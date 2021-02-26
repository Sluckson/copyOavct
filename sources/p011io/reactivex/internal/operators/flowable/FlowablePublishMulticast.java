package p011io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p011io.reactivex.Flowable;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.exceptions.MissingBackpressureException;
import p011io.reactivex.functions.Function;
import p011io.reactivex.internal.functions.ObjectHelper;
import p011io.reactivex.internal.fuseable.QueueSubscription;
import p011io.reactivex.internal.fuseable.SimpleQueue;
import p011io.reactivex.internal.subscriptions.EmptySubscription;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;
import p011io.reactivex.internal.util.BackpressureHelper;
import p011io.reactivex.internal.util.QueueDrainHelper;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowablePublishMulticast */
public final class FlowablePublishMulticast<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final boolean delayError;
    final int prefetch;
    final Function<? super Flowable<T>, ? extends Publisher<? extends R>> selector;

    public FlowablePublishMulticast(Flowable<T> flowable, Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i, boolean z) {
        super(flowable);
        this.selector = function;
        this.prefetch = i;
        this.delayError = z;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super R> subscriber) {
        MulticastProcessor multicastProcessor = new MulticastProcessor(this.prefetch, this.delayError);
        try {
            ((Publisher) ObjectHelper.requireNonNull(this.selector.apply(multicastProcessor), "selector returned a null Publisher")).subscribe(new OutputCanceller(subscriber, multicastProcessor));
            this.source.subscribe(multicastProcessor);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowablePublishMulticast$OutputCanceller */
    static final class OutputCanceller<R> implements FlowableSubscriber<R>, Subscription {
        final Subscriber<? super R> actual;
        final MulticastProcessor<?> processor;

        /* renamed from: s */
        Subscription f5106s;

        OutputCanceller(Subscriber<? super R> subscriber, MulticastProcessor<?> multicastProcessor) {
            this.actual = subscriber;
            this.processor = multicastProcessor;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f5106s, subscription)) {
                this.f5106s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(R r) {
            this.actual.onNext(r);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
            this.processor.dispose();
        }

        public void onComplete() {
            this.actual.onComplete();
            this.processor.dispose();
        }

        public void request(long j) {
            this.f5106s.request(j);
        }

        public void cancel() {
            this.f5106s.cancel();
            this.processor.dispose();
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastProcessor */
    static final class MulticastProcessor<T> extends Flowable<T> implements FlowableSubscriber<T>, Disposable {
        static final MulticastSubscription[] EMPTY = new MulticastSubscription[0];
        static final MulticastSubscription[] TERMINATED = new MulticastSubscription[0];
        int consumed;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        volatile SimpleQueue<T> queue;

        /* renamed from: s */
        final AtomicReference<Subscription> f5105s = new AtomicReference<>();
        int sourceMode;
        final AtomicReference<MulticastSubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicInteger wip = new AtomicInteger();

        MulticastProcessor(int i, boolean z) {
            this.prefetch = i;
            this.limit = i - (i >> 2);
            this.delayError = z;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f5105s, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueSubscription;
                        QueueDrainHelper.request(subscription, this.prefetch);
                        return;
                    }
                }
                this.queue = QueueDrainHelper.createQueue(this.prefetch);
                QueueDrainHelper.request(subscription, this.prefetch);
            }
        }

        public void dispose() {
            SimpleQueue<T> simpleQueue;
            SubscriptionHelper.cancel(this.f5105s);
            if (this.wip.getAndIncrement() == 0 && (simpleQueue = this.queue) != null) {
                simpleQueue.clear();
            }
        }

        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled(this.f5105s.get());
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0 || this.queue.offer(t)) {
                    drain();
                    return;
                }
                this.f5105s.get().cancel();
                onError(new MissingBackpressureException());
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean add(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = (MulticastSubscription[]) this.subscribers.get();
                if (multicastSubscriptionArr == TERMINATED) {
                    return false;
                }
                int length = multicastSubscriptionArr.length;
                multicastSubscriptionArr2 = new MulticastSubscription[(length + 1)];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
                multicastSubscriptionArr2[length] = multicastSubscription;
            } while (!this.subscribers.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public void remove(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = (MulticastSubscription[]) this.subscribers.get();
                int length = multicastSubscriptionArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (multicastSubscriptionArr[i2] == multicastSubscription) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            multicastSubscriptionArr2 = EMPTY;
                        } else {
                            MulticastSubscription[] multicastSubscriptionArr3 = new MulticastSubscription[(length - 1)];
                            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr3, 0, i);
                            System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr3, i, (length - i) - 1);
                            multicastSubscriptionArr2 = multicastSubscriptionArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
        }

        /* access modifiers changed from: protected */
        public void subscribeActual(Subscriber<? super T> subscriber) {
            MulticastSubscription multicastSubscription = new MulticastSubscription(subscriber, this);
            subscriber.onSubscribe(multicastSubscription);
            if (!add(multicastSubscription)) {
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
            } else if (multicastSubscription.isCancelled()) {
                remove(multicastSubscription);
            } else {
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x00fa, code lost:
            if (r7 != 0) goto L_0x012c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0100, code lost:
            if (isDisposed() == false) goto L_0x0106;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0102, code lost:
            r0.clear();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0105, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0106, code lost:
            r5 = r1.done;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0108, code lost:
            if (r5 == false) goto L_0x0116;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x010c, code lost:
            if (r1.delayError != false) goto L_0x0116;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x010e, code lost:
            r6 = r1.error;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x0110, code lost:
            if (r6 == null) goto L_0x0116;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x0112, code lost:
            errorAll(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x0115, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x0116, code lost:
            if (r5 == false) goto L_0x012c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x011c, code lost:
            if (r0.isEmpty() == false) goto L_0x012c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x011e, code lost:
            r0 = r1.error;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x0120, code lost:
            if (r0 == null) goto L_0x0126;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0122, code lost:
            errorAll(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x0126, code lost:
            completeAll();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain() {
            /*
                r24 = this;
                r1 = r24
                java.util.concurrent.atomic.AtomicInteger r0 = r1.wip
                int r0 = r0.getAndIncrement()
                if (r0 == 0) goto L_0x000b
                return
            L_0x000b:
                io.reactivex.internal.fuseable.SimpleQueue<T> r0 = r1.queue
                int r2 = r1.consumed
                int r3 = r1.limit
                int r4 = r1.sourceMode
                r6 = 1
                if (r4 == r6) goto L_0x0018
                r4 = 1
                goto L_0x0019
            L_0x0018:
                r4 = 0
            L_0x0019:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription<T>[]> r7 = r1.subscribers
                java.lang.Object r8 = r7.get()
                io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r8 = (p011io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r8
                r9 = r2
                r2 = 1
            L_0x0023:
                int r10 = r8.length
                if (r0 == 0) goto L_0x012a
                if (r10 == 0) goto L_0x012a
                int r11 = r8.length
                r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r14 = r10
                r15 = r12
                r10 = 0
            L_0x0031:
                r17 = -9223372036854775808
                if (r10 >= r11) goto L_0x0054
                r5 = r8[r10]
                long r19 = r5.get()
                r21 = r7
                long r6 = r5.emitted
                long r19 = r19 - r6
                int r5 = (r19 > r17 ? 1 : (r19 == r17 ? 0 : -1))
                if (r5 == 0) goto L_0x004c
                int r5 = (r15 > r19 ? 1 : (r15 == r19 ? 0 : -1))
                if (r5 <= 0) goto L_0x004e
                r15 = r19
                goto L_0x004e
            L_0x004c:
                int r14 = r14 + -1
            L_0x004e:
                int r10 = r10 + 1
                r7 = r21
                r6 = 1
                goto L_0x0031
            L_0x0054:
                r21 = r7
                r5 = 0
                if (r14 != 0) goto L_0x005b
                r15 = r5
            L_0x005b:
                int r7 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
                if (r7 == 0) goto L_0x00fa
                boolean r10 = r24.isDisposed()
                if (r10 == 0) goto L_0x0069
                r0.clear()
                return
            L_0x0069:
                boolean r10 = r1.done
                if (r10 == 0) goto L_0x0079
                boolean r11 = r1.delayError
                if (r11 != 0) goto L_0x0079
                java.lang.Throwable r11 = r1.error
                if (r11 == 0) goto L_0x0079
                r1.errorAll(r11)
                return
            L_0x0079:
                java.lang.Object r11 = r0.poll()     // Catch:{ Throwable -> 0x00ec }
                if (r11 != 0) goto L_0x0081
                r14 = 1
                goto L_0x0082
            L_0x0081:
                r14 = 0
            L_0x0082:
                if (r10 == 0) goto L_0x0092
                if (r14 == 0) goto L_0x0092
                java.lang.Throwable r0 = r1.error
                if (r0 == 0) goto L_0x008e
                r1.errorAll(r0)
                goto L_0x0091
            L_0x008e:
                r24.completeAll()
            L_0x0091:
                return
            L_0x0092:
                if (r14 == 0) goto L_0x0095
                goto L_0x00fa
            L_0x0095:
                int r7 = r8.length
                r10 = 0
                r14 = 0
            L_0x0098:
                r19 = 1
                if (r10 >= r7) goto L_0x00c1
                r5 = r8[r10]
                long r22 = r5.get()
                int r6 = (r22 > r17 ? 1 : (r22 == r17 ? 0 : -1))
                if (r6 == 0) goto L_0x00b6
                int r6 = (r22 > r12 ? 1 : (r22 == r12 ? 0 : -1))
                if (r6 == 0) goto L_0x00b0
                long r12 = r5.emitted
                long r12 = r12 + r19
                r5.emitted = r12
            L_0x00b0:
                org.reactivestreams.Subscriber<? super T> r5 = r5.actual
                r5.onNext(r11)
                goto L_0x00b7
            L_0x00b6:
                r14 = 1
            L_0x00b7:
                int r10 = r10 + 1
                r5 = 0
                r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                goto L_0x0098
            L_0x00c1:
                long r15 = r15 - r19
                if (r4 == 0) goto L_0x00d6
                int r9 = r9 + 1
                if (r9 != r3) goto L_0x00d6
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r5 = r1.f5105s
                java.lang.Object r5 = r5.get()
                org.reactivestreams.Subscription r5 = (org.reactivestreams.Subscription) r5
                long r6 = (long) r3
                r5.request(r6)
                r9 = 0
            L_0x00d6:
                java.lang.Object r5 = r21.get()
                io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r5 = (p011io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r5
                if (r14 != 0) goto L_0x00ea
                if (r5 == r8) goto L_0x00e1
                goto L_0x00ea
            L_0x00e1:
                r5 = 0
                r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                goto L_0x005b
            L_0x00ea:
                r8 = r5
                goto L_0x0143
            L_0x00ec:
                r0 = move-exception
                r2 = r0
                p011io.reactivex.exceptions.Exceptions.throwIfFatal(r2)
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r0 = r1.f5105s
                p011io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(r0)
                r1.errorAll(r2)
                return
            L_0x00fa:
                if (r7 != 0) goto L_0x012c
                boolean r5 = r24.isDisposed()
                if (r5 == 0) goto L_0x0106
                r0.clear()
                return
            L_0x0106:
                boolean r5 = r1.done
                if (r5 == 0) goto L_0x0116
                boolean r6 = r1.delayError
                if (r6 != 0) goto L_0x0116
                java.lang.Throwable r6 = r1.error
                if (r6 == 0) goto L_0x0116
                r1.errorAll(r6)
                return
            L_0x0116:
                if (r5 == 0) goto L_0x012c
                boolean r5 = r0.isEmpty()
                if (r5 == 0) goto L_0x012c
                java.lang.Throwable r0 = r1.error
                if (r0 == 0) goto L_0x0126
                r1.errorAll(r0)
                goto L_0x0129
            L_0x0126:
                r24.completeAll()
            L_0x0129:
                return
            L_0x012a:
                r21 = r7
            L_0x012c:
                r1.consumed = r9
                java.util.concurrent.atomic.AtomicInteger r5 = r1.wip
                int r2 = -r2
                int r2 = r5.addAndGet(r2)
                if (r2 != 0) goto L_0x0138
                return
            L_0x0138:
                if (r0 != 0) goto L_0x013c
                io.reactivex.internal.fuseable.SimpleQueue<T> r0 = r1.queue
            L_0x013c:
                java.lang.Object r5 = r21.get()
                r8 = r5
                io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r8 = (p011io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r8
            L_0x0143:
                r7 = r21
                r6 = 1
                goto L_0x0023
            */
            throw new UnsupportedOperationException("Method not decompiled: p011io.reactivex.internal.operators.flowable.FlowablePublishMulticast.MulticastProcessor.drain():void");
        }

        /* access modifiers changed from: package-private */
        public void errorAll(Throwable th) {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.actual.onError(th);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void completeAll() {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.actual.onComplete();
                }
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription */
    static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 8664815189257569791L;
        final Subscriber<? super T> actual;
        long emitted;
        final MulticastProcessor<T> parent;

        MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.actual = subscriber;
            this.parent = multicastProcessor;
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
                this.parent.drain();
            }
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.drain();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }
    }
}
