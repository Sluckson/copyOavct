package repack.org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class DHPublicKeyParameters extends DHKeyParameters {

    /* renamed from: y */
    private BigInteger f6179y;

    public DHPublicKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(false, dHParameters);
        this.f6179y = bigInteger;
    }

    public BigInteger getY() {
        return this.f6179y;
    }

    public int hashCode() {
        return this.f6179y.hashCode() ^ super.hashCode();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof DHPublicKeyParameters) && ((DHPublicKeyParameters) obj).getY().equals(this.f6179y) && super.equals(obj)) {
            return true;
        }
        return false;
    }
}
