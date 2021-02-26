package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final class zzfg implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzfh zzb;

    zzfg(zzfh zzfh, boolean z) {
        this.zzb = zzfh;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzb.zza(this.zza);
    }
}
