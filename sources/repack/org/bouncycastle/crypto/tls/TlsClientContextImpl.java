package repack.org.bouncycastle.crypto.tls;

import java.security.SecureRandom;

class TlsClientContextImpl implements TlsClientContext {
    private SecureRandom secureRandom;
    private SecurityParameters securityParameters;
    private Object userObject = null;

    TlsClientContextImpl(SecureRandom secureRandom2, SecurityParameters securityParameters2) {
        this.secureRandom = secureRandom2;
        this.securityParameters = securityParameters2;
    }

    public SecureRandom getSecureRandom() {
        return this.secureRandom;
    }

    public SecurityParameters getSecurityParameters() {
        return this.securityParameters;
    }

    public Object getUserObject() {
        return this.userObject;
    }

    public void setUserObject(Object obj) {
        this.userObject = obj;
    }
}
