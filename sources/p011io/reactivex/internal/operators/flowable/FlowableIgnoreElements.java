package p011io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p011io.reactivex.Flowable;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.annotations.Nullable;
import p011io.reactivex.internal.fuseable.QueueSubscription;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableIgnoreElements */
public final class FlowableIgnoreElements<T> extends AbstractFlowableWithUpstream<T, T> {
    public FlowableIgnoreElements(Flowable<T> flowable) {
        super(flowable);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new IgnoreElementsSubscriber(subscriber));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableIgnoreElements$IgnoreElementsSubscriber */
    static final class IgnoreElementsSubscriber<T> implements FlowableSubscriber<T>, QueueSubscription<T> {
        final Subscriber<? super T> actual;

        /* renamed from: s */
        Subscription f5092s;

        public void clear() {
        }

        public boolean isEmpty() {
            return true;
        }

        public void onNext(T t) {
        }

        @Nullable
        public T poll() {
            return null;
        }

        public void request(long j) {
        }

        public int requestFusion(int i) {
            return i & 2;
        }

        IgnoreElementsSubscriber(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f5092s, subscription)) {
                this.f5092s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }

        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public void cancel() {
            this.f5092s.cancel();
        }
    }
}
