package repack.org.bouncycastle.x509;

import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.x509.CertificatePair;
import repack.org.bouncycastle.asn1.x509.X509CertificateStructure;
import repack.org.bouncycastle.jce.provider.X509CertificateObject;

public class X509CertificatePair {
    private X509Certificate forward;
    private X509Certificate reverse;

    public X509CertificatePair(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        this.forward = x509Certificate;
        this.reverse = x509Certificate2;
    }

    public X509CertificatePair(CertificatePair certificatePair) throws CertificateParsingException {
        if (certificatePair.getForward() != null) {
            this.forward = new X509CertificateObject(certificatePair.getForward());
        }
        if (certificatePair.getReverse() != null) {
            this.reverse = new X509CertificateObject(certificatePair.getReverse());
        }
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        X509CertificateStructure x509CertificateStructure;
        try {
            X509CertificateStructure x509CertificateStructure2 = null;
            if (this.forward != null) {
                x509CertificateStructure = X509CertificateStructure.getInstance(new ASN1InputStream(this.forward.getEncoded()).readObject());
                if (x509CertificateStructure == null) {
                    throw new CertificateEncodingException("unable to get encoding for forward");
                }
            } else {
                x509CertificateStructure = null;
            }
            if (this.reverse != null) {
                x509CertificateStructure2 = X509CertificateStructure.getInstance(new ASN1InputStream(this.reverse.getEncoded()).readObject());
                if (x509CertificateStructure2 == null) {
                    throw new CertificateEncodingException("unable to get encoding for reverse");
                }
            }
            return new CertificatePair(x509CertificateStructure, x509CertificateStructure2).getDEREncoded();
        } catch (IllegalArgumentException e) {
            throw new ExtCertificateEncodingException(e.toString(), e);
        } catch (IOException e2) {
            throw new ExtCertificateEncodingException(e2.toString(), e2);
        }
    }

    public X509Certificate getForward() {
        return this.forward;
    }

    public X509Certificate getReverse() {
        return this.reverse;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == null || !(obj instanceof X509CertificatePair)) {
            return false;
        }
        X509CertificatePair x509CertificatePair = (X509CertificatePair) obj;
        X509Certificate x509Certificate = this.forward;
        if (x509Certificate != null) {
            z = x509Certificate.equals(x509CertificatePair.forward);
        } else {
            z = x509CertificatePair.forward == null;
        }
        X509Certificate x509Certificate2 = this.reverse;
        if (x509Certificate2 != null) {
            z2 = x509Certificate2.equals(x509CertificatePair.reverse);
        } else {
            z2 = x509CertificatePair.reverse == null;
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        X509Certificate x509Certificate = this.forward;
        int i = -1;
        if (x509Certificate != null) {
            i = -1 ^ x509Certificate.hashCode();
        }
        X509Certificate x509Certificate2 = this.reverse;
        return x509Certificate2 != null ? (i * 17) ^ x509Certificate2.hashCode() : i;
    }
}
