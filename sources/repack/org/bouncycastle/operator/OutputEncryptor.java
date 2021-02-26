package repack.org.bouncycastle.operator;

import java.io.OutputStream;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public interface OutputEncryptor {
    AlgorithmIdentifier getAlgorithmIdentifier();

    GenericKey getKey();

    OutputStream getOutputStream(OutputStream outputStream);
}
