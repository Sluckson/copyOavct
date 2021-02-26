package p011io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscription;
import p011io.reactivex.Flowable;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.Single;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.fuseable.FuseToFlowable;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableCountSingle */
public final class FlowableCountSingle<T> extends Single<Long> implements FuseToFlowable<Long> {
    final Flowable<T> source;

    public FlowableCountSingle(Flowable<T> flowable) {
        this.source = flowable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.source.subscribe(new CountSubscriber(singleObserver));
    }

    public Flowable<Long> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableCount(this.source));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableCountSingle$CountSubscriber */
    static final class CountSubscriber implements FlowableSubscriber<Object>, Disposable {
        final SingleObserver<? super Long> actual;
        long count;

        /* renamed from: s */
        Subscription f5063s;

        CountSubscriber(SingleObserver<? super Long> singleObserver) {
            this.actual = singleObserver;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f5063s, subscription)) {
                this.f5063s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onNext(Object obj) {
            this.count++;
        }

        public void onError(Throwable th) {
            this.f5063s = SubscriptionHelper.CANCELLED;
            this.actual.onError(th);
        }

        public void onComplete() {
            this.f5063s = SubscriptionHelper.CANCELLED;
            this.actual.onSuccess(Long.valueOf(this.count));
        }

        public void dispose() {
            this.f5063s.cancel();
            this.f5063s = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f5063s == SubscriptionHelper.CANCELLED;
        }
    }
}
