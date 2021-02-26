package repack.org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class ElGamalPublicKeyParameters extends ElGamalKeyParameters {

    /* renamed from: y */
    private BigInteger f6194y;

    public ElGamalPublicKeyParameters(BigInteger bigInteger, ElGamalParameters elGamalParameters) {
        super(false, elGamalParameters);
        this.f6194y = bigInteger;
    }

    public BigInteger getY() {
        return this.f6194y;
    }

    public int hashCode() {
        return this.f6194y.hashCode() ^ super.hashCode();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ElGamalPublicKeyParameters) && ((ElGamalPublicKeyParameters) obj).getY().equals(this.f6194y) && super.equals(obj)) {
            return true;
        }
        return false;
    }
}
