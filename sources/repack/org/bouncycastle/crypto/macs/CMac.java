package repack.org.bouncycastle.crypto.macs;

import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.Mac;
import repack.org.bouncycastle.crypto.modes.CBCBlockCipher;
import repack.org.bouncycastle.crypto.paddings.ISO7816d4Padding;

public class CMac implements Mac {
    private static final byte CONSTANT_128 = -121;
    private static final byte CONSTANT_64 = 27;

    /* renamed from: L */
    private byte[] f6138L;

    /* renamed from: Lu */
    private byte[] f6139Lu;
    private byte[] Lu2;
    private byte[] ZEROES;
    private byte[] buf;
    private int bufOff;
    private BlockCipher cipher;
    private byte[] mac;
    private int macSize;

    public CMac(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8);
    }

    public CMac(BlockCipher blockCipher, int i) {
        if (i % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        } else if (i > blockCipher.getBlockSize() * 8) {
            throw new IllegalArgumentException("MAC size must be less or equal to " + (blockCipher.getBlockSize() * 8));
        } else if (blockCipher.getBlockSize() == 8 || blockCipher.getBlockSize() == 16) {
            this.cipher = new CBCBlockCipher(blockCipher);
            this.macSize = i / 8;
            this.mac = new byte[blockCipher.getBlockSize()];
            this.buf = new byte[blockCipher.getBlockSize()];
            this.ZEROES = new byte[blockCipher.getBlockSize()];
            this.bufOff = 0;
        } else {
            throw new IllegalArgumentException("Block size must be either 64 or 128 bits");
        }
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName();
    }

    private byte[] doubleLu(byte[] bArr) {
        int i = 0;
        int i2 = (bArr[0] & 255) >> 7;
        byte[] bArr2 = new byte[bArr.length];
        while (i < bArr.length - 1) {
            int i3 = i + 1;
            bArr2[i] = (byte) ((bArr[i] << 1) + ((bArr[i3] & 255) >> 7));
            i = i3;
        }
        bArr2[bArr.length - 1] = (byte) (bArr[bArr.length - 1] << 1);
        if (i2 == 1) {
            int length = bArr.length - 1;
            bArr2[length] = (byte) ((bArr.length == 16 ? CONSTANT_128 : 27) ^ bArr2[length]);
        }
        return bArr2;
    }

    public void init(CipherParameters cipherParameters) {
        reset();
        this.cipher.init(true, cipherParameters);
        byte[] bArr = this.ZEROES;
        this.f6138L = new byte[bArr.length];
        this.cipher.processBlock(bArr, 0, this.f6138L, 0);
        this.f6139Lu = doubleLu(this.f6138L);
        this.Lu2 = doubleLu(this.f6139Lu);
        this.cipher.init(true, cipherParameters);
    }

    public int getMacSize() {
        return this.macSize;
    }

    public void update(byte b) {
        int i = this.bufOff;
        byte[] bArr = this.buf;
        if (i == bArr.length) {
            this.cipher.processBlock(bArr, 0, this.mac, 0);
            this.bufOff = 0;
        }
        byte[] bArr2 = this.buf;
        int i2 = this.bufOff;
        this.bufOff = i2 + 1;
        bArr2[i2] = b;
    }

    public void update(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            int blockSize = this.cipher.getBlockSize();
            int i3 = this.bufOff;
            int i4 = blockSize - i3;
            if (i2 > i4) {
                System.arraycopy(bArr, i, this.buf, i3, i4);
                this.cipher.processBlock(this.buf, 0, this.mac, 0);
                this.bufOff = 0;
                i2 -= i4;
                i += i4;
                while (i2 > blockSize) {
                    this.cipher.processBlock(bArr, i, this.mac, 0);
                    i2 -= blockSize;
                    i += blockSize;
                }
            }
            System.arraycopy(bArr, i, this.buf, this.bufOff, i2);
            this.bufOff += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    public int doFinal(byte[] bArr, int i) {
        byte[] bArr2;
        if (this.bufOff == this.cipher.getBlockSize()) {
            bArr2 = this.f6139Lu;
        } else {
            new ISO7816d4Padding().addPadding(this.buf, this.bufOff);
            bArr2 = this.Lu2;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr3 = this.mac;
            if (i2 >= bArr3.length) {
                this.cipher.processBlock(this.buf, 0, bArr3, 0);
                System.arraycopy(this.mac, 0, bArr, i, this.macSize);
                reset();
                return this.macSize;
            }
            byte[] bArr4 = this.buf;
            bArr4[i2] = (byte) (bArr4[i2] ^ bArr2[i2]);
            i2++;
        }
    }

    public void reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.buf;
            if (i >= bArr.length) {
                this.bufOff = 0;
                this.cipher.reset();
                return;
            }
            bArr[i] = 0;
            i++;
        }
    }
}
