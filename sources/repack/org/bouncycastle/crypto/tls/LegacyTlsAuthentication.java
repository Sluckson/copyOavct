package repack.org.bouncycastle.crypto.tls;

import java.io.IOException;

public class LegacyTlsAuthentication implements TlsAuthentication {
    protected CertificateVerifyer verifyer;

    public TlsCredentials getClientCredentials(CertificateRequest certificateRequest) throws IOException {
        return null;
    }

    public LegacyTlsAuthentication(CertificateVerifyer certificateVerifyer) {
        this.verifyer = certificateVerifyer;
    }

    public void notifyServerCertificate(Certificate certificate) throws IOException {
        if (!this.verifyer.isValid(certificate.getCerts())) {
            throw new TlsFatalAlert(90);
        }
    }
}
