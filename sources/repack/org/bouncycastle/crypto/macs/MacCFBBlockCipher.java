package repack.org.bouncycastle.crypto.macs;

import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.params.ParametersWithIV;

/* compiled from: CFBBlockCipherMac */
class MacCFBBlockCipher {

    /* renamed from: IV */
    private byte[] f6141IV;
    private int blockSize;
    private byte[] cfbOutV;
    private byte[] cfbV;
    private BlockCipher cipher = null;

    public MacCFBBlockCipher(BlockCipher blockCipher, int i) {
        this.cipher = blockCipher;
        this.blockSize = i / 8;
        this.f6141IV = new byte[blockCipher.getBlockSize()];
        this.cfbV = new byte[blockCipher.getBlockSize()];
        this.cfbOutV = new byte[blockCipher.getBlockSize()];
    }

    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            int length = iv.length;
            byte[] bArr = this.f6141IV;
            if (length < bArr.length) {
                System.arraycopy(iv, 0, bArr, bArr.length - iv.length, iv.length);
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
        return String.valueOf(this.cipher.getAlgorithmName()) + "/CFB" + (this.blockSize * 8);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        int i3 = this.blockSize;
        if (i + i3 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            this.cipher.processBlock(this.cfbV, 0, this.cfbOutV, 0);
            int i4 = 0;
            while (true) {
                int i5 = this.blockSize;
                if (i4 >= i5) {
                    byte[] bArr3 = this.cfbV;
                    System.arraycopy(bArr3, i5, bArr3, 0, bArr3.length - i5);
                    byte[] bArr4 = this.cfbV;
                    int length = bArr4.length;
                    int i6 = this.blockSize;
                    System.arraycopy(bArr2, i2, bArr4, length - i6, i6);
                    return this.blockSize;
                }
                bArr2[i2 + i4] = (byte) (this.cfbOutV[i4] ^ bArr[i + i4]);
                i4++;
            }
        } else {
            throw new DataLengthException("output buffer too short");
        }
    }

    public void reset() {
        byte[] bArr = this.f6141IV;
        System.arraycopy(bArr, 0, this.cfbV, 0, bArr.length);
        this.cipher.reset();
    }

    /* access modifiers changed from: package-private */
    public void getMacBlock(byte[] bArr) {
        this.cipher.processBlock(this.cfbV, 0, bArr, 0);
    }
}
