package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final class zzko implements Runnable {
    private final /* synthetic */ zzku zza;
    private final /* synthetic */ zzkp zzb;

    zzko(zzkp zzkp, zzku zzku) {
        this.zzb = zzkp;
        this.zza = zzku;
    }

    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
