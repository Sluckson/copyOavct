package repack.org.bouncycastle.asn1.x500;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class AttributeTypeAndValue extends ASN1Encodable {
    private ASN1ObjectIdentifier type;
    private ASN1Encodable value;

    private AttributeTypeAndValue(ASN1Sequence aSN1Sequence) {
        this.type = (ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(0);
        this.value = (ASN1Encodable) aSN1Sequence.getObjectAt(1);
    }

    public static AttributeTypeAndValue getInstance(Object obj) {
        if (obj instanceof AttributeTypeAndValue) {
            return (AttributeTypeAndValue) obj;
        }
        if (obj != null) {
            return new AttributeTypeAndValue(ASN1Sequence.getInstance(obj));
        }
        throw new IllegalArgumentException("null value in getInstance()");
    }

    public AttributeTypeAndValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.type = aSN1ObjectIdentifier;
        this.value = aSN1Encodable;
    }

    public ASN1ObjectIdentifier getType() {
        return this.type;
    }

    public ASN1Encodable getValue() {
        return this.value;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.type);
        aSN1EncodableVector.add(this.value);
        return new DERSequence(aSN1EncodableVector);
    }
}
