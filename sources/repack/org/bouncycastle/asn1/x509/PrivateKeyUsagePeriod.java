package repack.org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class PrivateKeyUsagePeriod extends ASN1Encodable {
    private DERGeneralizedTime _notAfter;
    private DERGeneralizedTime _notBefore;

    public static PrivateKeyUsagePeriod getInstance(Object obj) {
        if (obj instanceof PrivateKeyUsagePeriod) {
            return (PrivateKeyUsagePeriod) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new PrivateKeyUsagePeriod((ASN1Sequence) obj);
        }
        if (obj instanceof X509Extension) {
            return getInstance(X509Extension.convertValueToObject((X509Extension) obj));
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    private PrivateKeyUsagePeriod(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            if (aSN1TaggedObject.getTagNo() == 0) {
                this._notBefore = DERGeneralizedTime.getInstance(aSN1TaggedObject, false);
            } else if (aSN1TaggedObject.getTagNo() == 1) {
                this._notAfter = DERGeneralizedTime.getInstance(aSN1TaggedObject, false);
            }
        }
    }

    public DERGeneralizedTime getNotBefore() {
        return this._notBefore;
    }

    public DERGeneralizedTime getNotAfter() {
        return this._notAfter;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        DERGeneralizedTime dERGeneralizedTime = this._notBefore;
        if (dERGeneralizedTime != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, dERGeneralizedTime));
        }
        DERGeneralizedTime dERGeneralizedTime2 = this._notAfter;
        if (dERGeneralizedTime2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, dERGeneralizedTime2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
