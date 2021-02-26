package p011io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p011io.reactivex.Flowable;
import p011io.reactivex.Observable;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableFromObservable */
public final class FlowableFromObservable<T> extends Flowable<T> {
    private final Observable<T> upstream;

    public FlowableFromObservable(Observable<T> observable) {
        this.upstream = observable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.upstream.subscribe(new SubscriberObserver(subscriber));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableFromObservable$SubscriberObserver */
    static class SubscriberObserver<T> implements Observer<T>, Subscription {

        /* renamed from: d */
        private Disposable f5088d;

        /* renamed from: s */
        private final Subscriber<? super T> f5089s;

        public void request(long j) {
        }

        SubscriberObserver(Subscriber<? super T> subscriber) {
            this.f5089s = subscriber;
        }

        public void onComplete() {
            this.f5089s.onComplete();
        }

        public void onError(Throwable th) {
            this.f5089s.onError(th);
        }

        public void onNext(T t) {
            this.f5089s.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            this.f5088d = disposable;
            this.f5089s.onSubscribe(this);
        }

        public void cancel() {
            this.f5088d.dispose();
        }
    }
}
