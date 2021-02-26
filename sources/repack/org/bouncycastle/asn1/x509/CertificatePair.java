package repack.org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class CertificatePair extends ASN1Encodable {
    private X509CertificateStructure forward;
    private X509CertificateStructure reverse;

    public static CertificatePair getInstance(Object obj) {
        if (obj == null || (obj instanceof CertificatePair)) {
            return (CertificatePair) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CertificatePair((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    private CertificatePair(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 1 || aSN1Sequence.size() == 2) {
            Enumeration objects = aSN1Sequence.getObjects();
            while (objects.hasMoreElements()) {
                ASN1TaggedObject instance = ASN1TaggedObject.getInstance(objects.nextElement());
                if (instance.getTagNo() == 0) {
                    this.forward = X509CertificateStructure.getInstance(instance, true);
                } else if (instance.getTagNo() == 1) {
                    this.reverse = X509CertificateStructure.getInstance(instance, true);
                } else {
                    throw new IllegalArgumentException("Bad tag number: " + instance.getTagNo());
                }
            }
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public CertificatePair(X509CertificateStructure x509CertificateStructure, X509CertificateStructure x509CertificateStructure2) {
        this.forward = x509CertificateStructure;
        this.reverse = x509CertificateStructure2;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        X509CertificateStructure x509CertificateStructure = this.forward;
        if (x509CertificateStructure != null) {
            aSN1EncodableVector.add(new DERTaggedObject(0, x509CertificateStructure));
        }
        X509CertificateStructure x509CertificateStructure2 = this.reverse;
        if (x509CertificateStructure2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(1, x509CertificateStructure2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public X509CertificateStructure getForward() {
        return this.forward;
    }

    public X509CertificateStructure getReverse() {
        return this.reverse;
    }
}
