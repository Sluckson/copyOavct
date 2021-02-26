package com.google.android.gms.internal.p010firebaseperf;

import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzeo */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
class zzeo extends zzep {
    protected final byte[] zznh;

    zzeo(byte[] bArr) {
        if (bArr != null) {
            this.zznh = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public int zzgp() {
        return 0;
    }

    public byte zzq(int i) {
        return this.zznh[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzr(int i) {
        return this.zznh[i];
    }

    public int size() {
        return this.zznh.length;
    }

    public final zzee zzd(int i, int i2) {
        int zzc = zzc(0, i2, size());
        if (zzc == 0) {
            return zzee.zzna;
        }
        return new zzel(this.zznh, zzgp(), zzc);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzef zzef) throws IOException {
        zzef.zza(this.zznh, zzgp(), size());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zznh, zzgp(), size(), charset);
    }

    public final boolean zzgn() {
        int zzgp = zzgp();
        return zzii.zzc(this.zznh, zzgp, size() + zzgp);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzee) || size() != ((zzee) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzeo)) {
            return obj.equals(this);
        }
        zzeo zzeo = (zzeo) obj;
        int zzgo = zzgo();
        int zzgo2 = zzeo.zzgo();
        if (zzgo == 0 || zzgo2 == 0 || zzgo == zzgo2) {
            return zza(zzeo, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzee zzee, int i, int i2) {
        if (i2 > zzee.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzee.size()) {
            int size2 = zzee.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzee instanceof zzeo)) {
            return zzee.zzd(0, i2).equals(zzd(0, i2));
        } else {
            zzeo zzeo = (zzeo) zzee;
            byte[] bArr = this.zznh;
            byte[] bArr2 = zzeo.zznh;
            int zzgp = zzgp() + i2;
            int zzgp2 = zzgp();
            int zzgp3 = zzeo.zzgp();
            while (zzgp2 < zzgp) {
                if (bArr[zzgp2] != bArr2[zzgp3]) {
                    return false;
                }
                zzgp2++;
                zzgp3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final int zzb(int i, int i2, int i3) {
        return zzfj.zza(i, this.zznh, zzgp(), i3);
    }
}
