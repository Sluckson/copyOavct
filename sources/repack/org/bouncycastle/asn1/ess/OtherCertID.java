package repack.org.bouncycastle.asn1.ess;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.DigestInfo;
import repack.org.bouncycastle.asn1.x509.IssuerSerial;
import repack.org.bouncycastle.ocsp.CertificateID;

public class OtherCertID extends ASN1Encodable {
    private IssuerSerial issuerSerial;
    private ASN1Encodable otherCertHash;

    public static OtherCertID getInstance(Object obj) {
        if (obj == null || (obj instanceof OtherCertID)) {
            return (OtherCertID) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new OtherCertID((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in 'OtherCertID' factory : " + obj.getClass().getName() + ".");
    }

    public OtherCertID(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        if (aSN1Sequence.getObjectAt(0).getDERObject() instanceof ASN1OctetString) {
            this.otherCertHash = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        } else {
            this.otherCertHash = DigestInfo.getInstance(aSN1Sequence.getObjectAt(0));
        }
        if (aSN1Sequence.size() > 1) {
            this.issuerSerial = new IssuerSerial(ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1)));
        }
    }

    public OtherCertID(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.otherCertHash = new DigestInfo(algorithmIdentifier, bArr);
    }

    public OtherCertID(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, IssuerSerial issuerSerial2) {
        this.otherCertHash = new DigestInfo(algorithmIdentifier, bArr);
        this.issuerSerial = issuerSerial2;
    }

    public AlgorithmIdentifier getAlgorithmHash() {
        if (this.otherCertHash.getDERObject() instanceof ASN1OctetString) {
            return new AlgorithmIdentifier(CertificateID.HASH_SHA1);
        }
        return DigestInfo.getInstance(this.otherCertHash).getAlgorithmId();
    }

    public byte[] getCertHash() {
        if (this.otherCertHash.getDERObject() instanceof ASN1OctetString) {
            return ((ASN1OctetString) this.otherCertHash.getDERObject()).getOctets();
        }
        return DigestInfo.getInstance(this.otherCertHash).getDigest();
    }

    public IssuerSerial getIssuerSerial() {
        return this.issuerSerial;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.otherCertHash);
        IssuerSerial issuerSerial2 = this.issuerSerial;
        if (issuerSerial2 != null) {
            aSN1EncodableVector.add(issuerSerial2);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
