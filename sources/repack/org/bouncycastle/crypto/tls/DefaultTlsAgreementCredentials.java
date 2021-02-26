package repack.org.bouncycastle.crypto.tls;

import repack.org.bouncycastle.crypto.BasicAgreement;
import repack.org.bouncycastle.crypto.agreement.DHBasicAgreement;
import repack.org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import repack.org.bouncycastle.util.BigIntegers;

public class DefaultTlsAgreementCredentials implements TlsAgreementCredentials {
    protected BasicAgreement basicAgreement;
    protected Certificate clientCert;
    protected AsymmetricKeyParameter clientPrivateKey;

    public DefaultTlsAgreementCredentials(Certificate certificate, AsymmetricKeyParameter asymmetricKeyParameter) {
        if (certificate == null) {
            throw new IllegalArgumentException("'clientCertificate' cannot be null");
        } else if (certificate.certs.length == 0) {
            throw new IllegalArgumentException("'clientCertificate' cannot be empty");
        } else if (asymmetricKeyParameter == null) {
            throw new IllegalArgumentException("'clientPrivateKey' cannot be null");
        } else if (asymmetricKeyParameter.isPrivate()) {
            if (asymmetricKeyParameter instanceof DHPrivateKeyParameters) {
                this.basicAgreement = new DHBasicAgreement();
            } else if (asymmetricKeyParameter instanceof ECPrivateKeyParameters) {
                this.basicAgreement = new ECDHBasicAgreement();
            } else {
                throw new IllegalArgumentException("'clientPrivateKey' type not supported: " + asymmetricKeyParameter.getClass().getName());
            }
            this.clientCert = certificate;
            this.clientPrivateKey = asymmetricKeyParameter;
        } else {
            throw new IllegalArgumentException("'clientPrivateKey' must be private");
        }
    }

    public Certificate getCertificate() {
        return this.clientCert;
    }

    public byte[] generateAgreement(AsymmetricKeyParameter asymmetricKeyParameter) {
        this.basicAgreement.init(this.clientPrivateKey);
        return BigIntegers.asUnsignedByteArray(this.basicAgreement.calculateAgreement(asymmetricKeyParameter));
    }
}
