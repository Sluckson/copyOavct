package repack.org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class DSAPrivateKeyParameters extends DSAKeyParameters {

    /* renamed from: x */
    private BigInteger f6183x;

    public DSAPrivateKeyParameters(BigInteger bigInteger, DSAParameters dSAParameters) {
        super(true, dSAParameters);
        this.f6183x = bigInteger;
    }

    public BigInteger getX() {
        return this.f6183x;
    }
}
