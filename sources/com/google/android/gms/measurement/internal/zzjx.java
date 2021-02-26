package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final /* synthetic */ class zzjx implements Runnable {
    private final zzju zza;
    private final int zzb;
    private final zzex zzc;
    private final Intent zzd;

    zzjx(zzju zzju, int i, zzex zzex, Intent intent) {
        this.zza = zzju;
        this.zzb = i;
        this.zzc = zzex;
        this.zzd = intent;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd);
    }
}
