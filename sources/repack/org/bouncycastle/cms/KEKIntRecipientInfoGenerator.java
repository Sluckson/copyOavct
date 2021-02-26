package repack.org.bouncycastle.cms;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.cms.KEKIdentifier;
import repack.org.bouncycastle.asn1.cms.KEKRecipientInfo;
import repack.org.bouncycastle.asn1.cms.RecipientInfo;
import repack.org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import repack.org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import repack.org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

class KEKIntRecipientInfoGenerator implements IntRecipientInfoGenerator {
    private KEKIdentifier kekIdentifier;
    private AlgorithmIdentifier keyEncryptionAlgorithm;
    private SecretKey keyEncryptionKey;

    KEKIntRecipientInfoGenerator() {
    }

    /* access modifiers changed from: package-private */
    public void setKeyEncryptionKey(SecretKey secretKey) {
        this.keyEncryptionKey = secretKey;
        this.keyEncryptionAlgorithm = determineKeyEncAlg(secretKey);
    }

    /* access modifiers changed from: package-private */
    public void setKEKIdentifier(KEKIdentifier kEKIdentifier) {
        this.kekIdentifier = kEKIdentifier;
    }

    public RecipientInfo generate(SecretKey secretKey, SecureRandom secureRandom, Provider provider) throws GeneralSecurityException {
        Cipher createSymmetricCipher = CMSEnvelopedHelper.INSTANCE.createSymmetricCipher(this.keyEncryptionAlgorithm.getObjectId().getId(), provider);
        createSymmetricCipher.init(3, this.keyEncryptionKey, secureRandom);
        return new RecipientInfo(new KEKRecipientInfo(this.kekIdentifier, this.keyEncryptionAlgorithm, new DEROctetString(createSymmetricCipher.wrap(secretKey))));
    }

    private static AlgorithmIdentifier determineKeyEncAlg(SecretKey secretKey) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2;
        String algorithm = secretKey.getAlgorithm();
        if (algorithm.startsWith("DES")) {
            return new AlgorithmIdentifier(new DERObjectIdentifier("1.2.840.113549.1.9.16.3.6"), new DERNull());
        }
        if (algorithm.startsWith("RC2")) {
            return new AlgorithmIdentifier(new DERObjectIdentifier("1.2.840.113549.1.9.16.3.7"), new DERInteger(58));
        }
        if (algorithm.startsWith("AES")) {
            int length = secretKey.getEncoded().length * 8;
            if (length == 128) {
                aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_aes128_wrap;
            } else if (length == 192) {
                aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_aes192_wrap;
            } else if (length == 256) {
                aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_aes256_wrap;
            } else {
                throw new IllegalArgumentException("illegal keysize in AES");
            }
            return new AlgorithmIdentifier((DERObjectIdentifier) aSN1ObjectIdentifier2);
        } else if (algorithm.startsWith("SEED")) {
            return new AlgorithmIdentifier((DERObjectIdentifier) KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap);
        } else {
            if (algorithm.startsWith("Camellia")) {
                int length2 = secretKey.getEncoded().length * 8;
                if (length2 == 128) {
                    aSN1ObjectIdentifier = NTTObjectIdentifiers.id_camellia128_wrap;
                } else if (length2 == 192) {
                    aSN1ObjectIdentifier = NTTObjectIdentifiers.id_camellia192_wrap;
                } else if (length2 == 256) {
                    aSN1ObjectIdentifier = NTTObjectIdentifiers.id_camellia256_wrap;
                } else {
                    throw new IllegalArgumentException("illegal keysize in Camellia");
                }
                return new AlgorithmIdentifier((DERObjectIdentifier) aSN1ObjectIdentifier);
            }
            throw new IllegalArgumentException("unknown algorithm");
        }
    }
}
