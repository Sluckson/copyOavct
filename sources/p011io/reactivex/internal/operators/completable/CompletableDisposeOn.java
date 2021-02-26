package p011io.reactivex.internal.operators.completable;

import p011io.reactivex.Completable;
import p011io.reactivex.CompletableObserver;
import p011io.reactivex.CompletableSource;
import p011io.reactivex.Scheduler;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.completable.CompletableDisposeOn */
public final class CompletableDisposeOn extends Completable {
    final Scheduler scheduler;
    final CompletableSource source;

    public CompletableDisposeOn(CompletableSource completableSource, Scheduler scheduler2) {
        this.source = completableSource;
        this.scheduler = scheduler2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new CompletableObserverImplementation(completableObserver, this.scheduler));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableDisposeOn$CompletableObserverImplementation */
    static final class CompletableObserverImplementation implements CompletableObserver, Disposable, Runnable {

        /* renamed from: d */
        Disposable f5026d;
        volatile boolean disposed;

        /* renamed from: s */
        final CompletableObserver f5027s;
        final Scheduler scheduler;

        CompletableObserverImplementation(CompletableObserver completableObserver, Scheduler scheduler2) {
            this.f5027s = completableObserver;
            this.scheduler = scheduler2;
        }

        public void onComplete() {
            if (!this.disposed) {
                this.f5027s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.disposed) {
                RxJavaPlugins.onError(th);
            } else {
                this.f5027s.onError(th);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f5026d, disposable)) {
                this.f5026d = disposable;
                this.f5027s.onSubscribe(this);
            }
        }

        public void dispose() {
            this.disposed = true;
            this.scheduler.scheduleDirect(this);
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        public void run() {
            this.f5026d.dispose();
            this.f5026d = DisposableHelper.DISPOSED;
        }
    }
}
