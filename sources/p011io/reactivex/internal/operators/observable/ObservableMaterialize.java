package p011io.reactivex.internal.operators.observable;

import p011io.reactivex.Notification;
import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.observable.ObservableMaterialize */
public final class ObservableMaterialize<T> extends AbstractObservableWithUpstream<T, Notification<T>> {
    public ObservableMaterialize(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    public void subscribeActual(Observer<? super Notification<T>> observer) {
        this.source.subscribe(new MaterializeObserver(observer));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableMaterialize$MaterializeObserver */
    static final class MaterializeObserver<T> implements Observer<T>, Disposable {
        final Observer<? super Notification<T>> actual;

        /* renamed from: s */
        Disposable f5249s;

        MaterializeObserver(Observer<? super Notification<T>> observer) {
            this.actual = observer;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5249s, disposable)) {
                this.f5249s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f5249s.dispose();
        }

        public boolean isDisposed() {
            return this.f5249s.isDisposed();
        }

        public void onNext(T t) {
            this.actual.onNext(Notification.createOnNext(t));
        }

        public void onError(Throwable th) {
            this.actual.onNext(Notification.createOnError(th));
            this.actual.onComplete();
        }

        public void onComplete() {
            this.actual.onNext(Notification.createOnComplete());
            this.actual.onComplete();
        }
    }
}
