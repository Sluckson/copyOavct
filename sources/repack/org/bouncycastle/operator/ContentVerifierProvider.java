package repack.org.bouncycastle.operator;

import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.cert.X509CertificateHolder;

public interface ContentVerifierProvider {
    ContentVerifier get(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException;

    X509CertificateHolder getAssociatedCertificate();

    boolean hasAssociatedCertificate();
}
