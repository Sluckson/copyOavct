package repack.org.bouncycastle.cms;

import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.operator.ContentVerifier;
import repack.org.bouncycastle.operator.ContentVerifierProvider;
import repack.org.bouncycastle.operator.DigestCalculator;
import repack.org.bouncycastle.operator.DigestCalculatorProvider;
import repack.org.bouncycastle.operator.OperatorCreationException;

public class SignerInformationVerifier {
    private DigestCalculatorProvider digestProvider;
    private ContentVerifierProvider verifierProvider;

    public SignerInformationVerifier(ContentVerifierProvider contentVerifierProvider, DigestCalculatorProvider digestCalculatorProvider) {
        this.verifierProvider = contentVerifierProvider;
        this.digestProvider = digestCalculatorProvider;
    }

    public boolean hasAssociatedCertificate() {
        return this.verifierProvider.hasAssociatedCertificate();
    }

    public X509CertificateHolder getAssociatedCertificate() {
        return this.verifierProvider.getAssociatedCertificate();
    }

    public ContentVerifier getContentVerifier(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException {
        return this.verifierProvider.get(algorithmIdentifier);
    }

    public DigestCalculator getDigestCalculator(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException {
        return this.digestProvider.get(algorithmIdentifier);
    }
}
