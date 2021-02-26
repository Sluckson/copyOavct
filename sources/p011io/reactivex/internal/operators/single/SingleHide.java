package p011io.reactivex.internal.operators.single;

import p011io.reactivex.Single;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.SingleSource;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.single.SingleHide */
public final class SingleHide<T> extends Single<T> {
    final SingleSource<? extends T> source;

    public SingleHide(SingleSource<? extends T> singleSource) {
        this.source = singleSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new HideSingleObserver(singleObserver));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleHide$HideSingleObserver */
    static final class HideSingleObserver<T> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> actual;

        /* renamed from: d */
        Disposable f5342d;

        HideSingleObserver(SingleObserver<? super T> singleObserver) {
            this.actual = singleObserver;
        }

        public void dispose() {
            this.f5342d.dispose();
        }

        public boolean isDisposed() {
            return this.f5342d.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5342d, disposable)) {
                this.f5342d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }
    }
}
