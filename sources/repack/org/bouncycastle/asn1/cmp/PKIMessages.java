package repack.org.bouncycastle.asn1.cmp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class PKIMessages extends ASN1Encodable {
    private ASN1Sequence content;

    private PKIMessages(ASN1Sequence aSN1Sequence) {
        this.content = aSN1Sequence;
    }

    public static PKIMessages getInstance(Object obj) {
        if (obj instanceof PKIMessages) {
            return (PKIMessages) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new PKIMessages((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public PKIMessages(PKIMessage pKIMessage) {
        this.content = new DERSequence((DEREncodable) pKIMessage);
    }

    public PKIMessages(PKIMessage[] pKIMessageArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (PKIMessage add : pKIMessageArr) {
            aSN1EncodableVector.add(add);
        }
        this.content = new DERSequence(aSN1EncodableVector);
    }

    public PKIMessage[] toPKIMessageArray() {
        PKIMessage[] pKIMessageArr = new PKIMessage[this.content.size()];
        for (int i = 0; i != pKIMessageArr.length; i++) {
            pKIMessageArr[i] = PKIMessage.getInstance(this.content.getObjectAt(i));
        }
        return pKIMessageArr;
    }

    public DERObject toASN1Object() {
        return this.content;
    }
}
