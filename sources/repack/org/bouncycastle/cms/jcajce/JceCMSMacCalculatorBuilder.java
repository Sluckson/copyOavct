package repack.org.bouncycastle.cms.jcajce;

import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.cms.CMSException;
import repack.org.bouncycastle.jcajce.DefaultJcaJceHelper;
import repack.org.bouncycastle.jcajce.NamedJcaJceHelper;
import repack.org.bouncycastle.jcajce.ProviderJcaJceHelper;
import repack.org.bouncycastle.jcajce.p068io.MacOutputStream;
import repack.org.bouncycastle.operator.GenericKey;
import repack.org.bouncycastle.operator.MacCalculator;

public class JceCMSMacCalculatorBuilder {
    /* access modifiers changed from: private */
    public EnvelopedDataHelper helper;
    private final int keySize;
    private final ASN1ObjectIdentifier macOID;
    private MacOutputStream macOutputStream;
    private SecureRandom random;

    public JceCMSMacCalculatorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this(aSN1ObjectIdentifier, -1);
    }

    public JceCMSMacCalculatorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i) {
        this.helper = new EnvelopedDataHelper(new DefaultJcaJceHelper());
        this.macOID = aSN1ObjectIdentifier;
        this.keySize = i;
    }

    public JceCMSMacCalculatorBuilder setProvider(Provider provider) {
        this.helper = new EnvelopedDataHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    public JceCMSMacCalculatorBuilder setProvider(String str) {
        this.helper = new EnvelopedDataHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JceCMSMacCalculatorBuilder setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }

    public MacCalculator build() throws CMSException {
        return new CMSOutputEncryptor(this.macOID, this.keySize, this.random);
    }

    private class CMSOutputEncryptor implements MacCalculator {
        private AlgorithmIdentifier algorithmIdentifier;
        private SecretKey encKey;
        private Mac mac;
        private SecureRandom random;

        CMSOutputEncryptor(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, SecureRandom secureRandom) throws CMSException {
            KeyGenerator createKeyGenerator = JceCMSMacCalculatorBuilder.this.helper.createKeyGenerator(aSN1ObjectIdentifier);
            secureRandom = secureRandom == null ? new SecureRandom() : secureRandom;
            this.random = secureRandom;
            if (i < 0) {
                createKeyGenerator.init(secureRandom);
            } else {
                createKeyGenerator.init(i, secureRandom);
            }
            this.encKey = createKeyGenerator.generateKey();
            this.algorithmIdentifier = JceCMSMacCalculatorBuilder.this.helper.getAlgorithmIdentifier(aSN1ObjectIdentifier, generateParameterSpec(aSN1ObjectIdentifier, this.encKey));
            this.mac = JceCMSMacCalculatorBuilder.this.helper.createContentMac(this.encKey, this.algorithmIdentifier);
        }

        public AlgorithmIdentifier getAlgorithmIdentifier() {
            return this.algorithmIdentifier;
        }

        public OutputStream getOutputStream() {
            return new MacOutputStream(this.mac);
        }

        public byte[] getMac() {
            return this.mac.doFinal();
        }

        public GenericKey getKey() {
            return new GenericKey(this.encKey);
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameterSpec generateParameterSpec(ASN1ObjectIdentifier aSN1ObjectIdentifier, SecretKey secretKey) throws CMSException {
            try {
                if (!aSN1ObjectIdentifier.equals(PKCSObjectIdentifiers.RC2_CBC)) {
                    return JceCMSMacCalculatorBuilder.this.helper.createAlgorithmParameterGenerator(aSN1ObjectIdentifier).generateParameters().getParameterSpec(IvParameterSpec.class);
                }
                byte[] bArr = new byte[8];
                this.random.nextBytes(bArr);
                return new RC2ParameterSpec(secretKey.getEncoded().length * 8, bArr);
            } catch (GeneralSecurityException unused) {
                return null;
            }
        }
    }
}
