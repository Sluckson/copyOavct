package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zziw implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzkw zzb;
    private final /* synthetic */ zzn zzc;
    private final /* synthetic */ zziv zzd;

    zziw(zziv zziv, boolean z, zzkw zzkw, zzn zzn) {
        this.zzd = zziv;
        this.zza = z;
        this.zzb = zzkw;
        this.zzc = zzn;
    }

    public final void run() {
        zzep zzd2 = this.zzd.zzb;
        if (zzd2 == null) {
            this.zzd.zzq().zze().zza("Discarding data. Failed to set user property");
            return;
        }
        this.zzd.zza(zzd2, (AbstractSafeParcelable) this.zza ? null : this.zzb, this.zzc);
        this.zzd.zzaj();
    }
}
