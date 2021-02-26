package repack.org.bouncycastle.jce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import javax.crypto.spec.IvParameterSpec;
import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.BufferedBlockCipher;
import repack.org.bouncycastle.crypto.CipherKeyGenerator;
import repack.org.bouncycastle.crypto.engines.RC6Engine;
import repack.org.bouncycastle.crypto.modes.CBCBlockCipher;
import repack.org.bouncycastle.crypto.modes.CFBBlockCipher;
import repack.org.bouncycastle.crypto.modes.OFBBlockCipher;
import repack.org.bouncycastle.jce.provider.BouncyCastleProvider;
import repack.org.bouncycastle.jce.provider.JCEBlockCipher;
import repack.org.bouncycastle.jce.provider.JCEKeyGenerator;
import repack.org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator;
import repack.org.bouncycastle.jce.provider.JDKAlgorithmParameters;

public final class RC6 {

    public static class AlgParams extends JDKAlgorithmParameters.IVAlgorithmParameters {
        /* access modifiers changed from: protected */
        public String engineToString() {
            return "RC6 IV";
        }
    }

    private RC6() {
    }

    public static class ECB extends JCEBlockCipher {
        public ECB() {
            super(new RC6Engine());
        }
    }

    public static class CBC extends JCEBlockCipher {
        public CBC() {
            super((BlockCipher) new CBCBlockCipher(new RC6Engine()), 128);
        }
    }

    public static class CFB extends JCEBlockCipher {
        public CFB() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new RC6Engine(), 128)), 128);
        }
    }

    public static class OFB extends JCEBlockCipher {
        public OFB() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new RC6Engine(), 128)), 128);
        }
    }

    public static class KeyGen extends JCEKeyGenerator {
        public KeyGen() {
            super("RC6", 256, new CipherKeyGenerator());
        }
    }

    public static class AlgParamGen extends JDKAlgorithmParameterGenerator {
        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for RC6 parameter generation.");
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[16];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance("RC6", BouncyCastleProvider.PROVIDER_NAME);
                instance.init(new IvParameterSpec(bArr));
                return instance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class Mappings extends HashMap {
        public Mappings() {
            put("Cipher.RC6", "org.bouncycastle.jce.provider.symmetric.RC6$ECB");
            put("KeyGenerator.RC6", "org.bouncycastle.jce.provider.symmetric.RC6$KeyGen");
            put("AlgorithmParameters.RC6", "org.bouncycastle.jce.provider.symmetric.RC6$AlgParams");
        }
    }
}
