package p011io.reactivex.observers;

import p011io.reactivex.Observer;
import p011io.reactivex.annotations.NonNull;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.util.EndConsumerHelper;

/* renamed from: io.reactivex.observers.DefaultObserver */
public abstract class DefaultObserver<T> implements Observer<T> {

    /* renamed from: s */
    private Disposable f5381s;

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    public final void onSubscribe(@NonNull Disposable disposable) {
        if (EndConsumerHelper.validate(this.f5381s, disposable, getClass())) {
            this.f5381s = disposable;
            onStart();
        }
    }

    /* access modifiers changed from: protected */
    public final void cancel() {
        Disposable disposable = this.f5381s;
        this.f5381s = DisposableHelper.DISPOSED;
        disposable.dispose();
    }
}
