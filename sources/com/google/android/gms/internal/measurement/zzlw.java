package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzlw implements zzlt {
    private static final zzdc<Boolean> zza;
    private static final zzdc<Long> zzb;

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final long zzb() {
        return zzb.zzc().longValue();
    }

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.sdk.attribution.cache", true);
        zzb = zzdl.zza("measurement.sdk.attribution.cache.ttl", 604800000);
    }
}
