package repack.org.bouncycastle.cms.jcajce;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import repack.org.bouncycastle.cms.CMSAttributeTableGenerator;
import repack.org.bouncycastle.cms.SignerInfoGenerator;
import repack.org.bouncycastle.cms.SignerInfoGeneratorBuilder;
import repack.org.bouncycastle.operator.ContentSigner;
import repack.org.bouncycastle.operator.DigestCalculatorProvider;
import repack.org.bouncycastle.operator.OperatorCreationException;

public class JcaSignerInfoGeneratorBuilder extends SignerInfoGeneratorBuilder {
    public JcaSignerInfoGeneratorBuilder(DigestCalculatorProvider digestCalculatorProvider) {
        super(digestCalculatorProvider);
    }

    public SignerInfoGeneratorBuilder setDirectSignature(boolean z) {
        super.setDirectSignature(z);
        return this;
    }

    public SignerInfoGeneratorBuilder setSignedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        super.setSignedAttributeGenerator(cMSAttributeTableGenerator);
        return this;
    }

    public SignerInfoGeneratorBuilder setUnsignedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        super.setUnsignedAttributeGenerator(cMSAttributeTableGenerator);
        return this;
    }

    public SignerInfoGenerator build(ContentSigner contentSigner, X509Certificate x509Certificate) throws OperatorCreationException, CertificateEncodingException {
        return super.build(contentSigner, (X509CertificateHolder) new JcaX509CertificateHolder(x509Certificate));
    }
}
