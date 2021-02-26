package repack.org.bouncycastle.operator;

import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public interface KeyUnwrapper {
    GenericKey generateUnwrappedKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) throws OperatorException;

    AlgorithmIdentifier getAlgorithmIdentifier();
}
