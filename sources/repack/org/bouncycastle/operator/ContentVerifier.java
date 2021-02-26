package repack.org.bouncycastle.operator;

import java.io.OutputStream;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public interface ContentVerifier {
    AlgorithmIdentifier getAlgorithmIdentifier();

    OutputStream getOutputStream();

    boolean verify(byte[] bArr);
}
