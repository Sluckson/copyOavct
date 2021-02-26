package repack.org.bouncycastle.asn1.p065x9;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;

/* renamed from: repack.org.bouncycastle.asn1.x9.DHPublicKey */
public class DHPublicKey extends ASN1Encodable {

    /* renamed from: y */
    private DERInteger f5893y;

    public static DHPublicKey getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(DERInteger.getInstance(aSN1TaggedObject, z));
    }

    public static DHPublicKey getInstance(Object obj) {
        if (obj == null || (obj instanceof DHPublicKey)) {
            return (DHPublicKey) obj;
        }
        if (obj instanceof DERInteger) {
            return new DHPublicKey((DERInteger) obj);
        }
        throw new IllegalArgumentException("Invalid DHPublicKey: " + obj.getClass().getName());
    }

    public DHPublicKey(DERInteger dERInteger) {
        if (dERInteger != null) {
            this.f5893y = dERInteger;
            return;
        }
        throw new IllegalArgumentException("'y' cannot be null");
    }

    public DERInteger getY() {
        return this.f5893y;
    }

    public DERObject toASN1Object() {
        return this.f5893y;
    }
}
