package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzmu implements zzmr {
    private static final zzdc<Boolean> zza;
    private static final zzdc<Boolean> zzb;
    private static final zzdc<Boolean> zzc;
    private static final zzdc<Boolean> zzd;

    public final boolean zza() {
        return true;
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
        zza = zzdl.zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zzb = zzdl.zza("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzc = zzdl.zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzd = zzdl.zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }
}
