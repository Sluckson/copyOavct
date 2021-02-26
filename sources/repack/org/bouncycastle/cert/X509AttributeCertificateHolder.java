package repack.org.bouncycastle.cert;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.AttCertValidityPeriod;
import repack.org.bouncycastle.asn1.x509.Attribute;
import repack.org.bouncycastle.asn1.x509.AttributeCertificate;
import repack.org.bouncycastle.asn1.x509.AttributeCertificateInfo;
import repack.org.bouncycastle.asn1.x509.X509Extension;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.operator.ContentVerifier;
import repack.org.bouncycastle.operator.ContentVerifierProvider;

public class X509AttributeCertificateHolder {
    private static Attribute[] EMPTY_ARRAY = new Attribute[0];
    private AttributeCertificate attrCert;
    private X509Extensions extensions;

    private static AttributeCertificate parseBytes(byte[] bArr) throws IOException {
        try {
            return AttributeCertificate.getInstance(ASN1Object.fromByteArray(bArr));
        } catch (ClassCastException e) {
            throw new CertIOException("malformed data: " + e.getMessage(), e);
        } catch (IllegalArgumentException e2) {
            throw new CertIOException("malformed data: " + e2.getMessage(), e2);
        }
    }

    public X509AttributeCertificateHolder(byte[] bArr) throws IOException {
        this(parseBytes(bArr));
    }

    public X509AttributeCertificateHolder(AttributeCertificate attributeCertificate) {
        this.attrCert = attributeCertificate;
        this.extensions = attributeCertificate.getAcinfo().getExtensions();
    }

    public byte[] getEncoded() throws IOException {
        return this.attrCert.getEncoded();
    }

    public int getVersion() {
        return this.attrCert.getAcinfo().getVersion().getValue().intValue() + 1;
    }

    public BigInteger getSerialNumber() {
        return this.attrCert.getAcinfo().getSerialNumber().getValue();
    }

    public AttributeCertificateHolder getHolder() {
        return new AttributeCertificateHolder((ASN1Sequence) this.attrCert.getAcinfo().getHolder().toASN1Object());
    }

    public AttributeCertificateIssuer getIssuer() {
        return new AttributeCertificateIssuer(this.attrCert.getAcinfo().getIssuer());
    }

    public Date getNotBefore() {
        return CertUtils.recoverDate(this.attrCert.getAcinfo().getAttrCertValidityPeriod().getNotBeforeTime());
    }

    public Date getNotAfter() {
        return CertUtils.recoverDate(this.attrCert.getAcinfo().getAttrCertValidityPeriod().getNotAfterTime());
    }

    public Attribute[] getAttributes() {
        ASN1Sequence attributes = this.attrCert.getAcinfo().getAttributes();
        Attribute[] attributeArr = new Attribute[attributes.size()];
        for (int i = 0; i != attributes.size(); i++) {
            attributeArr[i] = Attribute.getInstance(attributes.getObjectAt(i));
        }
        return attributeArr;
    }

    public Attribute[] getAttributes(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        ASN1Sequence attributes = this.attrCert.getAcinfo().getAttributes();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != attributes.size(); i++) {
            Attribute instance = Attribute.getInstance(attributes.getObjectAt(i));
            if (instance.getAttrType().equals(aSN1ObjectIdentifier)) {
                arrayList.add(instance);
            }
        }
        if (arrayList.size() == 0) {
            return EMPTY_ARRAY;
        }
        return (Attribute[]) arrayList.toArray(new Attribute[arrayList.size()]);
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

    public boolean[] getIssuerUniqueID() {
        return CertUtils.bitStringToBoolean(this.attrCert.getAcinfo().getIssuerUniqueID());
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.attrCert.getSignatureAlgorithm();
    }

    public byte[] getSignature() {
        return this.attrCert.getSignatureValue().getBytes();
    }

    public AttributeCertificate toASN1Structure() {
        return this.attrCert;
    }

    public boolean isValidOn(Date date) {
        AttCertValidityPeriod attrCertValidityPeriod = this.attrCert.getAcinfo().getAttrCertValidityPeriod();
        return !date.before(CertUtils.recoverDate(attrCertValidityPeriod.getNotBeforeTime())) && !date.after(CertUtils.recoverDate(attrCertValidityPeriod.getNotAfterTime()));
    }

    public boolean isSignatureValid(ContentVerifierProvider contentVerifierProvider) throws CertException {
        AttributeCertificateInfo acinfo = this.attrCert.getAcinfo();
        if (acinfo.getSignature().equals(this.attrCert.getSignatureAlgorithm())) {
            try {
                ContentVerifier contentVerifier = contentVerifierProvider.get(acinfo.getSignature());
                OutputStream outputStream = contentVerifier.getOutputStream();
                outputStream.write(acinfo.getDEREncoded());
                outputStream.close();
                return contentVerifier.verify(this.attrCert.getSignatureValue().getBytes());
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
        if (!(obj instanceof X509AttributeCertificateHolder)) {
            return false;
        }
        return this.attrCert.equals(((X509AttributeCertificateHolder) obj).attrCert);
    }

    public int hashCode() {
        return this.attrCert.hashCode();
    }
}
