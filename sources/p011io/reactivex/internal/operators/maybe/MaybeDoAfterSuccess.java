package p011io.reactivex.internal.operators.maybe;

import p011io.reactivex.MaybeObserver;
import p011io.reactivex.MaybeSource;
import p011io.reactivex.annotations.Experimental;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.Consumer;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.plugins.RxJavaPlugins;

@Experimental
/* renamed from: io.reactivex.internal.operators.maybe.MaybeDoAfterSuccess */
public final class MaybeDoAfterSuccess<T> extends AbstractMaybeWithUpstream<T, T> {
    final Consumer<? super T> onAfterSuccess;

    public MaybeDoAfterSuccess(MaybeSource<T> maybeSource, Consumer<? super T> consumer) {
        super(maybeSource);
        this.onAfterSuccess = consumer;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new DoAfterObserver(maybeObserver, this.onAfterSuccess));
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeDoAfterSuccess$DoAfterObserver */
    static final class DoAfterObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> actual;

        /* renamed from: d */
        Disposable f5168d;
        final Consumer<? super T> onAfterSuccess;

        DoAfterObserver(MaybeObserver<? super T> maybeObserver, Consumer<? super T> consumer) {
            this.actual = maybeObserver;
            this.onAfterSuccess = consumer;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5168d, disposable)) {
                this.f5168d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.actual.onSuccess(t);
            try {
                this.onAfterSuccess.accept(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }

        public void dispose() {
            this.f5168d.dispose();
        }

        public boolean isDisposed() {
            return this.f5168d.isDisposed();
        }
    }
}
