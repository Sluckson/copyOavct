package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzho implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhe zzb;

    zzho(zzhe zzhe, long j) {
        this.zzb = zzhe;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zza(this.zza, true);
        this.zzb.zzg().zza((AtomicReference<String>) new AtomicReference());
    }
}
