package repack.org.bouncycastle.crypto.digests;

import java.lang.reflect.Array;
import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.ExtendedDigest;
import repack.org.bouncycastle.crypto.engines.GOST28147Engine;
import repack.org.bouncycastle.crypto.params.KeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithSBox;
import repack.org.bouncycastle.crypto.util.Pack;
import repack.org.bouncycastle.util.Arrays;

public class GOST3411Digest implements ExtendedDigest {

    /* renamed from: C2 */
    private static final byte[] f5926C2;
    private static final int DIGEST_LENGTH = 32;

    /* renamed from: C */
    private byte[][] f5927C;

    /* renamed from: H */
    private byte[] f5928H;

    /* renamed from: K */
    private byte[] f5929K;

    /* renamed from: L */
    private byte[] f5930L;

    /* renamed from: M */
    private byte[] f5931M;

    /* renamed from: S */
    byte[] f5932S;
    private byte[] Sum;

    /* renamed from: U */
    byte[] f5933U;

    /* renamed from: V */
    byte[] f5934V;

    /* renamed from: W */
    byte[] f5935W;

    /* renamed from: a */
    byte[] f5936a;
    private long byteCount;
    private BlockCipher cipher;
    private byte[] sBox;

    /* renamed from: wS */
    short[] f5937wS;
    short[] w_S;
    private byte[] xBuf;
    private int xBufOff;

    public String getAlgorithmName() {
        return "GOST3411";
    }

    public int getByteLength() {
        return 32;
    }

    public int getDigestSize() {
        return 32;
    }

    public GOST3411Digest() {
        this.f5928H = new byte[32];
        this.f5930L = new byte[32];
        this.f5931M = new byte[32];
        this.Sum = new byte[32];
        this.f5927C = (byte[][]) Array.newInstance(byte.class, new int[]{4, 32});
        this.xBuf = new byte[32];
        this.cipher = new GOST28147Engine();
        this.f5929K = new byte[32];
        this.f5936a = new byte[8];
        this.f5937wS = new short[16];
        this.w_S = new short[16];
        this.f5932S = new byte[32];
        this.f5933U = new byte[32];
        this.f5934V = new byte[32];
        this.f5935W = new byte[32];
        this.sBox = GOST28147Engine.getSBox("D-A");
        this.cipher.init(true, new ParametersWithSBox((CipherParameters) null, this.sBox));
        reset();
    }

    public GOST3411Digest(byte[] bArr) {
        this.f5928H = new byte[32];
        this.f5930L = new byte[32];
        this.f5931M = new byte[32];
        this.Sum = new byte[32];
        this.f5927C = (byte[][]) Array.newInstance(byte.class, new int[]{4, 32});
        this.xBuf = new byte[32];
        this.cipher = new GOST28147Engine();
        this.f5929K = new byte[32];
        this.f5936a = new byte[8];
        this.f5937wS = new short[16];
        this.w_S = new short[16];
        this.f5932S = new byte[32];
        this.f5933U = new byte[32];
        this.f5934V = new byte[32];
        this.f5935W = new byte[32];
        this.sBox = Arrays.clone(bArr);
        this.cipher.init(true, new ParametersWithSBox((CipherParameters) null, this.sBox));
        reset();
    }

    public GOST3411Digest(GOST3411Digest gOST3411Digest) {
        this.f5928H = new byte[32];
        this.f5930L = new byte[32];
        this.f5931M = new byte[32];
        this.Sum = new byte[32];
        this.f5927C = (byte[][]) Array.newInstance(byte.class, new int[]{4, 32});
        this.xBuf = new byte[32];
        this.cipher = new GOST28147Engine();
        this.f5929K = new byte[32];
        this.f5936a = new byte[8];
        this.f5937wS = new short[16];
        this.w_S = new short[16];
        this.f5932S = new byte[32];
        this.f5933U = new byte[32];
        this.f5934V = new byte[32];
        this.f5935W = new byte[32];
        this.sBox = gOST3411Digest.sBox;
        this.cipher.init(true, new ParametersWithSBox((CipherParameters) null, this.sBox));
        reset();
        byte[] bArr = gOST3411Digest.f5928H;
        System.arraycopy(bArr, 0, this.f5928H, 0, bArr.length);
        byte[] bArr2 = gOST3411Digest.f5930L;
        System.arraycopy(bArr2, 0, this.f5930L, 0, bArr2.length);
        byte[] bArr3 = gOST3411Digest.f5931M;
        System.arraycopy(bArr3, 0, this.f5931M, 0, bArr3.length);
        byte[] bArr4 = gOST3411Digest.Sum;
        System.arraycopy(bArr4, 0, this.Sum, 0, bArr4.length);
        byte[][] bArr5 = gOST3411Digest.f5927C;
        System.arraycopy(bArr5[1], 0, this.f5927C[1], 0, bArr5[1].length);
        byte[][] bArr6 = gOST3411Digest.f5927C;
        System.arraycopy(bArr6[2], 0, this.f5927C[2], 0, bArr6[2].length);
        byte[][] bArr7 = gOST3411Digest.f5927C;
        System.arraycopy(bArr7[3], 0, this.f5927C[3], 0, bArr7[3].length);
        byte[] bArr8 = gOST3411Digest.xBuf;
        System.arraycopy(bArr8, 0, this.xBuf, 0, bArr8.length);
        this.xBufOff = gOST3411Digest.xBufOff;
        this.byteCount = gOST3411Digest.byteCount;
    }

    public void update(byte b) {
        byte[] bArr = this.xBuf;
        int i = this.xBufOff;
        this.xBufOff = i + 1;
        bArr[i] = b;
        if (this.xBufOff == bArr.length) {
            sumByteArray(bArr);
            processBlock(this.xBuf, 0);
            this.xBufOff = 0;
        }
        this.byteCount++;
    }

    public void update(byte[] bArr, int i, int i2) {
        while (this.xBufOff != 0 && i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
        while (true) {
            byte[] bArr2 = this.xBuf;
            if (i2 <= bArr2.length) {
                break;
            }
            System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
            sumByteArray(this.xBuf);
            processBlock(this.xBuf, 0);
            byte[] bArr3 = this.xBuf;
            i += bArr3.length;
            i2 -= bArr3.length;
            this.byteCount += (long) bArr3.length;
        }
        while (i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
    }

    /* renamed from: P */
    private byte[] m4762P(byte[] bArr) {
        for (int i = 0; i < 8; i++) {
            byte[] bArr2 = this.f5929K;
            int i2 = i * 4;
            bArr2[i2] = bArr[i];
            bArr2[i2 + 1] = bArr[i + 8];
            bArr2[i2 + 2] = bArr[i + 16];
            bArr2[i2 + 3] = bArr[i + 24];
        }
        return this.f5929K;
    }

    /* renamed from: A */
    private byte[] m4760A(byte[] bArr) {
        for (int i = 0; i < 8; i++) {
            this.f5936a[i] = (byte) (bArr[i] ^ bArr[i + 8]);
        }
        System.arraycopy(bArr, 8, bArr, 0, 24);
        System.arraycopy(this.f5936a, 0, bArr, 24, 8);
        return bArr;
    }

    /* renamed from: E */
    private void m4761E(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2) {
        this.cipher.init(true, new KeyParameter(bArr));
        this.cipher.processBlock(bArr3, i2, bArr2, i);
    }

    /* renamed from: fw */
    private void m4763fw(byte[] bArr) {
        cpyBytesToShort(bArr, this.f5937wS);
        short[] sArr = this.w_S;
        short[] sArr2 = this.f5937wS;
        sArr[15] = (short) (((((sArr2[0] ^ sArr2[1]) ^ sArr2[2]) ^ sArr2[3]) ^ sArr2[12]) ^ sArr2[15]);
        System.arraycopy(sArr2, 1, sArr, 0, 15);
        cpyShortToBytes(this.w_S, bArr);
    }

    /* access modifiers changed from: protected */
    public void processBlock(byte[] bArr, int i) {
        System.arraycopy(bArr, i, this.f5931M, 0, 32);
        System.arraycopy(this.f5928H, 0, this.f5933U, 0, 32);
        System.arraycopy(this.f5931M, 0, this.f5934V, 0, 32);
        for (int i2 = 0; i2 < 32; i2++) {
            this.f5935W[i2] = (byte) (this.f5933U[i2] ^ this.f5934V[i2]);
        }
        m4761E(m4762P(this.f5935W), this.f5932S, 0, this.f5928H, 0);
        for (int i3 = 1; i3 < 4; i3++) {
            byte[] A = m4760A(this.f5933U);
            for (int i4 = 0; i4 < 32; i4++) {
                this.f5933U[i4] = (byte) (A[i4] ^ this.f5927C[i3][i4]);
            }
            this.f5934V = m4760A(m4760A(this.f5934V));
            for (int i5 = 0; i5 < 32; i5++) {
                this.f5935W[i5] = (byte) (this.f5933U[i5] ^ this.f5934V[i5]);
            }
            int i6 = i3 * 8;
            m4761E(m4762P(this.f5935W), this.f5932S, i6, this.f5928H, i6);
        }
        for (int i7 = 0; i7 < 12; i7++) {
            m4763fw(this.f5932S);
        }
        for (int i8 = 0; i8 < 32; i8++) {
            byte[] bArr2 = this.f5932S;
            bArr2[i8] = (byte) (bArr2[i8] ^ this.f5931M[i8]);
        }
        m4763fw(this.f5932S);
        for (int i9 = 0; i9 < 32; i9++) {
            byte[] bArr3 = this.f5932S;
            bArr3[i9] = (byte) (this.f5928H[i9] ^ bArr3[i9]);
        }
        for (int i10 = 0; i10 < 61; i10++) {
            m4763fw(this.f5932S);
        }
        byte[] bArr4 = this.f5932S;
        byte[] bArr5 = this.f5928H;
        System.arraycopy(bArr4, 0, bArr5, 0, bArr5.length);
    }

    private void finish() {
        Pack.longToLittleEndian(this.byteCount * 8, this.f5930L, 0);
        while (this.xBufOff != 0) {
            update((byte) 0);
        }
        processBlock(this.f5930L, 0);
        processBlock(this.Sum, 0);
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        byte[] bArr2 = this.f5928H;
        System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
        reset();
        return 32;
    }

    static {
        byte[] bArr = new byte[32];
        bArr[1] = -1;
        bArr[3] = -1;
        bArr[5] = -1;
        bArr[7] = -1;
        bArr[8] = -1;
        bArr[10] = -1;
        bArr[12] = -1;
        bArr[14] = -1;
        bArr[17] = -1;
        bArr[18] = -1;
        bArr[20] = -1;
        bArr[23] = -1;
        bArr[24] = -1;
        bArr[28] = -1;
        bArr[29] = -1;
        bArr[31] = -1;
        f5926C2 = bArr;
    }

    public void reset() {
        this.byteCount = 0;
        this.xBufOff = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.f5928H;
            if (i >= bArr.length) {
                break;
            }
            bArr[i] = 0;
            i++;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.f5930L;
            if (i2 >= bArr2.length) {
                break;
            }
            bArr2[i2] = 0;
            i2++;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr3 = this.f5931M;
            if (i3 >= bArr3.length) {
                break;
            }
            bArr3[i3] = 0;
            i3++;
        }
        int i4 = 0;
        while (true) {
            byte[][] bArr4 = this.f5927C;
            if (i4 >= bArr4[1].length) {
                break;
            }
            bArr4[1][i4] = 0;
            i4++;
        }
        int i5 = 0;
        while (true) {
            byte[][] bArr5 = this.f5927C;
            if (i5 >= bArr5[3].length) {
                break;
            }
            bArr5[3][i5] = 0;
            i5++;
        }
        int i6 = 0;
        while (true) {
            byte[] bArr6 = this.Sum;
            if (i6 >= bArr6.length) {
                break;
            }
            bArr6[i6] = 0;
            i6++;
        }
        int i7 = 0;
        while (true) {
            byte[] bArr7 = this.xBuf;
            if (i7 >= bArr7.length) {
                byte[] bArr8 = f5926C2;
                System.arraycopy(bArr8, 0, this.f5927C[2], 0, bArr8.length);
                return;
            }
            bArr7[i7] = 0;
            i7++;
        }
    }

    private void sumByteArray(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.Sum;
            if (i != bArr2.length) {
                int i3 = (bArr2[i] & 255) + (bArr[i] & 255) + i2;
                bArr2[i] = (byte) i3;
                i2 = i3 >>> 8;
                i++;
            } else {
                return;
            }
        }
    }

    private void cpyBytesToShort(byte[] bArr, short[] sArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            int i2 = i * 2;
            sArr[i] = (short) ((bArr[i2] & 255) | ((bArr[i2 + 1] << 8) & 65280));
        }
    }

    private void cpyShortToBytes(short[] sArr, byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            int i2 = i * 2;
            bArr[i2 + 1] = (byte) (sArr[i] >> 8);
            bArr[i2] = (byte) sArr[i];
        }
    }
}
