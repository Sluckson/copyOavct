package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final /* synthetic */ class zzke implements Runnable {
    private final zzkf zza;

    zzke(zzkf zzkf) {
        this.zza = zzkf;
    }

    public final void run() {
        zzkf zzkf = this.zza;
        zzkc zzkc = zzkf.zzc;
        long j = zzkf.zza;
        long j2 = zzkf.zzb;
        zzkc.zza.zzc();
        zzkc.zza.zzq().zzv().zza("Application going to the background");
        boolean z = true;
        if (zzkc.zza.zzs().zza(zzat.zzbw)) {
            zzkc.zza.zzr().zzr.zza(true);
        }
        Bundle bundle = new Bundle();
        if (!zzkc.zza.zzs().zzh().booleanValue()) {
            zzkc.zza.zzb.zzb(j2);
            if (zzkc.zza.zzs().zza(zzat.zzbn)) {
                bundle.putLong("_et", zzkc.zza.zza(j2));
                zzim.zza(zzkc.zza.zzh().zza(true), bundle, true);
            } else {
                z = false;
            }
            zzkc.zza.zza(false, z, j2);
        }
        zzkc.zza.zze().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ab", j, bundle);
    }
}
