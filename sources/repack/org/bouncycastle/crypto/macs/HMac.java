package repack.org.bouncycastle.crypto.macs;

import java.util.Hashtable;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.Digest;
import repack.org.bouncycastle.crypto.ExtendedDigest;
import repack.org.bouncycastle.crypto.Mac;
import repack.org.bouncycastle.crypto.params.KeyParameter;

public class HMac implements Mac {
    private static final byte IPAD = 54;
    private static final byte OPAD = 92;
    private static Hashtable blockLengths = new Hashtable();
    private int blockLength;
    private Digest digest;
    private int digestSize;
    private byte[] inputPad;
    private byte[] outputPad;

    static {
        blockLengths.put("GOST3411", new Integer(32));
        blockLengths.put("MD2", new Integer(16));
        blockLengths.put("MD4", new Integer(64));
        blockLengths.put("MD5", new Integer(64));
        blockLengths.put("RIPEMD128", new Integer(64));
        blockLengths.put("RIPEMD160", new Integer(64));
        blockLengths.put("SHA-1", new Integer(64));
        blockLengths.put("SHA-224", new Integer(64));
        blockLengths.put("SHA-256", new Integer(64));
        blockLengths.put("SHA-384", new Integer(128));
        blockLengths.put("SHA-512", new Integer(128));
        blockLengths.put("Tiger", new Integer(64));
        blockLengths.put("Whirlpool", new Integer(64));
    }

    private static int getByteLength(Digest digest2) {
        if (digest2 instanceof ExtendedDigest) {
            return ((ExtendedDigest) digest2).getByteLength();
        }
        Integer num = (Integer) blockLengths.get(digest2.getAlgorithmName());
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("unknown digest passed: " + digest2.getAlgorithmName());
    }

    public HMac(Digest digest2) {
        this(digest2, getByteLength(digest2));
    }

    private HMac(Digest digest2, int i) {
        this.digest = digest2;
        this.digestSize = digest2.getDigestSize();
        this.blockLength = i;
        int i2 = this.blockLength;
        this.inputPad = new byte[i2];
        this.outputPad = new byte[i2];
    }

    public String getAlgorithmName() {
        return String.valueOf(this.digest.getAlgorithmName()) + "/HMAC";
    }

    public Digest getUnderlyingDigest() {
        return this.digest;
    }

    public void init(CipherParameters cipherParameters) {
        this.digest.reset();
        byte[] key = ((KeyParameter) cipherParameters).getKey();
        if (key.length > this.blockLength) {
            this.digest.update(key, 0, key.length);
            this.digest.doFinal(this.inputPad, 0);
            int i = this.digestSize;
            while (true) {
                byte[] bArr = this.inputPad;
                if (i >= bArr.length) {
                    break;
                }
                bArr[i] = 0;
                i++;
            }
        } else {
            System.arraycopy(key, 0, this.inputPad, 0, key.length);
            int length = key.length;
            while (true) {
                byte[] bArr2 = this.inputPad;
                if (length >= bArr2.length) {
                    break;
                }
                bArr2[length] = 0;
                length++;
            }
        }
        byte[] bArr3 = this.inputPad;
        this.outputPad = new byte[bArr3.length];
        System.arraycopy(bArr3, 0, this.outputPad, 0, bArr3.length);
        int i2 = 0;
        while (true) {
            byte[] bArr4 = this.inputPad;
            if (i2 >= bArr4.length) {
                break;
            }
            bArr4[i2] = (byte) (bArr4[i2] ^ IPAD);
            i2++;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr5 = this.outputPad;
            if (i3 >= bArr5.length) {
                Digest digest2 = this.digest;
                byte[] bArr6 = this.inputPad;
                digest2.update(bArr6, 0, bArr6.length);
                return;
            }
            bArr5[i3] = (byte) (bArr5[i3] ^ OPAD);
            i3++;
        }
    }

    public int getMacSize() {
        return this.digestSize;
    }

    public void update(byte b) {
        this.digest.update(b);
    }

    public void update(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
    }

    public int doFinal(byte[] bArr, int i) {
        byte[] bArr2 = new byte[this.digestSize];
        this.digest.doFinal(bArr2, 0);
        Digest digest2 = this.digest;
        byte[] bArr3 = this.outputPad;
        digest2.update(bArr3, 0, bArr3.length);
        this.digest.update(bArr2, 0, bArr2.length);
        int doFinal = this.digest.doFinal(bArr, i);
        reset();
        return doFinal;
    }

    public void reset() {
        this.digest.reset();
        Digest digest2 = this.digest;
        byte[] bArr = this.inputPad;
        digest2.update(bArr, 0, bArr.length);
    }
}
