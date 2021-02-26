package com.google.android.gms.internal.p010firebaseperf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzed */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
abstract class zzed<E> extends AbstractList<E> implements zzfp<E> {
    private boolean zzmw = true;

    zzed() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public boolean add(E e) {
        zzgl();
        return super.add(e);
    }

    public void add(int i, E e) {
        zzgl();
        super.add(i, e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzgl();
        return super.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzgl();
        return super.addAll(i, collection);
    }

    public void clear() {
        zzgl();
        super.clear();
    }

    public boolean zzgj() {
        return this.zzmw;
    }

    public final void zzgk() {
        this.zzmw = false;
    }

    public E remove(int i) {
        zzgl();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        zzgl();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        zzgl();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzgl();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        zzgl();
        return super.set(i, e);
    }

    /* access modifiers changed from: protected */
    public final void zzgl() {
        if (!this.zzmw) {
            throw new UnsupportedOperationException();
        }
    }
}
