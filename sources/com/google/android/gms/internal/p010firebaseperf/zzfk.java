package com.google.android.gms.internal.p010firebaseperf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfk */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzfk extends zzed<Integer> implements zzfn, zzhb, RandomAccess {
    private static final zzfk zzrj;
    private int size;
    private int[] zzrk;

    public static zzfk zzhs() {
        return zzrj;
    }

    zzfk() {
        this(new int[10], 0);
    }

    private zzfk(int[] iArr, int i) {
        this.zzrk = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzgl();
        if (i2 >= i) {
            int[] iArr = this.zzrk;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfk)) {
            return super.equals(obj);
        }
        zzfk zzfk = (zzfk) obj;
        if (this.size != zzfk.size) {
            return false;
        }
        int[] iArr = zzfk.zzrk;
        for (int i = 0; i < this.size; i++) {
            if (this.zzrk[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzrk[i2];
        }
        return i;
    }

    /* renamed from: zzak */
    public final zzfn zzao(int i) {
        if (i >= this.size) {
            return new zzfk(Arrays.copyOf(this.zzrk, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final int getInt(int i) {
        zzam(i);
        return this.zzrk[i];
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zzrk[i] == intValue) {
                return i;
            }
        }
        return -1;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int size() {
        return this.size;
    }

    public final void zzal(int i) {
        zzgl();
        int i2 = this.size;
        int[] iArr = this.zzrk;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.zzrk = iArr2;
        }
        int[] iArr3 = this.zzrk;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr3[i3] = i;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzgl();
        zzfj.checkNotNull(collection);
        if (!(collection instanceof zzfk)) {
            return super.addAll(collection);
        }
        zzfk zzfk = (zzfk) collection;
        int i = zzfk.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzrk;
            if (i3 > iArr.length) {
                this.zzrk = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzfk.zzrk, 0, this.zzrk, this.size, zzfk.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzgl();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzrk[i]))) {
                int[] iArr = this.zzrk;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
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

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzgl();
        zzam(i);
        int[] iArr = this.zzrk;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzgl();
        zzam(i);
        int[] iArr = this.zzrk;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        zzgl();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzan(i));
        }
        int[] iArr = this.zzrk;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zzrk, i, iArr2, i + 1, this.size - i);
            this.zzrk = iArr2;
        }
        this.zzrk[i] = intValue;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zzal(((Integer) obj).intValue());
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzfk zzfk = new zzfk(new int[0], 0);
        zzrj = zzfk;
        zzfk.zzgk();
    }
}
