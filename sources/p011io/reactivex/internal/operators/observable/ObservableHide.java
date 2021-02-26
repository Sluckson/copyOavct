package p011io.reactivex.internal.operators.observable;

import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.observable.ObservableHide */
public final class ObservableHide<T> extends AbstractObservableWithUpstream<T, T> {
    public ObservableHide(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new HideDisposable(observer));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableHide$HideDisposable */
    static final class HideDisposable<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;

        /* renamed from: d */
        Disposable f5242d;

        HideDisposable(Observer<? super T> observer) {
            this.actual = observer;
        }

        public void dispose() {
            this.f5242d.dispose();
        }

        public boolean isDisposed() {
            return this.f5242d.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5242d, disposable)) {
                this.f5242d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.actual.onNext(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }
    }
}
