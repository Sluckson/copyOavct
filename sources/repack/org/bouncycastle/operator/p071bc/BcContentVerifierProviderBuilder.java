package repack.org.bouncycastle.operator.p071bc;

import java.io.IOException;
import java.io.OutputStream;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.crypto.Signer;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.operator.ContentVerifier;
import repack.org.bouncycastle.operator.ContentVerifierProvider;
import repack.org.bouncycastle.operator.OperatorCreationException;

/* renamed from: repack.org.bouncycastle.operator.bc.BcContentVerifierProviderBuilder */
public abstract class BcContentVerifierProviderBuilder {
    /* access modifiers changed from: protected */
    public abstract Signer createSigner(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException;

    /* access modifiers changed from: protected */
    public abstract AsymmetricKeyParameter extractKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException;

    public ContentVerifierProvider build(final X509CertificateHolder x509CertificateHolder) throws OperatorCreationException {
        return new ContentVerifierProvider() {
            public boolean hasAssociatedCertificate() {
                return true;
            }

            public X509CertificateHolder getAssociatedCertificate() {
                return x509CertificateHolder;
            }

            public ContentVerifier get(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException {
                try {
                    return new SigVerifier(algorithmIdentifier, BcContentVerifierProviderBuilder.this.createSignatureStream(algorithmIdentifier, BcContentVerifierProviderBuilder.this.extractKeyParameters(x509CertificateHolder.getSubjectPublicKeyInfo())));
                } catch (IOException e) {
                    throw new OperatorCreationException("exception on setup: " + e, e);
                }
            }
        };
    }

    public ContentVerifierProvider build(final AsymmetricKeyParameter asymmetricKeyParameter) throws OperatorCreationException {
        return new ContentVerifierProvider() {
            public X509CertificateHolder getAssociatedCertificate() {
                return null;
            }

            public boolean hasAssociatedCertificate() {
                return false;
            }

            public ContentVerifier get(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException {
                return new SigVerifier(algorithmIdentifier, BcContentVerifierProviderBuilder.this.createSignatureStream(algorithmIdentifier, asymmetricKeyParameter));
            }
        };
    }

    /* access modifiers changed from: private */
    public BcSignerOutputStream createSignatureStream(AlgorithmIdentifier algorithmIdentifier, AsymmetricKeyParameter asymmetricKeyParameter) throws OperatorCreationException {
        Signer createSigner = createSigner(algorithmIdentifier);
        createSigner.init(false, asymmetricKeyParameter);
        return new BcSignerOutputStream(createSigner);
    }

    /* renamed from: repack.org.bouncycastle.operator.bc.BcContentVerifierProviderBuilder$SigVerifier */
    private class SigVerifier implements ContentVerifier {
        private AlgorithmIdentifier algorithm;
        private BcSignerOutputStream stream;

        SigVerifier(AlgorithmIdentifier algorithmIdentifier, BcSignerOutputStream bcSignerOutputStream) {
            this.algorithm = algorithmIdentifier;
            this.stream = bcSignerOutputStream;
        }

        public AlgorithmIdentifier getAlgorithmIdentifier() {
            return this.algorithm;
        }

        public OutputStream getOutputStream() {
            BcSignerOutputStream bcSignerOutputStream = this.stream;
            if (bcSignerOutputStream != null) {
                return bcSignerOutputStream;
            }
            throw new IllegalStateException("verifier not initialised");
        }

        public boolean verify(byte[] bArr) {
            return this.stream.verify(bArr);
        }
    }
}
