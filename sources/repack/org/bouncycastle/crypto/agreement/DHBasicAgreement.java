package repack.org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import repack.org.bouncycastle.crypto.BasicAgreement;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.DHParameters;
import repack.org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.DHPublicKeyParameters;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;

public class DHBasicAgreement implements BasicAgreement {
    private DHParameters dhParams;
    private DHPrivateKeyParameters key;

    public void init(CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        if (cipherParameters instanceof ParametersWithRandom) {
            asymmetricKeyParameter = (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
        }
        if (asymmetricKeyParameter instanceof DHPrivateKeyParameters) {
            this.key = (DHPrivateKeyParameters) asymmetricKeyParameter;
            this.dhParams = this.key.getParameters();
            return;
        }
        throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
    }

    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        DHPublicKeyParameters dHPublicKeyParameters = (DHPublicKeyParameters) cipherParameters;
        if (dHPublicKeyParameters.getParameters().equals(this.dhParams)) {
            return dHPublicKeyParameters.getY().modPow(this.key.getX(), this.dhParams.getP());
        }
        throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
    }
}
