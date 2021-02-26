package com.google.android.gms.internal.p010firebaseperf;

import com.lowagie.text.pdf.codec.wmf.MetaDo;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhz */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzhz {
    private static final zzhz zzuw = new zzhz(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzmw;
    private int zzqw;
    private Object[] zztg;
    private int[] zzux;

    public static zzhz zzjg() {
        return zzuw;
    }

    static zzhz zza(zzhz zzhz, zzhz zzhz2) {
        int i = zzhz.count + zzhz2.count;
        int[] copyOf = Arrays.copyOf(zzhz.zzux, i);
        System.arraycopy(zzhz2.zzux, 0, copyOf, zzhz.count, zzhz2.count);
        Object[] copyOf2 = Arrays.copyOf(zzhz.zztg, i);
        System.arraycopy(zzhz2.zztg, 0, copyOf2, zzhz.count, zzhz2.count);
        return new zzhz(i, copyOf, copyOf2, true);
    }

    private zzhz() {
        this(0, new int[8], new Object[8], true);
    }

    private zzhz(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzqw = -1;
        this.count = i;
        this.zzux = iArr;
        this.zztg = objArr;
        this.zzmw = z;
    }

    public final void zzgk() {
        this.zzmw = false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zziu zziu) throws IOException {
        if (zziu.zzgx() == zzhe.zzub) {
            for (int i = this.count - 1; i >= 0; i--) {
                zziu.zza(this.zzux[i] >>> 3, this.zztg[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zziu.zza(this.zzux[i2] >>> 3, this.zztg[i2]);
        }
    }

    public final void zzb(zziu zziu) throws IOException {
        if (this.count != 0) {
            if (zziu.zzgx() == zzhe.zzua) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzux[i], this.zztg[i], zziu);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzux[i2], this.zztg[i2], zziu);
            }
        }
    }

    private static void zzb(int i, Object obj, zziu zziu) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zziu.zzi(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zziu.zzc(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zziu.zza(i2, (zzee) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zziu.zzh(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzfs.zzht());
        } else if (zziu.zzgx() == zzhe.zzua) {
            zziu.zzai(i2);
            ((zzhz) obj).zzb(zziu);
            zziu.zzaj(i2);
        } else {
            zziu.zzaj(i2);
            ((zzhz) obj).zzb(zziu);
            zziu.zzai(i2);
        }
    }

    public final int zzjh() {
        int i = this.zzqw;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzev.zzd(this.zzux[i3] >>> 3, (zzee) this.zztg[i3]);
        }
        this.zzqw = i2;
        return i2;
    }

    public final int getSerializedSize() {
        int i;
        int i2 = this.zzqw;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzux[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzev.zze(i6, ((Long) this.zztg[i4]).longValue());
            } else if (i7 == 1) {
                i = zzev.zzg(i6, ((Long) this.zztg[i4]).longValue());
            } else if (i7 == 2) {
                i = zzev.zzc(i6, (zzee) this.zztg[i4]);
            } else if (i7 == 3) {
                i = (zzev.zzy(i6) << 1) + ((zzhz) this.zztg[i4]).getSerializedSize();
            } else if (i7 == 5) {
                i = zzev.zzl(i6, ((Integer) this.zztg[i4]).intValue());
            } else {
                throw new IllegalStateException(zzfs.zzht());
            }
            i3 += i;
        }
        this.zzqw = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhz)) {
            return false;
        }
        zzhz zzhz = (zzhz) obj;
        int i = this.count;
        if (i == zzhz.count) {
            int[] iArr = this.zzux;
            int[] iArr2 = zzhz.zzux;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.zztg;
                Object[] objArr2 = zzhz.zztg;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = this.count;
        int i2 = (i + MetaDo.META_OFFSETWINDOWORG) * 31;
        int[] iArr = this.zzux;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zztg;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzgt.zza(sb, i, String.valueOf(this.zzux[i2] >>> 3), this.zztg[i2]);
        }
    }
}
