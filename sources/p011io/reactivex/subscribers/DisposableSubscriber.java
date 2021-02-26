package p011io.reactivex.subscribers;

import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;
import p011io.reactivex.internal.util.EndConsumerHelper;

/* renamed from: io.reactivex.subscribers.DisposableSubscriber */
public abstract class DisposableSubscriber<T> implements FlowableSubscriber<T>, Disposable {

    /* renamed from: s */
    final AtomicReference<Subscription> f5395s = new AtomicReference<>();

    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.setOnce(this.f5395s, subscription, getClass())) {
            onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.f5395s.get().request(Long.MAX_VALUE);
    }

    /* access modifiers changed from: protected */
    public final void request(long j) {
        this.f5395s.get().request(j);
    }

    /* access modifiers changed from: protected */
    public final void cancel() {
        dispose();
    }

    public final boolean isDisposed() {
        return this.f5395s.get() == SubscriptionHelper.CANCELLED;
    }

    public final void dispose() {
        SubscriptionHelper.cancel(this.f5395s);
    }
}
