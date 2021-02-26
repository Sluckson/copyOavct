package repack.org.bouncycastle.jce.provider;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.BufferedBlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.InvalidCipherTextException;
import repack.org.bouncycastle.crypto.engines.AESFastEngine;
import repack.org.bouncycastle.crypto.engines.DESEngine;
import repack.org.bouncycastle.crypto.engines.DESedeEngine;
import repack.org.bouncycastle.crypto.engines.GOST28147Engine;
import repack.org.bouncycastle.crypto.engines.RC2Engine;
import repack.org.bouncycastle.crypto.engines.TwofishEngine;
import repack.org.bouncycastle.crypto.modes.AEADBlockCipher;
import repack.org.bouncycastle.crypto.modes.CBCBlockCipher;
import repack.org.bouncycastle.crypto.modes.CCMBlockCipher;
import repack.org.bouncycastle.crypto.modes.CFBBlockCipher;
import repack.org.bouncycastle.crypto.modes.CTSBlockCipher;
import repack.org.bouncycastle.crypto.modes.EAXBlockCipher;
import repack.org.bouncycastle.crypto.modes.GCMBlockCipher;
import repack.org.bouncycastle.crypto.modes.GOFBBlockCipher;
import repack.org.bouncycastle.crypto.modes.OFBBlockCipher;
import repack.org.bouncycastle.crypto.modes.OpenPGPCFBBlockCipher;
import repack.org.bouncycastle.crypto.modes.PGPCFBBlockCipher;
import repack.org.bouncycastle.crypto.modes.SICBlockCipher;
import repack.org.bouncycastle.crypto.paddings.BlockCipherPadding;
import repack.org.bouncycastle.crypto.paddings.ISO10126d2Padding;
import repack.org.bouncycastle.crypto.paddings.ISO7816d4Padding;
import repack.org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import repack.org.bouncycastle.crypto.paddings.TBCPadding;
import repack.org.bouncycastle.crypto.paddings.X923Padding;
import repack.org.bouncycastle.crypto.paddings.ZeroBytePadding;
import repack.org.bouncycastle.crypto.params.ParametersWithIV;
import repack.org.bouncycastle.jce.spec.GOST28147ParameterSpec;
import repack.org.bouncycastle.util.Strings;

public class JCEBlockCipher extends WrapCipherSpi implements PBE {
    private Class[] availableSpecs = {RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class};
    private BlockCipher baseEngine;
    private GenericBlockCipher cipher;
    private int ivLength = 0;
    private ParametersWithIV ivParam;
    private String modeName = null;
    private boolean padded;
    private String pbeAlgorithm = null;
    private PBEParameterSpec pbeSpec = null;

    private interface GenericBlockCipher {
        int doFinal(byte[] bArr, int i) throws IllegalStateException, InvalidCipherTextException;

        String getAlgorithmName();

        int getOutputSize(int i);

        BlockCipher getUnderlyingCipher();

        int getUpdateOutputSize(int i);

        void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException;

        int processByte(byte b, byte[] bArr, int i) throws DataLengthException;

        int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException;

        boolean wrapOnNoPadding();
    }

    protected JCEBlockCipher(BlockCipher blockCipher) {
        this.baseEngine = blockCipher;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
    }

    protected JCEBlockCipher(BlockCipher blockCipher, int i) {
        this.baseEngine = blockCipher;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
        this.ivLength = i / 8;
    }

    protected JCEBlockCipher(BufferedBlockCipher bufferedBlockCipher, int i) {
        this.baseEngine = bufferedBlockCipher.getUnderlyingCipher();
        this.cipher = new BufferedGenericBlockCipher(bufferedBlockCipher);
        this.ivLength = i / 8;
    }

    /* access modifiers changed from: protected */
    public int engineGetBlockSize() {
        return this.baseEngine.getBlockSize();
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
    public int engineGetOutputSize(int i) {
        return this.cipher.getOutputSize(i);
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null) {
            if (this.pbeSpec != null) {
                try {
                    this.engineParams = AlgorithmParameters.getInstance(this.pbeAlgorithm, BouncyCastleProvider.PROVIDER_NAME);
                    this.engineParams.init(this.pbeSpec);
                } catch (Exception unused) {
                    return null;
                }
            } else if (this.ivParam != null) {
                String algorithmName = this.cipher.getUnderlyingCipher().getAlgorithmName();
                if (algorithmName.indexOf(47) >= 0) {
                    algorithmName = algorithmName.substring(0, algorithmName.indexOf(47));
                }
                try {
                    this.engineParams = AlgorithmParameters.getInstance(algorithmName, BouncyCastleProvider.PROVIDER_NAME);
                    this.engineParams.init(this.ivParam.getIV());
                } catch (Exception e) {
                    throw new RuntimeException(e.toString());
                }
            }
        }
        return this.engineParams;
    }

    /* access modifiers changed from: protected */
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        this.modeName = Strings.toUpperCase(str);
        if (this.modeName.equals("ECB")) {
            this.ivLength = 0;
            this.cipher = new BufferedGenericBlockCipher(this.baseEngine);
        } else if (this.modeName.equals("CBC")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher((BlockCipher) new CBCBlockCipher(this.baseEngine));
        } else if (this.modeName.startsWith("OFB")) {
            this.ivLength = this.baseEngine.getBlockSize();
            if (this.modeName.length() != 3) {
                this.cipher = new BufferedGenericBlockCipher((BlockCipher) new OFBBlockCipher(this.baseEngine, Integer.parseInt(this.modeName.substring(3))));
                return;
            }
            BlockCipher blockCipher = this.baseEngine;
            this.cipher = new BufferedGenericBlockCipher((BlockCipher) new OFBBlockCipher(blockCipher, blockCipher.getBlockSize() * 8));
        } else if (this.modeName.startsWith("CFB")) {
            this.ivLength = this.baseEngine.getBlockSize();
            if (this.modeName.length() != 3) {
                this.cipher = new BufferedGenericBlockCipher((BlockCipher) new CFBBlockCipher(this.baseEngine, Integer.parseInt(this.modeName.substring(3))));
                return;
            }
            BlockCipher blockCipher2 = this.baseEngine;
            this.cipher = new BufferedGenericBlockCipher((BlockCipher) new CFBBlockCipher(blockCipher2, blockCipher2.getBlockSize() * 8));
        } else if (this.modeName.startsWith("PGP")) {
            boolean equalsIgnoreCase = this.modeName.equalsIgnoreCase("PGPCFBwithIV");
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher((BlockCipher) new PGPCFBBlockCipher(this.baseEngine, equalsIgnoreCase));
        } else if (this.modeName.equalsIgnoreCase("OpenPGPCFB")) {
            this.ivLength = 0;
            this.cipher = new BufferedGenericBlockCipher((BlockCipher) new OpenPGPCFBBlockCipher(this.baseEngine));
        } else if (this.modeName.startsWith("SIC")) {
            this.ivLength = this.baseEngine.getBlockSize();
            if (this.ivLength >= 16) {
                this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.baseEngine)));
                return;
            }
            throw new IllegalArgumentException("Warning: SIC-Mode can become a twotime-pad if the blocksize of the cipher is too small. Use a cipher with a block size of at least 128 bits (e.g. AES)");
        } else if (this.modeName.startsWith("CTR")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.baseEngine)));
        } else if (this.modeName.startsWith("GOFB")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GOFBBlockCipher(this.baseEngine)));
        } else if (this.modeName.startsWith("CTS")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new BufferedGenericBlockCipher((BufferedBlockCipher) new CTSBlockCipher(new CBCBlockCipher(this.baseEngine)));
        } else if (this.modeName.startsWith("CCM")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new AEADGenericBlockCipher(new CCMBlockCipher(this.baseEngine));
        } else if (this.modeName.startsWith("EAX")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new AEADGenericBlockCipher(new EAXBlockCipher(this.baseEngine));
        } else if (this.modeName.startsWith("GCM")) {
            this.ivLength = this.baseEngine.getBlockSize();
            this.cipher = new AEADGenericBlockCipher(new GCMBlockCipher(this.baseEngine));
        } else {
            throw new NoSuchAlgorithmException("can't support mode " + str);
        }
    }

    /* access modifiers changed from: protected */
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("NOPADDING")) {
            if (this.cipher.wrapOnNoPadding()) {
                this.cipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(this.cipher.getUnderlyingCipher()));
            }
        } else if (upperCase.equals("WITHCTS")) {
            this.cipher = new BufferedGenericBlockCipher((BufferedBlockCipher) new CTSBlockCipher(this.cipher.getUnderlyingCipher()));
        } else {
            this.padded = true;
            if (isAEADModeName(this.modeName)) {
                throw new NoSuchPaddingException("Only NoPadding can be used with AEAD modes.");
            } else if (upperCase.equals("PKCS5PADDING") || upperCase.equals("PKCS7PADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher());
            } else if (upperCase.equals("ZEROBYTEPADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ZeroBytePadding());
            } else if (upperCase.equals("ISO10126PADDING") || upperCase.equals("ISO10126-2PADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO10126d2Padding());
            } else if (upperCase.equals("X9.23PADDING") || upperCase.equals("X923PADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new X923Padding());
            } else if (upperCase.equals("ISO7816-4PADDING") || upperCase.equals("ISO9797-1PADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO7816d4Padding());
            } else if (upperCase.equals("TBCPADDING")) {
                this.cipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new TBCPadding());
            } else {
                throw new NoSuchPaddingException("Padding " + str + " unknown.");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0216 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void engineInit(int r4, java.security.Key r5, java.security.spec.AlgorithmParameterSpec r6, java.security.SecureRandom r7) throws java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r3 = this;
            r0 = 0
            r3.pbeSpec = r0
            r3.pbeAlgorithm = r0
            r3.engineParams = r0
            boolean r0 = r5 instanceof javax.crypto.SecretKey
            if (r0 == 0) goto L_0x029f
            java.lang.String r0 = "RC5-64"
            if (r6 != 0) goto L_0x0024
            repack.org.bouncycastle.crypto.BlockCipher r1 = r3.baseEngine
            java.lang.String r1 = r1.getAlgorithmName()
            boolean r1 = r1.startsWith(r0)
            if (r1 != 0) goto L_0x001c
            goto L_0x0024
        L_0x001c:
            java.security.InvalidAlgorithmParameterException r4 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r5 = "RC5 requires an RC5ParametersSpec to be passed in."
            r4.<init>(r5)
            throw r4
        L_0x0024:
            boolean r1 = r5 instanceof repack.org.bouncycastle.jce.provider.JCEPBEKey
            if (r1 == 0) goto L_0x0084
            repack.org.bouncycastle.jce.provider.JCEPBEKey r5 = (repack.org.bouncycastle.jce.provider.JCEPBEKey) r5
            repack.org.bouncycastle.asn1.DERObjectIdentifier r0 = r5.getOID()
            if (r0 == 0) goto L_0x003b
            repack.org.bouncycastle.asn1.DERObjectIdentifier r0 = r5.getOID()
            java.lang.String r0 = r0.getId()
            r3.pbeAlgorithm = r0
            goto L_0x0041
        L_0x003b:
            java.lang.String r0 = r5.getAlgorithm()
            r3.pbeAlgorithm = r0
        L_0x0041:
            repack.org.bouncycastle.crypto.CipherParameters r0 = r5.getParam()
            if (r0 == 0) goto L_0x005b
            repack.org.bouncycastle.crypto.CipherParameters r6 = r5.getParam()
            javax.crypto.spec.PBEParameterSpec r0 = new javax.crypto.spec.PBEParameterSpec
            byte[] r1 = r5.getSalt()
            int r5 = r5.getIterationCount()
            r0.<init>(r1, r5)
            r3.pbeSpec = r0
            goto L_0x0072
        L_0x005b:
            boolean r0 = r6 instanceof javax.crypto.spec.PBEParameterSpec
            if (r0 == 0) goto L_0x007c
            r0 = r6
            javax.crypto.spec.PBEParameterSpec r0 = (javax.crypto.spec.PBEParameterSpec) r0
            r3.pbeSpec = r0
            repack.org.bouncycastle.jce.provider.JCEBlockCipher$GenericBlockCipher r0 = r3.cipher
            repack.org.bouncycastle.crypto.BlockCipher r0 = r0.getUnderlyingCipher()
            java.lang.String r0 = r0.getAlgorithmName()
            repack.org.bouncycastle.crypto.CipherParameters r6 = repack.org.bouncycastle.jce.provider.PBE.Util.makePBEParameters(r5, r6, r0)
        L_0x0072:
            boolean r5 = r6 instanceof repack.org.bouncycastle.crypto.params.ParametersWithIV
            if (r5 == 0) goto L_0x008f
            r5 = r6
            repack.org.bouncycastle.crypto.params.ParametersWithIV r5 = (repack.org.bouncycastle.crypto.params.ParametersWithIV) r5
            r3.ivParam = r5
            goto L_0x008f
        L_0x007c:
            java.security.InvalidAlgorithmParameterException r4 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r5 = "PBE requires PBE parameters to be set."
            r4.<init>(r5)
            throw r4
        L_0x0084:
            if (r6 != 0) goto L_0x0092
            repack.org.bouncycastle.crypto.params.KeyParameter r6 = new repack.org.bouncycastle.crypto.params.KeyParameter
            byte[] r5 = r5.getEncoded()
            r6.<init>(r5)
        L_0x008f:
            r5 = r6
            goto L_0x0201
        L_0x0092:
            boolean r1 = r6 instanceof javax.crypto.spec.IvParameterSpec
            if (r1 == 0) goto L_0x0100
            int r0 = r3.ivLength
            if (r0 == 0) goto L_0x00e1
            javax.crypto.spec.IvParameterSpec r6 = (javax.crypto.spec.IvParameterSpec) r6
            byte[] r0 = r6.getIV()
            int r0 = r0.length
            int r1 = r3.ivLength
            if (r0 == r1) goto L_0x00c9
            java.lang.String r0 = r3.modeName
            boolean r0 = r3.isAEADModeName(r0)
            if (r0 == 0) goto L_0x00ae
            goto L_0x00c9
        L_0x00ae:
            java.security.InvalidAlgorithmParameterException r4 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "IV must be "
            r5.<init>(r6)
            int r6 = r3.ivLength
            r5.append(r6)
            java.lang.String r6 = " bytes long."
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x00c9:
            repack.org.bouncycastle.crypto.params.ParametersWithIV r0 = new repack.org.bouncycastle.crypto.params.ParametersWithIV
            repack.org.bouncycastle.crypto.params.KeyParameter r1 = new repack.org.bouncycastle.crypto.params.KeyParameter
            byte[] r5 = r5.getEncoded()
            r1.<init>(r5)
            byte[] r5 = r6.getIV()
            r0.<init>(r1, r5)
            r5 = r0
            repack.org.bouncycastle.crypto.params.ParametersWithIV r5 = (repack.org.bouncycastle.crypto.params.ParametersWithIV) r5
            r3.ivParam = r5
            goto L_0x0132
        L_0x00e1:
            java.lang.String r6 = r3.modeName
            if (r6 == 0) goto L_0x00f6
            java.lang.String r0 = "ECB"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00ee
            goto L_0x00f6
        L_0x00ee:
            java.security.InvalidAlgorithmParameterException r4 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r5 = "ECB mode does not use an IV"
            r4.<init>(r5)
            throw r4
        L_0x00f6:
            repack.org.bouncycastle.crypto.params.KeyParameter r6 = new repack.org.bouncycastle.crypto.params.KeyParameter
            byte[] r5 = r5.getEncoded()
            r6.<init>(r5)
            goto L_0x008f
        L_0x0100:
            boolean r1 = r6 instanceof repack.org.bouncycastle.jce.spec.GOST28147ParameterSpec
            if (r1 == 0) goto L_0x0135
            repack.org.bouncycastle.jce.spec.GOST28147ParameterSpec r6 = (repack.org.bouncycastle.jce.spec.GOST28147ParameterSpec) r6
            repack.org.bouncycastle.crypto.params.ParametersWithSBox r0 = new repack.org.bouncycastle.crypto.params.ParametersWithSBox
            repack.org.bouncycastle.crypto.params.KeyParameter r1 = new repack.org.bouncycastle.crypto.params.KeyParameter
            byte[] r5 = r5.getEncoded()
            r1.<init>(r5)
            byte[] r5 = r6.getSbox()
            r0.<init>(r1, r5)
            byte[] r5 = r6.getIV()
            if (r5 == 0) goto L_0x0132
            int r5 = r3.ivLength
            if (r5 == 0) goto L_0x0132
            repack.org.bouncycastle.crypto.params.ParametersWithIV r5 = new repack.org.bouncycastle.crypto.params.ParametersWithIV
            byte[] r6 = r6.getIV()
            r5.<init>(r0, r6)
            r6 = r5
            repack.org.bouncycastle.crypto.params.ParametersWithIV r6 = (repack.org.bouncycastle.crypto.params.ParametersWithIV) r6
            r3.ivParam = r6
            goto L_0x0201
        L_0x0132:
            r5 = r0
            goto L_0x0201
        L_0x0135:
            boolean r1 = r6 instanceof javax.crypto.spec.RC2ParameterSpec
            if (r1 == 0) goto L_0x0162
            javax.crypto.spec.RC2ParameterSpec r6 = (javax.crypto.spec.RC2ParameterSpec) r6
            repack.org.bouncycastle.crypto.params.RC2Parameters r0 = new repack.org.bouncycastle.crypto.params.RC2Parameters
            byte[] r5 = r5.getEncoded()
            int r1 = r6.getEffectiveKeyBits()
            r0.<init>(r5, r1)
            byte[] r5 = r6.getIV()
            if (r5 == 0) goto L_0x0132
            int r5 = r3.ivLength
            if (r5 == 0) goto L_0x0132
            repack.org.bouncycastle.crypto.params.ParametersWithIV r5 = new repack.org.bouncycastle.crypto.params.ParametersWithIV
            byte[] r6 = r6.getIV()
            r5.<init>(r0, r6)
            r6 = r5
            repack.org.bouncycastle.crypto.params.ParametersWithIV r6 = (repack.org.bouncycastle.crypto.params.ParametersWithIV) r6
            r3.ivParam = r6
            goto L_0x0201
        L_0x0162:
            boolean r1 = r6 instanceof javax.crypto.spec.RC5ParameterSpec
            if (r1 == 0) goto L_0x0297
            javax.crypto.spec.RC5ParameterSpec r6 = (javax.crypto.spec.RC5ParameterSpec) r6
            repack.org.bouncycastle.crypto.params.RC5Parameters r1 = new repack.org.bouncycastle.crypto.params.RC5Parameters
            byte[] r5 = r5.getEncoded()
            int r2 = r6.getRounds()
            r1.<init>(r5, r2)
            repack.org.bouncycastle.crypto.BlockCipher r5 = r3.baseEngine
            java.lang.String r5 = r5.getAlgorithmName()
            java.lang.String r2 = "RC5"
            boolean r5 = r5.startsWith(r2)
            if (r5 == 0) goto L_0x028f
            repack.org.bouncycastle.crypto.BlockCipher r5 = r3.baseEngine
            java.lang.String r5 = r5.getAlgorithmName()
            java.lang.String r2 = "RC5-32"
            boolean r5 = r5.equals(r2)
            java.lang.String r2 = "."
            if (r5 == 0) goto L_0x01b7
            int r5 = r6.getWordSize()
            r0 = 32
            if (r5 != r0) goto L_0x019c
            goto L_0x01e7
        L_0x019c:
            java.security.InvalidAlgorithmParameterException r4 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "RC5 already set up for a word size of 32 not "
            r5.<init>(r7)
            int r6 = r6.getWordSize()
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x01b7:
            repack.org.bouncycastle.crypto.BlockCipher r5 = r3.baseEngine
            java.lang.String r5 = r5.getAlgorithmName()
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x01e7
            int r5 = r6.getWordSize()
            r0 = 64
            if (r5 != r0) goto L_0x01cc
            goto L_0x01e7
        L_0x01cc:
            java.security.InvalidAlgorithmParameterException r4 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "RC5 already set up for a word size of 64 not "
            r5.<init>(r7)
            int r6 = r6.getWordSize()
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x01e7:
            byte[] r5 = r6.getIV()
            if (r5 == 0) goto L_0x0200
            int r5 = r3.ivLength
            if (r5 == 0) goto L_0x0200
            repack.org.bouncycastle.crypto.params.ParametersWithIV r5 = new repack.org.bouncycastle.crypto.params.ParametersWithIV
            byte[] r6 = r6.getIV()
            r5.<init>(r1, r6)
            r6 = r5
            repack.org.bouncycastle.crypto.params.ParametersWithIV r6 = (repack.org.bouncycastle.crypto.params.ParametersWithIV) r6
            r3.ivParam = r6
            goto L_0x0201
        L_0x0200:
            r5 = r1
        L_0x0201:
            int r6 = r3.ivLength
            r0 = 3
            r1 = 1
            if (r6 == 0) goto L_0x0246
            boolean r6 = r5 instanceof repack.org.bouncycastle.crypto.params.ParametersWithIV
            if (r6 != 0) goto L_0x0246
            if (r7 != 0) goto L_0x0213
            java.security.SecureRandom r6 = new java.security.SecureRandom
            r6.<init>()
            goto L_0x0214
        L_0x0213:
            r6 = r7
        L_0x0214:
            if (r4 == r1) goto L_0x0234
            if (r4 != r0) goto L_0x0219
            goto L_0x0234
        L_0x0219:
            repack.org.bouncycastle.jce.provider.JCEBlockCipher$GenericBlockCipher r6 = r3.cipher
            repack.org.bouncycastle.crypto.BlockCipher r6 = r6.getUnderlyingCipher()
            java.lang.String r6 = r6.getAlgorithmName()
            java.lang.String r2 = "PGPCFB"
            int r6 = r6.indexOf(r2)
            if (r6 < 0) goto L_0x022c
            goto L_0x0246
        L_0x022c:
            java.security.InvalidAlgorithmParameterException r4 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r5 = "no IV set when one expected"
            r4.<init>(r5)
            throw r4
        L_0x0234:
            int r2 = r3.ivLength
            byte[] r2 = new byte[r2]
            r6.nextBytes(r2)
            repack.org.bouncycastle.crypto.params.ParametersWithIV r6 = new repack.org.bouncycastle.crypto.params.ParametersWithIV
            r6.<init>(r5, r2)
            r5 = r6
            repack.org.bouncycastle.crypto.params.ParametersWithIV r5 = (repack.org.bouncycastle.crypto.params.ParametersWithIV) r5
            r3.ivParam = r5
            r5 = r6
        L_0x0246:
            if (r7 == 0) goto L_0x0252
            boolean r6 = r3.padded
            if (r6 == 0) goto L_0x0252
            repack.org.bouncycastle.crypto.params.ParametersWithRandom r6 = new repack.org.bouncycastle.crypto.params.ParametersWithRandom
            r6.<init>(r5, r7)
            r5 = r6
        L_0x0252:
            if (r4 == r1) goto L_0x027f
            r6 = 2
            if (r4 == r6) goto L_0x0278
            if (r4 == r0) goto L_0x027f
            r6 = 4
            if (r4 != r6) goto L_0x025d
            goto L_0x0278
        L_0x025d:
            java.security.InvalidParameterException r5 = new java.security.InvalidParameterException     // Catch:{ Exception -> 0x0276 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0276 }
            java.lang.String r7 = "unknown opmode "
            r6.<init>(r7)     // Catch:{ Exception -> 0x0276 }
            r6.append(r4)     // Catch:{ Exception -> 0x0276 }
            java.lang.String r4 = " passed"
            r6.append(r4)     // Catch:{ Exception -> 0x0276 }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x0276 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x0276 }
            throw r5     // Catch:{ Exception -> 0x0276 }
        L_0x0276:
            r4 = move-exception
            goto L_0x0285
        L_0x0278:
            repack.org.bouncycastle.jce.provider.JCEBlockCipher$GenericBlockCipher r4 = r3.cipher     // Catch:{ Exception -> 0x0276 }
            r6 = 0
            r4.init(r6, r5)     // Catch:{ Exception -> 0x0276 }
            goto L_0x0284
        L_0x027f:
            repack.org.bouncycastle.jce.provider.JCEBlockCipher$GenericBlockCipher r4 = r3.cipher     // Catch:{ Exception -> 0x0276 }
            r4.init(r1, r5)     // Catch:{ Exception -> 0x0276 }
        L_0x0284:
            return
        L_0x0285:
            java.security.InvalidKeyException r5 = new java.security.InvalidKeyException
            java.lang.String r4 = r4.getMessage()
            r5.<init>(r4)
            throw r5
        L_0x028f:
            java.security.InvalidAlgorithmParameterException r4 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r5 = "RC5 parameters passed to a cipher that is not RC5."
            r4.<init>(r5)
            throw r4
        L_0x0297:
            java.security.InvalidAlgorithmParameterException r4 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r5 = "unknown parameter type."
            r4.<init>(r5)
            throw r4
        L_0x029f:
            java.security.InvalidKeyException r4 = new java.security.InvalidKeyException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Key for algorithm "
            r6.<init>(r7)
            java.lang.String r5 = r5.getAlgorithm()
            r6.append(r5)
            java.lang.String r5 = " not suitable for symmetric enryption."
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.jce.provider.JCEBlockCipher.engineInit(int, java.security.Key, java.security.spec.AlgorithmParameterSpec, java.security.SecureRandom):void");
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
        int updateOutputSize = this.cipher.getUpdateOutputSize(i2);
        if (updateOutputSize > 0) {
            byte[] bArr2 = new byte[updateOutputSize];
            int processBytes = this.cipher.processBytes(bArr, i, i2, bArr2, 0);
            if (processBytes == 0) {
                return null;
            }
            if (processBytes == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[processBytes];
            System.arraycopy(bArr2, 0, bArr3, 0, processBytes);
            return bArr3;
        }
        this.cipher.processBytes(bArr, i, i2, (byte[]) null, 0);
        return null;
    }

    /* access modifiers changed from: protected */
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        try {
            return this.cipher.processBytes(bArr, i, i2, bArr2, i3);
        } catch (DataLengthException e) {
            throw new ShortBufferException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2 = new byte[engineGetOutputSize(i2)];
        int processBytes = i2 != 0 ? this.cipher.processBytes(bArr, i, i2, bArr2, 0) : 0;
        try {
            int doFinal = processBytes + this.cipher.doFinal(bArr2, processBytes);
            if (doFinal == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[doFinal];
            System.arraycopy(bArr2, 0, bArr3, 0, doFinal);
            return bArr3;
        } catch (DataLengthException e) {
            throw new IllegalBlockSizeException(e.getMessage());
        } catch (InvalidCipherTextException e2) {
            throw new BadPaddingException(e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        int processBytes = i2 != 0 ? this.cipher.processBytes(bArr, i, i2, bArr2, i3) : 0;
        try {
            return processBytes + this.cipher.doFinal(bArr2, i3 + processBytes);
        } catch (DataLengthException e) {
            throw new IllegalBlockSizeException(e.getMessage());
        } catch (InvalidCipherTextException e2) {
            throw new BadPaddingException(e2.getMessage());
        }
    }

    private boolean isAEADModeName(String str) {
        return "CCM".equals(str) || "EAX".equals(str) || "GCM".equals(str);
    }

    public static class DES extends JCEBlockCipher {
        public DES() {
            super(new DESEngine());
        }
    }

    public static class DESCBC extends JCEBlockCipher {
        public DESCBC() {
            super((BlockCipher) new CBCBlockCipher(new DESEngine()), 64);
        }
    }

    public static class GOST28147 extends JCEBlockCipher {
        public GOST28147() {
            super(new GOST28147Engine());
        }
    }

    public static class GOST28147cbc extends JCEBlockCipher {
        public GOST28147cbc() {
            super((BlockCipher) new CBCBlockCipher(new GOST28147Engine()), 64);
        }
    }

    public static class RC2 extends JCEBlockCipher {
        public RC2() {
            super(new RC2Engine());
        }
    }

    public static class RC2CBC extends JCEBlockCipher {
        public RC2CBC() {
            super((BlockCipher) new CBCBlockCipher(new RC2Engine()), 64);
        }
    }

    public static class PBEWithMD5AndDES extends JCEBlockCipher {
        public PBEWithMD5AndDES() {
            super(new CBCBlockCipher(new DESEngine()));
        }
    }

    public static class PBEWithMD5AndRC2 extends JCEBlockCipher {
        public PBEWithMD5AndRC2() {
            super(new CBCBlockCipher(new RC2Engine()));
        }
    }

    public static class PBEWithSHA1AndDES extends JCEBlockCipher {
        public PBEWithSHA1AndDES() {
            super(new CBCBlockCipher(new DESEngine()));
        }
    }

    public static class PBEWithSHA1AndRC2 extends JCEBlockCipher {
        public PBEWithSHA1AndRC2() {
            super(new CBCBlockCipher(new RC2Engine()));
        }
    }

    public static class PBEWithSHAAndDES3Key extends JCEBlockCipher {
        public PBEWithSHAAndDES3Key() {
            super(new CBCBlockCipher(new DESedeEngine()));
        }
    }

    public static class PBEWithSHAAndDES2Key extends JCEBlockCipher {
        public PBEWithSHAAndDES2Key() {
            super(new CBCBlockCipher(new DESedeEngine()));
        }
    }

    public static class PBEWithSHAAnd128BitRC2 extends JCEBlockCipher {
        public PBEWithSHAAnd128BitRC2() {
            super(new CBCBlockCipher(new RC2Engine()));
        }
    }

    public static class PBEWithSHAAnd40BitRC2 extends JCEBlockCipher {
        public PBEWithSHAAnd40BitRC2() {
            super(new CBCBlockCipher(new RC2Engine()));
        }
    }

    public static class PBEWithSHAAndTwofish extends JCEBlockCipher {
        public PBEWithSHAAndTwofish() {
            super(new CBCBlockCipher(new TwofishEngine()));
        }
    }

    public static class PBEWithAESCBC extends JCEBlockCipher {
        public PBEWithAESCBC() {
            super(new CBCBlockCipher(new AESFastEngine()));
        }
    }

    private static class BufferedGenericBlockCipher implements GenericBlockCipher {
        private BufferedBlockCipher cipher;

        BufferedGenericBlockCipher(BufferedBlockCipher bufferedBlockCipher) {
            this.cipher = bufferedBlockCipher;
        }

        BufferedGenericBlockCipher(BlockCipher blockCipher) {
            this.cipher = new PaddedBufferedBlockCipher(blockCipher);
        }

        BufferedGenericBlockCipher(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
            this.cipher = new PaddedBufferedBlockCipher(blockCipher, blockCipherPadding);
        }

        public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.cipher.init(z, cipherParameters);
        }

        public boolean wrapOnNoPadding() {
            return !(this.cipher instanceof CTSBlockCipher);
        }

        public String getAlgorithmName() {
            return this.cipher.getUnderlyingCipher().getAlgorithmName();
        }

        public BlockCipher getUnderlyingCipher() {
            return this.cipher.getUnderlyingCipher();
        }

        public int getOutputSize(int i) {
            return this.cipher.getOutputSize(i);
        }

        public int getUpdateOutputSize(int i) {
            return this.cipher.getUpdateOutputSize(i);
        }

        public int processByte(byte b, byte[] bArr, int i) throws DataLengthException {
            return this.cipher.processByte(b, bArr, i);
        }

        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
            return this.cipher.processBytes(bArr, i, i2, bArr2, i3);
        }

        public int doFinal(byte[] bArr, int i) throws IllegalStateException, InvalidCipherTextException {
            return this.cipher.doFinal(bArr, i);
        }
    }

    private static class AEADGenericBlockCipher implements GenericBlockCipher {
        private AEADBlockCipher cipher;

        public boolean wrapOnNoPadding() {
            return false;
        }

        AEADGenericBlockCipher(AEADBlockCipher aEADBlockCipher) {
            this.cipher = aEADBlockCipher;
        }

        public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.cipher.init(z, cipherParameters);
        }

        public String getAlgorithmName() {
            return this.cipher.getUnderlyingCipher().getAlgorithmName();
        }

        public BlockCipher getUnderlyingCipher() {
            return this.cipher.getUnderlyingCipher();
        }

        public int getOutputSize(int i) {
            return this.cipher.getOutputSize(i);
        }

        public int getUpdateOutputSize(int i) {
            return this.cipher.getUpdateOutputSize(i);
        }

        public int processByte(byte b, byte[] bArr, int i) throws DataLengthException {
            return this.cipher.processByte(b, bArr, i);
        }

        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
            return this.cipher.processBytes(bArr, i, i2, bArr2, i3);
        }

        public int doFinal(byte[] bArr, int i) throws IllegalStateException, InvalidCipherTextException {
            return this.cipher.doFinal(bArr, i);
        }
    }
}
