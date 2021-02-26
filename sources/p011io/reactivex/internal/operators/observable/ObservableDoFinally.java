package p011io.reactivex.internal.operators.observable;

import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.annotations.Experimental;
import p011io.reactivex.annotations.Nullable;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.Action;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.fuseable.QueueDisposable;
import p011io.reactivex.internal.observers.BasicIntQueueDisposable;
import p011io.reactivex.plugins.RxJavaPlugins;

@Experimental
/* renamed from: io.reactivex.internal.operators.observable.ObservableDoFinally */
public final class ObservableDoFinally<T> extends AbstractObservableWithUpstream<T, T> {
    final Action onFinally;

    public ObservableDoFinally(ObservableSource<T> observableSource, Action action) {
        super(observableSource);
        this.onFinally = action;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DoFinallyObserver(observer, this.onFinally));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableDoFinally$DoFinallyObserver */
    static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final Observer<? super T> actual;

        /* renamed from: d */
        Disposable f5226d;
        final Action onFinally;

        /* renamed from: qd */
        QueueDisposable<T> f5227qd;
        boolean syncFused;

        DoFinallyObserver(Observer<? super T> observer, Action action) {
            this.actual = observer;
            this.onFinally = action;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5226d, disposable)) {
                this.f5226d = disposable;
                if (disposable instanceof QueueDisposable) {
                    this.f5227qd = (QueueDisposable) disposable;
                }
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.actual.onNext(t);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        public void dispose() {
            this.f5226d.dispose();
            runFinally();
        }

        public boolean isDisposed() {
            return this.f5226d.isDisposed();
        }

        public int requestFusion(int i) {
            QueueDisposable<T> queueDisposable = this.f5227qd;
            if (queueDisposable == null || (i & 4) != 0) {
                return 0;
            }
            int requestFusion = queueDisposable.requestFusion(i);
            if (requestFusion != 0) {
                boolean z = true;
                if (requestFusion != 1) {
                    z = false;
                }
                this.syncFused = z;
            }
            return requestFusion;
        }

        public void clear() {
            this.f5227qd.clear();
        }

        public boolean isEmpty() {
            return this.f5227qd.isEmpty();
        }

        @Nullable
        public T poll() throws Exception {
            T poll = this.f5227qd.poll();
            if (poll == null && this.syncFused) {
                runFinally();
            }
            return poll;
        }

        /* access modifiers changed from: package-private */
        public void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }
}
