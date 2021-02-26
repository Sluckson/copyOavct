package repack.org.bouncycastle.crypto.params;

import java.math.BigInteger;
import repack.org.bouncycastle.crypto.CipherParameters;

public class ElGamalParameters implements CipherParameters {

    /* renamed from: g */
    private BigInteger f6190g;

    /* renamed from: l */
    private int f6191l;

    /* renamed from: p */
    private BigInteger f6192p;

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f6190g = bigInteger2;
        this.f6192p = bigInteger;
        this.f6191l = i;
    }

    public BigInteger getP() {
        return this.f6192p;
    }

    public BigInteger getG() {
        return this.f6190g;
    }

    public int getL() {
        return this.f6191l;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ElGamalParameters)) {
            return false;
        }
        ElGamalParameters elGamalParameters = (ElGamalParameters) obj;
        if (!elGamalParameters.getP().equals(this.f6192p) || !elGamalParameters.getG().equals(this.f6190g) || elGamalParameters.getL() != this.f6191l) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) + this.f6191l;
    }
}
