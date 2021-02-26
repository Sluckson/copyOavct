package repack.org.bouncycastle.crypto.engines;

import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.InvalidCipherTextException;
import repack.org.bouncycastle.crypto.Wrapper;
import repack.org.bouncycastle.crypto.params.KeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithIV;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;
import repack.org.bouncycastle.util.Arrays;

public class RFC3394WrapEngine implements Wrapper {
    private BlockCipher engine;
    private boolean forWrapping;

    /* renamed from: iv */
    private byte[] f6109iv = {-90, -90, -90, -90, -90, -90, -90, -90};
    private KeyParameter param;

    public RFC3394WrapEngine(BlockCipher blockCipher) {
        this.engine = blockCipher;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        this.forWrapping = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        if (cipherParameters instanceof KeyParameter) {
            this.param = (KeyParameter) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f6109iv = parametersWithIV.getIV();
            this.param = (KeyParameter) parametersWithIV.getParameters();
            if (this.f6109iv.length != 8) {
                throw new IllegalArgumentException("IV not equal to 8");
            }
        }
    }

    public String getAlgorithmName() {
        return this.engine.getAlgorithmName();
    }

    public byte[] wrap(byte[] bArr, int i, int i2) {
        if (this.forWrapping) {
            int i3 = i2 / 8;
            if (i3 * 8 == i2) {
                byte[] bArr2 = this.f6109iv;
                byte[] bArr3 = new byte[(bArr2.length + i2)];
                byte[] bArr4 = new byte[(bArr2.length + 8)];
                System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                System.arraycopy(bArr, 0, bArr3, this.f6109iv.length, i2);
                this.engine.init(true, this.param);
                for (int i4 = 0; i4 != 6; i4++) {
                    for (int i5 = 1; i5 <= i3; i5++) {
                        System.arraycopy(bArr3, 0, bArr4, 0, this.f6109iv.length);
                        int i6 = i5 * 8;
                        System.arraycopy(bArr3, i6, bArr4, this.f6109iv.length, 8);
                        this.engine.processBlock(bArr4, 0, bArr4, 0);
                        int i7 = (i3 * i4) + i5;
                        int i8 = 1;
                        while (i7 != 0) {
                            int length = this.f6109iv.length - i8;
                            bArr4[length] = (byte) (((byte) i7) ^ bArr4[length]);
                            i7 >>>= 8;
                            i8++;
                        }
                        System.arraycopy(bArr4, 0, bArr3, 0, 8);
                        System.arraycopy(bArr4, 8, bArr3, i6, 8);
                    }
                }
                return bArr3;
            }
            throw new DataLengthException("wrap data must be a multiple of 8 bytes");
        }
        throw new IllegalStateException("not set for wrapping");
    }

    public byte[] unwrap(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (!this.forWrapping) {
            int i3 = i2 / 8;
            if (i3 * 8 == i2) {
                byte[] bArr2 = this.f6109iv;
                byte[] bArr3 = new byte[(i2 - bArr2.length)];
                byte[] bArr4 = new byte[bArr2.length];
                byte[] bArr5 = new byte[(bArr2.length + 8)];
                System.arraycopy(bArr, 0, bArr4, 0, bArr2.length);
                byte[] bArr6 = this.f6109iv;
                System.arraycopy(bArr, bArr6.length, bArr3, 0, i2 - bArr6.length);
                this.engine.init(false, this.param);
                int i4 = i3 - 1;
                for (int i5 = 5; i5 >= 0; i5--) {
                    for (int i6 = i4; i6 >= 1; i6--) {
                        System.arraycopy(bArr4, 0, bArr5, 0, this.f6109iv.length);
                        int i7 = (i6 - 1) * 8;
                        System.arraycopy(bArr3, i7, bArr5, this.f6109iv.length, 8);
                        int i8 = (i4 * i5) + i6;
                        int i9 = 1;
                        while (i8 != 0) {
                            int length = this.f6109iv.length - i9;
                            bArr5[length] = (byte) (((byte) i8) ^ bArr5[length]);
                            i8 >>>= 8;
                            i9++;
                        }
                        this.engine.processBlock(bArr5, 0, bArr5, 0);
                        System.arraycopy(bArr5, 0, bArr4, 0, 8);
                        System.arraycopy(bArr5, 8, bArr3, i7, 8);
                    }
                }
                if (Arrays.constantTimeAreEqual(bArr4, this.f6109iv)) {
                    return bArr3;
                }
                throw new InvalidCipherTextException("checksum failed");
            }
            throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
        }
        throw new IllegalStateException("not set for unwrapping");
    }
}
