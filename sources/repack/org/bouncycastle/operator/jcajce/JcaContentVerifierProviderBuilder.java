package repack.org.bouncycastle.operator.jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import repack.org.bouncycastle.jcajce.DefaultJcaJceHelper;
import repack.org.bouncycastle.jcajce.NamedJcaJceHelper;
import repack.org.bouncycastle.jcajce.ProviderJcaJceHelper;
import repack.org.bouncycastle.operator.ContentVerifier;
import repack.org.bouncycastle.operator.ContentVerifierProvider;
import repack.org.bouncycastle.operator.OperatorCreationException;
import repack.org.bouncycastle.operator.OperatorStreamException;
import repack.org.bouncycastle.operator.RawContentVerifier;
import repack.org.bouncycastle.operator.RuntimeOperatorException;

public class JcaContentVerifierProviderBuilder {
    /* access modifiers changed from: private */
    public OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());

    public JcaContentVerifierProviderBuilder setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    public JcaContentVerifierProviderBuilder setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public ContentVerifierProvider build(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException, CertificateException {
        return build(this.helper.convertCertificate(x509CertificateHolder));
    }

    public ContentVerifierProvider build(final X509Certificate x509Certificate) throws OperatorCreationException {
        try {
            final JcaX509CertificateHolder jcaX509CertificateHolder = new JcaX509CertificateHolder(x509Certificate);
            return new ContentVerifierProvider() {
                private SignatureOutputStream stream;

                public boolean hasAssociatedCertificate() {
                    return true;
                }

                public X509CertificateHolder getAssociatedCertificate() {
                    return jcaX509CertificateHolder;
                }

                public ContentVerifier get(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException {
                    try {
                        Signature createSignature = JcaContentVerifierProviderBuilder.this.helper.createSignature(algorithmIdentifier);
                        createSignature.initVerify(x509Certificate.getPublicKey());
                        this.stream = new SignatureOutputStream(createSignature);
                        Signature access$1 = JcaContentVerifierProviderBuilder.this.createRawSig(algorithmIdentifier, x509Certificate.getPublicKey());
                        if (access$1 != null) {
                            return new RawSigVerifier(algorithmIdentifier, this.stream, access$1);
                        }
                        return new SigVerifier(algorithmIdentifier, this.stream);
                    } catch (GeneralSecurityException e) {
                        throw new OperatorCreationException("exception on setup: " + e, e);
                    }
                }
            };
        } catch (CertificateEncodingException e) {
            throw new OperatorCreationException("cannot process certificate: " + e.getMessage(), e);
        }
    }

    public ContentVerifierProvider build(final PublicKey publicKey) throws OperatorCreationException {
        return new ContentVerifierProvider() {
            public X509CertificateHolder getAssociatedCertificate() {
                return null;
            }

            public boolean hasAssociatedCertificate() {
                return false;
            }

            public ContentVerifier get(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException {
                SignatureOutputStream access$2 = JcaContentVerifierProviderBuilder.this.createSignatureStream(algorithmIdentifier, publicKey);
                Signature access$1 = JcaContentVerifierProviderBuilder.this.createRawSig(algorithmIdentifier, publicKey);
                if (access$1 != null) {
                    return new RawSigVerifier(algorithmIdentifier, access$2, access$1);
                }
                return new SigVerifier(algorithmIdentifier, access$2);
            }
        };
    }

    /* access modifiers changed from: private */
    public SignatureOutputStream createSignatureStream(AlgorithmIdentifier algorithmIdentifier, PublicKey publicKey) throws OperatorCreationException {
        try {
            Signature createSignature = this.helper.createSignature(algorithmIdentifier);
            createSignature.initVerify(publicKey);
            return new SignatureOutputStream(createSignature);
        } catch (GeneralSecurityException e) {
            throw new OperatorCreationException("exception on setup: " + e, e);
        }
    }

    /* access modifiers changed from: private */
    public Signature createRawSig(AlgorithmIdentifier algorithmIdentifier, PublicKey publicKey) {
        try {
            Signature createRawSignature = this.helper.createRawSignature(algorithmIdentifier);
            createRawSignature.initVerify(publicKey);
            return createRawSignature;
        } catch (Exception unused) {
            return null;
        }
    }

    private class SigVerifier implements ContentVerifier {
        private AlgorithmIdentifier algorithm;
        private SignatureOutputStream stream;

        SigVerifier(AlgorithmIdentifier algorithmIdentifier, SignatureOutputStream signatureOutputStream) {
            this.algorithm = algorithmIdentifier;
            this.stream = signatureOutputStream;
        }

        public AlgorithmIdentifier getAlgorithmIdentifier() {
            return this.algorithm;
        }

        public OutputStream getOutputStream() {
            SignatureOutputStream signatureOutputStream = this.stream;
            if (signatureOutputStream != null) {
                return signatureOutputStream;
            }
            throw new IllegalStateException("verifier not initialised");
        }

        public boolean verify(byte[] bArr) {
            try {
                return this.stream.verify(bArr);
            } catch (SignatureException e) {
                throw new RuntimeOperatorException("exception obtaining signature: " + e.getMessage(), e);
            }
        }
    }

    private class RawSigVerifier extends SigVerifier implements RawContentVerifier {
        private Signature rawSignature;

        RawSigVerifier(AlgorithmIdentifier algorithmIdentifier, SignatureOutputStream signatureOutputStream, Signature signature) {
            super(algorithmIdentifier, signatureOutputStream);
            this.rawSignature = signature;
        }

        public boolean verify(byte[] bArr, byte[] bArr2) {
            try {
                this.rawSignature.update(bArr);
                return this.rawSignature.verify(bArr2);
            } catch (SignatureException e) {
                throw new RuntimeOperatorException("exception obtaining raw signature: " + e.getMessage(), e);
            }
        }
    }

    private class SignatureOutputStream extends OutputStream {
        private Signature sig;

        SignatureOutputStream(Signature signature) {
            this.sig = signature;
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.sig.update(bArr, i, i2);
            } catch (SignatureException e) {
                throw new OperatorStreamException("exception in content signer: " + e.getMessage(), e);
            }
        }

        public void write(byte[] bArr) throws IOException {
            try {
                this.sig.update(bArr);
            } catch (SignatureException e) {
                throw new OperatorStreamException("exception in content signer: " + e.getMessage(), e);
            }
        }

        public void write(int i) throws IOException {
            try {
                this.sig.update((byte) i);
            } catch (SignatureException e) {
                throw new OperatorStreamException("exception in content signer: " + e.getMessage(), e);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean verify(byte[] bArr) throws SignatureException {
            return this.sig.verify(bArr);
        }
    }
}
