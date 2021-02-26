package repack.org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class NaccacheSternKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: g */
    private BigInteger f6204g;
    int lowerSigmaBound;

    /* renamed from: n */
    private BigInteger f6205n;

    public NaccacheSternKeyParameters(boolean z, BigInteger bigInteger, BigInteger bigInteger2, int i) {
        super(z);
        this.f6204g = bigInteger;
        this.f6205n = bigInteger2;
        this.lowerSigmaBound = i;
    }

    public BigInteger getG() {
        return this.f6204g;
    }

    public int getLowerSigmaBound() {
        return this.lowerSigmaBound;
    }

    public BigInteger getModulus() {
        return this.f6205n;
    }
}
