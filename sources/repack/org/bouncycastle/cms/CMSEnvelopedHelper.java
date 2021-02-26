package repack.org.bouncycastle.cms;

import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.spec.InvalidParameterSpecException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import repack.org.bouncycastle.asn1.ASN1Null;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.cms.KEKRecipientInfo;
import repack.org.bouncycastle.asn1.cms.KeyAgreeRecipientInfo;
import repack.org.bouncycastle.asn1.cms.KeyTransRecipientInfo;
import repack.org.bouncycastle.asn1.cms.PasswordRecipientInfo;
import repack.org.bouncycastle.asn1.cms.RecipientInfo;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.operator.DigestCalculator;
import repack.org.bouncycastle.util.p072io.TeeInputStream;

class CMSEnvelopedHelper {
    private static final Map BASE_CIPHER_NAMES = new HashMap();
    private static final Map CIPHER_ALG_NAMES = new HashMap();
    static final CMSEnvelopedHelper INSTANCE = new CMSEnvelopedHelper();
    private static final Map KEYSIZES = new HashMap();
    private static final Map MAC_ALG_NAMES = new HashMap();

    interface JCECallback {
        Object doInJCE() throws CMSException, InvalidAlgorithmParameterException, InvalidKeyException, InvalidParameterSpecException, NoSuchAlgorithmException, NoSuchPaddingException;
    }

    CMSEnvelopedHelper() {
    }

    static {
        KEYSIZES.put(CMSEnvelopedGenerator.DES_EDE3_CBC, new Integer(PsExtractor.AUDIO_STREAM));
        KEYSIZES.put(CMSEnvelopedGenerator.AES128_CBC, new Integer(128));
        KEYSIZES.put(CMSEnvelopedGenerator.AES192_CBC, new Integer(PsExtractor.AUDIO_STREAM));
        KEYSIZES.put(CMSEnvelopedGenerator.AES256_CBC, new Integer(256));
        BASE_CIPHER_NAMES.put(CMSEnvelopedGenerator.DES_EDE3_CBC, "DESEDE");
        BASE_CIPHER_NAMES.put(CMSEnvelopedGenerator.AES128_CBC, "AES");
        BASE_CIPHER_NAMES.put(CMSEnvelopedGenerator.AES192_CBC, "AES");
        BASE_CIPHER_NAMES.put(CMSEnvelopedGenerator.AES256_CBC, "AES");
        CIPHER_ALG_NAMES.put(CMSEnvelopedGenerator.DES_EDE3_CBC, "DESEDE/CBC/PKCS5Padding");
        CIPHER_ALG_NAMES.put(CMSEnvelopedGenerator.AES128_CBC, "AES/CBC/PKCS5Padding");
        CIPHER_ALG_NAMES.put(CMSEnvelopedGenerator.AES192_CBC, "AES/CBC/PKCS5Padding");
        CIPHER_ALG_NAMES.put(CMSEnvelopedGenerator.AES256_CBC, "AES/CBC/PKCS5Padding");
        MAC_ALG_NAMES.put(CMSEnvelopedGenerator.DES_EDE3_CBC, "DESEDEMac");
        MAC_ALG_NAMES.put(CMSEnvelopedGenerator.AES128_CBC, "AESMac");
        MAC_ALG_NAMES.put(CMSEnvelopedGenerator.AES192_CBC, "AESMac");
        MAC_ALG_NAMES.put(CMSEnvelopedGenerator.AES256_CBC, "AESMac");
    }

    /* access modifiers changed from: package-private */
    public String getAsymmetricEncryptionAlgName(String str) {
        return PKCSObjectIdentifiers.rsaEncryption.getId().equals(str) ? "RSA/ECB/PKCS1Padding" : str;
    }

    /* access modifiers changed from: package-private */
    public Cipher createAsymmetricCipher(String str, String str2) throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException {
        String asymmetricEncryptionAlgName = getAsymmetricEncryptionAlgName(str);
        if (!asymmetricEncryptionAlgName.equals(str)) {
            try {
                return Cipher.getInstance(asymmetricEncryptionAlgName, str2);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return Cipher.getInstance(str, str2);
    }

    /* access modifiers changed from: package-private */
    public Cipher createAsymmetricCipher(String str, Provider provider) throws NoSuchAlgorithmException, NoSuchPaddingException {
        String asymmetricEncryptionAlgName = getAsymmetricEncryptionAlgName(str);
        if (!asymmetricEncryptionAlgName.equals(str)) {
            try {
                return getCipherInstance(asymmetricEncryptionAlgName, provider);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return getCipherInstance(str, provider);
    }

    /* access modifiers changed from: package-private */
    public KeyGenerator createSymmetricKeyGenerator(String str, Provider provider) throws NoSuchAlgorithmException {
        try {
            return createKeyGenerator(str, provider);
        } catch (NoSuchAlgorithmException e) {
            try {
                String str2 = (String) BASE_CIPHER_NAMES.get(str);
                if (str2 != null) {
                    return createKeyGenerator(str2, provider);
                }
            } catch (NoSuchAlgorithmException unused) {
            }
            if (provider != null) {
                return createSymmetricKeyGenerator(str, (Provider) null);
            }
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public AlgorithmParameters createAlgorithmParameters(String str, Provider provider) throws NoSuchAlgorithmException {
        try {
            return createAlgorithmParams(str, provider);
        } catch (NoSuchAlgorithmException e) {
            try {
                String str2 = (String) BASE_CIPHER_NAMES.get(str);
                if (str2 != null) {
                    return createAlgorithmParams(str2, provider);
                }
            } catch (NoSuchAlgorithmException unused) {
            }
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public AlgorithmParameterGenerator createAlgorithmParameterGenerator(String str, Provider provider) throws NoSuchAlgorithmException {
        try {
            return createAlgorithmParamsGenerator(str, provider);
        } catch (NoSuchAlgorithmException e) {
            try {
                String str2 = (String) BASE_CIPHER_NAMES.get(str);
                if (str2 != null) {
                    return createAlgorithmParamsGenerator(str2, provider);
                }
            } catch (NoSuchAlgorithmException unused) {
            }
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public String getRFC3211WrapperName(String str) {
        String str2 = (String) BASE_CIPHER_NAMES.get(str);
        if (str2 != null) {
            return String.valueOf(str2) + "RFC3211Wrap";
        }
        throw new IllegalArgumentException("no name for " + str);
    }

    /* access modifiers changed from: package-private */
    public int getKeySize(String str) {
        Integer num = (Integer) KEYSIZES.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("no keysize for " + str);
    }

    private Cipher getCipherInstance(String str, Provider provider) throws NoSuchAlgorithmException, NoSuchPaddingException {
        if (provider != null) {
            return Cipher.getInstance(str, provider);
        }
        return Cipher.getInstance(str);
    }

    private AlgorithmParameters createAlgorithmParams(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider != null) {
            return AlgorithmParameters.getInstance(str, provider);
        }
        return AlgorithmParameters.getInstance(str);
    }

    private AlgorithmParameterGenerator createAlgorithmParamsGenerator(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider != null) {
            return AlgorithmParameterGenerator.getInstance(str, provider);
        }
        return AlgorithmParameterGenerator.getInstance(str);
    }

    private KeyGenerator createKeyGenerator(String str, Provider provider) throws NoSuchAlgorithmException {
        if (provider != null) {
            return KeyGenerator.getInstance(str, provider);
        }
        return KeyGenerator.getInstance(str);
    }

    /* access modifiers changed from: package-private */
    public Cipher createSymmetricCipher(String str, Provider provider) throws NoSuchAlgorithmException, NoSuchPaddingException {
        try {
            return getCipherInstance(str, provider);
        } catch (NoSuchAlgorithmException e) {
            try {
                return getCipherInstance((String) CIPHER_ALG_NAMES.get(str), provider);
            } catch (NoSuchAlgorithmException unused) {
                if (provider != null) {
                    return createSymmetricCipher(str, (Provider) null);
                }
                throw e;
            }
        }
    }

    private Mac createMac(String str, Provider provider) throws NoSuchAlgorithmException, NoSuchPaddingException {
        if (provider != null) {
            return Mac.getInstance(str, provider);
        }
        return Mac.getInstance(str);
    }

    /* access modifiers changed from: package-private */
    public Mac getMac(String str, Provider provider) throws NoSuchAlgorithmException, NoSuchPaddingException {
        try {
            return createMac(str, provider);
        } catch (NoSuchAlgorithmException e) {
            try {
                return createMac((String) MAC_ALG_NAMES.get(str), provider);
            } catch (NoSuchAlgorithmException unused) {
                if (provider != null) {
                    return getMac(str, (Provider) null);
                }
                throw e;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public AlgorithmParameters getEncryptionAlgorithmParameters(String str, byte[] bArr, Provider provider) throws CMSException {
        if (bArr == null) {
            return null;
        }
        try {
            AlgorithmParameters createAlgorithmParameters = createAlgorithmParameters(str, provider);
            createAlgorithmParameters.init(bArr, "ASN.1");
            return createAlgorithmParameters;
        } catch (NoSuchAlgorithmException e) {
            throw new CMSException("can't find parameters for algorithm", e);
        } catch (IOException e2) {
            throw new CMSException("can't find parse parameters", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public String getSymmetricCipherName(String str) {
        String str2 = (String) BASE_CIPHER_NAMES.get(str);
        return str2 != null ? str2 : str;
    }

    static RecipientInformationStore buildRecipientInformationStore(ASN1Set aSN1Set, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable) {
        return buildRecipientInformationStore(aSN1Set, algorithmIdentifier, cMSSecureReadable, (AuthAttributesProvider) null);
    }

    static RecipientInformationStore buildRecipientInformationStore(ASN1Set aSN1Set, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable, AuthAttributesProvider authAttributesProvider) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != aSN1Set.size(); i++) {
            readRecipientInfo(arrayList, RecipientInfo.getInstance(aSN1Set.getObjectAt(i)), algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
        }
        return new RecipientInformationStore(arrayList);
    }

    private static void readRecipientInfo(List list, RecipientInfo recipientInfo, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable, AuthAttributesProvider authAttributesProvider) {
        DEREncodable info = recipientInfo.getInfo();
        if (info instanceof KeyTransRecipientInfo) {
            list.add(new KeyTransRecipientInformation((KeyTransRecipientInfo) info, algorithmIdentifier, cMSSecureReadable, authAttributesProvider));
        } else if (info instanceof KEKRecipientInfo) {
            list.add(new KEKRecipientInformation((KEKRecipientInfo) info, algorithmIdentifier, cMSSecureReadable, authAttributesProvider));
        } else if (info instanceof KeyAgreeRecipientInfo) {
            KeyAgreeRecipientInformation.readRecipientInfo(list, (KeyAgreeRecipientInfo) info, algorithmIdentifier, cMSSecureReadable, authAttributesProvider);
        } else if (info instanceof PasswordRecipientInfo) {
            list.add(new PasswordRecipientInformation((PasswordRecipientInfo) info, algorithmIdentifier, cMSSecureReadable, authAttributesProvider));
        }
    }

    static class CMSDigestAuthenticatedSecureReadable implements CMSSecureReadable {
        /* access modifiers changed from: private */
        public DigestCalculator digestCalculator;
        private CMSReadable readable;

        public AlgorithmIdentifier getAlgorithm() {
            return null;
        }

        public Object getCryptoObject() {
            return null;
        }

        public CMSReadable getReadable(SecretKey secretKey, Provider provider) throws CMSException {
            return null;
        }

        public CMSDigestAuthenticatedSecureReadable(DigestCalculator digestCalculator2, CMSReadable cMSReadable) {
            this.digestCalculator = digestCalculator2;
            this.readable = cMSReadable;
        }

        public InputStream getInputStream() throws IOException, CMSException {
            return new FilterInputStream(this.readable.getInputStream()) {
                public int read() throws IOException {
                    int read = this.in.read();
                    if (read >= 0) {
                        CMSDigestAuthenticatedSecureReadable.this.digestCalculator.getOutputStream().write(read);
                    }
                    return read;
                }

                public int read(byte[] bArr, int i, int i2) throws IOException {
                    int read = this.in.read(bArr, i, i2);
                    if (read >= 0) {
                        CMSDigestAuthenticatedSecureReadable.this.digestCalculator.getOutputStream().write(bArr, i, read);
                    }
                    return read;
                }
            };
        }

        public byte[] getDigest() {
            return this.digestCalculator.getDigest();
        }
    }

    static class CMSAuthenticatedSecureReadable implements CMSSecureReadable {
        private AlgorithmIdentifier algorithm;
        private Mac mac;
        private CMSReadable readable;

        CMSAuthenticatedSecureReadable(AlgorithmIdentifier algorithmIdentifier, CMSReadable cMSReadable) {
            this.algorithm = algorithmIdentifier;
            this.readable = cMSReadable;
        }

        public AlgorithmIdentifier getAlgorithm() {
            return this.algorithm;
        }

        public Object getCryptoObject() {
            return this.mac;
        }

        public InputStream getInputStream() throws IOException, CMSException {
            return this.readable.getInputStream();
        }

        public CMSReadable getReadable(SecretKey secretKey, Provider provider) throws CMSException {
            final String id = this.algorithm.getObjectId().getId();
            final ASN1Object aSN1Object = (ASN1Object) this.algorithm.getParameters();
            final Provider provider2 = provider;
            final SecretKey secretKey2 = secretKey;
            this.mac = (Mac) CMSEnvelopedHelper.execute(new JCECallback() {
                public Object doInJCE() throws CMSException, InvalidAlgorithmParameterException, InvalidKeyException, InvalidParameterSpecException, NoSuchAlgorithmException, NoSuchPaddingException {
                    Mac mac = CMSEnvelopedHelper.INSTANCE.getMac(id, provider2);
                    ASN1Object aSN1Object = aSN1Object;
                    if (aSN1Object == null || (aSN1Object instanceof ASN1Null)) {
                        mac.init(secretKey2);
                    } else {
                        AlgorithmParameters createAlgorithmParameters = CMSEnvelopedHelper.INSTANCE.createAlgorithmParameters(id, provider2);
                        try {
                            createAlgorithmParameters.init(aSN1Object.getEncoded(), "ASN.1");
                            mac.init(secretKey2, createAlgorithmParameters.getParameterSpec(IvParameterSpec.class));
                        } catch (IOException e) {
                            throw new CMSException("error decoding algorithm parameters.", e);
                        }
                    }
                    return mac;
                }
            });
            try {
                return new CMSProcessableInputStream(new TeeInputStream(this.readable.getInputStream(), new MacOutputStream(this.mac)));
            } catch (IOException e) {
                throw new CMSException("error reading content.", e);
            }
        }
    }

    static class CMSEnvelopedSecureReadable implements CMSSecureReadable {
        private AlgorithmIdentifier algorithm;
        private Cipher cipher;
        private CMSReadable readable;

        CMSEnvelopedSecureReadable(AlgorithmIdentifier algorithmIdentifier, CMSReadable cMSReadable) {
            this.algorithm = algorithmIdentifier;
            this.readable = cMSReadable;
        }

        public AlgorithmIdentifier getAlgorithm() {
            return this.algorithm;
        }

        public InputStream getInputStream() throws IOException, CMSException {
            return this.readable.getInputStream();
        }

        public Object getCryptoObject() {
            return this.cipher;
        }

        public CMSReadable getReadable(SecretKey secretKey, Provider provider) throws CMSException {
            final String id = this.algorithm.getObjectId().getId();
            final ASN1Object aSN1Object = (ASN1Object) this.algorithm.getParameters();
            final Provider provider2 = provider;
            final SecretKey secretKey2 = secretKey;
            this.cipher = (Cipher) CMSEnvelopedHelper.execute(new JCECallback() {
                public Object doInJCE() throws CMSException, InvalidAlgorithmParameterException, InvalidKeyException, InvalidParameterSpecException, NoSuchAlgorithmException, NoSuchPaddingException {
                    Cipher createSymmetricCipher = CMSEnvelopedHelper.INSTANCE.createSymmetricCipher(id, provider2);
                    ASN1Object aSN1Object = aSN1Object;
                    if (aSN1Object != null && !(aSN1Object instanceof ASN1Null)) {
                        try {
                            AlgorithmParameters createAlgorithmParameters = CMSEnvelopedHelper.INSTANCE.createAlgorithmParameters(id, createSymmetricCipher.getProvider());
                            createAlgorithmParameters.init(aSN1Object.getEncoded(), "ASN.1");
                            createSymmetricCipher.init(2, secretKey2, createAlgorithmParameters);
                        } catch (IOException e) {
                            throw new CMSException("error decoding algorithm parameters.", e);
                        } catch (NoSuchAlgorithmException e2) {
                            if (id.equals(CMSEnvelopedDataGenerator.DES_EDE3_CBC) || id.equals(CMSEnvelopedGenerator.IDEA_CBC) || id.equals(CMSEnvelopedDataGenerator.AES128_CBC) || id.equals(CMSEnvelopedDataGenerator.AES192_CBC) || id.equals(CMSEnvelopedDataGenerator.AES256_CBC)) {
                                createSymmetricCipher.init(2, secretKey2, new IvParameterSpec(ASN1OctetString.getInstance(aSN1Object).getOctets()));
                            } else {
                                throw e2;
                            }
                        }
                    } else if (id.equals(CMSEnvelopedDataGenerator.DES_EDE3_CBC) || id.equals(CMSEnvelopedGenerator.IDEA_CBC) || id.equals(CMSEnvelopedGenerator.CAST5_CBC)) {
                        createSymmetricCipher.init(2, secretKey2, new IvParameterSpec(new byte[8]));
                    } else {
                        createSymmetricCipher.init(2, secretKey2);
                    }
                    return createSymmetricCipher;
                }
            });
            try {
                return new CMSProcessableInputStream(new CipherInputStream(this.readable.getInputStream(), this.cipher));
            } catch (IOException e) {
                throw new CMSException("error reading content.", e);
            }
        }
    }

    static Object execute(JCECallback jCECallback) throws CMSException {
        try {
            return jCECallback.doInJCE();
        } catch (NoSuchAlgorithmException e) {
            throw new CMSException("can't find algorithm.", e);
        } catch (InvalidKeyException e2) {
            throw new CMSException("key invalid in message.", e2);
        } catch (NoSuchPaddingException e3) {
            throw new CMSException("required padding not supported.", e3);
        } catch (InvalidAlgorithmParameterException e4) {
            throw new CMSException("algorithm parameters invalid.", e4);
        } catch (InvalidParameterSpecException e5) {
            throw new CMSException("MAC algorithm parameter spec invalid.", e5);
        }
    }
}
