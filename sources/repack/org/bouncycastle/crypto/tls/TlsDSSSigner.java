package repack.org.bouncycastle.crypto.tls;

import repack.org.bouncycastle.crypto.DSA;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import repack.org.bouncycastle.crypto.signers.DSASigner;

class TlsDSSSigner extends TlsDSASigner {
    TlsDSSSigner() {
    }

    public boolean isValidPublicKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        return asymmetricKeyParameter instanceof DSAPublicKeyParameters;
    }

    /* access modifiers changed from: protected */
    public DSA createDSAImpl() {
        return new DSASigner();
    }
}
