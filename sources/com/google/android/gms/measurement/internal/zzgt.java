package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final class zzgt implements Callable<List<zzky>> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzgc zzb;

    zzgt(zzgc zzgc, zzn zzn) {
        this.zzb = zzgc;
        this.zza = zzn;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzb.zza.zzr();
        return this.zzb.zza.zze().zza(this.zza.zza);
    }
}
