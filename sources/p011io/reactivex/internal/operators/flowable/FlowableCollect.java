package p011io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p011io.reactivex.Flowable;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.BiConsumer;
import p011io.reactivex.internal.functions.ObjectHelper;
import p011io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import p011io.reactivex.internal.subscriptions.EmptySubscription;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableCollect */
public final class FlowableCollect<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final BiConsumer<? super U, ? super T> collector;
    final Callable<? extends U> initialSupplier;

    public FlowableCollect(Flowable<T> flowable, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        super(flowable);
        this.initialSupplier = callable;
        this.collector = biConsumer;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super U> subscriber) {
        try {
            this.source.subscribe(new CollectSubscriber(subscriber, ObjectHelper.requireNonNull(this.initialSupplier.call(), "The initial value supplied is null"), this.collector));
        } catch (Throwable th) {
            EmptySubscription.error(th, subscriber);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableCollect$CollectSubscriber */
    static final class CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3589550218733891694L;
        final BiConsumer<? super U, ? super T> collector;
        boolean done;

        /* renamed from: s */
        Subscription f5056s;

        /* renamed from: u */
        final U f5057u;

        CollectSubscriber(Subscriber<? super U> subscriber, U u, BiConsumer<? super U, ? super T> biConsumer) {
            super(subscriber);
            this.collector = biConsumer;
            this.f5057u = u;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f5056s, subscription)) {
                this.f5056s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.collector.accept(this.f5057u, t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f5056s.cancel();
                    onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                complete(this.f5057u);
            }
        }

        public void cancel() {
            super.cancel();
            this.f5056s.cancel();
        }
    }
}
