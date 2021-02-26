package repack.org.bouncycastle.asn1.cmp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;

public class PollReqContent extends ASN1Encodable {
    private ASN1Sequence content;

    private PollReqContent(ASN1Sequence aSN1Sequence) {
        this.content = aSN1Sequence;
    }

    public static PollReqContent getInstance(Object obj) {
        if (obj instanceof PollReqContent) {
            return (PollReqContent) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new PollReqContent((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public DERInteger[][] getCertReqIds() {
        DERInteger[][] dERIntegerArr = new DERInteger[this.content.size()][];
        for (int i = 0; i != dERIntegerArr.length; i++) {
            dERIntegerArr[i] = seqenceToDERIntegerArray((ASN1Sequence) this.content.getObjectAt(i));
        }
        return dERIntegerArr;
    }

    private DERInteger[] seqenceToDERIntegerArray(ASN1Sequence aSN1Sequence) {
        DERInteger[] dERIntegerArr = new DERInteger[aSN1Sequence.size()];
        for (int i = 0; i != dERIntegerArr.length; i++) {
            dERIntegerArr[i] = DERInteger.getInstance(aSN1Sequence.getObjectAt(i));
        }
        return dERIntegerArr;
    }

    public DERObject toASN1Object() {
        return this.content;
    }
}
