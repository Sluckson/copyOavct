package com.google.android.gms.internal.p010firebaseperf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhl */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzhl implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzuo;
    private final /* synthetic */ zzhj zzup;

    private zzhl(zzhj zzhj) {
        this.zzup = zzhj;
        this.pos = this.zzup.zzuf.size();
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzup.zzuf.size()) || zzjd().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zzjd() {
        if (this.zzuo == null) {
            this.zzuo = this.zzup.zzui.entrySet().iterator();
        }
        return this.zzuo;
    }

    public final /* synthetic */ Object next() {
        if (zzjd().hasNext()) {
            return (Map.Entry) zzjd().next();
        }
        List zzb = this.zzup.zzuf;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) zzb.get(i);
    }

    /* synthetic */ zzhl(zzhj zzhj, zzhm zzhm) {
        this(zzhj);
    }
}
