package p011io.reactivex.internal.operators.completable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p011io.reactivex.Completable;
import p011io.reactivex.CompletableObserver;
import p011io.reactivex.Scheduler;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.completable.CompletableTimer */
public final class CompletableTimer extends Completable {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    public CompletableTimer(long j, TimeUnit timeUnit, Scheduler scheduler2) {
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(completableObserver);
        completableObserver.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.scheduler.scheduleDirect(timerDisposable, this.delay, this.unit));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableTimer$TimerDisposable */
    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 3167244060586201109L;
        final CompletableObserver actual;

        TimerDisposable(CompletableObserver completableObserver) {
            this.actual = completableObserver;
        }

        public void run() {
            this.actual.onComplete();
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        /* access modifiers changed from: package-private */
        public void setFuture(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }
}
