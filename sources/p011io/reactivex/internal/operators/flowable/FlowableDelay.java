package p011io.reactivex.internal.operators.flowable;

import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p011io.reactivex.Flowable;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.Scheduler;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;
import p011io.reactivex.subscribers.SerializedSubscriber;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableDelay */
public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    public FlowableDelay(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler2, boolean z) {
        super(flowable);
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.delayError = z;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber;
        if (this.delayError) {
            serializedSubscriber = subscriber;
        } else {
            serializedSubscriber = new SerializedSubscriber(subscriber);
        }
        this.source.subscribe(new DelaySubscriber(serializedSubscriber, this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableDelay$DelaySubscriber */
    static final class DelaySubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> actual;
        final long delay;
        final boolean delayError;

        /* renamed from: s */
        Subscription f5066s;
        final TimeUnit unit;

        /* renamed from: w */
        final Scheduler.Worker f5067w;

        DelaySubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.actual = subscriber;
            this.delay = j;
            this.unit = timeUnit;
            this.f5067w = worker;
            this.delayError = z;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f5066s, subscription)) {
                this.f5066s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f5067w.schedule(new OnNext(t), this.delay, this.unit);
        }

        public void onError(Throwable th) {
            this.f5067w.schedule(new OnError(th), this.delayError ? this.delay : 0, this.unit);
        }

        public void onComplete() {
            this.f5067w.schedule(new OnComplete(), this.delay, this.unit);
        }

        public void request(long j) {
            this.f5066s.request(j);
        }

        public void cancel() {
            this.f5066s.cancel();
            this.f5067w.dispose();
        }

        /* renamed from: io.reactivex.internal.operators.flowable.FlowableDelay$DelaySubscriber$OnNext */
        final class OnNext implements Runnable {

            /* renamed from: t */
            private final T f5069t;

            OnNext(T t) {
                this.f5069t = t;
            }

            public void run() {
                DelaySubscriber.this.actual.onNext(this.f5069t);
            }
        }

        /* renamed from: io.reactivex.internal.operators.flowable.FlowableDelay$DelaySubscriber$OnError */
        final class OnError implements Runnable {

            /* renamed from: t */
            private final Throwable f5068t;

            OnError(Throwable th) {
                this.f5068t = th;
            }

            public void run() {
                try {
                    DelaySubscriber.this.actual.onError(this.f5068t);
                } finally {
                    DelaySubscriber.this.f5067w.dispose();
                }
            }
        }

        /* renamed from: io.reactivex.internal.operators.flowable.FlowableDelay$DelaySubscriber$OnComplete */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            public void run() {
                try {
                    DelaySubscriber.this.actual.onComplete();
                } finally {
                    DelaySubscriber.this.f5067w.dispose();
                }
            }
        }
    }
}
