package repack.org.bouncycastle.x509.extension;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import repack.org.bouncycastle.asn1.x509.GeneralName;
import repack.org.bouncycastle.asn1.x509.GeneralNames;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.asn1.x509.X509Extension;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.asn1.x509.X509Name;
import repack.org.bouncycastle.jce.PrincipalUtil;

public class AuthorityKeyIdentifierStructure extends AuthorityKeyIdentifier {
    public AuthorityKeyIdentifierStructure(byte[] bArr) throws IOException {
        super((ASN1Sequence) X509ExtensionUtil.fromExtensionValue(bArr));
    }

    public AuthorityKeyIdentifierStructure(X509Extension x509Extension) {
        super((ASN1Sequence) x509Extension.getParsedValue());
    }

    private static ASN1Sequence fromCertificate(X509Certificate x509Certificate) throws CertificateParsingException {
        try {
            if (x509Certificate.getVersion() != 3) {
                return (ASN1Sequence) new AuthorityKeyIdentifier(new SubjectPublicKeyInfo((ASN1Sequence) new ASN1InputStream(x509Certificate.getPublicKey().getEncoded()).readObject()), new GeneralNames(new GeneralName((X509Name) PrincipalUtil.getIssuerX509Principal(x509Certificate))), x509Certificate.getSerialNumber()).toASN1Object();
            }
            GeneralName generalName = new GeneralName((X509Name) PrincipalUtil.getIssuerX509Principal(x509Certificate));
            byte[] extensionValue = x509Certificate.getExtensionValue(X509Extensions.SubjectKeyIdentifier.getId());
            if (extensionValue != null) {
                return (ASN1Sequence) new AuthorityKeyIdentifier(((ASN1OctetString) X509ExtensionUtil.fromExtensionValue(extensionValue)).getOctets(), new GeneralNames(generalName), x509Certificate.getSerialNumber()).toASN1Object();
            }
            return (ASN1Sequence) new AuthorityKeyIdentifier(new SubjectPublicKeyInfo((ASN1Sequence) new ASN1InputStream(x509Certificate.getPublicKey().getEncoded()).readObject()), new GeneralNames(generalName), x509Certificate.getSerialNumber()).toASN1Object();
        } catch (Exception e) {
            throw new CertificateParsingException("Exception extracting certificate details: " + e.toString());
        }
    }

    private static ASN1Sequence fromKey(PublicKey publicKey) throws InvalidKeyException {
        try {
            return (ASN1Sequence) new AuthorityKeyIdentifier(new SubjectPublicKeyInfo((ASN1Sequence) new ASN1InputStream(publicKey.getEncoded()).readObject())).toASN1Object();
        } catch (Exception e) {
            throw new InvalidKeyException("can't process key: " + e);
        }
    }

    public AuthorityKeyIdentifierStructure(X509Certificate x509Certificate) throws CertificateParsingException {
        super(fromCertificate(x509Certificate));
    }

    public AuthorityKeyIdentifierStructure(PublicKey publicKey) throws InvalidKeyException {
        super(fromKey(publicKey));
    }
}
