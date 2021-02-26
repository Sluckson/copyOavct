package p011io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import p011io.reactivex.Observable;
import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.Single;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.functions.BiConsumer;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.disposables.EmptyDisposable;
import p011io.reactivex.internal.functions.ObjectHelper;
import p011io.reactivex.internal.fuseable.FuseToObservable;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.observable.ObservableCollectSingle */
public final class ObservableCollectSingle<T, U> extends Single<U> implements FuseToObservable<U> {
    final BiConsumer<? super U, ? super T> collector;
    final Callable<? extends U> initialSupplier;
    final ObservableSource<T> source;

    public ObservableCollectSingle(ObservableSource<T> observableSource, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        this.source = observableSource;
        this.initialSupplier = callable;
        this.collector = biConsumer;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.source.subscribe(new CollectObserver(singleObserver, ObjectHelper.requireNonNull(this.initialSupplier.call(), "The initialSupplier returned a null value"), this.collector));
        } catch (Throwable th) {
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }

    public Observable<U> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableCollect(this.source, this.initialSupplier, this.collector));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableCollectSingle$CollectObserver */
    static final class CollectObserver<T, U> implements Observer<T>, Disposable {
        final SingleObserver<? super U> actual;
        final BiConsumer<? super U, ? super T> collector;
        boolean done;

        /* renamed from: s */
        Disposable f5212s;

        /* renamed from: u */
        final U f5213u;

        CollectObserver(SingleObserver<? super U> singleObserver, U u, BiConsumer<? super U, ? super T> biConsumer) {
            this.actual = singleObserver;
            this.collector = biConsumer;
            this.f5213u = u;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5212s, disposable)) {
                this.f5212s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f5212s.dispose();
        }

        public boolean isDisposed() {
            return this.f5212s.isDisposed();
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.collector.accept(this.f5213u, t);
                } catch (Throwable th) {
                    this.f5212s.dispose();
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
                this.actual.onSuccess(this.f5213u);
            }
        }
    }
}
