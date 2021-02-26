package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzel */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzel extends zzeo {
    private final int zzne;
    private final int zznf;

    zzel(byte[] bArr, int i, int i2) {
        super(bArr);
        zzc(i, i + i2, bArr.length);
        this.zzne = i;
        this.zznf = i2;
    }

    public final byte zzq(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zznh[this.zzne + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: package-private */
    public final byte zzr(int i) {
        return this.zznh[this.zzne + i];
    }

    public final int size() {
        return this.zznf;
    }

    /* access modifiers changed from: protected */
    public final int zzgp() {
        return this.zzne;
    }
}
