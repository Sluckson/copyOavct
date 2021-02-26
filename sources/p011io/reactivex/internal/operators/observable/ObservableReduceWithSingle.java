package p011io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import p011io.reactivex.ObservableSource;
import p011io.reactivex.Single;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.BiFunction;
import p011io.reactivex.internal.disposables.EmptyDisposable;
import p011io.reactivex.internal.functions.ObjectHelper;
import p011io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;

/* renamed from: io.reactivex.internal.operators.observable.ObservableReduceWithSingle */
public final class ObservableReduceWithSingle<T, R> extends Single<R> {
    final BiFunction<R, ? super T, R> reducer;
    final Callable<R> seedSupplier;
    final ObservableSource<T> source;

    public ObservableReduceWithSingle(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.source = observableSource;
        this.seedSupplier = callable;
        this.reducer = biFunction;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.source.subscribe(new ObservableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.reducer, ObjectHelper.requireNonNull(this.seedSupplier.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }
}
