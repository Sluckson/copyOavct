package repack.org.bouncycastle.cert.crmf;

import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.operator.InputDecryptor;

public interface ValueDecryptorGenerator {
    InputDecryptor getValueDecryptor(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, byte[] bArr) throws CRMFException;
}
