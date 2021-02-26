package repack.org.bouncycastle.asn1.ocsp;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERIA5String;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class CrlID extends ASN1Encodable {
    DERInteger crlNum;
    DERGeneralizedTime crlTime;
    DERIA5String crlUrl;

    public CrlID(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 0) {
                this.crlUrl = DERIA5String.getInstance(aSN1TaggedObject, true);
            } else if (tagNo == 1) {
                this.crlNum = DERInteger.getInstance(aSN1TaggedObject, true);
            } else if (tagNo == 2) {
                this.crlTime = DERGeneralizedTime.getInstance(aSN1TaggedObject, true);
            } else {
                throw new IllegalArgumentException("unknown tag number: " + aSN1TaggedObject.getTagNo());
            }
        }
    }

    public DERIA5String getCrlUrl() {
        return this.crlUrl;
    }

    public DERInteger getCrlNum() {
        return this.crlNum;
    }

    public DERGeneralizedTime getCrlTime() {
        return this.crlTime;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        DERIA5String dERIA5String = this.crlUrl;
        if (dERIA5String != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, dERIA5String));
        }
        DERInteger dERInteger = this.crlNum;
        if (dERInteger != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, dERInteger));
        }
        DERGeneralizedTime dERGeneralizedTime = this.crlTime;
        if (dERGeneralizedTime != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 2, dERGeneralizedTime));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
