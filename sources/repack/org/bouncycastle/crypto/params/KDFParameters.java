package repack.org.bouncycastle.crypto.params;

import repack.org.bouncycastle.crypto.DerivationParameters;

public class KDFParameters implements DerivationParameters {

    /* renamed from: iv */
    byte[] f6203iv;
    byte[] shared;

    public KDFParameters(byte[] bArr, byte[] bArr2) {
        this.shared = bArr;
        this.f6203iv = bArr2;
    }

    public byte[] getSharedSecret() {
        return this.shared;
    }

    public byte[] getIV() {
        return this.f6203iv;
    }
}
