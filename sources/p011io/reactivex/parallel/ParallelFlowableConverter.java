package p011io.reactivex.parallel;

import p011io.reactivex.annotations.Experimental;
import p011io.reactivex.annotations.NonNull;

@Experimental
/* renamed from: io.reactivex.parallel.ParallelFlowableConverter */
public interface ParallelFlowableConverter<T, R> {
    @NonNull
    R apply(@NonNull ParallelFlowable<T> parallelFlowable);
}
