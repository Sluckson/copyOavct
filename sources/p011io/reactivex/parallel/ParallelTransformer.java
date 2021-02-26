package p011io.reactivex.parallel;

import p011io.reactivex.annotations.Experimental;
import p011io.reactivex.annotations.NonNull;

@Experimental
/* renamed from: io.reactivex.parallel.ParallelTransformer */
public interface ParallelTransformer<Upstream, Downstream> {
    @NonNull
    ParallelFlowable<Downstream> apply(@NonNull ParallelFlowable<Upstream> parallelFlowable);
}
