package repack.org.bouncycastle.crypto;

public class AsymmetricCipherKeyPair {
    private CipherParameters privateParam;
    private CipherParameters publicParam;

    public AsymmetricCipherKeyPair(CipherParameters cipherParameters, CipherParameters cipherParameters2) {
        this.publicParam = cipherParameters;
        this.privateParam = cipherParameters2;
    }

    public CipherParameters getPublic() {
        return this.publicParam;
    }

    public CipherParameters getPrivate() {
        return this.privateParam;
    }
}
