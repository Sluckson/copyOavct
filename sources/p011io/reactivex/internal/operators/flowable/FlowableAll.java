package p011io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p011io.reactivex.Flowable;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.Predicate;
import p011io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableAll */
public final class FlowableAll<T> extends AbstractFlowableWithUpstream<T, Boolean> {
    final Predicate<? super T> predicate;

    public FlowableAll(Flowable<T> flowable, Predicate<? super T> predicate2) {
        super(flowable);
        this.predicate = predicate2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super Boolean> subscriber) {
        this.source.subscribe(new AllSubscriber(subscriber, this.predicate));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableAll$AllSubscriber */
    static final class AllSubscriber<T> extends DeferredScalarSubscription<Boolean> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3521127104134758517L;
        boolean done;
        final Predicate<? super T> predicate;

        /* renamed from: s */
        Subscription f5042s;

        AllSubscriber(Subscriber<? super Boolean> subscriber, Predicate<? super T> predicate2) {
            super(subscriber);
            this.predicate = predicate2;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f5042s, subscription)) {
                this.f5042s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    if (!this.predicate.test(t)) {
                        this.done = true;
                        this.f5042s.cancel();
                        complete(false);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f5042s.cancel();
                    onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                complete(true);
            }
        }

        public void cancel() {
            super.cancel();
            this.f5042s.cancel();
        }
    }
}
