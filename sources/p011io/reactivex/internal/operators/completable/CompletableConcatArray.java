package p011io.reactivex.internal.operators.completable;

import java.util.concurrent.atomic.AtomicInteger;
import p011io.reactivex.Completable;
import p011io.reactivex.CompletableObserver;
import p011io.reactivex.CompletableSource;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.SequentialDisposable;

/* renamed from: io.reactivex.internal.operators.completable.CompletableConcatArray */
public final class CompletableConcatArray extends Completable {
    final CompletableSource[] sources;

    public CompletableConcatArray(CompletableSource[] completableSourceArr) {
        this.sources = completableSourceArr;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver, this.sources);
        completableObserver.onSubscribe(concatInnerObserver.f5021sd);
        concatInnerObserver.next();
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableConcatArray$ConcatInnerObserver */
    static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;
        final CompletableObserver actual;
        int index;

        /* renamed from: sd */
        final SequentialDisposable f5021sd = new SequentialDisposable();
        final CompletableSource[] sources;

        ConcatInnerObserver(CompletableObserver completableObserver, CompletableSource[] completableSourceArr) {
            this.actual = completableObserver;
            this.sources = completableSourceArr;
        }

        public void onSubscribe(Disposable disposable) {
            this.f5021sd.replace(disposable);
        }

        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        public void onComplete() {
            next();
        }

        /* access modifiers changed from: package-private */
        public void next() {
            if (!this.f5021sd.isDisposed() && getAndIncrement() == 0) {
                CompletableSource[] completableSourceArr = this.sources;
                while (!this.f5021sd.isDisposed()) {
                    int i = this.index;
                    this.index = i + 1;
                    if (i == completableSourceArr.length) {
                        this.actual.onComplete();
                        return;
                    }
                    completableSourceArr[i].subscribe(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }
}
