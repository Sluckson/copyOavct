package repack.org.bouncycastle.asn1.pkcs;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class KeyDerivationFunc extends AlgorithmIdentifier {
    KeyDerivationFunc(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    public KeyDerivationFunc(DERObjectIdentifier dERObjectIdentifier, ASN1Encodable aSN1Encodable) {
        super(dERObjectIdentifier, aSN1Encodable);
    }
}
