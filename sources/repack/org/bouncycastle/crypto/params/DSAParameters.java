package repack.org.bouncycastle.crypto.params;

import java.math.BigInteger;
import repack.org.bouncycastle.crypto.CipherParameters;

public class DSAParameters implements CipherParameters {

    /* renamed from: g */
    private BigInteger f6180g;

    /* renamed from: p */
    private BigInteger f6181p;

    /* renamed from: q */
    private BigInteger f6182q;
    private DSAValidationParameters validation;

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f6180g = bigInteger3;
        this.f6181p = bigInteger;
        this.f6182q = bigInteger2;
    }

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, DSAValidationParameters dSAValidationParameters) {
        this.f6180g = bigInteger3;
        this.f6181p = bigInteger;
        this.f6182q = bigInteger2;
        this.validation = dSAValidationParameters;
    }

    public BigInteger getP() {
        return this.f6181p;
    }

    public BigInteger getQ() {
        return this.f6182q;
    }

    public BigInteger getG() {
        return this.f6180g;
    }

    public DSAValidationParameters getValidationParameters() {
        return this.validation;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        DSAParameters dSAParameters = (DSAParameters) obj;
        if (!dSAParameters.getP().equals(this.f6181p) || !dSAParameters.getQ().equals(this.f6182q) || !dSAParameters.getG().equals(this.f6180g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getQ().hashCode()) ^ getG().hashCode();
    }
}
