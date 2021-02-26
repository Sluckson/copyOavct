package p011io.reactivex.internal.fuseable;

import p011io.reactivex.ObservableSource;

/* renamed from: io.reactivex.internal.fuseable.HasUpstreamObservableSource */
public interface HasUpstreamObservableSource<T> {
    ObservableSource<T> source();
}
