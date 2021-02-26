package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final class zzgs implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzgc zzb;

    zzgs(zzgc zzgc, zzn zzn) {
        this.zzb = zzgc;
        this.zza = zzn;
    }

    public final void run() {
        this.zzb.zza.zzr();
        this.zzb.zza.zzb(this.zza);
    }
}
