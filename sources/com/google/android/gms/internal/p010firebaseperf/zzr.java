package com.google.android.gms.internal.p010firebaseperf;

import java.util.AbstractMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzr */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzr extends zzj<Map.Entry<K, V>> {
    private final /* synthetic */ zzs zzp;

    zzr(zzs zzs) {
        this.zzp = zzs;
    }

    public final boolean zzg() {
        return true;
    }

    public final int size() {
        return this.zzp.size;
    }

    public final /* synthetic */ Object get(int i) {
        zzd.zza(i, this.zzp.size);
        Object[] zzb = this.zzp.zzm;
        int i2 = i * 2;
        zzs zzs = this.zzp;
        Object obj = zzb[i2];
        Object[] zzb2 = zzs.zzm;
        zzs zzs2 = this.zzp;
        return new AbstractMap.SimpleImmutableEntry(obj, zzb2[i2 + 1]);
    }
}
