package repack.org.bouncycastle.asn1.ocsp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.x509.X509Extensions;

public class SingleResponse extends ASN1Encodable {
    private CertID certID;
    private CertStatus certStatus;
    private DERGeneralizedTime nextUpdate;
    private X509Extensions singleExtensions;
    private DERGeneralizedTime thisUpdate;

    public SingleResponse(CertID certID2, CertStatus certStatus2, DERGeneralizedTime dERGeneralizedTime, DERGeneralizedTime dERGeneralizedTime2, X509Extensions x509Extensions) {
        this.certID = certID2;
        this.certStatus = certStatus2;
        this.thisUpdate = dERGeneralizedTime;
        this.nextUpdate = dERGeneralizedTime2;
        this.singleExtensions = x509Extensions;
    }

    public SingleResponse(ASN1Sequence aSN1Sequence) {
        this.certID = CertID.getInstance(aSN1Sequence.getObjectAt(0));
        this.certStatus = CertStatus.getInstance(aSN1Sequence.getObjectAt(1));
        this.thisUpdate = (DERGeneralizedTime) aSN1Sequence.getObjectAt(2);
        if (aSN1Sequence.size() > 4) {
            this.nextUpdate = DERGeneralizedTime.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(3), true);
            this.singleExtensions = X509Extensions.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(4), true);
        } else if (aSN1Sequence.size() > 3) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(3);
            if (aSN1TaggedObject.getTagNo() == 0) {
                this.nextUpdate = DERGeneralizedTime.getInstance(aSN1TaggedObject, true);
            } else {
                this.singleExtensions = X509Extensions.getInstance(aSN1TaggedObject, true);
            }
        }
    }

    public static SingleResponse getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static SingleResponse getInstance(Object obj) {
        if (obj == null || (obj instanceof SingleResponse)) {
            return (SingleResponse) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new SingleResponse((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public CertID getCertID() {
        return this.certID;
    }

    public CertStatus getCertStatus() {
        return this.certStatus;
    }

    public DERGeneralizedTime getThisUpdate() {
        return this.thisUpdate;
    }

    public DERGeneralizedTime getNextUpdate() {
        return this.nextUpdate;
    }

    public X509Extensions getSingleExtensions() {
        return this.singleExtensions;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.certID);
        aSN1EncodableVector.add(this.certStatus);
        aSN1EncodableVector.add(this.thisUpdate);
        DERGeneralizedTime dERGeneralizedTime = this.nextUpdate;
        if (dERGeneralizedTime != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, dERGeneralizedTime));
        }
        X509Extensions x509Extensions = this.singleExtensions;
        if (x509Extensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, x509Extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
