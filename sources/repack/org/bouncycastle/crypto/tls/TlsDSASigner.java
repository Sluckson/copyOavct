package repack.org.bouncycastle.crypto.tls;

import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.CryptoException;
import repack.org.bouncycastle.crypto.DSA;
import repack.org.bouncycastle.crypto.Signer;
import repack.org.bouncycastle.crypto.digests.NullDigest;
import repack.org.bouncycastle.crypto.digests.SHA1Digest;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;
import repack.org.bouncycastle.crypto.signers.DSADigestSigner;

abstract class TlsDSASigner implements TlsSigner {
    /* access modifiers changed from: protected */
    public abstract DSA createDSAImpl();

    TlsDSASigner() {
    }

    public byte[] calculateRawSignature(SecureRandom secureRandom, AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr) throws CryptoException {
        DSADigestSigner dSADigestSigner = new DSADigestSigner(createDSAImpl(), new NullDigest());
        dSADigestSigner.init(true, new ParametersWithRandom(asymmetricKeyParameter, secureRandom));
        dSADigestSigner.update(bArr, 16, 20);
        return dSADigestSigner.generateSignature();
    }

    public Signer createVerifyer(AsymmetricKeyParameter asymmetricKeyParameter) {
        DSADigestSigner dSADigestSigner = new DSADigestSigner(createDSAImpl(), new SHA1Digest());
        dSADigestSigner.init(false, asymmetricKeyParameter);
        return dSADigestSigner;
    }
}
