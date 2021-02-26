package repack.org.bouncycastle.asn1.crmf;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class CertReqMessages extends ASN1Encodable {
    private ASN1Sequence content;

    private CertReqMessages(ASN1Sequence aSN1Sequence) {
        this.content = aSN1Sequence;
    }

    public static CertReqMessages getInstance(Object obj) {
        if (obj instanceof CertReqMessages) {
            return (CertReqMessages) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CertReqMessages((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public CertReqMessages(CertReqMsg certReqMsg) {
        this.content = new DERSequence((DEREncodable) certReqMsg);
    }

    public CertReqMessages(CertReqMsg[] certReqMsgArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (CertReqMsg add : certReqMsgArr) {
            aSN1EncodableVector.add(add);
        }
        this.content = new DERSequence(aSN1EncodableVector);
    }

    public CertReqMsg[] toCertReqMsgArray() {
        CertReqMsg[] certReqMsgArr = new CertReqMsg[this.content.size()];
        for (int i = 0; i != certReqMsgArr.length; i++) {
            certReqMsgArr[i] = CertReqMsg.getInstance(this.content.getObjectAt(i));
        }
        return certReqMsgArr;
    }

    public DERObject toASN1Object() {
        return this.content;
    }
}
