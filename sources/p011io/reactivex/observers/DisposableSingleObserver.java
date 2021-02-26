package p011io.reactivex.observers;

import java.util.concurrent.atomic.AtomicReference;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.annotations.NonNull;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.util.EndConsumerHelper;

/* renamed from: io.reactivex.observers.DisposableSingleObserver */
public abstract class DisposableSingleObserver<T> implements SingleObserver<T>, Disposable {

    /* renamed from: s */
    final AtomicReference<Disposable> f5385s = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    public final void onSubscribe(@NonNull Disposable disposable) {
        if (EndConsumerHelper.setOnce(this.f5385s, disposable, getClass())) {
            onStart();
        }
    }

    public final boolean isDisposed() {
        return this.f5385s.get() == DisposableHelper.DISPOSED;
    }

    public final void dispose() {
        DisposableHelper.dispose(this.f5385s);
    }
}
