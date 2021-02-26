package repack.org.bouncycastle.operator;

import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public abstract class SymmetricKeyWrapper implements KeyWrapper {
    private AlgorithmIdentifier algorithmId;

    protected SymmetricKeyWrapper(AlgorithmIdentifier algorithmIdentifier) {
        this.algorithmId = algorithmIdentifier;
    }

    public AlgorithmIdentifier getAlgorithmIdentifier() {
        return this.algorithmId;
    }
}
