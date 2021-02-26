package repack.org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import repack.org.bouncycastle.math.p070ec.ECCurve;
import repack.org.bouncycastle.math.p070ec.ECPoint;

public class ECParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: G */
    private ECPoint f6250G;
    private ECCurve curve;

    /* renamed from: h */
    private BigInteger f6251h;

    /* renamed from: n */
    private BigInteger f6252n;
    private byte[] seed;

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this.curve = eCCurve;
        this.f6250G = eCPoint;
        this.f6252n = bigInteger;
        this.f6251h = BigInteger.valueOf(1);
        this.seed = null;
    }

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this.curve = eCCurve;
        this.f6250G = eCPoint;
        this.f6252n = bigInteger;
        this.f6251h = bigInteger2;
        this.seed = null;
    }

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.curve = eCCurve;
        this.f6250G = eCPoint;
        this.f6252n = bigInteger;
        this.f6251h = bigInteger2;
        this.seed = bArr;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.f6250G;
    }

    public BigInteger getN() {
        return this.f6252n;
    }

    public BigInteger getH() {
        return this.f6251h;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ECParameterSpec)) {
            return false;
        }
        ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
        if (!getCurve().equals(eCParameterSpec.getCurve()) || !getG().equals(eCParameterSpec.getG())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return getCurve().hashCode() ^ getG().hashCode();
    }
}
