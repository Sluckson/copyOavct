package repack.org.bouncycastle.cert.crmf;

import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.Digest;
import repack.org.bouncycastle.crypto.digests.SHA1Digest;
import repack.org.bouncycastle.crypto.generators.MGF1BytesGenerator;
import repack.org.bouncycastle.crypto.params.MGFParameters;

public class FixedLengthMGF1Padder implements EncryptedValuePadder {
    private Digest dig;
    private int length;
    private SecureRandom random;

    public FixedLengthMGF1Padder(int i) {
        this(i, (SecureRandom) null);
    }

    public FixedLengthMGF1Padder(int i, SecureRandom secureRandom) {
        this.dig = new SHA1Digest();
        this.length = i;
        this.random = secureRandom;
    }

    public byte[] getPaddedData(byte[] bArr) {
        byte[] bArr2 = new byte[this.length];
        byte[] bArr3 = new byte[this.dig.getDigestSize()];
        byte[] bArr4 = new byte[(this.length - this.dig.getDigestSize())];
        if (this.random == null) {
            this.random = new SecureRandom();
        }
        this.random.nextBytes(bArr3);
        MGF1BytesGenerator mGF1BytesGenerator = new MGF1BytesGenerator(this.dig);
        mGF1BytesGenerator.init(new MGFParameters(bArr3));
        mGF1BytesGenerator.generateBytes(bArr4, 0, bArr4.length);
        System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
        System.arraycopy(bArr, 0, bArr2, bArr3.length, bArr.length);
        for (int length2 = bArr3.length + bArr.length + 1; length2 != bArr2.length; length2++) {
            byte nextInt = (byte) this.random.nextInt();
            if (nextInt == 0) {
                nextInt = 1;
            }
            bArr2[length2] = nextInt;
        }
        for (int i = 0; i != bArr4.length; i++) {
            int length3 = bArr3.length + i;
            bArr2[length3] = (byte) (bArr2[length3] ^ bArr4[i]);
        }
        return bArr2;
    }

    public byte[] getUnpaddedData(byte[] bArr) {
        byte[] bArr2 = new byte[this.dig.getDigestSize()];
        byte[] bArr3 = new byte[(this.length - this.dig.getDigestSize())];
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        MGF1BytesGenerator mGF1BytesGenerator = new MGF1BytesGenerator(this.dig);
        mGF1BytesGenerator.init(new MGFParameters(bArr2));
        mGF1BytesGenerator.generateBytes(bArr3, 0, bArr3.length);
        for (int i = 0; i != bArr3.length; i++) {
            int length2 = bArr2.length + i;
            bArr[length2] = (byte) (bArr[length2] ^ bArr3[i]);
        }
        int length3 = bArr.length;
        while (true) {
            length3--;
            if (length3 == bArr2.length) {
                length3 = 0;
                break;
            } else if (bArr[length3] == 0) {
                break;
            }
        }
        if (length3 != 0) {
            byte[] bArr4 = new byte[(length3 - bArr2.length)];
            System.arraycopy(bArr, bArr2.length, bArr4, 0, bArr4.length);
            return bArr4;
        }
        throw new IllegalStateException("bad padding in encoding");
    }
}
