package p011io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p011io.reactivex.Observable;
import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.Function;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.disposables.EmptyDisposable;
import p011io.reactivex.internal.functions.ObjectHelper;
import p011io.reactivex.internal.util.AtomicThrowable;
import p011io.reactivex.internal.util.HalfSerializer;
import p011io.reactivex.subjects.PublishSubject;
import p011io.reactivex.subjects.Subject;

/* renamed from: io.reactivex.internal.operators.observable.ObservableRetryWhen */
public final class ObservableRetryWhen<T> extends AbstractObservableWithUpstream<T, T> {
    final Function<? super Observable<Throwable>, ? extends ObservableSource<?>> handler;

    public ObservableRetryWhen(ObservableSource<T> observableSource, Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        this.handler = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        Subject serialized = PublishSubject.create().toSerialized();
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.handler.apply(serialized), "The handler returned a null ObservableSource");
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, serialized, this.source);
            observer.onSubscribe(repeatWhenObserver);
            observableSource.subscribe(repeatWhenObserver.inner);
            repeatWhenObserver.subscribeNext();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (Observer<?>) observer);
        }
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableRetryWhen$RepeatWhenObserver */
    static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 802743776666017014L;
        volatile boolean active;
        final Observer<? super T> actual;

        /* renamed from: d */
        final AtomicReference<Disposable> f5263d = new AtomicReference<>();
        final AtomicThrowable error = new AtomicThrowable();
        final RepeatWhenObserver<T>.InnerRepeatObserver inner = new InnerRepeatObserver();
        final Subject<Throwable> signaller;
        final ObservableSource<T> source;
        final AtomicInteger wip = new AtomicInteger();

        RepeatWhenObserver(Observer<? super T> observer, Subject<Throwable> subject, ObservableSource<T> observableSource) {
            this.actual = observer;
            this.signaller = subject;
            this.source = observableSource;
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.f5263d, disposable);
        }

        public void onNext(T t) {
            HalfSerializer.onNext(this.actual, t, (AtomicInteger) this, this.error);
        }

        public void onError(Throwable th) {
            this.active = false;
            this.signaller.onNext(th);
        }

        public void onComplete() {
            DisposableHelper.dispose(this.inner);
            HalfSerializer.onComplete((Observer<?>) this.actual, (AtomicInteger) this, this.error);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f5263d.get());
        }

        public void dispose() {
            DisposableHelper.dispose(this.f5263d);
            DisposableHelper.dispose(this.inner);
        }

        /* access modifiers changed from: package-private */
        public void innerNext() {
            subscribeNext();
        }

        /* access modifiers changed from: package-private */
        public void innerError(Throwable th) {
            DisposableHelper.dispose(this.f5263d);
            HalfSerializer.onError((Observer<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        /* access modifiers changed from: package-private */
        public void innerComplete() {
            DisposableHelper.dispose(this.f5263d);
            HalfSerializer.onComplete((Observer<?>) this.actual, (AtomicInteger) this, this.error);
        }

        /* access modifiers changed from: package-private */
        public void subscribeNext() {
            if (this.wip.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.active) {
                        this.active = true;
                        this.source.subscribe(this);
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        /* renamed from: io.reactivex.internal.operators.observable.ObservableRetryWhen$RepeatWhenObserver$InnerRepeatObserver */
        final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            InnerRepeatObserver() {
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onNext(Object obj) {
                RepeatWhenObserver.this.innerNext();
            }

            public void onError(Throwable th) {
                RepeatWhenObserver.this.innerError(th);
            }

            public void onComplete() {
                RepeatWhenObserver.this.innerComplete();
            }
        }
    }
}
