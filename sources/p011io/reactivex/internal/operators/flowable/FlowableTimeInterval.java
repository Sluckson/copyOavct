package p011io.reactivex.internal.operators.flowable;

import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p011io.reactivex.Flowable;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.Scheduler;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;
import p011io.reactivex.schedulers.Timed;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableTimeInterval */
public final class FlowableTimeInterval<T> extends AbstractFlowableWithUpstream<T, Timed<T>> {
    final Scheduler scheduler;
    final TimeUnit unit;

    public FlowableTimeInterval(Flowable<T> flowable, TimeUnit timeUnit, Scheduler scheduler2) {
        super(flowable);
        this.scheduler = scheduler2;
        this.unit = timeUnit;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super Timed<T>> subscriber) {
        this.source.subscribe(new TimeIntervalSubscriber(subscriber, this.unit, this.scheduler));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableTimeInterval$TimeIntervalSubscriber */
    static final class TimeIntervalSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super Timed<T>> actual;
        long lastTime;

        /* renamed from: s */
        Subscription f5144s;
        final Scheduler scheduler;
        final TimeUnit unit;

        TimeIntervalSubscriber(Subscriber<? super Timed<T>> subscriber, TimeUnit timeUnit, Scheduler scheduler2) {
            this.actual = subscriber;
            this.scheduler = scheduler2;
            this.unit = timeUnit;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f5144s, subscription)) {
                this.lastTime = this.scheduler.now(this.unit);
                this.f5144s = subscription;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            long now = this.scheduler.now(this.unit);
            long j = this.lastTime;
            this.lastTime = now;
            this.actual.onNext(new Timed(t, now - j, this.unit));
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }

        public void request(long j) {
            this.f5144s.request(j);
        }

        public void cancel() {
            this.f5144s.cancel();
        }
    }
}
