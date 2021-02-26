package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzoq implements zzon {
    private static final zzdc<Boolean> zza;
    private static final zzdc<Double> zzb;
    private static final zzdc<Long> zzc;
    private static final zzdc<Long> zzd;
    private static final zzdc<String> zze;

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final double zzb() {
        return zzb.zzc().doubleValue();
    }

    public final long zzc() {
        return zzc.zzc().longValue();
    }

    public final long zzd() {
        return zzd.zzc().longValue();
    }

    public final String zze() {
        return zze.zzc();
    }

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.test.boolean_flag", false);
        zzb = zzdl.zza("measurement.test.double_flag", -3.0d);
        zzc = zzdl.zza("measurement.test.int_flag", -2);
        zzd = zzdl.zza("measurement.test.long_flag", -1);
        zze = zzdl.zza("measurement.test.string_flag", "---");
    }
}
