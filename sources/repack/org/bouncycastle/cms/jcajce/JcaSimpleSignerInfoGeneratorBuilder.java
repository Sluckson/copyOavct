package repack.org.bouncycastle.cms.jcajce;

import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import repack.org.bouncycastle.asn1.cms.AttributeTable;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import repack.org.bouncycastle.cms.CMSAttributeTableGenerator;
import repack.org.bouncycastle.cms.DefaultSignedAttributeTableGenerator;
import repack.org.bouncycastle.cms.SignerInfoGenerator;
import repack.org.bouncycastle.cms.SignerInfoGeneratorBuilder;
import repack.org.bouncycastle.operator.ContentSigner;
import repack.org.bouncycastle.operator.DigestCalculatorProvider;
import repack.org.bouncycastle.operator.OperatorCreationException;
import repack.org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import repack.org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;

public class JcaSimpleSignerInfoGeneratorBuilder {
    private boolean hasNoSignedAttributes;
    private Helper helper = new Helper(this, (Helper) null, (Helper) null);
    private CMSAttributeTableGenerator signedGen;
    private CMSAttributeTableGenerator unsignedGen;

    public JcaSimpleSignerInfoGeneratorBuilder setProvider(String str) throws OperatorCreationException {
        this.helper = new NamedHelper(str);
        return this;
    }

    public JcaSimpleSignerInfoGeneratorBuilder setProvider(Provider provider) throws OperatorCreationException {
        this.helper = new ProviderHelper(provider);
        return this;
    }

    public JcaSimpleSignerInfoGeneratorBuilder setDirectSignature(boolean z) {
        this.hasNoSignedAttributes = z;
        return this;
    }

    public JcaSimpleSignerInfoGeneratorBuilder setSignedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        this.signedGen = cMSAttributeTableGenerator;
        return this;
    }

    public JcaSimpleSignerInfoGeneratorBuilder setSignedAttributeGenerator(AttributeTable attributeTable) {
        this.signedGen = new DefaultSignedAttributeTableGenerator(attributeTable);
        return this;
    }

    public JcaSimpleSignerInfoGeneratorBuilder setUnsignedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        this.unsignedGen = cMSAttributeTableGenerator;
        return this;
    }

    public SignerInfoGenerator build(String str, PrivateKey privateKey, X509Certificate x509Certificate) throws OperatorCreationException, CertificateEncodingException {
        return configureAndBuild().build(this.helper.createContentSigner(str, privateKey), (X509CertificateHolder) new JcaX509CertificateHolder(x509Certificate));
    }

    public SignerInfoGenerator build(String str, PrivateKey privateKey, byte[] bArr) throws OperatorCreationException, CertificateEncodingException {
        return configureAndBuild().build(this.helper.createContentSigner(str, privateKey), bArr);
    }

    private SignerInfoGeneratorBuilder configureAndBuild() throws OperatorCreationException {
        SignerInfoGeneratorBuilder signerInfoGeneratorBuilder = new SignerInfoGeneratorBuilder(this.helper.createDigestCalculatorProvider());
        signerInfoGeneratorBuilder.setDirectSignature(this.hasNoSignedAttributes);
        signerInfoGeneratorBuilder.setSignedAttributeGenerator(this.signedGen);
        signerInfoGeneratorBuilder.setUnsignedAttributeGenerator(this.unsignedGen);
        return signerInfoGeneratorBuilder;
    }

    private class Helper {
        private Helper() {
        }

        /* synthetic */ Helper(JcaSimpleSignerInfoGeneratorBuilder jcaSimpleSignerInfoGeneratorBuilder, Helper helper) {
            this();
        }

        /* synthetic */ Helper(JcaSimpleSignerInfoGeneratorBuilder jcaSimpleSignerInfoGeneratorBuilder, Helper helper, Helper helper2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public ContentSigner createContentSigner(String str, PrivateKey privateKey) throws OperatorCreationException {
            return new JcaContentSignerBuilder(str).build(privateKey);
        }

        /* access modifiers changed from: package-private */
        public DigestCalculatorProvider createDigestCalculatorProvider() throws OperatorCreationException {
            return new JcaDigestCalculatorProviderBuilder().build();
        }
    }

    private class NamedHelper extends Helper {
        private final String providerName;

        public NamedHelper(String str) {
            super(JcaSimpleSignerInfoGeneratorBuilder.this, (Helper) null);
            this.providerName = str;
        }

        /* access modifiers changed from: package-private */
        public ContentSigner createContentSigner(String str, PrivateKey privateKey) throws OperatorCreationException {
            return new JcaContentSignerBuilder(str).setProvider(this.providerName).build(privateKey);
        }

        /* access modifiers changed from: package-private */
        public DigestCalculatorProvider createDigestCalculatorProvider() throws OperatorCreationException {
            return new JcaDigestCalculatorProviderBuilder().setProvider(this.providerName).build();
        }
    }

    private class ProviderHelper extends Helper {
        private final Provider provider;

        public ProviderHelper(Provider provider2) {
            super(JcaSimpleSignerInfoGeneratorBuilder.this, (Helper) null);
            this.provider = provider2;
        }

        /* access modifiers changed from: package-private */
        public ContentSigner createContentSigner(String str, PrivateKey privateKey) throws OperatorCreationException {
            return new JcaContentSignerBuilder(str).setProvider(this.provider).build(privateKey);
        }

        /* access modifiers changed from: package-private */
        public DigestCalculatorProvider createDigestCalculatorProvider() throws OperatorCreationException {
            return new JcaDigestCalculatorProviderBuilder().setProvider(this.provider).build();
        }
    }
}
