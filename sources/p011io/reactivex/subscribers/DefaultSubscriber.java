package p011io.reactivex.subscribers;

import org.reactivestreams.Subscription;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;
import p011io.reactivex.internal.util.EndConsumerHelper;

/* renamed from: io.reactivex.subscribers.DefaultSubscriber */
public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {

    /* renamed from: s */
    private Subscription f5394s;

    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.validate(this.f5394s, subscription, getClass())) {
            this.f5394s = subscription;
            onStart();
        }
    }

    /* access modifiers changed from: protected */
    public final void request(long j) {
        Subscription subscription = this.f5394s;
        if (subscription != null) {
            subscription.request(j);
        }
    }

    /* access modifiers changed from: protected */
    public final void cancel() {
        Subscription subscription = this.f5394s;
        this.f5394s = SubscriptionHelper.CANCELLED;
        subscription.cancel();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        request(Long.MAX_VALUE);
    }
}
