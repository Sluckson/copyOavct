package repack.org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class GOST3410PrivateKeySpec implements KeySpec {

    /* renamed from: a */
    private BigInteger f6260a;

    /* renamed from: p */
    private BigInteger f6261p;

    /* renamed from: q */
    private BigInteger f6262q;

    /* renamed from: x */
    private BigInteger f6263x;

    public GOST3410PrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f6263x = bigInteger;
        this.f6261p = bigInteger2;
        this.f6262q = bigInteger3;
        this.f6260a = bigInteger4;
    }

    public BigInteger getX() {
        return this.f6263x;
    }

    public BigInteger getP() {
        return this.f6261p;
    }

    public BigInteger getQ() {
        return this.f6262q;
    }

    public BigInteger getA() {
        return this.f6260a;
    }
}
