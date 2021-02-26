package com.google.android.gms.internal.p010firebaseperf;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzu */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzu<K> extends zzn<K> {
    private final transient zzj<K> zze;
    private final transient zzo<K, ?> zzq;

    zzu(zzo<K, ?> zzo, zzj<K> zzj) {
        this.zzq = zzo;
        this.zze = zzj;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return true;
    }

    public final zzv<K> zzb() {
        return (zzv) zzc().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzc().zza(objArr, i);
    }

    public final zzj<K> zzc() {
        return this.zze;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zzq.get(obj) != null;
    }

    public final int size() {
        return this.zzq.size();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
