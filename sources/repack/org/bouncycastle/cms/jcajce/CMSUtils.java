package repack.org.bouncycastle.cms.jcajce;

import java.security.Key;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import javax.crypto.spec.SecretKeySpec;
import repack.org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import repack.org.bouncycastle.asn1.x509.TBSCertificateStructure;
import repack.org.bouncycastle.asn1.x509.X509CertificateStructure;
import repack.org.bouncycastle.operator.GenericKey;

class CMSUtils {
    CMSUtils() {
    }

    static TBSCertificateStructure getTBSCertificateStructure(X509Certificate x509Certificate) throws CertificateEncodingException {
        return TBSCertificateStructure.getInstance(x509Certificate.getTBSCertificate());
    }

    static Key getJceKey(GenericKey genericKey) {
        if (genericKey.getRepresentation() instanceof Key) {
            return (Key) genericKey.getRepresentation();
        }
        if (genericKey.getRepresentation() instanceof byte[]) {
            return new SecretKeySpec((byte[]) genericKey.getRepresentation(), "ENC");
        }
        throw new IllegalArgumentException("unknown generic key type");
    }

    static IssuerAndSerialNumber getIssuerAndSerialNumber(X509Certificate x509Certificate) throws CertificateEncodingException {
        X509CertificateStructure instance = X509CertificateStructure.getInstance(x509Certificate.getEncoded());
        return new IssuerAndSerialNumber(instance.getIssuer(), instance.getSerialNumber());
    }
}
