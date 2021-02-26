package repack.org.bouncycastle.asn1.esf;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class OtherHashAlgAndValue extends ASN1Encodable {
    private AlgorithmIdentifier hashAlgorithm;
    private ASN1OctetString hashValue;

    public static OtherHashAlgAndValue getInstance(Object obj) {
        if (obj instanceof OtherHashAlgAndValue) {
            return (OtherHashAlgAndValue) obj;
        }
        if (obj != null) {
            return new OtherHashAlgAndValue(ASN1Sequence.getInstance(obj));
        }
        throw new IllegalArgumentException("null value in getInstance");
    }

    private OtherHashAlgAndValue(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.hashAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.hashValue = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public OtherHashAlgAndValue(AlgorithmIdentifier algorithmIdentifier, ASN1OctetString aSN1OctetString) {
        this.hashAlgorithm = algorithmIdentifier;
        this.hashValue = aSN1OctetString;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public ASN1OctetString getHashValue() {
        return this.hashValue;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.hashAlgorithm);
        aSN1EncodableVector.add(this.hashValue);
        return new DERSequence(aSN1EncodableVector);
    }
}
