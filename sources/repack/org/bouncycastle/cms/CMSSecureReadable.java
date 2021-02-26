package repack.org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.security.Provider;
import javax.crypto.SecretKey;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

interface CMSSecureReadable {
    AlgorithmIdentifier getAlgorithm();

    Object getCryptoObject();

    InputStream getInputStream() throws IOException, CMSException;

    CMSReadable getReadable(SecretKey secretKey, Provider provider) throws CMSException;
}
