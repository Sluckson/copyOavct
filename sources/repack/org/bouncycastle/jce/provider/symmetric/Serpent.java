package repack.org.bouncycastle.jce.provider.symmetric;

import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import java.util.HashMap;
import repack.org.bouncycastle.crypto.CipherKeyGenerator;
import repack.org.bouncycastle.crypto.engines.SerpentEngine;
import repack.org.bouncycastle.jce.provider.JCEBlockCipher;
import repack.org.bouncycastle.jce.provider.JCEKeyGenerator;
import repack.org.bouncycastle.jce.provider.JDKAlgorithmParameters;

public final class Serpent {

    public static class AlgParams extends JDKAlgorithmParameters.IVAlgorithmParameters {
        /* access modifiers changed from: protected */
        public String engineToString() {
            return "Serpent IV";
        }
    }

    private Serpent() {
    }

    public static class ECB extends JCEBlockCipher {
        public ECB() {
            super(new SerpentEngine());
        }
    }

    public static class KeyGen extends JCEKeyGenerator {
        public KeyGen() {
            super("Serpent", PsExtractor.AUDIO_STREAM, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends HashMap {
        public Mappings() {
            put("Cipher.Serpent", "org.bouncycastle.jce.provider.symmetric.Serpent$ECB");
            put("KeyGenerator.Serpent", "org.bouncycastle.jce.provider.symmetric.Serpent$KeyGen");
            put("AlgorithmParameters.Serpent", "org.bouncycastle.jce.provider.symmetric.Serpent$AlgParams");
        }
    }
}
