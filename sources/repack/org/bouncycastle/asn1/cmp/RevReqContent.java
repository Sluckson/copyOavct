package repack.org.bouncycastle.asn1.cmp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class RevReqContent extends ASN1Encodable {
    private ASN1Sequence content;

    private RevReqContent(ASN1Sequence aSN1Sequence) {
        this.content = aSN1Sequence;
    }

    public static RevReqContent getInstance(Object obj) {
        if (obj instanceof RevReqContent) {
            return (RevReqContent) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new RevReqContent((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public RevReqContent(RevDetails revDetails) {
        this.content = new DERSequence((DEREncodable) revDetails);
    }

    public RevReqContent(RevDetails[] revDetailsArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (int i = 0; i != revDetailsArr.length; i++) {
            aSN1EncodableVector.add(revDetailsArr[i]);
        }
        this.content = new DERSequence(aSN1EncodableVector);
    }

    public RevDetails[] toRevDetailsArray() {
        RevDetails[] revDetailsArr = new RevDetails[this.content.size()];
        for (int i = 0; i != revDetailsArr.length; i++) {
            revDetailsArr[i] = RevDetails.getInstance(this.content.getObjectAt(i));
        }
        return revDetailsArr;
    }

    public DERObject toASN1Object() {
        return this.content;
    }
}
