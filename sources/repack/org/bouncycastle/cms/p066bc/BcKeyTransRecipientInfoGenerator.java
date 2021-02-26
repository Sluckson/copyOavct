package repack.org.bouncycastle.cms.p066bc;

import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.cms.KeyTransRecipientInfoGenerator;
import repack.org.bouncycastle.operator.AsymmetricKeyWrapper;
import repack.org.bouncycastle.operator.p071bc.BcAsymmetricKeyWrapper;

/* renamed from: repack.org.bouncycastle.cms.bc.BcKeyTransRecipientInfoGenerator */
public abstract class BcKeyTransRecipientInfoGenerator extends KeyTransRecipientInfoGenerator {
    public BcKeyTransRecipientInfoGenerator(X509CertificateHolder x509CertificateHolder, BcAsymmetricKeyWrapper bcAsymmetricKeyWrapper) {
        super(x509CertificateHolder.getIssuerAndSerialNumber(), (AsymmetricKeyWrapper) bcAsymmetricKeyWrapper);
    }

    public BcKeyTransRecipientInfoGenerator(byte[] bArr, BcAsymmetricKeyWrapper bcAsymmetricKeyWrapper) {
        super(bArr, (AsymmetricKeyWrapper) bcAsymmetricKeyWrapper);
    }
}
