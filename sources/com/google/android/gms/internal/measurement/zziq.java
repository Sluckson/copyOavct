package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
abstract class zziq {
    private static final zziq zza = new zzis();
    private static final zziq zzb = new zzir();

    private zziq() {
    }

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> zza(Object obj, long j);

    /* access modifiers changed from: package-private */
    public abstract <L> void zza(Object obj, Object obj2, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(Object obj, long j);

    static zziq zza() {
        return zza;
    }

    static zziq zzb() {
        return zzb;
    }
}
