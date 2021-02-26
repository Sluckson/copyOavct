package repack.org.bouncycastle.crypto.generators;

import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.DerivationFunction;
import repack.org.bouncycastle.crypto.DerivationParameters;
import repack.org.bouncycastle.crypto.Digest;
import repack.org.bouncycastle.crypto.params.ISO18033KDFParameters;
import repack.org.bouncycastle.crypto.params.KDFParameters;

public class BaseKDFBytesGenerator implements DerivationFunction {
    private int counterStart;
    private Digest digest;

    /* renamed from: iv */
    private byte[] f6133iv;
    private byte[] shared;

    protected BaseKDFBytesGenerator(int i, Digest digest2) {
        this.counterStart = i;
        this.digest = digest2;
    }

    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFParameters) {
            KDFParameters kDFParameters = (KDFParameters) derivationParameters;
            this.shared = kDFParameters.getSharedSecret();
            this.f6133iv = kDFParameters.getIV();
        } else if (derivationParameters instanceof ISO18033KDFParameters) {
            this.shared = ((ISO18033KDFParameters) derivationParameters).getSeed();
            this.f6133iv = null;
        } else {
            throw new IllegalArgumentException("KDF parameters required for KDF2Generator");
        }
    }

    public Digest getDigest() {
        return this.digest;
    }

    public int generateBytes(byte[] bArr, int i, int i2) throws DataLengthException, IllegalArgumentException {
        if (bArr.length - i2 >= i) {
            long j = (long) i2;
            int digestSize = this.digest.getDigestSize();
            if (j <= 8589934591L) {
                long j2 = (long) digestSize;
                int i3 = (int) (((j + j2) - 1) / j2);
                byte[] bArr2 = new byte[this.digest.getDigestSize()];
                int i4 = this.counterStart;
                int i5 = i;
                for (int i6 = 0; i6 < i3; i6++) {
                    Digest digest2 = this.digest;
                    byte[] bArr3 = this.shared;
                    digest2.update(bArr3, 0, bArr3.length);
                    this.digest.update((byte) (i4 >> 24));
                    this.digest.update((byte) (i4 >> 16));
                    this.digest.update((byte) (i4 >> 8));
                    this.digest.update((byte) i4);
                    byte[] bArr4 = this.f6133iv;
                    if (bArr4 != null) {
                        this.digest.update(bArr4, 0, bArr4.length);
                    }
                    this.digest.doFinal(bArr2, 0);
                    if (i2 > digestSize) {
                        System.arraycopy(bArr2, 0, bArr, i5, digestSize);
                        i5 += digestSize;
                        i2 -= digestSize;
                    } else {
                        System.arraycopy(bArr2, 0, bArr, i5, i2);
                    }
                    i4++;
                }
                this.digest.reset();
                return i2;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new DataLengthException("output buffer too small");
    }
}
