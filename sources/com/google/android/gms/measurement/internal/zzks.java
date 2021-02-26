package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzmb;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final class zzks implements Callable<String> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzkp zzb;

    zzks(zzkp zzkp, zzn zzn) {
        this.zzb = zzkp;
        this.zza = zzn;
    }

    public final /* synthetic */ Object call() throws Exception {
        if (!zzmb.zzb() || !this.zzb.zzb().zza(zzat.zzcp) || (this.zzb.zza(this.zza.zza).zze() && zzad.zza(this.zza.zzw).zze())) {
            zzf zzc = this.zzb.zzc(this.zza);
            if (zzc != null) {
                return zzc.zzd();
            }
            this.zzb.zzq().zzh().zza("App info was null when attempting to get app instance id");
            return null;
        }
        this.zzb.zzq().zzw().zza("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
