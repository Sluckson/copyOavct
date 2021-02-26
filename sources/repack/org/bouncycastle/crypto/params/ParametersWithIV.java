package repack.org.bouncycastle.crypto.params;

import repack.org.bouncycastle.crypto.CipherParameters;

public class ParametersWithIV implements CipherParameters {

    /* renamed from: iv */
    private byte[] f6206iv;
    private CipherParameters parameters;

    public ParametersWithIV(CipherParameters cipherParameters, byte[] bArr) {
        this(cipherParameters, bArr, 0, bArr.length);
    }

    public ParametersWithIV(CipherParameters cipherParameters, byte[] bArr, int i, int i2) {
        this.f6206iv = new byte[i2];
        this.parameters = cipherParameters;
        System.arraycopy(bArr, i, this.f6206iv, 0, i2);
    }

    public byte[] getIV() {
        return this.f6206iv;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}
