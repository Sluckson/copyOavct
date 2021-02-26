package repack.org.bouncycastle.cms.jcajce;

import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.operator.OutputCompressor;

public class ZlibCompressor implements OutputCompressor {
    private static final String ZLIB = "1.2.840.113549.1.9.16.3.8";

    public AlgorithmIdentifier getAlgorithmIdentifier() {
        return new AlgorithmIdentifier((DERObjectIdentifier) new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.3.8"));
    }

    public OutputStream getOutputStream(OutputStream outputStream) {
        return new DeflaterOutputStream(outputStream);
    }
}
