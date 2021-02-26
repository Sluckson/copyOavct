package repack.org.bouncycastle.cms.jcajce;

import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.SecretKey;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.cms.KEKIdentifier;
import repack.org.bouncycastle.asn1.cms.OtherKeyAttribute;
import repack.org.bouncycastle.cms.KEKRecipientInfoGenerator;
import repack.org.bouncycastle.operator.jcajce.JceSymmetricKeyWrapper;

public class JceKEKRecipientInfoGenerator extends KEKRecipientInfoGenerator {
    public JceKEKRecipientInfoGenerator(KEKIdentifier kEKIdentifier, SecretKey secretKey) {
        super(kEKIdentifier, new JceSymmetricKeyWrapper(secretKey));
    }

    public JceKEKRecipientInfoGenerator(byte[] bArr, SecretKey secretKey) {
        this(new KEKIdentifier(bArr, (DERGeneralizedTime) null, (OtherKeyAttribute) null), secretKey);
    }

    public JceKEKRecipientInfoGenerator setProvider(Provider provider) {
        ((JceSymmetricKeyWrapper) this.wrapper).setProvider(provider);
        return this;
    }

    public JceKEKRecipientInfoGenerator setProvider(String str) {
        ((JceSymmetricKeyWrapper) this.wrapper).setProvider(str);
        return this;
    }

    public JceKEKRecipientInfoGenerator setSecureRandom(SecureRandom secureRandom) {
        ((JceSymmetricKeyWrapper) this.wrapper).setSecureRandom(secureRandom);
        return this;
    }
}
