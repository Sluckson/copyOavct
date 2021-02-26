package p011io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p011io.reactivex.Completable;
import p011io.reactivex.CompletableObserver;
import p011io.reactivex.CompletableSource;
import p011io.reactivex.Observable;
import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.CompositeDisposable;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.Function;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.functions.ObjectHelper;
import p011io.reactivex.internal.fuseable.FuseToObservable;
import p011io.reactivex.internal.util.AtomicThrowable;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable */
public final class ObservableFlatMapCompletableCompletable<T> extends Completable implements FuseToObservable<T> {
    final boolean delayErrors;
    final Function<? super T, ? extends CompletableSource> mapper;
    final ObservableSource<T> source;

    public ObservableFlatMapCompletableCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z) {
        this.source = observableSource;
        this.mapper = function;
        this.delayErrors = z;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new FlatMapCompletableMainObserver(completableObserver, this.mapper, this.delayErrors));
    }

    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableFlatMapCompletable(this.source, this.mapper, this.delayErrors));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver */
    static final class FlatMapCompletableMainObserver<T> extends AtomicInteger implements Disposable, Observer<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final CompletableObserver actual;

        /* renamed from: d */
        Disposable f5235d;
        final boolean delayErrors;
        volatile boolean disposed;
        final AtomicThrowable errors = new AtomicThrowable();
        final Function<? super T, ? extends CompletableSource> mapper;
        final CompositeDisposable set = new CompositeDisposable();

        FlatMapCompletableMainObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z) {
            this.actual = completableObserver;
            this.mapper = function;
            this.delayErrors = z;
            lazySet(1);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5235d, disposable)) {
                this.f5235d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.disposed && this.set.add(innerObserver)) {
                    completableSource.subscribe(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f5235d.dispose();
                onError(th);
            }
        }

        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (!this.delayErrors) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.actual.onError(this.errors.terminate());
                }
            } else if (decrementAndGet() == 0) {
                this.actual.onError(this.errors.terminate());
            }
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.errors.terminate();
                if (terminate != null) {
                    this.actual.onError(terminate);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        public void dispose() {
            this.disposed = true;
            this.f5235d.dispose();
            this.set.dispose();
        }

        public boolean isDisposed() {
            return this.f5235d.isDisposed();
        }

        /* access modifiers changed from: package-private */
        public void innerComplete(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.set.delete(innerObserver);
            onComplete();
        }

        /* access modifiers changed from: package-private */
        public void innerError(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th) {
            this.set.delete(innerObserver);
            onError(th);
        }

        /* renamed from: io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver$InnerObserver */
        final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 8606673141535671828L;

            InnerObserver() {
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onComplete() {
                FlatMapCompletableMainObserver.this.innerComplete(this);
            }

            public void onError(Throwable th) {
                FlatMapCompletableMainObserver.this.innerError(this, th);
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }
        }
    }
}
