package p011io.reactivex;

import p011io.reactivex.annotations.NonNull;

/* renamed from: io.reactivex.ObservableTransformer */
public interface ObservableTransformer<Upstream, Downstream> {
    @NonNull
    ObservableSource<Downstream> apply(@NonNull Observable<Upstream> observable);
}
