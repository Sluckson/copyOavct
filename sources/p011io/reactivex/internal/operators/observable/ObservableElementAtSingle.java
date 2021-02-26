package p011io.reactivex.internal.operators.observable;

import java.util.NoSuchElementException;
import p011io.reactivex.Observable;
import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.Single;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.fuseable.FuseToObservable;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableElementAtSingle */
public final class ObservableElementAtSingle<T> extends Single<T> implements FuseToObservable<T> {
    final T defaultValue;
    final long index;
    final ObservableSource<T> source;

    public ObservableElementAtSingle(ObservableSource<T> observableSource, long j, T t) {
        this.source = observableSource;
        this.index = j;
        this.defaultValue = t;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new ElementAtObserver(singleObserver, this.index, this.defaultValue));
    }

    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableElementAt(this.source, this.index, this.defaultValue, true));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableElementAtSingle$ElementAtObserver */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        final SingleObserver<? super T> actual;
        long count;
        final T defaultValue;
        boolean done;
        final long index;

        /* renamed from: s */
        Disposable f5231s;

        ElementAtObserver(SingleObserver<? super T> singleObserver, long j, T t) {
            this.actual = singleObserver;
            this.index = j;
            this.defaultValue = t;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5231s, disposable)) {
                this.f5231s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f5231s.dispose();
        }

        public boolean isDisposed() {
            return this.f5231s.isDisposed();
        }

        public void onNext(T t) {
            if (!this.done) {
                long j = this.count;
                if (j == this.index) {
                    this.done = true;
                    this.f5231s.dispose();
                    this.actual.onSuccess(t);
                    return;
                }
                this.count = j + 1;
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                T t = this.defaultValue;
                if (t != null) {
                    this.actual.onSuccess(t);
                } else {
                    this.actual.onError(new NoSuchElementException());
                }
            }
        }
    }
}
