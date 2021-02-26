package repack.org.bouncycastle.asn1.cmp;

import java.math.BigInteger;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSequence;

public class CertStatus extends ASN1Encodable {
    private ASN1OctetString certHash;
    private DERInteger certReqId;
    private PKIStatusInfo statusInfo;

    private CertStatus(ASN1Sequence aSN1Sequence) {
        this.certHash = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        this.certReqId = DERInteger.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.size() > 2) {
            this.statusInfo = PKIStatusInfo.getInstance(aSN1Sequence.getObjectAt(2));
        }
    }

    public CertStatus(byte[] bArr, BigInteger bigInteger) {
        this.certHash = new DEROctetString(bArr);
        this.certReqId = new DERInteger(bigInteger);
    }

    public CertStatus(byte[] bArr, BigInteger bigInteger, PKIStatusInfo pKIStatusInfo) {
        this.certHash = new DEROctetString(bArr);
        this.certReqId = new DERInteger(bigInteger);
        this.statusInfo = pKIStatusInfo;
    }

    public static CertStatus getInstance(Object obj) {
        if (obj instanceof CertStatus) {
            return (CertStatus) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CertStatus((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public ASN1OctetString getCertHash() {
        return this.certHash;
    }

    public DERInteger getCertReqId() {
        return this.certReqId;
    }

    public PKIStatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.certHash);
        aSN1EncodableVector.add(this.certReqId);
        PKIStatusInfo pKIStatusInfo = this.statusInfo;
        if (pKIStatusInfo != null) {
            aSN1EncodableVector.add(pKIStatusInfo);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
