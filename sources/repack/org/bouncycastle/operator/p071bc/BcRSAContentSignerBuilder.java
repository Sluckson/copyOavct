package repack.org.bouncycastle.operator.p071bc;

import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.crypto.Signer;
import repack.org.bouncycastle.crypto.signers.RSADigestSigner;
import repack.org.bouncycastle.operator.OperatorCreationException;

/* renamed from: repack.org.bouncycastle.operator.bc.BcRSAContentSignerBuilder */
public class BcRSAContentSignerBuilder extends BcContentSignerBuilder {
    public BcRSAContentSignerBuilder(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        super(algorithmIdentifier, algorithmIdentifier2);
    }

    /* access modifiers changed from: protected */
    public Signer createSigner(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) throws OperatorCreationException {
        return new RSADigestSigner(BcUtil.createDigest(algorithmIdentifier2));
    }
}
