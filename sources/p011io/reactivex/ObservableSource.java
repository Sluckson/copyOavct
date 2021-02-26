package p011io.reactivex;

import p011io.reactivex.annotations.NonNull;

/* renamed from: io.reactivex.ObservableSource */
public interface ObservableSource<T> {
    void subscribe(@NonNull Observer<? super T> observer);
}
