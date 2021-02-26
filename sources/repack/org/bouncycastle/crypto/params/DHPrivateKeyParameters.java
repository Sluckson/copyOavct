package repack.org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class DHPrivateKeyParameters extends DHKeyParameters {

    /* renamed from: x */
    private BigInteger f6178x;

    public DHPrivateKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(true, dHParameters);
        this.f6178x = bigInteger;
    }

    public BigInteger getX() {
        return this.f6178x;
    }

    public int hashCode() {
        return this.f6178x.hashCode() ^ super.hashCode();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof DHPrivateKeyParameters) && ((DHPrivateKeyParameters) obj).getX().equals(this.f6178x) && super.equals(obj)) {
            return true;
        }
        return false;
    }
}
