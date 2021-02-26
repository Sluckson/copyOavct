package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzng implements zznd {
    private static final zzdc<Boolean> zza;
    private static final zzdc<Boolean> zzb;
    private static final zzdc<Boolean> zzc;

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.client.sessions.check_on_reset_and_enable2", true);
        zzb = zzdl.zza("measurement.client.sessions.check_on_startup", true);
        zzc = zzdl.zza("measurement.client.sessions.start_session_before_view_screen", true);
    }
}
