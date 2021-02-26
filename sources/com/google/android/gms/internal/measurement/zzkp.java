package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
final class zzkp extends zzkn<zzkq, zzkq> {
    zzkp() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzjw zzjw) {
        return false;
    }

    private static void zza(Object obj, zzkq zzkq) {
        ((zzhv) obj).zzb = zzkq;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(Object obj) {
        ((zzhv) obj).zzb.zzc();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzf(Object obj) {
        return ((zzkq) obj).zze();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zze(Object obj) {
        return ((zzkq) obj).zzd();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(Object obj, Object obj2) {
        zzkq zzkq = (zzkq) obj;
        zzkq zzkq2 = (zzkq) obj2;
        if (zzkq2.equals(zzkq.zza())) {
            return zzkq;
        }
        return zzkq.zza(zzkq, zzkq2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, zzlk zzlk) throws IOException {
        ((zzkq) obj).zza(zzlk);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzlk zzlk) throws IOException {
        ((zzkq) obj).zzb(zzlk);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, Object obj2) {
        zza(obj, (zzkq) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(Object obj) {
        zzkq zzkq = ((zzhv) obj).zzb;
        if (zzkq != zzkq.zza()) {
            return zzkq;
        }
        zzkq zzb = zzkq.zzb();
        zza(obj, zzb);
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzb(Object obj) {
        return ((zzhv) obj).zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zza(Object obj, Object obj2) {
        zza(obj, (zzkq) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(Object obj) {
        zzkq zzkq = (zzkq) obj;
        zzkq.zzc();
        return zzkq;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza() {
        return zzkq.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzkq) obj).zza((i << 3) | 3, (Object) (zzkq) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, zzgm zzgm) {
        ((zzkq) obj).zza((i << 3) | 2, (Object) zzgm);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzkq) obj).zza((i << 3) | 1, (Object) Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, int i2) {
        ((zzkq) obj).zza((i << 3) | 5, (Object) Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzkq) obj).zza(i << 3, (Object) Long.valueOf(j));
    }
}
