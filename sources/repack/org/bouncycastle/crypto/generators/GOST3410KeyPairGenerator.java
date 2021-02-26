package repack.org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import repack.org.bouncycastle.crypto.KeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.GOST3410KeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.GOST3410Parameters;
import repack.org.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.GOST3410PublicKeyParameters;

public class GOST3410KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private GOST3410KeyGenerationParameters param;

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (GOST3410KeyGenerationParameters) keyGenerationParameters;
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        GOST3410Parameters parameters = this.param.getParameters();
        SecureRandom random = this.param.getRandom();
        BigInteger q = parameters.getQ();
        BigInteger p = parameters.getP();
        BigInteger a = parameters.getA();
        while (true) {
            BigInteger bigInteger = new BigInteger(256, random);
            if (!bigInteger.equals(ZERO) && bigInteger.compareTo(q) < 0) {
                return new AsymmetricCipherKeyPair(new GOST3410PublicKeyParameters(a.modPow(bigInteger, p), parameters), new GOST3410PrivateKeyParameters(bigInteger, parameters));
            }
        }
    }
}
