package repack.org.bouncycastle.cms;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import repack.org.bouncycastle.asn1.cms.KeyTransRecipientInfo;
import repack.org.bouncycastle.asn1.cms.RecipientIdentifier;
import repack.org.bouncycastle.asn1.cms.RecipientInfo;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.asn1.x509.TBSCertificateStructure;

class KeyTransIntRecipientInfoGenerator implements IntRecipientInfoGenerator {
    private SubjectPublicKeyInfo info;
    private PublicKey recipientPublicKey;
    private TBSCertificateStructure recipientTBSCert;
    private ASN1OctetString subjectKeyIdentifier;

    KeyTransIntRecipientInfoGenerator() {
    }

    /* access modifiers changed from: package-private */
    public void setRecipientCert(X509Certificate x509Certificate) {
        this.recipientTBSCert = CMSUtils.getTBSCertificateStructure(x509Certificate);
        this.recipientPublicKey = x509Certificate.getPublicKey();
        this.info = this.recipientTBSCert.getSubjectPublicKeyInfo();
    }

    /* access modifiers changed from: package-private */
    public void setRecipientPublicKey(PublicKey publicKey) {
        this.recipientPublicKey = publicKey;
        try {
            this.info = SubjectPublicKeyInfo.getInstance(ASN1Object.fromByteArray(publicKey.getEncoded()));
        } catch (IOException unused) {
            throw new IllegalArgumentException("can't extract key algorithm from this key");
        }
    }

    /* access modifiers changed from: package-private */
    public void setSubjectKeyIdentifier(ASN1OctetString aSN1OctetString) {
        this.subjectKeyIdentifier = aSN1OctetString;
    }

    public RecipientInfo generate(SecretKey secretKey, SecureRandom secureRandom, Provider provider) throws GeneralSecurityException {
        byte[] bArr;
        RecipientIdentifier recipientIdentifier;
        AlgorithmIdentifier algorithmId = this.info.getAlgorithmId();
        Cipher createAsymmetricCipher = CMSEnvelopedHelper.INSTANCE.createAsymmetricCipher(algorithmId.getObjectId().getId(), provider);
        try {
            createAsymmetricCipher.init(3, this.recipientPublicKey, secureRandom);
            bArr = createAsymmetricCipher.wrap(secretKey);
        } catch (IllegalStateException | UnsupportedOperationException | GeneralSecurityException | ProviderException unused) {
            bArr = null;
        }
        if (bArr == null) {
            createAsymmetricCipher.init(1, this.recipientPublicKey, secureRandom);
            bArr = createAsymmetricCipher.doFinal(secretKey.getEncoded());
        }
        TBSCertificateStructure tBSCertificateStructure = this.recipientTBSCert;
        if (tBSCertificateStructure != null) {
            recipientIdentifier = new RecipientIdentifier(new IssuerAndSerialNumber(tBSCertificateStructure.getIssuer(), this.recipientTBSCert.getSerialNumber().getValue()));
        } else {
            recipientIdentifier = new RecipientIdentifier(this.subjectKeyIdentifier);
        }
        return new RecipientInfo(new KeyTransRecipientInfo(recipientIdentifier, algorithmId, new DEROctetString(bArr)));
    }
}
