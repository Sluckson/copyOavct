package repack.org.bouncycastle.asn1.cms;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.BERSet;
import repack.org.bouncycastle.asn1.DERObject;

public class Attributes extends ASN1Encodable {
    private ASN1Set attributes;

    private Attributes(ASN1Set aSN1Set) {
        this.attributes = aSN1Set;
    }

    public Attributes(ASN1EncodableVector aSN1EncodableVector) {
        this.attributes = new BERSet(aSN1EncodableVector);
    }

    public static Attributes getInstance(Object obj) {
        if (obj instanceof Attributes) {
            return (Attributes) obj;
        }
        if (obj != null) {
            return new Attributes(ASN1Set.getInstance(obj));
        }
        return null;
    }

    public DERObject toASN1Object() {
        return this.attributes;
    }
}
