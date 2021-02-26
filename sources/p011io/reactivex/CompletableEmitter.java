package p011io.reactivex;

import p011io.reactivex.annotations.Experimental;
import p011io.reactivex.annotations.NonNull;
import p011io.reactivex.annotations.Nullable;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.functions.Cancellable;

/* renamed from: io.reactivex.CompletableEmitter */
public interface CompletableEmitter {
    boolean isDisposed();

    void onComplete();

    void onError(@NonNull Throwable th);

    void setCancellable(@Nullable Cancellable cancellable);

    void setDisposable(@Nullable Disposable disposable);

    @Experimental
    boolean tryOnError(@NonNull Throwable th);
}
