package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzmj implements zzmk {
    private static final zzdc<Boolean> zza;
    private static final zzdc<Boolean> zzb;
    private static final zzdc<Boolean> zzc;
    private static final zzdc<Boolean> zzd;
    private static final zzdc<Boolean> zze;
    private static final zzdc<Boolean> zzf;

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

    public final boolean zze() {
        return zzd.zzc().booleanValue();
    }

    public final boolean zzf() {
        return zze.zzc().booleanValue();
    }

    public final boolean zzg() {
        return zzf.zzc().booleanValue();
    }

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.gold.enhanced_ecommerce.format_logs", true);
        zzb = zzdl.zza("measurement.gold.enhanced_ecommerce.log_nested_complex_events", true);
        zzc = zzdl.zza("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", true);
        zzd = zzdl.zza("measurement.gold.enhanced_ecommerce.updated_schema.client", true);
        zze = zzdl.zza("measurement.gold.enhanced_ecommerce.updated_schema.service", true);
        zzf = zzdl.zza("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", true);
    }
}
