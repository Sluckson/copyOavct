package p011io.reactivex.internal.operators.completable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;
import p011io.reactivex.Completable;
import p011io.reactivex.CompletableObserver;
import p011io.reactivex.CompletableSource;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.disposables.CompositeDisposable;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;
import p011io.reactivex.internal.util.AtomicThrowable;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.completable.CompletableMerge */
public final class CompletableMerge extends Completable {
    final boolean delayErrors;
    final int maxConcurrency;
    final Publisher<? extends CompletableSource> source;

    public CompletableMerge(Publisher<? extends CompletableSource> publisher, int i, boolean z) {
        this.source = publisher;
        this.maxConcurrency = i;
        this.delayErrors = z;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new CompletableMergeSubscriber(completableObserver, this.maxConcurrency, this.delayErrors));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableMerge$CompletableMergeSubscriber */
    static final class CompletableMergeSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        private static final long serialVersionUID = -2108443387387077490L;
        final CompletableObserver actual;
        final boolean delayErrors;
        final AtomicThrowable error = new AtomicThrowable();
        final int maxConcurrency;

        /* renamed from: s */
        Subscription f5034s;
        final CompositeDisposable set = new CompositeDisposable();

        CompletableMergeSubscriber(CompletableObserver completableObserver, int i, boolean z) {
            this.actual = completableObserver;
            this.maxConcurrency = i;
            this.delayErrors = z;
            lazySet(1);
        }

        public void dispose() {
            this.f5034s.cancel();
            this.set.dispose();
        }

        public boolean isDisposed() {
            return this.set.isDisposed();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f5034s, subscription)) {
                this.f5034s = subscription;
                this.actual.onSubscribe(this);
                int i = this.maxConcurrency;
                if (i == Integer.MAX_VALUE) {
                    subscription.request(Long.MAX_VALUE);
                } else {
                    subscription.request((long) i);
                }
            }
        }

        public void onNext(CompletableSource completableSource) {
            getAndIncrement();
            MergeInnerObserver mergeInnerObserver = new MergeInnerObserver();
            this.set.add(mergeInnerObserver);
            completableSource.subscribe(mergeInnerObserver);
        }

        public void onError(Throwable th) {
            if (!this.delayErrors) {
                this.set.dispose();
                if (!this.error.addThrowable(th)) {
                    RxJavaPlugins.onError(th);
                } else if (getAndSet(0) > 0) {
                    this.actual.onError(this.error.terminate());
                }
            } else if (!this.error.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (decrementAndGet() == 0) {
                this.actual.onError(this.error.terminate());
            }
        }

        public void onComplete() {
            if (decrementAndGet() != 0) {
                return;
            }
            if (((Throwable) this.error.get()) != null) {
                this.actual.onError(this.error.terminate());
            } else {
                this.actual.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void innerError(MergeInnerObserver mergeInnerObserver, Throwable th) {
            this.set.delete(mergeInnerObserver);
            if (!this.delayErrors) {
                this.f5034s.cancel();
                this.set.dispose();
                if (!this.error.addThrowable(th)) {
                    RxJavaPlugins.onError(th);
                } else if (getAndSet(0) > 0) {
                    this.actual.onError(this.error.terminate());
                }
            } else if (!this.error.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (decrementAndGet() == 0) {
                this.actual.onError(this.error.terminate());
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.f5034s.request(1);
            }
        }

        /* access modifiers changed from: package-private */
        public void innerComplete(MergeInnerObserver mergeInnerObserver) {
            this.set.delete(mergeInnerObserver);
            if (decrementAndGet() == 0) {
                Throwable th = (Throwable) this.error.get();
                if (th != null) {
                    this.actual.onError(th);
                } else {
                    this.actual.onComplete();
                }
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.f5034s.request(1);
            }
        }

        /* renamed from: io.reactivex.internal.operators.completable.CompletableMerge$CompletableMergeSubscriber$MergeInnerObserver */
        final class MergeInnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 251330541679988317L;

            MergeInnerObserver() {
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onError(Throwable th) {
                CompletableMergeSubscriber.this.innerError(this, th);
            }

            public void onComplete() {
                CompletableMergeSubscriber.this.innerComplete(this);
            }

            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
