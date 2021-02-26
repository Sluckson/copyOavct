package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zziy implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zziv zzb;

    zziy(zziv zziv, zzn zzn) {
        this.zzb = zziv;
        this.zza = zzn;
    }

    public final void run() {
        zzep zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzq().zze().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            zzd.zzd(this.zza);
        } catch (RemoteException e) {
            this.zzb.zzq().zze().zza("Failed to reset data on the service: remote exception", e);
        }
        this.zzb.zzaj();
    }
}
