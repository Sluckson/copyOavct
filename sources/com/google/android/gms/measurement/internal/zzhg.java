package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final /* synthetic */ class zzhg implements Runnable {
    private final zzhe zza;

    zzhg(zzhe zzhe) {
        this.zza = zzhe;
    }

    public final void run() {
        zzhe zzhe = this.zza;
        zzhe.zzc();
        if (zzhe.zzr().zzs.zza()) {
            zzhe.zzq().zzv().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long zza2 = zzhe.zzr().zzt.zza();
        zzhe.zzr().zzt.zza(1 + zza2);
        if (zza2 >= 5) {
            zzhe.zzq().zzh().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzhe.zzr().zzs.zza(true);
            return;
        }
        zzhe.zzy.zzag();
    }
}
