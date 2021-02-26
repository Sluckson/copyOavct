package p011io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import p011io.reactivex.Flowable;
import p011io.reactivex.internal.fuseable.ScalarCallable;
import p011io.reactivex.internal.subscriptions.EmptySubscription;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableEmpty */
public final class FlowableEmpty extends Flowable<Object> implements ScalarCallable<Object> {
    public static final Flowable<Object> INSTANCE = new FlowableEmpty();

    public Object call() {
        return null;
    }

    private FlowableEmpty() {
    }

    public void subscribeActual(Subscriber<? super Object> subscriber) {
        EmptySubscription.complete(subscriber);
    }
}
