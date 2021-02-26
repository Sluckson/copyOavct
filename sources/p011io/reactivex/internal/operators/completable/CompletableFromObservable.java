package p011io.reactivex.internal.operators.completable;

import p011io.reactivex.Completable;
import p011io.reactivex.CompletableObserver;
import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.completable.CompletableFromObservable */
public final class CompletableFromObservable<T> extends Completable {
    final ObservableSource<T> observable;

    public CompletableFromObservable(ObservableSource<T> observableSource) {
        this.observable = observableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.observable.subscribe(new CompletableFromObservableObserver(completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableFromObservable$CompletableFromObservableObserver */
    static final class CompletableFromObservableObserver<T> implements Observer<T> {

        /* renamed from: co */
        final CompletableObserver f5029co;

        public void onNext(T t) {
        }

        CompletableFromObservableObserver(CompletableObserver completableObserver) {
            this.f5029co = completableObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.f5029co.onSubscribe(disposable);
        }

        public void onError(Throwable th) {
            this.f5029co.onError(th);
        }

        public void onComplete() {
            this.f5029co.onComplete();
        }
    }
}
