package repack.org.bouncycastle.operator.jcajce;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import repack.org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import repack.org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.jcajce.DefaultJcaJceHelper;
import repack.org.bouncycastle.jcajce.NamedJcaJceHelper;
import repack.org.bouncycastle.jcajce.ProviderJcaJceHelper;
import repack.org.bouncycastle.operator.GenericKey;
import repack.org.bouncycastle.operator.OperatorException;
import repack.org.bouncycastle.operator.SymmetricKeyWrapper;

public class JceSymmetricKeyWrapper extends SymmetricKeyWrapper {
    private OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
    private SecureRandom random;
    private SecretKey wrappingKey;

    public JceSymmetricKeyWrapper(SecretKey secretKey) {
        super(determineKeyEncAlg(secretKey));
        this.wrappingKey = secretKey;
    }

    public JceSymmetricKeyWrapper setProvider(Provider provider) {
        this.helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    public JceSymmetricKeyWrapper setProvider(String str) {
        this.helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JceSymmetricKeyWrapper setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }

    public byte[] generateWrappedKey(GenericKey genericKey) throws OperatorException {
        Key jceKey = OperatorUtils.getJceKey(genericKey);
        Cipher createSymmetricWrapper = this.helper.createSymmetricWrapper(getAlgorithmIdentifier().getAlgorithm());
        try {
            createSymmetricWrapper.init(3, this.wrappingKey, this.random);
            return createSymmetricWrapper.wrap(jceKey);
        } catch (GeneralSecurityException e) {
            throw new OperatorException("cannot wrap key: " + e.getMessage(), e);
        }
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
