package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzjo implements Runnable {
    private final /* synthetic */ zzep zza;
    private final /* synthetic */ zzjp zzb;

    zzjo(zzjp zzjp, zzep zzep) {
        this.zzb = zzjp;
        this.zza = zzep;
    }

    public final void run() {
        synchronized (this.zzb) {
            boolean unused = this.zzb.zzb = false;
            if (!this.zzb.zza.zzaa()) {
                this.zzb.zza.zzq().zzw().zza("Connected to service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
