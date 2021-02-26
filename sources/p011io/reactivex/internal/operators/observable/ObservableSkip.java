package p011io.reactivex.internal.operators.observable;

import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.observable.ObservableSkip */
public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: n */
    final long f5274n;

    public ObservableSkip(ObservableSource<T> observableSource, long j) {
        super(observableSource);
        this.f5274n = j;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SkipObserver(observer, this.f5274n));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableSkip$SkipObserver */
    static final class SkipObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;

        /* renamed from: d */
        Disposable f5275d;
        long remaining;

        SkipObserver(Observer<? super T> observer, long j) {
            this.actual = observer;
            this.remaining = j;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5275d, disposable)) {
                this.f5275d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            long j = this.remaining;
            if (j != 0) {
                this.remaining = j - 1;
            } else {
                this.actual.onNext(t);
            }
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }

        public void dispose() {
            this.f5275d.dispose();
        }

        public boolean isDisposed() {
            return this.f5275d.isDisposed();
        }
    }
}
