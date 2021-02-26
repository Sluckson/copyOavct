package p011io.reactivex;

import p011io.reactivex.annotations.NonNull;

/* renamed from: io.reactivex.SingleSource */
public interface SingleSource<T> {
    void subscribe(@NonNull SingleObserver<? super T> singleObserver);
}
