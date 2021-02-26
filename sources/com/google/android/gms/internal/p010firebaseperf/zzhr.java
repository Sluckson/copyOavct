package com.google.android.gms.internal.p010firebaseperf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhr */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzhr implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzuo;
    private final /* synthetic */ zzhj zzup;
    private boolean zzus;

    private zzhr(zzhj zzhj) {
        this.zzup = zzhj;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zzup.zzuf.size() || (!this.zzup.zzug.isEmpty() && zzjd().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.zzus) {
            this.zzus = false;
            this.zzup.zziw();
            if (this.pos < this.zzup.zzuf.size()) {
                zzhj zzhj = this.zzup;
                int i = this.pos;
                this.pos = i - 1;
                Object unused = zzhj.zzav(i);
                return;
            }
            zzjd().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> zzjd() {
        if (this.zzuo == null) {
            this.zzuo = this.zzup.zzug.entrySet().iterator();
        }
        return this.zzuo;
    }

    public final /* synthetic */ Object next() {
        this.zzus = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zzup.zzuf.size()) {
            return (Map.Entry) this.zzup.zzuf.get(this.pos);
        }
        return (Map.Entry) zzjd().next();
    }

    /* synthetic */ zzhr(zzhj zzhj, zzhm zzhm) {
        this(zzhj);
    }
}
