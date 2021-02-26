package repack.org.bouncycastle.crypto.modes;

import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.params.ParametersWithIV;

public class SICBlockCipher implements BlockCipher {

    /* renamed from: IV */
    private byte[] f6167IV;
    private final int blockSize = this.cipher.getBlockSize();
    private final BlockCipher cipher;
    private byte[] counter;
    private byte[] counterOut;

    public SICBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        int i = this.blockSize;
        this.f6167IV = new byte[i];
        this.counter = new byte[i];
        this.counterOut = new byte[i];
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            byte[] bArr = this.f6167IV;
            System.arraycopy(iv, 0, bArr, 0, bArr.length);
            reset();
            this.cipher.init(true, parametersWithIV.getParameters());
            return;
        }
        throw new IllegalArgumentException("SIC mode requires ParametersWithIV");
    }

    public String getAlgorithmName() {
        return String.valueOf(this.cipher.getAlgorithmName()) + "/SIC";
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
        int i3 = 0;
        while (true) {
            byte[] bArr3 = this.counterOut;
            if (i3 >= bArr3.length) {
                break;
            }
            bArr2[i2 + i3] = (byte) (bArr3[i3] ^ bArr[i + i3]);
            i3++;
        }
        byte b = 1;
        for (int length = this.counter.length - 1; length >= 0; length--) {
            int i4 = (this.counter[length] & 255) + b;
            b = i4 > 255 ? (byte) 1 : 0;
            this.counter[length] = (byte) i4;
        }
        return this.counter.length;
    }

    public void reset() {
        byte[] bArr = this.f6167IV;
        byte[] bArr2 = this.counter;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.cipher.reset();
    }
}
