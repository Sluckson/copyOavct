package repack.org.bouncycastle.jce.provider;

import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.MacSpi;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.Mac;
import repack.org.bouncycastle.crypto.digests.MD2Digest;
import repack.org.bouncycastle.crypto.digests.MD4Digest;
import repack.org.bouncycastle.crypto.digests.MD5Digest;
import repack.org.bouncycastle.crypto.digests.RIPEMD128Digest;
import repack.org.bouncycastle.crypto.digests.RIPEMD160Digest;
import repack.org.bouncycastle.crypto.digests.SHA1Digest;
import repack.org.bouncycastle.crypto.digests.SHA224Digest;
import repack.org.bouncycastle.crypto.digests.SHA256Digest;
import repack.org.bouncycastle.crypto.digests.SHA384Digest;
import repack.org.bouncycastle.crypto.digests.SHA512Digest;
import repack.org.bouncycastle.crypto.digests.TigerDigest;
import repack.org.bouncycastle.crypto.engines.DESEngine;
import repack.org.bouncycastle.crypto.engines.RC2Engine;
import repack.org.bouncycastle.crypto.macs.CBCBlockCipherMac;
import repack.org.bouncycastle.crypto.macs.CFBBlockCipherMac;
import repack.org.bouncycastle.crypto.macs.GOST28147Mac;
import repack.org.bouncycastle.crypto.macs.HMac;
import repack.org.bouncycastle.crypto.macs.ISO9797Alg3Mac;
import repack.org.bouncycastle.crypto.macs.OldHMac;
import repack.org.bouncycastle.crypto.paddings.BlockCipherPadding;
import repack.org.bouncycastle.crypto.paddings.ISO7816d4Padding;
import repack.org.bouncycastle.crypto.params.KeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithIV;
import repack.org.bouncycastle.jce.provider.PBE;

public class JCEMac extends MacSpi implements PBE {
    private int keySize = 160;
    private Mac macEngine;
    private int pbeHash = 1;
    private int pbeType = 2;

    protected JCEMac(Mac mac) {
        this.macEngine = mac;
    }

    protected JCEMac(Mac mac, int i, int i2, int i3) {
        this.macEngine = mac;
        this.pbeType = i;
        this.pbeHash = i2;
        this.keySize = i3;
    }

    /* access modifiers changed from: protected */
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        CipherParameters cipherParameters;
        if (key != null) {
            if (key instanceof JCEPBEKey) {
                JCEPBEKey jCEPBEKey = (JCEPBEKey) key;
                if (jCEPBEKey.getParam() != null) {
                    cipherParameters = jCEPBEKey.getParam();
                } else if (algorithmParameterSpec instanceof PBEParameterSpec) {
                    cipherParameters = PBE.Util.makePBEMacParameters(jCEPBEKey, algorithmParameterSpec);
                } else {
                    throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                }
            } else if (algorithmParameterSpec instanceof IvParameterSpec) {
                cipherParameters = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec) algorithmParameterSpec).getIV());
            } else if (algorithmParameterSpec == null) {
                cipherParameters = new KeyParameter(key.getEncoded());
            } else {
                throw new InvalidAlgorithmParameterException("unknown parameter type.");
            }
            this.macEngine.init(cipherParameters);
            return;
        }
        throw new InvalidKeyException("key is null");
    }

    /* access modifiers changed from: protected */
    public int engineGetMacLength() {
        return this.macEngine.getMacSize();
    }

    /* access modifiers changed from: protected */
    public void engineReset() {
        this.macEngine.reset();
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte b) {
        this.macEngine.update(b);
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.macEngine.update(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public byte[] engineDoFinal() {
        byte[] bArr = new byte[engineGetMacLength()];
        this.macEngine.doFinal(bArr, 0);
        return bArr;
    }

    public static class DES extends JCEMac {
        public DES() {
            super(new CBCBlockCipherMac(new DESEngine()));
        }
    }

    public static class RC2 extends JCEMac {
        public RC2() {
            super(new CBCBlockCipherMac(new RC2Engine()));
        }
    }

    public static class GOST28147 extends JCEMac {
        public GOST28147() {
            super(new GOST28147Mac());
        }
    }

    public static class DESCFB8 extends JCEMac {
        public DESCFB8() {
            super(new CFBBlockCipherMac(new DESEngine()));
        }
    }

    public static class RC2CFB8 extends JCEMac {
        public RC2CFB8() {
            super(new CFBBlockCipherMac(new RC2Engine()));
        }
    }

    public static class DES9797Alg3with7816d4 extends JCEMac {
        public DES9797Alg3with7816d4() {
            super(new ISO9797Alg3Mac((BlockCipher) new DESEngine(), (BlockCipherPadding) new ISO7816d4Padding()));
        }
    }

    public static class DES9797Alg3 extends JCEMac {
        public DES9797Alg3() {
            super(new ISO9797Alg3Mac(new DESEngine()));
        }
    }

    public static class MD2 extends JCEMac {
        public MD2() {
            super(new HMac(new MD2Digest()));
        }
    }

    public static class MD4 extends JCEMac {
        public MD4() {
            super(new HMac(new MD4Digest()));
        }
    }

    public static class MD5 extends JCEMac {
        public MD5() {
            super(new HMac(new MD5Digest()));
        }
    }

    public static class SHA1 extends JCEMac {
        public SHA1() {
            super(new HMac(new SHA1Digest()));
        }
    }

    public static class SHA224 extends JCEMac {
        public SHA224() {
            super(new HMac(new SHA224Digest()));
        }
    }

    public static class SHA256 extends JCEMac {
        public SHA256() {
            super(new HMac(new SHA256Digest()));
        }
    }

    public static class SHA384 extends JCEMac {
        public SHA384() {
            super(new HMac(new SHA384Digest()));
        }
    }

    public static class OldSHA384 extends JCEMac {
        public OldSHA384() {
            super(new OldHMac(new SHA384Digest()));
        }
    }

    public static class SHA512 extends JCEMac {
        public SHA512() {
            super(new HMac(new SHA512Digest()));
        }
    }

    public static class OldSHA512 extends JCEMac {
        public OldSHA512() {
            super(new OldHMac(new SHA512Digest()));
        }
    }

    public static class RIPEMD128 extends JCEMac {
        public RIPEMD128() {
            super(new HMac(new RIPEMD128Digest()));
        }
    }

    public static class RIPEMD160 extends JCEMac {
        public RIPEMD160() {
            super(new HMac(new RIPEMD160Digest()));
        }
    }

    public static class Tiger extends JCEMac {
        public Tiger() {
            super(new HMac(new TigerDigest()));
        }
    }

    public static class PBEWithRIPEMD160 extends JCEMac {
        public PBEWithRIPEMD160() {
            super(new HMac(new RIPEMD160Digest()), 2, 2, 160);
        }
    }

    public static class PBEWithSHA extends JCEMac {
        public PBEWithSHA() {
            super(new HMac(new SHA1Digest()), 2, 1, 160);
        }
    }

    public static class PBEWithTiger extends JCEMac {
        public PBEWithTiger() {
            super(new HMac(new TigerDigest()), 2, 3, PsExtractor.AUDIO_STREAM);
        }
    }
}
