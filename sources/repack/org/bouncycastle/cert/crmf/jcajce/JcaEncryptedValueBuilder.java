package repack.org.bouncycastle.cert.crmf.jcajce;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import repack.org.bouncycastle.asn1.crmf.EncryptedValue;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.cert.crmf.CRMFException;
import repack.org.bouncycastle.cert.crmf.EncryptedValueBuilder;
import repack.org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import repack.org.bouncycastle.operator.KeyWrapper;
import repack.org.bouncycastle.operator.OutputEncryptor;

public class JcaEncryptedValueBuilder extends EncryptedValueBuilder {
    public JcaEncryptedValueBuilder(KeyWrapper keyWrapper, OutputEncryptor outputEncryptor) {
        super(keyWrapper, outputEncryptor);
    }

    public EncryptedValue build(X509Certificate x509Certificate) throws CertificateEncodingException, CRMFException {
        return build((X509CertificateHolder) new JcaX509CertificateHolder(x509Certificate));
    }
}
