package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzkf implements Runnable {
    long zza;
    long zzb;
    final /* synthetic */ zzkc zzc;

    zzkf(zzkc zzkc, long j, long j2) {
        this.zzc = zzkc;
        this.zza = j;
        this.zzb = j2;
    }

    public final void run() {
        this.zzc.zza.zzp().zza((Runnable) new zzke(this));
    }
}
