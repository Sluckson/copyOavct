package repack.org.bouncycastle.jce.provider.symmetric;

import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.HashMap;
import javax.crypto.SecretKey;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.KeyGenerationParameters;
import repack.org.bouncycastle.crypto.engines.DESedeEngine;
import repack.org.bouncycastle.crypto.engines.DESedeWrapEngine;
import repack.org.bouncycastle.crypto.engines.RFC3211WrapEngine;
import repack.org.bouncycastle.crypto.generators.DESedeKeyGenerator;
import repack.org.bouncycastle.crypto.macs.CBCBlockCipherMac;
import repack.org.bouncycastle.crypto.macs.CFBBlockCipherMac;
import repack.org.bouncycastle.crypto.macs.CMac;
import repack.org.bouncycastle.crypto.modes.CBCBlockCipher;
import repack.org.bouncycastle.crypto.paddings.ISO7816d4Padding;
import repack.org.bouncycastle.jce.provider.JCEBlockCipher;
import repack.org.bouncycastle.jce.provider.JCEKeyGenerator;
import repack.org.bouncycastle.jce.provider.JCEMac;
import repack.org.bouncycastle.jce.provider.JCESecretKeyFactory;
import repack.org.bouncycastle.jce.provider.WrapCipherSpi;

public final class DESede {
    private DESede() {
    }

    public static class ECB extends JCEBlockCipher {
        public ECB() {
            super(new DESedeEngine());
        }
    }

    public static class CBC extends JCEBlockCipher {
        public CBC() {
            super((BlockCipher) new CBCBlockCipher(new DESedeEngine()), 64);
        }
    }

    public static class DESedeCFB8 extends JCEMac {
        public DESedeCFB8() {
            super(new CFBBlockCipherMac(new DESedeEngine()));
        }
    }

    public static class DESede64 extends JCEMac {
        public DESede64() {
            super(new CBCBlockCipherMac((BlockCipher) new DESedeEngine(), 64));
        }
    }

    public static class DESede64with7816d4 extends JCEMac {
        public DESede64with7816d4() {
            super(new CBCBlockCipherMac(new DESedeEngine(), 64, new ISO7816d4Padding()));
        }
    }

    public static class CBCMAC extends JCEMac {
        public CBCMAC() {
            super(new CBCBlockCipherMac(new DESedeEngine()));
        }
    }

    public static class CMAC extends JCEMac {
        public CMAC() {
            super(new CMac(new DESedeEngine()));
        }
    }

    public static class Wrap extends WrapCipherSpi {
        public Wrap() {
            super(new DESedeWrapEngine());
        }
    }

    public static class RFC3211 extends WrapCipherSpi {
        public RFC3211() {
            super(new RFC3211WrapEngine(new DESedeEngine()), 8);
        }
    }

    public static class KeyGenerator extends JCEKeyGenerator {
        private boolean keySizeSet = false;

        public KeyGenerator() {
            super("DESede", PsExtractor.AUDIO_STREAM, new DESedeKeyGenerator());
        }

        /* access modifiers changed from: protected */
        public void engineInit(int i, SecureRandom secureRandom) {
            super.engineInit(i, secureRandom);
            this.keySizeSet = true;
        }

        /* access modifiers changed from: protected */
        public SecretKey engineGenerateKey() {
            if (this.uninitialised) {
                this.engine.init(new KeyGenerationParameters(new SecureRandom(), this.defaultKeySize));
                this.uninitialised = false;
            }
            if (this.keySizeSet) {
                return new SecretKeySpec(this.engine.generateKey(), this.algName);
            }
            byte[] generateKey = this.engine.generateKey();
            System.arraycopy(generateKey, 0, generateKey, 16, 8);
            return new SecretKeySpec(generateKey, this.algName);
        }
    }

    public static class KeyGenerator3 extends JCEKeyGenerator {
        public KeyGenerator3() {
            super("DESede3", PsExtractor.AUDIO_STREAM, new DESedeKeyGenerator());
        }
    }

    public static class KeyFactory extends JCESecretKeyFactory {
        public KeyFactory() {
            super("DESede", (DERObjectIdentifier) null);
        }

        /* access modifiers changed from: protected */
        public KeySpec engineGetKeySpec(SecretKey secretKey, Class cls) throws InvalidKeySpecException {
            if (cls == null) {
                throw new InvalidKeySpecException("keySpec parameter is null");
            } else if (secretKey == null) {
                throw new InvalidKeySpecException("key parameter is null");
            } else if (SecretKeySpec.class.isAssignableFrom(cls)) {
                return new SecretKeySpec(secretKey.getEncoded(), this.algName);
            } else {
                if (DESedeKeySpec.class.isAssignableFrom(cls)) {
                    byte[] encoded = secretKey.getEncoded();
                    try {
                        if (encoded.length != 16) {
                            return new DESedeKeySpec(encoded);
                        }
                        byte[] bArr = new byte[24];
                        System.arraycopy(encoded, 0, bArr, 0, 16);
                        System.arraycopy(encoded, 0, bArr, 16, 8);
                        return new DESedeKeySpec(bArr);
                    } catch (Exception e) {
                        throw new InvalidKeySpecException(e.toString());
                    }
                } else {
                    throw new InvalidKeySpecException("Invalid KeySpec");
                }
            }
        }

        /* access modifiers changed from: protected */
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (keySpec instanceof DESedeKeySpec) {
                return new SecretKeySpec(((DESedeKeySpec) keySpec).getKey(), "DESede");
            }
            return super.engineGenerateSecret(keySpec);
        }
    }

    public static class Mappings extends HashMap {
        public Mappings() {
            put("Cipher.DESEDE", "org.bouncycastle.jce.provider.symmetric.DESede$ECB");
            put("Cipher." + PKCSObjectIdentifiers.des_EDE3_CBC, "org.bouncycastle.jce.provider.symmetric.DESede$CBC");
            put("Cipher." + OIWObjectIdentifiers.desCBC, "org.bouncycastle.jce.provider.symmetric.DESede$CBC");
            put("Cipher.DESEDEWRAP", "org.bouncycastle.jce.provider.symmetric.DESede$Wrap");
            put("Cipher." + PKCSObjectIdentifiers.id_alg_CMS3DESwrap, "org.bouncycastle.jce.provider.symmetric.DESede$Wrap");
            put("Cipher.DESEDERFC3211WRAP", "org.bouncycastle.jce.provider.symmetric.DESede$RFC3211");
            put("KeyGenerator.DESEDE", "org.bouncycastle.jce.provider.symmetric.DESede$KeyGenerator");
            put("KeyGenerator." + PKCSObjectIdentifiers.des_EDE3_CBC, "org.bouncycastle.jce.provider.symmetric.DESede$KeyGenerator3");
            put("KeyGenerator.DESEDEWRAP", "org.bouncycastle.jce.provider.symmetric.DESede$KeyGenerator");
            put("SecretKeyFactory.DESEDE", "org.bouncycastle.jce.provider.symmetric.DESede$KeyFactory");
            put("Mac.DESEDECMAC", "org.bouncycastle.jce.provider.symmetric.DESede$CMAC");
            put("Mac.DESEDEMAC", "org.bouncycastle.jce.provider.symmetric.DESede$CBCMAC");
            put("Alg.Alias.Mac.DESEDE", "DESEDEMAC");
            put("Mac.DESEDEMAC/CFB8", "org.bouncycastle.jce.provider.symmetric.DESede$DESedeCFB8");
            put("Alg.Alias.Mac.DESEDE/CFB8", "DESEDEMAC/CFB8");
            put("Mac.DESEDEMAC64", "org.bouncycastle.jce.provider.symmetric.DESede$DESede64");
            put("Alg.Alias.Mac.DESEDE64", "DESEDEMAC64");
            put("Mac.DESEDEMAC64WITHISO7816-4PADDING", "org.bouncycastle.jce.provider.symmetric.DESede$DESede64with7816d4");
            put("Alg.Alias.Mac.DESEDE64WITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
            put("Alg.Alias.Mac.DESEDEISO9797ALG1MACWITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
            put("Alg.Alias.Mac.DESEDEISO9797ALG1WITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
        }
    }
}
