package repack.org.bouncycastle.asn1.ess;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DEROctetString;

public class ContentIdentifier extends ASN1Encodable {
    ASN1OctetString value;

    public static ContentIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof ContentIdentifier)) {
            return (ContentIdentifier) obj;
        }
        if (obj instanceof ASN1OctetString) {
            return new ContentIdentifier((ASN1OctetString) obj);
        }
        throw new IllegalArgumentException("unknown object in 'ContentIdentifier' factory : " + obj.getClass().getName() + ".");
    }

    public ContentIdentifier(ASN1OctetString aSN1OctetString) {
        this.value = aSN1OctetString;
    }

    public ContentIdentifier(byte[] bArr) {
        this((ASN1OctetString) new DEROctetString(bArr));
    }

    public ASN1OctetString getValue() {
        return this.value;
    }

    public DERObject toASN1Object() {
        return this.value;
    }
}
