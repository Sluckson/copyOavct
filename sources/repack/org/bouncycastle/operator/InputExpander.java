package repack.org.bouncycastle.operator;

import java.io.InputStream;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public interface InputExpander {
    AlgorithmIdentifier getAlgorithmIdentifier();

    InputStream getInputStream(InputStream inputStream);
}
