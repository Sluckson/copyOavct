package p011io.reactivex.internal.operators.maybe;

import org.reactivestreams.Publisher;
import p011io.reactivex.MaybeSource;
import p011io.reactivex.functions.Function;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeToPublisher */
public enum MaybeToPublisher implements Function<MaybeSource<Object>, Publisher<Object>> {
    INSTANCE;

    public static <T> Function<MaybeSource<T>, Publisher<T>> instance() {
        return INSTANCE;
    }

    public Publisher<Object> apply(MaybeSource<Object> maybeSource) throws Exception {
        return new MaybeToFlowable(maybeSource);
    }
}
