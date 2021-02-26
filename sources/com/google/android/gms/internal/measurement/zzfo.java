package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzfo extends zzew<Object> {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzfo(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return true;
    }

    public final Object get(int i) {
        zzdw.zza(i, this.zzc);
        return this.zza[(i * 2) + this.zzb];
    }

    public final int size() {
        return this.zzc;
    }
}
