package p011io.reactivex.internal.operators.maybe;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import p011io.reactivex.Maybe;
import p011io.reactivex.MaybeObserver;
import p011io.reactivex.MaybeSource;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.CompositeException;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.Consumer;
import p011io.reactivex.functions.Function;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.disposables.EmptyDisposable;
import p011io.reactivex.internal.functions.ObjectHelper;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeUsing */
public final class MaybeUsing<T, D> extends Maybe<T> {
    final boolean eager;
    final Consumer<? super D> resourceDisposer;
    final Callable<? extends D> resourceSupplier;
    final Function<? super D, ? extends MaybeSource<? extends T>> sourceSupplier;

    public MaybeUsing(Callable<? extends D> callable, Function<? super D, ? extends MaybeSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        this.resourceSupplier = callable;
        this.sourceSupplier = function;
        this.resourceDisposer = consumer;
        this.eager = z;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        try {
            Object call = this.resourceSupplier.call();
            try {
                ((MaybeSource) ObjectHelper.requireNonNull(this.sourceSupplier.apply(call), "The sourceSupplier returned a null MaybeSource")).subscribe(new UsingObserver(maybeObserver, call, this.resourceDisposer, this.eager));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (MaybeObserver<?>) maybeObserver);
        }
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeUsing$UsingObserver */
    static final class UsingObserver<T, D> extends AtomicReference<Object> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -674404550052917487L;
        final MaybeObserver<? super T> actual;

        /* renamed from: d */
        Disposable f5195d;
        final Consumer<? super D> disposer;
        final boolean eager;

        UsingObserver(MaybeObserver<? super T> maybeObserver, D d, Consumer<? super D> consumer, boolean z) {
            super(d);
            this.actual = maybeObserver;
            this.disposer = consumer;
            this.eager = z;
        }

        public void dispose() {
            this.f5195d.dispose();
            this.f5195d = DisposableHelper.DISPOSED;
            disposeResourceAfter();
        }

        /* access modifiers changed from: package-private */
        public void disposeResourceAfter() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }

        public boolean isDisposed() {
            return this.f5195d.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5195d, disposable)) {
                this.f5195d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.f5195d = DisposableHelper.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.disposer.accept(andSet);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.actual.onError(th);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.actual.onSuccess(t);
            if (!this.eager) {
                disposeResourceAfter();
            }
        }

        public void onError(Throwable th) {
            this.f5195d = DisposableHelper.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.disposer.accept(andSet);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        th = new CompositeException(th, th2);
                    }
                } else {
                    return;
                }
            }
            this.actual.onError(th);
            if (!this.eager) {
                disposeResourceAfter();
            }
        }

        public void onComplete() {
            this.f5195d = DisposableHelper.DISPOSED;
            if (this.eager) {
                Object andSet = getAndSet(this);
                if (andSet != this) {
                    try {
                        this.disposer.accept(andSet);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.actual.onError(th);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.actual.onComplete();
            if (!this.eager) {
                disposeResourceAfter();
            }
        }
    }
}
