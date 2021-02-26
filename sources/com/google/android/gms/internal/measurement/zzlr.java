package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzlr implements zzls {
    private static final zzdc<Boolean> zza;
    private static final zzdc<Boolean> zzb;

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.androidId.delete_feature", true);
        zzb = zzdl.zza("measurement.log_androidId_enabled", false);
    }
}
