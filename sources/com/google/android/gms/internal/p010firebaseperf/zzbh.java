package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbh */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final /* synthetic */ class zzbh implements Runnable {
    private final zzbw zzbn;
    private final zzbf zzbo;

    zzbh(zzbf zzbf, zzbw zzbw) {
        this.zzbo = zzbf;
        this.zzbn = zzbw;
    }

    public final void run() {
        this.zzbo.zzh(this.zzbn);
    }
}
