package p011io.reactivex.internal.operators.single;

import p011io.reactivex.Single;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.SingleSource;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.Action;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.single.SingleDoAfterTerminate */
public final class SingleDoAfterTerminate<T> extends Single<T> {
    final Action onAfterTerminate;
    final SingleSource<T> source;

    public SingleDoAfterTerminate(SingleSource<T> singleSource, Action action) {
        this.source = singleSource;
        this.onAfterTerminate = action;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DoAfterTerminateObserver(singleObserver, this.onAfterTerminate));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleDoAfterTerminate$DoAfterTerminateObserver */
    static final class DoAfterTerminateObserver<T> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> actual;

        /* renamed from: d */
        Disposable f5330d;
        final Action onAfterTerminate;

        DoAfterTerminateObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.actual = singleObserver;
            this.onAfterTerminate = action;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5330d, disposable)) {
                this.f5330d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.actual.onSuccess(t);
            onAfterTerminate();
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
            onAfterTerminate();
        }

        public void dispose() {
            this.f5330d.dispose();
        }

        public boolean isDisposed() {
            return this.f5330d.isDisposed();
        }

        private void onAfterTerminate() {
            try {
                this.onAfterTerminate.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }
}
