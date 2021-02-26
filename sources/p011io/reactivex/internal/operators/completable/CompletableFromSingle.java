package p011io.reactivex.internal.operators.completable;

import p011io.reactivex.Completable;
import p011io.reactivex.CompletableObserver;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.SingleSource;
import p011io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.completable.CompletableFromSingle */
public final class CompletableFromSingle<T> extends Completable {
    final SingleSource<T> single;

    public CompletableFromSingle(SingleSource<T> singleSource) {
        this.single = singleSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.single.subscribe(new CompletableFromSingleObserver(completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableFromSingle$CompletableFromSingleObserver */
    static final class CompletableFromSingleObserver<T> implements SingleObserver<T> {

        /* renamed from: co */
        final CompletableObserver f5032co;

        CompletableFromSingleObserver(CompletableObserver completableObserver) {
            this.f5032co = completableObserver;
        }

        public void onError(Throwable th) {
            this.f5032co.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            this.f5032co.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            this.f5032co.onComplete();
        }
    }
}
