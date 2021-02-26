package p011io.reactivex.processors;

import org.reactivestreams.Processor;
import p011io.reactivex.Flowable;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.annotations.CheckReturnValue;
import p011io.reactivex.annotations.NonNull;
import p011io.reactivex.annotations.Nullable;

/* renamed from: io.reactivex.processors.FlowableProcessor */
public abstract class FlowableProcessor<T> extends Flowable<T> implements Processor<T, T>, FlowableSubscriber<T> {
    @Nullable
    public abstract Throwable getThrowable();

    public abstract boolean hasComplete();

    public abstract boolean hasSubscribers();

    public abstract boolean hasThrowable();

    @CheckReturnValue
    @NonNull
    public final FlowableProcessor<T> toSerialized() {
        if (this instanceof SerializedProcessor) {
            return this;
        }
        return new SerializedProcessor(this);
    }
}
