package repack.org.bouncycastle.jce.spec;

import java.math.BigInteger;

public class ElGamalPrivateKeySpec extends ElGamalKeySpec {

    /* renamed from: x */
    private BigInteger f6257x;

    public ElGamalPrivateKeySpec(BigInteger bigInteger, ElGamalParameterSpec elGamalParameterSpec) {
        super(elGamalParameterSpec);
        this.f6257x = bigInteger;
    }

    public BigInteger getX() {
        return this.f6257x;
    }
}
