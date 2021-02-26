package p011io.reactivex.internal.operators.observable;

import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.observers.SerializedObserver;

/* renamed from: io.reactivex.internal.operators.observable.ObservableSerialized */
public final class ObservableSerialized<T> extends AbstractObservableWithUpstream<T, T> {
    public ObservableSerialized(Observable<T> observable) {
        super(observable);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SerializedObserver(observer));
    }
}
