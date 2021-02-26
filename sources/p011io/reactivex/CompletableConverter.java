package p011io.reactivex;

import p011io.reactivex.annotations.Experimental;
import p011io.reactivex.annotations.NonNull;

@Experimental
/* renamed from: io.reactivex.CompletableConverter */
public interface CompletableConverter<R> {
    @NonNull
    R apply(@NonNull Completable completable);
}
