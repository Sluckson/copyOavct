package repack.org.bouncycastle.crypto.tls;

import repack.org.bouncycastle.asn1.x509.X509CertificateStructure;

public class AlwaysValidVerifyer implements CertificateVerifyer {
    public boolean isValid(X509CertificateStructure[] x509CertificateStructureArr) {
        return true;
    }
}
