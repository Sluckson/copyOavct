package repack.org.bouncycastle.crypto.encodings;

import java.math.BigInteger;
import repack.org.bouncycastle.crypto.AsymmetricBlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.InvalidCipherTextException;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;
import repack.org.bouncycastle.crypto.params.RSAKeyParameters;

public class ISO9796d1Encoding implements AsymmetricBlockCipher {
    private static final BigInteger SIX = BigInteger.valueOf(6);
    private static final BigInteger SIXTEEN = BigInteger.valueOf(16);
    private static byte[] inverse;
    private static byte[] shadows;
    private int bitSize;
    private AsymmetricBlockCipher engine;
    private boolean forEncryption;
    private BigInteger modulus;
    private int padBits = 0;

    static {
        byte[] bArr = new byte[16];
        bArr[0] = 14;
        bArr[1] = 3;
        bArr[2] = 5;
        bArr[3] = 8;
        bArr[4] = 9;
        bArr[5] = 4;
        bArr[6] = 2;
        bArr[7] = 15;
        bArr[9] = 13;
        bArr[10] = 11;
        bArr[11] = 6;
        bArr[12] = 7;
        bArr[13] = 10;
        bArr[14] = 12;
        bArr[15] = 1;
        shadows = bArr;
        byte[] bArr2 = new byte[16];
        bArr2[0] = 8;
        bArr2[1] = 15;
        bArr2[2] = 6;
        bArr2[3] = 1;
        bArr2[4] = 5;
        bArr2[5] = 2;
        bArr2[6] = 11;
        bArr2[7] = 12;
        bArr2[8] = 3;
        bArr2[9] = 4;
        bArr2[10] = 13;
        bArr2[11] = 10;
        bArr2[12] = 14;
        bArr2[13] = 9;
        bArr2[15] = 7;
        inverse = bArr2;
    }

    public ISO9796d1Encoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.engine = asymmetricBlockCipher;
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters;
        if (cipherParameters instanceof ParametersWithRandom) {
            rSAKeyParameters = (RSAKeyParameters) ((ParametersWithRandom) cipherParameters).getParameters();
        } else {
            rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        }
        this.engine.init(z, cipherParameters);
        this.modulus = rSAKeyParameters.getModulus();
        this.bitSize = this.modulus.bitLength();
        this.forEncryption = z;
    }

    public int getInputBlockSize() {
        int inputBlockSize = this.engine.getInputBlockSize();
        return this.forEncryption ? (inputBlockSize + 1) / 2 : inputBlockSize;
    }

    public int getOutputBlockSize() {
        int outputBlockSize = this.engine.getOutputBlockSize();
        if (this.forEncryption) {
            return outputBlockSize;
        }
        return (outputBlockSize + 1) / 2;
    }

    public void setPadBits(int i) {
        if (i <= 7) {
            this.padBits = i;
            return;
        }
        throw new IllegalArgumentException("padBits > 7");
    }

    public int getPadBits() {
        return this.padBits;
    }

    public byte[] processBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (this.forEncryption) {
            return encodeBlock(bArr, i, i2);
        }
        return decodeBlock(bArr, i, i2);
    }

    private byte[] encodeBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        int i3 = this.bitSize;
        byte[] bArr2 = new byte[((i3 + 7) / 8)];
        int i4 = 1;
        int i5 = this.padBits + 1;
        int i6 = (i3 + 13) / 16;
        int i7 = 0;
        while (i7 < i6) {
            if (i7 > i6 - i2) {
                int i8 = i6 - i7;
                System.arraycopy(bArr, (i + i2) - i8, bArr2, bArr2.length - i6, i8);
            } else {
                System.arraycopy(bArr, i, bArr2, bArr2.length - (i7 + i2), i2);
            }
            i7 += i2;
        }
        for (int length = bArr2.length - (i6 * 2); length != bArr2.length; length += 2) {
            byte b = bArr2[(bArr2.length - i6) + (length / 2)];
            byte[] bArr3 = shadows;
            bArr2[length] = (byte) (bArr3[b & 15] | (bArr3[(b & 255) >>> 4] << 4));
            bArr2[length + 1] = b;
        }
        int length2 = bArr2.length - (i2 * 2);
        bArr2[length2] = (byte) (bArr2[length2] ^ i5);
        bArr2[bArr2.length - 1] = (byte) ((bArr2[bArr2.length - 1] << 4) | 6);
        int i9 = 8 - ((this.bitSize - 1) % 8);
        if (i9 != 8) {
            bArr2[0] = (byte) (bArr2[0] & (255 >>> i9));
            bArr2[0] = (byte) ((128 >>> i9) | bArr2[0]);
            i4 = 0;
        } else {
            bArr2[0] = 0;
            bArr2[1] = (byte) (bArr2[1] | 128);
        }
        return this.engine.processBlock(bArr2, i4, bArr2.length - i4);
    }

    private byte[] decodeBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        byte[] processBlock = this.engine.processBlock(bArr, i, i2);
        int i3 = (this.bitSize + 13) / 16;
        BigInteger bigInteger = new BigInteger(1, processBlock);
        if (!bigInteger.mod(SIXTEEN).equals(SIX)) {
            if (this.modulus.subtract(bigInteger).mod(SIXTEEN).equals(SIX)) {
                bigInteger = this.modulus.subtract(bigInteger);
            } else {
                throw new InvalidCipherTextException("resulting integer iS or (modulus - iS) is not congruent to 6 mod 16");
            }
        }
        byte[] convertOutputDecryptOnly = convertOutputDecryptOnly(bigInteger);
        if ((convertOutputDecryptOnly[convertOutputDecryptOnly.length - 1] & 15) == 6) {
            convertOutputDecryptOnly[convertOutputDecryptOnly.length - 1] = (byte) (((convertOutputDecryptOnly[convertOutputDecryptOnly.length - 1] & 255) >>> 4) | (inverse[(convertOutputDecryptOnly[convertOutputDecryptOnly.length - 2] & 255) >> 4] << 4));
            byte[] bArr2 = shadows;
            convertOutputDecryptOnly[0] = (byte) (bArr2[convertOutputDecryptOnly[1] & 15] | (bArr2[(convertOutputDecryptOnly[1] & 255) >>> 4] << 4));
            int i4 = 0;
            boolean z = false;
            byte b = 1;
            for (int length = convertOutputDecryptOnly.length - 1; length >= convertOutputDecryptOnly.length - (i3 * 2); length -= 2) {
                byte[] bArr3 = shadows;
                byte b2 = bArr3[convertOutputDecryptOnly[length] & 15] | (bArr3[(convertOutputDecryptOnly[length] & 255) >>> 4] << 4);
                int i5 = length - 1;
                if (((convertOutputDecryptOnly[i5] ^ b2) & 255) != 0) {
                    if (!z) {
                        b = (convertOutputDecryptOnly[i5] ^ b2) & 255;
                        i4 = i5;
                        z = true;
                    } else {
                        throw new InvalidCipherTextException("invalid tsums in block");
                    }
                }
            }
            convertOutputDecryptOnly[i4] = 0;
            byte[] bArr4 = new byte[((convertOutputDecryptOnly.length - i4) / 2)];
            for (int i6 = 0; i6 < bArr4.length; i6++) {
                bArr4[i6] = convertOutputDecryptOnly[(i6 * 2) + i4 + 1];
            }
            this.padBits = b - 1;
            return bArr4;
        }
        throw new InvalidCipherTextException("invalid forcing byte in block");
    }

    private static byte[] convertOutputDecryptOnly(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] != 0) {
            return byteArray;
        }
        byte[] bArr = new byte[(byteArray.length - 1)];
        System.arraycopy(byteArray, 1, bArr, 0, bArr.length);
        return bArr;
    }
}
