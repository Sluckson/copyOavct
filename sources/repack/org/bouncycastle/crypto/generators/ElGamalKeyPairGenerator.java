package repack.org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import repack.org.bouncycastle.crypto.KeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.DHParameters;
import repack.org.bouncycastle.crypto.params.ElGamalKeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.ElGamalParameters;
import repack.org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;

public class ElGamalKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private ElGamalKeyGenerationParameters param;

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (ElGamalKeyGenerationParameters) keyGenerationParameters;
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        DHKeyGeneratorHelper dHKeyGeneratorHelper = DHKeyGeneratorHelper.INSTANCE;
        ElGamalParameters parameters = this.param.getParameters();
        DHParameters dHParameters = new DHParameters(parameters.getP(), parameters.getG(), (BigInteger) null, parameters.getL());
        BigInteger calculatePrivate = dHKeyGeneratorHelper.calculatePrivate(dHParameters, this.param.getRandom());
        return new AsymmetricCipherKeyPair(new ElGamalPublicKeyParameters(dHKeyGeneratorHelper.calculatePublic(dHParameters, calculatePrivate), parameters), new ElGamalPrivateKeyParameters(calculatePrivate, parameters));
    }
}
