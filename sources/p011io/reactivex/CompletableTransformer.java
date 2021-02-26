package p011io.reactivex;

import p011io.reactivex.annotations.NonNull;

/* renamed from: io.reactivex.CompletableTransformer */
public interface CompletableTransformer {
    @NonNull
    CompletableSource apply(@NonNull Completable completable);
}
