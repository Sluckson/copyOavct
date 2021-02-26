package p011io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscription;
import p011io.reactivex.Completable;
import p011io.reactivex.CompletableObserver;
import p011io.reactivex.Flowable;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.fuseable.FuseToFlowable;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableIgnoreElementsCompletable */
public final class FlowableIgnoreElementsCompletable<T> extends Completable implements FuseToFlowable<T> {
    final Flowable<T> source;

    public FlowableIgnoreElementsCompletable(Flowable<T> flowable) {
        this.source = flowable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new IgnoreElementsSubscriber(completableObserver));
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableIgnoreElements(this.source));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableIgnoreElementsCompletable$IgnoreElementsSubscriber */
    static final class IgnoreElementsSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final CompletableObserver actual;

        /* renamed from: s */
        Subscription f5093s;

        public void onNext(T t) {
        }

        IgnoreElementsSubscriber(CompletableObserver completableObserver) {
            this.actual = completableObserver;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f5093s, subscription)) {
                this.f5093s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onError(Throwable th) {
            this.f5093s = SubscriptionHelper.CANCELLED;
            this.actual.onError(th);
        }

        public void onComplete() {
            this.f5093s = SubscriptionHelper.CANCELLED;
            this.actual.onComplete();
        }

        public void dispose() {
            this.f5093s.cancel();
            this.f5093s = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f5093s == SubscriptionHelper.CANCELLED;
        }
    }
}
