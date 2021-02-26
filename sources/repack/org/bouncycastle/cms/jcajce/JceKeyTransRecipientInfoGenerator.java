package repack.org.bouncycastle.cms.jcajce;

import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import repack.org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import repack.org.bouncycastle.cms.KeyTransRecipientInfoGenerator;
import repack.org.bouncycastle.operator.AsymmetricKeyWrapper;
import repack.org.bouncycastle.operator.OperatorCreationException;
import repack.org.bouncycastle.operator.jcajce.JceAsymmetricKeyWrapper;

public class JceKeyTransRecipientInfoGenerator extends KeyTransRecipientInfoGenerator {
    public JceKeyTransRecipientInfoGenerator(X509Certificate x509Certificate) throws CertificateEncodingException {
        super(new JcaX509CertificateHolder(x509Certificate).getIssuerAndSerialNumber(), (AsymmetricKeyWrapper) new JceAsymmetricKeyWrapper(x509Certificate.getPublicKey()));
    }

    public JceKeyTransRecipientInfoGenerator(byte[] bArr, PublicKey publicKey) {
        super(bArr, (AsymmetricKeyWrapper) new JceAsymmetricKeyWrapper(publicKey));
    }

    public JceKeyTransRecipientInfoGenerator setProvider(String str) throws OperatorCreationException {
        ((JceAsymmetricKeyWrapper) this.wrapper).setProvider(str);
        return this;
    }

    public JceKeyTransRecipientInfoGenerator setProvider(Provider provider) throws OperatorCreationException {
        ((JceAsymmetricKeyWrapper) this.wrapper).setProvider(provider);
        return this;
    }
}
