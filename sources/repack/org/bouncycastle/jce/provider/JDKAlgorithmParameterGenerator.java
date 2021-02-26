package repack.org.bouncycastle.jce.provider;

import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import repack.org.bouncycastle.crypto.generators.DHParametersGenerator;
import repack.org.bouncycastle.crypto.generators.DSAParametersGenerator;
import repack.org.bouncycastle.crypto.generators.ElGamalParametersGenerator;
import repack.org.bouncycastle.crypto.generators.GOST3410ParametersGenerator;
import repack.org.bouncycastle.crypto.params.DHParameters;
import repack.org.bouncycastle.crypto.params.DSAParameters;
import repack.org.bouncycastle.crypto.params.ElGamalParameters;
import repack.org.bouncycastle.crypto.params.GOST3410Parameters;
import repack.org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import repack.org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public abstract class JDKAlgorithmParameterGenerator extends AlgorithmParameterGeneratorSpi {
    protected SecureRandom random;
    protected int strength = 1024;

    /* access modifiers changed from: protected */
    public void engineInit(int i, SecureRandom secureRandom) {
        this.strength = i;
        this.random = secureRandom;
    }

    /* renamed from: repack.org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator$DH */
    public static class C5020DH extends JDKAlgorithmParameterGenerator {

        /* renamed from: l */
        private int f6232l = 0;

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec instanceof DHGenParameterSpec) {
                DHGenParameterSpec dHGenParameterSpec = (DHGenParameterSpec) algorithmParameterSpec;
                this.strength = dHGenParameterSpec.getPrimeSize();
                this.f6232l = dHGenParameterSpec.getExponentSize();
                this.random = secureRandom;
                return;
            }
            throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameters engineGenerateParameters() {
            DHParametersGenerator dHParametersGenerator = new DHParametersGenerator();
            if (this.random != null) {
                dHParametersGenerator.init(this.strength, 20, this.random);
            } else {
                dHParametersGenerator.init(this.strength, 20, new SecureRandom());
            }
            DHParameters generateParameters = dHParametersGenerator.generateParameters();
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance("DH", BouncyCastleProvider.PROVIDER_NAME);
                instance.init(new DHParameterSpec(generateParameters.getP(), generateParameters.getG(), this.f6232l));
                return instance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class DSA extends JDKAlgorithmParameterGenerator {
        /* access modifiers changed from: protected */
        public void engineInit(int i, SecureRandom secureRandom) {
            if (i < 512 || i > 1024 || i % 64 != 0) {
                throw new InvalidParameterException("strength must be from 512 - 1024 and a multiple of 64");
            }
            this.strength = i;
            this.random = secureRandom;
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DSA parameter generation.");
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameters engineGenerateParameters() {
            DSAParametersGenerator dSAParametersGenerator = new DSAParametersGenerator();
            if (this.random != null) {
                dSAParametersGenerator.init(this.strength, 20, this.random);
            } else {
                dSAParametersGenerator.init(this.strength, 20, new SecureRandom());
            }
            DSAParameters generateParameters = dSAParametersGenerator.generateParameters();
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance("DSA", BouncyCastleProvider.PROVIDER_NAME);
                instance.init(new DSAParameterSpec(generateParameters.getP(), generateParameters.getQ(), generateParameters.getG()));
                return instance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class GOST3410 extends JDKAlgorithmParameterGenerator {
        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for GOST3410 parameter generation.");
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameters engineGenerateParameters() {
            GOST3410ParametersGenerator gOST3410ParametersGenerator = new GOST3410ParametersGenerator();
            if (this.random != null) {
                gOST3410ParametersGenerator.init(this.strength, 2, this.random);
            } else {
                gOST3410ParametersGenerator.init(this.strength, 2, new SecureRandom());
            }
            GOST3410Parameters generateParameters = gOST3410ParametersGenerator.generateParameters();
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance("GOST3410", BouncyCastleProvider.PROVIDER_NAME);
                instance.init(new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(generateParameters.getP(), generateParameters.getQ(), generateParameters.getA())));
                return instance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class ElGamal extends JDKAlgorithmParameterGenerator {

        /* renamed from: l */
        private int f6233l = 0;

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec instanceof DHGenParameterSpec) {
                DHGenParameterSpec dHGenParameterSpec = (DHGenParameterSpec) algorithmParameterSpec;
                this.strength = dHGenParameterSpec.getPrimeSize();
                this.f6233l = dHGenParameterSpec.getExponentSize();
                this.random = secureRandom;
                return;
            }
            throw new InvalidAlgorithmParameterException("DH parameter generator requires a DHGenParameterSpec for initialisation");
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameters engineGenerateParameters() {
            ElGamalParametersGenerator elGamalParametersGenerator = new ElGamalParametersGenerator();
            if (this.random != null) {
                elGamalParametersGenerator.init(this.strength, 20, this.random);
            } else {
                elGamalParametersGenerator.init(this.strength, 20, new SecureRandom());
            }
            ElGamalParameters generateParameters = elGamalParametersGenerator.generateParameters();
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance("ElGamal", BouncyCastleProvider.PROVIDER_NAME);
                instance.init(new DHParameterSpec(generateParameters.getP(), generateParameters.getG(), this.f6233l));
                return instance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class DES extends JDKAlgorithmParameterGenerator {
        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DES parameter generation.");
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance("DES", BouncyCastleProvider.PROVIDER_NAME);
                instance.init(new IvParameterSpec(bArr));
                return instance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class RC2 extends JDKAlgorithmParameterGenerator {
        RC2ParameterSpec spec = null;

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec instanceof RC2ParameterSpec) {
                this.spec = (RC2ParameterSpec) algorithmParameterSpec;
                return;
            }
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for RC2 parameter generation.");
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameters engineGenerateParameters() {
            if (this.spec == null) {
                byte[] bArr = new byte[8];
                if (this.random == null) {
                    this.random = new SecureRandom();
                }
                this.random.nextBytes(bArr);
                try {
                    AlgorithmParameters instance = AlgorithmParameters.getInstance("RC2", BouncyCastleProvider.PROVIDER_NAME);
                    instance.init(new IvParameterSpec(bArr));
                    return instance;
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            } else {
                try {
                    AlgorithmParameters instance2 = AlgorithmParameters.getInstance("RC2", BouncyCastleProvider.PROVIDER_NAME);
                    instance2.init(this.spec);
                    return instance2;
                } catch (Exception e2) {
                    throw new RuntimeException(e2.getMessage());
                }
            }
        }
    }
}
