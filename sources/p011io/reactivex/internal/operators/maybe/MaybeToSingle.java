package p011io.reactivex.internal.operators.maybe;

import java.util.NoSuchElementException;
import p011io.reactivex.MaybeObserver;
import p011io.reactivex.MaybeSource;
import p011io.reactivex.Single;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeToSingle */
public final class MaybeToSingle<T> extends Single<T> implements HasUpstreamMaybeSource<T> {
    final T defaultValue;
    final MaybeSource<T> source;

    public MaybeToSingle(MaybeSource<T> maybeSource, T t) {
        this.source = maybeSource;
        this.defaultValue = t;
    }

    public MaybeSource<T> source() {
        return this.source;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new ToSingleMaybeSubscriber(singleObserver, this.defaultValue));
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeToSingle$ToSingleMaybeSubscriber */
    static final class ToSingleMaybeSubscriber<T> implements MaybeObserver<T>, Disposable {
        final SingleObserver<? super T> actual;

        /* renamed from: d */
        Disposable f5193d;
        final T defaultValue;

        ToSingleMaybeSubscriber(SingleObserver<? super T> singleObserver, T t) {
            this.actual = singleObserver;
            this.defaultValue = t;
        }

        public void dispose() {
            this.f5193d.dispose();
            this.f5193d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f5193d.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5193d, disposable)) {
                this.f5193d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.f5193d = DisposableHelper.DISPOSED;
            this.actual.onSuccess(t);
        }

        public void onError(Throwable th) {
            this.f5193d = DisposableHelper.DISPOSED;
            this.actual.onError(th);
        }

        public void onComplete() {
            this.f5193d = DisposableHelper.DISPOSED;
            T t = this.defaultValue;
            if (t != null) {
                this.actual.onSuccess(t);
            } else {
                this.actual.onError(new NoSuchElementException("The MaybeSource is empty"));
            }
        }
    }
}
