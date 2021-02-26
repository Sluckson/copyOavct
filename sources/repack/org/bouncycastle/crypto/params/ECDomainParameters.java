package repack.org.bouncycastle.crypto.params;

import java.math.BigInteger;
import repack.org.bouncycastle.math.p070ec.ECConstants;
import repack.org.bouncycastle.math.p070ec.ECCurve;
import repack.org.bouncycastle.math.p070ec.ECPoint;

public class ECDomainParameters implements ECConstants {

    /* renamed from: G */
    ECPoint f6185G;
    ECCurve curve;

    /* renamed from: h */
    BigInteger f6186h;

    /* renamed from: n */
    BigInteger f6187n;
    byte[] seed;

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger) {
        this.curve = eCCurve;
        this.f6185G = eCPoint;
        this.f6187n = bigInteger;
        this.f6186h = ONE;
        this.seed = null;
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this.curve = eCCurve;
        this.f6185G = eCPoint;
        this.f6187n = bigInteger;
        this.f6186h = bigInteger2;
        this.seed = null;
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.curve = eCCurve;
        this.f6185G = eCPoint;
        this.f6187n = bigInteger;
        this.f6186h = bigInteger2;
        this.seed = bArr;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.f6185G;
    }

    public BigInteger getN() {
        return this.f6187n;
    }

    public BigInteger getH() {
        return this.f6186h;
    }

    public byte[] getSeed() {
        return this.seed;
    }
}
