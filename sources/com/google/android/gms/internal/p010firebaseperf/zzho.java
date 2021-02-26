package com.google.android.gms.internal.p010firebaseperf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzho */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzho extends zzhu {
    private final /* synthetic */ zzhj zzup;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzho(zzhj zzhj) {
        super(zzhj, (zzhm) null);
        this.zzup = zzhj;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzhl(this.zzup, (zzhm) null);
    }

    /* synthetic */ zzho(zzhj zzhj, zzhm zzhm) {
        this(zzhj);
    }
}
