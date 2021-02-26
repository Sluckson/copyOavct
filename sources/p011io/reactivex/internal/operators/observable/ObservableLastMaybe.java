package p011io.reactivex.internal.operators.observable;

import p011io.reactivex.Maybe;
import p011io.reactivex.MaybeObserver;
import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.observable.ObservableLastMaybe */
public final class ObservableLastMaybe<T> extends Maybe<T> {
    final ObservableSource<T> source;

    public ObservableLastMaybe(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new LastObserver(maybeObserver));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableLastMaybe$LastObserver */
    static final class LastObserver<T> implements Observer<T>, Disposable {
        final MaybeObserver<? super T> actual;
        T item;

        /* renamed from: s */
        Disposable f5246s;

        LastObserver(MaybeObserver<? super T> maybeObserver) {
            this.actual = maybeObserver;
        }

        public void dispose() {
            this.f5246s.dispose();
            this.f5246s = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f5246s == DisposableHelper.DISPOSED;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5246s, disposable)) {
                this.f5246s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.item = t;
        }

        public void onError(Throwable th) {
            this.f5246s = DisposableHelper.DISPOSED;
            this.item = null;
            this.actual.onError(th);
        }

        public void onComplete() {
            this.f5246s = DisposableHelper.DISPOSED;
            T t = this.item;
            if (t != null) {
                this.item = null;
                this.actual.onSuccess(t);
                return;
            }
            this.actual.onComplete();
        }
    }
}
