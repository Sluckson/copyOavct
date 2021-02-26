package p011io.reactivex.internal.operators.flowable;

import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.Single;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableLastSingle */
public final class FlowableLastSingle<T> extends Single<T> {
    final T defaultItem;
    final Publisher<T> source;

    public FlowableLastSingle(Publisher<T> publisher, T t) {
        this.source = publisher;
        this.defaultItem = t;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new LastSubscriber(singleObserver, this.defaultItem));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableLastSingle$LastSubscriber */
    static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final SingleObserver<? super T> actual;
        final T defaultItem;
        T item;

        /* renamed from: s */
        Subscription f5096s;

        LastSubscriber(SingleObserver<? super T> singleObserver, T t) {
            this.actual = singleObserver;
            this.defaultItem = t;
        }

        public void dispose() {
            this.f5096s.cancel();
            this.f5096s = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f5096s == SubscriptionHelper.CANCELLED;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f5096s, subscription)) {
                this.f5096s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            this.item = t;
        }

        public void onError(Throwable th) {
            this.f5096s = SubscriptionHelper.CANCELLED;
            this.item = null;
            this.actual.onError(th);
        }

        public void onComplete() {
            this.f5096s = SubscriptionHelper.CANCELLED;
            T t = this.item;
            if (t != null) {
                this.item = null;
                this.actual.onSuccess(t);
                return;
            }
            T t2 = this.defaultItem;
            if (t2 != null) {
                this.actual.onSuccess(t2);
            } else {
                this.actual.onError(new NoSuchElementException());
            }
        }
    }
}
