package p011io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p011io.reactivex.Flowable;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;
import p011io.reactivex.internal.util.EmptyComponent;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableDetach */
public final class FlowableDetach<T> extends AbstractFlowableWithUpstream<T, T> {
    public FlowableDetach(Flowable<T> flowable) {
        super(flowable);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new DetachSubscriber(subscriber));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableDetach$DetachSubscriber */
    static final class DetachSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        Subscriber<? super T> actual;

        /* renamed from: s */
        Subscription f5072s;

        DetachSubscriber(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        public void request(long j) {
            this.f5072s.request(j);
        }

        public void cancel() {
            Subscription subscription = this.f5072s;
            this.f5072s = EmptyComponent.INSTANCE;
            this.actual = EmptyComponent.asSubscriber();
            subscription.cancel();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f5072s, subscription)) {
                this.f5072s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.actual.onNext(t);
        }

        public void onError(Throwable th) {
            Subscriber<? super T> subscriber = this.actual;
            this.f5072s = EmptyComponent.INSTANCE;
            this.actual = EmptyComponent.asSubscriber();
            subscriber.onError(th);
        }

        public void onComplete() {
            Subscriber<? super T> subscriber = this.actual;
            this.f5072s = EmptyComponent.INSTANCE;
            this.actual = EmptyComponent.asSubscriber();
            subscriber.onComplete();
        }
    }
}
