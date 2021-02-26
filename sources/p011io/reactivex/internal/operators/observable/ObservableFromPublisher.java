package p011io.reactivex.internal.operators.observable;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;

/* renamed from: io.reactivex.internal.operators.observable.ObservableFromPublisher */
public final class ObservableFromPublisher<T> extends Observable<T> {
    final Publisher<? extends T> source;

    public ObservableFromPublisher(Publisher<? extends T> publisher) {
        this.source = publisher;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new PublisherSubscriber(observer));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableFromPublisher$PublisherSubscriber */
    static final class PublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        final Observer<? super T> actual;

        /* renamed from: s */
        Subscription f5240s;

        PublisherSubscriber(Observer<? super T> observer) {
            this.actual = observer;
        }

        public void onComplete() {
            this.actual.onComplete();
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onNext(T t) {
            this.actual.onNext(t);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f5240s, subscription)) {
                this.f5240s = subscription;
                this.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void dispose() {
            this.f5240s.cancel();
            this.f5240s = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f5240s == SubscriptionHelper.CANCELLED;
        }
    }
}
