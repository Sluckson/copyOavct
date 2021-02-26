package repack.org.bouncycastle.jce.provider.symmetric;

import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import javax.crypto.spec.IvParameterSpec;
import repack.org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherKeyGenerator;
import repack.org.bouncycastle.crypto.engines.CamelliaEngine;
import repack.org.bouncycastle.crypto.engines.CamelliaWrapEngine;
import repack.org.bouncycastle.crypto.engines.RFC3211WrapEngine;
import repack.org.bouncycastle.crypto.modes.CBCBlockCipher;
import repack.org.bouncycastle.jce.provider.BouncyCastleProvider;
import repack.org.bouncycastle.jce.provider.JCEBlockCipher;
import repack.org.bouncycastle.jce.provider.JCEKeyGenerator;
import repack.org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator;
import repack.org.bouncycastle.jce.provider.JDKAlgorithmParameters;
import repack.org.bouncycastle.jce.provider.WrapCipherSpi;

public final class Camellia {

    public static class AlgParams extends JDKAlgorithmParameters.IVAlgorithmParameters {
        /* access modifiers changed from: protected */
        public String engineToString() {
            return "Camellia IV";
        }
    }

    private Camellia() {
    }

    public static class ECB extends JCEBlockCipher {
        public ECB() {
            super(new CamelliaEngine());
        }
    }

    public static class CBC extends JCEBlockCipher {
        public CBC() {
            super((BlockCipher) new CBCBlockCipher(new CamelliaEngine()), 128);
        }
    }

    public static class Wrap extends WrapCipherSpi {
        public Wrap() {
            super(new CamelliaWrapEngine());
        }
    }

    public static class RFC3211Wrap extends WrapCipherSpi {
        public RFC3211Wrap() {
            super(new RFC3211WrapEngine(new CamelliaEngine()), 16);
        }
    }

    public static class KeyGen extends JCEKeyGenerator {
        public KeyGen() {
            this(256);
        }

        public KeyGen(int i) {
            super("Camellia", i, new CipherKeyGenerator());
        }
    }

    public static class KeyGen128 extends KeyGen {
        public KeyGen128() {
            super(128);
        }
    }

    public static class KeyGen192 extends KeyGen {
        public KeyGen192() {
            super(PsExtractor.AUDIO_STREAM);
        }
    }

    public static class KeyGen256 extends KeyGen {
        public KeyGen256() {
            super(256);
        }
    }

    public static class AlgParamGen extends JDKAlgorithmParameterGenerator {
        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for Camellia parameter generation.");
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance("Camellia", BouncyCastleProvider.PROVIDER_NAME);
                instance.init(new IvParameterSpec(bArr));
                return instance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class Mappings extends HashMap {
        public Mappings() {
            put("AlgorithmParameters.CAMELLIA", "org.bouncycastle.jce.provider.symmetric.Camellia$AlgParams");
            put("Alg.Alias.AlgorithmParameters." + NTTObjectIdentifiers.id_camellia128_cbc, "CAMELLIA");
            put("Alg.Alias.AlgorithmParameters." + NTTObjectIdentifiers.id_camellia192_cbc, "CAMELLIA");
            put("Alg.Alias.AlgorithmParameters." + NTTObjectIdentifiers.id_camellia256_cbc, "CAMELLIA");
            put("AlgorithmParameterGenerator.CAMELLIA", "org.bouncycastle.jce.provider.symmetric.Camellia$AlgParamGen");
            put("Alg.Alias.AlgorithmParameterGenerator." + NTTObjectIdentifiers.id_camellia128_cbc, "CAMELLIA");
            put("Alg.Alias.AlgorithmParameterGenerator." + NTTObjectIdentifiers.id_camellia192_cbc, "CAMELLIA");
            put("Alg.Alias.AlgorithmParameterGenerator." + NTTObjectIdentifiers.id_camellia256_cbc, "CAMELLIA");
            put("Cipher.CAMELLIA", "org.bouncycastle.jce.provider.symmetric.Camellia$ECB");
            put("Cipher." + NTTObjectIdentifiers.id_camellia128_cbc, "org.bouncycastle.jce.provider.symmetric.Camellia$CBC");
            put("Cipher." + NTTObjectIdentifiers.id_camellia192_cbc, "org.bouncycastle.jce.provider.symmetric.Camellia$CBC");
            put("Cipher." + NTTObjectIdentifiers.id_camellia256_cbc, "org.bouncycastle.jce.provider.symmetric.Camellia$CBC");
            put("Cipher.CAMELLIARFC3211WRAP", "org.bouncycastle.jce.provider.symmetric.Camellia$RFC3211Wrap");
            put("Cipher.CAMELLIAWRAP", "org.bouncycastle.jce.provider.symmetric.Camellia$Wrap");
            put("Alg.Alias.Cipher." + NTTObjectIdentifiers.id_camellia128_wrap, "CAMELLIAWRAP");
            put("Alg.Alias.Cipher." + NTTObjectIdentifiers.id_camellia192_wrap, "CAMELLIAWRAP");
            put("Alg.Alias.Cipher." + NTTObjectIdentifiers.id_camellia256_wrap, "CAMELLIAWRAP");
            put("KeyGenerator.CAMELLIA", "org.bouncycastle.jce.provider.symmetric.Camellia$KeyGen");
            put("KeyGenerator." + NTTObjectIdentifiers.id_camellia128_wrap, "org.bouncycastle.jce.provider.symmetric.Camellia$KeyGen128");
            put("KeyGenerator." + NTTObjectIdentifiers.id_camellia192_wrap, "org.bouncycastle.jce.provider.symmetric.Camellia$KeyGen192");
            put("KeyGenerator." + NTTObjectIdentifiers.id_camellia256_wrap, "org.bouncycastle.jce.provider.symmetric.Camellia$KeyGen256");
            put("KeyGenerator." + NTTObjectIdentifiers.id_camellia128_cbc, "org.bouncycastle.jce.provider.symmetric.Camellia$KeyGen128");
            put("KeyGenerator." + NTTObjectIdentifiers.id_camellia192_cbc, "org.bouncycastle.jce.provider.symmetric.Camellia$KeyGen192");
            put("KeyGenerator." + NTTObjectIdentifiers.id_camellia256_cbc, "org.bouncycastle.jce.provider.symmetric.Camellia$KeyGen256");
        }
    }
}
