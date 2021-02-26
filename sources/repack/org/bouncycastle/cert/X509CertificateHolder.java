package repack.org.bouncycastle.cert;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.asn1.x509.TBSCertificateStructure;
import repack.org.bouncycastle.asn1.x509.X509CertificateStructure;
import repack.org.bouncycastle.asn1.x509.X509Extension;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.operator.ContentVerifier;
import repack.org.bouncycastle.operator.ContentVerifierProvider;

public class X509CertificateHolder {
    private X509Extensions extensions;
    private X509CertificateStructure x509Certificate;

    private static X509CertificateStructure parseBytes(byte[] bArr) throws IOException {
        try {
            return X509CertificateStructure.getInstance(ASN1Object.fromByteArray(bArr));
        } catch (ClassCastException e) {
            throw new CertIOException("malformed data: " + e.getMessage(), e);
        } catch (IllegalArgumentException e2) {
            throw new CertIOException("malformed data: " + e2.getMessage(), e2);
        }
    }

    public X509CertificateHolder(byte[] bArr) throws IOException {
        this(parseBytes(bArr));
    }

    public X509CertificateHolder(X509CertificateStructure x509CertificateStructure) {
        this.x509Certificate = x509CertificateStructure;
        this.extensions = x509CertificateStructure.getTBSCertificate().getExtensions();
    }

    public int getVersion() {
        return this.x509Certificate.getVersion();
    }

    public boolean hasExtensions() {
        return this.extensions != null;
    }

    public X509Extension getExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X509Extensions x509Extensions = this.extensions;
        if (x509Extensions != null) {
            return x509Extensions.getExtension(aSN1ObjectIdentifier);
        }
        return null;
    }

    public List getExtensionOIDs() {
        return CertUtils.getExtensionOIDs(this.extensions);
    }

    public Set getCriticalExtensionOIDs() {
        return CertUtils.getCriticalExtensionOIDs(this.extensions);
    }

    public Set getNonCriticalExtensionOIDs() {
        return CertUtils.getNonCriticalExtensionOIDs(this.extensions);
    }

    public IssuerAndSerialNumber getIssuerAndSerialNumber() {
        return new IssuerAndSerialNumber(this.x509Certificate.getIssuer(), this.x509Certificate.getSerialNumber());
    }

    public BigInteger getSerialNumber() {
        return this.x509Certificate.getSerialNumber().getValue();
    }

    public X500Name getIssuer() {
        return X500Name.getInstance(this.x509Certificate.getIssuer());
    }

    public X500Name getSubject() {
        return X500Name.getInstance(this.x509Certificate.getSubject());
    }

    public Date getNotBefore() {
        return this.x509Certificate.getStartDate().getDate();
    }

    public Date getNotAfter() {
        return this.x509Certificate.getEndDate().getDate();
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.x509Certificate.getSubjectPublicKeyInfo();
    }

    public X509CertificateStructure toASN1Structure() {
        return this.x509Certificate;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.x509Certificate.getSignatureAlgorithm();
    }

    public byte[] getSignature() {
        return this.x509Certificate.getSignature().getBytes();
    }

    public boolean isValidOn(Date date) {
        return !date.before(this.x509Certificate.getStartDate().getDate()) && !date.after(this.x509Certificate.getEndDate().getDate());
    }

    public boolean isSignatureValid(ContentVerifierProvider contentVerifierProvider) throws CertException {
        TBSCertificateStructure tBSCertificate = this.x509Certificate.getTBSCertificate();
        if (tBSCertificate.getSignature().equals(this.x509Certificate.getSignatureAlgorithm())) {
            try {
                ContentVerifier contentVerifier = contentVerifierProvider.get(tBSCertificate.getSignature());
                OutputStream outputStream = contentVerifier.getOutputStream();
                outputStream.write(tBSCertificate.getDEREncoded());
                outputStream.close();
                return contentVerifier.verify(this.x509Certificate.getSignature().getBytes());
            } catch (Exception e) {
                throw new CertException("unable to process signature: " + e.getMessage(), e);
            }
        } else {
            throw new CertException("signature invalid - algorithm identifier mismatch");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509CertificateHolder)) {
            return false;
        }
        return this.x509Certificate.equals(((X509CertificateHolder) obj).x509Certificate);
    }

    public int hashCode() {
        return this.x509Certificate.hashCode();
    }

    public byte[] getEncoded() throws IOException {
        return this.x509Certificate.getEncoded();
    }
}
