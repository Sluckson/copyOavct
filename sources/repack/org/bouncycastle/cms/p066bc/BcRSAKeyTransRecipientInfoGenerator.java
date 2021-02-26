package repack.org.bouncycastle.cms.p066bc;

import java.io.IOException;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.operator.p071bc.BcAsymmetricKeyWrapper;
import repack.org.bouncycastle.operator.p071bc.BcRSAAsymmetricKeyWrapper;

/* renamed from: repack.org.bouncycastle.cms.bc.BcRSAKeyTransRecipientInfoGenerator */
public class BcRSAKeyTransRecipientInfoGenerator extends BcKeyTransRecipientInfoGenerator {
    public BcRSAKeyTransRecipientInfoGenerator(byte[] bArr, AlgorithmIdentifier algorithmIdentifier, AsymmetricKeyParameter asymmetricKeyParameter) {
        super(bArr, (BcAsymmetricKeyWrapper) new BcRSAAsymmetricKeyWrapper(algorithmIdentifier, asymmetricKeyParameter));
    }

    public BcRSAKeyTransRecipientInfoGenerator(X509CertificateHolder x509CertificateHolder) throws IOException {
        super(x509CertificateHolder, (BcAsymmetricKeyWrapper) new BcRSAAsymmetricKeyWrapper(x509CertificateHolder.getSubjectPublicKeyInfo().getAlgorithmId(), x509CertificateHolder.getSubjectPublicKeyInfo()));
    }
}
