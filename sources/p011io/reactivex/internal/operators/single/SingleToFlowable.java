package p011io.reactivex.internal.operators.single;

import org.reactivestreams.Subscriber;
import p011io.reactivex.Flowable;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.SingleSource;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.subscriptions.DeferredScalarSubscription;

/* renamed from: io.reactivex.internal.operators.single.SingleToFlowable */
public final class SingleToFlowable<T> extends Flowable<T> {
    final SingleSource<? extends T> source;

    public SingleToFlowable(SingleSource<? extends T> singleSource) {
        this.source = singleSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SingleToFlowableObserver(subscriber));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleToFlowable$SingleToFlowableObserver */
    static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements SingleObserver<T> {
        private static final long serialVersionUID = 187782011903685568L;

        /* renamed from: d */
        Disposable f5344d;

        SingleToFlowableObserver(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5344d, disposable)) {
                this.f5344d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            complete(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void cancel() {
            super.cancel();
            this.f5344d.dispose();
        }
    }
}
