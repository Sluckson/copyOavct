package repack.org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class RSAPrivateCrtKeyParameters extends RSAKeyParameters {

    /* renamed from: dP */
    private BigInteger f6207dP;

    /* renamed from: dQ */
    private BigInteger f6208dQ;

    /* renamed from: e */
    private BigInteger f6209e;

    /* renamed from: p */
    private BigInteger f6210p;

    /* renamed from: q */
    private BigInteger f6211q;
    private BigInteger qInv;

    public RSAPrivateCrtKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        super(true, bigInteger, bigInteger3);
        this.f6209e = bigInteger2;
        this.f6210p = bigInteger4;
        this.f6211q = bigInteger5;
        this.f6207dP = bigInteger6;
        this.f6208dQ = bigInteger7;
        this.qInv = bigInteger8;
    }

    public BigInteger getPublicExponent() {
        return this.f6209e;
    }

    public BigInteger getP() {
        return this.f6210p;
    }

    public BigInteger getQ() {
        return this.f6211q;
    }

    public BigInteger getDP() {
        return this.f6207dP;
    }

    public BigInteger getDQ() {
        return this.f6208dQ;
    }

    public BigInteger getQInv() {
        return this.qInv;
    }
}
