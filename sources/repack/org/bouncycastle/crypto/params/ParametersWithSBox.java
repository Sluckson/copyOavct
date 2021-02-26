package repack.org.bouncycastle.crypto.params;

import repack.org.bouncycastle.crypto.CipherParameters;

public class ParametersWithSBox implements CipherParameters {
    private CipherParameters parameters;
    private byte[] sBox;

    public ParametersWithSBox(CipherParameters cipherParameters, byte[] bArr) {
        this.parameters = cipherParameters;
        this.sBox = bArr;
    }

    public byte[] getSBox() {
        return this.sBox;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}
