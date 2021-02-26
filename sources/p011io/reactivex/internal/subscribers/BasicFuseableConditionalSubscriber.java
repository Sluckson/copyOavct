package p011io.reactivex.internal.subscribers;

import org.reactivestreams.Subscription;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.internal.fuseable.ConditionalSubscriber;
import p011io.reactivex.internal.fuseable.QueueSubscription;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber */
public abstract class BasicFuseableConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, QueueSubscription<R> {
    protected final ConditionalSubscriber<? super R> actual;
    protected boolean done;

    /* renamed from: qs */
    protected QueueSubscription<T> f5351qs;

    /* renamed from: s */
    protected Subscription f5352s;
    protected int sourceMode;

    /* access modifiers changed from: protected */
    public void afterDownstream() {
    }

    /* access modifiers changed from: protected */
    public boolean beforeDownstream() {
        return true;
    }

    public BasicFuseableConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber) {
        this.actual = conditionalSubscriber;
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f5352s, subscription)) {
            this.f5352s = subscription;
            if (subscription instanceof QueueSubscription) {
                this.f5351qs = (QueueSubscription) subscription;
            }
            if (beforeDownstream()) {
                this.actual.onSubscribe(this);
                afterDownstream();
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

    /* access modifiers changed from: protected */
    public final void fail(Throwable th) {
        Exceptions.throwIfFatal(th);
        this.f5352s.cancel();
        onError(th);
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.actual.onComplete();
        }
    }

    /* access modifiers changed from: protected */
    public final int transitiveBoundaryFusion(int i) {
        QueueSubscription<T> queueSubscription = this.f5351qs;
        if (queueSubscription == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = queueSubscription.requestFusion(i);
        if (requestFusion != 0) {
            this.sourceMode = requestFusion;
        }
        return requestFusion;
    }

    public void request(long j) {
        this.f5352s.request(j);
    }

    public void cancel() {
        this.f5352s.cancel();
    }

    public boolean isEmpty() {
        return this.f5351qs.isEmpty();
    }

    public void clear() {
        this.f5351qs.clear();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
