package p011io.reactivex;

import p011io.reactivex.annotations.Experimental;
import p011io.reactivex.annotations.NonNull;

@Experimental
/* renamed from: io.reactivex.FlowableConverter */
public interface FlowableConverter<T, R> {
    @NonNull
    R apply(@NonNull Flowable<T> flowable);
}
