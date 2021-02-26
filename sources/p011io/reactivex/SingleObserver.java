package p011io.reactivex;

import p011io.reactivex.annotations.NonNull;
import p011io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.SingleObserver */
public interface SingleObserver<T> {
    void onError(@NonNull Throwable th);

    void onSubscribe(@NonNull Disposable disposable);

    void onSuccess(@NonNull T t);
}
