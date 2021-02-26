package repack.org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Vector;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class NameConstraints extends ASN1Encodable {
    private ASN1Sequence excluded;
    private ASN1Sequence permitted;

    public NameConstraints(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(objects.nextElement());
            int tagNo = instance.getTagNo();
            if (tagNo == 0) {
                this.permitted = ASN1Sequence.getInstance(instance, false);
            } else if (tagNo == 1) {
                this.excluded = ASN1Sequence.getInstance(instance, false);
            }
        }
    }

    public NameConstraints(Vector vector, Vector vector2) {
        if (vector != null) {
            this.permitted = createSequence(vector);
        }
        if (vector2 != null) {
            this.excluded = createSequence(vector2);
        }
    }

    private DERSequence createSequence(Vector vector) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            aSN1EncodableVector.add((GeneralSubtree) elements.nextElement());
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public ASN1Sequence getPermittedSubtrees() {
        return this.permitted;
    }

    public ASN1Sequence getExcludedSubtrees() {
        return this.excluded;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Sequence aSN1Sequence = this.permitted;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1Sequence));
        }
        ASN1Sequence aSN1Sequence2 = this.excluded;
        if (aSN1Sequence2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, aSN1Sequence2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
