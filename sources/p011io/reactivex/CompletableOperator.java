package p011io.reactivex;

import p011io.reactivex.annotations.NonNull;

/* renamed from: io.reactivex.CompletableOperator */
public interface CompletableOperator {
    @NonNull
    CompletableObserver apply(@NonNull CompletableObserver completableObserver) throws Exception;
}
