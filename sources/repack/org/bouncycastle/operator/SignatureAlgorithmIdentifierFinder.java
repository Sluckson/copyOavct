package repack.org.bouncycastle.operator;

import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public interface SignatureAlgorithmIdentifierFinder {
    AlgorithmIdentifier find(String str);
}
