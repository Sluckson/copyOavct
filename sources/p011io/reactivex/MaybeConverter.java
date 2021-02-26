package p011io.reactivex;

import p011io.reactivex.annotations.Experimental;
import p011io.reactivex.annotations.NonNull;

@Experimental
/* renamed from: io.reactivex.MaybeConverter */
public interface MaybeConverter<T, R> {
    @NonNull
    R apply(@NonNull Maybe<T> maybe);
}
