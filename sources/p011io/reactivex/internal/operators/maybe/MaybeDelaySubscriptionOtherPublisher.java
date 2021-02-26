package p011io.reactivex.internal.operators.maybe;

import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;
import p011io.reactivex.FlowableSubscriber;
import p011io.reactivex.MaybeObserver;
import p011io.reactivex.MaybeSource;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.subscriptions.SubscriptionHelper;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher */
public final class MaybeDelaySubscriptionOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {
    final Publisher<U> other;

    public MaybeDelaySubscriptionOtherPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.other = publisher;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.other.subscribe(new OtherSubscriber(maybeObserver, this.source));
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher$OtherSubscriber */
    static final class OtherSubscriber<T> implements FlowableSubscriber<Object>, Disposable {
        final DelayMaybeObserver<T> main;

        /* renamed from: s */
        Subscription f5166s;
        MaybeSource<T> source;

        OtherSubscriber(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
            this.main = new DelayMaybeObserver<>(maybeObserver);
            this.source = maybeSource;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f5166s, subscription)) {
                this.f5166s = subscription;
                this.main.actual.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onNext(Object obj) {
            if (this.f5166s != SubscriptionHelper.CANCELLED) {
                this.f5166s.cancel();
                this.f5166s = SubscriptionHelper.CANCELLED;
                subscribeNext();
            }
        }

        public void onError(Throwable th) {
            if (this.f5166s != SubscriptionHelper.CANCELLED) {
                this.f5166s = SubscriptionHelper.CANCELLED;
                this.main.actual.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onComplete() {
            if (this.f5166s != SubscriptionHelper.CANCELLED) {
                this.f5166s = SubscriptionHelper.CANCELLED;
                subscribeNext();
            }
        }

        /* access modifiers changed from: package-private */
        public void subscribeNext() {
            MaybeSource<T> maybeSource = this.source;
            this.source = null;
            maybeSource.subscribe(this.main);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) this.main.get());
        }

        public void dispose() {
            this.f5166s.cancel();
            this.f5166s = SubscriptionHelper.CANCELLED;
            DisposableHelper.dispose(this.main);
        }
    }

    /* renamed from: io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher$DelayMaybeObserver */
    static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 706635022205076709L;
        final MaybeObserver<? super T> actual;

        DelayMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.actual = maybeObserver;
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            this.actual.onComplete();
        }
    }
}
