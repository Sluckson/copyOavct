package p011io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.CompositeException;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.Function;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.observable.ObservableMapNotification */
public final class ObservableMapNotification<T, R> extends AbstractObservableWithUpstream<T, ObservableSource<? extends R>> {
    final Callable<? extends ObservableSource<? extends R>> onCompleteSupplier;
    final Function<? super Throwable, ? extends ObservableSource<? extends R>> onErrorMapper;
    final Function<? super T, ? extends ObservableSource<? extends R>> onNextMapper;

    public ObservableMapNotification(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        super(observableSource);
        this.onNextMapper = function;
        this.onErrorMapper = function2;
        this.onCompleteSupplier = callable;
    }

    public void subscribeActual(Observer<? super ObservableSource<? extends R>> observer) {
        this.source.subscribe(new MapNotificationObserver(observer, this.onNextMapper, this.onErrorMapper, this.onCompleteSupplier));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableMapNotification$MapNotificationObserver */
    static final class MapNotificationObserver<T, R> implements Observer<T>, Disposable {
        final Observer<? super ObservableSource<? extends R>> actual;
        final Callable<? extends ObservableSource<? extends R>> onCompleteSupplier;
        final Function<? super Throwable, ? extends ObservableSource<? extends R>> onErrorMapper;
        final Function<? super T, ? extends ObservableSource<? extends R>> onNextMapper;

        /* renamed from: s */
        Disposable f5248s;

        MapNotificationObserver(Observer<? super ObservableSource<? extends R>> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
            this.actual = observer;
            this.onNextMapper = function;
            this.onErrorMapper = function2;
            this.onCompleteSupplier = callable;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5248s, disposable)) {
                this.f5248s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f5248s.dispose();
        }

        public boolean isDisposed() {
            return this.f5248s.isDisposed();
        }

        public void onNext(T t) {
            try {
                this.actual.onNext((ObservableSource) ObjectHelper.requireNonNull(this.onNextMapper.apply(t), "The onNext ObservableSource returned is null"));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.actual.onError(th);
            }
        }

        public void onError(Throwable th) {
            try {
                this.actual.onNext((ObservableSource) ObjectHelper.requireNonNull(this.onErrorMapper.apply(th), "The onError ObservableSource returned is null"));
                this.actual.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }

        public void onComplete() {
            try {
                this.actual.onNext((ObservableSource) ObjectHelper.requireNonNull(this.onCompleteSupplier.call(), "The onComplete ObservableSource returned is null"));
                this.actual.onComplete();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.actual.onError(th);
            }
        }
    }
}
