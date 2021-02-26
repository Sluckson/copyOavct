package repack.org.bouncycastle.jce.spec;

import java.math.BigInteger;

public class GOST3410PublicKeyParameterSetSpec {

    /* renamed from: a */
    private BigInteger f6264a;

    /* renamed from: p */
    private BigInteger f6265p;

    /* renamed from: q */
    private BigInteger f6266q;

    public GOST3410PublicKeyParameterSetSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f6265p = bigInteger;
        this.f6266q = bigInteger2;
        this.f6264a = bigInteger3;
    }

    public BigInteger getP() {
        return this.f6265p;
    }

    public BigInteger getQ() {
        return this.f6266q;
    }

    public BigInteger getA() {
        return this.f6264a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GOST3410PublicKeyParameterSetSpec) {
            GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec = (GOST3410PublicKeyParameterSetSpec) obj;
            if (!this.f6264a.equals(gOST3410PublicKeyParameterSetSpec.f6264a) || !this.f6265p.equals(gOST3410PublicKeyParameterSetSpec.f6265p) || !this.f6266q.equals(gOST3410PublicKeyParameterSetSpec.f6266q)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f6264a.hashCode() ^ this.f6265p.hashCode()) ^ this.f6266q.hashCode();
    }
}
