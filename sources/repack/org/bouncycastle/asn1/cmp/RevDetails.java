package repack.org.bouncycastle.asn1.cmp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.crmf.CertTemplate;
import repack.org.bouncycastle.asn1.x509.X509Extensions;

public class RevDetails extends ASN1Encodable {
    private CertTemplate certDetails;
    private X509Extensions crlEntryDetails;

    private RevDetails(ASN1Sequence aSN1Sequence) {
        this.certDetails = CertTemplate.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() > 1) {
            this.crlEntryDetails = X509Extensions.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public static RevDetails getInstance(Object obj) {
        if (obj instanceof RevDetails) {
            return (RevDetails) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new RevDetails((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public RevDetails(CertTemplate certTemplate) {
        this.certDetails = certTemplate;
    }

    public RevDetails(CertTemplate certTemplate, X509Extensions x509Extensions) {
        this.crlEntryDetails = x509Extensions;
    }

    public CertTemplate getCertDetails() {
        return this.certDetails;
    }

    public X509Extensions getCrlEntryDetails() {
        return this.crlEntryDetails;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.certDetails);
        X509Extensions x509Extensions = this.crlEntryDetails;
        if (x509Extensions != null) {
            aSN1EncodableVector.add(x509Extensions);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
