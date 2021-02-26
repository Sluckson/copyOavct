package p011io.reactivex.internal.operators.observable;

import p011io.reactivex.Completable;
import p011io.reactivex.CompletableObserver;
import p011io.reactivex.Observable;
import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.fuseable.FuseToObservable;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable */
public final class ObservableIgnoreElementsCompletable<T> extends Completable implements FuseToObservable<T> {
    final ObservableSource<T> source;

    public ObservableIgnoreElementsCompletable(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new IgnoreObservable(completableObserver));
    }

    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableIgnoreElements(this.source));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable$IgnoreObservable */
    static final class IgnoreObservable<T> implements Observer<T>, Disposable {
        final CompletableObserver actual;

        /* renamed from: d */
        Disposable f5244d;

        public void onNext(T t) {
        }

        IgnoreObservable(CompletableObserver completableObserver) {
            this.actual = completableObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.f5244d = disposable;
            this.actual.onSubscribe(this);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }

        public void dispose() {
            this.f5244d.dispose();
        }

        public boolean isDisposed() {
            return this.f5244d.isDisposed();
        }
    }
}
