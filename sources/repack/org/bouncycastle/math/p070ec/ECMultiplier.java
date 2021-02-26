package repack.org.bouncycastle.math.p070ec;

import java.math.BigInteger;

/* renamed from: repack.org.bouncycastle.math.ec.ECMultiplier */
interface ECMultiplier {
    ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger, PreCompInfo preCompInfo);
}
