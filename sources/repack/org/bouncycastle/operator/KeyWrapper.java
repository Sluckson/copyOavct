package repack.org.bouncycastle.operator;

import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public interface KeyWrapper {
    byte[] generateWrappedKey(GenericKey genericKey) throws OperatorException;

    AlgorithmIdentifier getAlgorithmIdentifier();
}
