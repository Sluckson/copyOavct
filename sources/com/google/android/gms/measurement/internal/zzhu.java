package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzhu implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zzhe zzf;

    zzhu(zzhe zzhe, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.zzf = zzhe;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z;
    }

    public final void run() {
        this.zzf.zzy.zzv().zza(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}
