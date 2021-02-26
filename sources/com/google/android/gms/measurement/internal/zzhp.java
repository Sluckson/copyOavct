package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzhp implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzhe zzc;

    zzhp(zzhe zzhe, AtomicReference atomicReference, boolean z) {
        this.zzc = zzhe;
        this.zza = atomicReference;
        this.zzb = z;
    }

    public final void run() {
        this.zzc.zzg().zza((AtomicReference<List<zzkw>>) this.zza, this.zzb);
    }
}
