package repack.org.bouncycastle.jce.provider;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import repack.org.bouncycastle.asn1.p065x9.X9ObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import repack.org.bouncycastle.crypto.InvalidCipherTextException;
import repack.org.bouncycastle.crypto.Wrapper;
import repack.org.bouncycastle.crypto.engines.RC2WrapEngine;
import repack.org.bouncycastle.crypto.params.KeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithIV;
import repack.org.bouncycastle.jce.provider.PBE;

public abstract class WrapCipherSpi extends CipherSpi implements PBE {
    private Class[] availableSpecs;
    protected AlgorithmParameters engineParams;

    /* renamed from: iv */
    private byte[] f6244iv;
    private int ivSize;
    protected int pbeHash;
    protected int pbeIvSize;
    protected int pbeKeySize;
    protected int pbeType;
    protected Wrapper wrapEngine;

    /* access modifiers changed from: protected */
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        return 0;
    }

    /* access modifiers changed from: protected */
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        return null;
    }

    /* access modifiers changed from: protected */
    public int engineGetBlockSize() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int engineGetOutputSize(int i) {
        return -1;
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    protected WrapCipherSpi() {
        this.availableSpecs = new Class[]{IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class};
        this.pbeType = 2;
        this.pbeHash = 1;
        this.engineParams = null;
        this.wrapEngine = null;
    }

    protected WrapCipherSpi(Wrapper wrapper) {
        this(wrapper, 0);
    }

    protected WrapCipherSpi(Wrapper wrapper, int i) {
        this.availableSpecs = new Class[]{IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class};
        this.pbeType = 2;
        this.pbeHash = 1;
        this.engineParams = null;
        this.wrapEngine = null;
        this.wrapEngine = wrapper;
        this.ivSize = i;
    }

    /* access modifiers changed from: protected */
    public byte[] engineGetIV() {
        return (byte[]) this.f6244iv.clone();
    }

    /* access modifiers changed from: protected */
    public int engineGetKeySize(Key key) {
        return key.getEncoded().length;
    }

    /* access modifiers changed from: protected */
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("can't support mode " + str);
    }

    /* access modifiers changed from: protected */
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        throw new NoSuchPaddingException("Padding " + str + " unknown.");
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithIV parametersWithIV;
        int i2;
        if (key instanceof JCEPBEKey) {
            JCEPBEKey jCEPBEKey = (JCEPBEKey) key;
            if (algorithmParameterSpec instanceof PBEParameterSpec) {
                parametersWithIV = PBE.Util.makePBEParameters(jCEPBEKey, algorithmParameterSpec, this.wrapEngine.getAlgorithmName());
            } else if (jCEPBEKey.getParam() != null) {
                parametersWithIV = jCEPBEKey.getParam();
            } else {
                throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
            }
        } else {
            parametersWithIV = new KeyParameter(key.getEncoded());
        }
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            parametersWithIV = new ParametersWithIV(parametersWithIV, ((IvParameterSpec) algorithmParameterSpec).getIV());
        }
        if ((parametersWithIV instanceof KeyParameter) && (i2 = this.ivSize) != 0) {
            this.f6244iv = new byte[i2];
            secureRandom.nextBytes(this.f6244iv);
            parametersWithIV = new ParametersWithIV(parametersWithIV, this.f6244iv);
        }
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException("engine only valid for wrapping");
        } else if (i == 3) {
            this.wrapEngine.init(true, parametersWithIV);
        } else if (i != 4) {
            System.out.println("eeek!");
        } else {
            this.wrapEngine.init(false, parametersWithIV);
        }
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
        this.engineParams = algorithmParameters;
        engineInit(i, key, algorithmParameterSpec, secureRandom);
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        throw new RuntimeException("not supported for wrapping");
    }

    /* access modifiers changed from: protected */
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        throw new RuntimeException("not supported for wrapping");
    }

    /* access modifiers changed from: protected */
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        byte[] encoded = key.getEncoded();
        if (encoded != null) {
            try {
                if (this.wrapEngine == null) {
                    return engineDoFinal(encoded, 0, encoded.length);
                }
                return this.wrapEngine.wrap(encoded, 0, encoded.length);
            } catch (BadPaddingException e) {
                throw new IllegalBlockSizeException(e.getMessage());
            }
        } else {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
    }

    /* access modifiers changed from: protected */
    public Key engineUnwrap(byte[] bArr, String str, int i) throws InvalidKeyException {
        byte[] bArr2;
        try {
            if (this.wrapEngine == null) {
                bArr2 = engineDoFinal(bArr, 0, bArr.length);
            } else {
                bArr2 = this.wrapEngine.unwrap(bArr, 0, bArr.length);
            }
            if (i == 3) {
                return new SecretKeySpec(bArr2, str);
            }
            if (!str.equals("") || i != 2) {
                try {
                    KeyFactory instance = KeyFactory.getInstance(str, BouncyCastleProvider.PROVIDER_NAME);
                    if (i == 1) {
                        return instance.generatePublic(new X509EncodedKeySpec(bArr2));
                    }
                    if (i == 2) {
                        return instance.generatePrivate(new PKCS8EncodedKeySpec(bArr2));
                    }
                    throw new InvalidKeyException("Unknown key type " + i);
                } catch (NoSuchProviderException e) {
                    throw new InvalidKeyException("Unknown key type " + e.getMessage());
                } catch (NoSuchAlgorithmException e2) {
                    throw new InvalidKeyException("Unknown key type " + e2.getMessage());
                } catch (InvalidKeySpecException e3) {
                    throw new InvalidKeyException("Unknown key type " + e3.getMessage());
                }
            } else {
                try {
                    PrivateKeyInfo privateKeyInfo = new PrivateKeyInfo((ASN1Sequence) new ASN1InputStream(bArr2).readObject());
                    DERObjectIdentifier objectId = privateKeyInfo.getAlgorithmId().getObjectId();
                    if (objectId.equals(X9ObjectIdentifiers.id_ecPublicKey)) {
                        return new JCEECPrivateKey(privateKeyInfo);
                    }
                    if (objectId.equals(CryptoProObjectIdentifiers.gostR3410_94)) {
                        return new JDKGOST3410PrivateKey(privateKeyInfo);
                    }
                    if (objectId.equals(X9ObjectIdentifiers.id_dsa)) {
                        return new JDKDSAPrivateKey(privateKeyInfo);
                    }
                    if (objectId.equals(PKCSObjectIdentifiers.dhKeyAgreement)) {
                        return new JCEDHPrivateKey(privateKeyInfo);
                    }
                    if (objectId.equals(X9ObjectIdentifiers.dhpublicnumber)) {
                        return new JCEDHPrivateKey(privateKeyInfo);
                    }
                    return new JCERSAPrivateCrtKey(privateKeyInfo);
                } catch (Exception unused) {
                    throw new InvalidKeyException("Invalid key encoding.");
                }
            }
        } catch (InvalidCipherTextException e4) {
            throw new InvalidKeyException(e4.getMessage());
        } catch (BadPaddingException e5) {
            throw new InvalidKeyException(e5.getMessage());
        } catch (IllegalBlockSizeException e6) {
            throw new InvalidKeyException(e6.getMessage());
        }
    }

    public static class RC2Wrap extends WrapCipherSpi {
        public RC2Wrap() {
            super(new RC2WrapEngine());
        }
    }
}
