package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzmi implements zzmf {
    private static final zzdc<Boolean> zza;
    private static final zzdc<Boolean> zzb;
    private static final zzdc<Boolean> zzc;
    private static final zzdc<Long> zzd;

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.sdk.dynamite.allow_remote_dynamite2", false);
        zzb = zzdl.zza("measurement.collection.init_params_control_enabled", true);
        zzc = zzdl.zza("measurement.sdk.dynamite.use_dynamite3", true);
        zzd = zzdl.zza("measurement.id.sdk.dynamite.use_dynamite", 0);
    }
}
