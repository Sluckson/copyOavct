package p011io.reactivex;

import p011io.reactivex.annotations.NonNull;

/* renamed from: io.reactivex.MaybeSource */
public interface MaybeSource<T> {
    void subscribe(@NonNull MaybeObserver<? super T> maybeObserver);
}
