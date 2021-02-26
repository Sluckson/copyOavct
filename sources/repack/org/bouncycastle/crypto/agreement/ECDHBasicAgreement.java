package repack.org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import repack.org.bouncycastle.crypto.BasicAgreement;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.ECPublicKeyParameters;

public class ECDHBasicAgreement implements BasicAgreement {
    private ECPrivateKeyParameters key;

    public void init(CipherParameters cipherParameters) {
        this.key = (ECPrivateKeyParameters) cipherParameters;
    }

    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        return ((ECPublicKeyParameters) cipherParameters).getQ().multiply(this.key.getD()).getX().toBigInteger();
    }
}
