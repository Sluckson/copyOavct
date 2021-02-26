package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzw;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzix implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzn zzd;
    private final /* synthetic */ zzw zze;
    private final /* synthetic */ zziv zzf;

    zzix(zziv zziv, String str, String str2, boolean z, zzn zzn, zzw zzw) {
        this.zzf = zziv;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = zzn;
        this.zze = zzw;
    }

    public final void run() {
        Bundle bundle = new Bundle();
        try {
            zzep zzd2 = this.zzf.zzb;
            if (zzd2 == null) {
                this.zzf.zzq().zze().zza("Failed to get user properties; not connected to service", this.zza, this.zzb);
                return;
            }
            bundle = zzkx.zza(zzd2.zza(this.zza, this.zzb, this.zzc, this.zzd));
            this.zzf.zzaj();
            this.zzf.zzo().zza(this.zze, bundle);
        } catch (RemoteException e) {
            this.zzf.zzq().zze().zza("Failed to get user properties; remote exception", this.zza, e);
        } finally {
            this.zzf.zzo().zza(this.zze, bundle);
        }
    }
}
