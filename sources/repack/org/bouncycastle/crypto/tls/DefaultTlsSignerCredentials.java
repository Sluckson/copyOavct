package repack.org.bouncycastle.crypto.tls;

import java.io.IOException;
import repack.org.bouncycastle.crypto.CryptoException;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.RSAKeyParameters;

public class DefaultTlsSignerCredentials implements TlsSignerCredentials {
    protected Certificate clientCert;
    protected AsymmetricKeyParameter clientPrivateKey;
    protected TlsSigner clientSigner;
    protected TlsClientContext context;

    public DefaultTlsSignerCredentials(TlsClientContext tlsClientContext, Certificate certificate, AsymmetricKeyParameter asymmetricKeyParameter) {
        if (certificate == null) {
            throw new IllegalArgumentException("'clientCertificate' cannot be null");
        } else if (certificate.certs.length == 0) {
            throw new IllegalArgumentException("'clientCertificate' cannot be empty");
        } else if (asymmetricKeyParameter == null) {
            throw new IllegalArgumentException("'clientPrivateKey' cannot be null");
        } else if (asymmetricKeyParameter.isPrivate()) {
            if (asymmetricKeyParameter instanceof RSAKeyParameters) {
                this.clientSigner = new TlsRSASigner();
            } else if (asymmetricKeyParameter instanceof DSAPrivateKeyParameters) {
                this.clientSigner = new TlsDSSSigner();
            } else if (asymmetricKeyParameter instanceof ECPrivateKeyParameters) {
                this.clientSigner = new TlsECDSASigner();
            } else {
                throw new IllegalArgumentException("'clientPrivateKey' type not supported: " + asymmetricKeyParameter.getClass().getName());
            }
            this.context = tlsClientContext;
            this.clientCert = certificate;
            this.clientPrivateKey = asymmetricKeyParameter;
        } else {
            throw new IllegalArgumentException("'clientPrivateKey' must be private");
        }
    }

    public Certificate getCertificate() {
        return this.clientCert;
    }

    public byte[] generateCertificateSignature(byte[] bArr) throws IOException {
        try {
            return this.clientSigner.calculateRawSignature(this.context.getSecureRandom(), this.clientPrivateKey, bArr);
        } catch (CryptoException unused) {
            throw new TlsFatalAlert(80);
        }
    }
}
