package p011io.reactivex;

import p011io.reactivex.annotations.NonNull;

/* renamed from: io.reactivex.MaybeOperator */
public interface MaybeOperator<Downstream, Upstream> {
    @NonNull
    MaybeObserver<? super Upstream> apply(@NonNull MaybeObserver<? super Downstream> maybeObserver) throws Exception;
}
