package repack.org.bouncycastle.asn1.esf;

import repack.org.bouncycastle.asn1.DERIA5String;
import repack.org.bouncycastle.asn1.DERObject;

public class SPuri {
    private DERIA5String uri;

    public static SPuri getInstance(Object obj) {
        if (obj instanceof SPuri) {
            return (SPuri) obj;
        }
        if (obj instanceof DERIA5String) {
            return new SPuri((DERIA5String) obj);
        }
        throw new IllegalArgumentException("unknown object in 'SPuri' factory: " + obj.getClass().getName() + ".");
    }

    public SPuri(DERIA5String dERIA5String) {
        this.uri = dERIA5String;
    }

    public DERIA5String getUri() {
        return this.uri;
    }

    public DERObject toASN1Object() {
        return this.uri.getDERObject();
    }
}
