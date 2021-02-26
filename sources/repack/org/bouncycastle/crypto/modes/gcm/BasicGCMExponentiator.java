package repack.org.bouncycastle.crypto.modes.gcm;

import repack.org.bouncycastle.util.Arrays;

public class BasicGCMExponentiator implements GCMExponentiator {

    /* renamed from: x */
    private byte[] f6168x;

    public void init(byte[] bArr) {
        this.f6168x = Arrays.clone(bArr);
    }

    public void exponentiateX(long j, byte[] bArr) {
        byte[] oneAsBytes = GCMUtil.oneAsBytes();
        if (j > 0) {
            byte[] clone = Arrays.clone(this.f6168x);
            do {
                if ((1 & j) != 0) {
                    GCMUtil.multiply(oneAsBytes, clone);
                }
                GCMUtil.multiply(clone, clone);
                j >>>= 1;
            } while (j > 0);
        }
        System.arraycopy(oneAsBytes, 0, bArr, 0, 16);
    }
}
