package repack.org.bouncycastle.asn1.cms;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSequence;

public class KEKIdentifier extends ASN1Encodable {
    private DERGeneralizedTime date;
    private ASN1OctetString keyIdentifier;
    private OtherKeyAttribute other;

    public KEKIdentifier(byte[] bArr, DERGeneralizedTime dERGeneralizedTime, OtherKeyAttribute otherKeyAttribute) {
        this.keyIdentifier = new DEROctetString(bArr);
        this.date = dERGeneralizedTime;
        this.other = otherKeyAttribute;
    }

    public KEKIdentifier(ASN1Sequence aSN1Sequence) {
        this.keyIdentifier = (ASN1OctetString) aSN1Sequence.getObjectAt(0);
        int size = aSN1Sequence.size();
        if (size == 1) {
            return;
        }
        if (size != 2) {
            if (size == 3) {
                this.date = (DERGeneralizedTime) aSN1Sequence.getObjectAt(1);
                this.other = OtherKeyAttribute.getInstance(aSN1Sequence.getObjectAt(2));
                return;
            }
            throw new IllegalArgumentException("Invalid KEKIdentifier");
        } else if (aSN1Sequence.getObjectAt(1) instanceof DERGeneralizedTime) {
            this.date = (DERGeneralizedTime) aSN1Sequence.getObjectAt(1);
        } else {
            this.other = OtherKeyAttribute.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public static KEKIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static KEKIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof KEKIdentifier)) {
            return (KEKIdentifier) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new KEKIdentifier((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid KEKIdentifier: " + obj.getClass().getName());
    }

    public ASN1OctetString getKeyIdentifier() {
        return this.keyIdentifier;
    }

    public DERGeneralizedTime getDate() {
        return this.date;
    }

    public OtherKeyAttribute getOther() {
        return this.other;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.keyIdentifier);
        DERGeneralizedTime dERGeneralizedTime = this.date;
        if (dERGeneralizedTime != null) {
            aSN1EncodableVector.add(dERGeneralizedTime);
        }
        OtherKeyAttribute otherKeyAttribute = this.other;
        if (otherKeyAttribute != null) {
            aSN1EncodableVector.add(otherKeyAttribute);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
