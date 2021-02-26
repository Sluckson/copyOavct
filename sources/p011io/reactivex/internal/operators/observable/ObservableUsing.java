package p011io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import p011io.reactivex.Observable;
import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.CompositeException;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.Consumer;
import p011io.reactivex.functions.Function;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.disposables.EmptyDisposable;
import p011io.reactivex.internal.functions.ObjectHelper;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableUsing */
public final class ObservableUsing<T, D> extends Observable<T> {
    final Consumer<? super D> disposer;
    final boolean eager;
    final Callable<? extends D> resourceSupplier;
    final Function<? super D, ? extends ObservableSource<? extends T>> sourceSupplier;

    public ObservableUsing(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.resourceSupplier = callable;
        this.sourceSupplier = function;
        this.disposer = consumer;
        this.eager = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            Object call = this.resourceSupplier.call();
            try {
                ((ObservableSource) ObjectHelper.requireNonNull(this.sourceSupplier.apply(call), "The sourceSupplier returned a null ObservableSource")).subscribe(new UsingObserver(observer, call, this.disposer, this.eager));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error((Throwable) new CompositeException(th, th), (Observer<?>) observer);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableUsing$UsingObserver */
    static final class UsingObserver<T, D> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = 5904473792286235046L;
        final Observer<? super T> actual;
        final Consumer<? super D> disposer;
        final boolean eager;
        final D resource;

        /* renamed from: s */
        Disposable f5293s;

        UsingObserver(Observer<? super T> observer, D d, Consumer<? super D> consumer, boolean z) {
            this.actual = observer;
            this.resource = d;
            this.disposer = consumer;
            this.eager = z;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5293s, disposable)) {
                this.f5293s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.actual.onNext(t);
        }

        public void onError(Throwable th) {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept(this.resource);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                this.f5293s.dispose();
                this.actual.onError(th);
                return;
            }
            this.actual.onError(th);
            this.f5293s.dispose();
            disposeAfter();
        }

        public void onComplete() {
            if (this.eager) {
                if (compareAndSet(false, true)) {
                    try {
                        this.disposer.accept(this.resource);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.actual.onError(th);
                        return;
                    }
                }
                this.f5293s.dispose();
                this.actual.onComplete();
                return;
            }
            this.actual.onComplete();
            this.f5293s.dispose();
            disposeAfter();
        }

        public void dispose() {
            disposeAfter();
            this.f5293s.dispose();
        }

        public boolean isDisposed() {
            return get();
        }

        /* access modifiers changed from: package-private */
        public void disposeAfter() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }
}
