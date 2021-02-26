package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzoe implements zzob {
    private static final zzdc<Long> zza;
    private static final zzdc<Boolean> zzb;
    private static final zzdc<Boolean> zzc;
    private static final zzdc<Boolean> zzd;
    private static final zzdc<Long> zze;

    public final boolean zza() {
        return zzb.zzc().booleanValue();
    }

    public final boolean zzb() {
        return zzc.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.id.lifecycle.app_in_background_parameter", 0);
        zzb = zzdl.zza("measurement.lifecycle.app_backgrounded_engagement", false);
        zzc = zzdl.zza("measurement.lifecycle.app_backgrounded_tracking", true);
        zzd = zzdl.zza("measurement.lifecycle.app_in_background_parameter", false);
        zze = zzdl.zza("measurement.id.lifecycle.app_backgrounded_tracking", 0);
    }
}
