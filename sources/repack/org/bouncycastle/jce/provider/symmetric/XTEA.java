package repack.org.bouncycastle.jce.provider.symmetric;

import java.util.HashMap;
import repack.org.bouncycastle.crypto.CipherKeyGenerator;
import repack.org.bouncycastle.crypto.engines.XTEAEngine;
import repack.org.bouncycastle.jce.provider.JCEBlockCipher;
import repack.org.bouncycastle.jce.provider.JCEKeyGenerator;
import repack.org.bouncycastle.jce.provider.JDKAlgorithmParameters;

public final class XTEA {

    public static class AlgParams extends JDKAlgorithmParameters.IVAlgorithmParameters {
        /* access modifiers changed from: protected */
        public String engineToString() {
            return "XTEA IV";
        }
    }

    private XTEA() {
    }

    public static class ECB extends JCEBlockCipher {
        public ECB() {
            super(new XTEAEngine());
        }
    }

    public static class KeyGen extends JCEKeyGenerator {
        public KeyGen() {
            super("XTEA", 128, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends HashMap {
        public Mappings() {
            put("Cipher.XTEA", "org.bouncycastle.jce.provider.symmetric.XTEA$ECB");
            put("KeyGenerator.XTEA", "org.bouncycastle.jce.provider.symmetric.XTEA$KeyGen");
            put("AlgorithmParameters.XTEA", "org.bouncycastle.jce.provider.symmetric.XTEA$AlgParams");
        }
    }
}
