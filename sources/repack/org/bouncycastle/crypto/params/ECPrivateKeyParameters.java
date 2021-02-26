package repack.org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class ECPrivateKeyParameters extends ECKeyParameters {

    /* renamed from: d */
    BigInteger f6188d;

    public ECPrivateKeyParameters(BigInteger bigInteger, ECDomainParameters eCDomainParameters) {
        super(true, eCDomainParameters);
        this.f6188d = bigInteger;
    }

    public BigInteger getD() {
        return this.f6188d;
    }
}
