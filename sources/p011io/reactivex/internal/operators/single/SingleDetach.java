package p011io.reactivex.internal.operators.single;

import p011io.reactivex.Single;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.SingleSource;
import p011io.reactivex.annotations.Experimental;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;

@Experimental
/* renamed from: io.reactivex.internal.operators.single.SingleDetach */
public final class SingleDetach<T> extends Single<T> {
    final SingleSource<T> source;

    public SingleDetach(SingleSource<T> singleSource) {
        this.source = singleSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DetachSingleObserver(singleObserver));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleDetach$DetachSingleObserver */
    static final class DetachSingleObserver<T> implements SingleObserver<T>, Disposable {
        SingleObserver<? super T> actual;

        /* renamed from: d */
        Disposable f5328d;

        DetachSingleObserver(SingleObserver<? super T> singleObserver) {
            this.actual = singleObserver;
        }

        public void dispose() {
            this.actual = null;
            this.f5328d.dispose();
            this.f5328d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f5328d.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5328d, disposable)) {
                this.f5328d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.f5328d = DisposableHelper.DISPOSED;
            SingleObserver<? super T> singleObserver = this.actual;
            if (singleObserver != null) {
                this.actual = null;
                singleObserver.onSuccess(t);
            }
        }

        public void onError(Throwable th) {
            this.f5328d = DisposableHelper.DISPOSED;
            SingleObserver<? super T> singleObserver = this.actual;
            if (singleObserver != null) {
                this.actual = null;
                singleObserver.onError(th);
            }
        }
    }
}
