package repack.org.bouncycastle.cms;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.cms.PasswordRecipientInfo;
import repack.org.bouncycastle.asn1.cms.RecipientInfo;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

class PasswordIntRecipientInfoGenerator implements IntRecipientInfoGenerator {
    private AlgorithmIdentifier keyDerivationAlgorithm;
    private SecretKey keyEncryptionKey;

    PasswordIntRecipientInfoGenerator() {
    }

    /* access modifiers changed from: package-private */
    public void setKeyDerivationAlgorithm(AlgorithmIdentifier algorithmIdentifier) {
        this.keyDerivationAlgorithm = algorithmIdentifier;
    }

    /* access modifiers changed from: package-private */
    public void setKeyEncryptionKey(SecretKey secretKey) {
        this.keyEncryptionKey = secretKey;
    }

    public RecipientInfo generate(SecretKey secretKey, SecureRandom secureRandom, Provider provider) throws GeneralSecurityException {
        CMSEnvelopedHelper cMSEnvelopedHelper = CMSEnvelopedHelper.INSTANCE;
        Cipher createSymmetricCipher = cMSEnvelopedHelper.createSymmetricCipher(cMSEnvelopedHelper.getRFC3211WrapperName(this.keyEncryptionKey.getAlgorithm()), provider);
        createSymmetricCipher.init(3, this.keyEncryptionKey, secureRandom);
        DEROctetString dEROctetString = new DEROctetString(createSymmetricCipher.wrap(secretKey));
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new DERObjectIdentifier(this.keyEncryptionKey.getAlgorithm()));
        aSN1EncodableVector.add(new DEROctetString(createSymmetricCipher.getIV()));
        return new RecipientInfo(new PasswordRecipientInfo(this.keyDerivationAlgorithm, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_PWRI_KEK, new DERSequence(aSN1EncodableVector)), dEROctetString));
    }
}
