package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p010firebaseperf.zzcg;
import com.google.android.gms.internal.p010firebaseperf.zzcq;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzh implements Runnable {
    private final /* synthetic */ zzcg zzdl;
    private final /* synthetic */ zzd zzdm;
    private final /* synthetic */ zzcq zzdn;

    zzh(zzd zzd, zzcq zzcq, zzcg zzcg) {
        this.zzdm = zzd;
        this.zzdn = zzcq;
        this.zzdl = zzcg;
    }

    public final void run() {
        this.zzdm.zzb(this.zzdn, this.zzdl);
    }
}
