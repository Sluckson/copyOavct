package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final class zzgo implements Runnable {
    private final /* synthetic */ zzar zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzgc zzc;

    zzgo(zzgc zzgc, zzar zzar, String str) {
        this.zzc = zzgc;
        this.zza = zzar;
        this.zzb = str;
    }

    public final void run() {
        this.zzc.zza.zzr();
        this.zzc.zza.zza(this.zza, this.zzb);
    }
}
