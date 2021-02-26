package repack.org.bouncycastle.jce.spec;

import java.math.BigInteger;

public class ElGamalPublicKeySpec extends ElGamalKeySpec {

    /* renamed from: y */
    private BigInteger f6258y;

    public ElGamalPublicKeySpec(BigInteger bigInteger, ElGamalParameterSpec elGamalParameterSpec) {
        super(elGamalParameterSpec);
        this.f6258y = bigInteger;
    }

    public BigInteger getY() {
        return this.f6258y;
    }
}
