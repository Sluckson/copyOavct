package repack.org.bouncycastle.cert.cmp;

import java.math.BigInteger;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.cmp.RevDetails;
import repack.org.bouncycastle.asn1.crmf.CertTemplateBuilder;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class RevocationDetailsBuilder {
    private CertTemplateBuilder templateBuilder = new CertTemplateBuilder();

    public RevocationDetailsBuilder setPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        if (subjectPublicKeyInfo != null) {
            this.templateBuilder.setPublicKey(subjectPublicKeyInfo);
        }
        return this;
    }

    public RevocationDetailsBuilder setIssuer(X500Name x500Name) {
        if (x500Name != null) {
            this.templateBuilder.setIssuer(x500Name);
        }
        return this;
    }

    public RevocationDetailsBuilder setSerialNumber(BigInteger bigInteger) {
        if (bigInteger != null) {
            this.templateBuilder.setSerialNumber(new DERInteger(bigInteger));
        }
        return this;
    }

    public RevocationDetailsBuilder setSubject(X500Name x500Name) {
        if (x500Name != null) {
            this.templateBuilder.setSubject(x500Name);
        }
        return this;
    }

    public RevocationDetails build() {
        return new RevocationDetails(new RevDetails(this.templateBuilder.build()));
    }
}
