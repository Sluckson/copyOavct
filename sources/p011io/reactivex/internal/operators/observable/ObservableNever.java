package p011io.reactivex.internal.operators.observable;

import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.internal.disposables.EmptyDisposable;

/* renamed from: io.reactivex.internal.operators.observable.ObservableNever */
public final class ObservableNever extends Observable<Object> {
    public static final Observable<Object> INSTANCE = new ObservableNever();

    private ObservableNever() {
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super Object> observer) {
        observer.onSubscribe(EmptyDisposable.NEVER);
    }
}
