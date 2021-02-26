package repack.org.bouncycastle.jce.provider;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.PBEParametersGenerator;
import repack.org.bouncycastle.crypto.digests.MD2Digest;
import repack.org.bouncycastle.crypto.digests.MD5Digest;
import repack.org.bouncycastle.crypto.digests.RIPEMD160Digest;
import repack.org.bouncycastle.crypto.digests.SHA1Digest;
import repack.org.bouncycastle.crypto.digests.SHA256Digest;
import repack.org.bouncycastle.crypto.digests.TigerDigest;
import repack.org.bouncycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import repack.org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import repack.org.bouncycastle.crypto.generators.PKCS5S1ParametersGenerator;
import repack.org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import repack.org.bouncycastle.crypto.params.DESParameters;
import repack.org.bouncycastle.crypto.params.KeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithIV;

public interface PBE {
    public static final int MD2 = 5;
    public static final int MD5 = 0;
    public static final int OPENSSL = 3;
    public static final int PKCS12 = 2;
    public static final int PKCS5S1 = 0;
    public static final int PKCS5S2 = 1;
    public static final int RIPEMD160 = 2;
    public static final int SHA1 = 1;
    public static final int SHA256 = 4;
    public static final int TIGER = 3;

    public static class Util {
        private static PBEParametersGenerator makePBEGenerator(int i, int i2) {
            if (i == 0) {
                if (i2 == 0) {
                    return new PKCS5S1ParametersGenerator(new MD5Digest());
                }
                if (i2 == 1) {
                    return new PKCS5S1ParametersGenerator(new SHA1Digest());
                }
                if (i2 == 5) {
                    return new PKCS5S1ParametersGenerator(new MD2Digest());
                }
                throw new IllegalStateException("PKCS5 scheme 1 only supports MD2, MD5 and SHA1.");
            } else if (i == 1) {
                return new PKCS5S2ParametersGenerator();
            } else {
                if (i != 2) {
                    return new OpenSSLPBEParametersGenerator();
                }
                if (i2 == 0) {
                    return new PKCS12ParametersGenerator(new MD5Digest());
                }
                if (i2 == 1) {
                    return new PKCS12ParametersGenerator(new SHA1Digest());
                }
                if (i2 == 2) {
                    return new PKCS12ParametersGenerator(new RIPEMD160Digest());
                }
                if (i2 == 3) {
                    return new PKCS12ParametersGenerator(new TigerDigest());
                }
                if (i2 == 4) {
                    return new PKCS12ParametersGenerator(new SHA256Digest());
                }
                if (i2 == 5) {
                    return new PKCS12ParametersGenerator(new MD2Digest());
                }
                throw new IllegalStateException("unknown digest scheme for PBE encryption.");
            }
        }

        static CipherParameters makePBEParameters(JCEPBEKey jCEPBEKey, AlgorithmParameterSpec algorithmParameterSpec, String str) {
            CipherParameters cipherParameters;
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            PBEParametersGenerator makePBEGenerator = makePBEGenerator(jCEPBEKey.getType(), jCEPBEKey.getDigest());
            byte[] encoded = jCEPBEKey.getEncoded();
            if (jCEPBEKey.shouldTryWrongPKCS12()) {
                encoded = new byte[2];
            }
            makePBEGenerator.init(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            if (jCEPBEKey.getIvSize() != 0) {
                cipherParameters = makePBEGenerator.generateDerivedParameters(jCEPBEKey.getKeySize(), jCEPBEKey.getIvSize());
            } else {
                cipherParameters = makePBEGenerator.generateDerivedParameters(jCEPBEKey.getKeySize());
            }
            if (str.startsWith("DES")) {
                if (cipherParameters instanceof ParametersWithIV) {
                    DESParameters.setOddParity(((KeyParameter) ((ParametersWithIV) cipherParameters).getParameters()).getKey());
                } else {
                    DESParameters.setOddParity(((KeyParameter) cipherParameters).getKey());
                }
            }
            for (int i = 0; i != encoded.length; i++) {
                encoded[i] = 0;
            }
            return cipherParameters;
        }

        static CipherParameters makePBEMacParameters(JCEPBEKey jCEPBEKey, AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            PBEParametersGenerator makePBEGenerator = makePBEGenerator(jCEPBEKey.getType(), jCEPBEKey.getDigest());
            byte[] encoded = jCEPBEKey.getEncoded();
            if (jCEPBEKey.shouldTryWrongPKCS12()) {
                encoded = new byte[2];
            }
            makePBEGenerator.init(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            CipherParameters generateDerivedMacParameters = makePBEGenerator.generateDerivedMacParameters(jCEPBEKey.getKeySize());
            for (int i = 0; i != encoded.length; i++) {
                encoded[i] = 0;
            }
            return generateDerivedMacParameters;
        }

        static CipherParameters makePBEParameters(PBEKeySpec pBEKeySpec, int i, int i2, int i3, int i4) {
            byte[] bArr;
            CipherParameters cipherParameters;
            PBEParametersGenerator makePBEGenerator = makePBEGenerator(i, i2);
            if (i == 2) {
                bArr = PBEParametersGenerator.PKCS12PasswordToBytes(pBEKeySpec.getPassword());
            } else {
                bArr = PBEParametersGenerator.PKCS5PasswordToBytes(pBEKeySpec.getPassword());
            }
            makePBEGenerator.init(bArr, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            if (i4 != 0) {
                cipherParameters = makePBEGenerator.generateDerivedParameters(i3, i4);
            } else {
                cipherParameters = makePBEGenerator.generateDerivedParameters(i3);
            }
            for (int i5 = 0; i5 != bArr.length; i5++) {
                bArr[i5] = 0;
            }
            return cipherParameters;
        }

        static CipherParameters makePBEMacParameters(PBEKeySpec pBEKeySpec, int i, int i2, int i3) {
            byte[] bArr;
            PBEParametersGenerator makePBEGenerator = makePBEGenerator(i, i2);
            if (i == 2) {
                bArr = PBEParametersGenerator.PKCS12PasswordToBytes(pBEKeySpec.getPassword());
            } else {
                bArr = PBEParametersGenerator.PKCS5PasswordToBytes(pBEKeySpec.getPassword());
            }
            makePBEGenerator.init(bArr, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            CipherParameters generateDerivedMacParameters = makePBEGenerator.generateDerivedMacParameters(i3);
            for (int i4 = 0; i4 != bArr.length; i4++) {
                bArr[i4] = 0;
            }
            return generateDerivedMacParameters;
        }
    }
}
