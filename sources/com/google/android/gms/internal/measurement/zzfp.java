package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzfp<K> extends zzff<K> {
    private final transient zzfb<K, ?> zza;
    private final transient zzew<K> zzb;

    zzfp(zzfb<K, ?> zzfb, zzew<K> zzew) {
        this.zza = zzfb;
        this.zzb = zzew;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return true;
    }

    public final zzfs<K> zzb() {
        return (zzfs) zzc().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zzb(Object[] objArr, int i) {
        return zzc().zzb(objArr, i);
    }

    public final zzew<K> zzc() {
        return this.zzb;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.get(obj) != null;
    }

    public final int size() {
        return this.zza.size();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
