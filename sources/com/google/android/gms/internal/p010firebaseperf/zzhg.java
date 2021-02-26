package com.google.android.gms.internal.p010firebaseperf;

import java.util.Arrays;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhg */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzhg<E> extends zzed<E> implements RandomAccess {
    private static final zzhg<Object> zzud;
    private int size;
    private E[] zzo;

    public static <E> zzhg<E> zzis() {
        return zzud;
    }

    zzhg() {
        this(new Object[10], 0);
    }

    private zzhg(E[] eArr, int i) {
        this.zzo = eArr;
        this.size = i;
    }

    public final boolean add(E e) {
        zzgl();
        int i = this.size;
        E[] eArr = this.zzo;
        if (i == eArr.length) {
            this.zzo = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzo;
        int i2 = this.size;
        this.size = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }

    public final void add(int i, E e) {
        int i2;
        zzgl();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzan(i));
        }
        E[] eArr = this.zzo;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = new Object[(((i2 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.zzo, i, eArr2, i + 1, this.size - i);
            this.zzo = eArr2;
        }
        this.zzo[i] = e;
        this.size++;
        this.modCount++;
    }

    public final E get(int i) {
        zzam(i);
        return this.zzo[i];
    }

    public final E remove(int i) {
        zzgl();
        zzam(i);
        E[] eArr = this.zzo;
        E e = eArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return e;
    }

    public final E set(int i, E e) {
        zzgl();
        zzam(i);
        E[] eArr = this.zzo;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.size;
    }

    private final void zzam(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzan(i));
        }
    }

    private final String zzan(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ zzfp zzao(int i) {
        if (i >= this.size) {
            return new zzhg(Arrays.copyOf(this.zzo, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    static {
        zzhg<Object> zzhg = new zzhg<>(new Object[0], 0);
        zzud = zzhg;
        zzhg.zzgk();
    }
}
