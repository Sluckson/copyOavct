package repack.org.bouncycastle.asn1.ocsp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class OCSPRequest extends ASN1Encodable {
    Signature optionalSignature;
    TBSRequest tbsRequest;

    public OCSPRequest(TBSRequest tBSRequest, Signature signature) {
        this.tbsRequest = tBSRequest;
        this.optionalSignature = signature;
    }

    public OCSPRequest(ASN1Sequence aSN1Sequence) {
        this.tbsRequest = TBSRequest.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() == 2) {
            this.optionalSignature = Signature.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true);
        }
    }

    public static OCSPRequest getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static OCSPRequest getInstance(Object obj) {
        if (obj == null || (obj instanceof OCSPRequest)) {
            return (OCSPRequest) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new OCSPRequest((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public TBSRequest getTbsRequest() {
        return this.tbsRequest;
    }

    public Signature getOptionalSignature() {
        return this.optionalSignature;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.tbsRequest);
        Signature signature = this.optionalSignature;
        if (signature != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, signature));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
