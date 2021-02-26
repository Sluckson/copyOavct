package repack.org.bouncycastle.jce.provider;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.Hashtable;
import javax.crypto.spec.DHParameterSpec;
import repack.org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import repack.org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import repack.org.bouncycastle.crypto.generators.DHBasicKeyPairGenerator;
import repack.org.bouncycastle.crypto.generators.DHParametersGenerator;
import repack.org.bouncycastle.crypto.generators.DSAKeyPairGenerator;
import repack.org.bouncycastle.crypto.generators.DSAParametersGenerator;
import repack.org.bouncycastle.crypto.generators.ElGamalKeyPairGenerator;
import repack.org.bouncycastle.crypto.generators.ElGamalParametersGenerator;
import repack.org.bouncycastle.crypto.generators.GOST3410KeyPairGenerator;
import repack.org.bouncycastle.crypto.generators.RSAKeyPairGenerator;
import repack.org.bouncycastle.crypto.params.DHKeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.DHParameters;
import repack.org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.DHPublicKeyParameters;
import repack.org.bouncycastle.crypto.params.DSAKeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.DSAParameters;
import repack.org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import repack.org.bouncycastle.crypto.params.ElGamalKeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.ElGamalParameters;
import repack.org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import repack.org.bouncycastle.crypto.params.GOST3410KeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.GOST3410Parameters;
import repack.org.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.GOST3410PublicKeyParameters;
import repack.org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import repack.org.bouncycastle.crypto.params.RSAKeyParameters;
import repack.org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import repack.org.bouncycastle.jce.spec.ElGamalParameterSpec;
import repack.org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import repack.org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public abstract class JDKKeyPairGenerator extends KeyPairGenerator {
    public abstract KeyPair generateKeyPair();

    public abstract void initialize(int i, SecureRandom secureRandom);

    public JDKKeyPairGenerator(String str) {
        super(str);
    }

    public static class RSA extends JDKKeyPairGenerator {
        static final BigInteger defaultPublicExponent = BigInteger.valueOf(65537);
        static final int defaultTests = 12;
        RSAKeyPairGenerator engine = new RSAKeyPairGenerator();
        RSAKeyGenerationParameters param = new RSAKeyGenerationParameters(defaultPublicExponent, new SecureRandom(), 2048, 12);

        public RSA() {
            super("RSA");
            this.engine.init(this.param);
        }

        public void initialize(int i, SecureRandom secureRandom) {
            this.param = new RSAKeyGenerationParameters(defaultPublicExponent, secureRandom, i, 12);
            this.engine.init(this.param);
        }

        public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec instanceof RSAKeyGenParameterSpec) {
                RSAKeyGenParameterSpec rSAKeyGenParameterSpec = (RSAKeyGenParameterSpec) algorithmParameterSpec;
                this.param = new RSAKeyGenerationParameters(rSAKeyGenParameterSpec.getPublicExponent(), secureRandom, rSAKeyGenParameterSpec.getKeysize(), 12);
                this.engine.init(this.param);
                return;
            }
            throw new InvalidAlgorithmParameterException("parameter object not a RSAKeyGenParameterSpec");
        }

        public KeyPair generateKeyPair() {
            AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
            return new KeyPair(new JCERSAPublicKey((RSAKeyParameters) generateKeyPair.getPublic()), new JCERSAPrivateCrtKey((RSAPrivateCrtKeyParameters) generateKeyPair.getPrivate()));
        }
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.JDKKeyPairGenerator$DH */
    public static class C5023DH extends JDKKeyPairGenerator {
        private static Hashtable params = new Hashtable();
        int certainty = 20;
        DHBasicKeyPairGenerator engine = new DHBasicKeyPairGenerator();
        boolean initialised = false;
        DHKeyGenerationParameters param;
        SecureRandom random = new SecureRandom();
        int strength = 1024;

        public C5023DH() {
            super("DH");
        }

        public void initialize(int i, SecureRandom secureRandom) {
            this.strength = i;
            this.random = secureRandom;
        }

        public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec instanceof DHParameterSpec) {
                DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                this.param = new DHKeyGenerationParameters(secureRandom, new DHParameters(dHParameterSpec.getP(), dHParameterSpec.getG(), (BigInteger) null, dHParameterSpec.getL()));
                this.engine.init(this.param);
                this.initialised = true;
                return;
            }
            throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec");
        }

        public KeyPair generateKeyPair() {
            if (!this.initialised) {
                Integer num = new Integer(this.strength);
                if (params.containsKey(num)) {
                    this.param = (DHKeyGenerationParameters) params.get(num);
                } else {
                    DHParametersGenerator dHParametersGenerator = new DHParametersGenerator();
                    dHParametersGenerator.init(this.strength, this.certainty, this.random);
                    this.param = new DHKeyGenerationParameters(this.random, dHParametersGenerator.generateParameters());
                    params.put(num, this.param);
                }
                this.engine.init(this.param);
                this.initialised = true;
            }
            AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
            return new KeyPair(new JCEDHPublicKey((DHPublicKeyParameters) generateKeyPair.getPublic()), new JCEDHPrivateKey((DHPrivateKeyParameters) generateKeyPair.getPrivate()));
        }
    }

    public static class DSA extends JDKKeyPairGenerator {
        int certainty = 20;
        DSAKeyPairGenerator engine = new DSAKeyPairGenerator();
        boolean initialised = false;
        DSAKeyGenerationParameters param;
        SecureRandom random = new SecureRandom();
        int strength = 1024;

        public DSA() {
            super("DSA");
        }

        public void initialize(int i, SecureRandom secureRandom) {
            if (i < 512 || i > 1024 || i % 64 != 0) {
                throw new InvalidParameterException("strength must be from 512 - 1024 and a multiple of 64");
            }
            this.strength = i;
            this.random = secureRandom;
        }

        public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec instanceof DSAParameterSpec) {
                DSAParameterSpec dSAParameterSpec = (DSAParameterSpec) algorithmParameterSpec;
                this.param = new DSAKeyGenerationParameters(secureRandom, new DSAParameters(dSAParameterSpec.getP(), dSAParameterSpec.getQ(), dSAParameterSpec.getG()));
                this.engine.init(this.param);
                this.initialised = true;
                return;
            }
            throw new InvalidAlgorithmParameterException("parameter object not a DSAParameterSpec");
        }

        public KeyPair generateKeyPair() {
            if (!this.initialised) {
                DSAParametersGenerator dSAParametersGenerator = new DSAParametersGenerator();
                dSAParametersGenerator.init(this.strength, this.certainty, this.random);
                this.param = new DSAKeyGenerationParameters(this.random, dSAParametersGenerator.generateParameters());
                this.engine.init(this.param);
                this.initialised = true;
            }
            AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
            return new KeyPair(new JDKDSAPublicKey((DSAPublicKeyParameters) generateKeyPair.getPublic()), new JDKDSAPrivateKey((DSAPrivateKeyParameters) generateKeyPair.getPrivate()));
        }
    }

    public static class ElGamal extends JDKKeyPairGenerator {
        int certainty = 20;
        ElGamalKeyPairGenerator engine = new ElGamalKeyPairGenerator();
        boolean initialised = false;
        ElGamalKeyGenerationParameters param;
        SecureRandom random = new SecureRandom();
        int strength = 1024;

        public ElGamal() {
            super("ElGamal");
        }

        public void initialize(int i, SecureRandom secureRandom) {
            this.strength = i;
            this.random = secureRandom;
        }

        public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            boolean z = algorithmParameterSpec instanceof ElGamalParameterSpec;
            if (z || (algorithmParameterSpec instanceof DHParameterSpec)) {
                if (z) {
                    ElGamalParameterSpec elGamalParameterSpec = (ElGamalParameterSpec) algorithmParameterSpec;
                    this.param = new ElGamalKeyGenerationParameters(secureRandom, new ElGamalParameters(elGamalParameterSpec.getP(), elGamalParameterSpec.getG()));
                } else {
                    DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                    this.param = new ElGamalKeyGenerationParameters(secureRandom, new ElGamalParameters(dHParameterSpec.getP(), dHParameterSpec.getG(), dHParameterSpec.getL()));
                }
                this.engine.init(this.param);
                this.initialised = true;
                return;
            }
            throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec or an ElGamalParameterSpec");
        }

        public KeyPair generateKeyPair() {
            if (!this.initialised) {
                ElGamalParametersGenerator elGamalParametersGenerator = new ElGamalParametersGenerator();
                elGamalParametersGenerator.init(this.strength, this.certainty, this.random);
                this.param = new ElGamalKeyGenerationParameters(this.random, elGamalParametersGenerator.generateParameters());
                this.engine.init(this.param);
                this.initialised = true;
            }
            AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
            return new KeyPair(new JCEElGamalPublicKey((ElGamalPublicKeyParameters) generateKeyPair.getPublic()), new JCEElGamalPrivateKey((ElGamalPrivateKeyParameters) generateKeyPair.getPrivate()));
        }
    }

    public static class GOST3410 extends JDKKeyPairGenerator {
        GOST3410KeyPairGenerator engine = new GOST3410KeyPairGenerator();
        GOST3410ParameterSpec gost3410Params;
        boolean initialised = false;
        GOST3410KeyGenerationParameters param;
        SecureRandom random = null;
        int strength = 1024;

        public GOST3410() {
            super("GOST3410");
        }

        public void initialize(int i, SecureRandom secureRandom) {
            this.strength = i;
            this.random = secureRandom;
        }

        private void init(GOST3410ParameterSpec gOST3410ParameterSpec, SecureRandom secureRandom) {
            GOST3410PublicKeyParameterSetSpec publicKeyParameters = gOST3410ParameterSpec.getPublicKeyParameters();
            this.param = new GOST3410KeyGenerationParameters(secureRandom, new GOST3410Parameters(publicKeyParameters.getP(), publicKeyParameters.getQ(), publicKeyParameters.getA()));
            this.engine.init(this.param);
            this.initialised = true;
            this.gost3410Params = gOST3410ParameterSpec;
        }

        public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec instanceof GOST3410ParameterSpec) {
                init((GOST3410ParameterSpec) algorithmParameterSpec, secureRandom);
                return;
            }
            throw new InvalidAlgorithmParameterException("parameter object not a GOST3410ParameterSpec");
        }

        public KeyPair generateKeyPair() {
            if (!this.initialised) {
                init(new GOST3410ParameterSpec(CryptoProObjectIdentifiers.gostR3410_94_CryptoPro_A.getId()), new SecureRandom());
            }
            AsymmetricCipherKeyPair generateKeyPair = this.engine.generateKeyPair();
            return new KeyPair(new JDKGOST3410PublicKey((GOST3410PublicKeyParameters) generateKeyPair.getPublic(), this.gost3410Params), new JDKGOST3410PrivateKey((GOST3410PrivateKeyParameters) generateKeyPair.getPrivate(), this.gost3410Params));
        }
    }
}
