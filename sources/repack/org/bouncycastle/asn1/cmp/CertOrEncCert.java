package repack.org.bouncycastle.asn1.cmp;

import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.crmf.EncryptedValue;

public class CertOrEncCert extends ASN1Encodable implements ASN1Choice {
    private CMPCertificate certificate;
    private EncryptedValue encryptedCert;

    private CertOrEncCert(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.getTagNo() == 0) {
            this.certificate = CMPCertificate.getInstance(aSN1TaggedObject.getObject());
        } else if (aSN1TaggedObject.getTagNo() == 1) {
            this.encryptedCert = EncryptedValue.getInstance(aSN1TaggedObject.getObject());
        } else {
            throw new IllegalArgumentException("unknown tag: " + aSN1TaggedObject.getTagNo());
        }
    }

    public static CertOrEncCert getInstance(Object obj) {
        if (obj instanceof CertOrEncCert) {
            return (CertOrEncCert) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new CertOrEncCert((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public CertOrEncCert(CMPCertificate cMPCertificate) {
        if (cMPCertificate != null) {
            this.certificate = cMPCertificate;
            return;
        }
        throw new IllegalArgumentException("'certificate' cannot be null");
    }

    public CertOrEncCert(EncryptedValue encryptedValue) {
        if (encryptedValue != null) {
            this.encryptedCert = encryptedValue;
            return;
        }
        throw new IllegalArgumentException("'encryptedCert' cannot be null");
    }

    public CMPCertificate getCertificate() {
        return this.certificate;
    }

    public EncryptedValue getEncryptedCert() {
        return this.encryptedCert;
    }

    public DERObject toASN1Object() {
        CMPCertificate cMPCertificate = this.certificate;
        if (cMPCertificate != null) {
            return new DERTaggedObject(true, 0, cMPCertificate);
        }
        return new DERTaggedObject(true, 1, this.encryptedCert);
    }
}
