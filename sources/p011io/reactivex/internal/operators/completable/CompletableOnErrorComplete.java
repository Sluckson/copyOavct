package p011io.reactivex.internal.operators.completable;

import p011io.reactivex.Completable;
import p011io.reactivex.CompletableObserver;
import p011io.reactivex.CompletableSource;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.exceptions.CompositeException;
import p011io.reactivex.exceptions.Exceptions;
import p011io.reactivex.functions.Predicate;

/* renamed from: io.reactivex.internal.operators.completable.CompletableOnErrorComplete */
public final class CompletableOnErrorComplete extends Completable {
    final Predicate<? super Throwable> predicate;
    final CompletableSource source;

    public CompletableOnErrorComplete(CompletableSource completableSource, Predicate<? super Throwable> predicate2) {
        this.source = completableSource;
        this.predicate = predicate2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new OnError(completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableOnErrorComplete$OnError */
    final class OnError implements CompletableObserver {

        /* renamed from: s */
        private final CompletableObserver f5035s;

        OnError(CompletableObserver completableObserver) {
            this.f5035s = completableObserver;
        }

        public void onComplete() {
            this.f5035s.onComplete();
        }

        public void onError(Throwable th) {
            try {
                if (CompletableOnErrorComplete.this.predicate.test(th)) {
                    this.f5035s.onComplete();
                } else {
                    this.f5035s.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f5035s.onError(new CompositeException(th, th2));
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f5035s.onSubscribe(disposable);
        }
    }
}
