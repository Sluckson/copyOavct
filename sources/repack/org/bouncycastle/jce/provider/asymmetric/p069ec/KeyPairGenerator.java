package repack.org.bouncycastle.jce.provider.asymmetric.p069ec;

import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import repack.org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import repack.org.bouncycastle.crypto.params.ECDomainParameters;
import repack.org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.ECPublicKeyParameters;
import repack.org.bouncycastle.jce.ECNamedCurveTable;
import repack.org.bouncycastle.jce.provider.JCEECPrivateKey;
import repack.org.bouncycastle.jce.provider.JCEECPublicKey;
import repack.org.bouncycastle.jce.provider.JDKKeyPairGenerator;
import repack.org.bouncycastle.jce.provider.ProviderUtil;
import repack.org.bouncycastle.jce.spec.ECParameterSpec;

/* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyPairGenerator */
public abstract class KeyPairGenerator extends JDKKeyPairGenerator {
    public KeyPairGenerator(String str) {
        super(str);
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyPairGenerator$EC */
    public static class C5027EC extends KeyPairGenerator {
        private static Hashtable ecParameters = new Hashtable();
        String algorithm;
        int certainty;
        ECParameterSpec ecParams;
        ECKeyPairGenerator engine;
        boolean initialised;
        ECKeyGenerationParameters param;
        SecureRandom random;
        int strength;

        static {
            ecParameters.put(new Integer(PsExtractor.AUDIO_STREAM), ECNamedCurveTable.getParameterSpec("prime192v1"));
            ecParameters.put(new Integer(239), ECNamedCurveTable.getParameterSpec("prime239v1"));
            ecParameters.put(new Integer(256), ECNamedCurveTable.getParameterSpec("prime256v1"));
        }

        public C5027EC() {
            super("EC");
            this.engine = new ECKeyPairGenerator();
            this.ecParams = null;
            this.strength = 239;
            this.certainty = 50;
            this.random = new SecureRandom();
            this.initialised = false;
            this.algorithm = "EC";
        }

        public C5027EC(String str) {
            super(str);
            this.engine = new ECKeyPairGenerator();
            this.ecParams = null;
            this.strength = 239;
            this.certainty = 50;
            this.random = new SecureRandom();
            this.initialised = false;
            this.algorithm = str;
        }

        public void initialize(int i, SecureRandom secureRandom) {
            this.strength = i;
            this.random = secureRandom;
            this.ecParams = (ECParameterSpec) ecParameters.get(new Integer(i));
            ECParameterSpec eCParameterSpec = this.ecParams;
            if (eCParameterSpec != null) {
                this.param = new ECKeyGenerationParameters(new ECDomainParameters(eCParameterSpec.getCurve(), this.ecParams.getG(), this.ecParams.getN()), secureRandom);
                this.engine.init(this.param);
                this.initialised = true;
                return;
            }
            throw new InvalidParameterException("unknown key size.");
        }

        public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec instanceof ECParameterSpec) {
                ECParameterSpec eCParameterSpec = (ECParameterSpec) algorithmParameterSpec;
                this.ecParams = eCParameterSpec;
                this.param = new ECKeyGenerationParameters(new ECDomainParameters(eCParameterSpec.getCurve(), eCParameterSpec.getG(), eCParameterSpec.getN()), secureRandom);
                this.engine.init(this.param);
                this.initialised = true;
            } else if (algorithmParameterSpec == null && ProviderUtil.getEcImplicitlyCa() != null) {
                ECParameterSpec ecImplicitlyCa = ProviderUtil.getEcImplicitlyCa();
                this.ecParams = (ECParameterSpec) algorithmParameterSpec;
                this.param = new ECKeyGenerationParameters(new ECDomainParameters(ecImplicitlyCa.getCurve(), ecImplicitlyCa.getG(), ecImplicitlyCa.getN()), secureRandom);
                this.engine.init(this.param);
                this.initialised = true;
            } else if (algorithmParameterSpec == null && ProviderUtil.getEcImplicitlyCa() == null) {
                throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
            } else {
                throw new InvalidAlgorithmParameterException("parameter object not a ECParameterSpec");
            }
        }

        public KeyPair generateKeyPair() {
            if (this.initialised) {
                AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
                ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) generateKeyPair.getPublic();
                ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) generateKeyPair.getPrivate();
                ECParameterSpec eCParameterSpec = this.ecParams;
                if (eCParameterSpec == null) {
                    return new KeyPair(new JCEECPublicKey(this.algorithm, eCPublicKeyParameters), new JCEECPrivateKey(this.algorithm, eCPrivateKeyParameters));
                }
                JCEECPublicKey jCEECPublicKey = new JCEECPublicKey(this.algorithm, eCPublicKeyParameters, eCParameterSpec);
                return new KeyPair(jCEECPublicKey, new JCEECPrivateKey(this.algorithm, eCPrivateKeyParameters, jCEECPublicKey, eCParameterSpec));
            }
            throw new IllegalStateException("EC Key Pair Generator not initialised");
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyPairGenerator$ECDSA */
    public static class ECDSA extends C5027EC {
        public ECDSA() {
            super("ECDSA");
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyPairGenerator$ECGOST3410 */
    public static class ECGOST3410 extends C5027EC {
        public ECGOST3410() {
            super("ECGOST3410");
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyPairGenerator$ECDH */
    public static class ECDH extends C5027EC {
        public ECDH() {
            super("ECDH");
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyPairGenerator$ECDHC */
    public static class ECDHC extends C5027EC {
        public ECDHC() {
            super("ECDHC");
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.KeyPairGenerator$ECMQV */
    public static class ECMQV extends C5027EC {
        public ECMQV() {
            super("ECMQV");
        }
    }
}
