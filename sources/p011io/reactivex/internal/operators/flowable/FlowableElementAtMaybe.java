package p011io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscription;
import p011io.reactivex.Flowable;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.Maybe;
import p011io.reactivex.MaybeObserver;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.fuseable.FuseToFlowable;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableElementAtMaybe */
public final class FlowableElementAtMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {
    final long index;
    final Flowable<T> source;

    public FlowableElementAtMaybe(Flowable<T> flowable, long j) {
        this.source = flowable;
        this.index = j;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new ElementAtSubscriber(maybeObserver, this.index));
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableElementAt(this.source, this.index, null, false));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableElementAtMaybe$ElementAtSubscriber */
    static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final MaybeObserver<? super T> actual;
        long count;
        boolean done;
        final long index;

        /* renamed from: s */
        Subscription f5079s;

        ElementAtSubscriber(MaybeObserver<? super T> maybeObserver, long j) {
            this.actual = maybeObserver;
            this.index = j;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f5079s, subscription)) {
                this.f5079s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                long j = this.count;
                if (j == this.index) {
                    this.done = true;
                    this.f5079s.cancel();
                    this.f5079s = SubscriptionHelper.CANCELLED;
                    this.actual.onSuccess(t);
                    return;
                }
                this.count = j + 1;
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.f5079s = SubscriptionHelper.CANCELLED;
            this.actual.onError(th);
        }

        public void onComplete() {
            this.f5079s = SubscriptionHelper.CANCELLED;
            if (!this.done) {
                this.done = true;
                this.actual.onComplete();
            }
        }

        public void dispose() {
            this.f5079s.cancel();
            this.f5079s = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f5079s == SubscriptionHelper.CANCELLED;
        }
    }
}
