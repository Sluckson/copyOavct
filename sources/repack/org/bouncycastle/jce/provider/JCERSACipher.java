package repack.org.bouncycastle.jce.provider;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import repack.org.bouncycastle.crypto.AsymmetricBlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
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
import repack.org.bouncycastle.crypto.engines.RSAEngine;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;
import repack.org.bouncycastle.crypto.params.RSAKeyParameters;
import repack.org.bouncycastle.util.Strings;

public class JCERSACipher extends WrapCipherSpi {
    private ByteArrayOutputStream bOut = new ByteArrayOutputStream();
    private AsymmetricBlockCipher cipher;
    private AlgorithmParameters engineParams;
    private AlgorithmParameterSpec paramSpec;
    private boolean privateKeyOnly = false;
    private boolean publicKeyOnly = false;

    /* access modifiers changed from: protected */
    public byte[] engineGetIV() {
        return null;
    }

    public JCERSACipher(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.cipher = asymmetricBlockCipher;
    }

    public JCERSACipher(boolean z, boolean z2, AsymmetricBlockCipher asymmetricBlockCipher) {
        this.publicKeyOnly = z;
        this.privateKeyOnly = z2;
        this.cipher = asymmetricBlockCipher;
    }

    /* access modifiers changed from: protected */
    public int engineGetBlockSize() {
        try {
            return this.cipher.getInputBlockSize();
        } catch (NullPointerException unused) {
            throw new IllegalStateException("RSA Cipher not initialised");
        }
    }

    /* access modifiers changed from: protected */
    public int engineGetKeySize(Key key) {
        if (key instanceof RSAPrivateKey) {
            return ((RSAPrivateKey) key).getModulus().bitLength();
        }
        if (key instanceof RSAPublicKey) {
            return ((RSAPublicKey) key).getModulus().bitLength();
        }
        throw new IllegalArgumentException("not an RSA key!");
    }

    /* access modifiers changed from: protected */
    public int engineGetOutputSize(int i) {
        try {
            return this.cipher.getOutputBlockSize();
        } catch (NullPointerException unused) {
            throw new IllegalStateException("RSA Cipher not initialised");
        }
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
            if (upperCase.equals(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE)) {
                this.privateKeyOnly = true;
                this.publicKeyOnly = false;
            } else if (upperCase.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                this.privateKeyOnly = false;
                this.publicKeyOnly = true;
            } else {
                throw new NoSuchAlgorithmException("can't support mode " + str);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("NOPADDING")) {
            this.cipher = new RSAEngine();
        } else if (upperCase.equals("PKCS1PADDING")) {
            this.cipher = new PKCS1Encoding(new RSAEngine());
        } else if (upperCase.equals("OAEPPADDING")) {
            this.cipher = new OAEPEncoding(new RSAEngine());
        } else if (upperCase.equals("ISO9796-1PADDING")) {
            this.cipher = new ISO9796d1Encoding(new RSAEngine());
        } else if (upperCase.equals("OAEPWITHMD5ANDMGF1PADDING")) {
            this.cipher = new OAEPEncoding(new RSAEngine(), new MD5Digest());
        } else if (upperCase.equals("OAEPWITHSHA1ANDMGF1PADDING")) {
            this.cipher = new OAEPEncoding(new RSAEngine(), new SHA1Digest());
        } else if (upperCase.equals("OAEPWITHSHA224ANDMGF1PADDING")) {
            this.cipher = new OAEPEncoding(new RSAEngine(), new SHA224Digest());
        } else if (upperCase.equals("OAEPWITHSHA256ANDMGF1PADDING")) {
            this.cipher = new OAEPEncoding(new RSAEngine(), new SHA256Digest());
        } else if (upperCase.equals("OAEPWITHSHA384ANDMGF1PADDING")) {
            this.cipher = new OAEPEncoding(new RSAEngine(), new SHA384Digest());
        } else if (upperCase.equals("OAEPWITHSHA512ANDMGF1PADDING")) {
            this.cipher = new OAEPEncoding(new RSAEngine(), new SHA512Digest());
        } else {
            throw new NoSuchPaddingException(String.valueOf(str) + " unavailable with RSA.");
        }
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException {
        RSAKeyParameters rSAKeyParameters;
        CipherParameters cipherParameters;
        if (algorithmParameterSpec == null) {
            if (key instanceof RSAPublicKey) {
                if (!this.privateKeyOnly) {
                    rSAKeyParameters = RSAUtil.generatePublicKeyParameter((RSAPublicKey) key);
                } else {
                    throw new InvalidKeyException("mode 1 requires RSAPrivateKey");
                }
            } else if (!(key instanceof RSAPrivateKey)) {
                throw new InvalidKeyException("unknown key type passed to RSA");
            } else if (!this.publicKeyOnly) {
                rSAKeyParameters = RSAUtil.generatePrivateKeyParameter((RSAPrivateKey) key);
            } else {
                throw new InvalidKeyException("mode 2 requires RSAPublicKey");
            }
            if (!(this.cipher instanceof RSAEngine)) {
                cipherParameters = secureRandom != null ? new ParametersWithRandom(rSAKeyParameters, secureRandom) : new ParametersWithRandom(rSAKeyParameters, new SecureRandom());
            } else {
                cipherParameters = rSAKeyParameters;
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
                this.cipher.init(false, cipherParameters);
                return;
            }
            this.cipher.init(true, cipherParameters);
            return;
        }
        throw new IllegalArgumentException("unknown parameter type.");
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("can't handle parameters in RSA");
    }

    /* access modifiers changed from: protected */
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
    }

    /* access modifiers changed from: protected */
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.bOut.write(bArr, i, i2);
        if (this.cipher instanceof RSAEngine) {
            if (this.bOut.size() <= this.cipher.getInputBlockSize() + 1) {
                return null;
            }
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        } else if (this.bOut.size() <= this.cipher.getInputBlockSize()) {
            return null;
        } else {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
    }

    /* access modifiers changed from: protected */
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.bOut.write(bArr, i, i2);
        if (this.cipher instanceof RSAEngine) {
            if (this.bOut.size() <= this.cipher.getInputBlockSize() + 1) {
                return 0;
            }
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        } else if (this.bOut.size() <= this.cipher.getInputBlockSize()) {
            return 0;
        } else {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
    }

    /* access modifiers changed from: protected */
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        if (bArr != null) {
            this.bOut.write(bArr, i, i2);
        }
        if (this.cipher instanceof RSAEngine) {
            if (this.bOut.size() > this.cipher.getInputBlockSize() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
        } else if (this.bOut.size() > this.cipher.getInputBlockSize()) {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        try {
            byte[] byteArray = this.bOut.toByteArray();
            this.bOut.reset();
            return this.cipher.processBlock(byteArray, 0, byteArray.length);
        } catch (InvalidCipherTextException e) {
            throw new BadPaddingException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        if (bArr != null) {
            this.bOut.write(bArr, i, i2);
        }
        if (this.cipher instanceof RSAEngine) {
            if (this.bOut.size() > this.cipher.getInputBlockSize() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
        } else if (this.bOut.size() > this.cipher.getInputBlockSize()) {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        try {
            byte[] byteArray = this.bOut.toByteArray();
            this.bOut.reset();
            byte[] processBlock = this.cipher.processBlock(byteArray, 0, byteArray.length);
            for (int i4 = 0; i4 != processBlock.length; i4++) {
                bArr2[i3 + i4] = processBlock[i4];
            }
            return processBlock.length;
        } catch (InvalidCipherTextException e) {
            throw new BadPaddingException(e.getMessage());
        }
    }

    public static class NoPadding extends JCERSACipher {
        public NoPadding() {
            super(new RSAEngine());
        }
    }

    public static class PKCS1v1_5Padding extends JCERSACipher {
        public PKCS1v1_5Padding() {
            super(new PKCS1Encoding(new RSAEngine()));
        }
    }

    public static class PKCS1v1_5Padding_PrivateOnly extends JCERSACipher {
        public PKCS1v1_5Padding_PrivateOnly() {
            super(false, true, new PKCS1Encoding(new RSAEngine()));
        }
    }

    public static class PKCS1v1_5Padding_PublicOnly extends JCERSACipher {
        public PKCS1v1_5Padding_PublicOnly() {
            super(true, false, new PKCS1Encoding(new RSAEngine()));
        }
    }

    public static class OAEPPadding extends JCERSACipher {
        public OAEPPadding() {
            super(new OAEPEncoding(new RSAEngine()));
        }
    }

    public static class ISO9796d1Padding extends JCERSACipher {
        public ISO9796d1Padding() {
            super(new ISO9796d1Encoding(new RSAEngine()));
        }
    }
}
