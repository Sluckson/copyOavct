package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzey extends zzew<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzew zzc;

    zzey(zzew zzew, int i, int i2) {
        this.zzc = zzew;
        this.zza = i;
        this.zzb = i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return true;
    }

    public final int size() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzd() {
        return this.zzc.zzd();
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return this.zzc.zze() + this.zza;
    }

    /* access modifiers changed from: package-private */
    public final int zzf() {
        return this.zzc.zze() + this.zza + this.zzb;
    }

    public final E get(int i) {
        zzdw.zza(i, this.zzb);
        return this.zzc.get(i + this.zza);
    }

    public final zzew<E> zza(int i, int i2) {
        zzdw.zza(i, i2, this.zzb);
        zzew zzew = this.zzc;
        int i3 = this.zza;
        return (zzew) zzew.subList(i + i3, i2 + i3);
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
