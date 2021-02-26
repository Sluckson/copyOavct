package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zznt implements zznu {
    private static final zzdc<Boolean> zza;
    private static final zzdc<Boolean> zzb;
    private static final zzdc<Boolean> zzc;
    private static final zzdc<Long> zzd;

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    public final boolean zzd() {
        return zzc.zzc().booleanValue();
    }

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.client.global_params", true);
        zzb = zzdl.zza("measurement.service.global_params_in_payload", true);
        zzc = zzdl.zza("measurement.service.global_params", true);
        zzd = zzdl.zza("measurement.id.service.global_params", 0);
    }
}
