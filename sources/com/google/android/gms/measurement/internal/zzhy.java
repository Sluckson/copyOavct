package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzhy implements Runnable {
    private final /* synthetic */ Boolean zza;
    private final /* synthetic */ zzhe zzb;

    zzhy(zzhe zzhe, Boolean bool) {
        this.zzb = zzhe;
        this.zza = bool;
    }

    public final void run() {
        this.zzb.zza(this.zza, true);
    }
}
