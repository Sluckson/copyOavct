package repack.org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class ElGamalParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: g */
    private BigInteger f6255g;

    /* renamed from: p */
    private BigInteger f6256p;

    public ElGamalParameterSpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f6256p = bigInteger;
        this.f6255g = bigInteger2;
    }

    public BigInteger getP() {
        return this.f6256p;
    }

    public BigInteger getG() {
        return this.f6255g;
    }
}
