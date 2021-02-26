package p011io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.Scheduler;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.schedulers.Timed;

/* renamed from: io.reactivex.internal.operators.observable.ObservableTimeInterval */
public final class ObservableTimeInterval<T> extends AbstractObservableWithUpstream<T, Timed<T>> {
    final Scheduler scheduler;
    final TimeUnit unit;

    public ObservableTimeInterval(ObservableSource<T> observableSource, TimeUnit timeUnit, Scheduler scheduler2) {
        super(observableSource);
        this.scheduler = scheduler2;
        this.unit = timeUnit;
    }

    public void subscribeActual(Observer<? super Timed<T>> observer) {
        this.source.subscribe(new TimeIntervalObserver(observer, this.unit, this.scheduler));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableTimeInterval$TimeIntervalObserver */
    static final class TimeIntervalObserver<T> implements Observer<T>, Disposable {
        final Observer<? super Timed<T>> actual;
        long lastTime;

        /* renamed from: s */
        Disposable f5289s;
        final Scheduler scheduler;
        final TimeUnit unit;

        TimeIntervalObserver(Observer<? super Timed<T>> observer, TimeUnit timeUnit, Scheduler scheduler2) {
            this.actual = observer;
            this.scheduler = scheduler2;
            this.unit = timeUnit;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5289s, disposable)) {
                this.f5289s = disposable;
                this.lastTime = this.scheduler.now(this.unit);
                this.actual.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f5289s.dispose();
        }

        public boolean isDisposed() {
            return this.f5289s.isDisposed();
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
    }
}
