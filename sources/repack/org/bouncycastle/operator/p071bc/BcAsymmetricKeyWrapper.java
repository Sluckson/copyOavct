package repack.org.bouncycastle.operator.p071bc;

import java.security.SecureRandom;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.crypto.AsymmetricBlockCipher;
import repack.org.bouncycastle.crypto.InvalidCipherTextException;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.ParametersWithRandom;
import repack.org.bouncycastle.operator.AsymmetricKeyWrapper;
import repack.org.bouncycastle.operator.GenericKey;
import repack.org.bouncycastle.operator.OperatorException;

/* renamed from: repack.org.bouncycastle.operator.bc.BcAsymmetricKeyWrapper */
public abstract class BcAsymmetricKeyWrapper extends AsymmetricKeyWrapper {
    private AsymmetricKeyParameter publicKey;
    private SecureRandom random;

    /* access modifiers changed from: protected */
    public abstract AsymmetricBlockCipher createAsymmetricWrapper(ASN1ObjectIdentifier aSN1ObjectIdentifier);

    public BcAsymmetricKeyWrapper(AlgorithmIdentifier algorithmIdentifier, AsymmetricKeyParameter asymmetricKeyParameter) {
        super(algorithmIdentifier);
        this.publicKey = asymmetricKeyParameter;
    }

    public BcAsymmetricKeyWrapper setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }

    public byte[] generateWrappedKey(GenericKey genericKey) throws OperatorException {
        AsymmetricBlockCipher createAsymmetricWrapper = createAsymmetricWrapper(getAlgorithmIdentifier().getAlgorithm());
        AsymmetricKeyParameter asymmetricKeyParameter = this.publicKey;
        SecureRandom secureRandom = this.random;
        if (secureRandom != null) {
            new ParametersWithRandom(asymmetricKeyParameter, secureRandom);
        }
        try {
            byte[] keyBytes = OperatorUtils.getKeyBytes(genericKey);
            createAsymmetricWrapper.init(true, this.publicKey);
            return createAsymmetricWrapper.processBlock(keyBytes, 0, keyBytes.length);
        } catch (InvalidCipherTextException e) {
            throw new OperatorException("unable to encrypt contents key", e);
        }
    }
}
