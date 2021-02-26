package repack.org.bouncycastle.asn1.cmp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class CertRepMessage extends ASN1Encodable {
    private ASN1Sequence caPubs;
    private ASN1Sequence response;

    private CertRepMessage(ASN1Sequence aSN1Sequence) {
        int i = 1;
        if (aSN1Sequence.size() > 1) {
            this.caPubs = ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(0), true);
        } else {
            i = 0;
        }
        this.response = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(i));
    }

    public static CertRepMessage getInstance(Object obj) {
        if (obj instanceof CertRepMessage) {
            return (CertRepMessage) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CertRepMessage((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public CertRepMessage(CMPCertificate[] cMPCertificateArr, CertResponse[] certResponseArr) {
        if (certResponseArr != null) {
            if (cMPCertificateArr != null) {
                ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                for (CMPCertificate add : cMPCertificateArr) {
                    aSN1EncodableVector.add(add);
                }
                this.caPubs = new DERSequence(aSN1EncodableVector);
            }
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            for (CertResponse add2 : certResponseArr) {
                aSN1EncodableVector2.add(add2);
            }
            this.response = new DERSequence(aSN1EncodableVector2);
            return;
        }
        throw new IllegalArgumentException("'response' cannot be null");
    }

    public CMPCertificate[] getCaPubs() {
        ASN1Sequence aSN1Sequence = this.caPubs;
        if (aSN1Sequence == null) {
            return null;
        }
        CMPCertificate[] cMPCertificateArr = new CMPCertificate[aSN1Sequence.size()];
        for (int i = 0; i != cMPCertificateArr.length; i++) {
            cMPCertificateArr[i] = CMPCertificate.getInstance(this.caPubs.getObjectAt(i));
        }
        return cMPCertificateArr;
    }

    public CertResponse[] getResponse() {
        CertResponse[] certResponseArr = new CertResponse[this.response.size()];
        for (int i = 0; i != certResponseArr.length; i++) {
            certResponseArr[i] = CertResponse.getInstance(this.response.getObjectAt(i));
        }
        return certResponseArr;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Sequence aSN1Sequence = this.caPubs;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, aSN1Sequence));
        }
        aSN1EncodableVector.add(this.response);
        return new DERSequence(aSN1EncodableVector);
    }
}
