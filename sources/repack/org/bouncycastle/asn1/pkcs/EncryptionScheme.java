package repack.org.bouncycastle.asn1.pkcs;

import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptionScheme extends AlgorithmIdentifier {
    public EncryptionScheme(DERObjectIdentifier dERObjectIdentifier, DEREncodable dEREncodable) {
        super(dERObjectIdentifier, dEREncodable);
    }

    EncryptionScheme(ASN1Sequence aSN1Sequence) {
        this((DERObjectIdentifier) aSN1Sequence.getObjectAt(0), aSN1Sequence.getObjectAt(1));
    }

    public static final AlgorithmIdentifier getInstance(Object obj) {
        if (obj instanceof EncryptionScheme) {
            return (EncryptionScheme) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new EncryptionScheme((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public DERObject getObject() {
        return (DERObject) getParameters();
    }

    public DERObject getDERObject() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(getObjectId());
        aSN1EncodableVector.add(getParameters());
        return new DERSequence(aSN1EncodableVector);
    }
}
