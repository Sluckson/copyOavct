package repack.org.bouncycastle.crypto.signers;

import com.google.common.primitives.SignedBytes;
import java.util.Hashtable;
import repack.org.bouncycastle.crypto.AsymmetricBlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.CryptoException;
import repack.org.bouncycastle.crypto.Digest;
import repack.org.bouncycastle.crypto.InvalidCipherTextException;
import repack.org.bouncycastle.crypto.SignerWithRecovery;
import repack.org.bouncycastle.crypto.params.RSAKeyParameters;
import repack.org.bouncycastle.util.Arrays;

public class ISO9796d2Signer implements SignerWithRecovery {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    public static final int TRAILER_SHA256 = 13516;
    public static final int TRAILER_SHA384 = 14028;
    public static final int TRAILER_SHA512 = 13772;
    public static final int TRAILER_WHIRLPOOL = 14284;
    private static Hashtable trailerMap = new Hashtable();
    private byte[] block;
    private AsymmetricBlockCipher cipher;
    private Digest digest;
    private boolean fullMessage;
    private int keyBits;
    private byte[] mBuf;
    private int messageLength;
    private byte[] preBlock;
    private byte[] preSig;
    private byte[] recoveredMessage;
    private int trailer;

    static {
        trailerMap.put("RIPEMD128", new Integer(13004));
        trailerMap.put("RIPEMD160", new Integer(12748));
        trailerMap.put("SHA-1", new Integer(13260));
        trailerMap.put("SHA-256", new Integer(TRAILER_SHA256));
        trailerMap.put("SHA-384", new Integer(TRAILER_SHA384));
        trailerMap.put("SHA-512", new Integer(TRAILER_SHA512));
        trailerMap.put("Whirlpool", new Integer(TRAILER_WHIRLPOOL));
    }

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest2, boolean z) {
        this.cipher = asymmetricBlockCipher;
        this.digest = digest2;
        if (z) {
            this.trailer = 188;
            return;
        }
        Integer num = (Integer) trailerMap.get(digest2.getAlgorithmName());
        if (num != null) {
            this.trailer = num.intValue();
            return;
        }
        throw new IllegalArgumentException("no valid trailer for digest");
    }

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest2) {
        this(asymmetricBlockCipher, digest2, false);
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.cipher.init(z, rSAKeyParameters);
        this.keyBits = rSAKeyParameters.getModulus().bitLength();
        this.block = new byte[((this.keyBits + 7) / 8)];
        if (this.trailer == 188) {
            this.mBuf = new byte[((this.block.length - this.digest.getDigestSize()) - 2)];
        } else {
            this.mBuf = new byte[((this.block.length - this.digest.getDigestSize()) - 3)];
        }
        reset();
    }

    private boolean isSameAs(byte[] bArr, byte[] bArr2) {
        int i = this.messageLength;
        byte[] bArr3 = this.mBuf;
        boolean z = true;
        if (i > bArr3.length) {
            if (bArr3.length > bArr2.length) {
                z = false;
            }
            for (int i2 = 0; i2 != this.mBuf.length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    z = false;
                }
            }
        } else {
            if (i != bArr2.length) {
                z = false;
            }
            for (int i3 = 0; i3 != bArr2.length; i3++) {
                if (bArr[i3] != bArr2[i3]) {
                    z = false;
                }
            }
        }
        return z;
    }

    private void clearBlock(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = 0;
        }
    }

    public void updateWithRecoveredMessage(byte[] bArr) throws InvalidCipherTextException {
        byte[] processBlock = this.cipher.processBlock(bArr, 0, bArr.length);
        if (((processBlock[0] & 192) ^ SignedBytes.MAX_POWER_OF_TWO) != 0) {
            throw new InvalidCipherTextException("malformed signature");
        } else if (((processBlock[processBlock.length - 1] & 15) ^ 12) == 0) {
            int i = 2;
            if (((processBlock[processBlock.length - 1] & 255) ^ PSSSigner.TRAILER_IMPLICIT) == 0) {
                i = 1;
            } else {
                byte b = ((processBlock[processBlock.length - 2] & 255) << 8) | (processBlock[processBlock.length - 1] & 255);
                Integer num = (Integer) trailerMap.get(this.digest.getAlgorithmName());
                if (num == null) {
                    throw new IllegalArgumentException("unrecognised hash in signature");
                } else if (b != num.intValue()) {
                    throw new IllegalStateException("signer initialised with wrong digest for trailer " + b);
                }
            }
            int i2 = 0;
            while (i2 != processBlock.length && ((processBlock[i2] & 15) ^ 10) != 0) {
                i2++;
            }
            int i3 = i2 + 1;
            int length = ((processBlock.length - i) - this.digest.getDigestSize()) - i3;
            if (length > 0) {
                if ((processBlock[0] & 32) == 0) {
                    this.fullMessage = true;
                    this.recoveredMessage = new byte[length];
                    byte[] bArr2 = this.recoveredMessage;
                    System.arraycopy(processBlock, i3, bArr2, 0, bArr2.length);
                } else {
                    this.fullMessage = false;
                    this.recoveredMessage = new byte[length];
                    byte[] bArr3 = this.recoveredMessage;
                    System.arraycopy(processBlock, i3, bArr3, 0, bArr3.length);
                }
                this.preSig = bArr;
                this.preBlock = processBlock;
                Digest digest2 = this.digest;
                byte[] bArr4 = this.recoveredMessage;
                digest2.update(bArr4, 0, bArr4.length);
                this.messageLength = this.recoveredMessage.length;
                return;
            }
            throw new InvalidCipherTextException("malformed block");
        } else {
            throw new InvalidCipherTextException("malformed signature");
        }
    }

    public void update(byte b) {
        this.digest.update(b);
        if (this.preSig == null) {
            int i = this.messageLength;
            byte[] bArr = this.mBuf;
            if (i < bArr.length) {
                bArr[i] = b;
            }
        }
        this.messageLength++;
    }

    public void update(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
        if (this.preSig == null && this.messageLength < this.mBuf.length) {
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = this.messageLength;
                int i5 = i3 + i4;
                byte[] bArr2 = this.mBuf;
                if (i5 >= bArr2.length) {
                    break;
                }
                bArr2[i4 + i3] = bArr[i + i3];
            }
        }
        this.messageLength += i2;
    }

    public void reset() {
        this.digest.reset();
        this.messageLength = 0;
        clearBlock(this.mBuf);
        byte[] bArr = this.recoveredMessage;
        if (bArr != null) {
            clearBlock(bArr);
        }
        this.recoveredMessage = null;
        this.fullMessage = false;
    }

    public byte[] generateSignature() throws CryptoException {
        int i;
        int i2;
        int i3;
        byte b;
        int digestSize = this.digest.getDigestSize();
        if (this.trailer == 188) {
            byte[] bArr = this.block;
            i = (bArr.length - digestSize) - 1;
            this.digest.doFinal(bArr, i);
            byte[] bArr2 = this.block;
            bArr2[bArr2.length - 1] = PSSSigner.TRAILER_IMPLICIT;
            i2 = 8;
        } else {
            i2 = 16;
            byte[] bArr3 = this.block;
            int length = (bArr3.length - digestSize) - 2;
            this.digest.doFinal(bArr3, length);
            byte[] bArr4 = this.block;
            int i4 = this.trailer;
            bArr4[bArr4.length - 2] = (byte) (i4 >>> 8);
            bArr4[bArr4.length - 1] = (byte) i4;
            i = length;
        }
        int i5 = this.messageLength;
        int i6 = ((((digestSize + i5) * 8) + i2) + 4) - this.keyBits;
        if (i6 > 0) {
            int i7 = i5 - ((i6 + 7) / 8);
            b = 96;
            i3 = i - i7;
            System.arraycopy(this.mBuf, 0, this.block, i3, i7);
        } else {
            b = SignedBytes.MAX_POWER_OF_TWO;
            i3 = i - i5;
            System.arraycopy(this.mBuf, 0, this.block, i3, i5);
        }
        int i8 = i3 - 1;
        if (i8 > 0) {
            for (int i9 = i8; i9 != 0; i9--) {
                this.block[i9] = -69;
            }
            byte[] bArr5 = this.block;
            bArr5[i8] = (byte) (bArr5[i8] ^ 1);
            bArr5[0] = 11;
            bArr5[0] = (byte) (b | bArr5[0]);
        } else {
            byte[] bArr6 = this.block;
            bArr6[0] = 10;
            bArr6[0] = (byte) (b | bArr6[0]);
        }
        AsymmetricBlockCipher asymmetricBlockCipher = this.cipher;
        byte[] bArr7 = this.block;
        byte[] processBlock = asymmetricBlockCipher.processBlock(bArr7, 0, bArr7.length);
        clearBlock(this.mBuf);
        clearBlock(this.block);
        return processBlock;
    }

    public boolean verifySignature(byte[] bArr) {
        byte[] bArr2;
        boolean z;
        byte[] bArr3 = this.preSig;
        if (bArr3 == null) {
            try {
                bArr2 = this.cipher.processBlock(bArr, 0, bArr.length);
                z = false;
            } catch (Exception unused) {
                return false;
            }
        } else if (Arrays.areEqual(bArr3, bArr)) {
            bArr2 = this.preBlock;
            this.preSig = null;
            this.preBlock = null;
            z = true;
        } else {
            throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
        }
        if (((bArr2[0] & 192) ^ SignedBytes.MAX_POWER_OF_TWO) != 0) {
            return returnFalse(bArr2);
        }
        if (((bArr2[bArr2.length - 1] & 15) ^ 12) != 0) {
            return returnFalse(bArr2);
        }
        int i = 2;
        if (((bArr2[bArr2.length - 1] & 255) ^ PSSSigner.TRAILER_IMPLICIT) == 0) {
            i = 1;
        } else {
            byte b = ((bArr2[bArr2.length - 2] & 255) << 8) | (bArr2[bArr2.length - 1] & 255);
            Integer num = (Integer) trailerMap.get(this.digest.getAlgorithmName());
            if (num == null) {
                throw new IllegalArgumentException("unrecognised hash in signature");
            } else if (b != num.intValue()) {
                throw new IllegalStateException("signer initialised with wrong digest for trailer " + b);
            }
        }
        int i2 = 0;
        while (i2 != bArr2.length && ((bArr2[i2] & 15) ^ 10) != 0) {
            i2++;
        }
        int i3 = i2 + 1;
        byte[] bArr4 = new byte[this.digest.getDigestSize()];
        int length = (bArr2.length - i) - bArr4.length;
        int i4 = length - i3;
        if (i4 <= 0) {
            return returnFalse(bArr2);
        }
        if ((bArr2[0] & 32) == 0) {
            this.fullMessage = true;
            if (this.messageLength > i4) {
                return returnFalse(bArr2);
            }
            this.digest.reset();
            this.digest.update(bArr2, i3, i4);
            this.digest.doFinal(bArr4, 0);
            boolean z2 = true;
            for (int i5 = 0; i5 != bArr4.length; i5++) {
                int i6 = length + i5;
                bArr2[i6] = (byte) (bArr2[i6] ^ bArr4[i5]);
                if (bArr2[i6] != 0) {
                    z2 = false;
                }
            }
            if (!z2) {
                return returnFalse(bArr2);
            }
            this.recoveredMessage = new byte[i4];
            byte[] bArr5 = this.recoveredMessage;
            System.arraycopy(bArr2, i3, bArr5, 0, bArr5.length);
        } else {
            this.fullMessage = false;
            this.digest.doFinal(bArr4, 0);
            boolean z3 = true;
            for (int i7 = 0; i7 != bArr4.length; i7++) {
                int i8 = length + i7;
                bArr2[i8] = (byte) (bArr2[i8] ^ bArr4[i7]);
                if (bArr2[i8] != 0) {
                    z3 = false;
                }
            }
            if (!z3) {
                return returnFalse(bArr2);
            }
            this.recoveredMessage = new byte[i4];
            byte[] bArr6 = this.recoveredMessage;
            System.arraycopy(bArr2, i3, bArr6, 0, bArr6.length);
        }
        if (this.messageLength != 0 && !z && !isSameAs(this.mBuf, this.recoveredMessage)) {
            return returnFalse(bArr2);
        }
        clearBlock(this.mBuf);
        clearBlock(bArr2);
        return true;
    }

    private boolean returnFalse(byte[] bArr) {
        clearBlock(this.mBuf);
        clearBlock(bArr);
        return false;
    }

    public boolean hasFullMessage() {
        return this.fullMessage;
    }

    public byte[] getRecoveredMessage() {
        return this.recoveredMessage;
    }
}
