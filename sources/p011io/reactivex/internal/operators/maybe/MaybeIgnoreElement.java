package p011io.reactivex.internal.operators.maybe;

import p011io.reactivex.MaybeObserver;
import p011io.reactivex.MaybeSource;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeIgnoreElement */
public final class MaybeIgnoreElement<T> extends AbstractMaybeWithUpstream<T, T> {
    public MaybeIgnoreElement(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new IgnoreMaybeObserver(maybeObserver));
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeIgnoreElement$IgnoreMaybeObserver */
    static final class IgnoreMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> actual;

        /* renamed from: d */
        Disposable f5182d;

        IgnoreMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.actual = maybeObserver;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5182d, disposable)) {
                this.f5182d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.f5182d = DisposableHelper.DISPOSED;
            this.actual.onComplete();
        }

        public void onError(Throwable th) {
            this.f5182d = DisposableHelper.DISPOSED;
            this.actual.onError(th);
        }

        public void onComplete() {
            this.f5182d = DisposableHelper.DISPOSED;
            this.actual.onComplete();
        }

        public boolean isDisposed() {
            return this.f5182d.isDisposed();
        }

        public void dispose() {
            this.f5182d.dispose();
            this.f5182d = DisposableHelper.DISPOSED;
        }
    }
}
