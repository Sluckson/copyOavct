package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzhr implements Runnable {
    private final /* synthetic */ zzhd zza;
    private final /* synthetic */ zzhe zzb;

    zzhr(zzhe zzhe, zzhd zzhd) {
        this.zzb = zzhe;
        this.zza = zzhd;
    }

    public final void run() {
        this.zzb.zza(this.zza);
    }
}
