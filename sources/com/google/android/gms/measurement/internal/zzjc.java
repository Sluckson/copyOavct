package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzjc implements Runnable {
    private final /* synthetic */ zzin zza;
    private final /* synthetic */ zziv zzb;

    zzjc(zziv zziv, zzin zzin) {
        this.zzb = zziv;
        this.zza = zzin;
    }

    public final void run() {
        zzep zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzq().zze().zza("Failed to send current screen to service");
            return;
        }
        try {
            if (this.zza == null) {
                zzd.zza(0, (String) null, (String) null, this.zzb.zzm().getPackageName());
            } else {
                zzd.zza(this.zza.zzc, this.zza.zza, this.zza.zzb, this.zzb.zzm().getPackageName());
            }
            this.zzb.zzaj();
        } catch (RemoteException e) {
            this.zzb.zzq().zze().zza("Failed to send current screen to the service", e);
        }
    }
}
