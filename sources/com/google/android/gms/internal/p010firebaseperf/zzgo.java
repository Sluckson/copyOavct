package com.google.android.gms.internal.p010firebaseperf;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgo */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzgo implements zzgl {
    zzgo() {
    }

    public final zzgj<?, ?> zzk(Object obj) {
        return ((zzgk) obj).zzic();
    }

    public final Map<?, ?> zzi(Object obj) {
        return (zzgm) obj;
    }

    public final Object zzj(Object obj) {
        ((zzgm) obj).zzgk();
        return obj;
    }

    public final Object zzc(Object obj, Object obj2) {
        zzgm zzgm = (zzgm) obj;
        zzgm zzgm2 = (zzgm) obj2;
        if (!zzgm2.isEmpty()) {
            if (!zzgm.isMutable()) {
                zzgm = zzgm.zzie();
            }
            zzgm.zza(zzgm2);
        }
        return zzgm;
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzgm zzgm = (zzgm) obj;
        zzgk zzgk = (zzgk) obj2;
        int i2 = 0;
        if (zzgm.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : zzgm.entrySet()) {
            i2 += zzgk.zza(i, entry.getKey(), entry.getValue());
        }
        return i2;
    }
}
