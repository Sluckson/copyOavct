package repack.org.bouncycastle.crypto.engines;

import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.params.KeyParameter;

public class RC6Engine implements BlockCipher {
    private static final int LGW = 5;
    private static final int P32 = -1209970333;
    private static final int Q32 = -1640531527;
    private static final int _noRounds = 20;
    private static final int bytesPerWord = 4;
    private static final int wordSize = 32;

    /* renamed from: _S */
    private int[] f6108_S = null;
    private boolean forEncryption;

    private int rotateLeft(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    private int rotateRight(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    public String getAlgorithmName() {
        return "RC6";
    }

    public int getBlockSize() {
        return 16;
    }

    public void reset() {
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.forEncryption = z;
            setKey(((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to RC6 init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int blockSize = getBlockSize();
        if (this.f6108_S == null) {
            throw new IllegalStateException("RC6 engine not initialised");
        } else if (i + blockSize > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (blockSize + i2 > bArr2.length) {
            throw new DataLengthException("output buffer too short");
        } else if (this.forEncryption) {
            return encryptBlock(bArr, i, bArr2, i2);
        } else {
            return decryptBlock(bArr, i, bArr2, i2);
        }
    }

    private void setKey(byte[] bArr) {
        int[] iArr;
        int i;
        int length = (bArr.length + 3) / 4;
        int[] iArr2 = new int[(((bArr.length + 4) - 1) / 4)];
        for (int length2 = bArr.length - 1; length2 >= 0; length2--) {
            int i2 = length2 / 4;
            iArr2[i2] = (iArr2[i2] << 8) + (bArr[length2] & 255);
        }
        this.f6108_S = new int[44];
        this.f6108_S[0] = P32;
        int i3 = 1;
        while (true) {
            iArr = this.f6108_S;
            if (i3 >= iArr.length) {
                break;
            }
            iArr[i3] = iArr[i3 - 1] + Q32;
            i3++;
        }
        if (iArr2.length > iArr.length) {
            i = iArr2.length;
        } else {
            i = iArr.length;
        }
        int i4 = i * 3;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i4; i9++) {
            int[] iArr3 = this.f6108_S;
            i6 = rotateLeft(iArr3[i5] + i6 + i7, 3);
            iArr3[i5] = i6;
            i7 = rotateLeft(iArr2[i8] + i6 + i7, i7 + i6);
            iArr2[i8] = i7;
            i5 = (i5 + 1) % this.f6108_S.length;
            i8 = (i8 + 1) % iArr2.length;
        }
    }

    private int encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int bytesToWord = bytesToWord(bArr, i);
        int bytesToWord2 = bytesToWord(bArr, i + 4);
        int bytesToWord3 = bytesToWord(bArr, i + 8);
        int bytesToWord4 = bytesToWord(bArr, i + 12);
        int[] iArr = this.f6108_S;
        int i3 = bytesToWord4 + iArr[1];
        int i4 = bytesToWord;
        int i5 = bytesToWord2 + iArr[0];
        int i6 = bytesToWord3;
        int i7 = i3;
        int i8 = 1;
        while (i8 <= 20) {
            int rotateLeft = rotateLeft(((i5 * 2) + 1) * i5, 5);
            int rotateLeft2 = rotateLeft(((i7 * 2) + 1) * i7, 5);
            int i9 = i8 * 2;
            i8++;
            int i10 = i7;
            i7 = rotateLeft(i4 ^ rotateLeft, rotateLeft2) + this.f6108_S[i9];
            i4 = i5;
            i5 = rotateLeft(i6 ^ rotateLeft2, rotateLeft) + this.f6108_S[i9 + 1];
            i6 = i10;
        }
        int[] iArr2 = this.f6108_S;
        int i11 = i6 + iArr2[43];
        wordToBytes(i4 + iArr2[42], bArr2, i2);
        wordToBytes(i5, bArr2, i2 + 4);
        wordToBytes(i11, bArr2, i2 + 8);
        wordToBytes(i7, bArr2, i2 + 12);
        return 16;
    }

    private int decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int bytesToWord = bytesToWord(bArr, i);
        int bytesToWord2 = bytesToWord(bArr, i + 4);
        int bytesToWord3 = bytesToWord(bArr, i + 8);
        int bytesToWord4 = bytesToWord(bArr, i + 12);
        int[] iArr = this.f6108_S;
        int i3 = bytesToWord3 - iArr[43];
        int i4 = bytesToWord - iArr[42];
        int i5 = 20;
        while (i5 >= 1) {
            int rotateLeft = rotateLeft(((i4 * 2) + 1) * i4, 5);
            int rotateLeft2 = rotateLeft(((i3 * 2) + 1) * i3, 5);
            int i6 = i5 * 2;
            i5--;
            int i7 = i4;
            i4 = rotateRight(bytesToWord4 - this.f6108_S[i6], rotateLeft2) ^ rotateLeft;
            bytesToWord4 = i3;
            i3 = rotateRight(bytesToWord2 - this.f6108_S[i6 + 1], rotateLeft) ^ rotateLeft2;
            bytesToWord2 = i7;
        }
        int[] iArr2 = this.f6108_S;
        wordToBytes(i4, bArr2, i2);
        wordToBytes(bytesToWord2 - iArr2[0], bArr2, i2 + 4);
        wordToBytes(i3, bArr2, i2 + 8);
        wordToBytes(bytesToWord4 - iArr2[1], bArr2, i2 + 12);
        return 16;
    }

    private int bytesToWord(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 3; i3 >= 0; i3--) {
            i2 = (i2 << 8) + (bArr[i3 + i] & 255);
        }
        return i2;
    }

    private void wordToBytes(int i, byte[] bArr, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i3 + i2] = (byte) i;
            i >>>= 8;
        }
    }
}