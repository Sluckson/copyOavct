package repack.org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.DigestInfo;
import repack.org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import repack.org.bouncycastle.crypto.AsymmetricBlockCipher;
import repack.org.bouncycastle.crypto.Digest;
import repack.org.bouncycastle.crypto.digests.MD2Digest;
import repack.org.bouncycastle.crypto.digests.MD4Digest;
import repack.org.bouncycastle.crypto.digests.MD5Digest;
import repack.org.bouncycastle.crypto.digests.NullDigest;
import repack.org.bouncycastle.crypto.digests.RIPEMD128Digest;
import repack.org.bouncycastle.crypto.digests.RIPEMD160Digest;
import repack.org.bouncycastle.crypto.digests.RIPEMD256Digest;
import repack.org.bouncycastle.crypto.digests.SHA1Digest;
import repack.org.bouncycastle.crypto.digests.SHA224Digest;
import repack.org.bouncycastle.crypto.digests.SHA256Digest;
import repack.org.bouncycastle.crypto.digests.SHA384Digest;
import repack.org.bouncycastle.crypto.digests.SHA512Digest;
import repack.org.bouncycastle.crypto.encodings.PKCS1Encoding;
import repack.org.bouncycastle.crypto.engines.RSABlindedEngine;
import repack.org.bouncycastle.crypto.params.RSAKeyParameters;

public class JDKDigestSignature extends SignatureSpi {
    private AlgorithmIdentifier algId;
    private AsymmetricBlockCipher cipher;
    private Digest digest;

    /* access modifiers changed from: protected */
    public Object engineGetParameter(String str) {
        return null;
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    protected JDKDigestSignature(Digest digest2, AsymmetricBlockCipher asymmetricBlockCipher) {
        this.digest = digest2;
        this.cipher = asymmetricBlockCipher;
        this.algId = null;
    }

    protected JDKDigestSignature(DERObjectIdentifier dERObjectIdentifier, Digest digest2, AsymmetricBlockCipher asymmetricBlockCipher) {
        this.digest = digest2;
        this.cipher = asymmetricBlockCipher;
        this.algId = new AlgorithmIdentifier(dERObjectIdentifier, DERNull.INSTANCE);
    }

    /* access modifiers changed from: protected */
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof RSAPublicKey) {
            RSAKeyParameters generatePublicKeyParameter = RSAUtil.generatePublicKeyParameter((RSAPublicKey) publicKey);
            this.digest.reset();
            this.cipher.init(false, generatePublicKeyParameter);
            return;
        }
        throw new InvalidKeyException("Supplied key (" + getType(publicKey) + ") is not a RSAPublicKey instance");
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof RSAPrivateKey) {
            RSAKeyParameters generatePrivateKeyParameter = RSAUtil.generatePrivateKeyParameter((RSAPrivateKey) privateKey);
            this.digest.reset();
            this.cipher.init(true, generatePrivateKeyParameter);
            return;
        }
        throw new InvalidKeyException("Supplied key (" + getType(privateKey) + ") is not a RSAPrivateKey instance");
    }

    private String getType(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.getClass().getName();
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte b) throws SignatureException {
        this.digest.update(b);
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.digest.update(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public byte[] engineSign() throws SignatureException {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        try {
            byte[] derEncode = derEncode(bArr);
            return this.cipher.processBlock(derEncode, 0, derEncode.length);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new SignatureException("key too small for signature type");
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr2, 0);
        try {
            byte[] processBlock = this.cipher.processBlock(bArr, 0, bArr.length);
            byte[] derEncode = derEncode(bArr2);
            if (processBlock.length == derEncode.length) {
                for (int i = 0; i < processBlock.length; i++) {
                    if (processBlock[i] != derEncode[i]) {
                        return false;
                    }
                }
            } else {
                if (processBlock.length == derEncode.length - 2) {
                    int length = (processBlock.length - bArr2.length) - 2;
                    int length2 = (derEncode.length - bArr2.length) - 2;
                    derEncode[1] = (byte) (derEncode[1] - 2);
                    derEncode[3] = (byte) (derEncode[3] - 2);
                    for (int i2 = 0; i2 < bArr2.length; i2++) {
                        if (processBlock[length + i2] != derEncode[length2 + i2]) {
                            return false;
                        }
                    }
                    for (int i3 = 0; i3 < length; i3++) {
                        if (processBlock[i3] != derEncode[i3]) {
                            return false;
                        }
                    }
                }
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    /* access modifiers changed from: protected */
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    private byte[] derEncode(byte[] bArr) throws IOException {
        AlgorithmIdentifier algorithmIdentifier = this.algId;
        if (algorithmIdentifier == null) {
            return bArr;
        }
        return new DigestInfo(algorithmIdentifier, bArr).getEncoded(ASN1Encodable.DER);
    }

    public static class SHA1WithRSAEncryption extends JDKDigestSignature {
        public SHA1WithRSAEncryption() {
            super(X509ObjectIdentifiers.id_SHA1, new SHA1Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA224WithRSAEncryption extends JDKDigestSignature {
        public SHA224WithRSAEncryption() {
            super(NISTObjectIdentifiers.id_sha224, new SHA224Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA256WithRSAEncryption extends JDKDigestSignature {
        public SHA256WithRSAEncryption() {
            super(NISTObjectIdentifiers.id_sha256, new SHA256Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA384WithRSAEncryption extends JDKDigestSignature {
        public SHA384WithRSAEncryption() {
            super(NISTObjectIdentifiers.id_sha384, new SHA384Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA512WithRSAEncryption extends JDKDigestSignature {
        public SHA512WithRSAEncryption() {
            super(NISTObjectIdentifiers.id_sha512, new SHA512Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class MD2WithRSAEncryption extends JDKDigestSignature {
        public MD2WithRSAEncryption() {
            super(PKCSObjectIdentifiers.md2, new MD2Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class MD4WithRSAEncryption extends JDKDigestSignature {
        public MD4WithRSAEncryption() {
            super(PKCSObjectIdentifiers.md4, new MD4Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class MD5WithRSAEncryption extends JDKDigestSignature {
        public MD5WithRSAEncryption() {
            super(PKCSObjectIdentifiers.md5, new MD5Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class RIPEMD160WithRSAEncryption extends JDKDigestSignature {
        public RIPEMD160WithRSAEncryption() {
            super(TeleTrusTObjectIdentifiers.ripemd160, new RIPEMD160Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class RIPEMD128WithRSAEncryption extends JDKDigestSignature {
        public RIPEMD128WithRSAEncryption() {
            super(TeleTrusTObjectIdentifiers.ripemd128, new RIPEMD128Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class RIPEMD256WithRSAEncryption extends JDKDigestSignature {
        public RIPEMD256WithRSAEncryption() {
            super(TeleTrusTObjectIdentifiers.ripemd256, new RIPEMD256Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class noneRSA extends JDKDigestSignature {
        public noneRSA() {
            super(new NullDigest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }
}
