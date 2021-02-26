package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgd */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzgd extends zzgc {
    private zzgd() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j) {
        zzb(obj, j).zzgk();
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzfp zzb = zzb(obj, j);
        zzfp zzb2 = zzb(obj2, j);
        int size = zzb.size();
        int size2 = zzb2.size();
        if (size > 0 && size2 > 0) {
            if (!zzb.zzgj()) {
                zzb = zzb.zzao(size2 + size);
            }
            zzb.addAll(zzb2);
        }
        if (size > 0) {
            zzb2 = zzb;
        }
        zzig.zza(obj, j, (Object) zzb2);
    }

    private static <E> zzfp<E> zzb(Object obj, long j) {
        return (zzfp) zzig.zzo(obj, j);
    }
}
