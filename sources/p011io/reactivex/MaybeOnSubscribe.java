package p011io.reactivex;

import p011io.reactivex.annotations.NonNull;

/* renamed from: io.reactivex.MaybeOnSubscribe */
public interface MaybeOnSubscribe<T> {
    void subscribe(@NonNull MaybeEmitter<T> maybeEmitter) throws Exception;
}
