package repack.org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class ElGamalPrivateKeyParameters extends ElGamalKeyParameters {

    /* renamed from: x */
    private BigInteger f6193x;

    public ElGamalPrivateKeyParameters(BigInteger bigInteger, ElGamalParameters elGamalParameters) {
        super(true, elGamalParameters);
        this.f6193x = bigInteger;
    }

    public BigInteger getX() {
        return this.f6193x;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ElGamalPrivateKeyParameters) && ((ElGamalPrivateKeyParameters) obj).getX().equals(this.f6193x)) {
            return super.equals(obj);
        }
        return false;
    }

    public int hashCode() {
        return getX().hashCode();
    }
}
