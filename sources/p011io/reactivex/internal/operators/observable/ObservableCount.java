package p011io.reactivex.internal.operators.observable;

import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.observable.ObservableCount */
public final class ObservableCount<T> extends AbstractObservableWithUpstream<T, Long> {
    public ObservableCount(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super Long> observer) {
        this.source.subscribe(new CountObserver(observer));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableCount$CountObserver */
    static final class CountObserver implements Observer<Object>, Disposable {
        final Observer<? super Long> actual;
        long count;

        /* renamed from: s */
        Disposable f5217s;

        CountObserver(Observer<? super Long> observer) {
            this.actual = observer;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5217s, disposable)) {
                this.f5217s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f5217s.dispose();
        }

        public boolean isDisposed() {
            return this.f5217s.isDisposed();
        }

        public void onNext(Object obj) {
            this.count++;
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onNext(Long.valueOf(this.count));
            this.actual.onComplete();
        }
    }
}
