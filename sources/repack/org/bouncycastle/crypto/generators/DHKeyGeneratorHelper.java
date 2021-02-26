package repack.org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.params.DHParameters;
import repack.org.bouncycastle.util.BigIntegers;

class DHKeyGeneratorHelper {
    static final DHKeyGeneratorHelper INSTANCE = new DHKeyGeneratorHelper();
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    private DHKeyGeneratorHelper() {
    }

    /* access modifiers changed from: package-private */
    public BigInteger calculatePrivate(DHParameters dHParameters, SecureRandom secureRandom) {
        BigInteger p = dHParameters.getP();
        int l = dHParameters.getL();
        if (l != 0) {
            return new BigInteger(l, secureRandom).setBit(l - 1);
        }
        BigInteger bigInteger = TWO;
        int m = dHParameters.getM();
        if (m != 0) {
            bigInteger = ONE.shiftLeft(m - 1);
        }
        BigInteger subtract = p.subtract(TWO);
        BigInteger q = dHParameters.getQ();
        if (q != null) {
            subtract = q.subtract(TWO);
        }
        return BigIntegers.createRandomInRange(bigInteger, subtract, secureRandom);
    }

    /* access modifiers changed from: package-private */
    public BigInteger calculatePublic(DHParameters dHParameters, BigInteger bigInteger) {
        return dHParameters.getG().modPow(bigInteger, dHParameters.getP());
    }
}
