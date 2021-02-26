package repack.org.bouncycastle.operator.p071bc;

import java.io.IOException;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.crypto.AsymmetricBlockCipher;
import repack.org.bouncycastle.crypto.encodings.PKCS1Encoding;
import repack.org.bouncycastle.crypto.engines.RSAEngine;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.util.PublicKeyFactory;

/* renamed from: repack.org.bouncycastle.operator.bc.BcRSAAsymmetricKeyWrapper */
public class BcRSAAsymmetricKeyWrapper extends BcAsymmetricKeyWrapper {
    public BcRSAAsymmetricKeyWrapper(AlgorithmIdentifier algorithmIdentifier, AsymmetricKeyParameter asymmetricKeyParameter) {
        super(algorithmIdentifier, asymmetricKeyParameter);
    }

    public BcRSAAsymmetricKeyWrapper(AlgorithmIdentifier algorithmIdentifier, SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        super(algorithmIdentifier, PublicKeyFactory.createKey(subjectPublicKeyInfo));
    }

    /* access modifiers changed from: protected */
    public AsymmetricBlockCipher createAsymmetricWrapper(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return new PKCS1Encoding(new RSAEngine());
    }
}
