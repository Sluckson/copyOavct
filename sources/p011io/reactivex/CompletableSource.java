package p011io.reactivex;

import p011io.reactivex.annotations.NonNull;

/* renamed from: io.reactivex.CompletableSource */
public interface CompletableSource {
    void subscribe(@NonNull CompletableObserver completableObserver);
}
