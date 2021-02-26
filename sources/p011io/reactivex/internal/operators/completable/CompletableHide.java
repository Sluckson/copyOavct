package p011io.reactivex.internal.operators.completable;

import p011io.reactivex.Completable;
import p011io.reactivex.CompletableObserver;
import p011io.reactivex.CompletableSource;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.completable.CompletableHide */
public final class CompletableHide extends Completable {
    final CompletableSource source;

    public CompletableHide(CompletableSource completableSource) {
        this.source = completableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new HideCompletableObserver(completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableHide$HideCompletableObserver */
    static final class HideCompletableObserver implements CompletableObserver, Disposable {
        final CompletableObserver actual;

        /* renamed from: d */
        Disposable f5033d;

        HideCompletableObserver(CompletableObserver completableObserver) {
            this.actual = completableObserver;
        }

        public void dispose() {
            this.f5033d.dispose();
            this.f5033d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f5033d.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5033d, disposable)) {
                this.f5033d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }
    }
}
