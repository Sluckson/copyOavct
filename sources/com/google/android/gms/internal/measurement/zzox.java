package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzox implements zzoy {
    private static final zzdc<Boolean> zza;
    private static final zzdc<Long> zzb;

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.service.ssaid_removal", true);
        zzb = zzdl.zza("measurement.id.ssaid_removal", 0);
    }
}
