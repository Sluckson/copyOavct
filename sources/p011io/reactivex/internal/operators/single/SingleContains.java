package p011io.reactivex.internal.operators.single;

import p011io.reactivex.SingleObserver;
import p011io.reactivex.SingleSource;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.BiPredicate;

/* renamed from: io.reactivex.internal.operators.single.SingleContains */
public final class SingleContains<T> extends p011io.reactivex.Single<Boolean> {
    final BiPredicate<Object, Object> comparer;
    final SingleSource<T> source;
    final Object value;

    public SingleContains(SingleSource<T> singleSource, Object obj, BiPredicate<Object, Object> biPredicate) {
        this.source = singleSource;
        this.value = obj;
        this.comparer = biPredicate;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.source.subscribe(new Single(singleObserver));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleContains$Single */
    final class Single implements SingleObserver<T> {

        /* renamed from: s */
        private final SingleObserver<? super Boolean> f5323s;

        Single(SingleObserver<? super Boolean> singleObserver) {
            this.f5323s = singleObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.f5323s.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            try {
                this.f5323s.onSuccess(Boolean.valueOf(SingleContains.this.comparer.test(t, SingleContains.this.value)));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f5323s.onError(th);
            }
        }

        public void onError(Throwable th) {
            this.f5323s.onError(th);
        }
    }
}
