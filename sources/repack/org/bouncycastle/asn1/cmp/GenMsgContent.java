package repack.org.bouncycastle.asn1.cmp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class GenMsgContent extends ASN1Encodable {
    private ASN1Sequence content;

    private GenMsgContent(ASN1Sequence aSN1Sequence) {
        this.content = aSN1Sequence;
    }

    public static GenMsgContent getInstance(Object obj) {
        if (obj instanceof GenMsgContent) {
            return (GenMsgContent) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new GenMsgContent((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public GenMsgContent(InfoTypeAndValue infoTypeAndValue) {
        this.content = new DERSequence((DEREncodable) infoTypeAndValue);
    }

    public GenMsgContent(InfoTypeAndValue[] infoTypeAndValueArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (InfoTypeAndValue add : infoTypeAndValueArr) {
            aSN1EncodableVector.add(add);
        }
        this.content = new DERSequence(aSN1EncodableVector);
    }

    public InfoTypeAndValue[] toInfoTypeAndValueArray() {
        InfoTypeAndValue[] infoTypeAndValueArr = new InfoTypeAndValue[this.content.size()];
        for (int i = 0; i != infoTypeAndValueArr.length; i++) {
            infoTypeAndValueArr[i] = InfoTypeAndValue.getInstance(this.content.getObjectAt(i));
        }
        return infoTypeAndValueArr;
    }

    public DERObject toASN1Object() {
        return this.content;
    }
}
