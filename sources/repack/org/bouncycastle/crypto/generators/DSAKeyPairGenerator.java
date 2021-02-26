package repack.org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import repack.org.bouncycastle.crypto.KeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.DSAKeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.DSAParameters;
import repack.org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import repack.org.bouncycastle.util.BigIntegers;

public class DSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private DSAKeyGenerationParameters param;

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (DSAKeyGenerationParameters) keyGenerationParameters;
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        DSAParameters parameters = this.param.getParameters();
        BigInteger generatePrivateKey = generatePrivateKey(parameters.getQ(), this.param.getRandom());
        return new AsymmetricCipherKeyPair(new DSAPublicKeyParameters(calculatePublicKey(parameters.getP(), parameters.getG(), generatePrivateKey), parameters), new DSAPrivateKeyParameters(generatePrivateKey, parameters));
    }

    private static BigInteger generatePrivateKey(BigInteger bigInteger, SecureRandom secureRandom) {
        BigInteger bigInteger2 = ONE;
        return BigIntegers.createRandomInRange(bigInteger2, bigInteger.subtract(bigInteger2), secureRandom);
    }

    private static BigInteger calculatePublicKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return bigInteger2.modPow(bigInteger3, bigInteger);
    }
}
