package p011io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p011io.reactivex.Flowable;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.internal.subscriptions.SubscriptionArbiter;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableRepeat */
public final class FlowableRepeat<T> extends AbstractFlowableWithUpstream<T, T> {
    final long count;

    public FlowableRepeat(Flowable<T> flowable, long j) {
        super(flowable);
        this.count = j;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
        subscriber.onSubscribe(subscriptionArbiter);
        long j = this.count;
        long j2 = Long.MAX_VALUE;
        if (j != Long.MAX_VALUE) {
            j2 = j - 1;
        }
        new RepeatSubscriber(subscriber, j2, subscriptionArbiter, this.source).subscribeNext();
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableRepeat$RepeatSubscriber */
    static final class RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final Subscriber<? super T> actual;
        long produced;
        long remaining;

        /* renamed from: sa */
        final SubscriptionArbiter f5111sa;
        final Publisher<? extends T> source;

        RepeatSubscriber(Subscriber<? super T> subscriber, long j, SubscriptionArbiter subscriptionArbiter, Publisher<? extends T> publisher) {
            this.actual = subscriber;
            this.f5111sa = subscriptionArbiter;
            this.source = publisher;
            this.remaining = j;
        }

        public void onSubscribe(Subscription subscription) {
            this.f5111sa.setSubscription(subscription);
        }

        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            long j = this.remaining;
            if (j != Long.MAX_VALUE) {
                this.remaining = j - 1;
            }
            if (j != 0) {
                subscribeNext();
            } else {
                this.actual.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.f5111sa.isCancelled()) {
                    long j = this.produced;
                    if (j != 0) {
                        this.produced = 0;
                        this.f5111sa.produced(j);
                    }
                    this.source.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }
}
