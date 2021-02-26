package repack.org.bouncycastle.asn1.cmp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class CertResponse extends ASN1Encodable {
    private DERInteger certReqId;
    private CertifiedKeyPair certifiedKeyPair;
    private ASN1OctetString rspInfo;
    private PKIStatusInfo status;

    private CertResponse(ASN1Sequence aSN1Sequence) {
        this.certReqId = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
        this.status = PKIStatusInfo.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() < 3) {
            return;
        }
        if (aSN1Sequence.size() == 3) {
            DEREncodable objectAt = aSN1Sequence.getObjectAt(2);
            if (objectAt instanceof ASN1OctetString) {
                this.rspInfo = ASN1OctetString.getInstance(objectAt);
            } else {
                this.certifiedKeyPair = CertifiedKeyPair.getInstance(objectAt);
            }
        } else {
            this.certifiedKeyPair = CertifiedKeyPair.getInstance(aSN1Sequence.getObjectAt(2));
            this.rspInfo = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(3));
        }
    }

    public static CertResponse getInstance(Object obj) {
        if (obj instanceof CertResponse) {
            return (CertResponse) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CertResponse((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public CertResponse(DERInteger dERInteger, PKIStatusInfo pKIStatusInfo) {
        this(dERInteger, pKIStatusInfo, (CertifiedKeyPair) null, (ASN1OctetString) null);
    }

    public CertResponse(DERInteger dERInteger, PKIStatusInfo pKIStatusInfo, CertifiedKeyPair certifiedKeyPair2, ASN1OctetString aSN1OctetString) {
        if (dERInteger == null) {
            throw new IllegalArgumentException("'certReqId' cannot be null");
        } else if (pKIStatusInfo != null) {
            this.certReqId = dERInteger;
            this.status = pKIStatusInfo;
            this.certifiedKeyPair = certifiedKeyPair2;
            this.rspInfo = aSN1OctetString;
        } else {
            throw new IllegalArgumentException("'status' cannot be null");
        }
    }

    public DERInteger getCertReqId() {
        return this.certReqId;
    }

    public PKIStatusInfo getStatus() {
        return this.status;
    }

    public CertifiedKeyPair getCertifiedKeyPair() {
        return this.certifiedKeyPair;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.certReqId);
        aSN1EncodableVector.add(this.status);
        CertifiedKeyPair certifiedKeyPair2 = this.certifiedKeyPair;
        if (certifiedKeyPair2 != null) {
            aSN1EncodableVector.add(certifiedKeyPair2);
        }
        ASN1OctetString aSN1OctetString = this.rspInfo;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.add(aSN1OctetString);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
