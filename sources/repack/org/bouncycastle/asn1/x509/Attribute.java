package repack.org.bouncycastle.asn1.x509;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERSequence;

public class Attribute extends ASN1Encodable {
    private DERObjectIdentifier attrType;
    private ASN1Set attrValues;

    public static Attribute getInstance(Object obj) {
        if (obj == null || (obj instanceof Attribute)) {
            return (Attribute) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new Attribute((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public Attribute(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.attrType = DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.attrValues = ASN1Set.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public Attribute(DERObjectIdentifier dERObjectIdentifier, ASN1Set aSN1Set) {
        this.attrType = dERObjectIdentifier;
        this.attrValues = aSN1Set;
    }

    public ASN1ObjectIdentifier getAttrType() {
        return new ASN1ObjectIdentifier(this.attrType.getId());
    }

    public ASN1Encodable[] getAttributeValues() {
        return this.attrValues.toArray();
    }

    public ASN1Set getAttrValues() {
        return this.attrValues;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.attrType);
        aSN1EncodableVector.add(this.attrValues);
        return new DERSequence(aSN1EncodableVector);
    }
}
