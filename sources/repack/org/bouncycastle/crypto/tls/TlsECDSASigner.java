package repack.org.bouncycastle.crypto.tls;

import repack.org.bouncycastle.crypto.DSA;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.ECPublicKeyParameters;
import repack.org.bouncycastle.crypto.signers.ECDSASigner;

class TlsECDSASigner extends TlsDSASigner {
    TlsECDSASigner() {
    }

    public boolean isValidPublicKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        return asymmetricKeyParameter instanceof ECPublicKeyParameters;
    }

    /* access modifiers changed from: protected */
    public DSA createDSAImpl() {
        return new ECDSASigner();
    }
}
