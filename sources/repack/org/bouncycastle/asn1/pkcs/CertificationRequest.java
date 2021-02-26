package repack.org.bouncycastle.asn1.pkcs;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERBitString;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class CertificationRequest extends ASN1Encodable {
    protected CertificationRequestInfo reqInfo = null;
    protected AlgorithmIdentifier sigAlgId = null;
    protected DERBitString sigBits = null;

    public static CertificationRequest getInstance(Object obj) {
        if (obj instanceof CertificationRequest) {
            return (CertificationRequest) obj;
        }
        if (obj != null) {
            return new CertificationRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    protected CertificationRequest() {
    }

    public CertificationRequest(CertificationRequestInfo certificationRequestInfo, AlgorithmIdentifier algorithmIdentifier, DERBitString dERBitString) {
        this.reqInfo = certificationRequestInfo;
        this.sigAlgId = algorithmIdentifier;
        this.sigBits = dERBitString;
    }

    public CertificationRequest(ASN1Sequence aSN1Sequence) {
        this.reqInfo = CertificationRequestInfo.getInstance(aSN1Sequence.getObjectAt(0));
        this.sigAlgId = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.sigBits = (DERBitString) aSN1Sequence.getObjectAt(2);
    }

    public CertificationRequestInfo getCertificationRequestInfo() {
        return this.reqInfo;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.sigAlgId;
    }

    public DERBitString getSignature() {
        return this.sigBits;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.reqInfo);
        aSN1EncodableVector.add(this.sigAlgId);
        aSN1EncodableVector.add(this.sigBits);
        return new DERSequence(aSN1EncodableVector);
    }
}
