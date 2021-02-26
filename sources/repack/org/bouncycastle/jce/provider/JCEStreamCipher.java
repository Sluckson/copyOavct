package repack.org.bouncycastle.jce.provider;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.StreamBlockCipher;
import repack.org.bouncycastle.crypto.StreamCipher;
import repack.org.bouncycastle.crypto.engines.BlowfishEngine;
import repack.org.bouncycastle.crypto.engines.DESEngine;
import repack.org.bouncycastle.crypto.engines.DESedeEngine;
import repack.org.bouncycastle.crypto.engines.RC4Engine;
import repack.org.bouncycastle.crypto.engines.SkipjackEngine;
import repack.org.bouncycastle.crypto.engines.TwofishEngine;
import repack.org.bouncycastle.crypto.modes.CFBBlockCipher;
import repack.org.bouncycastle.crypto.modes.OFBBlockCipher;
import repack.org.bouncycastle.crypto.params.KeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithIV;
import repack.org.bouncycastle.jce.provider.PBE;

public class JCEStreamCipher extends WrapCipherSpi implements PBE {
    private Class[] availableSpecs = {RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
    private StreamCipher cipher;
    private int ivLength = 0;
    private ParametersWithIV ivParam;
    private String pbeAlgorithm = null;
    private PBEParameterSpec pbeSpec = null;

    /* access modifiers changed from: protected */
    public int engineGetBlockSize() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int engineGetOutputSize(int i) {
        return i;
    }

    protected JCEStreamCipher(StreamCipher streamCipher, int i) {
        this.cipher = streamCipher;
        this.ivLength = i;
    }

    protected JCEStreamCipher(BlockCipher blockCipher, int i) {
        this.ivLength = i;
        this.cipher = new StreamBlockCipher(blockCipher);
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetIV() {
        ParametersWithIV parametersWithIV = this.ivParam;
        if (parametersWithIV != null) {
            return parametersWithIV.getIV();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams != null || this.pbeSpec == null) {
            return this.engineParams;
        }
        try {
            AlgorithmParameters instance = AlgorithmParameters.getInstance(this.pbeAlgorithm, BouncyCastleProvider.PROVIDER_NAME);
            instance.init(this.pbeSpec);
            return instance;
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void engineSetMode(String str) {
        if (!str.equalsIgnoreCase("ECB")) {
            throw new IllegalArgumentException("can't support mode " + str);
        }
    }

    /* access modifiers changed from: protected */
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        if (!str.equalsIgnoreCase("NoPadding")) {
            throw new NoSuchPaddingException("Padding " + str + " unknown.");
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithIV parametersWithIV;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.engineParams = null;
        if (key instanceof SecretKey) {
            if (key instanceof JCEPBEKey) {
                JCEPBEKey jCEPBEKey = (JCEPBEKey) key;
                if (jCEPBEKey.getOID() != null) {
                    this.pbeAlgorithm = jCEPBEKey.getOID().getId();
                } else {
                    this.pbeAlgorithm = jCEPBEKey.getAlgorithm();
                }
                if (jCEPBEKey.getParam() != null) {
                    parametersWithIV = jCEPBEKey.getParam();
                    this.pbeSpec = new PBEParameterSpec(jCEPBEKey.getSalt(), jCEPBEKey.getIterationCount());
                } else if (algorithmParameterSpec instanceof PBEParameterSpec) {
                    CipherParameters makePBEParameters = PBE.Util.makePBEParameters(jCEPBEKey, algorithmParameterSpec, this.cipher.getAlgorithmName());
                    this.pbeSpec = (PBEParameterSpec) algorithmParameterSpec;
                    parametersWithIV = makePBEParameters;
                } else {
                    throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                }
                if (jCEPBEKey.getIvSize() != 0) {
                    this.ivParam = (ParametersWithIV) parametersWithIV;
                }
            } else if (algorithmParameterSpec == null) {
                parametersWithIV = new KeyParameter(key.getEncoded());
            } else if (algorithmParameterSpec instanceof IvParameterSpec) {
                ParametersWithIV parametersWithIV2 = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec) algorithmParameterSpec).getIV());
                this.ivParam = parametersWithIV2;
                parametersWithIV = parametersWithIV2;
            } else {
                throw new IllegalArgumentException("unknown parameter type.");
            }
            if (this.ivLength != 0 && !(parametersWithIV instanceof ParametersWithIV)) {
                if (secureRandom == null) {
                    secureRandom = new SecureRandom();
                }
                if (i == 1 || i == 3) {
                    byte[] bArr = new byte[this.ivLength];
                    secureRandom.nextBytes(bArr);
                    ParametersWithIV parametersWithIV3 = new ParametersWithIV(parametersWithIV, bArr);
                    this.ivParam = parametersWithIV3;
                    parametersWithIV = parametersWithIV3;
                } else {
                    throw new InvalidAlgorithmParameterException("no IV set when one expected");
                }
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            System.out.println("eeek!");
                            return;
                        }
                    }
                }
                this.cipher.init(false, parametersWithIV);
                return;
            }
            this.cipher.init(true, parametersWithIV);
            return;
        }
        throw new InvalidKeyException("Key for algorithm " + key.getAlgorithm() + " not suitable for symmetric enryption.");
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec = null;
        if (algorithmParameters != null) {
            int i2 = 0;
            while (true) {
                Class[] clsArr = this.availableSpecs;
                if (i2 == clsArr.length) {
                    break;
                }
                try {
                    algorithmParameterSpec = algorithmParameters.getParameterSpec(clsArr[i2]);
                    break;
                } catch (Exception unused) {
                    i2++;
                }
            }
            if (algorithmParameterSpec == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        }
        engineInit(i, key, algorithmParameterSpec, secureRandom);
        this.engineParams = algorithmParameters;
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.cipher.processBytes(bArr, i, i2, bArr2, 0);
        return bArr2;
    }

    /* access modifiers changed from: protected */
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        try {
            this.cipher.processBytes(bArr, i, i2, bArr2, i3);
            return i2;
        } catch (DataLengthException e) {
            throw new ShortBufferException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            byte[] engineUpdate = engineUpdate(bArr, i, i2);
            this.cipher.reset();
            return engineUpdate;
        }
        this.cipher.reset();
        return new byte[0];
    }

    /* access modifiers changed from: protected */
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i2 != 0) {
            this.cipher.processBytes(bArr, i, i2, bArr2, i3);
        }
        this.cipher.reset();
        return i2;
    }

    public static class DES_CFB8 extends JCEStreamCipher {
        public DES_CFB8() {
            super((BlockCipher) new CFBBlockCipher(new DESEngine(), 8), 64);
        }
    }

    public static class DESede_CFB8 extends JCEStreamCipher {
        public DESede_CFB8() {
            super((BlockCipher) new CFBBlockCipher(new DESedeEngine(), 8), 64);
        }
    }

    public static class Skipjack_CFB8 extends JCEStreamCipher {
        public Skipjack_CFB8() {
            super((BlockCipher) new CFBBlockCipher(new SkipjackEngine(), 8), 64);
        }
    }

    public static class Blowfish_CFB8 extends JCEStreamCipher {
        public Blowfish_CFB8() {
            super((BlockCipher) new CFBBlockCipher(new BlowfishEngine(), 8), 64);
        }
    }

    public static class Twofish_CFB8 extends JCEStreamCipher {
        public Twofish_CFB8() {
            super((BlockCipher) new CFBBlockCipher(new TwofishEngine(), 8), 128);
        }
    }

    public static class DES_OFB8 extends JCEStreamCipher {
        public DES_OFB8() {
            super((BlockCipher) new OFBBlockCipher(new DESEngine(), 8), 64);
        }
    }

    public static class DESede_OFB8 extends JCEStreamCipher {
        public DESede_OFB8() {
            super((BlockCipher) new OFBBlockCipher(new DESedeEngine(), 8), 64);
        }
    }

    public static class Skipjack_OFB8 extends JCEStreamCipher {
        public Skipjack_OFB8() {
            super((BlockCipher) new OFBBlockCipher(new SkipjackEngine(), 8), 64);
        }
    }

    public static class Blowfish_OFB8 extends JCEStreamCipher {
        public Blowfish_OFB8() {
            super((BlockCipher) new OFBBlockCipher(new BlowfishEngine(), 8), 64);
        }
    }

    public static class Twofish_OFB8 extends JCEStreamCipher {
        public Twofish_OFB8() {
            super((BlockCipher) new OFBBlockCipher(new TwofishEngine(), 8), 128);
        }
    }

    public static class PBEWithSHAAnd128BitRC4 extends JCEStreamCipher {
        public PBEWithSHAAnd128BitRC4() {
            super((StreamCipher) new RC4Engine(), 0);
        }
    }

    public static class PBEWithSHAAnd40BitRC4 extends JCEStreamCipher {
        public PBEWithSHAAnd40BitRC4() {
            super((StreamCipher) new RC4Engine(), 0);
        }
    }
}
