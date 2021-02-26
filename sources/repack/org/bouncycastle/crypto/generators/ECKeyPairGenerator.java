package repack.org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import repack.org.bouncycastle.crypto.KeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.ECDomainParameters;
import repack.org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.ECPublicKeyParameters;
import repack.org.bouncycastle.math.p070ec.ECConstants;

public class ECKeyPairGenerator implements AsymmetricCipherKeyPairGenerator, ECConstants {
    ECDomainParameters params;
    SecureRandom random;

    public void init(KeyGenerationParameters keyGenerationParameters) {
        ECKeyGenerationParameters eCKeyGenerationParameters = (ECKeyGenerationParameters) keyGenerationParameters;
        this.random = eCKeyGenerationParameters.getRandom();
        this.params = eCKeyGenerationParameters.getDomainParameters();
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger n = this.params.getN();
        int bitLength = n.bitLength();
        while (true) {
            BigInteger bigInteger = new BigInteger(bitLength, this.random);
            if (!bigInteger.equals(ZERO) && bigInteger.compareTo(n) < 0) {
                return new AsymmetricCipherKeyPair(new ECPublicKeyParameters(this.params.getG().multiply(bigInteger), this.params), new ECPrivateKeyParameters(bigInteger, this.params));
            }
        }
    }
}
