package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzjj implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zziv zzb;

    zzjj(zziv zziv, zzn zzn) {
        this.zzb = zziv;
        this.zza = zzn;
    }

    public final void run() {
        zzep zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzq().zze().zza("Failed to send consent settings to service");
            return;
        }
        try {
            zzd.zze(this.zza);
            this.zzb.zzaj();
        } catch (RemoteException e) {
            this.zzb.zzq().zze().zza("Failed to send consent settings to the service", e);
        }
    }
}
