package repack.org.bouncycastle.crypto.params;

import java.math.BigInteger;
import repack.org.bouncycastle.crypto.CipherParameters;

public class GOST3410Parameters implements CipherParameters {

    /* renamed from: a */
    private BigInteger f6195a;

    /* renamed from: p */
    private BigInteger f6196p;

    /* renamed from: q */
    private BigInteger f6197q;
    private GOST3410ValidationParameters validation;

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f6196p = bigInteger;
        this.f6197q = bigInteger2;
        this.f6195a = bigInteger3;
    }

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, GOST3410ValidationParameters gOST3410ValidationParameters) {
        this.f6195a = bigInteger3;
        this.f6196p = bigInteger;
        this.f6197q = bigInteger2;
        this.validation = gOST3410ValidationParameters;
    }

    public BigInteger getP() {
        return this.f6196p;
    }

    public BigInteger getQ() {
        return this.f6197q;
    }

    public BigInteger getA() {
        return this.f6195a;
    }

    public GOST3410ValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (this.f6196p.hashCode() ^ this.f6197q.hashCode()) ^ this.f6195a.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410Parameters)) {
            return false;
        }
        GOST3410Parameters gOST3410Parameters = (GOST3410Parameters) obj;
        if (!gOST3410Parameters.getP().equals(this.f6196p) || !gOST3410Parameters.getQ().equals(this.f6197q) || !gOST3410Parameters.getA().equals(this.f6195a)) {
            return false;
        }
        return true;
    }
}
