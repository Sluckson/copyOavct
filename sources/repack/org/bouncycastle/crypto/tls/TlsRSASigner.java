package repack.org.bouncycastle.crypto.tls;

import java.security.SecureRandom;
import repack.org.bouncycastle.crypto.CryptoException;
import repack.org.bouncycastle.crypto.Signer;
import repack.org.bouncycastle.crypto.digests.NullDigest;
import repack.org.bouncycastle.crypto.encodings.PKCS1Encoding;
import repack.org.bouncycastle.crypto.engines.RSABlindedEngine;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;
import repack.org.bouncycastle.crypto.params.RSAKeyParameters;
import repack.org.bouncycastle.crypto.signers.GenericSigner;

class TlsRSASigner implements TlsSigner {
    TlsRSASigner() {
    }

    public byte[] calculateRawSignature(SecureRandom secureRandom, AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr) throws CryptoException {
        GenericSigner genericSigner = new GenericSigner(new PKCS1Encoding(new RSABlindedEngine()), new NullDigest());
        genericSigner.init(true, new ParametersWithRandom(asymmetricKeyParameter, secureRandom));
        genericSigner.update(bArr, 0, bArr.length);
        return genericSigner.generateSignature();
    }

    public Signer createVerifyer(AsymmetricKeyParameter asymmetricKeyParameter) {
        GenericSigner genericSigner = new GenericSigner(new PKCS1Encoding(new RSABlindedEngine()), new CombinedHash());
        genericSigner.init(false, asymmetricKeyParameter);
        return genericSigner;
    }

    public boolean isValidPublicKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        return (asymmetricKeyParameter instanceof RSAKeyParameters) && !asymmetricKeyParameter.isPrivate();
    }
}
