package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzem */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzem {
    private final byte[] buffer;
    private final zzev zzng;

    private zzem(int i) {
        this.buffer = new byte[i];
        this.zzng = zzev.zza(this.buffer);
    }

    public final zzee zzgq() {
        this.zzng.zzgu();
        return new zzeo(this.buffer);
    }

    public final zzev zzgr() {
        return this.zzng;
    }

    /* synthetic */ zzem(int i, zzeh zzeh) {
        this(i);
    }
}
