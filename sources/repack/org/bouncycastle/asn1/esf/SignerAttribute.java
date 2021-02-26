package repack.org.bouncycastle.asn1.esf;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.x509.AttributeCertificate;

public class SignerAttribute extends ASN1Encodable {
    private AttributeCertificate certifiedAttributes;
    private ASN1Sequence claimedAttributes;

    public static SignerAttribute getInstance(Object obj) {
        if (obj == null || (obj instanceof SignerAttribute)) {
            return (SignerAttribute) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SignerAttribute(obj);
        }
        throw new IllegalArgumentException("unknown object in 'SignerAttribute' factory: " + obj.getClass().getName() + ".");
    }

    private SignerAttribute(Object obj) {
        DERTaggedObject dERTaggedObject = (DERTaggedObject) ((ASN1Sequence) obj).getObjectAt(0);
        if (dERTaggedObject.getTagNo() == 0) {
            this.claimedAttributes = ASN1Sequence.getInstance(dERTaggedObject, true);
        } else if (dERTaggedObject.getTagNo() == 1) {
            this.certifiedAttributes = AttributeCertificate.getInstance(dERTaggedObject);
        } else {
            throw new IllegalArgumentException("illegal tag.");
        }
    }

    public SignerAttribute(ASN1Sequence aSN1Sequence) {
        this.claimedAttributes = aSN1Sequence;
    }

    public SignerAttribute(AttributeCertificate attributeCertificate) {
        this.certifiedAttributes = attributeCertificate;
    }

    public ASN1Sequence getClaimedAttributes() {
        return this.claimedAttributes;
    }

    public AttributeCertificate getCertifiedAttributes() {
        return this.certifiedAttributes;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Sequence aSN1Sequence = this.claimedAttributes;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(new DERTaggedObject(0, aSN1Sequence));
        } else {
            aSN1EncodableVector.add(new DERTaggedObject(1, this.certifiedAttributes));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
