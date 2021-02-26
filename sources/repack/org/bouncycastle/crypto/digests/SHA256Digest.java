package repack.org.bouncycastle.crypto.digests;

import com.google.common.base.Ascii;
import repack.org.bouncycastle.crypto.util.Pack;

public class SHA256Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 32;

    /* renamed from: K */
    static final int[] f6013K = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};

    /* renamed from: H1 */
    private int f6014H1;

    /* renamed from: H2 */
    private int f6015H2;

    /* renamed from: H3 */
    private int f6016H3;

    /* renamed from: H4 */
    private int f6017H4;

    /* renamed from: H5 */
    private int f6018H5;

    /* renamed from: H6 */
    private int f6019H6;

    /* renamed from: H7 */
    private int f6020H7;

    /* renamed from: H8 */
    private int f6021H8;

    /* renamed from: X */
    private int[] f6022X = new int[64];
    private int xOff;

    /* renamed from: Ch */
    private int m4806Ch(int i, int i2, int i3) {
        return ((~i) & i3) ^ (i2 & i);
    }

    private int Maj(int i, int i2, int i3) {
        return ((i & i3) ^ (i & i2)) ^ (i2 & i3);
    }

    private int Sum0(int i) {
        return ((i << 10) | (i >>> 22)) ^ (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19)));
    }

    private int Sum1(int i) {
        return ((i << 7) | (i >>> 25)) ^ (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21)));
    }

    private int Theta0(int i) {
        return (i >>> 3) ^ (((i >>> 7) | (i << 25)) ^ ((i >>> 18) | (i << 14)));
    }

    private int Theta1(int i) {
        return (i >>> 10) ^ (((i >>> 17) | (i << 15)) ^ ((i >>> 19) | (i << 13)));
    }

    public String getAlgorithmName() {
        return "SHA-256";
    }

    public int getDigestSize() {
        return 32;
    }

    public SHA256Digest() {
        reset();
    }

    public SHA256Digest(SHA256Digest sHA256Digest) {
        super(sHA256Digest);
        this.f6014H1 = sHA256Digest.f6014H1;
        this.f6015H2 = sHA256Digest.f6015H2;
        this.f6016H3 = sHA256Digest.f6016H3;
        this.f6017H4 = sHA256Digest.f6017H4;
        this.f6018H5 = sHA256Digest.f6018H5;
        this.f6019H6 = sHA256Digest.f6019H6;
        this.f6020H7 = sHA256Digest.f6020H7;
        this.f6021H8 = sHA256Digest.f6021H8;
        int[] iArr = sHA256Digest.f6022X;
        System.arraycopy(iArr, 0, this.f6022X, 0, iArr.length);
        this.xOff = sHA256Digest.xOff;
    }

    /* access modifiers changed from: protected */
    public void processWord(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i3 + 1] & 255) | (bArr[i] << Ascii.CAN) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
        int[] iArr = this.f6022X;
        int i5 = this.xOff;
        iArr[i5] = i4;
        int i6 = i5 + 1;
        this.xOff = i6;
        if (i6 == 16) {
            processBlock();
        }
    }

    /* access modifiers changed from: protected */
    public void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.f6022X;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) (j & -1);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.intToBigEndian(this.f6014H1, bArr, i);
        Pack.intToBigEndian(this.f6015H2, bArr, i + 4);
        Pack.intToBigEndian(this.f6016H3, bArr, i + 8);
        Pack.intToBigEndian(this.f6017H4, bArr, i + 12);
        Pack.intToBigEndian(this.f6018H5, bArr, i + 16);
        Pack.intToBigEndian(this.f6019H6, bArr, i + 20);
        Pack.intToBigEndian(this.f6020H7, bArr, i + 24);
        Pack.intToBigEndian(this.f6021H8, bArr, i + 28);
        reset();
        return 32;
    }

    public void reset() {
        super.reset();
        this.f6014H1 = 1779033703;
        this.f6015H2 = -1150833019;
        this.f6016H3 = 1013904242;
        this.f6017H4 = -1521486534;
        this.f6018H5 = 1359893119;
        this.f6019H6 = -1694144372;
        this.f6020H7 = 528734635;
        this.f6021H8 = 1541459225;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f6022X;
            if (i != iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void processBlock() {
        for (int i = 16; i <= 63; i++) {
            int[] iArr = this.f6022X;
            int Theta1 = Theta1(iArr[i - 2]);
            int[] iArr2 = this.f6022X;
            iArr[i] = Theta1 + iArr2[i - 7] + Theta0(iArr2[i - 15]) + this.f6022X[i - 16];
        }
        int i2 = this.f6014H1;
        int i3 = this.f6015H2;
        int i4 = this.f6016H3;
        int i5 = this.f6017H4;
        int i6 = this.f6018H5;
        int i7 = this.f6019H6;
        int i8 = this.f6020H7;
        int i9 = this.f6021H8;
        int i10 = i3;
        int i11 = i4;
        int i12 = 0;
        int i13 = i2;
        for (int i14 = 0; i14 < 8; i14++) {
            int Sum1 = i9 + Sum1(i6) + m4806Ch(i6, i7, i8) + f6013K[i12] + this.f6022X[i12];
            int i15 = i5 + Sum1;
            int Sum0 = Sum1 + Sum0(i13) + Maj(i13, i10, i11);
            int i16 = i12 + 1;
            int Sum12 = i8 + Sum1(i15) + m4806Ch(i15, i6, i7) + f6013K[i16] + this.f6022X[i16];
            int i17 = i11 + Sum12;
            int Sum02 = Sum12 + Sum0(Sum0) + Maj(Sum0, i13, i10);
            int i18 = i16 + 1;
            int Sum13 = i7 + Sum1(i17) + m4806Ch(i17, i15, i6) + f6013K[i18] + this.f6022X[i18];
            int i19 = i10 + Sum13;
            int Sum03 = Sum13 + Sum0(Sum02) + Maj(Sum02, Sum0, i13);
            int i20 = i18 + 1;
            int Sum14 = i6 + Sum1(i19) + m4806Ch(i19, i17, i15) + f6013K[i20] + this.f6022X[i20];
            int i21 = i13 + Sum14;
            int Sum04 = Sum14 + Sum0(Sum03) + Maj(Sum03, Sum02, Sum0);
            int i22 = i20 + 1;
            int Sum15 = i15 + Sum1(i21) + m4806Ch(i21, i19, i17) + f6013K[i22] + this.f6022X[i22];
            i9 = Sum0 + Sum15;
            i5 = Sum15 + Sum0(Sum04) + Maj(Sum04, Sum03, Sum02);
            int i23 = i22 + 1;
            int Sum16 = i17 + Sum1(i9) + m4806Ch(i9, i21, i19) + f6013K[i23] + this.f6022X[i23];
            i8 = Sum02 + Sum16;
            i11 = Sum16 + Sum0(i5) + Maj(i5, Sum04, Sum03);
            int i24 = i23 + 1;
            int Sum17 = i19 + Sum1(i8) + m4806Ch(i8, i9, i21) + f6013K[i24] + this.f6022X[i24];
            i7 = Sum03 + Sum17;
            i10 = Sum17 + Sum0(i11) + Maj(i11, i5, Sum04);
            int i25 = i24 + 1;
            int Sum18 = i21 + Sum1(i7) + m4806Ch(i7, i8, i9) + f6013K[i25] + this.f6022X[i25];
            i6 = Sum04 + Sum18;
            i13 = Sum18 + Sum0(i10) + Maj(i10, i11, i5);
            i12 = i25 + 1;
        }
        this.f6014H1 += i13;
        this.f6015H2 += i10;
        this.f6016H3 += i11;
        this.f6017H4 += i5;
        this.f6018H5 += i6;
        this.f6019H6 += i7;
        this.f6020H7 += i8;
        this.f6021H8 += i9;
        this.xOff = 0;
        for (int i26 = 0; i26 < 16; i26++) {
            this.f6022X[i26] = 0;
        }
    }
}
