package repack.org.bouncycastle.crypto.modes;

import com.google.common.primitives.SignedBytes;
import java.io.ByteArrayOutputStream;
import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.InvalidCipherTextException;
import repack.org.bouncycastle.crypto.macs.CBCBlockCipherMac;
import repack.org.bouncycastle.crypto.params.AEADParameters;
import repack.org.bouncycastle.crypto.params.ParametersWithIV;
import repack.org.bouncycastle.util.Arrays;

public class CCMBlockCipher implements AEADBlockCipher {
    private byte[] associatedText;
    private int blockSize;
    private BlockCipher cipher;
    private ByteArrayOutputStream data = new ByteArrayOutputStream();
    private boolean forEncryption;
    private CipherParameters keyParam;
    private byte[] macBlock;
    private int macSize;
    private byte[] nonce;

    public int getUpdateOutputSize(int i) {
        return 0;
    }

    public CCMBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        this.blockSize = blockCipher.getBlockSize();
        int i = this.blockSize;
        this.macBlock = new byte[i];
        if (i != 16) {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        }
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.forEncryption = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            this.nonce = aEADParameters.getNonce();
            this.associatedText = aEADParameters.getAssociatedText();
            this.macSize = aEADParameters.getMacSize() / 8;
            this.keyParam = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.nonce = parametersWithIV.getIV();
            this.associatedText = null;
            this.macSize = this.macBlock.length / 2;
            this.keyParam = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to CCM");
        }
    }

    public String getAlgorithmName() {
        return String.valueOf(this.cipher.getAlgorithmName()) + "/CCM";
    }

    public int processByte(byte b, byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        this.data.write(b);
        return 0;
    }

    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException, IllegalStateException {
        this.data.write(bArr, i, i2);
        return 0;
    }

    public int doFinal(byte[] bArr, int i) throws IllegalStateException, InvalidCipherTextException {
        byte[] byteArray = this.data.toByteArray();
        byte[] processPacket = processPacket(byteArray, 0, byteArray.length);
        System.arraycopy(processPacket, 0, bArr, i, processPacket.length);
        reset();
        return processPacket.length;
    }

    public void reset() {
        this.cipher.reset();
        this.data.reset();
    }

    public byte[] getMac() {
        byte[] bArr = new byte[this.macSize];
        System.arraycopy(this.macBlock, 0, bArr, 0, bArr.length);
        return bArr;
    }

    public int getOutputSize(int i) {
        if (this.forEncryption) {
            return this.data.size() + i + this.macSize;
        }
        return (this.data.size() + i) - this.macSize;
    }

    public byte[] processPacket(byte[] bArr, int i, int i2) throws IllegalStateException, InvalidCipherTextException {
        int i3;
        if (this.keyParam != null) {
            SICBlockCipher sICBlockCipher = new SICBlockCipher(this.cipher);
            byte[] bArr2 = new byte[this.blockSize];
            byte[] bArr3 = this.nonce;
            bArr2[0] = (byte) (((15 - bArr3.length) - 1) & 7);
            System.arraycopy(bArr3, 0, bArr2, 1, bArr3.length);
            sICBlockCipher.init(this.forEncryption, new ParametersWithIV(this.keyParam, bArr2));
            if (this.forEncryption) {
                byte[] bArr4 = new byte[(this.macSize + i2)];
                calculateMac(bArr, i, i2, this.macBlock);
                byte[] bArr5 = this.macBlock;
                sICBlockCipher.processBlock(bArr5, 0, bArr5, 0);
                int i4 = 0;
                while (true) {
                    int i5 = this.blockSize;
                    if (i >= i2 - i5) {
                        byte[] bArr6 = new byte[i5];
                        int i6 = i2 - i;
                        System.arraycopy(bArr, i, bArr6, 0, i6);
                        sICBlockCipher.processBlock(bArr6, 0, bArr6, 0);
                        System.arraycopy(bArr6, 0, bArr4, i4, i6);
                        int i7 = i4 + i6;
                        System.arraycopy(this.macBlock, 0, bArr4, i7, bArr4.length - i7);
                        return bArr4;
                    }
                    sICBlockCipher.processBlock(bArr, i, bArr4, i4);
                    int i8 = this.blockSize;
                    i4 += i8;
                    i += i8;
                }
            } else {
                int i9 = this.macSize;
                byte[] bArr7 = new byte[(i2 - i9)];
                System.arraycopy(bArr, (i2 + i) - i9, this.macBlock, 0, i9);
                byte[] bArr8 = this.macBlock;
                sICBlockCipher.processBlock(bArr8, 0, bArr8, 0);
                int i10 = this.macSize;
                while (true) {
                    byte[] bArr9 = this.macBlock;
                    if (i10 == bArr9.length) {
                        break;
                    }
                    bArr9[i10] = 0;
                    i10++;
                }
                int i11 = i;
                int i12 = 0;
                while (true) {
                    int length = bArr7.length;
                    i3 = this.blockSize;
                    if (i12 >= length - i3) {
                        break;
                    }
                    sICBlockCipher.processBlock(bArr, i11, bArr7, i12);
                    int i13 = this.blockSize;
                    i12 += i13;
                    i11 += i13;
                }
                byte[] bArr10 = new byte[i3];
                System.arraycopy(bArr, i11, bArr10, 0, bArr7.length - i12);
                sICBlockCipher.processBlock(bArr10, 0, bArr10, 0);
                System.arraycopy(bArr10, 0, bArr7, i12, bArr7.length - i12);
                byte[] bArr11 = new byte[this.blockSize];
                calculateMac(bArr7, 0, bArr7.length, bArr11);
                if (Arrays.constantTimeAreEqual(this.macBlock, bArr11)) {
                    return bArr7;
                }
                throw new InvalidCipherTextException("mac check in CCM failed");
            }
        } else {
            throw new IllegalStateException("CCM cipher unitialized.");
        }
    }

    private int calculateMac(byte[] bArr, int i, int i2, byte[] bArr2) {
        CBCBlockCipherMac cBCBlockCipherMac = new CBCBlockCipherMac(this.cipher, this.macSize * 8);
        cBCBlockCipherMac.init(this.keyParam);
        byte[] bArr3 = new byte[16];
        if (hasAssociatedText()) {
            bArr3[0] = (byte) (bArr3[0] | SignedBytes.MAX_POWER_OF_TWO);
        }
        int i3 = 2;
        bArr3[0] = (byte) (bArr3[0] | ((((cBCBlockCipherMac.getMacSize() - 2) / 2) & 7) << 3));
        byte b = bArr3[0];
        byte[] bArr4 = this.nonce;
        bArr3[0] = (byte) (b | (((15 - bArr4.length) - 1) & 7));
        System.arraycopy(bArr4, 0, bArr3, 1, bArr4.length);
        int i4 = i2;
        int i5 = 1;
        while (i4 > 0) {
            bArr3[bArr3.length - i5] = (byte) (i4 & 255);
            i4 >>>= 8;
            i5++;
        }
        cBCBlockCipherMac.update(bArr3, 0, bArr3.length);
        if (hasAssociatedText()) {
            byte[] bArr5 = this.associatedText;
            if (bArr5.length < 65280) {
                cBCBlockCipherMac.update((byte) (bArr5.length >> 8));
                cBCBlockCipherMac.update((byte) this.associatedText.length);
            } else {
                cBCBlockCipherMac.update((byte) -1);
                cBCBlockCipherMac.update((byte) -2);
                cBCBlockCipherMac.update((byte) (this.associatedText.length >> 24));
                cBCBlockCipherMac.update((byte) (this.associatedText.length >> 16));
                cBCBlockCipherMac.update((byte) (this.associatedText.length >> 8));
                cBCBlockCipherMac.update((byte) this.associatedText.length);
                i3 = 6;
            }
            byte[] bArr6 = this.associatedText;
            cBCBlockCipherMac.update(bArr6, 0, bArr6.length);
            int length = (i3 + this.associatedText.length) % 16;
            if (length != 0) {
                for (int i6 = 0; i6 != 16 - length; i6++) {
                    cBCBlockCipherMac.update((byte) 0);
                }
            }
        }
        cBCBlockCipherMac.update(bArr, i, i2);
        return cBCBlockCipherMac.doFinal(bArr2, 0);
    }

    private boolean hasAssociatedText() {
        byte[] bArr = this.associatedText;
        return (bArr == null || bArr.length == 0) ? false : true;
    }
}
