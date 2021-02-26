package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzeq */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public abstract class zzeq {
    private int zzni;
    private int zznj;
    private boolean zznk;

    static zzeq zza(byte[] bArr, int i, int i2, boolean z) {
        zzes zzes = new zzes(bArr, 0, i2, false);
        try {
            zzes.zzt(i2);
            return zzes;
        } catch (zzfs e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract int zzgs();

    public abstract int zzt(int i) throws zzfs;

    private zzeq() {
        this.zzni = 100;
        this.zznj = Integer.MAX_VALUE;
        this.zznk = false;
    }
}
