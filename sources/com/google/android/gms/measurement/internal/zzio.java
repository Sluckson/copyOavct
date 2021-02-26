package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzio implements Runnable {
    private final /* synthetic */ zzin zza;
    private final /* synthetic */ zzin zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzim zze;

    zzio(zzim zzim, zzin zzin, zzin zzin2, long j, boolean z) {
        this.zze = zzim;
        this.zza = zzin;
        this.zzb = zzin2;
        this.zzc = j;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
