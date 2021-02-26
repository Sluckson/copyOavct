package p011io.reactivex.internal.operators.maybe;

import p011io.reactivex.Maybe;
import p011io.reactivex.MaybeObserver;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.SingleSource;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.fuseable.HasUpstreamSingleSource;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeFromSingle */
public final class MaybeFromSingle<T> extends Maybe<T> implements HasUpstreamSingleSource<T> {
    final SingleSource<T> source;

    public MaybeFromSingle(SingleSource<T> singleSource) {
        this.source = singleSource;
    }

    public SingleSource<T> source() {
        return this.source;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new FromSingleObserver(maybeObserver));
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeFromSingle$FromSingleObserver */
    static final class FromSingleObserver<T> implements SingleObserver<T>, Disposable {
        final MaybeObserver<? super T> actual;

        /* renamed from: d */
        Disposable f5180d;

        FromSingleObserver(MaybeObserver<? super T> maybeObserver) {
            this.actual = maybeObserver;
        }

        public void dispose() {
            this.f5180d.dispose();
            this.f5180d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f5180d.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5180d, disposable)) {
                this.f5180d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.f5180d = DisposableHelper.DISPOSED;
            this.actual.onSuccess(t);
        }

        public void onError(Throwable th) {
            this.f5180d = DisposableHelper.DISPOSED;
            this.actual.onError(th);
        }
    }
}
