package repack.org.bouncycastle.jce.provider;

import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.PSSParameterSpec;
import repack.org.bouncycastle.crypto.AsymmetricBlockCipher;
import repack.org.bouncycastle.crypto.CryptoException;
import repack.org.bouncycastle.crypto.Digest;
import repack.org.bouncycastle.crypto.digests.SHA1Digest;
import repack.org.bouncycastle.crypto.digests.SHA224Digest;
import repack.org.bouncycastle.crypto.digests.SHA256Digest;
import repack.org.bouncycastle.crypto.digests.SHA384Digest;
import repack.org.bouncycastle.crypto.digests.SHA512Digest;
import repack.org.bouncycastle.crypto.engines.RSABlindedEngine;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;
import repack.org.bouncycastle.crypto.signers.PSSSigner;

public class JDKPSSSigner extends Signature {
    private Digest digest;
    private AlgorithmParameters engineParams;
    private PSSSigner pss;
    private int saltLength;
    private AsymmetricBlockCipher signer;

    protected JDKPSSSigner(String str, AsymmetricBlockCipher asymmetricBlockCipher, Digest digest2) {
        super(str);
        this.signer = asymmetricBlockCipher;
        this.digest = digest2;
        if (digest2 != null) {
            this.saltLength = digest2.getDigestSize();
        } else {
            this.saltLength = 20;
        }
    }

    /* access modifiers changed from: protected */
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof RSAPublicKey) {
            this.pss = new PSSSigner(this.signer, this.digest, this.saltLength);
            this.pss.init(false, RSAUtil.generatePublicKeyParameter((RSAPublicKey) publicKey));
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPublicKey instance");
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        if (privateKey instanceof RSAPrivateKey) {
            this.pss = new PSSSigner(this.signer, this.digest, this.saltLength);
            this.pss.init(true, new ParametersWithRandom(RSAUtil.generatePrivateKeyParameter((RSAPrivateKey) privateKey), secureRandom));
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
    }

    /* access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof RSAPrivateKey) {
            this.pss = new PSSSigner(this.signer, this.digest, this.saltLength);
            this.pss.init(true, RSAUtil.generatePrivateKeyParameter((RSAPrivateKey) privateKey));
            return;
        }
        throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte b) throws SignatureException {
        this.pss.update(b);
    }

    /* access modifiers changed from: protected */
    public void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.pss.update(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public byte[] engineSign() throws SignatureException {
        try {
            return this.pss.generateSignature();
        } catch (CryptoException e) {
            throw new SignatureException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        return this.pss.verifySignature(bArr);
    }

    /* access modifiers changed from: protected */
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterException {
        if (algorithmParameterSpec instanceof PSSParameterSpec) {
            this.saltLength = ((PSSParameterSpec) algorithmParameterSpec).getSaltLength();
            return;
        }
        throw new InvalidParameterException("Only PSSParameterSpec supported");
    }

    /* access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null) {
            try {
                this.engineParams = AlgorithmParameters.getInstance("PSS", "BC");
                this.engineParams.init(new PSSParameterSpec(this.saltLength));
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.engineParams;
    }

    /* access modifiers changed from: protected */
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    /* access modifiers changed from: protected */
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    public static class PSSwithRSA extends JDKPSSSigner {
        public PSSwithRSA() {
            super("SHA1withRSAandMGF1", new RSABlindedEngine(), (Digest) null);
        }
    }

    public static class SHA1withRSA extends JDKPSSSigner {
        public SHA1withRSA() {
            super("SHA1withRSAandMGF1", new RSABlindedEngine(), new SHA1Digest());
        }
    }

    public static class SHA224withRSA extends JDKPSSSigner {
        public SHA224withRSA() {
            super("SHA224withRSAandMGF1", new RSABlindedEngine(), new SHA224Digest());
        }
    }

    public static class SHA256withRSA extends JDKPSSSigner {
        public SHA256withRSA() {
            super("SHA256withRSAandMGF1", new RSABlindedEngine(), new SHA256Digest());
        }
    }

    public static class SHA384withRSA extends JDKPSSSigner {
        public SHA384withRSA() {
            super("SHA384withRSAandMGF1", new RSABlindedEngine(), new SHA384Digest());
        }
    }

    public static class SHA512withRSA extends JDKPSSSigner {
        public SHA512withRSA() {
            super("SHA512withRSAandMGF1", new RSABlindedEngine(), new SHA512Digest());
        }
    }
}
