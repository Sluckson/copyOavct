package repack.org.bouncycastle.crypto.modes;

import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.params.ParametersWithIV;

public class OFBBlockCipher implements BlockCipher {

    /* renamed from: IV */
    private byte[] f6162IV;
    private final int blockSize;
    private final BlockCipher cipher;
    private byte[] ofbOutV;
    private byte[] ofbV;

    public OFBBlockCipher(BlockCipher blockCipher, int i) {
        this.cipher = blockCipher;
        this.blockSize = i / 8;
        this.f6162IV = new byte[blockCipher.getBlockSize()];
        this.ofbV = new byte[blockCipher.getBlockSize()];
        this.ofbOutV = new byte[blockCipher.getBlockSize()];
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            int length = iv.length;
            byte[] bArr = this.f6162IV;
            if (length < bArr.length) {
                System.arraycopy(iv, 0, bArr, bArr.length - iv.length, iv.length);
                int i = 0;
                while (true) {
                    byte[] bArr2 = this.f6162IV;
                    if (i >= bArr2.length - iv.length) {
                        break;
                    }
                    bArr2[i] = 0;
                    i++;
                }
            } else {
                System.arraycopy(iv, 0, bArr, 0, bArr.length);
            }
            reset();
            this.cipher.init(true, parametersWithIV.getParameters());
            return;
        }
        reset();
        this.cipher.init(true, cipherParameters);
    }

    public String getAlgorithmName() {
        return String.valueOf(this.cipher.getAlgorithmName()) + "/OFB" + (this.blockSize * 8);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        int i3 = this.blockSize;
        if (i + i3 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            this.cipher.processBlock(this.ofbV, 0, this.ofbOutV, 0);
            int i4 = 0;
            while (true) {
                int i5 = this.blockSize;
                if (i4 >= i5) {
                    byte[] bArr3 = this.ofbV;
                    System.arraycopy(bArr3, i5, bArr3, 0, bArr3.length - i5);
                    byte[] bArr4 = this.ofbOutV;
                    byte[] bArr5 = this.ofbV;
                    int length = bArr5.length;
                    int i6 = this.blockSize;
                    System.arraycopy(bArr4, 0, bArr5, length - i6, i6);
                    return this.blockSize;
                }
                bArr2[i2 + i4] = (byte) (this.ofbOutV[i4] ^ bArr[i + i4]);
                i4++;
            }
        } else {
            throw new DataLengthException("output buffer too short");
        }
    }

    public void reset() {
        byte[] bArr = this.f6162IV;
        System.arraycopy(bArr, 0, this.ofbV, 0, bArr.length);
        this.cipher.reset();
    }
}
