package p011io.reactivex;

import p011io.reactivex.annotations.NonNull;

/* renamed from: io.reactivex.SingleOnSubscribe */
public interface SingleOnSubscribe<T> {
    void subscribe(@NonNull SingleEmitter<T> singleEmitter) throws Exception;
}
