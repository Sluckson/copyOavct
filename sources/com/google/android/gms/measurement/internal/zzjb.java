package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzmb;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzjb implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zziv zzc;

    zzjb(zziv zziv, AtomicReference atomicReference, zzn zzn) {
        this.zzc = zziv;
        this.zza = atomicReference;
        this.zzb = zzn;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                if (!zzmb.zzb() || !this.zzc.zzs().zza(zzat.zzco) || this.zzc.zzr().zzw().zze()) {
                    zzep zzd = this.zzc.zzb;
                    if (zzd == null) {
                        this.zzc.zzq().zze().zza("Failed to get app instance id");
                        this.zza.notify();
                        return;
                    }
                    this.zza.set(zzd.zzc(this.zzb));
                    String str = (String) this.zza.get();
                    if (str != null) {
                        this.zzc.zze().zza(str);
                        this.zzc.zzr().zzj.zza(str);
                    }
                    this.zzc.zzaj();
                    this.zza.notify();
                } else {
                    this.zzc.zzq().zzj().zza("Analytics storage consent denied; will not get app instance id");
                    this.zzc.zze().zza((String) null);
                    this.zzc.zzr().zzj.zza((String) null);
                    this.zza.set((Object) null);
                    this.zza.notify();
                }
            } catch (RemoteException e) {
                try {
                    this.zzc.zzq().zze().zza("Failed to get app instance id", e);
                    this.zza.notify();
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
