package p011io.reactivex;

import p011io.reactivex.annotations.NonNull;

/* renamed from: io.reactivex.Emitter */
public interface Emitter<T> {
    void onComplete();

    void onError(@NonNull Throwable th);

    void onNext(@NonNull T t);
}
