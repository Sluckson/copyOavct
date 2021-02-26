package repack.org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;

public class CompleteRevocationRefs extends ASN1Encodable {
    private ASN1Sequence crlOcspRefs;

    public static CompleteRevocationRefs getInstance(Object obj) {
        if (obj instanceof CompleteRevocationRefs) {
            return (CompleteRevocationRefs) obj;
        }
        if (obj != null) {
            return new CompleteRevocationRefs(ASN1Sequence.getInstance(obj));
        }
        throw new IllegalArgumentException("null value in getInstance");
    }

    private CompleteRevocationRefs(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            CrlOcspRef.getInstance(objects.nextElement());
        }
        this.crlOcspRefs = aSN1Sequence;
    }

    public CompleteRevocationRefs(CrlOcspRef[] crlOcspRefArr) {
        this.crlOcspRefs = new DERSequence((ASN1Encodable[]) crlOcspRefArr);
    }

    public CrlOcspRef[] getCrlOcspRefs() {
        CrlOcspRef[] crlOcspRefArr = new CrlOcspRef[this.crlOcspRefs.size()];
        for (int i = 0; i < crlOcspRefArr.length; i++) {
            crlOcspRefArr[i] = CrlOcspRef.getInstance(this.crlOcspRefs.getObjectAt(i));
        }
        return crlOcspRefArr;
    }

    public DERObject toASN1Object() {
        return this.crlOcspRefs;
    }
}
