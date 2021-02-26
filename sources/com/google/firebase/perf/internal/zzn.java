package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p010firebaseperf.zzcg;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final /* synthetic */ class zzn implements Runnable {
    private final GaugeManager zzdt;
    private final String zzdu;
    private final zzcg zzdv;

    zzn(GaugeManager gaugeManager, String str, zzcg zzcg) {
        this.zzdt = gaugeManager;
        this.zzdu = str;
        this.zzdv = zzcg;
    }

    public final void run() {
        this.zzdt.zzd(this.zzdu, this.zzdv);
    }
}
