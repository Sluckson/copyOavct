package repack.org.bouncycastle.jce.provider;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import repack.org.bouncycastle.crypto.DSA;
import repack.org.bouncycastle.crypto.Digest;

public abstract class DSABase extends Signature implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    protected Digest digest;
    protected DSAEncoder encoder;
    protected DSA signer;

    /* access modifiers changed from: protected */
    public abstract void doEngineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException;

    protected DSABase(String str, Digest digest2, DSA dsa, DSAEncoder dSAEncoder) {
        super(str);
        this.digest = digest2;
        this.signer = dsa;
        this.encoder = dSAEncoder;
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        doEngineInitSign(privateKey, this.appRandom);
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
            BigInteger[] generateSignature = this.signer.generateSignature(bArr);
            return this.encoder.encode(generateSignature[0], generateSignature[1]);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr2, 0);
        try {
            BigInteger[] decode = this.encoder.decode(bArr);
            return this.signer.verifySignature(bArr2, decode[0], decode[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
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

    /* access modifiers changed from: protected */
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }
}
