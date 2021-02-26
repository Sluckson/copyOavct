package p011io.reactivex.internal.operators.maybe;

import p011io.reactivex.MaybeObserver;
import p011io.reactivex.MaybeSource;
import p011io.reactivex.Single;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeCount */
public final class MaybeCount<T> extends Single<Long> implements HasUpstreamMaybeSource<T> {
    final MaybeSource<T> source;

    public MaybeCount(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    public MaybeSource<T> source() {
        return this.source;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.source.subscribe(new CountMaybeObserver(singleObserver));
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeCount$CountMaybeObserver */
    static final class CountMaybeObserver implements MaybeObserver<Object>, Disposable {
        final SingleObserver<? super Long> actual;

        /* renamed from: d */
        Disposable f5164d;

        CountMaybeObserver(SingleObserver<? super Long> singleObserver) {
            this.actual = singleObserver;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5164d, disposable)) {
                this.f5164d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(Object obj) {
            this.f5164d = DisposableHelper.DISPOSED;
            this.actual.onSuccess(1L);
        }

        public void onError(Throwable th) {
            this.f5164d = DisposableHelper.DISPOSED;
            this.actual.onError(th);
        }

        public void onComplete() {
            this.f5164d = DisposableHelper.DISPOSED;
            this.actual.onSuccess(0L);
        }

        public boolean isDisposed() {
            return this.f5164d.isDisposed();
        }

        public void dispose() {
            this.f5164d.dispose();
            this.f5164d = DisposableHelper.DISPOSED;
        }
    }
}
