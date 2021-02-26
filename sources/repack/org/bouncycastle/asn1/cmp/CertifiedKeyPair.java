package repack.org.bouncycastle.asn1.cmp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.crmf.EncryptedValue;
import repack.org.bouncycastle.asn1.crmf.PKIPublicationInfo;

public class CertifiedKeyPair extends ASN1Encodable {
    private CertOrEncCert certOrEncCert;
    private EncryptedValue privateKey;
    private PKIPublicationInfo publicationInfo;

    private CertifiedKeyPair(ASN1Sequence aSN1Sequence) {
        this.certOrEncCert = CertOrEncCert.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() < 2) {
            return;
        }
        if (aSN1Sequence.size() == 2) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1));
            if (instance.getTagNo() == 0) {
                this.privateKey = EncryptedValue.getInstance(instance.getObject());
            } else {
                this.publicationInfo = PKIPublicationInfo.getInstance(instance.getObject());
            }
        } else {
            this.privateKey = EncryptedValue.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1)));
            this.publicationInfo = PKIPublicationInfo.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(2)));
        }
    }

    public static CertifiedKeyPair getInstance(Object obj) {
        if (obj instanceof CertifiedKeyPair) {
            return (CertifiedKeyPair) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CertifiedKeyPair((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public CertifiedKeyPair(CertOrEncCert certOrEncCert2) {
        this(certOrEncCert2, (EncryptedValue) null, (PKIPublicationInfo) null);
    }

    public CertifiedKeyPair(CertOrEncCert certOrEncCert2, EncryptedValue encryptedValue, PKIPublicationInfo pKIPublicationInfo) {
        if (certOrEncCert2 != null) {
            this.certOrEncCert = certOrEncCert2;
            this.privateKey = encryptedValue;
            this.publicationInfo = pKIPublicationInfo;
            return;
        }
        throw new IllegalArgumentException("'certOrEncCert' cannot be null");
    }

    public CertOrEncCert getCertOrEncCert() {
        return this.certOrEncCert;
    }

    public EncryptedValue getPrivateKey() {
        return this.privateKey;
    }

    public PKIPublicationInfo getPublicationInfo() {
        return this.publicationInfo;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.certOrEncCert);
        EncryptedValue encryptedValue = this.privateKey;
        if (encryptedValue != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, encryptedValue));
        }
        PKIPublicationInfo pKIPublicationInfo = this.publicationInfo;
        if (pKIPublicationInfo != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, pKIPublicationInfo));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
