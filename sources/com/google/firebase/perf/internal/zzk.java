package com.google.firebase.perf.internal;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzk implements Runnable {
    private final /* synthetic */ zzd zzdm;
    private final /* synthetic */ boolean zzdq;

    zzk(zzd zzd, boolean z) {
        this.zzdm = zzd;
        this.zzdq = z;
    }

    public final void run() {
        this.zzdm.zzd(this.zzdq);
    }
}
