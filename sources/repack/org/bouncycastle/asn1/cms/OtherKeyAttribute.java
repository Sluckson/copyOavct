package repack.org.bouncycastle.asn1.cms;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;

public class OtherKeyAttribute extends ASN1Encodable {
    private DEREncodable keyAttr;
    private DERObjectIdentifier keyAttrId;

    public static OtherKeyAttribute getInstance(Object obj) {
        if (obj == null || (obj instanceof OtherKeyAttribute)) {
            return (OtherKeyAttribute) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new OtherKeyAttribute((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public OtherKeyAttribute(ASN1Sequence aSN1Sequence) {
        this.keyAttrId = (DERObjectIdentifier) aSN1Sequence.getObjectAt(0);
        this.keyAttr = aSN1Sequence.getObjectAt(1);
    }

    public OtherKeyAttribute(DERObjectIdentifier dERObjectIdentifier, DEREncodable dEREncodable) {
        this.keyAttrId = dERObjectIdentifier;
        this.keyAttr = dEREncodable;
    }

    public DERObjectIdentifier getKeyAttrId() {
        return this.keyAttrId;
    }

    public DEREncodable getKeyAttr() {
        return this.keyAttr;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.keyAttrId);
        aSN1EncodableVector.add(this.keyAttr);
        return new DERSequence(aSN1EncodableVector);
    }
}
