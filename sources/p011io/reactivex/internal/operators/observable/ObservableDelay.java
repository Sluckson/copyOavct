package p011io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.Scheduler;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.observers.SerializedObserver;

/* renamed from: io.reactivex.internal.operators.observable.ObservableDelay */
public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    public ObservableDelay(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler2, boolean z) {
        super(observableSource);
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.delayError = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver;
        if (this.delayError) {
            serializedObserver = observer;
        } else {
            serializedObserver = new SerializedObserver(observer);
        }
        this.source.subscribe(new DelayObserver(serializedObserver, this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableDelay$DelayObserver */
    static final class DelayObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;
        final long delay;
        final boolean delayError;

        /* renamed from: s */
        Disposable f5221s;
        final TimeUnit unit;

        /* renamed from: w */
        final Scheduler.Worker f5222w;

        DelayObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.actual = observer;
            this.delay = j;
            this.unit = timeUnit;
            this.f5222w = worker;
            this.delayError = z;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5221s, disposable)) {
                this.f5221s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.f5222w.schedule(new OnNext(t), this.delay, this.unit);
        }

        public void onError(Throwable th) {
            this.f5222w.schedule(new OnError(th), this.delayError ? this.delay : 0, this.unit);
        }

        public void onComplete() {
            this.f5222w.schedule(new OnComplete(), this.delay, this.unit);
        }

        public void dispose() {
            this.f5221s.dispose();
            this.f5222w.dispose();
        }

        public boolean isDisposed() {
            return this.f5222w.isDisposed();
        }

        /* renamed from: io.reactivex.internal.operators.observable.ObservableDelay$DelayObserver$OnNext */
        final class OnNext implements Runnable {

            /* renamed from: t */
            private final T f5223t;

            OnNext(T t) {
                this.f5223t = t;
            }

            public void run() {
                DelayObserver.this.actual.onNext(this.f5223t);
            }
        }

        /* renamed from: io.reactivex.internal.operators.observable.ObservableDelay$DelayObserver$OnError */
        final class OnError implements Runnable {
            private final Throwable throwable;

            OnError(Throwable th) {
                this.throwable = th;
            }

            public void run() {
                try {
                    DelayObserver.this.actual.onError(this.throwable);
                } finally {
                    DelayObserver.this.f5222w.dispose();
                }
            }
        }

        /* renamed from: io.reactivex.internal.operators.observable.ObservableDelay$DelayObserver$OnComplete */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            public void run() {
                try {
                    DelayObserver.this.actual.onComplete();
                } finally {
                    DelayObserver.this.f5222w.dispose();
                }
            }
        }
    }
}
