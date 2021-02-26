package repack.org.bouncycastle.crypto.params;

import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.CipherParameters;

public class ParametersWithRandom implements CipherParameters {
    private CipherParameters parameters;
    private SecureRandom random;

    public ParametersWithRandom(CipherParameters cipherParameters, SecureRandom secureRandom) {
        this.random = secureRandom;
        this.parameters = cipherParameters;
    }

    public ParametersWithRandom(CipherParameters cipherParameters) {
        this(cipherParameters, new SecureRandom());
    }

    public SecureRandom getRandom() {
        return this.random;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}
