package repack.org.bouncycastle.operator;

import java.io.OutputStream;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public interface ContentSigner {
    AlgorithmIdentifier getAlgorithmIdentifier();

    OutputStream getOutputStream();

    byte[] getSignature();
}
