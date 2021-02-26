package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final class zzgr implements Callable<byte[]> {
    private final /* synthetic */ zzar zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzgc zzc;

    zzgr(zzgc zzgc, zzar zzar, String str) {
        this.zzc = zzgc;
        this.zza = zzar;
        this.zzb = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzc.zza.zzr();
        return this.zzc.zza.zzg().zza(this.zza, this.zzb);
    }
}
