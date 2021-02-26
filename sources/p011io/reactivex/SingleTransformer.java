package p011io.reactivex;

import p011io.reactivex.annotations.NonNull;

/* renamed from: io.reactivex.SingleTransformer */
public interface SingleTransformer<Upstream, Downstream> {
    @NonNull
    SingleSource<Downstream> apply(@NonNull Single<Upstream> single);
}
