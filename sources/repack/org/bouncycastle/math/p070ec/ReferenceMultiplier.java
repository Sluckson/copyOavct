package repack.org.bouncycastle.math.p070ec;

import java.math.BigInteger;

/* renamed from: repack.org.bouncycastle.math.ec.ReferenceMultiplier */
class ReferenceMultiplier implements ECMultiplier {
    ReferenceMultiplier() {
    }

    public ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger, PreCompInfo preCompInfo) {
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        int bitLength = bigInteger.bitLength();
        for (int i = 0; i < bitLength; i++) {
            if (bigInteger.testBit(i)) {
                infinity = infinity.add(eCPoint);
            }
            eCPoint = eCPoint.twice();
        }
        return infinity;
    }
}
