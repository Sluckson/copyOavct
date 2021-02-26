package p011io.reactivex.internal.operators.single;

import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.SingleSource;
import p011io.reactivex.annotations.Experimental;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.observers.DeferredScalarDisposable;

/* renamed from: io.reactivex.internal.operators.single.SingleToObservable */
public final class SingleToObservable<T> extends Observable<T> {
    final SingleSource<? extends T> source;

    public SingleToObservable(SingleSource<? extends T> singleSource) {
        this.source = singleSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(create(observer));
    }

    @Experimental
    public static <T> SingleObserver<T> create(Observer<? super T> observer) {
        return new SingleToObservableObserver(observer);
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleToObservable$SingleToObservableObserver */
    static final class SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements SingleObserver<T> {
        private static final long serialVersionUID = 3786543492451018833L;

        /* renamed from: d */
        Disposable f5345d;

        SingleToObservableObserver(Observer<? super T> observer) {
            super(observer);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5345d, disposable)) {
                this.f5345d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            complete(t);
        }

        public void onError(Throwable th) {
            error(th);
        }

        public void dispose() {
            super.dispose();
            this.f5345d.dispose();
        }
    }
}
