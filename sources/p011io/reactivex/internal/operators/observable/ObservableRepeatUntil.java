package p011io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;
import p011io.reactivex.Observable;
import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.BooleanSupplier;
import p011io.reactivex.internal.disposables.SequentialDisposable;

/* renamed from: io.reactivex.internal.operators.observable.ObservableRepeatUntil */
public final class ObservableRepeatUntil<T> extends AbstractObservableWithUpstream<T, T> {
    final BooleanSupplier until;

    public ObservableRepeatUntil(Observable<T> observable, BooleanSupplier booleanSupplier) {
        super(observable);
        this.until = booleanSupplier;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RepeatUntilObserver(observer, this.until, sequentialDisposable, this.source).subscribeNext();
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableRepeatUntil$RepeatUntilObserver */
    static final class RepeatUntilObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final Observer<? super T> actual;

        /* renamed from: sd */
        final SequentialDisposable f5258sd;
        final ObservableSource<? extends T> source;
        final BooleanSupplier stop;

        RepeatUntilObserver(Observer<? super T> observer, BooleanSupplier booleanSupplier, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.actual = observer;
            this.f5258sd = sequentialDisposable;
            this.source = observableSource;
            this.stop = booleanSupplier;
        }

        public void onSubscribe(Disposable disposable) {
            this.f5258sd.replace(disposable);
        }

        public void onNext(T t) {
            this.actual.onNext(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            try {
                if (this.stop.getAsBoolean()) {
                    this.actual.onComplete();
                } else {
                    subscribeNext();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.actual.onError(th);
            }
        }

        /* access modifiers changed from: package-private */
        public void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i = 1;
                do {
                    this.source.subscribe(this);
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }
    }
}
