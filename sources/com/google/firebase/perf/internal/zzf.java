package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p010firebaseperf.zzcg;
import com.google.android.gms.internal.p010firebaseperf.zzdm;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzf implements Runnable {
    private final /* synthetic */ zzdm zzdk;
    private final /* synthetic */ zzcg zzdl;
    private final /* synthetic */ zzd zzdm;

    zzf(zzd zzd, zzdm zzdm2, zzcg zzcg) {
        this.zzdm = zzd;
        this.zzdk = zzdm2;
        this.zzdl = zzcg;
    }

    public final void run() {
        this.zzdm.zzb(this.zzdk, this.zzdl);
    }
}
