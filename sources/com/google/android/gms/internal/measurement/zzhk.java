package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhq;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
abstract class zzhk<T extends zzhq<T>> {
    zzhk() {
    }

    /* access modifiers changed from: package-private */
    public abstract int zza(Map.Entry<?, ?> entry);

    /* access modifiers changed from: package-private */
    public abstract zzho<T> zza(Object obj);

    /* access modifiers changed from: package-private */
    public abstract Object zza(zzhi zzhi, zzjg zzjg, int i);

    /* access modifiers changed from: package-private */
    public abstract <UT, UB> UB zza(zzjw zzjw, Object obj, zzhi zzhi, zzho<T> zzho, UB ub, zzkn<UT, UB> zzkn) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(zzgm zzgm, Object obj, zzhi zzhi, zzho<T> zzho) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(zzjw zzjw, Object obj, zzhi zzhi, zzho<T> zzho) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(zzlk zzlk, Map.Entry<?, ?> entry) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract boolean zza(zzjg zzjg);

    /* access modifiers changed from: package-private */
    public abstract zzho<T> zzb(Object obj);

    /* access modifiers changed from: package-private */
    public abstract void zzc(Object obj);
}
