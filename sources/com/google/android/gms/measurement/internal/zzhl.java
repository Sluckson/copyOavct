package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzhl implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhe zzb;

    zzhl(zzhe zzhe, long j) {
        this.zzb = zzhe;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzr().zzk.zza(this.zza);
        this.zzb.zzq().zzv().zza("Minimum session duration set", Long.valueOf(this.zza));
    }
}
