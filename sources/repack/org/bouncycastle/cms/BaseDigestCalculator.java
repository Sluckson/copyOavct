package repack.org.bouncycastle.cms;

import repack.org.bouncycastle.util.Arrays;

class BaseDigestCalculator implements IntDigestCalculator {
    private final byte[] digest;

    BaseDigestCalculator(byte[] bArr) {
        this.digest = bArr;
    }

    public byte[] getDigest() {
        return Arrays.clone(this.digest);
    }
}
