package repack.org.bouncycastle.jce.provider;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.interfaces.DHKey;
import repack.org.bouncycastle.crypto.AsymmetricBlockCipher;
import repack.org.bouncycastle.crypto.BufferedAsymmetricBlockCipher;
import repack.org.bouncycastle.crypto.InvalidCipherTextException;
import repack.org.bouncycastle.crypto.digests.MD5Digest;
import repack.org.bouncycastle.crypto.digests.SHA1Digest;
import repack.org.bouncycastle.crypto.digests.SHA224Digest;
import repack.org.bouncycastle.crypto.digests.SHA256Digest;
import repack.org.bouncycastle.crypto.digests.SHA384Digest;
import repack.org.bouncycastle.crypto.digests.SHA512Digest;
import repack.org.bouncycastle.crypto.encodings.ISO9796d1Encoding;
import repack.org.bouncycastle.crypto.encodings.OAEPEncoding;
import repack.org.bouncycastle.crypto.encodings.PKCS1Encoding;
import repack.org.bouncycastle.crypto.engines.ElGamalEngine;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;
import repack.org.bouncycastle.jce.interfaces.ElGamalKey;
import repack.org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import repack.org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import repack.org.bouncycastle.util.Strings;

public class JCEElGamalCipher extends WrapCipherSpi {
    private BufferedAsymmetricBlockCipher cipher;
    private AlgorithmParameters engineParams;
    private AlgorithmParameterSpec paramSpec;

    /* access modifiers changed from: protected */
    public byte[] engineGetIV() {
        return null;
    }

    public JCEElGamalCipher(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.cipher = new BufferedAsymmetricBlockCipher(asymmetricBlockCipher);
    }

    /* access modifiers changed from: protected */
    public int engineGetBlockSize() {
        return this.cipher.getInputBlockSize();
    }

    /* access modifiers changed from: protected */
    public int engineGetKeySize(Key key) {
        if (key instanceof ElGamalKey) {
            return ((ElGamalKey) key).getParameters().getP().bitLength();
        }
        if (key instanceof DHKey) {
            return ((DHKey) key).getParams().getP().bitLength();
        }
        throw new IllegalArgumentException("not an ElGamal key!");
    }

    /* access modifiers changed from: protected */
    public int engineGetOutputSize(int i) {
        return this.cipher.getOutputBlockSize();
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null && this.paramSpec != null) {
            try {
                this.engineParams = AlgorithmParameters.getInstance("OAEP", "BC");
                this.engineParams.init(this.paramSpec);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.engineParams;
    }

    /* access modifiers changed from: protected */
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        String upperCase = Strings.toUpperCase(str);
        if (!upperCase.equals("NONE") && !upperCase.equals("ECB")) {
            throw new NoSuchAlgorithmException("can't support mode " + str);
        }
    }

    /* access modifiers changed from: protected */
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("NOPADDING")) {
            this.cipher = new BufferedAsymmetricBlockCipher(new ElGamalEngine());
        } else if (upperCase.equals("PKCS1PADDING")) {
            this.cipher = new BufferedAsymmetricBlockCipher(new PKCS1Encoding(new ElGamalEngine()));
        } else if (upperCase.equals("OAEPPADDING")) {
            this.cipher = new BufferedAsymmetricBlockCipher(new OAEPEncoding(new ElGamalEngine()));
        } else if (upperCase.equals("ISO9796-1PADDING")) {
            this.cipher = new BufferedAsymmetricBlockCipher(new ISO9796d1Encoding(new ElGamalEngine()));
        } else if (upperCase.equals("OAEPWITHMD5ANDMGF1PADDING")) {
            this.cipher = new BufferedAsymmetricBlockCipher(new OAEPEncoding(new ElGamalEngine(), new MD5Digest()));
        } else if (upperCase.equals("OAEPWITHSHA1ANDMGF1PADDING")) {
            this.cipher = new BufferedAsymmetricBlockCipher(new OAEPEncoding(new ElGamalEngine(), new SHA1Digest()));
        } else if (upperCase.equals("OAEPWITHSHA224ANDMGF1PADDING")) {
            this.cipher = new BufferedAsymmetricBlockCipher(new OAEPEncoding(new ElGamalEngine(), new SHA224Digest()));
        } else if (upperCase.equals("OAEPWITHSHA256ANDMGF1PADDING")) {
            this.cipher = new BufferedAsymmetricBlockCipher(new OAEPEncoding(new ElGamalEngine(), new SHA256Digest()));
        } else if (upperCase.equals("OAEPWITHSHA384ANDMGF1PADDING")) {
            this.cipher = new BufferedAsymmetricBlockCipher(new OAEPEncoding(new ElGamalEngine(), new SHA384Digest()));
        } else if (upperCase.equals("OAEPWITHSHA512ANDMGF1PADDING")) {
            this.cipher = new BufferedAsymmetricBlockCipher(new OAEPEncoding(new ElGamalEngine(), new SHA512Digest()));
        } else {
            throw new NoSuchPaddingException(String.valueOf(str) + " unavailable with ElGamal.");
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException {
        ParametersWithRandom parametersWithRandom;
        if (algorithmParameterSpec == null) {
            if (key instanceof ElGamalPublicKey) {
                parametersWithRandom = ElGamalUtil.generatePublicKeyParameter((PublicKey) key);
            } else if (key instanceof ElGamalPrivateKey) {
                parametersWithRandom = ElGamalUtil.generatePrivateKeyParameter((PrivateKey) key);
            } else {
                throw new InvalidKeyException("unknown key type passed to ElGamal");
            }
            if (secureRandom != null) {
                parametersWithRandom = new ParametersWithRandom(parametersWithRandom, secureRandom);
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new InvalidParameterException("unknown opmode " + i + " passed to ElGamal");
                        }
                    }
                }
                this.cipher.init(false, parametersWithRandom);
                return;
            }
            this.cipher.init(true, parametersWithRandom);
            return;
        }
        throw new IllegalArgumentException("unknown parameter type.");
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("can't handle parameters in ElGamal");
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
    }

    /* access modifiers changed from: protected */
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.cipher.processBytes(bArr, i, i2);
        return null;
    }

    /* access modifiers changed from: protected */
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.cipher.processBytes(bArr, i, i2);
        return 0;
    }

    /* access modifiers changed from: protected */
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        this.cipher.processBytes(bArr, i, i2);
        try {
            return this.cipher.doFinal();
        } catch (InvalidCipherTextException e) {
            throw new BadPaddingException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        this.cipher.processBytes(bArr, i, i2);
        try {
            byte[] doFinal = this.cipher.doFinal();
            for (int i4 = 0; i4 != doFinal.length; i4++) {
                bArr2[i3 + i4] = doFinal[i4];
            }
            return doFinal.length;
        } catch (InvalidCipherTextException e) {
            throw new BadPaddingException(e.getMessage());
        }
    }

    public static class NoPadding extends JCEElGamalCipher {
        public NoPadding() {
            super(new ElGamalEngine());
        }
    }

    public static class PKCS1v1_5Padding extends JCEElGamalCipher {
        public PKCS1v1_5Padding() {
            super(new PKCS1Encoding(new ElGamalEngine()));
        }
    }
}
