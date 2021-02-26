package com.google.android.gms.internal.p010firebaseperf;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzev */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public abstract class zzev extends zzef {
    private static final Logger logger = Logger.getLogger(zzev.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzno = zzig.zzji();
    zzex zznp;

    public static zzev zza(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zzaa(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzac(int i) {
        return 4;
    }

    public static int zzad(int i) {
        return 4;
    }

    private static int zzag(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int zzau(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int zzaw(long j) {
        return 8;
    }

    public static int zzax(long j) {
        return 8;
    }

    private static long zzay(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzb(double d) {
        return 8;
    }

    public static int zzc(float f) {
        return 4;
    }

    public static int zzg(boolean z) {
        return 1;
    }

    public abstract void writeTag(int i, int i2) throws IOException;

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzee zzee) throws IOException;

    public abstract void zza(int i, zzgs zzgs) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(int i, zzgs zzgs, zzhi zzhi) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(int i, boolean z) throws IOException;

    public abstract void zza(zzee zzee) throws IOException;

    public abstract void zzak(String str) throws IOException;

    public abstract void zzaq(long j) throws IOException;

    public abstract void zzas(long j) throws IOException;

    public abstract void zzb(int i, zzee zzee) throws IOException;

    public abstract void zzb(zzgs zzgs) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzb(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzc(byte b) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zze(int i, int i2) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract int zzgt();

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzu(int i) throws IOException;

    public abstract void zzv(int i) throws IOException;

    public abstract void zzx(int i) throws IOException;

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzev$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        zza(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L_0x0011
                java.lang.String r3 = r1.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L_0x0016:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p010firebaseperf.zzev.zza.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzev() {
    }

    public final void zzg(int i, int i2) throws IOException {
        zzf(i, zzag(i2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzay(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzh(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzw(int i) throws IOException {
        zzv(zzag(i));
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzev$zzb */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    static class zzb extends zzev {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zzb(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i2 + 0;
                if ((i2 | 0 | (bArr.length - i3)) >= 0) {
                    this.buffer = bArr;
                    this.offset = 0;
                    this.position = 0;
                    this.limit = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        public final void writeTag(int i, int i2) throws IOException {
            zzv((i << 3) | i2);
        }

        public final void zze(int i, int i2) throws IOException {
            writeTag(i, 0);
            zzu(i2);
        }

        public final void zzf(int i, int i2) throws IOException {
            writeTag(i, 0);
            zzv(i2);
        }

        public final void zzh(int i, int i2) throws IOException {
            writeTag(i, 5);
            zzx(i2);
        }

        public final void zza(int i, long j) throws IOException {
            writeTag(i, 0);
            zzaq(j);
        }

        public final void zzc(int i, long j) throws IOException {
            writeTag(i, 1);
            zzas(j);
        }

        public final void zza(int i, boolean z) throws IOException {
            writeTag(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        public final void zza(int i, String str) throws IOException {
            writeTag(i, 2);
            zzak(str);
        }

        public final void zza(int i, zzee zzee) throws IOException {
            writeTag(i, 2);
            zza(zzee);
        }

        public final void zza(zzee zzee) throws IOException {
            zzv(zzee.size());
            zzee.zza((zzef) this);
        }

        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzv(i2);
            write(bArr, 0, i2);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzgs zzgs, zzhi zzhi) throws IOException {
            writeTag(i, 2);
            zzdz zzdz = (zzdz) zzgs;
            int zzgf = zzdz.zzgf();
            if (zzgf == -1) {
                zzgf = zzhi.zzn(zzdz);
                zzdz.zzp(zzgf);
            }
            zzv(zzgf);
            zzhi.zza(zzgs, this.zznp);
        }

        public final void zza(int i, zzgs zzgs) throws IOException {
            writeTag(1, 3);
            zzf(2, i);
            writeTag(3, 2);
            zzb(zzgs);
            writeTag(1, 4);
        }

        public final void zzb(int i, zzee zzee) throws IOException {
            writeTag(1, 3);
            zzf(2, i);
            zza(3, zzee);
            writeTag(1, 4);
        }

        public final void zzb(zzgs zzgs) throws IOException {
            zzv(zzgs.getSerializedSize());
            zzgs.writeTo(this);
        }

        public final void zzc(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zzu(int i) throws IOException {
            if (i >= 0) {
                zzv(i);
            } else {
                zzaq((long) i);
            }
        }

        public final void zzv(int i) throws IOException {
            if (!zzev.zzno || zzec.zzgh() || zzgt() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzig.zza(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzig.zza(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zzig.zza(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zzig.zza(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zzig.zza(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zzig.zza(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzig.zza(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzig.zza(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzig.zza(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        public final void zzx(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zzaq(long j) throws IOException {
            if (!zzev.zzno || zzgt() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zzig.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzig.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzas(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        private final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzak(String str) throws IOException {
            int i = this.position;
            try {
                int zzaa = zzaa(str.length() * 3);
                int zzaa2 = zzaa(str.length());
                if (zzaa2 == zzaa) {
                    this.position = i + zzaa2;
                    int zzb = zzii.zzb(str, this.buffer, this.position, zzgt());
                    this.position = i;
                    zzv((zzb - i) - zzaa2);
                    this.position = zzb;
                    return;
                }
                zzv(zzii.zza(str));
                this.position = zzii.zzb(str, this.buffer, this.position, zzgt());
            } catch (zzij e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(e2);
            }
        }

        public final int zzgt() {
            return this.limit - this.position;
        }
    }

    public final void zzar(long j) throws IOException {
        zzaq(zzay(j));
    }

    public final void zzb(float f) throws IOException {
        zzx(Float.floatToRawIntBits(f));
    }

    public final void zza(double d) throws IOException {
        zzas(Double.doubleToRawLongBits(d));
    }

    public final void zzf(boolean z) throws IOException {
        zzc(z ? (byte) 1 : 0);
    }

    public static int zzi(int i, int i2) {
        return zzy(i) + zzz(i2);
    }

    public static int zzj(int i, int i2) {
        return zzy(i) + zzaa(i2);
    }

    public static int zzk(int i, int i2) {
        return zzy(i) + zzaa(zzag(i2));
    }

    public static int zzl(int i, int i2) {
        return zzy(i) + 4;
    }

    public static int zzm(int i, int i2) {
        return zzy(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzy(i) + zzau(j);
    }

    public static int zze(int i, long j) {
        return zzy(i) + zzau(j);
    }

    public static int zzf(int i, long j) {
        return zzy(i) + zzau(zzay(j));
    }

    public static int zzg(int i, long j) {
        return zzy(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzy(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzy(i) + 4;
    }

    public static int zzb(int i, double d) {
        return zzy(i) + 8;
    }

    public static int zzb(int i, boolean z) {
        return zzy(i) + 1;
    }

    public static int zzn(int i, int i2) {
        return zzy(i) + zzz(i2);
    }

    public static int zzb(int i, String str) {
        return zzy(i) + zzal(str);
    }

    public static int zzc(int i, zzee zzee) {
        int zzy = zzy(i);
        int size = zzee.size();
        return zzy + zzaa(size) + size;
    }

    public static int zza(int i, zzfx zzfx) {
        int zzy = zzy(i);
        int serializedSize = zzfx.getSerializedSize();
        return zzy + zzaa(serializedSize) + serializedSize;
    }

    static int zzb(int i, zzgs zzgs, zzhi zzhi) {
        return zzy(i) + zza(zzgs, zzhi);
    }

    public static int zzb(int i, zzgs zzgs) {
        return (zzy(1) << 1) + zzj(2, i) + zzy(3) + zzc(zzgs);
    }

    public static int zzd(int i, zzee zzee) {
        return (zzy(1) << 1) + zzj(2, i) + zzc(3, zzee);
    }

    public static int zzb(int i, zzfx zzfx) {
        return (zzy(1) << 1) + zzj(2, i) + zza(3, zzfx);
    }

    public static int zzy(int i) {
        return zzaa(i << 3);
    }

    public static int zzz(int i) {
        if (i >= 0) {
            return zzaa(i);
        }
        return 10;
    }

    public static int zzab(int i) {
        return zzaa(zzag(i));
    }

    public static int zzat(long j) {
        return zzau(j);
    }

    public static int zzav(long j) {
        return zzau(zzay(j));
    }

    public static int zzae(int i) {
        return zzz(i);
    }

    public static int zzal(String str) {
        int i;
        try {
            i = zzii.zza(str);
        } catch (zzij unused) {
            i = str.getBytes(zzfj.UTF_8).length;
        }
        return zzaa(i) + i;
    }

    public static int zza(zzfx zzfx) {
        int serializedSize = zzfx.getSerializedSize();
        return zzaa(serializedSize) + serializedSize;
    }

    public static int zzb(zzee zzee) {
        int size = zzee.size();
        return zzaa(size) + size;
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        return zzaa(length) + length;
    }

    public static int zzc(zzgs zzgs) {
        int serializedSize = zzgs.getSerializedSize();
        return zzaa(serializedSize) + serializedSize;
    }

    static int zza(zzgs zzgs, zzhi zzhi) {
        zzdz zzdz = (zzdz) zzgs;
        int zzgf = zzdz.zzgf();
        if (zzgf == -1) {
            zzgf = zzhi.zzn(zzdz);
            zzdz.zzp(zzgf);
        }
        return zzaa(zzgf) + zzgf;
    }

    static int zzaf(int i) {
        return zzaa(i) + i;
    }

    public final void zzgu() {
        if (zzgt() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzij zzij) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzij);
        byte[] bytes = str.getBytes(zzfj.UTF_8);
        try {
            zzv(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zza(e);
        } catch (zza e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzgs zzgs, zzhi zzhi) {
        int zzy = zzy(i) << 1;
        zzdz zzdz = (zzdz) zzgs;
        int zzgf = zzdz.zzgf();
        if (zzgf == -1) {
            zzgf = zzhi.zzn(zzdz);
            zzdz.zzp(zzgf);
        }
        return zzy + zzgf;
    }

    @Deprecated
    public static int zzd(zzgs zzgs) {
        return zzgs.getSerializedSize();
    }

    @Deprecated
    public static int zzah(int i) {
        return zzaa(i);
    }
}
