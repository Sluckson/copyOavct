package p011io.reactivex.internal.operators.completable;

import java.util.concurrent.TimeUnit;
import p011io.reactivex.Completable;
import p011io.reactivex.CompletableObserver;
import p011io.reactivex.CompletableSource;
import p011io.reactivex.Scheduler;
import p011io.reactivex.disposables.CompositeDisposable;
import p011io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.completable.CompletableDelay */
public final class CompletableDelay extends Completable {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final CompletableSource source;
    final TimeUnit unit;

    public CompletableDelay(CompletableSource completableSource, long j, TimeUnit timeUnit, Scheduler scheduler2, boolean z) {
        this.source = completableSource;
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
        this.delayError = z;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new Delay(new CompositeDisposable(), completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableDelay$Delay */
    final class Delay implements CompletableObserver {

        /* renamed from: s */
        final CompletableObserver f5023s;
        private final CompositeDisposable set;

        Delay(CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.set = compositeDisposable;
            this.f5023s = completableObserver;
        }

        public void onComplete() {
            this.set.add(CompletableDelay.this.scheduler.scheduleDirect(new OnComplete(), CompletableDelay.this.delay, CompletableDelay.this.unit));
        }

        public void onError(Throwable th) {
            this.set.add(CompletableDelay.this.scheduler.scheduleDirect(new OnError(th), CompletableDelay.this.delayError ? CompletableDelay.this.delay : 0, CompletableDelay.this.unit));
        }

        public void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
            this.f5023s.onSubscribe(this.set);
        }

        /* renamed from: io.reactivex.internal.operators.completable.CompletableDelay$Delay$OnComplete */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            public void run() {
                Delay.this.f5023s.onComplete();
            }
        }

        /* renamed from: io.reactivex.internal.operators.completable.CompletableDelay$Delay$OnError */
        final class OnError implements Runnable {

            /* renamed from: e */
            private final Throwable f5024e;

            OnError(Throwable th) {
                this.f5024e = th;
            }

            public void run() {
                Delay.this.f5023s.onError(this.f5024e);
            }
        }
    }
}
