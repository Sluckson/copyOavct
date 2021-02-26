package repack.org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DSA;
import repack.org.bouncycastle.crypto.params.ECKeyParameters;
import repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.ECPublicKeyParameters;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;
import repack.org.bouncycastle.math.p070ec.ECAlgorithms;
import repack.org.bouncycastle.math.p070ec.ECConstants;

public class ECDSASigner implements ECConstants, DSA {
    ECKeyParameters key;
    SecureRandom random;

    public void init(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.key = (ECPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.random = parametersWithRandom.getRandom();
            this.key = (ECPrivateKeyParameters) parametersWithRandom.getParameters();
        } else {
            this.random = new SecureRandom();
            this.key = (ECPrivateKeyParameters) cipherParameters;
        }
    }

    public BigInteger[] generateSignature(byte[] bArr) {
        BigInteger mod;
        BigInteger mod2;
        BigInteger n = this.key.getParameters().getN();
        BigInteger calculateE = calculateE(n, bArr);
        do {
            int bitLength = n.bitLength();
            while (true) {
                BigInteger bigInteger = new BigInteger(bitLength, this.random);
                if (!bigInteger.equals(ZERO) && bigInteger.compareTo(n) < 0) {
                    mod = this.key.getParameters().getG().multiply(bigInteger).getX().toBigInteger().mod(n);
                    if (!mod.equals(ZERO)) {
                        mod2 = bigInteger.modInverse(n).multiply(calculateE.add(((ECPrivateKeyParameters) this.key).getD().multiply(mod))).mod(n);
                    }
                }
            }
        } while (mod2.equals(ZERO));
        return new BigInteger[]{mod, mod2};
    }

    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger n = this.key.getParameters().getN();
        BigInteger calculateE = calculateE(n, bArr);
        if (bigInteger.compareTo(ONE) < 0 || bigInteger.compareTo(n) >= 0 || bigInteger2.compareTo(ONE) < 0 || bigInteger2.compareTo(n) >= 0) {
            return false;
        }
        BigInteger modInverse = bigInteger2.modInverse(n);
        return ECAlgorithms.sumOfTwoMultiplies(this.key.getParameters().getG(), calculateE.multiply(modInverse).mod(n), ((ECPublicKeyParameters) this.key).getQ(), bigInteger.multiply(modInverse).mod(n)).getX().toBigInteger().mod(n).equals(bigInteger);
    }

    private BigInteger calculateE(BigInteger bigInteger, byte[] bArr) {
        if (bigInteger.bitLength() > bArr.length * 8) {
            return new BigInteger(1, bArr);
        }
        int length = bArr.length * 8;
        BigInteger bigInteger2 = new BigInteger(1, bArr);
        return length - bigInteger.bitLength() > 0 ? bigInteger2.shiftRight(length - bigInteger.bitLength()) : bigInteger2;
    }
}
