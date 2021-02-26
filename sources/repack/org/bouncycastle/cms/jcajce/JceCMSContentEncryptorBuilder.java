package repack.org.bouncycastle.cms.jcajce;

import java.io.OutputStream;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.cms.CMSException;
import repack.org.bouncycastle.jcajce.DefaultJcaJceHelper;
import repack.org.bouncycastle.jcajce.NamedJcaJceHelper;
import repack.org.bouncycastle.jcajce.ProviderJcaJceHelper;
import repack.org.bouncycastle.operator.GenericKey;
import repack.org.bouncycastle.operator.OutputEncryptor;

public class JceCMSContentEncryptorBuilder {
    private final ASN1ObjectIdentifier encryptionOID;
    /* access modifiers changed from: private */
    public EnvelopedDataHelper helper;
    private final int keySize;
    private SecureRandom random;

    public JceCMSContentEncryptorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this(aSN1ObjectIdentifier, -1);
    }

    public JceCMSContentEncryptorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i) {
        this.helper = new EnvelopedDataHelper(new DefaultJcaJceHelper());
        this.encryptionOID = aSN1ObjectIdentifier;
        this.keySize = i;
    }

    public JceCMSContentEncryptorBuilder setProvider(Provider provider) {
        this.helper = new EnvelopedDataHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    public JceCMSContentEncryptorBuilder setProvider(String str) {
        this.helper = new EnvelopedDataHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JceCMSContentEncryptorBuilder setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }

    public OutputEncryptor build() throws CMSException {
        return new CMSOutputEncryptor(this.encryptionOID, this.keySize, this.random);
    }

    private class CMSOutputEncryptor implements OutputEncryptor {
        private AlgorithmIdentifier algorithmIdentifier;
        private Cipher cipher;
        private SecretKey encKey;

        CMSOutputEncryptor(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, SecureRandom secureRandom) throws CMSException {
            KeyGenerator createKeyGenerator = JceCMSContentEncryptorBuilder.this.helper.createKeyGenerator(aSN1ObjectIdentifier);
            secureRandom = secureRandom == null ? new SecureRandom() : secureRandom;
            if (i < 0) {
                createKeyGenerator.init(secureRandom);
            } else {
                createKeyGenerator.init(i, secureRandom);
            }
            this.cipher = JceCMSContentEncryptorBuilder.this.helper.createCipher(aSN1ObjectIdentifier);
            this.encKey = createKeyGenerator.generateKey();
            AlgorithmParameters generateParameters = JceCMSContentEncryptorBuilder.this.helper.generateParameters(aSN1ObjectIdentifier, this.encKey, secureRandom);
            try {
                this.cipher.init(1, this.encKey, generateParameters, secureRandom);
                this.algorithmIdentifier = JceCMSContentEncryptorBuilder.this.helper.getAlgorithmIdentifier(aSN1ObjectIdentifier, generateParameters == null ? this.cipher.getParameters() : generateParameters);
            } catch (GeneralSecurityException e) {
                throw new CMSException("unable to initialize cipher: " + e.getMessage(), e);
            }
        }

        public AlgorithmIdentifier getAlgorithmIdentifier() {
            return this.algorithmIdentifier;
        }

        public OutputStream getOutputStream(OutputStream outputStream) {
            return new CipherOutputStream(outputStream, this.cipher);
        }

        public GenericKey getKey() {
            return new GenericKey(this.encKey);
        }
    }
}
