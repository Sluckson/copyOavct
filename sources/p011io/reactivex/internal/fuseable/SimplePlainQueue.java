package p011io.reactivex.internal.fuseable;

import p011io.reactivex.annotations.Nullable;

/* renamed from: io.reactivex.internal.fuseable.SimplePlainQueue */
public interface SimplePlainQueue<T> extends SimpleQueue<T> {
    @Nullable
    T poll();
}
