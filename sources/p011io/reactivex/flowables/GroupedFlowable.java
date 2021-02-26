package p011io.reactivex.flowables;

import p011io.reactivex.Flowable;
import p011io.reactivex.annotations.Nullable;

/* renamed from: io.reactivex.flowables.GroupedFlowable */
public abstract class GroupedFlowable<K, T> extends Flowable<T> {
    final K key;

    protected GroupedFlowable(@Nullable K k) {
        this.key = k;
    }

    @Nullable
    public K getKey() {
        return this.key;
    }
}
