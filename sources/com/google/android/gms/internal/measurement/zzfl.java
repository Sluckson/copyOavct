package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzfl<E> extends zzew<E> {
    static final zzew<Object> zza = new zzfl(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    zzfl(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
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
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzd() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zzf() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzb(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzc);
        return i + this.zzc;
    }

    public final E get(int i) {
        zzdw.zza(i, this.zzc);
        return this.zzb[i];
    }
}
