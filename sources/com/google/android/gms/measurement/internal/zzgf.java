package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final /* synthetic */ class zzgf implements Runnable {
    private final zzgc zza;
    private final zzn zzb;
    private final Bundle zzc;

    zzgf(zzgc zzgc, zzn zzn, Bundle bundle) {
        this.zza = zzgc;
        this.zzb = zzn;
        this.zzc = bundle;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc);
    }
}
