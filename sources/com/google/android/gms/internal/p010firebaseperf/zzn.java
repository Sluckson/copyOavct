package com.google.android.gms.internal.p010firebaseperf;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzn */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public abstract class zzn<E> extends zzk<E> implements Set<E> {
    @NullableDecl
    private transient zzj<E> zzf;

    zzn() {
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        return zzw.zza(this, obj);
    }

    public int hashCode() {
        return zzw.zza(this);
    }

    public zzj<E> zzc() {
        zzj<E> zzj = this.zzf;
        if (zzj != null) {
            return zzj;
        }
        zzj<E> zzh = zzh();
        this.zzf = zzh;
        return zzh;
    }

    /* access modifiers changed from: package-private */
    public zzj<E> zzh() {
        return zzj.zza(toArray());
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
