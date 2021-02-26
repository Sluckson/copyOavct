package p011io.reactivex;

import p011io.reactivex.annotations.Experimental;
import p011io.reactivex.annotations.NonNull;

@Experimental
/* renamed from: io.reactivex.ObservableConverter */
public interface ObservableConverter<T, R> {
    @NonNull
    R apply(@NonNull Observable<T> observable);
}
