package p011io.reactivex.internal.operators.completable;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;
import p011io.reactivex.Completable;
import p011io.reactivex.CompletableObserver;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;

/* renamed from: io.reactivex.internal.operators.completable.CompletableFromPublisher */
public final class CompletableFromPublisher<T> extends Completable {
    final Publisher<T> flowable;

    public CompletableFromPublisher(Publisher<T> publisher) {
        this.flowable = publisher;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.flowable.subscribe(new FromPublisherSubscriber(completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableFromPublisher$FromPublisherSubscriber */
    static final class FromPublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: cs */
        final CompletableObserver f5030cs;

        /* renamed from: s */
        Subscription f5031s;

        public void onNext(T t) {
        }

        FromPublisherSubscriber(CompletableObserver completableObserver) {
            this.f5030cs = completableObserver;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f5031s, subscription)) {
                this.f5031s = subscription;
                this.f5030cs.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onError(Throwable th) {
            this.f5030cs.onError(th);
        }

        public void onComplete() {
            this.f5030cs.onComplete();
        }

        public void dispose() {
            this.f5031s.cancel();
            this.f5031s = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f5031s == SubscriptionHelper.CANCELLED;
        }
    }
}
