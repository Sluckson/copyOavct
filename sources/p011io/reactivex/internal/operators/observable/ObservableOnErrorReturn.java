package p011io.reactivex.internal.operators.observable;

import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.CompositeException;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.Function;
import p011io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.observable.ObservableOnErrorReturn */
public final class ObservableOnErrorReturn<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Throwable, ? extends T> valueSupplier;

    public ObservableOnErrorReturn(ObservableSource<T> observableSource, Function<? super Throwable, ? extends T> function) {
        super(observableSource);
        this.valueSupplier = function;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new OnErrorReturnObserver(observer, this.valueSupplier));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableOnErrorReturn$OnErrorReturnObserver */
    static final class OnErrorReturnObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;

        /* renamed from: s */
        Disposable f5251s;
        final Function<? super Throwable, ? extends T> valueSupplier;

        OnErrorReturnObserver(Observer<? super T> observer, Function<? super Throwable, ? extends T> function) {
            this.actual = observer;
            this.valueSupplier = function;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5251s, disposable)) {
                this.f5251s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f5251s.dispose();
        }

        public boolean isDisposed() {
            return this.f5251s.isDisposed();
        }

        public void onNext(T t) {
            this.actual.onNext(t);
        }

        public void onError(Throwable th) {
            try {
                Object apply = this.valueSupplier.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.actual.onError(nullPointerException);
                    return;
                }
                this.actual.onNext(apply);
                this.actual.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }

        public void onComplete() {
            this.actual.onComplete();
        }
    }
}
