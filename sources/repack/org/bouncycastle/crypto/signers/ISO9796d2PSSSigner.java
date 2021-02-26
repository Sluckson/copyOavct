package repack.org.bouncycastle.crypto.signers;

import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.AsymmetricBlockCipher;
import repack.org.bouncycastle.crypto.CryptoException;
import repack.org.bouncycastle.crypto.Digest;
import repack.org.bouncycastle.crypto.InvalidCipherTextException;
import repack.org.bouncycastle.crypto.SignerWithRecovery;
import repack.org.bouncycastle.crypto.digests.RIPEMD128Digest;
import repack.org.bouncycastle.crypto.digests.RIPEMD160Digest;
import repack.org.bouncycastle.crypto.digests.SHA1Digest;

public class ISO9796d2PSSSigner implements SignerWithRecovery {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    private byte[] block;
    private AsymmetricBlockCipher cipher;
    private Digest digest;
    private boolean fullMessage;
    private int hLen;
    private int keyBits;
    private byte[] mBuf;
    private int messageLength;
    private SecureRandom random;
    private byte[] recoveredMessage;
    private int saltLength;
    private byte[] standardSalt;
    private int trailer;

    public ISO9796d2PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest2, int i, boolean z) {
        this.cipher = asymmetricBlockCipher;
        this.digest = digest2;
        this.hLen = digest2.getDigestSize();
        this.saltLength = i;
        if (z) {
            this.trailer = 188;
        } else if (digest2 instanceof SHA1Digest) {
            this.trailer = 13260;
        } else if (digest2 instanceof RIPEMD160Digest) {
            this.trailer = 12748;
        } else if (digest2 instanceof RIPEMD128Digest) {
            this.trailer = 13004;
        } else {
            throw new IllegalArgumentException("no valid trailer for digest");
        }
    }

    public ISO9796d2PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest2, int i) {
        this(asymmetricBlockCipher, digest2, i, false);
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [repack.org.bouncycastle.crypto.CipherParameters] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(boolean r4, repack.org.bouncycastle.crypto.CipherParameters r5) {
        /*
            r3 = this;
            int r0 = r3.saltLength
            boolean r1 = r5 instanceof repack.org.bouncycastle.crypto.params.ParametersWithRandom
            if (r1 == 0) goto L_0x0017
            repack.org.bouncycastle.crypto.params.ParametersWithRandom r5 = (repack.org.bouncycastle.crypto.params.ParametersWithRandom) r5
            repack.org.bouncycastle.crypto.CipherParameters r1 = r5.getParameters()
            repack.org.bouncycastle.crypto.params.RSAKeyParameters r1 = (repack.org.bouncycastle.crypto.params.RSAKeyParameters) r1
            if (r4 == 0) goto L_0x0047
            java.security.SecureRandom r5 = r5.getRandom()
            r3.random = r5
            goto L_0x0047
        L_0x0017:
            boolean r1 = r5 instanceof repack.org.bouncycastle.crypto.params.ParametersWithSalt
            if (r1 == 0) goto L_0x003b
            repack.org.bouncycastle.crypto.params.ParametersWithSalt r5 = (repack.org.bouncycastle.crypto.params.ParametersWithSalt) r5
            repack.org.bouncycastle.crypto.CipherParameters r0 = r5.getParameters()
            r1 = r0
            repack.org.bouncycastle.crypto.params.RSAKeyParameters r1 = (repack.org.bouncycastle.crypto.params.RSAKeyParameters) r1
            byte[] r5 = r5.getSalt()
            r3.standardSalt = r5
            byte[] r5 = r3.standardSalt
            int r0 = r5.length
            int r5 = r5.length
            int r2 = r3.saltLength
            if (r5 != r2) goto L_0x0033
            goto L_0x0047
        L_0x0033:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Fixed salt is of wrong length"
            r4.<init>(r5)
            throw r4
        L_0x003b:
            r1 = r5
            repack.org.bouncycastle.crypto.params.RSAKeyParameters r1 = (repack.org.bouncycastle.crypto.params.RSAKeyParameters) r1
            if (r4 == 0) goto L_0x0047
            java.security.SecureRandom r5 = new java.security.SecureRandom
            r5.<init>()
            r3.random = r5
        L_0x0047:
            repack.org.bouncycastle.crypto.AsymmetricBlockCipher r5 = r3.cipher
            r5.init(r4, r1)
            java.math.BigInteger r4 = r1.getModulus()
            int r4 = r4.bitLength()
            r3.keyBits = r4
            int r4 = r3.keyBits
            int r4 = r4 + 7
            int r4 = r4 / 8
            byte[] r4 = new byte[r4]
            r3.block = r4
            int r4 = r3.trailer
            r5 = 188(0xbc, float:2.63E-43)
            if (r4 != r5) goto L_0x007a
            byte[] r4 = r3.block
            int r4 = r4.length
            repack.org.bouncycastle.crypto.Digest r5 = r3.digest
            int r5 = r5.getDigestSize()
            int r4 = r4 - r5
            int r4 = r4 - r0
            int r4 = r4 + -1
            int r4 = r4 + -1
            byte[] r4 = new byte[r4]
            r3.mBuf = r4
            goto L_0x008d
        L_0x007a:
            byte[] r4 = r3.block
            int r4 = r4.length
            repack.org.bouncycastle.crypto.Digest r5 = r3.digest
            int r5 = r5.getDigestSize()
            int r4 = r4 - r5
            int r4 = r4 - r0
            int r4 = r4 + -1
            int r4 = r4 + -2
            byte[] r4 = new byte[r4]
            r3.mBuf = r4
        L_0x008d:
            r3.reset()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.crypto.signers.ISO9796d2PSSSigner.init(boolean, repack.org.bouncycastle.crypto.CipherParameters):void");
    }

    private boolean isSameAs(byte[] bArr, byte[] bArr2) {
        boolean z = this.messageLength == bArr2.length;
        for (int i = 0; i != bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                z = false;
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
        throw new RuntimeException("not implemented");
    }

    public void update(byte b) {
        int i = this.messageLength;
        byte[] bArr = this.mBuf;
        if (i < bArr.length) {
            this.messageLength = i + 1;
            bArr[i] = b;
            return;
        }
        this.digest.update(b);
    }

    public void update(byte[] bArr, int i, int i2) {
        while (i2 > 0 && this.messageLength < this.mBuf.length) {
            update(bArr[i]);
            i++;
            i2--;
        }
        if (i2 > 0) {
            this.digest.update(bArr, i, i2);
        }
    }

    public void reset() {
        this.digest.reset();
        this.messageLength = 0;
        byte[] bArr = this.mBuf;
        if (bArr != null) {
            clearBlock(bArr);
        }
        byte[] bArr2 = this.recoveredMessage;
        if (bArr2 != null) {
            clearBlock(bArr2);
            this.recoveredMessage = null;
        }
        this.fullMessage = false;
    }

    public byte[] generateSignature() throws CryptoException {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        byte[] bArr2 = new byte[8];
        LtoOSP((long) (this.messageLength * 8), bArr2);
        this.digest.update(bArr2, 0, bArr2.length);
        this.digest.update(this.mBuf, 0, this.messageLength);
        this.digest.update(bArr, 0, bArr.length);
        byte[] bArr3 = this.standardSalt;
        if (bArr3 == null) {
            bArr3 = new byte[this.saltLength];
            this.random.nextBytes(bArr3);
        }
        this.digest.update(bArr3, 0, bArr3.length);
        byte[] bArr4 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr4, 0);
        int i = this.trailer == 188 ? 1 : 2;
        byte[] bArr5 = this.block;
        int length = bArr5.length;
        int i2 = this.messageLength;
        int length2 = ((((length - i2) - bArr3.length) - this.hLen) - i) - 1;
        bArr5[length2] = 1;
        int i3 = length2 + 1;
        System.arraycopy(this.mBuf, 0, bArr5, i3, i2);
        System.arraycopy(bArr3, 0, this.block, i3 + this.messageLength, bArr3.length);
        byte[] maskGeneratorFunction1 = maskGeneratorFunction1(bArr4, 0, bArr4.length, (this.block.length - this.hLen) - i);
        for (int i4 = 0; i4 != maskGeneratorFunction1.length; i4++) {
            byte[] bArr6 = this.block;
            bArr6[i4] = (byte) (bArr6[i4] ^ maskGeneratorFunction1[i4]);
        }
        byte[] bArr7 = this.block;
        int length3 = bArr7.length;
        int i5 = this.hLen;
        System.arraycopy(bArr4, 0, bArr7, (length3 - i5) - i, i5);
        int i6 = this.trailer;
        if (i6 == 188) {
            byte[] bArr8 = this.block;
            bArr8[bArr8.length - 1] = PSSSigner.TRAILER_IMPLICIT;
        } else {
            byte[] bArr9 = this.block;
            bArr9[bArr9.length - 2] = (byte) (i6 >>> 8);
            bArr9[bArr9.length - 1] = (byte) i6;
        }
        byte[] bArr10 = this.block;
        bArr10[0] = (byte) (bArr10[0] & Byte.MAX_VALUE);
        byte[] processBlock = this.cipher.processBlock(bArr10, 0, bArr10.length);
        clearBlock(this.mBuf);
        clearBlock(this.block);
        this.messageLength = 0;
        return processBlock;
    }

    public boolean verifySignature(byte[] bArr) {
        try {
            byte[] processBlock = this.cipher.processBlock(bArr, 0, bArr.length);
            int length = processBlock.length;
            int i = this.keyBits;
            if (length < (i + 7) / 8) {
                byte[] bArr2 = new byte[((i + 7) / 8)];
                System.arraycopy(processBlock, 0, bArr2, bArr2.length - processBlock.length, processBlock.length);
                clearBlock(processBlock);
                processBlock = bArr2;
            }
            int i2 = 2;
            if (((processBlock[processBlock.length - 1] & 255) ^ PSSSigner.TRAILER_IMPLICIT) == 0) {
                i2 = 1;
            } else {
                byte b = ((processBlock[processBlock.length - 2] & 255) << 8) | (processBlock[processBlock.length - 1] & 255);
                if (b != 12748) {
                    if (b != 13004) {
                        if (b != 13260) {
                            throw new IllegalArgumentException("unrecognised hash in signature");
                        } else if (!(this.digest instanceof SHA1Digest)) {
                            throw new IllegalStateException("signer should be initialised with SHA1");
                        }
                    } else if (!(this.digest instanceof RIPEMD128Digest)) {
                        throw new IllegalStateException("signer should be initialised with RIPEMD128");
                    }
                } else if (!(this.digest instanceof RIPEMD160Digest)) {
                    throw new IllegalStateException("signer should be initialised with RIPEMD160");
                }
            }
            byte[] bArr3 = new byte[this.hLen];
            this.digest.doFinal(bArr3, 0);
            int length2 = processBlock.length;
            int i3 = this.hLen;
            byte[] maskGeneratorFunction1 = maskGeneratorFunction1(processBlock, (length2 - i3) - i2, i3, (processBlock.length - i3) - i2);
            for (int i4 = 0; i4 != maskGeneratorFunction1.length; i4++) {
                processBlock[i4] = (byte) (processBlock[i4] ^ maskGeneratorFunction1[i4]);
            }
            processBlock[0] = (byte) (processBlock[0] & Byte.MAX_VALUE);
            int i5 = 0;
            while (i5 != processBlock.length && processBlock[i5] != 1) {
                i5++;
            }
            int i6 = i5 + 1;
            if (i6 >= processBlock.length) {
                clearBlock(processBlock);
                return false;
            }
            this.fullMessage = i6 > 1;
            this.recoveredMessage = new byte[((maskGeneratorFunction1.length - i6) - this.saltLength)];
            byte[] bArr4 = this.recoveredMessage;
            System.arraycopy(processBlock, i6, bArr4, 0, bArr4.length);
            byte[] bArr5 = new byte[8];
            LtoOSP((long) (this.recoveredMessage.length * 8), bArr5);
            this.digest.update(bArr5, 0, bArr5.length);
            byte[] bArr6 = this.recoveredMessage;
            if (bArr6.length != 0) {
                this.digest.update(bArr6, 0, bArr6.length);
            }
            this.digest.update(bArr3, 0, bArr3.length);
            this.digest.update(processBlock, i6 + this.recoveredMessage.length, this.saltLength);
            byte[] bArr7 = new byte[this.digest.getDigestSize()];
            this.digest.doFinal(bArr7, 0);
            int length3 = (processBlock.length - i2) - bArr7.length;
            boolean z = true;
            for (int i7 = 0; i7 != bArr7.length; i7++) {
                if (bArr7[i7] != processBlock[length3 + i7]) {
                    z = false;
                }
            }
            clearBlock(processBlock);
            clearBlock(bArr7);
            if (!z) {
                this.fullMessage = false;
                clearBlock(this.recoveredMessage);
                return false;
            }
            if (this.messageLength != 0) {
                if (!isSameAs(this.mBuf, this.recoveredMessage)) {
                    clearBlock(this.mBuf);
                    return false;
                }
                this.messageLength = 0;
            }
            clearBlock(this.mBuf);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean hasFullMessage() {
        return this.fullMessage;
    }

    public byte[] getRecoveredMessage() {
        return this.recoveredMessage;
    }

    private void ItoOSP(int i, byte[] bArr) {
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) (i >>> 0);
    }

    private void LtoOSP(long j, byte[] bArr) {
        bArr[0] = (byte) ((int) (j >>> 56));
        bArr[1] = (byte) ((int) (j >>> 48));
        bArr[2] = (byte) ((int) (j >>> 40));
        bArr[3] = (byte) ((int) (j >>> 32));
        bArr[4] = (byte) ((int) (j >>> 24));
        bArr[5] = (byte) ((int) (j >>> 16));
        bArr[6] = (byte) ((int) (j >>> 8));
        bArr[7] = (byte) ((int) (j >>> 0));
    }

    private byte[] maskGeneratorFunction1(byte[] bArr, int i, int i2, int i3) {
        int i4;
        byte[] bArr2 = new byte[i3];
        byte[] bArr3 = new byte[this.hLen];
        byte[] bArr4 = new byte[4];
        this.digest.reset();
        int i5 = 0;
        while (true) {
            i4 = this.hLen;
            if (i5 >= i3 / i4) {
                break;
            }
            ItoOSP(i5, bArr4);
            this.digest.update(bArr, i, i2);
            this.digest.update(bArr4, 0, bArr4.length);
            this.digest.doFinal(bArr3, 0);
            int i6 = this.hLen;
            System.arraycopy(bArr3, 0, bArr2, i5 * i6, i6);
            i5++;
        }
        if (i4 * i5 < i3) {
            ItoOSP(i5, bArr4);
            this.digest.update(bArr, i, i2);
            this.digest.update(bArr4, 0, bArr4.length);
            this.digest.doFinal(bArr3, 0);
            int i7 = this.hLen;
            System.arraycopy(bArr3, 0, bArr2, i5 * i7, bArr2.length - (i5 * i7));
        }
        return bArr2;
    }
}
