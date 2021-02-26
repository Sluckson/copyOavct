package repack.org.bouncycastle.asn1.cmp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.crmf.CertId;
import repack.org.bouncycastle.asn1.x509.X509Extensions;

public class RevAnnContent extends ASN1Encodable {
    private DERGeneralizedTime badSinceDate;
    private CertId certId;
    private X509Extensions crlDetails;
    private PKIStatus status;
    private DERGeneralizedTime willBeRevokedAt;

    private RevAnnContent(ASN1Sequence aSN1Sequence) {
        this.status = PKIStatus.getInstance(aSN1Sequence.getObjectAt(0));
        this.certId = CertId.getInstance(aSN1Sequence.getObjectAt(1));
        this.willBeRevokedAt = DERGeneralizedTime.getInstance(aSN1Sequence.getObjectAt(2));
        this.badSinceDate = DERGeneralizedTime.getInstance(aSN1Sequence.getObjectAt(3));
        if (aSN1Sequence.size() > 4) {
            this.crlDetails = X509Extensions.getInstance(aSN1Sequence.getObjectAt(4));
        }
    }

    public static RevAnnContent getInstance(Object obj) {
        if (obj instanceof RevAnnContent) {
            return (RevAnnContent) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new RevAnnContent((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public PKIStatus getStatus() {
        return this.status;
    }

    public CertId getCertId() {
        return this.certId;
    }

    public DERGeneralizedTime getWillBeRevokedAt() {
        return this.willBeRevokedAt;
    }

    public DERGeneralizedTime getBadSinceDate() {
        return this.badSinceDate;
    }

    public X509Extensions getCrlDetails() {
        return this.crlDetails;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.status);
        aSN1EncodableVector.add(this.certId);
        aSN1EncodableVector.add(this.willBeRevokedAt);
        aSN1EncodableVector.add(this.badSinceDate);
        X509Extensions x509Extensions = this.crlDetails;
        if (x509Extensions != null) {
            aSN1EncodableVector.add(x509Extensions);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
