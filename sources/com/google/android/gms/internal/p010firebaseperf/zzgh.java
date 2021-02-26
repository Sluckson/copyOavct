package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgh */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzgh implements zzgp {
    private zzgp[] zzsp;

    zzgh(zzgp... zzgpArr) {
        this.zzsp = zzgpArr;
    }

    public final boolean zza(Class<?> cls) {
        for (zzgp zza : this.zzsp) {
            if (zza.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzgq zzb(Class<?> cls) {
        for (zzgp zzgp : this.zzsp) {
            if (zzgp.zza(cls)) {
                return zzgp.zzb(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
