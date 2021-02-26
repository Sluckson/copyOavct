package com.google.android.gms.internal.p010firebaseperf;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhu */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
class zzhu extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzhj zzup;

    private zzhu(zzhj zzhj) {
        this.zzup = zzhj;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzhr(this.zzup, (zzhm) null);
    }

    public int size() {
        return this.zzup.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzup.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzup.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzup.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzup.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzhu(zzhj zzhj, zzhm zzhm) {
        this(zzhj);
    }
}
