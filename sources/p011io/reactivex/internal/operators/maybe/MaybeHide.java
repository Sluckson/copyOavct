package p011io.reactivex.internal.operators.maybe;

import p011io.reactivex.MaybeObserver;
import p011io.reactivex.MaybeSource;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeHide */
public final class MaybeHide<T> extends AbstractMaybeWithUpstream<T, T> {
    public MaybeHide(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new HideMaybeObserver(maybeObserver));
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeHide$HideMaybeObserver */
    static final class HideMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> actual;

        /* renamed from: d */
        Disposable f5181d;

        HideMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.actual = maybeObserver;
        }

        public void dispose() {
            this.f5181d.dispose();
            this.f5181d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f5181d.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5181d, disposable)) {
                this.f5181d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }
    }
}
