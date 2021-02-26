package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzit implements Runnable {
    private final /* synthetic */ zzin zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzim zzc;

    zzit(zzim zzim, zzin zzin, long j) {
        this.zzc = zzim;
        this.zza = zzin;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zza(this.zza, false, this.zzb);
        zzim zzim = this.zzc;
        zzim.zza = null;
        zzim.zzg().zza((zzin) null);
    }
}
