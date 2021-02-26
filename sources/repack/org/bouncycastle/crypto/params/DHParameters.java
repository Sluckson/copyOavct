package repack.org.bouncycastle.crypto.params;

import java.math.BigInteger;
import repack.org.bouncycastle.crypto.CipherParameters;

public class DHParameters implements CipherParameters {
    private static final int DEFAULT_MINIMUM_LENGTH = 160;

    /* renamed from: g */
    private BigInteger f6172g;

    /* renamed from: j */
    private BigInteger f6173j;

    /* renamed from: l */
    private int f6174l;

    /* renamed from: m */
    private int f6175m;

    /* renamed from: p */
    private BigInteger f6176p;

    /* renamed from: q */
    private BigInteger f6177q;
    private DHValidationParameters validation;

    private static int getDefaultMParam(int i) {
        return (i != 0 && i < DEFAULT_MINIMUM_LENGTH) ? i : DEFAULT_MINIMUM_LENGTH;
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, (BigInteger) null, 0);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, 0);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i) {
        this(bigInteger, bigInteger2, bigInteger3, getDefaultMParam(i), i, (BigInteger) null, (DHValidationParameters) null);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i, int i2) {
        this(bigInteger, bigInteger2, bigInteger3, i, i2, (BigInteger) null, (DHValidationParameters) null);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        this(bigInteger, bigInteger2, bigInteger3, DEFAULT_MINIMUM_LENGTH, 0, bigInteger4, dHValidationParameters);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i, int i2, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        if (i2 != 0) {
            if (i2 >= bigInteger.bitLength()) {
                throw new IllegalArgumentException("when l value specified, it must be less than bitlength(p)");
            } else if (i2 < i) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        this.f6172g = bigInteger2;
        this.f6176p = bigInteger;
        this.f6177q = bigInteger3;
        this.f6175m = i;
        this.f6174l = i2;
        this.f6173j = bigInteger4;
        this.validation = dHValidationParameters;
    }

    public BigInteger getP() {
        return this.f6176p;
    }

    public BigInteger getG() {
        return this.f6172g;
    }

    public BigInteger getQ() {
        return this.f6177q;
    }

    public BigInteger getJ() {
        return this.f6173j;
    }

    public int getM() {
        return this.f6175m;
    }

    public int getL() {
        return this.f6174l;
    }

    public DHValidationParameters getValidationParameters() {
        return this.validation;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHParameters)) {
            return false;
        }
        DHParameters dHParameters = (DHParameters) obj;
        if (getQ() != null) {
            if (!getQ().equals(dHParameters.getQ())) {
                return false;
            }
        } else if (dHParameters.getQ() != null) {
            return false;
        }
        if (!dHParameters.getP().equals(this.f6176p) || !dHParameters.getG().equals(this.f6172g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) ^ (getQ() != null ? getQ().hashCode() : 0);
    }
}
