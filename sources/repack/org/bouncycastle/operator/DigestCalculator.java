package repack.org.bouncycastle.operator;

import java.io.OutputStream;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public interface DigestCalculator {
    AlgorithmIdentifier getAlgorithmIdentifier();

    byte[] getDigest();

    OutputStream getOutputStream();
}
