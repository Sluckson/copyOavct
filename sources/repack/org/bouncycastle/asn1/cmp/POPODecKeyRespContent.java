package repack.org.bouncycastle.asn1.cmp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;

public class POPODecKeyRespContent extends ASN1Encodable {
    private ASN1Sequence content;

    private POPODecKeyRespContent(ASN1Sequence aSN1Sequence) {
        this.content = aSN1Sequence;
    }

    public static POPODecKeyRespContent getInstance(Object obj) {
        if (obj instanceof POPODecKeyRespContent) {
            return (POPODecKeyRespContent) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new POPODecKeyRespContent((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public DERInteger[] toDERIntegerArray() {
        DERInteger[] dERIntegerArr = new DERInteger[this.content.size()];
        for (int i = 0; i != dERIntegerArr.length; i++) {
            dERIntegerArr[i] = DERInteger.getInstance(this.content.getObjectAt(i));
        }
        return dERIntegerArr;
    }

    public DERObject toASN1Object() {
        return this.content;
    }
}
