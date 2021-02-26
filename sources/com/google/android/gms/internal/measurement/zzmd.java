package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzmd implements zzme {
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

    public final long zzd() {
        return zzc.zzc().longValue();
    }

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.client.consent_state_v1", false);
        zzb = zzdl.zza("measurement.service.consent_state_v1_W33", false);
        zzc = zzdl.zza("measurement.service.storage_consent_support_version", 203290);
    }
}
