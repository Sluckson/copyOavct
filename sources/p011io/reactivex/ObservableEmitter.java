package p011io.reactivex;

import p011io.reactivex.annotations.Experimental;
import p011io.reactivex.annotations.NonNull;
import p011io.reactivex.annotations.Nullable;
import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.functions.Cancellable;

/* renamed from: io.reactivex.ObservableEmitter */
public interface ObservableEmitter<T> extends Emitter<T> {
    boolean isDisposed();

    @NonNull
    ObservableEmitter<T> serialize();

    void setCancellable(@Nullable Cancellable cancellable);

    void setDisposable(@Nullable Disposable disposable);

    @Experimental
    boolean tryOnError(@NonNull Throwable th);
}
