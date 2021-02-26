package repack.org.bouncycastle.cert.crmf.jcajce;

import java.math.BigInteger;
import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.asn1.x509.GeneralName;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.cert.crmf.CertificateRequestMessageBuilder;

public class JcaCertificateRequestMessageBuilder extends CertificateRequestMessageBuilder {
    public JcaCertificateRequestMessageBuilder(BigInteger bigInteger) {
        super(bigInteger);
    }

    public JcaCertificateRequestMessageBuilder setIssuer(X500Principal x500Principal) {
        if (x500Principal != null) {
            setIssuer(X500Name.getInstance(x500Principal.getEncoded()));
        }
        return this;
    }

    public JcaCertificateRequestMessageBuilder setSubject(X500Principal x500Principal) {
        if (x500Principal != null) {
            setSubject(X500Name.getInstance(x500Principal.getEncoded()));
        }
        return this;
    }

    public JcaCertificateRequestMessageBuilder setAuthInfoSender(X500Principal x500Principal) {
        if (x500Principal != null) {
            setAuthInfoSender(new GeneralName(X500Name.getInstance(x500Principal.getEncoded())));
        }
        return this;
    }

    public JcaCertificateRequestMessageBuilder setPublicKey(PublicKey publicKey) {
        setPublicKey(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()));
        return this;
    }
}
