package repack.org.bouncycastle.cms.jcajce;

import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.cms.SignerInformationVerifier;
import repack.org.bouncycastle.operator.ContentVerifierProvider;
import repack.org.bouncycastle.operator.DigestCalculatorProvider;
import repack.org.bouncycastle.operator.OperatorCreationException;
import repack.org.bouncycastle.operator.jcajce.JcaContentVerifierProviderBuilder;
import repack.org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;

public class JcaSimpleSignerInfoVerifierBuilder {
    private Helper helper = new Helper(this, (Helper) null);

    public JcaSimpleSignerInfoVerifierBuilder setProvider(Provider provider) {
        this.helper = new ProviderHelper(provider);
        return this;
    }

    public JcaSimpleSignerInfoVerifierBuilder setProvider(String str) {
        this.helper = new NamedHelper(str);
        return this;
    }

    public SignerInformationVerifier build(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException, CertificateException {
        return new SignerInformationVerifier(this.helper.createContentVerifierProvider(x509CertificateHolder), this.helper.createDigestCalculatorProvider());
    }

    public SignerInformationVerifier build(X509Certificate x509Certificate) throws OperatorCreationException {
        return new SignerInformationVerifier(this.helper.createContentVerifierProvider(x509Certificate), this.helper.createDigestCalculatorProvider());
    }

    public SignerInformationVerifier build(PublicKey publicKey) throws OperatorCreationException {
        return new SignerInformationVerifier(this.helper.createContentVerifierProvider(publicKey), this.helper.createDigestCalculatorProvider());
    }

    private class Helper {
        private Helper() {
        }

        /* synthetic */ Helper(JcaSimpleSignerInfoVerifierBuilder jcaSimpleSignerInfoVerifierBuilder, Helper helper) {
            this();
        }

        /* synthetic */ Helper(JcaSimpleSignerInfoVerifierBuilder jcaSimpleSignerInfoVerifierBuilder, Helper helper, Helper helper2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public ContentVerifierProvider createContentVerifierProvider(PublicKey publicKey) throws OperatorCreationException {
            return new JcaContentVerifierProviderBuilder().build(publicKey);
        }

        /* access modifiers changed from: package-private */
        public ContentVerifierProvider createContentVerifierProvider(X509Certificate x509Certificate) throws OperatorCreationException {
            return new JcaContentVerifierProviderBuilder().build(x509Certificate);
        }

        /* access modifiers changed from: package-private */
        public ContentVerifierProvider createContentVerifierProvider(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException, CertificateException {
            return new JcaContentVerifierProviderBuilder().build(x509CertificateHolder);
        }

        /* access modifiers changed from: package-private */
        public DigestCalculatorProvider createDigestCalculatorProvider() throws OperatorCreationException {
            return new JcaDigestCalculatorProviderBuilder().build();
        }
    }

    private class NamedHelper extends Helper {
        private final String providerName;

        public NamedHelper(String str) {
            super(JcaSimpleSignerInfoVerifierBuilder.this, (Helper) null, (Helper) null);
            this.providerName = str;
        }

        /* access modifiers changed from: package-private */
        public ContentVerifierProvider createContentVerifierProvider(PublicKey publicKey) throws OperatorCreationException {
            return new JcaContentVerifierProviderBuilder().setProvider(this.providerName).build(publicKey);
        }

        /* access modifiers changed from: package-private */
        public ContentVerifierProvider createContentVerifierProvider(X509Certificate x509Certificate) throws OperatorCreationException {
            return new JcaContentVerifierProviderBuilder().setProvider(this.providerName).build(x509Certificate);
        }

        /* access modifiers changed from: package-private */
        public DigestCalculatorProvider createDigestCalculatorProvider() throws OperatorCreationException {
            return new JcaDigestCalculatorProviderBuilder().setProvider(this.providerName).build();
        }

        /* access modifiers changed from: package-private */
        public ContentVerifierProvider createContentVerifierProvider(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException, CertificateException {
            return new JcaContentVerifierProviderBuilder().setProvider(this.providerName).build(x509CertificateHolder);
        }
    }

    private class ProviderHelper extends Helper {
        private final Provider provider;

        public ProviderHelper(Provider provider2) {
            super(JcaSimpleSignerInfoVerifierBuilder.this, (Helper) null, (Helper) null);
            this.provider = provider2;
        }

        /* access modifiers changed from: package-private */
        public ContentVerifierProvider createContentVerifierProvider(PublicKey publicKey) throws OperatorCreationException {
            return new JcaContentVerifierProviderBuilder().setProvider(this.provider).build(publicKey);
        }

        /* access modifiers changed from: package-private */
        public ContentVerifierProvider createContentVerifierProvider(X509Certificate x509Certificate) throws OperatorCreationException {
            return new JcaContentVerifierProviderBuilder().setProvider(this.provider).build(x509Certificate);
        }

        /* access modifiers changed from: package-private */
        public DigestCalculatorProvider createDigestCalculatorProvider() throws OperatorCreationException {
            return new JcaDigestCalculatorProviderBuilder().setProvider(this.provider).build();
        }

        /* access modifiers changed from: package-private */
        public ContentVerifierProvider createContentVerifierProvider(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException, CertificateException {
            return new JcaContentVerifierProviderBuilder().setProvider(this.provider).build(x509CertificateHolder);
        }
    }
}
