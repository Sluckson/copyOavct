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

public class ECGOST3410Signer implements DSA {
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
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i != bArr2.length; i++) {
            bArr2[i] = bArr[(bArr2.length - 1) - i];
        }
        BigInteger bigInteger = new BigInteger(1, bArr2);
        BigInteger n = this.key.getParameters().getN();
        while (true) {
            BigInteger bigInteger2 = new BigInteger(n.bitLength(), this.random);
            if (!bigInteger2.equals(ECConstants.ZERO)) {
                BigInteger mod = this.key.getParameters().getG().multiply(bigInteger2).getX().toBigInteger().mod(n);
                if (!mod.equals(ECConstants.ZERO)) {
                    BigInteger mod2 = bigInteger2.multiply(bigInteger).add(((ECPrivateKeyParameters) this.key).getD().multiply(mod)).mod(n);
                    if (!mod2.equals(ECConstants.ZERO)) {
                        return new BigInteger[]{mod, mod2};
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i != bArr2.length; i++) {
            bArr2[i] = bArr[(bArr2.length - 1) - i];
        }
        BigInteger bigInteger3 = new BigInteger(1, bArr2);
        BigInteger n = this.key.getParameters().getN();
        if (bigInteger.compareTo(ECConstants.ONE) < 0 || bigInteger.compareTo(n) >= 0 || bigInteger2.compareTo(ECConstants.ONE) < 0 || bigInteger2.compareTo(n) >= 0) {
            return false;
        }
        BigInteger modInverse = bigInteger3.modInverse(n);
        return ECAlgorithms.sumOfTwoMultiplies(this.key.getParameters().getG(), bigInteger2.multiply(modInverse).mod(n), ((ECPublicKeyParameters) this.key).getQ(), n.subtract(bigInteger).multiply(modInverse).mod(n)).getX().toBigInteger().mod(n).equals(bigInteger);
    }
}
