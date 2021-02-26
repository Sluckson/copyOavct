package repack.org.bouncycastle.crypto.modes;

import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.InvalidCipherTextException;
import repack.org.bouncycastle.crypto.Mac;
import repack.org.bouncycastle.crypto.macs.CMac;
import repack.org.bouncycastle.crypto.params.AEADParameters;
import repack.org.bouncycastle.crypto.params.ParametersWithIV;
import repack.org.bouncycastle.util.Arrays;

public class EAXBlockCipher implements AEADBlockCipher {
    private static final byte cTAG = 2;
    private static final byte hTAG = 1;
    private static final byte nTAG = 0;
    private byte[] associatedTextMac = new byte[this.mac.getMacSize()];
    private int blockSize;
    private byte[] bufBlock;
    private int bufOff;
    private SICBlockCipher cipher;
    private boolean forEncryption;
    private Mac mac;
    private byte[] macBlock;
    private int macSize;
    private byte[] nonceMac = new byte[this.mac.getMacSize()];

    public EAXBlockCipher(BlockCipher blockCipher) {
        this.blockSize = blockCipher.getBlockSize();
        this.mac = new CMac(blockCipher);
        int i = this.blockSize;
        this.macBlock = new byte[i];
        this.bufBlock = new byte[(i * 2)];
        this.cipher = new SICBlockCipher(blockCipher);
    }

    public String getAlgorithmName() {
        return String.valueOf(this.cipher.getUnderlyingCipher().getAlgorithmName()) + "/EAX";
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher.getUnderlyingCipher();
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        byte[] bArr;
        byte[] bArr2;
        this.forEncryption = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            bArr = aEADParameters.getNonce();
            bArr2 = aEADParameters.getAssociatedText();
            this.macSize = aEADParameters.getMacSize() / 8;
            cipherParameters2 = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.getIV();
            bArr2 = new byte[0];
            this.macSize = this.mac.getMacSize() / 2;
            cipherParameters2 = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to EAX");
        }
        byte[] bArr3 = new byte[this.blockSize];
        this.mac.init(cipherParameters2);
        int i = this.blockSize;
        bArr3[i - 1] = 1;
        this.mac.update(bArr3, 0, i);
        this.mac.update(bArr2, 0, bArr2.length);
        this.mac.doFinal(this.associatedTextMac, 0);
        int i2 = this.blockSize;
        bArr3[i2 - 1] = 0;
        this.mac.update(bArr3, 0, i2);
        this.mac.update(bArr, 0, bArr.length);
        this.mac.doFinal(this.nonceMac, 0);
        int i3 = this.blockSize;
        bArr3[i3 - 1] = 2;
        this.mac.update(bArr3, 0, i3);
        this.cipher.init(true, new ParametersWithIV(cipherParameters2, this.nonceMac));
    }

    private void calculateMac() {
        byte[] bArr = new byte[this.blockSize];
        int i = 0;
        this.mac.doFinal(bArr, 0);
        while (true) {
            byte[] bArr2 = this.macBlock;
            if (i < bArr2.length) {
                bArr2[i] = (byte) ((this.nonceMac[i] ^ this.associatedTextMac[i]) ^ bArr[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public void reset() {
        reset(true);
    }

    private void reset(boolean z) {
        this.cipher.reset();
        this.mac.reset();
        this.bufOff = 0;
        Arrays.fill(this.bufBlock, (byte) 0);
        if (z) {
            Arrays.fill(this.macBlock, (byte) 0);
        }
        int i = this.blockSize;
        byte[] bArr = new byte[i];
        bArr[i - 1] = 2;
        this.mac.update(bArr, 0, i);
    }

    public int processByte(byte b, byte[] bArr, int i) throws DataLengthException {
        return process(b, bArr, i);
    }

    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
        int i4 = 0;
        for (int i5 = 0; i5 != i2; i5++) {
            i4 += process(bArr[i + i5], bArr2, i3 + i4);
        }
        return i4;
    }

    public int doFinal(byte[] bArr, int i) throws IllegalStateException, InvalidCipherTextException {
        int i2 = this.bufOff;
        byte[] bArr2 = this.bufBlock;
        byte[] bArr3 = new byte[bArr2.length];
        this.bufOff = 0;
        if (this.forEncryption) {
            this.cipher.processBlock(bArr2, 0, bArr3, 0);
            SICBlockCipher sICBlockCipher = this.cipher;
            byte[] bArr4 = this.bufBlock;
            int i3 = this.blockSize;
            sICBlockCipher.processBlock(bArr4, i3, bArr3, i3);
            System.arraycopy(bArr3, 0, bArr, i, i2);
            this.mac.update(bArr3, 0, i2);
            calculateMac();
            System.arraycopy(this.macBlock, 0, bArr, i + i2, this.macSize);
            reset(false);
            return i2 + this.macSize;
        }
        int i4 = this.macSize;
        if (i2 > i4) {
            this.mac.update(bArr2, 0, i2 - i4);
            this.cipher.processBlock(this.bufBlock, 0, bArr3, 0);
            SICBlockCipher sICBlockCipher2 = this.cipher;
            byte[] bArr5 = this.bufBlock;
            int i5 = this.blockSize;
            sICBlockCipher2.processBlock(bArr5, i5, bArr3, i5);
            System.arraycopy(bArr3, 0, bArr, i, i2 - this.macSize);
        }
        calculateMac();
        if (verifyMac(this.bufBlock, i2 - this.macSize)) {
            reset(false);
            return i2 - this.macSize;
        }
        throw new InvalidCipherTextException("mac check in EAX failed");
    }

    public byte[] getMac() {
        int i = this.macSize;
        byte[] bArr = new byte[i];
        System.arraycopy(this.macBlock, 0, bArr, 0, i);
        return bArr;
    }

    public int getUpdateOutputSize(int i) {
        int i2 = i + this.bufOff;
        int i3 = this.blockSize;
        return (i2 / i3) * i3;
    }

    public int getOutputSize(int i) {
        if (this.forEncryption) {
            return i + this.bufOff + this.macSize;
        }
        return (i + this.bufOff) - this.macSize;
    }

    private int process(byte b, byte[] bArr, int i) {
        int i2;
        byte[] bArr2 = this.bufBlock;
        int i3 = this.bufOff;
        this.bufOff = i3 + 1;
        bArr2[i3] = b;
        if (this.bufOff != bArr2.length) {
            return 0;
        }
        if (this.forEncryption) {
            i2 = this.cipher.processBlock(bArr2, 0, bArr, i);
            this.mac.update(bArr, i, this.blockSize);
        } else {
            this.mac.update(bArr2, 0, this.blockSize);
            i2 = this.cipher.processBlock(this.bufBlock, 0, bArr, i);
        }
        int i4 = this.blockSize;
        this.bufOff = i4;
        byte[] bArr3 = this.bufBlock;
        System.arraycopy(bArr3, i4, bArr3, 0, i4);
        return i2;
    }

    private boolean verifyMac(byte[] bArr, int i) {
        for (int i2 = 0; i2 < this.macSize; i2++) {
            if (this.macBlock[i2] != bArr[i + i2]) {
                return false;
            }
        }
        return true;
    }
}
