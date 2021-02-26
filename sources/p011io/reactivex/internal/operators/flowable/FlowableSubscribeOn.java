package p011io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p011io.reactivex.Flowable;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.Scheduler;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;
import p011io.reactivex.internal.util.BackpressureHelper;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableSubscribeOn */
public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final boolean nonScheduledRequests;
    final Scheduler scheduler;

    public FlowableSubscribeOn(Flowable<T> flowable, Scheduler scheduler2, boolean z) {
        super(flowable);
        this.scheduler = scheduler2;
        this.nonScheduledRequests = z;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(subscriber, createWorker, this.source, this.nonScheduledRequests);
        subscriber.onSubscribe(subscribeOnSubscriber);
        createWorker.schedule(subscribeOnSubscriber);
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableSubscribeOn$SubscribeOnSubscriber */
    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;
        final Subscriber<? super T> actual;
        final boolean nonScheduledRequests;
        final AtomicLong requested = new AtomicLong();

        /* renamed from: s */
        final AtomicReference<Subscription> f5133s = new AtomicReference<>();
        Publisher<T> source;
        final Scheduler.Worker worker;

        SubscribeOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker2, Publisher<T> publisher, boolean z) {
            this.actual = subscriber;
            this.worker = worker2;
            this.source = publisher;
            this.nonScheduledRequests = !z;
        }

        public void run() {
            lazySet(Thread.currentThread());
            Publisher<T> publisher = this.source;
            this.source = null;
            publisher.subscribe(this);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f5133s, subscription)) {
                long andSet = this.requested.getAndSet(0);
                if (andSet != 0) {
                    requestUpstream(andSet, subscription);
                }
            }
        }

        public void onNext(T t) {
            this.actual.onNext(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
            this.worker.dispose();
        }

        public void onComplete() {
            this.actual.onComplete();
            this.worker.dispose();
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                Subscription subscription = this.f5133s.get();
                if (subscription != null) {
                    requestUpstream(j, subscription);
                    return;
                }
                BackpressureHelper.add(this.requested, j);
                Subscription subscription2 = this.f5133s.get();
                if (subscription2 != null) {
                    long andSet = this.requested.getAndSet(0);
                    if (andSet != 0) {
                        requestUpstream(andSet, subscription2);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void requestUpstream(long j, Subscription subscription) {
            if (this.nonScheduledRequests || Thread.currentThread() == get()) {
                subscription.request(j);
            } else {
                this.worker.schedule(new Request(subscription, j));
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f5133s);
            this.worker.dispose();
        }

        /* renamed from: io.reactivex.internal.operators.flowable.FlowableSubscribeOn$SubscribeOnSubscriber$Request */
        static final class Request implements Runnable {

            /* renamed from: n */
            private final long f5134n;

            /* renamed from: s */
            private final Subscription f5135s;

            Request(Subscription subscription, long j) {
                this.f5135s = subscription;
                this.f5134n = j;
            }

            public void run() {
                this.f5135s.request(this.f5134n);
            }
        }
    }
}
