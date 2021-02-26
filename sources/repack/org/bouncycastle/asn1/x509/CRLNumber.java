package repack.org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import repack.org.bouncycastle.asn1.DERInteger;

public class CRLNumber extends DERInteger {
    public CRLNumber(BigInteger bigInteger) {
        super(bigInteger);
    }

    public BigInteger getCRLNumber() {
        return getPositiveValue();
    }

    public String toString() {
        return "CRLNumber: " + getCRLNumber();
    }
}
