package repack.org.bouncycastle.jce.provider.asymmetric.p069ec;

import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import repack.org.bouncycastle.asn1.p065x9.X9IntegerConverter;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.crypto.BasicAgreement;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DerivationFunction;
import repack.org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import repack.org.bouncycastle.crypto.agreement.ECDHCBasicAgreement;
import repack.org.bouncycastle.crypto.agreement.ECMQVBasicAgreement;
import repack.org.bouncycastle.crypto.agreement.kdf.DHKDFParameters;
import repack.org.bouncycastle.crypto.agreement.kdf.ECDHKEKGenerator;
import repack.org.bouncycastle.crypto.digests.SHA1Digest;
import repack.org.bouncycastle.crypto.params.ECDomainParameters;
import repack.org.bouncycastle.crypto.params.ECPublicKeyParameters;
import repack.org.bouncycastle.crypto.params.MQVPublicParameters;
import repack.org.bouncycastle.jce.interfaces.ECPublicKey;
import repack.org.bouncycastle.jce.interfaces.MQVPublicKey;

/* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyAgreement */
public class KeyAgreement extends KeyAgreementSpi {
    private static final Hashtable algorithms = new Hashtable();
    private static final X9IntegerConverter converter = new X9IntegerConverter();
    private BasicAgreement agreement;
    private String kaAlgorithm;
    private DerivationFunction kdf;
    private ECDomainParameters parameters;
    private BigInteger result;

    static {
        Integer num = new Integer(128);
        Integer num2 = new Integer(PsExtractor.AUDIO_STREAM);
        Integer num3 = new Integer(256);
        algorithms.put(NISTObjectIdentifiers.id_aes128_CBC.getId(), num);
        algorithms.put(NISTObjectIdentifiers.id_aes192_CBC.getId(), num2);
        algorithms.put(NISTObjectIdentifiers.id_aes256_CBC.getId(), num3);
        algorithms.put(NISTObjectIdentifiers.id_aes128_wrap.getId(), num);
        algorithms.put(NISTObjectIdentifiers.id_aes192_wrap.getId(), num2);
        algorithms.put(NISTObjectIdentifiers.id_aes256_wrap.getId(), num3);
        algorithms.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId(), num2);
    }

    private byte[] bigIntToBytes(BigInteger bigInteger) {
        X9IntegerConverter x9IntegerConverter = converter;
        return x9IntegerConverter.integerToBytes(bigInteger, x9IntegerConverter.getByteLength(this.parameters.getG().getX()));
    }

    protected KeyAgreement(String str, BasicAgreement basicAgreement, DerivationFunction derivationFunction) {
        this.kaAlgorithm = str;
        this.agreement = basicAgreement;
        this.kdf = derivationFunction;
    }

    /* access modifiers changed from: protected */
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        CipherParameters cipherParameters;
        if (this.parameters == null) {
            throw new IllegalStateException(String.valueOf(this.kaAlgorithm) + " not initialised.");
        } else if (z) {
            if (this.agreement instanceof ECMQVBasicAgreement) {
                if (key instanceof MQVPublicKey) {
                    MQVPublicKey mQVPublicKey = (MQVPublicKey) key;
                    cipherParameters = new MQVPublicParameters((ECPublicKeyParameters) ECUtil.generatePublicKeyParameter(mQVPublicKey.getStaticKey()), (ECPublicKeyParameters) ECUtil.generatePublicKeyParameter(mQVPublicKey.getEphemeralKey()));
                } else {
                    throw new InvalidKeyException(String.valueOf(this.kaAlgorithm) + " key agreement requires " + getSimpleName(MQVPublicKey.class) + " for doPhase");
                }
            } else if (key instanceof ECPublicKey) {
                cipherParameters = ECUtil.generatePublicKeyParameter((PublicKey) key);
            } else {
                throw new InvalidKeyException(String.valueOf(this.kaAlgorithm) + " key agreement requires " + getSimpleName(ECPublicKey.class) + " for doPhase");
            }
            this.result = this.agreement.calculateAgreement(cipherParameters);
            return null;
        } else {
            throw new IllegalStateException(String.valueOf(this.kaAlgorithm) + " can only be between two parties.");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.kdf == null) {
            return bigIntToBytes(this.result);
        }
        throw new UnsupportedOperationException("KDF can only be used when algorithm is known");
    }

    /* access modifiers changed from: protected */
    public int engineGenerateSecret(byte[] bArr, int i) throws IllegalStateException, ShortBufferException {
        byte[] engineGenerateSecret = engineGenerateSecret();
        if (bArr.length - i >= engineGenerateSecret.length) {
            System.arraycopy(engineGenerateSecret, 0, bArr, i, engineGenerateSecret.length);
            return engineGenerateSecret.length;
        }
        throw new ShortBufferException(String.valueOf(this.kaAlgorithm) + " key agreement: need " + engineGenerateSecret.length + " bytes");
    }

    /* access modifiers changed from: protected */
    public SecretKey engineGenerateSecret(String str) throws NoSuchAlgorithmException {
        byte[] bigIntToBytes = bigIntToBytes(this.result);
        if (this.kdf != null) {
            if (algorithms.containsKey(str)) {
                int intValue = ((Integer) algorithms.get(str)).intValue();
                DHKDFParameters dHKDFParameters = new DHKDFParameters(new DERObjectIdentifier(str), intValue, bigIntToBytes);
                bigIntToBytes = new byte[(intValue / 8)];
                this.kdf.init(dHKDFParameters);
                this.kdf.generateBytes(bigIntToBytes, 0, bigIntToBytes.length);
            } else {
                throw new NoSuchAlgorithmException("unknown algorithm encountered: " + str);
            }
        }
        return new SecretKeySpec(bigIntToBytes, str);
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        initFromKey(key);
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        initFromKey(key);
    }

    /* JADX WARNING: type inference failed for: r5v9, types: [repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initFromKey(java.security.Key r5) throws java.security.InvalidKeyException {
        /*
            r4 = this;
            repack.org.bouncycastle.crypto.BasicAgreement r0 = r4.agreement
            boolean r0 = r0 instanceof repack.org.bouncycastle.crypto.agreement.ECMQVBasicAgreement
            java.lang.String r1 = " for initialisation"
            java.lang.String r2 = " key agreement requires "
            if (r0 == 0) goto L_0x006b
            boolean r0 = r5 instanceof repack.org.bouncycastle.jce.interfaces.MQVPrivateKey
            if (r0 == 0) goto L_0x0047
            repack.org.bouncycastle.jce.interfaces.MQVPrivateKey r5 = (repack.org.bouncycastle.jce.interfaces.MQVPrivateKey) r5
            java.security.PrivateKey r0 = r5.getStaticPrivateKey()
            repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter r0 = repack.org.bouncycastle.jce.provider.asymmetric.p069ec.ECUtil.generatePrivateKeyParameter(r0)
            repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters r0 = (repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters) r0
            java.security.PrivateKey r1 = r5.getEphemeralPrivateKey()
            repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter r1 = repack.org.bouncycastle.jce.provider.asymmetric.p069ec.ECUtil.generatePrivateKeyParameter(r1)
            repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters r1 = (repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters) r1
            r2 = 0
            java.security.PublicKey r3 = r5.getEphemeralPublicKey()
            if (r3 == 0) goto L_0x0036
            java.security.PublicKey r5 = r5.getEphemeralPublicKey()
            repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter r5 = repack.org.bouncycastle.jce.provider.asymmetric.p069ec.ECUtil.generatePublicKeyParameter(r5)
            r2 = r5
            repack.org.bouncycastle.crypto.params.ECPublicKeyParameters r2 = (repack.org.bouncycastle.crypto.params.ECPublicKeyParameters) r2
        L_0x0036:
            repack.org.bouncycastle.crypto.params.MQVPrivateParameters r5 = new repack.org.bouncycastle.crypto.params.MQVPrivateParameters
            r5.<init>(r0, r1, r2)
            repack.org.bouncycastle.crypto.params.ECDomainParameters r0 = r0.getParameters()
            r4.parameters = r0
            repack.org.bouncycastle.crypto.BasicAgreement r0 = r4.agreement
            r0.init(r5)
            goto L_0x0082
        L_0x0047:
            java.security.InvalidKeyException r5 = new java.security.InvalidKeyException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = r4.kaAlgorithm
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r0.<init>(r3)
            r0.append(r2)
            java.lang.Class<repack.org.bouncycastle.jce.interfaces.MQVPrivateKey> r2 = repack.org.bouncycastle.jce.interfaces.MQVPrivateKey.class
            java.lang.String r2 = getSimpleName(r2)
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x006b:
            boolean r0 = r5 instanceof repack.org.bouncycastle.jce.interfaces.ECPrivateKey
            if (r0 == 0) goto L_0x0083
            java.security.PrivateKey r5 = (java.security.PrivateKey) r5
            repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter r5 = repack.org.bouncycastle.jce.provider.asymmetric.p069ec.ECUtil.generatePrivateKeyParameter(r5)
            repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters r5 = (repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters) r5
            repack.org.bouncycastle.crypto.params.ECDomainParameters r0 = r5.getParameters()
            r4.parameters = r0
            repack.org.bouncycastle.crypto.BasicAgreement r0 = r4.agreement
            r0.init(r5)
        L_0x0082:
            return
        L_0x0083:
            java.security.InvalidKeyException r5 = new java.security.InvalidKeyException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = r4.kaAlgorithm
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r0.<init>(r3)
            r0.append(r2)
            java.lang.Class<repack.org.bouncycastle.jce.interfaces.ECPrivateKey> r2 = repack.org.bouncycastle.jce.interfaces.ECPrivateKey.class
            java.lang.String r2 = getSimpleName(r2)
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.jce.provider.asymmetric.p069ec.KeyAgreement.initFromKey(java.security.Key):void");
    }

    private static String getSimpleName(Class cls) {
        String name = cls.getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyAgreement$DH */
    public static class C5025DH extends KeyAgreement {
        public C5025DH() {
            super("ECDH", new ECDHBasicAgreement(), (DerivationFunction) null);
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyAgreement$DHC */
    public static class DHC extends KeyAgreement {
        public DHC() {
            super("ECDHC", new ECDHCBasicAgreement(), (DerivationFunction) null);
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyAgreement$MQV */
    public static class MQV extends KeyAgreement {
        public MQV() {
            super("ECMQV", new ECMQVBasicAgreement(), (DerivationFunction) null);
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyAgreement$DHwithSHA1KDF */
    public static class DHwithSHA1KDF extends KeyAgreement {
        public DHwithSHA1KDF() {
            super("ECDHwithSHA1KDF", new ECDHBasicAgreement(), new ECDHKEKGenerator(new SHA1Digest()));
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyAgreement$MQVwithSHA1KDF */
    public static class MQVwithSHA1KDF extends KeyAgreement {
        public MQVwithSHA1KDF() {
            super("ECMQVwithSHA1KDF", new ECMQVBasicAgreement(), new ECDHKEKGenerator(new SHA1Digest()));
        }
    }
}
