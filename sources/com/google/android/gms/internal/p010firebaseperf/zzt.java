package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzt */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzt extends zzj<Object> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zzm;

    zzt(Object[] objArr, int i, int i2) {
        this.zzm = objArr;
        this.offset = i;
        this.size = i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return true;
    }

    public final Object get(int i) {
        zzd.zza(i, this.size);
        return this.zzm[(i * 2) + this.offset];
    }

    public final int size() {
        return this.size;
    }
}
