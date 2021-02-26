package repack.org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.generators.DHKeyPairGenerator;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.DHKeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.DHParameters;
import repack.org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.DHPublicKeyParameters;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;

public class DHAgreement {
    private DHParameters dhParams;
    private DHPrivateKeyParameters key;
    private BigInteger privateValue;
    private SecureRandom random;

    public void init(CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.random = parametersWithRandom.getRandom();
            asymmetricKeyParameter = (AsymmetricKeyParameter) parametersWithRandom.getParameters();
        } else {
            this.random = new SecureRandom();
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (asymmetricKeyParameter instanceof DHPrivateKeyParameters) {
            this.key = (DHPrivateKeyParameters) asymmetricKeyParameter;
            this.dhParams = this.key.getParameters();
            return;
        }
        throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
    }

    public BigInteger calculateMessage() {
        DHKeyPairGenerator dHKeyPairGenerator = new DHKeyPairGenerator();
        dHKeyPairGenerator.init(new DHKeyGenerationParameters(this.random, this.dhParams));
        AsymmetricCipherKeyPair generateKeyPair = dHKeyPairGenerator.generateKeyPair();
        this.privateValue = ((DHPrivateKeyParameters) generateKeyPair.getPrivate()).getX();
        return ((DHPublicKeyParameters) generateKeyPair.getPublic()).getY();
    }

    public BigInteger calculateAgreement(DHPublicKeyParameters dHPublicKeyParameters, BigInteger bigInteger) {
        if (dHPublicKeyParameters.getParameters().equals(this.dhParams)) {
            BigInteger p = this.dhParams.getP();
            return bigInteger.modPow(this.key.getX(), p).multiply(dHPublicKeyParameters.getY().modPow(this.privateValue, p)).mod(p);
        }
        throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
    }
}
