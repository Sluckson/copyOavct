package p011io.reactivex.internal.operators.maybe;

import p011io.reactivex.MaybeObserver;
import p011io.reactivex.MaybeSource;
import p011io.reactivex.Single;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.functions.ObjectHelper;
import p011io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeContains */
public final class MaybeContains<T> extends Single<Boolean> implements HasUpstreamMaybeSource<T> {
    final MaybeSource<T> source;
    final Object value;

    public MaybeContains(MaybeSource<T> maybeSource, Object obj) {
        this.source = maybeSource;
        this.value = obj;
    }

    public MaybeSource<T> source() {
        return this.source;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.source.subscribe(new ContainsMaybeObserver(singleObserver, this.value));
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeContains$ContainsMaybeObserver */
    static final class ContainsMaybeObserver implements MaybeObserver<Object>, Disposable {
        final SingleObserver<? super Boolean> actual;

        /* renamed from: d */
        Disposable f5163d;
        final Object value;

        ContainsMaybeObserver(SingleObserver<? super Boolean> singleObserver, Object obj) {
            this.actual = singleObserver;
            this.value = obj;
        }

        public void dispose() {
            this.f5163d.dispose();
            this.f5163d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f5163d.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5163d, disposable)) {
                this.f5163d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(Object obj) {
            this.f5163d = DisposableHelper.DISPOSED;
            this.actual.onSuccess(Boolean.valueOf(ObjectHelper.equals(obj, this.value)));
        }

        public void onError(Throwable th) {
            this.f5163d = DisposableHelper.DISPOSED;
            this.actual.onError(th);
        }

        public void onComplete() {
            this.f5163d = DisposableHelper.DISPOSED;
            this.actual.onSuccess(false);
        }
    }
}
