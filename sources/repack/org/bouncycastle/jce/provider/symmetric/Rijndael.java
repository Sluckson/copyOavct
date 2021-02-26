package repack.org.bouncycastle.jce.provider.symmetric;

import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import java.util.HashMap;
import repack.org.bouncycastle.crypto.CipherKeyGenerator;
import repack.org.bouncycastle.crypto.engines.RijndaelEngine;
import repack.org.bouncycastle.jce.provider.JCEBlockCipher;
import repack.org.bouncycastle.jce.provider.JCEKeyGenerator;
import repack.org.bouncycastle.jce.provider.JDKAlgorithmParameters;

public final class Rijndael {

    public static class AlgParams extends JDKAlgorithmParameters.IVAlgorithmParameters {
        /* access modifiers changed from: protected */
        public String engineToString() {
            return "Rijndael IV";
        }
    }

    private Rijndael() {
    }

    public static class ECB extends JCEBlockCipher {
        public ECB() {
            super(new RijndaelEngine());
        }
    }

    public static class KeyGen extends JCEKeyGenerator {
        public KeyGen() {
            super("Rijndael", PsExtractor.AUDIO_STREAM, new CipherKeyGenerator());
        }
    }

    public static class Mappings extends HashMap {
        public Mappings() {
            put("Cipher.RIJNDAEL", "org.bouncycastle.jce.provider.symmetric.Rijndael$ECB");
            put("KeyGenerator.RIJNDAEL", "org.bouncycastle.jce.provider.symmetric.Rijndael$KeyGen");
            put("AlgorithmParameters.RIJNDAEL", "org.bouncycastle.jce.provider.symmetric.Rijndael$AlgParams");
        }
    }
}
