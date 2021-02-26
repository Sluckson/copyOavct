package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzmb;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final class zzgm implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzgc zzb;

    zzgm(zzgc zzgc, zzn zzn) {
        this.zzb = zzgc;
        this.zza = zzn;
    }

    public final void run() {
        this.zzb.zza.zzr();
        zzkp zza2 = this.zzb.zza;
        zzn zzn = this.zza;
        if (zzmb.zzb() && zza2.zzb().zza(zzat.zzcp)) {
            zza2.zzp().zzc();
            zza2.zzn();
            Preconditions.checkNotEmpty(zzn.zza);
            zzad zza3 = zzad.zza(zzn.zzw);
            zzad zza4 = zza2.zza(zzn.zza);
            zza2.zza(zzn.zza, zza3);
            if (zza3.zza(zza4)) {
                zza2.zza(zzn);
            }
        }
    }
}
