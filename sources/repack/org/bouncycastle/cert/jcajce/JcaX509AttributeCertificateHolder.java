package repack.org.bouncycastle.cert.jcajce;

import java.io.IOException;
import repack.org.bouncycastle.asn1.x509.AttributeCertificate;
import repack.org.bouncycastle.cert.X509AttributeCertificateHolder;
import repack.org.bouncycastle.x509.X509AttributeCertificate;

public class JcaX509AttributeCertificateHolder extends X509AttributeCertificateHolder {
    public JcaX509AttributeCertificateHolder(X509AttributeCertificate x509AttributeCertificate) throws IOException {
        super(AttributeCertificate.getInstance(x509AttributeCertificate.getEncoded()));
    }
}
