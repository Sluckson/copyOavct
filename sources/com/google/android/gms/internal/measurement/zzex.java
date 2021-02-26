package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public abstract class zzex<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zza = new Object[0];

    zzex() {
    }

    public abstract boolean contains(@NullableDecl Object obj);

    /* renamed from: zzb */
    public abstract zzfs<E> iterator();

    /* access modifiers changed from: package-private */
    @NullableDecl
    public Object[] zzd() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean zzg();

    public final Object[] toArray() {
        return toArray(zza);
    }

    public final <T> T[] toArray(T[] tArr) {
        zzdw.zza(tArr);
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
        zzb(tArr, 0);
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

    public zzew<E> zzc() {
        return isEmpty() ? zzew.zza() : zzew.zza(toArray());
    }

    /* access modifiers changed from: package-private */
    public int zzb(Object[] objArr, int i) {
        zzfs zzfs = (zzfs) iterator();
        while (zzfs.hasNext()) {
            objArr[i] = zzfs.next();
            i++;
        }
        return i;
    }
}
