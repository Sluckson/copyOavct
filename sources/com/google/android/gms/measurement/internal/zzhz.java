package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzhz implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzhe zzb;

    zzhz(zzhe zzhe, AtomicReference atomicReference) {
        this.zzb = zzhe;
        this.zza = atomicReference;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Double.valueOf(this.zzb.zzs().zzc(this.zzb.zzf().zzaa(), zzat.zzan)));
                this.zza.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
