package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zznz implements zzoa {
    private static final zzdc<Boolean> zza;
    private static final zzdc<Boolean> zzb;
    private static final zzdc<Boolean> zzc;
    private static final zzdc<Boolean> zzd;
    private static final zzdc<Long> zze;

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzc.zzc().booleanValue();
    }

    public final boolean zzd() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.sdk.collection.enable_extend_user_property_size", true);
        zzb = zzdl.zza("measurement.sdk.collection.last_deep_link_referrer2", true);
        zzc = zzdl.zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzd = zzdl.zza("measurement.sdk.collection.last_gclid_from_referrer2", false);
        zze = zzdl.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0);
    }
}
