package com.google.android.gms.internal.p010firebaseperf;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzl */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzl extends zzj<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzj zzd;

    zzl(zzj zzj, int i, int i2) {
        this.zzd = zzj;
        this.offset = i;
        this.length = i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return true;
    }

    public final int size() {
        return this.length;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzd() {
        return this.zzd.zzd();
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return this.zzd.zze() + this.offset;
    }

    /* access modifiers changed from: package-private */
    public final int zzf() {
        return this.zzd.zze() + this.offset + this.length;
    }

    public final E get(int i) {
        zzd.zza(i, this.length);
        return this.zzd.get(i + this.offset);
    }

    public final zzj<E> zzc(int i, int i2) {
        zzd.zza(i, i2, this.length);
        zzj zzj = this.zzd;
        int i3 = this.offset;
        return (zzj) zzj.subList(i + i3, i2 + i3);
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
