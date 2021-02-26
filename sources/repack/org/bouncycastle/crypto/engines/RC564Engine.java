package repack.org.bouncycastle.crypto.engines;

import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.params.RC5Parameters;

public class RC564Engine implements BlockCipher {
    private static final long P64 = -5196783011329398165L;
    private static final long Q64 = -7046029254386353131L;
    private static final int bytesPerWord = 8;
    private static final int wordSize = 64;

    /* renamed from: _S */
    private long[] f6107_S = null;
    private int _noRounds = 12;
    private boolean forEncryption;

    private long rotateLeft(long j, long j2) {
        long j3 = j2 & 63;
        return (j >>> ((int) (64 - j3))) | (j << ((int) j3));
    }

    private long rotateRight(long j, long j2) {
        long j3 = j2 & 63;
        return (j << ((int) (64 - j3))) | (j >>> ((int) j3));
    }

    public String getAlgorithmName() {
        return "RC5-64";
    }

    public int getBlockSize() {
        return 16;
    }

    public void reset() {
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof RC5Parameters) {
            RC5Parameters rC5Parameters = (RC5Parameters) cipherParameters;
            this.forEncryption = z;
            this._noRounds = rC5Parameters.getRounds();
            setKey(rC5Parameters.getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to RC564 init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.forEncryption) {
            return encryptBlock(bArr, i, bArr2, i2);
        }
        return decryptBlock(bArr, i, bArr2, i2);
    }

    private void setKey(byte[] bArr) {
        long[] jArr;
        int i;
        long[] jArr2 = new long[((bArr.length + 7) / 8)];
        for (int i2 = 0; i2 != bArr.length; i2++) {
            int i3 = i2 / 8;
            jArr2[i3] = jArr2[i3] + (((long) (bArr[i2] & 255)) << ((i2 % 8) * 8));
        }
        this.f6107_S = new long[((this._noRounds + 1) * 2)];
        this.f6107_S[0] = -5196783011329398165L;
        int i4 = 1;
        while (true) {
            jArr = this.f6107_S;
            if (i4 >= jArr.length) {
                break;
            }
            jArr[i4] = jArr[i4 - 1] + Q64;
            i4++;
        }
        if (jArr2.length > jArr.length) {
            i = jArr2.length;
        } else {
            i = jArr.length;
        }
        int i5 = i * 3;
        long j = 0;
        long j2 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < i5; i8++) {
            long[] jArr3 = this.f6107_S;
            j = rotateLeft(jArr3[i6] + j + j2, 3);
            jArr3[i6] = j;
            j2 = rotateLeft(jArr2[i7] + j + j2, j2 + j);
            jArr2[i7] = j2;
            i6 = (i6 + 1) % this.f6107_S.length;
            i7 = (i7 + 1) % jArr2.length;
        }
    }

    private int encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        long bytesToWord = bytesToWord(bArr, i) + this.f6107_S[0];
        long bytesToWord2 = bytesToWord(bArr, i + 8) + this.f6107_S[1];
        for (int i3 = 1; i3 <= this._noRounds; i3++) {
            int i4 = i3 * 2;
            bytesToWord = rotateLeft(bytesToWord ^ bytesToWord2, bytesToWord2) + this.f6107_S[i4];
            bytesToWord2 = rotateLeft(bytesToWord2 ^ bytesToWord, bytesToWord) + this.f6107_S[i4 + 1];
        }
        wordToBytes(bytesToWord, bArr2, i2);
        wordToBytes(bytesToWord2, bArr2, i2 + 8);
        return 16;
    }

    private int decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        long bytesToWord = bytesToWord(bArr, i);
        long bytesToWord2 = bytesToWord(bArr, i + 8);
        for (int i3 = this._noRounds; i3 >= 1; i3--) {
            int i4 = i3 * 2;
            bytesToWord2 = rotateRight(bytesToWord2 - this.f6107_S[i4 + 1], bytesToWord) ^ bytesToWord;
            bytesToWord = rotateRight(bytesToWord - this.f6107_S[i4], bytesToWord2) ^ bytesToWord2;
        }
        wordToBytes(bytesToWord - this.f6107_S[0], bArr2, i2);
        wordToBytes(bytesToWord2 - this.f6107_S[1], bArr2, i2 + 8);
        return 16;
    }

    private long bytesToWord(byte[] bArr, int i) {
        long j = 0;
        for (int i2 = 7; i2 >= 0; i2--) {
            j = (j << 8) + ((long) (bArr[i2 + i] & 255));
        }
        return j;
    }

    private void wordToBytes(long j, byte[] bArr, int i) {
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i2 + i] = (byte) ((int) j);
            j >>>= 8;
        }
    }
}
