package p011io.reactivex.internal.operators.single;

import p011io.reactivex.Single;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.SingleSource;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.CompositeException;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.BiConsumer;

/* renamed from: io.reactivex.internal.operators.single.SingleDoOnEvent */
public final class SingleDoOnEvent<T> extends Single<T> {
    final BiConsumer<? super T, ? super Throwable> onEvent;
    final SingleSource<T> source;

    public SingleDoOnEvent(SingleSource<T> singleSource, BiConsumer<? super T, ? super Throwable> biConsumer) {
        this.source = singleSource;
        this.onEvent = biConsumer;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DoOnEvent(singleObserver));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleDoOnEvent$DoOnEvent */
    final class DoOnEvent implements SingleObserver<T> {

        /* renamed from: s */
        private final SingleObserver<? super T> f5334s;

        DoOnEvent(SingleObserver<? super T> singleObserver) {
            this.f5334s = singleObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.f5334s.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            try {
                SingleDoOnEvent.this.onEvent.accept(t, null);
                this.f5334s.onSuccess(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f5334s.onError(th);
            }
        }

        public void onError(Throwable th) {
            try {
                SingleDoOnEvent.this.onEvent.accept(null, th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(th, th2);
            }
            this.f5334s.onError(th);
        }
    }
}
