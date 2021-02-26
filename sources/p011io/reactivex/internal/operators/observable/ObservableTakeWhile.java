package p011io.reactivex.internal.operators.observable;

import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.Predicate;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableTakeWhile */
public final class ObservableTakeWhile<T> extends AbstractObservableWithUpstream<T, T> {
    final Predicate<? super T> predicate;

    public ObservableTakeWhile(ObservableSource<T> observableSource, Predicate<? super T> predicate2) {
        super(observableSource);
        this.predicate = predicate2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new TakeWhileObserver(observer, this.predicate));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableTakeWhile$TakeWhileObserver */
    static final class TakeWhileObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;
        boolean done;
        final Predicate<? super T> predicate;

        /* renamed from: s */
        Disposable f5287s;

        TakeWhileObserver(Observer<? super T> observer, Predicate<? super T> predicate2) {
            this.actual = observer;
            this.predicate = predicate2;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5287s, disposable)) {
                this.f5287s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f5287s.dispose();
        }

        public boolean isDisposed() {
            return this.f5287s.isDisposed();
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    if (!this.predicate.test(t)) {
                        this.done = true;
                        this.f5287s.dispose();
                        this.actual.onComplete();
                        return;
                    }
                    this.actual.onNext(t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.f5287s.dispose();
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
                this.actual.onComplete();
            }
        }
    }
}
