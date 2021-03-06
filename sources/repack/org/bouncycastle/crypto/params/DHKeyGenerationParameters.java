package repack.org.bouncycastle.crypto.params;

import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.KeyGenerationParameters;

public class DHKeyGenerationParameters extends KeyGenerationParameters {
    private DHParameters params;

    public DHKeyGenerationParameters(SecureRandom secureRandom, DHParameters dHParameters) {
        super(secureRandom, getStrength(dHParameters));
        this.params = dHParameters;
    }

    public DHParameters getParameters() {
        return this.params;
    }

    static int getStrength(DHParameters dHParameters) {
        return dHParameters.getL() != 0 ? dHParameters.getL() : dHParameters.getP().bitLength();
    }
}
