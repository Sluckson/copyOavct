package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzok implements zzoh {
    private static final zzdc<Long> zza;
    private static final zzdc<Long> zzb;

    public final long zza() {
        return zzb.zzc().longValue();
    }

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.id.max_bundles_per_iteration", 0);
        zzb = zzdl.zza("measurement.max_bundles_per_iteration", 2);
    }
}
