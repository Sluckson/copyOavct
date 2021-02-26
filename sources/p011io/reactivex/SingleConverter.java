package p011io.reactivex;

import p011io.reactivex.annotations.Experimental;
import p011io.reactivex.annotations.NonNull;

@Experimental
/* renamed from: io.reactivex.SingleConverter */
public interface SingleConverter<T, R> {
    @NonNull
    R apply(@NonNull Single<T> single);
}
