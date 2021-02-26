package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final class zzgq implements Runnable {
    private final /* synthetic */ zzkw zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzgc zzc;

    zzgq(zzgc zzgc, zzkw zzkw, zzn zzn) {
        this.zzc = zzgc;
        this.zza = zzkw;
        this.zzb = zzn;
    }

    public final void run() {
        this.zzc.zza.zzr();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzb(this.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}
