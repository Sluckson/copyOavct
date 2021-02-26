package p011io.reactivex.internal.operators.observable;

import java.util.Iterator;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.BiFunction;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.disposables.EmptyDisposable;
import p011io.reactivex.internal.functions.ObjectHelper;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableZipIterable */
public final class ObservableZipIterable<T, U, V> extends Observable<V> {
    final Iterable<U> other;
    final Observable<? extends T> source;
    final BiFunction<? super T, ? super U, ? extends V> zipper;

    public ObservableZipIterable(Observable<? extends T> observable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        this.source = observable;
        this.other = iterable;
        this.zipper = biFunction;
    }

    public void subscribeActual(Observer<? super V> observer) {
        try {
            Iterator it = (Iterator) ObjectHelper.requireNonNull(this.other.iterator(), "The iterator returned by other is null");
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete((Observer<?>) observer);
                } else {
                    this.source.subscribe(new ZipIterableObserver(observer, it, this.zipper));
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, (Observer<?>) observer);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableZipIterable$ZipIterableObserver */
    static final class ZipIterableObserver<T, U, V> implements Observer<T>, Disposable {
        final Observer<? super V> actual;
        boolean done;
        final Iterator<U> iterator;

        /* renamed from: s */
        Disposable f5308s;
        final BiFunction<? super T, ? super U, ? extends V> zipper;

        ZipIterableObserver(Observer<? super V> observer, Iterator<U> it, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.actual = observer;
            this.iterator = it;
            this.zipper = biFunction;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5308s, disposable)) {
                this.f5308s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f5308s.dispose();
        }

        public boolean isDisposed() {
            return this.f5308s.isDisposed();
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    try {
                        this.actual.onNext(ObjectHelper.requireNonNull(this.zipper.apply(t, ObjectHelper.requireNonNull(this.iterator.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                        try {
                            if (!this.iterator.hasNext()) {
                                this.done = true;
                                this.f5308s.dispose();
                                this.actual.onComplete();
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            error(th);
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        error(th2);
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    error(th3);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void error(Throwable th) {
            this.done = true;
            this.f5308s.dispose();
            this.actual.onError(th);
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
                this.actual.onComplete();
            }
        }
    }
}
