package repack.org.bouncycastle.asn1.cmp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.x509.CertificateList;

public class CRLAnnContent extends ASN1Encodable {
    private ASN1Sequence content;

    private CRLAnnContent(ASN1Sequence aSN1Sequence) {
        this.content = aSN1Sequence;
    }

    public static CRLAnnContent getInstance(Object obj) {
        if (obj instanceof CRLAnnContent) {
            return (CRLAnnContent) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new CRLAnnContent((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public CertificateList[] toCertificateListArray() {
        CertificateList[] certificateListArr = new CertificateList[this.content.size()];
        for (int i = 0; i != certificateListArr.length; i++) {
            certificateListArr[i] = CertificateList.getInstance(this.content.getObjectAt(i));
        }
        return certificateListArr;
    }

    public DERObject toASN1Object() {
        return this.content;
    }
}
