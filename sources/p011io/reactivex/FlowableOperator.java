package p011io.reactivex;

import org.reactivestreams.Subscriber;
import p011io.reactivex.annotations.NonNull;

/* renamed from: io.reactivex.FlowableOperator */
public interface FlowableOperator<Downstream, Upstream> {
    @NonNull
    Subscriber<? super Upstream> apply(@NonNull Subscriber<? super Downstream> subscriber) throws Exception;
}
