package repack.org.bouncycastle.cms.p066bc;

import java.security.cert.CertificateException;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.cms.SignerInformationVerifier;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import repack.org.bouncycastle.operator.DigestCalculatorProvider;
import repack.org.bouncycastle.operator.OperatorCreationException;
import repack.org.bouncycastle.operator.p071bc.BcRSAContentVerifierProviderBuilder;

/* renamed from: repack.org.bouncycastle.cms.bc.BcRSASignerInfoVerifierBuilder */
public class BcRSASignerInfoVerifierBuilder {
    private BcRSAContentVerifierProviderBuilder contentVerifierProviderBuilder;
    private DigestCalculatorProvider digestCalculatorProvider;

    public BcRSASignerInfoVerifierBuilder(DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder, DigestCalculatorProvider digestCalculatorProvider2) {
        this.contentVerifierProviderBuilder = new BcRSAContentVerifierProviderBuilder(digestAlgorithmIdentifierFinder);
        this.digestCalculatorProvider = digestCalculatorProvider2;
    }

    public SignerInformationVerifier build(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException, CertificateException {
        return new SignerInformationVerifier(this.contentVerifierProviderBuilder.build(x509CertificateHolder), this.digestCalculatorProvider);
    }

    public SignerInformationVerifier build(AsymmetricKeyParameter asymmetricKeyParameter) throws OperatorCreationException {
        return new SignerInformationVerifier(this.contentVerifierProviderBuilder.build(asymmetricKeyParameter), this.digestCalculatorProvider);
    }
}
