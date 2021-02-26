package repack.org.bouncycastle.crypto.modes.gcm;

import repack.org.bouncycastle.util.Arrays;

public class BasicGCMMultiplier implements GCMMultiplier {

    /* renamed from: H */
    private byte[] f6169H;

    public void init(byte[] bArr) {
        this.f6169H = Arrays.clone(bArr);
    }

    public void multiplyH(byte[] bArr) {
        GCMUtil.multiply(bArr, this.f6169H);
    }
}
