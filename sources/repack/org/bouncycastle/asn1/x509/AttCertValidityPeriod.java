package repack.org.bouncycastle.asn1.x509;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class AttCertValidityPeriod extends ASN1Encodable {
    DERGeneralizedTime notAfterTime;
    DERGeneralizedTime notBeforeTime;

    public static AttCertValidityPeriod getInstance(Object obj) {
        if (obj instanceof AttCertValidityPeriod) {
            return (AttCertValidityPeriod) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new AttCertValidityPeriod((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public AttCertValidityPeriod(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.notBeforeTime = DERGeneralizedTime.getInstance(aSN1Sequence.getObjectAt(0));
            this.notAfterTime = DERGeneralizedTime.getInstance(aSN1Sequence.getObjectAt(1));
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public AttCertValidityPeriod(DERGeneralizedTime dERGeneralizedTime, DERGeneralizedTime dERGeneralizedTime2) {
        this.notBeforeTime = dERGeneralizedTime;
        this.notAfterTime = dERGeneralizedTime2;
    }

    public DERGeneralizedTime getNotBeforeTime() {
        return this.notBeforeTime;
    }

    public DERGeneralizedTime getNotAfterTime() {
        return this.notAfterTime;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.notBeforeTime);
        aSN1EncodableVector.add(this.notAfterTime);
        return new DERSequence(aSN1EncodableVector);
    }
}
