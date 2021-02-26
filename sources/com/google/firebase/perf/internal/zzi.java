package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p010firebaseperf.zzcg;
import com.google.android.gms.internal.p010firebaseperf.zzcx;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzi implements Runnable {
    private final /* synthetic */ zzcg zzdl;
    private final /* synthetic */ zzd zzdm;
    private final /* synthetic */ zzcx zzdo;

    zzi(zzd zzd, zzcx zzcx, zzcg zzcg) {
        this.zzdm = zzd;
        this.zzdo = zzcx;
        this.zzdl = zzcg;
    }

    public final void run() {
        this.zzdm.zzb(this.zzdo, this.zzdl);
    }
}
