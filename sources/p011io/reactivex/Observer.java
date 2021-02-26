package p011io.reactivex;

import p011io.reactivex.annotations.NonNull;
import p011io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.Observer */
public interface Observer<T> {
    void onComplete();

    void onError(@NonNull Throwable th);

    void onNext(@NonNull T t);

    void onSubscribe(@NonNull Disposable disposable);
}
