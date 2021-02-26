package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zziz implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zziv zzd;

    zziz(zziv zziv, AtomicReference atomicReference, zzn zzn, boolean z) {
        this.zzd = zziv;
        this.zza = atomicReference;
        this.zzb = zzn;
        this.zzc = z;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                zzep zzd2 = this.zzd.zzb;
                if (zzd2 == null) {
                    this.zzd.zzq().zze().zza("Failed to get all user properties; not connected to service");
                    this.zza.notify();
                    return;
                }
                this.zza.set(zzd2.zza(this.zzb, this.zzc));
                this.zzd.zzaj();
                this.zza.notify();
            } catch (RemoteException e) {
                try {
                    this.zzd.zzq().zze().zza("Failed to get all user properties; remote exception", e);
                    this.zza.notify();
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
