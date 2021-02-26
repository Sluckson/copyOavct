package p011io.reactivex.internal.operators.observable;

import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.Predicate;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableAny */
public final class ObservableAny<T> extends AbstractObservableWithUpstream<T, Boolean> {
    final Predicate<? super T> predicate;

    public ObservableAny(ObservableSource<T> observableSource, Predicate<? super T> predicate2) {
        super(observableSource);
        this.predicate = predicate2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super Boolean> observer) {
        this.source.subscribe(new AnyObserver(observer, this.predicate));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableAny$AnyObserver */
    static final class AnyObserver<T> implements Observer<T>, Disposable {
        final Observer<? super Boolean> actual;
        boolean done;
        final Predicate<? super T> predicate;

        /* renamed from: s */
        Disposable f5198s;

        AnyObserver(Observer<? super Boolean> observer, Predicate<? super T> predicate2) {
            this.actual = observer;
            this.predicate = predicate2;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5198s, disposable)) {
                this.f5198s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    if (this.predicate.test(t)) {
                        this.done = true;
                        this.f5198s.dispose();
                        this.actual.onNext(true);
                        this.actual.onComplete();
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f5198s.dispose();
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
                this.actual.onNext(false);
                this.actual.onComplete();
            }
        }

        public void dispose() {
            this.f5198s.dispose();
        }

        public boolean isDisposed() {
            return this.f5198s.isDisposed();
        }
    }
}
