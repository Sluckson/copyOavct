package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzhq implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzhe zzb;

    zzhq(zzhe zzhe, Bundle bundle) {
        this.zzb = zzhe;
        this.zza = bundle;
    }

    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
