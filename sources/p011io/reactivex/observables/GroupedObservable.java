package p011io.reactivex.observables;

import p011io.reactivex.Observable;
import p011io.reactivex.annotations.Nullable;

/* renamed from: io.reactivex.observables.GroupedObservable */
public abstract class GroupedObservable<K, T> extends Observable<T> {
    final K key;

    protected GroupedObservable(@Nullable K k) {
        this.key = k;
    }

    @Nullable
    public K getKey() {
        return this.key;
    }
}
