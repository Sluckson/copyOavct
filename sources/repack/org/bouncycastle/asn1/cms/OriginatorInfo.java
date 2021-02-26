package repack.org.bouncycastle.asn1.cms;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class OriginatorInfo extends ASN1Encodable {
    private ASN1Set certs;
    private ASN1Set crls;

    public OriginatorInfo(ASN1Set aSN1Set, ASN1Set aSN1Set2) {
        this.certs = aSN1Set;
        this.crls = aSN1Set2;
    }

    public OriginatorInfo(ASN1Sequence aSN1Sequence) {
        int size = aSN1Sequence.size();
        if (size == 0) {
            return;
        }
        if (size == 1) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(0);
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 0) {
                this.certs = ASN1Set.getInstance(aSN1TaggedObject, false);
            } else if (tagNo == 1) {
                this.crls = ASN1Set.getInstance(aSN1TaggedObject, false);
            } else {
                throw new IllegalArgumentException("Bad tag in OriginatorInfo: " + aSN1TaggedObject.getTagNo());
            }
        } else if (size == 2) {
            this.certs = ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(0), false);
            this.crls = ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), false);
        } else {
            throw new IllegalArgumentException("OriginatorInfo too big");
        }
    }

    public static OriginatorInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static OriginatorInfo getInstance(Object obj) {
        if (obj == null || (obj instanceof OriginatorInfo)) {
            return (OriginatorInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new OriginatorInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid OriginatorInfo: " + obj.getClass().getName());
    }

    public ASN1Set getCertificates() {
        return this.certs;
    }

    public ASN1Set getCRLs() {
        return this.crls;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Set aSN1Set = this.certs;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1Set));
        }
        ASN1Set aSN1Set2 = this.crls;
        if (aSN1Set2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, aSN1Set2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
