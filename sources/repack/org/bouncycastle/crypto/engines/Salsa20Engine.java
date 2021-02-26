package repack.org.bouncycastle.crypto.engines;

import com.google.common.base.Ascii;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.MaxBytesExceededException;
import repack.org.bouncycastle.crypto.StreamCipher;
import repack.org.bouncycastle.crypto.params.KeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithIV;
import repack.org.bouncycastle.util.Strings;

public class Salsa20Engine implements StreamCipher {
    private static final byte[] sigma = Strings.toByteArray("expand 32-byte k");
    private static final int stateSize = 16;
    private static final byte[] tau = Strings.toByteArray("expand 16-byte k");
    private int cW0;
    private int cW1;
    private int cW2;
    private int[] engineState = new int[16];
    private int index = 0;
    private boolean initialised = false;
    private byte[] keyStream = new byte[64];
    private byte[] workingIV = null;
    private byte[] workingKey = null;

    /* renamed from: x */
    private int[] f6118x = new int[16];

    private int rotl(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    public String getAlgorithmName() {
        return "Salsa20";
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            if (iv == null || iv.length != 8) {
                throw new IllegalArgumentException("Salsa20 requires exactly 8 bytes of IV");
            } else if (parametersWithIV.getParameters() instanceof KeyParameter) {
                this.workingKey = ((KeyParameter) parametersWithIV.getParameters()).getKey();
                this.workingIV = iv;
                setKey(this.workingKey, this.workingIV);
            } else {
                throw new IllegalArgumentException("Salsa20 Init parameters must include a key");
            }
        } else {
            throw new IllegalArgumentException("Salsa20 Init parameters must include an IV");
        }
    }

    public byte returnByte(byte b) {
        if (!limitExceeded()) {
            if (this.index == 0) {
                salsa20WordToByte(this.engineState, this.keyStream);
                int[] iArr = this.engineState;
                iArr[8] = iArr[8] + 1;
                if (iArr[8] == 0) {
                    iArr[9] = iArr[9] + 1;
                }
            }
            byte[] bArr = this.keyStream;
            int i = this.index;
            byte b2 = (byte) (b ^ bArr[i]);
            this.index = (i + 1) & 63;
            return b2;
        }
        throw new MaxBytesExceededException("2^70 byte limit per IV; Change IV");
    }

    public void processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (!this.initialised) {
            throw new IllegalStateException(String.valueOf(getAlgorithmName()) + " not initialised");
        } else if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 > bArr2.length) {
            throw new DataLengthException("output buffer too short");
        } else if (!limitExceeded(i2)) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (this.index == 0) {
                    salsa20WordToByte(this.engineState, this.keyStream);
                    int[] iArr = this.engineState;
                    iArr[8] = iArr[8] + 1;
                    if (iArr[8] == 0) {
                        iArr[9] = iArr[9] + 1;
                    }
                }
                byte[] bArr3 = this.keyStream;
                int i5 = this.index;
                bArr2[i4 + i3] = (byte) (bArr3[i5] ^ bArr[i4 + i]);
                this.index = (i5 + 1) & 63;
            }
        } else {
            throw new MaxBytesExceededException("2^70 byte limit per IV would be exceeded; Change IV");
        }
    }

    public void reset() {
        setKey(this.workingKey, this.workingIV);
    }

    private void setKey(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        int i;
        this.workingKey = bArr;
        this.workingIV = bArr2;
        this.index = 0;
        resetCounter();
        this.engineState[1] = byteToIntLittle(this.workingKey, 0);
        this.engineState[2] = byteToIntLittle(this.workingKey, 4);
        this.engineState[3] = byteToIntLittle(this.workingKey, 8);
        this.engineState[4] = byteToIntLittle(this.workingKey, 12);
        if (this.workingKey.length == 32) {
            bArr3 = sigma;
            i = 16;
        } else {
            bArr3 = tau;
            i = 0;
        }
        this.engineState[11] = byteToIntLittle(this.workingKey, i);
        this.engineState[12] = byteToIntLittle(this.workingKey, i + 4);
        this.engineState[13] = byteToIntLittle(this.workingKey, i + 8);
        this.engineState[14] = byteToIntLittle(this.workingKey, i + 12);
        this.engineState[0] = byteToIntLittle(bArr3, 0);
        this.engineState[5] = byteToIntLittle(bArr3, 4);
        this.engineState[10] = byteToIntLittle(bArr3, 8);
        this.engineState[15] = byteToIntLittle(bArr3, 12);
        this.engineState[6] = byteToIntLittle(this.workingIV, 0);
        this.engineState[7] = byteToIntLittle(this.workingIV, 4);
        int[] iArr = this.engineState;
        iArr[9] = 0;
        iArr[8] = 0;
        this.initialised = true;
    }

    private void salsa20WordToByte(int[] iArr, byte[] bArr) {
        int[] iArr2 = iArr;
        byte[] bArr2 = bArr;
        System.arraycopy(iArr2, 0, this.f6118x, 0, iArr2.length);
        for (int i = 0; i < 10; i++) {
            int[] iArr3 = this.f6118x;
            iArr3[4] = iArr3[4] ^ rotl(iArr3[0] + iArr3[12], 7);
            int[] iArr4 = this.f6118x;
            iArr4[8] = iArr4[8] ^ rotl(iArr4[4] + iArr4[0], 9);
            int[] iArr5 = this.f6118x;
            iArr5[12] = iArr5[12] ^ rotl(iArr5[8] + iArr5[4], 13);
            int[] iArr6 = this.f6118x;
            iArr6[0] = iArr6[0] ^ rotl(iArr6[12] + iArr6[8], 18);
            int[] iArr7 = this.f6118x;
            iArr7[9] = iArr7[9] ^ rotl(iArr7[5] + iArr7[1], 7);
            int[] iArr8 = this.f6118x;
            iArr8[13] = iArr8[13] ^ rotl(iArr8[9] + iArr8[5], 9);
            int[] iArr9 = this.f6118x;
            iArr9[1] = iArr9[1] ^ rotl(iArr9[13] + iArr9[9], 13);
            int[] iArr10 = this.f6118x;
            iArr10[5] = iArr10[5] ^ rotl(iArr10[1] + iArr10[13], 18);
            int[] iArr11 = this.f6118x;
            iArr11[14] = rotl(iArr11[10] + iArr11[6], 7) ^ iArr11[14];
            int[] iArr12 = this.f6118x;
            iArr12[2] = rotl(iArr12[14] + iArr12[10], 9) ^ iArr12[2];
            int[] iArr13 = this.f6118x;
            iArr13[6] = iArr13[6] ^ rotl(iArr13[2] + iArr13[14], 13);
            int[] iArr14 = this.f6118x;
            iArr14[10] = iArr14[10] ^ rotl(iArr14[6] + iArr14[2], 18);
            int[] iArr15 = this.f6118x;
            iArr15[3] = rotl(iArr15[15] + iArr15[11], 7) ^ iArr15[3];
            int[] iArr16 = this.f6118x;
            iArr16[7] = iArr16[7] ^ rotl(iArr16[3] + iArr16[15], 9);
            int[] iArr17 = this.f6118x;
            iArr17[11] = rotl(iArr17[7] + iArr17[3], 13) ^ iArr17[11];
            int[] iArr18 = this.f6118x;
            iArr18[15] = iArr18[15] ^ rotl(iArr18[11] + iArr18[7], 18);
            int[] iArr19 = this.f6118x;
            iArr19[1] = iArr19[1] ^ rotl(iArr19[0] + iArr19[3], 7);
            int[] iArr20 = this.f6118x;
            iArr20[2] = iArr20[2] ^ rotl(iArr20[1] + iArr20[0], 9);
            int[] iArr21 = this.f6118x;
            iArr21[3] = iArr21[3] ^ rotl(iArr21[2] + iArr21[1], 13);
            int[] iArr22 = this.f6118x;
            iArr22[0] = iArr22[0] ^ rotl(iArr22[3] + iArr22[2], 18);
            int[] iArr23 = this.f6118x;
            iArr23[6] = iArr23[6] ^ rotl(iArr23[5] + iArr23[4], 7);
            int[] iArr24 = this.f6118x;
            iArr24[7] = iArr24[7] ^ rotl(iArr24[6] + iArr24[5], 9);
            int[] iArr25 = this.f6118x;
            iArr25[4] = iArr25[4] ^ rotl(iArr25[7] + iArr25[6], 13);
            int[] iArr26 = this.f6118x;
            iArr26[5] = rotl(iArr26[4] + iArr26[7], 18) ^ iArr26[5];
            int[] iArr27 = this.f6118x;
            iArr27[11] = iArr27[11] ^ rotl(iArr27[10] + iArr27[9], 7);
            int[] iArr28 = this.f6118x;
            iArr28[8] = iArr28[8] ^ rotl(iArr28[11] + iArr28[10], 9);
            int[] iArr29 = this.f6118x;
            iArr29[9] = iArr29[9] ^ rotl(iArr29[8] + iArr29[11], 13);
            int[] iArr30 = this.f6118x;
            iArr30[10] = rotl(iArr30[9] + iArr30[8], 18) ^ iArr30[10];
            int[] iArr31 = this.f6118x;
            iArr31[12] = iArr31[12] ^ rotl(iArr31[15] + iArr31[14], 7);
            int[] iArr32 = this.f6118x;
            iArr32[13] = iArr32[13] ^ rotl(iArr32[12] + iArr32[15], 9);
            int[] iArr33 = this.f6118x;
            iArr33[14] = rotl(iArr33[13] + iArr33[12], 13) ^ iArr33[14];
            int[] iArr34 = this.f6118x;
            iArr34[15] = rotl(iArr34[14] + iArr34[13], 18) ^ iArr34[15];
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 16; i3++) {
            intToByteLittle(this.f6118x[i3] + iArr2[i3], bArr2, i2);
            i2 += 4;
        }
        int i4 = 16;
        while (true) {
            int[] iArr35 = this.f6118x;
            if (i4 < iArr35.length) {
                intToByteLittle(iArr35[i4], bArr2, i2);
                i2 += 4;
                i4++;
            } else {
                return;
            }
        }
    }

    private byte[] intToByteLittle(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
        return bArr;
    }

    private int byteToIntLittle(byte[] bArr, int i) {
        return (bArr[i + 3] << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private void resetCounter() {
        this.cW0 = 0;
        this.cW1 = 0;
        this.cW2 = 0;
    }

    private boolean limitExceeded() {
        this.cW0++;
        if (this.cW0 == 0) {
            this.cW1++;
            if (this.cW1 == 0) {
                this.cW2++;
                if ((this.cW2 & 32) != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean limitExceeded(int i) {
        int i2 = this.cW0;
        if (i2 >= 0) {
            this.cW0 = i2 + i;
        } else {
            this.cW0 = i2 + i;
            if (this.cW0 >= 0) {
                this.cW1++;
                if (this.cW1 == 0) {
                    this.cW2++;
                    if ((this.cW2 & 32) != 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
