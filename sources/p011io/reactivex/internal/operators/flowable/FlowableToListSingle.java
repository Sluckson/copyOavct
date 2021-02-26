package p011io.reactivex.internal.operators.flowable;

import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;
import p011io.reactivex.Flowable;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.Single;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.internal.disposables.EmptyDisposable;
import p011io.reactivex.internal.functions.ObjectHelper;
import p011io.reactivex.internal.fuseable.FuseToFlowable;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;
import p011io.reactivex.internal.util.ArrayListSupplier;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableToListSingle */
public final class FlowableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToFlowable<U> {
    final Callable<U> collectionSupplier;
    final Flowable<T> source;

    public FlowableToListSingle(Flowable<T> flowable) {
        this(flowable, ArrayListSupplier.asCallable());
    }

    public FlowableToListSingle(Flowable<T> flowable, Callable<U> callable) {
        this.source = flowable;
        this.collectionSupplier = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.source.subscribe(new ToListSubscriber(singleObserver, (Collection) ObjectHelper.requireNonNull(this.collectionSupplier.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }

    public Flowable<U> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableToList(this.source, this.collectionSupplier));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableToListSingle$ToListSubscriber */
    static final class ToListSubscriber<T, U extends Collection<? super T>> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super U> actual;

        /* renamed from: s */
        Subscription f5146s;
        U value;

        ToListSubscriber(SingleObserver<? super U> singleObserver, U u) {
            this.actual = singleObserver;
            this.value = u;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f5146s, subscription)) {
                this.f5146s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            this.value.add(t);
        }

        public void onError(Throwable th) {
            this.value = null;
            this.f5146s = SubscriptionHelper.CANCELLED;
            this.actual.onError(th);
        }

        public void onComplete() {
            this.f5146s = SubscriptionHelper.CANCELLED;
            this.actual.onSuccess(this.value);
        }

        public void dispose() {
            this.f5146s.cancel();
            this.f5146s = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f5146s == SubscriptionHelper.CANCELLED;
        }
    }
}
