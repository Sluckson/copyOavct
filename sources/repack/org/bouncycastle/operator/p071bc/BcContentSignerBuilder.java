package repack.org.bouncycastle.operator.p071bc;

import java.io.OutputStream;
import java.security.SecureRandom;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.crypto.CryptoException;
import repack.org.bouncycastle.crypto.Signer;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;
import repack.org.bouncycastle.operator.ContentSigner;
import repack.org.bouncycastle.operator.OperatorCreationException;
import repack.org.bouncycastle.operator.RuntimeOperatorException;

/* renamed from: repack.org.bouncycastle.operator.bc.BcContentSignerBuilder */
public abstract class BcContentSignerBuilder {
    private AlgorithmIdentifier digAlgId;
    private SecureRandom random;
    /* access modifiers changed from: private */
    public AlgorithmIdentifier sigAlgId;

    /* access modifiers changed from: protected */
    public abstract Signer createSigner(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) throws OperatorCreationException;

    public BcContentSignerBuilder(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        this.sigAlgId = algorithmIdentifier;
        this.digAlgId = algorithmIdentifier2;
    }

    public BcContentSignerBuilder setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }

    public ContentSigner build(AsymmetricKeyParameter asymmetricKeyParameter) throws OperatorCreationException {
        Signer createSigner = createSigner(this.sigAlgId, this.digAlgId);
        SecureRandom secureRandom = this.random;
        if (secureRandom != null) {
            createSigner.init(true, new ParametersWithRandom(asymmetricKeyParameter, secureRandom));
        } else {
            createSigner.init(true, asymmetricKeyParameter);
        }
        return new ContentSigner(createSigner) {
            private BcSignerOutputStream stream;

            {
                this.stream = new BcSignerOutputStream(r2);
            }

            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return BcContentSignerBuilder.this.sigAlgId;
            }

            public OutputStream getOutputStream() {
                return this.stream;
            }

            public byte[] getSignature() {
                try {
                    return this.stream.getSignature();
                } catch (CryptoException e) {
                    throw new RuntimeOperatorException("exception obtaining signature: " + e.getMessage(), e);
                }
            }
        };
    }
}
