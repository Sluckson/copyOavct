package com.google.android.gms.internal.p010firebaseperf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfy */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzfy<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzse;

    public zzfy(Iterator<Map.Entry<K, Object>> it) {
        this.zzse = it;
    }

    public final boolean hasNext() {
        return this.zzse.hasNext();
    }

    public final void remove() {
        this.zzse.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzse.next();
        return next.getValue() instanceof zzft ? new zzfv(next) : next;
    }
}
