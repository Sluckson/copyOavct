package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzkd implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzkb zzb;

    zzkd(zzkb zzkb, long j) {
        this.zzb = zzkb;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
