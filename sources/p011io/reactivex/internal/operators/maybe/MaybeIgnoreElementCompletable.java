package p011io.reactivex.internal.operators.maybe;

import p011io.reactivex.Completable;
import p011io.reactivex.CompletableObserver;
import p011io.reactivex.Maybe;
import p011io.reactivex.MaybeObserver;
import p011io.reactivex.MaybeSource;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.fuseable.FuseToMaybe;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeIgnoreElementCompletable */
public final class MaybeIgnoreElementCompletable<T> extends Completable implements FuseToMaybe<T> {
    final MaybeSource<T> source;

    public MaybeIgnoreElementCompletable(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new IgnoreMaybeObserver(completableObserver));
    }

    public Maybe<T> fuseToMaybe() {
        return RxJavaPlugins.onAssembly(new MaybeIgnoreElement(this.source));
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeIgnoreElementCompletable$IgnoreMaybeObserver */
    static final class IgnoreMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final CompletableObserver actual;

        /* renamed from: d */
        Disposable f5183d;

        IgnoreMaybeObserver(CompletableObserver completableObserver) {
            this.actual = completableObserver;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5183d, disposable)) {
                this.f5183d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.f5183d = DisposableHelper.DISPOSED;
            this.actual.onComplete();
        }

        public void onError(Throwable th) {
            this.f5183d = DisposableHelper.DISPOSED;
            this.actual.onError(th);
        }

        public void onComplete() {
            this.f5183d = DisposableHelper.DISPOSED;
            this.actual.onComplete();
        }

        public boolean isDisposed() {
            return this.f5183d.isDisposed();
        }

        public void dispose() {
            this.f5183d.dispose();
            this.f5183d = DisposableHelper.DISPOSED;
        }
    }
}
