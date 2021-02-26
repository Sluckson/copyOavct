package repack.org.bouncycastle.asn1.esf;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.ocsp.ResponderID;

public class OcspIdentifier extends ASN1Encodable {
    private ResponderID ocspResponderID;
    private DERGeneralizedTime producedAt;

    public static OcspIdentifier getInstance(Object obj) {
        if (obj instanceof OcspIdentifier) {
            return (OcspIdentifier) obj;
        }
        if (obj != null) {
            return new OcspIdentifier(ASN1Sequence.getInstance(obj));
        }
        throw new IllegalArgumentException("null value in getInstance");
    }

    private OcspIdentifier(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.ocspResponderID = ResponderID.getInstance(aSN1Sequence.getObjectAt(0));
            this.producedAt = (DERGeneralizedTime) aSN1Sequence.getObjectAt(1);
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public OcspIdentifier(ResponderID responderID, DERGeneralizedTime dERGeneralizedTime) {
        this.ocspResponderID = responderID;
        this.producedAt = dERGeneralizedTime;
    }

    public ResponderID getOcspResponderID() {
        return this.ocspResponderID;
    }

    public DERGeneralizedTime getProducedAt() {
        return this.producedAt;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.ocspResponderID);
        aSN1EncodableVector.add(this.producedAt);
        return new DERSequence(aSN1EncodableVector);
    }
}
