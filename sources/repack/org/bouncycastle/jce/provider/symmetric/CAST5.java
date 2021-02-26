package repack.org.bouncycastle.jce.provider.symmetric;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashMap;
import javax.crypto.spec.IvParameterSpec;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.misc.CAST5CBCParameters;
import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherKeyGenerator;
import repack.org.bouncycastle.crypto.engines.CAST5Engine;
import repack.org.bouncycastle.crypto.modes.CBCBlockCipher;
import repack.org.bouncycastle.jce.provider.BouncyCastleProvider;
import repack.org.bouncycastle.jce.provider.JCEBlockCipher;
import repack.org.bouncycastle.jce.provider.JCEKeyGenerator;
import repack.org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator;
import repack.org.bouncycastle.jce.provider.JDKAlgorithmParameters;

public final class CAST5 {
    private CAST5() {
    }

    public static class ECB extends JCEBlockCipher {
        public ECB() {
            super(new CAST5Engine());
        }
    }

    public static class CBC extends JCEBlockCipher {
        public CBC() {
            super((BlockCipher) new CBCBlockCipher(new CAST5Engine()), 64);
        }
    }

    public static class KeyGen extends JCEKeyGenerator {
        public KeyGen() {
            super("CAST5", 128, new CipherKeyGenerator());
        }
    }

    public static class AlgParamGen extends JDKAlgorithmParameterGenerator {
        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for CAST5 parameter generation.");
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance("CAST5", BouncyCastleProvider.PROVIDER_NAME);
                instance.init(new IvParameterSpec(bArr));
                return instance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class AlgParams extends JDKAlgorithmParameters {

        /* renamed from: iv */
        private byte[] f6248iv;
        private int keyLength = 128;

        /* access modifiers changed from: protected */
        public String engineToString() {
            return "CAST5 Parameters";
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded() {
            byte[] bArr = this.f6248iv;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded(String str) throws IOException {
            if (isASN1FormatString(str)) {
                return new CAST5CBCParameters(engineGetEncoded(), this.keyLength).getEncoded();
            }
            if (str.equals("RAW")) {
                return engineGetEncoded();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f6248iv);
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to CAST5 parameters object.");
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.f6248iv = ((IvParameterSpec) algorithmParameterSpec).getIV();
                return;
            }
            throw new InvalidParameterSpecException("IvParameterSpec required to initialise a CAST5 parameters algorithm parameters object");
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr) throws IOException {
            this.f6248iv = new byte[bArr.length];
            byte[] bArr2 = this.f6248iv;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str)) {
                CAST5CBCParameters instance = CAST5CBCParameters.getInstance(new ASN1InputStream(bArr).readObject());
                this.keyLength = instance.getKeyLength();
                this.f6248iv = instance.getIV();
            } else if (str.equals("RAW")) {
                engineInit(bArr);
            } else {
                throw new IOException("Unknown parameters format in IV parameters object");
            }
        }
    }

    public static class Mappings extends HashMap {
        public Mappings() {
            put("AlgorithmParameters.CAST5", "org.bouncycastle.jce.provider.symmetric.CAST5$AlgParams");
            put("Alg.Alias.AlgorithmParameters.1.2.840.113533.7.66.10", "CAST5");
            put("AlgorithmParameterGenerator.CAST5", "org.bouncycastle.jce.provider.symmetric.CAST5$AlgParamGen");
            put("Alg.Alias.AlgorithmParameterGenerator.1.2.840.113533.7.66.10", "CAST5");
            put("Cipher.CAST5", "org.bouncycastle.jce.provider.symmetric.CAST5$ECB");
            put("Cipher.1.2.840.113533.7.66.10", "org.bouncycastle.jce.provider.symmetric.CAST5$CBC");
            put("KeyGenerator.CAST5", "org.bouncycastle.jce.provider.symmetric.CAST5$KeyGen");
            put("Alg.Alias.KeyGenerator.1.2.840.113533.7.66.10", "CAST5");
        }
    }
}
