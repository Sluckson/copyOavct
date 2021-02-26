package repack.org.bouncycastle.asn1.cmp;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1Null;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObject;

public class PKIConfirmContent extends ASN1Encodable {
    private ASN1Null val;

    private PKIConfirmContent(ASN1Null aSN1Null) {
        this.val = aSN1Null;
    }

    public static PKIConfirmContent getInstance(Object obj) {
        if (obj instanceof PKIConfirmContent) {
            return (PKIConfirmContent) obj;
        }
        if (obj instanceof ASN1Null) {
            return new PKIConfirmContent((ASN1Null) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public PKIConfirmContent() {
        this.val = DERNull.INSTANCE;
    }

    public DERObject toASN1Object() {
        return this.val;
    }
}