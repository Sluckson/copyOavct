package p011io.reactivex.internal.observers;

import java.util.concurrent.CountDownLatch;
import p011io.reactivex.Observer;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.util.BlockingHelper;
import p011io.reactivex.internal.util.ExceptionHelper;

/* renamed from: io.reactivex.internal.observers.BlockingBaseObserver */
public abstract class BlockingBaseObserver<T> extends CountDownLatch implements Observer<T>, Disposable {
    volatile boolean cancelled;

    /* renamed from: d */
    Disposable f5003d;
    Throwable error;
    T value;

    public BlockingBaseObserver() {
        super(1);
    }

    public final void onSubscribe(Disposable disposable) {
        this.f5003d = disposable;
        if (this.cancelled) {
            disposable.dispose();
        }
    }

    public final void onComplete() {
        countDown();
    }

    public final void dispose() {
        this.cancelled = true;
        Disposable disposable = this.f5003d;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final boolean isDisposed() {
        return this.cancelled;
    }

    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.error;
        if (th == null) {
            return this.value;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }
}
