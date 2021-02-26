package com.google.android.gms.internal.p010firebaseperf;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzk */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public abstract class zzk<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzc = new Object[0];

    zzk() {
    }

    public abstract boolean contains(@NullableDecl Object obj);

    /* renamed from: zzb */
    public abstract zzv<E> iterator();

    /* access modifiers changed from: package-private */
    @NullableDecl
    public Object[] zzd() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean zzg();

    public final Object[] toArray() {
        return toArray(zzc);
    }

    public final <T> T[] toArray(T[] tArr) {
        zzd.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzd = zzd();
            if (zzd != null) {
                return Arrays.copyOfRange(zzd, zze(), zzf(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: package-private */
    public int zze() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zzf() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public zzj<E> zzc() {
        return isEmpty() ? zzj.zza() : zzj.zza(toArray());
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        zzv zzv = (zzv) iterator();
        while (zzv.hasNext()) {
            objArr[i] = zzv.next();
            i++;
        }
        return i;
    }
}
