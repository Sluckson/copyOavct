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
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.misc.IDEACBCPar;
import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherKeyGenerator;
import repack.org.bouncycastle.crypto.engines.IDEAEngine;
import repack.org.bouncycastle.crypto.macs.CBCBlockCipherMac;
import repack.org.bouncycastle.crypto.macs.CFBBlockCipherMac;
import repack.org.bouncycastle.crypto.modes.CBCBlockCipher;
import repack.org.bouncycastle.jce.provider.BouncyCastleProvider;
import repack.org.bouncycastle.jce.provider.JCEBlockCipher;
import repack.org.bouncycastle.jce.provider.JCEKeyGenerator;
import repack.org.bouncycastle.jce.provider.JCEMac;
import repack.org.bouncycastle.jce.provider.JCESecretKeyFactory;
import repack.org.bouncycastle.jce.provider.JDKAlgorithmParameterGenerator;
import repack.org.bouncycastle.jce.provider.JDKAlgorithmParameters;

public final class IDEA {
    private IDEA() {
    }

    public static class ECB extends JCEBlockCipher {
        public ECB() {
            super(new IDEAEngine());
        }
    }

    public static class CBC extends JCEBlockCipher {
        public CBC() {
            super((BlockCipher) new CBCBlockCipher(new IDEAEngine()), 64);
        }
    }

    public static class KeyGen extends JCEKeyGenerator {
        public KeyGen() {
            super("IDEA", 128, new CipherKeyGenerator());
        }
    }

    public static class PBEWithSHAAndIDEAKeyGen extends JCESecretKeyFactory.PBEKeyFactory {
        public PBEWithSHAAndIDEAKeyGen() {
            super("PBEwithSHAandIDEA-CBC", (DERObjectIdentifier) null, true, 2, 1, 128, 64);
        }
    }

    public static class PBEWithSHAAndIDEA extends JCEBlockCipher {
        public PBEWithSHAAndIDEA() {
            super(new CBCBlockCipher(new IDEAEngine()));
        }
    }

    public static class AlgParamGen extends JDKAlgorithmParameterGenerator {
        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for IDEA parameter generation.");
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters instance = AlgorithmParameters.getInstance("IDEA", BouncyCastleProvider.PROVIDER_NAME);
                instance.init(new IvParameterSpec(bArr));
                return instance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class AlgParams extends JDKAlgorithmParameters {

        /* renamed from: iv */
        private byte[] f6249iv;

        /* access modifiers changed from: protected */
        public String engineToString() {
            return "IDEA Parameters";
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded() throws IOException {
            return engineGetEncoded("ASN.1");
        }

        /* access modifiers changed from: protected */
        public byte[] engineGetEncoded(String str) throws IOException {
            if (isASN1FormatString(str)) {
                return new IDEACBCPar(engineGetEncoded("RAW")).getEncoded();
            }
            if (!str.equals("RAW")) {
                return null;
            }
            byte[] bArr = this.f6249iv;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }

        /* access modifiers changed from: protected */
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f6249iv);
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to IV parameters object.");
        }

        /* access modifiers changed from: protected */
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.f6249iv = ((IvParameterSpec) algorithmParameterSpec).getIV();
                return;
            }
            throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr) throws IOException {
            this.f6249iv = new byte[bArr.length];
            byte[] bArr2 = this.f6249iv;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        }

        /* access modifiers changed from: protected */
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (str.equals("RAW")) {
                engineInit(bArr);
            } else if (str.equals("ASN.1")) {
                engineInit(new IDEACBCPar((ASN1Sequence) new ASN1InputStream(bArr).readObject()).getIV());
            } else {
                throw new IOException("Unknown parameters format in IV parameters object");
            }
        }
    }

    public static class Mac extends JCEMac {
        public Mac() {
            super(new CBCBlockCipherMac(new IDEAEngine()));
        }
    }

    public static class CFB8Mac extends JCEMac {
        public CFB8Mac() {
            super(new CFBBlockCipherMac(new IDEAEngine()));
        }
    }

    public static class Mappings extends HashMap {
        public Mappings() {
            put("AlgorithmParameterGenerator.IDEA", "org.bouncycastle.jce.provider.symmetric.IDEA$AlgParamGen");
            put("AlgorithmParameterGenerator.1.3.6.1.4.1.188.7.1.1.2", "org.bouncycastle.jce.provider.symmetric.IDEA$AlgParamGen");
            put("AlgorithmParameters.IDEA", "org.bouncycastle.jce.provider.symmetric.IDEA$AlgParams");
            put("AlgorithmParameters.1.3.6.1.4.1.188.7.1.1.2", "org.bouncycastle.jce.provider.symmetric.IDEA$AlgParams");
            put("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA", "PKCS12PBE");
            put("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA", "PKCS12PBE");
            put("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDIDEA-CBC", "PKCS12PBE");
            put("Cipher.IDEA", "org.bouncycastle.jce.provider.symmetric.IDEA$ECB");
            put("Cipher.1.3.6.1.4.1.188.7.1.1.2", "org.bouncycastle.jce.provider.symmetric.IDEA$CBC");
            put("Cipher.PBEWITHSHAANDIDEA-CBC", "org.bouncycastle.jce.provider.symmetric.IDEA$PBEWithSHAAndIDEA");
            put("KeyGenerator.IDEA", "org.bouncycastle.jce.provider.symmetric.IDEA$KeyGen");
            put("KeyGenerator.1.3.6.1.4.1.188.7.1.1.2", "org.bouncycastle.jce.provider.symmetric.IDEA$KeyGen");
            put("SecretKeyFactory.PBEWITHSHAANDIDEA-CBC", "org.bouncycastle.jce.provider.symmetric.IDEA$PBEWithSHAAndIDEAKeyGen");
            put("Mac.IDEAMAC", "org.bouncycastle.jce.provider.symmetric.IDEA$Mac");
            put("Alg.Alias.Mac.IDEA", "IDEAMAC");
            put("Mac.IDEAMAC/CFB8", "org.bouncycastle.jce.provider.symmetric.IDEA$CFB8Mac");
            put("Alg.Alias.Mac.IDEA/CFB8", "IDEAMAC/CFB8");
        }
    }
}
