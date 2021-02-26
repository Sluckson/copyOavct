package p011io.reactivex.internal.operators.single;

import p011io.reactivex.Single;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.SingleSource;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.Consumer;

/* renamed from: io.reactivex.internal.operators.single.SingleDoOnSuccess */
public final class SingleDoOnSuccess<T> extends Single<T> {
    final Consumer<? super T> onSuccess;
    final SingleSource<T> source;

    public SingleDoOnSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.source = singleSource;
        this.onSuccess = consumer;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DoOnSuccess(singleObserver));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleDoOnSuccess$DoOnSuccess */
    final class DoOnSuccess implements SingleObserver<T> {

        /* renamed from: s */
        private final SingleObserver<? super T> f5335s;

        DoOnSuccess(SingleObserver<? super T> singleObserver) {
            this.f5335s = singleObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.f5335s.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            try {
                SingleDoOnSuccess.this.onSuccess.accept(t);
                this.f5335s.onSuccess(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f5335s.onError(th);
            }
        }

        public void onError(Throwable th) {
            this.f5335s.onError(th);
        }
    }
}
