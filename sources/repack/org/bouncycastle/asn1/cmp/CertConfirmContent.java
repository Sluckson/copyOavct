package repack.org.bouncycastle.asn1.cmp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObject;

public class CertConfirmContent extends ASN1Encodable {
    private ASN1Sequence content;

    private CertConfirmContent(ASN1Sequence aSN1Sequence) {
        this.content = aSN1Sequence;
    }

    public static CertConfirmContent getInstance(Object obj) {
        if (obj instanceof CertConfirmContent) {
            return (CertConfirmContent) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CertConfirmContent((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public CertStatus[] toCertStatusArray() {
        CertStatus[] certStatusArr = new CertStatus[this.content.size()];
        for (int i = 0; i != certStatusArr.length; i++) {
            certStatusArr[i] = CertStatus.getInstance(this.content.getObjectAt(i));
        }
        return certStatusArr;
    }

    public DERObject toASN1Object() {
        return this.content;
    }
}
