package p011io.reactivex.observers;

import java.util.concurrent.atomic.AtomicReference;
import p011io.reactivex.SingleObserver;
import p011io.reactivex.annotations.NonNull;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.internal.disposables.DisposableHelper;
import p011io.reactivex.internal.disposables.ListCompositeDisposable;
import p011io.reactivex.internal.functions.ObjectHelper;
import p011io.reactivex.internal.util.EndConsumerHelper;

/* renamed from: io.reactivex.observers.ResourceSingleObserver */
public abstract class ResourceSingleObserver<T> implements SingleObserver<T>, Disposable {
    private final ListCompositeDisposable resources = new ListCompositeDisposable();

    /* renamed from: s */
    private final AtomicReference<Disposable> f5389s = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    public final void add(@NonNull Disposable disposable) {
        ObjectHelper.requireNonNull(disposable, "resource is null");
        this.resources.add(disposable);
    }

    public final void onSubscribe(@NonNull Disposable disposable) {
        if (EndConsumerHelper.setOnce(this.f5389s, disposable, getClass())) {
            onStart();
        }
    }

    public final void dispose() {
        if (DisposableHelper.dispose(this.f5389s)) {
            this.resources.dispose();
        }
    }

    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f5389s.get());
    }
}
