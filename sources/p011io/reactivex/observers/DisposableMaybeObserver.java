package p011io.reactivex.observers;

import java.util.concurrent.atomic.AtomicReference;
import p011io.reactivex.MaybeObserver;
import p011io.reactivex.annotations.NonNull;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.util.EndConsumerHelper;

/* renamed from: io.reactivex.observers.DisposableMaybeObserver */
public abstract class DisposableMaybeObserver<T> implements MaybeObserver<T>, Disposable {

    /* renamed from: s */
    final AtomicReference<Disposable> f5383s = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    public final void onSubscribe(@NonNull Disposable disposable) {
        if (EndConsumerHelper.setOnce(this.f5383s, disposable, getClass())) {
            onStart();
        }
    }

    public final boolean isDisposed() {
        return this.f5383s.get() == DisposableHelper.DISPOSED;
    }

    public final void dispose() {
        DisposableHelper.dispose(this.f5383s);
    }
}
