package repack.org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class GOST3410PublicKeySpec implements KeySpec {

    /* renamed from: a */
    private BigInteger f6267a;

    /* renamed from: p */
    private BigInteger f6268p;

    /* renamed from: q */
    private BigInteger f6269q;

    /* renamed from: y */
    private BigInteger f6270y;

    public GOST3410PublicKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f6270y = bigInteger;
        this.f6268p = bigInteger2;
        this.f6269q = bigInteger3;
        this.f6267a = bigInteger4;
    }

    public BigInteger getY() {
        return this.f6270y;
    }

    public BigInteger getP() {
        return this.f6268p;
    }

    public BigInteger getQ() {
        return this.f6269q;
    }

    public BigInteger getA() {
        return this.f6267a;
    }
}
