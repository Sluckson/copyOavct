package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p010firebaseperf.zzcg;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final /* synthetic */ class zzp implements Runnable {
    private final GaugeManager zzdt;
    private final String zzdu;
    private final zzcg zzdv;

    zzp(GaugeManager gaugeManager, String str, zzcg zzcg) {
        this.zzdt = gaugeManager;
        this.zzdu = str;
        this.zzdv = zzcg;
    }

    public final void run() {
        this.zzdt.zzc(this.zzdu, this.zzdv);
    }
}
