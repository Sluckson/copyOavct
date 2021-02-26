package p011io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p011io.reactivex.Flowable;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.BiFunction;
import p011io.reactivex.internal.functions.ObjectHelper;
import p011io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableReduce */
public final class FlowableReduce<T> extends AbstractFlowableWithUpstream<T, T> {
    final BiFunction<T, T, T> reducer;

    public FlowableReduce(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.reducer = biFunction;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new ReduceSubscriber(subscriber, this.reducer));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableReduce$ReduceSubscriber */
    static final class ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4663883003264602070L;
        final BiFunction<T, T, T> reducer;

        /* renamed from: s */
        Subscription f5107s;

        ReduceSubscriber(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
            super(subscriber);
            this.reducer = biFunction;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f5107s, subscription)) {
                this.f5107s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (this.f5107s != SubscriptionHelper.CANCELLED) {
                Object obj = this.value;
                if (obj == null) {
                    this.value = t;
                    return;
                }
                try {
                    this.value = ObjectHelper.requireNonNull(this.reducer.apply(obj, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f5107s.cancel();
                    onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.f5107s == SubscriptionHelper.CANCELLED) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.f5107s = SubscriptionHelper.CANCELLED;
            this.actual.onError(th);
        }

        public void onComplete() {
            if (this.f5107s != SubscriptionHelper.CANCELLED) {
                this.f5107s = SubscriptionHelper.CANCELLED;
                Object obj = this.value;
                if (obj != null) {
                    complete(obj);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        public void cancel() {
            super.cancel();
            this.f5107s.cancel();
            this.f5107s = SubscriptionHelper.CANCELLED;
        }
    }
}
