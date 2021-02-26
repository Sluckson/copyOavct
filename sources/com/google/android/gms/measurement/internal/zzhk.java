package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzhk implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhe zzb;

    zzhk(zzhe zzhe, long j) {
        this.zzb = zzhe;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzr().zzl.zza(this.zza);
        this.zzb.zzq().zzv().zza("Session timeout duration set", Long.valueOf(this.zza));
    }
}
