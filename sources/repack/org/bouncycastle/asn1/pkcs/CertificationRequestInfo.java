package repack.org.bouncycastle.asn1.pkcs;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.asn1.x509.X509Name;

public class CertificationRequestInfo extends ASN1Encodable {
    ASN1Set attributes = null;
    X509Name subject;
    SubjectPublicKeyInfo subjectPKInfo;
    DERInteger version = new DERInteger(0);

    public static CertificationRequestInfo getInstance(Object obj) {
        if (obj instanceof CertificationRequestInfo) {
            return (CertificationRequestInfo) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CertificationRequestInfo((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public CertificationRequestInfo(X500Name x500Name, SubjectPublicKeyInfo subjectPublicKeyInfo, ASN1Set aSN1Set) {
        this.subject = X509Name.getInstance(x500Name.getDERObject());
        this.subjectPKInfo = subjectPublicKeyInfo;
        this.attributes = aSN1Set;
        if (x500Name == null || this.version == null || this.subjectPKInfo == null) {
            throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        }
    }

    public CertificationRequestInfo(X509Name x509Name, SubjectPublicKeyInfo subjectPublicKeyInfo, ASN1Set aSN1Set) {
        this.subject = x509Name;
        this.subjectPKInfo = subjectPublicKeyInfo;
        this.attributes = aSN1Set;
        if (x509Name == null || this.version == null || this.subjectPKInfo == null) {
            throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        }
    }

    public CertificationRequestInfo(ASN1Sequence aSN1Sequence) {
        this.version = (DERInteger) aSN1Sequence.getObjectAt(0);
        this.subject = X509Name.getInstance(aSN1Sequence.getObjectAt(1));
        this.subjectPKInfo = SubjectPublicKeyInfo.getInstance(aSN1Sequence.getObjectAt(2));
        if (aSN1Sequence.size() > 3) {
            this.attributes = ASN1Set.getInstance((DERTaggedObject) aSN1Sequence.getObjectAt(3), false);
        }
        if (this.subject == null || this.version == null || this.subjectPKInfo == null) {
            throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        }
    }

    public DERInteger getVersion() {
        return this.version;
    }

    public X509Name getSubject() {
        return this.subject;
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.subjectPKInfo;
    }

    public ASN1Set getAttributes() {
        return this.attributes;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.subject);
        aSN1EncodableVector.add(this.subjectPKInfo);
        ASN1Set aSN1Set = this.attributes;
        if (aSN1Set != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1Set));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
