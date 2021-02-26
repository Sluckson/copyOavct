package repack.org.bouncycastle.cms;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.X509CertSelector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.asn1.x509.X509Extension;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.crypto.digests.SHA1Digest;
import repack.org.bouncycastle.util.Arrays;
import repack.org.bouncycastle.util.Selector;

public class SignerId extends X509CertSelector implements Selector {
    private X500Name issuer;
    private BigInteger serialNumber;
    private byte[] subjectKeyId;

    public SignerId() {
    }

    public SignerId(byte[] bArr) {
        super.setSubjectKeyIdentifier(new DEROctetString(bArr).getDEREncoded());
        this.subjectKeyId = bArr;
    }

    public SignerId(X500Name x500Name, BigInteger bigInteger) {
        this.issuer = x500Name;
        this.serialNumber = bigInteger;
        try {
            setIssuer(x500Name.getDEREncoded());
            setSerialNumber(bigInteger);
        } catch (IOException e) {
            throw new IllegalArgumentException("invalid issuer: " + e.getMessage());
        }
    }

    public int hashCode() {
        int hashCode = Arrays.hashCode(this.subjectKeyId);
        BigInteger bigInteger = this.serialNumber;
        if (bigInteger != null) {
            hashCode ^= bigInteger.hashCode();
        }
        X500Name x500Name = this.issuer;
        return x500Name != null ? hashCode ^ x500Name.hashCode() : hashCode;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SignerId)) {
            return false;
        }
        SignerId signerId = (SignerId) obj;
        if (!Arrays.areEqual(this.subjectKeyId, signerId.subjectKeyId) || !equalsObj(this.serialNumber, signerId.serialNumber) || !equalsObj(this.issuer, signerId.issuer)) {
            return false;
        }
        return true;
    }

    private boolean equalsObj(Object obj, Object obj2) {
        if (obj != null) {
            return obj.equals(obj2);
        }
        return obj2 == null;
    }

    public boolean match(Object obj) {
        if (obj instanceof X509CertificateHolder) {
            X509CertificateHolder x509CertificateHolder = (X509CertificateHolder) obj;
            if (getSerialNumber() != null) {
                IssuerAndSerialNumber issuerAndSerialNumber = x509CertificateHolder.getIssuerAndSerialNumber();
                if (!issuerAndSerialNumber.getName().equals(this.issuer) || !issuerAndSerialNumber.getSerialNumber().getValue().equals(this.serialNumber)) {
                    return false;
                }
                return true;
            } else if (getSubjectKeyIdentifier() != null) {
                X509Extension extension = x509CertificateHolder.getExtension(X509Extension.subjectKeyIdentifier);
                if (extension == null) {
                    SHA1Digest sHA1Digest = new SHA1Digest();
                    byte[] bArr = new byte[sHA1Digest.getDigestSize()];
                    byte[] dEREncoded = x509CertificateHolder.getSubjectPublicKeyInfo().getDEREncoded();
                    sHA1Digest.update(dEREncoded, 0, dEREncoded.length);
                    sHA1Digest.doFinal(bArr, 0);
                    return Arrays.areEqual(this.subjectKeyId, bArr);
                }
                return Arrays.areEqual(this.subjectKeyId, ASN1OctetString.getInstance(extension.getParsedValue()).getOctets());
            }
        } else if (obj instanceof byte[]) {
            return Arrays.areEqual(this.subjectKeyId, (byte[]) obj);
        } else {
            if (obj instanceof SignerInformation) {
                return ((SignerInformation) obj).getSID().equals(this);
            }
        }
        return false;
    }
}
