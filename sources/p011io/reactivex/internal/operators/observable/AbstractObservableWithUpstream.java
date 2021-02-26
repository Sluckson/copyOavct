package p011io.reactivex.internal.operators.observable;

import p011io.reactivex.Observable;
import p011io.reactivex.ObservableSource;
import p011io.reactivex.internal.fuseable.HasUpstreamObservableSource;

/* renamed from: io.reactivex.internal.operators.observable.AbstractObservableWithUpstream */
abstract class AbstractObservableWithUpstream<T, U> extends Observable<U> implements HasUpstreamObservableSource<T> {
    protected final ObservableSource<T> source;

    AbstractObservableWithUpstream(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    public final ObservableSource<T> source() {
        return this.source;
    }
}
