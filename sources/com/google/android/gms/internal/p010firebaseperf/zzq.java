package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzq */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzq<E> extends zzj<E> {
    static final zzj<Object> zzn = new zzq(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzo;

    zzq(Object[] objArr, int i) {
        this.zzo = objArr;
        this.size = i;
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return false;
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzd() {
        return this.zzo;
    }

    /* access modifiers changed from: package-private */
    public final int zzf() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzo, 0, objArr, i, this.size);
        return i + this.size;
    }

    public final E get(int i) {
        zzd.zza(i, this.size);
        return this.zzo[i];
    }
}
