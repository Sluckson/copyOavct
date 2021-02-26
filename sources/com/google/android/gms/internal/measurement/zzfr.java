package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzfr<E> extends zzff<E> {
    static final zzfr<Object> zza = new zzfr(new Object[0], 0, (Object[]) null, 0, 0);
    private final transient Object[] zzb;
    private final transient Object[] zzc;
    private final transient int zzd;
    private final transient int zze;
    private final transient int zzf;

    zzfr(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzb = objArr;
        this.zzc = objArr2;
        this.zzd = i2;
        this.zze = i;
        this.zzf = i3;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return false;
    }

    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.zzc;
        if (obj == null || objArr == null) {
            return false;
        }
        int zza2 = zzeu.zza(obj);
        while (true) {
            int i = zza2 & this.zzd;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zza2 = i + 1;
        }
    }

    public final int size() {
        return this.zzf;
    }

    public final zzfs<E> zzb() {
        return (zzfs) zzc().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzd() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zzf() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final int zzb(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzf);
        return i + this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final zzew<E> zzh() {
        return zzew.zza(this.zzb, this.zzf);
    }

    public final int hashCode() {
        return this.zze;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
