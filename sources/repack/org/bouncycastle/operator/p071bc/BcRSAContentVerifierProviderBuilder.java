package repack.org.bouncycastle.operator.p071bc;

import java.io.IOException;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.crypto.Signer;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.signers.RSADigestSigner;
import repack.org.bouncycastle.crypto.util.PublicKeyFactory;
import repack.org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import repack.org.bouncycastle.operator.OperatorCreationException;

/* renamed from: repack.org.bouncycastle.operator.bc.BcRSAContentVerifierProviderBuilder */
public class BcRSAContentVerifierProviderBuilder extends BcContentVerifierProviderBuilder {
    private DigestAlgorithmIdentifierFinder digestAlgorithmFinder;

    public BcRSAContentVerifierProviderBuilder(DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder) {
        this.digestAlgorithmFinder = digestAlgorithmIdentifierFinder;
    }

    /* access modifiers changed from: protected */
    public Signer createSigner(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException {
        return new RSADigestSigner(BcUtil.createDigest(this.digestAlgorithmFinder.find(algorithmIdentifier)));
    }

    /* access modifiers changed from: protected */
    public AsymmetricKeyParameter extractKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        return PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }
}
