package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final class zzgh implements Runnable {
    private final /* synthetic */ zzw zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzgc zzc;

    zzgh(zzgc zzgc, zzw zzw, zzn zzn) {
        this.zzc = zzgc;
        this.zza = zzw;
        this.zzb = zzn;
    }

    public final void run() {
        this.zzc.zza.zzr();
        if (this.zza.zzc.zza() == null) {
            this.zzc.zza.zzb(this.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}
