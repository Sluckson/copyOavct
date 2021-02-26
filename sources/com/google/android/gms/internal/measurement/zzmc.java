package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzmc implements zzlz {
    private static final zzdc<Boolean> zza;
    private static final zzdc<Boolean> zzb;
    private static final zzdc<Long> zzc;

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.service.configurable_service_limits", true);
        zzb = zzdl.zza("measurement.client.configurable_service_limits", true);
        zzc = zzdl.zza("measurement.id.service.configurable_service_limits", 0);
    }
}
