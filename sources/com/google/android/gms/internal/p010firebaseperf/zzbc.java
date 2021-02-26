package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbc */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final /* synthetic */ class zzbc implements Runnable {
    private final zzba zzbm;
    private final zzbw zzbn;

    zzbc(zzba zzba, zzbw zzbw) {
        this.zzbm = zzba;
        this.zzbn = zzbw;
    }

    public final void run() {
        this.zzbm.zzd(this.zzbn);
    }
}
