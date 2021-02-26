package repack.org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import repack.org.bouncycastle.crypto.KeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.DHKeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.DHParameters;
import repack.org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.DHPublicKeyParameters;

public class DHKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private DHKeyGenerationParameters param;

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (DHKeyGenerationParameters) keyGenerationParameters;
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        DHKeyGeneratorHelper dHKeyGeneratorHelper = DHKeyGeneratorHelper.INSTANCE;
        DHParameters parameters = this.param.getParameters();
        BigInteger calculatePrivate = dHKeyGeneratorHelper.calculatePrivate(parameters, this.param.getRandom());
        return new AsymmetricCipherKeyPair(new DHPublicKeyParameters(dHKeyGeneratorHelper.calculatePublic(parameters, calculatePrivate), parameters), new DHPrivateKeyParameters(calculatePrivate, parameters));
    }
}
