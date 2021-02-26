package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzjt implements Runnable {
    private final /* synthetic */ zzjp zza;

    zzjt(zzjp zzjp) {
        this.zza = zzjp;
    }

    public final void run() {
        this.zza.zza.zza(new ComponentName(this.zza.zza.zzm(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
