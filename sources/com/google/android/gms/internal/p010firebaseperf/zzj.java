package com.google.android.gms.internal.p010firebaseperf;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzj */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public abstract class zzj<E> extends zzk<E> implements List<E>, RandomAccess {
    private static final zzy<Object> zzb = new zzm(zzq.zzn, 0);

    public static <E> zzj<E> zza() {
        return zzq.zzn;
    }

    public final zzj<E> zzc() {
        return this;
    }

    public static <E> zzj<E> zza(Collection<? extends E> collection) {
        if (collection instanceof zzk) {
            zzj<E> zzc = ((zzk) collection).zzc();
            if (!zzc.zzg()) {
                return zzc;
            }
            Object[] array = zzc.toArray();
            int length = array.length;
            if (length == 0) {
                return zzq.zzn;
            }
            return new zzq(array, length);
        }
        Object[] array2 = collection.toArray();
        int length2 = array2.length;
        int i = 0;
        while (i < length2) {
            if (array2[i] != null) {
                i++;
            } else {
                StringBuilder sb = new StringBuilder(20);
                sb.append("at index ");
                sb.append(i);
                throw new NullPointerException(sb.toString());
            }
        }
        int length3 = array2.length;
        if (length3 == 0) {
            return zzq.zzn;
        }
        return new zzq(array2, length3);
    }

    static <E> zzj<E> zza(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return zzq.zzn;
        }
        return new zzq(objArr, length);
    }

    zzj() {
    }

    public final zzv<E> zzb() {
        return (zzy) listIterator();
    }

    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            int size = size();
            int i = 0;
            if (obj == null) {
                while (i < size) {
                    if (get(i) == null) {
                        return i;
                    }
                    i++;
                }
            } else {
                while (i < size) {
                    if (obj.equals(get(i))) {
                        return i;
                    }
                    i++;
                }
            }
            return -1;
        }
        ListIterator listIterator = listIterator();
        while (listIterator.hasNext()) {
            if (zze.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            if (obj == null) {
                for (int size = size() - 1; size >= 0; size--) {
                    if (get(size) == null) {
                        return size;
                    }
                }
            } else {
                for (int size2 = size() - 1; size2 >= 0; size2--) {
                    if (obj.equals(get(size2))) {
                        return size2;
                    }
                }
            }
            return -1;
        }
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (zze.equal(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    /* renamed from: zzc */
    public zzj<E> subList(int i, int i2) {
        zzd.zza(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzq.zzn;
        }
        return new zzl(this, i, i3);
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzd.checkNotNull(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (!(this instanceof RandomAccess) || !(list instanceof RandomAccess)) {
                    zzj zzj = this;
                    int size2 = zzj.size();
                    Iterator it = list.iterator();
                    int i = 0;
                    while (true) {
                        if (i < size2) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Object obj2 = zzj.get(i);
                            i++;
                            if (!zze.equal(obj2, it.next())) {
                                break;
                            }
                        } else if (!it.hasNext()) {
                            return true;
                        }
                    }
                } else {
                    int i2 = 0;
                    while (i2 < size) {
                        if (zze.equal(get(i2), list.get(i2))) {
                            i2++;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        zzd.zzb(i, size());
        if (isEmpty()) {
            return zzb;
        }
        return new zzm(this, i);
    }

    public /* synthetic */ ListIterator listIterator() {
        return (zzy) listIterator(0);
    }
}
