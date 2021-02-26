package p011io.reactivex;

import org.reactivestreams.Publisher;
import p011io.reactivex.annotations.NonNull;

/* renamed from: io.reactivex.FlowableTransformer */
public interface FlowableTransformer<Upstream, Downstream> {
    @NonNull
    Publisher<Downstream> apply(@NonNull Flowable<Upstream> flowable);
}
