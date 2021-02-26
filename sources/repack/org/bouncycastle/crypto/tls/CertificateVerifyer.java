package repack.org.bouncycastle.crypto.tls;

import repack.org.bouncycastle.asn1.x509.X509CertificateStructure;

public interface CertificateVerifyer {
    boolean isValid(X509CertificateStructure[] x509CertificateStructureArr);
}
