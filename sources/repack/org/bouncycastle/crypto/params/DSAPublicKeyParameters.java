package repack.org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class DSAPublicKeyParameters extends DSAKeyParameters {

    /* renamed from: y */
    private BigInteger f6184y;

    public DSAPublicKeyParameters(BigInteger bigInteger, DSAParameters dSAParameters) {
        super(false, dSAParameters);
        this.f6184y = bigInteger;
    }

    public BigInteger getY() {
        return this.f6184y;
    }
}
