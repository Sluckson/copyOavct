package repack.org.bouncycastle.cms;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import repack.org.bouncycastle.asn1.cms.KeyAgreeRecipientIdentifier;
import repack.org.bouncycastle.asn1.cms.KeyAgreeRecipientInfo;
import repack.org.bouncycastle.asn1.cms.OriginatorIdentifierOrKey;
import repack.org.bouncycastle.asn1.cms.OriginatorPublicKey;
import repack.org.bouncycastle.asn1.cms.RecipientEncryptedKey;
import repack.org.bouncycastle.asn1.cms.ecc.MQVuserKeyingMaterial;
import repack.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.jce.spec.MQVPrivateKeySpec;
import repack.org.bouncycastle.jce.spec.MQVPublicKeySpec;

public class KeyAgreeRecipientInformation extends RecipientInformation {
    private ASN1OctetString encryptedKey;
    private KeyAgreeRecipientInfo info;

    static void readRecipientInfo(List list, KeyAgreeRecipientInfo keyAgreeRecipientInfo, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable, AuthAttributesProvider authAttributesProvider) {
        KeyAgreeRecipientId keyAgreeRecipientId;
        ASN1Sequence recipientEncryptedKeys = keyAgreeRecipientInfo.getRecipientEncryptedKeys();
        for (int i = 0; i < recipientEncryptedKeys.size(); i++) {
            RecipientEncryptedKey instance = RecipientEncryptedKey.getInstance(recipientEncryptedKeys.getObjectAt(i));
            KeyAgreeRecipientIdentifier identifier = instance.getIdentifier();
            IssuerAndSerialNumber issuerAndSerialNumber = identifier.getIssuerAndSerialNumber();
            if (issuerAndSerialNumber != null) {
                keyAgreeRecipientId = new KeyAgreeRecipientId(issuerAndSerialNumber.getName(), issuerAndSerialNumber.getSerialNumber().getValue());
            } else {
                keyAgreeRecipientId = new KeyAgreeRecipientId(identifier.getRKeyID().getSubjectKeyIdentifier().getOctets());
            }
            List list2 = list;
            list.add(new KeyAgreeRecipientInformation(keyAgreeRecipientInfo, keyAgreeRecipientId, instance.getEncryptedKey(), algorithmIdentifier, cMSSecureReadable, authAttributesProvider));
        }
    }

    KeyAgreeRecipientInformation(KeyAgreeRecipientInfo keyAgreeRecipientInfo, RecipientId recipientId, ASN1OctetString aSN1OctetString, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable, AuthAttributesProvider authAttributesProvider) {
        super(keyAgreeRecipientInfo.getKeyEncryptionAlgorithm(), algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
        this.info = keyAgreeRecipientInfo;
        this.rid = recipientId;
        this.encryptedKey = aSN1OctetString;
    }

    private SubjectPublicKeyInfo getSenderPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, OriginatorIdentifierOrKey originatorIdentifierOrKey) throws CMSException, IOException {
        OriginatorPublicKey originatorKey = originatorIdentifierOrKey.getOriginatorKey();
        if (originatorKey != null) {
            return getPublicKeyInfoFromOriginatorPublicKey(algorithmIdentifier, originatorKey);
        }
        OriginatorId originatorId = new OriginatorId();
        IssuerAndSerialNumber issuerAndSerialNumber = originatorIdentifierOrKey.getIssuerAndSerialNumber();
        if (issuerAndSerialNumber != null) {
            originatorId.setIssuer(issuerAndSerialNumber.getName().getEncoded());
            originatorId.setSerialNumber(issuerAndSerialNumber.getSerialNumber().getValue());
        } else {
            originatorId.setSubjectKeyIdentifier(originatorIdentifierOrKey.getSubjectKeyIdentifier().getKeyIdentifier());
        }
        return getPublicKeyInfoFromOriginatorId(originatorId);
    }

    private SubjectPublicKeyInfo getPublicKeyInfoFromOriginatorPublicKey(AlgorithmIdentifier algorithmIdentifier, OriginatorPublicKey originatorPublicKey) {
        return new SubjectPublicKeyInfo(algorithmIdentifier, originatorPublicKey.getPublicKey().getBytes());
    }

    private SubjectPublicKeyInfo getPublicKeyInfoFromOriginatorId(OriginatorId originatorId) throws CMSException {
        throw new CMSException("No support for 'originator' as IssuerAndSerialNumber or SubjectKeyIdentifier");
    }

    private PublicKey getSenderPublicKey(Key key, OriginatorIdentifierOrKey originatorIdentifierOrKey, Provider provider) throws CMSException, GeneralSecurityException, IOException {
        return KeyFactory.getInstance(this.keyEncAlg.getAlgorithm().getId(), provider).generatePublic(new X509EncodedKeySpec(getSenderPublicKeyInfo(PrivateKeyInfo.getInstance(key.getEncoded()).getAlgorithmId(), originatorIdentifierOrKey).getEncoded()));
    }

    private PublicKey getPublicKeyFromOriginatorPublicKey(Key key, OriginatorPublicKey originatorPublicKey, Provider provider) throws CMSException, GeneralSecurityException, IOException {
        return KeyFactory.getInstance(this.keyEncAlg.getAlgorithm().getId(), provider).generatePublic(new X509EncodedKeySpec(getPublicKeyInfoFromOriginatorPublicKey(PrivateKeyInfo.getInstance(key.getEncoded()).getAlgorithmId(), originatorPublicKey).getEncoded()));
    }

    private SecretKey calculateAgreedWrapKey(String str, PublicKey publicKey, PrivateKey privateKey, Provider provider) throws CMSException, GeneralSecurityException, IOException {
        PrivateKey privateKey2;
        PublicKey publicKey2;
        String id = this.keyEncAlg.getAlgorithm().getId();
        if (id.equals(CMSEnvelopedGenerator.ECMQV_SHA1KDF)) {
            publicKey2 = new MQVPublicKeySpec(publicKey, getPublicKeyFromOriginatorPublicKey(privateKey, MQVuserKeyingMaterial.getInstance(ASN1Object.fromByteArray(this.info.getUserKeyingMaterial().getOctets())).getEphemeralPublicKey(), provider));
            privateKey2 = new MQVPrivateKeySpec(privateKey, privateKey);
        } else {
            publicKey2 = publicKey;
            privateKey2 = privateKey;
        }
        KeyAgreement instance = KeyAgreement.getInstance(id, provider);
        instance.init(privateKey2);
        instance.doPhase(publicKey2, true);
        return instance.generateSecret(str);
    }

    private Key unwrapSessionKey(String str, SecretKey secretKey, Provider provider) throws GeneralSecurityException {
        Cipher createSymmetricCipher = CMSEnvelopedHelper.INSTANCE.createSymmetricCipher(str, provider);
        createSymmetricCipher.init(4, secretKey);
        return createSymmetricCipher.unwrap(this.encryptedKey.getOctets(), getContentAlgorithmName(), 3);
    }

    /* access modifiers changed from: protected */
    public Key getSessionKey(Key key, Provider provider) throws CMSException {
        try {
            String id = AlgorithmIdentifier.getInstance(this.keyEncAlg.getParameters()).getAlgorithm().getId();
            return unwrapSessionKey(id, calculateAgreedWrapKey(id, getSenderPublicKey(key, this.info.getOriginator(), provider), (PrivateKey) key, provider), provider);
        } catch (NoSuchAlgorithmException e) {
            throw new CMSException("can't find algorithm.", e);
        } catch (InvalidKeyException e2) {
            throw new CMSException("key invalid in message.", e2);
        } catch (InvalidKeySpecException e3) {
            throw new CMSException("originator key spec invalid.", e3);
        } catch (NoSuchPaddingException e4) {
            throw new CMSException("required padding not supported.", e4);
        } catch (Exception e5) {
            throw new CMSException("originator key invalid.", e5);
        }
    }

    public CMSTypedStream getContentStream(Key key, String str) throws CMSException, NoSuchProviderException {
        return getContentStream(key, CMSUtils.getProvider(str));
    }

    public CMSTypedStream getContentStream(Key key, Provider provider) throws CMSException {
        return getContentFromSessionKey(getSessionKey(key, provider), provider);
    }

    /* access modifiers changed from: protected */
    public RecipientOperator getRecipientOperator(Recipient recipient) throws CMSException, IOException {
        KeyAgreeRecipient keyAgreeRecipient = (KeyAgreeRecipient) recipient;
        return keyAgreeRecipient.getRecipientOperator(this.keyEncAlg, this.messageAlgorithm, getSenderPublicKeyInfo(keyAgreeRecipient.getPrivateKeyAlgorithmIdentifier(), this.info.getOriginator()), this.info.getUserKeyingMaterial(), this.encryptedKey.getOctets());
    }
}
