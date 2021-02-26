package p011io.reactivex.parallel;

import p011io.reactivex.annotations.Experimental;
import p011io.reactivex.functions.BiFunction;

@Experimental
/* renamed from: io.reactivex.parallel.ParallelFailureHandling */
public enum ParallelFailureHandling implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    public ParallelFailureHandling apply(Long l, Throwable th) {
        return this;
    }
}
