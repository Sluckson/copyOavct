package repack.org.bouncycastle.asn1.cms;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;

public class OtherRecipientInfo extends ASN1Encodable {
    private DERObjectIdentifier oriType;
    private DEREncodable oriValue;

    public OtherRecipientInfo(DERObjectIdentifier dERObjectIdentifier, DEREncodable dEREncodable) {
        this.oriType = dERObjectIdentifier;
        this.oriValue = dEREncodable;
    }

    public OtherRecipientInfo(ASN1Sequence aSN1Sequence) {
        this.oriType = DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.oriValue = aSN1Sequence.getObjectAt(1);
    }

    public static OtherRecipientInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static OtherRecipientInfo getInstance(Object obj) {
        if (obj == null || (obj instanceof OtherRecipientInfo)) {
            return (OtherRecipientInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new OtherRecipientInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid OtherRecipientInfo: " + obj.getClass().getName());
    }

    public DERObjectIdentifier getType() {
        return this.oriType;
    }

    public DEREncodable getValue() {
        return this.oriValue;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.oriType);
        aSN1EncodableVector.add(this.oriValue);
        return new DERSequence(aSN1EncodableVector);
    }
}
