package repack.org.bouncycastle.jce.provider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1OutputStream;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.util.ASN1Dump;
import repack.org.bouncycastle.asn1.x509.CRLDistPoint;
import repack.org.bouncycastle.asn1.x509.CRLNumber;
import repack.org.bouncycastle.asn1.x509.CertificateList;
import repack.org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import repack.org.bouncycastle.asn1.x509.TBSCertList;
import repack.org.bouncycastle.asn1.x509.X509Extension;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.jce.X509Principal;
import repack.org.bouncycastle.util.encoders.Hex;
import repack.org.bouncycastle.x509.extension.X509ExtensionUtil;

public class X509CRLObject extends X509CRL {

    /* renamed from: c */
    private CertificateList f6246c;
    private boolean isIndirect;
    private String sigAlgName;
    private byte[] sigAlgParams;

    public X509CRLObject(CertificateList certificateList) throws CRLException {
        this.f6246c = certificateList;
        try {
            this.sigAlgName = X509SignatureUtil.getSignatureName(certificateList.getSignatureAlgorithm());
            if (certificateList.getSignatureAlgorithm().getParameters() != null) {
                this.sigAlgParams = ((ASN1Encodable) certificateList.getSignatureAlgorithm().getParameters()).getDEREncoded();
            } else {
                this.sigAlgParams = null;
            }
            this.isIndirect = isIndirectCRL();
        } catch (Exception e) {
            throw new CRLException("CRL contents invalid: " + e);
        }
    }

    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        if (criticalExtensionOIDs == null) {
            return false;
        }
        criticalExtensionOIDs.remove(RFC3280CertPathUtilities.ISSUING_DISTRIBUTION_POINT);
        criticalExtensionOIDs.remove(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
        return !criticalExtensionOIDs.isEmpty();
    }

    private Set getExtensionOIDs(boolean z) {
        X509Extensions extensions;
        if (getVersion() != 2 || (extensions = this.f6246c.getTBSCertList().getExtensions()) == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Enumeration oids = extensions.oids();
        while (oids.hasMoreElements()) {
            DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) oids.nextElement();
            if (z == extensions.getExtension(dERObjectIdentifier).isCritical()) {
                hashSet.add(dERObjectIdentifier.getId());
            }
        }
        return hashSet;
    }

    public Set getCriticalExtensionOIDs() {
        return getExtensionOIDs(true);
    }

    public Set getNonCriticalExtensionOIDs() {
        return getExtensionOIDs(false);
    }

    public byte[] getExtensionValue(String str) {
        X509Extension extension;
        X509Extensions extensions = this.f6246c.getTBSCertList().getExtensions();
        if (extensions == null || (extension = extensions.getExtension(new DERObjectIdentifier(str))) == null) {
            return null;
        }
        try {
            return extension.getValue().getEncoded();
        } catch (Exception e) {
            throw new IllegalStateException("error parsing " + e.toString());
        }
    }

    public byte[] getEncoded() throws CRLException {
        try {
            return this.f6246c.getEncoded(ASN1Encodable.DER);
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    public void verify(PublicKey publicKey) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        verify(publicKey, BouncyCastleProvider.PROVIDER_NAME);
    }

    public void verify(PublicKey publicKey, String str) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        if (this.f6246c.getSignatureAlgorithm().equals(this.f6246c.getTBSCertList().getSignature())) {
            Signature instance = Signature.getInstance(getSigAlgName(), str);
            instance.initVerify(publicKey);
            instance.update(getTBSCertList());
            if (!instance.verify(getSignature())) {
                throw new SignatureException("CRL does not verify with supplied public key.");
            }
            return;
        }
        throw new CRLException("Signature algorithm on CertificateList does not match TBSCertList.");
    }

    public int getVersion() {
        return this.f6246c.getVersion();
    }

    public Principal getIssuerDN() {
        return new X509Principal(this.f6246c.getIssuer());
    }

    public X500Principal getIssuerX500Principal() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ASN1OutputStream(byteArrayOutputStream).writeObject(this.f6246c.getIssuer());
            return new X500Principal(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    public Date getThisUpdate() {
        return this.f6246c.getThisUpdate().getDate();
    }

    public Date getNextUpdate() {
        if (this.f6246c.getNextUpdate() != null) {
            return this.f6246c.getNextUpdate().getDate();
        }
        return null;
    }

    private Set loadCRLEntries() {
        HashSet hashSet = new HashSet();
        Enumeration revokedCertificateEnumeration = this.f6246c.getRevokedCertificateEnumeration();
        X500Principal issuerX500Principal = getIssuerX500Principal();
        while (revokedCertificateEnumeration.hasMoreElements()) {
            X509CRLEntryObject x509CRLEntryObject = new X509CRLEntryObject((TBSCertList.CRLEntry) revokedCertificateEnumeration.nextElement(), this.isIndirect, issuerX500Principal);
            hashSet.add(x509CRLEntryObject);
            issuerX500Principal = x509CRLEntryObject.getCertificateIssuer();
        }
        return hashSet;
    }

    public X509CRLEntry getRevokedCertificate(BigInteger bigInteger) {
        Enumeration revokedCertificateEnumeration = this.f6246c.getRevokedCertificateEnumeration();
        X500Principal issuerX500Principal = getIssuerX500Principal();
        while (revokedCertificateEnumeration.hasMoreElements()) {
            TBSCertList.CRLEntry cRLEntry = (TBSCertList.CRLEntry) revokedCertificateEnumeration.nextElement();
            X509CRLEntryObject x509CRLEntryObject = new X509CRLEntryObject(cRLEntry, this.isIndirect, issuerX500Principal);
            if (bigInteger.equals(cRLEntry.getUserCertificate().getValue())) {
                return x509CRLEntryObject;
            }
            issuerX500Principal = x509CRLEntryObject.getCertificateIssuer();
        }
        return null;
    }

    public Set getRevokedCertificates() {
        Set loadCRLEntries = loadCRLEntries();
        if (!loadCRLEntries.isEmpty()) {
            return Collections.unmodifiableSet(loadCRLEntries);
        }
        return null;
    }

    public byte[] getTBSCertList() throws CRLException {
        try {
            return this.f6246c.getTBSCertList().getEncoded(ASN1Encodable.DER);
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    public byte[] getSignature() {
        return this.f6246c.getSignature().getBytes();
    }

    public String getSigAlgName() {
        return this.sigAlgName;
    }

    public String getSigAlgOID() {
        return this.f6246c.getSignatureAlgorithm().getObjectId().getId();
    }

    public byte[] getSigAlgParams() {
        byte[] bArr = this.sigAlgParams;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        return bArr2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String property = System.getProperty("line.separator");
        stringBuffer.append("              Version: ");
        stringBuffer.append(getVersion());
        stringBuffer.append(property);
        stringBuffer.append("             IssuerDN: ");
        stringBuffer.append(getIssuerDN());
        stringBuffer.append(property);
        stringBuffer.append("          This update: ");
        stringBuffer.append(getThisUpdate());
        stringBuffer.append(property);
        stringBuffer.append("          Next update: ");
        stringBuffer.append(getNextUpdate());
        stringBuffer.append(property);
        stringBuffer.append("  Signature Algorithm: ");
        stringBuffer.append(getSigAlgName());
        stringBuffer.append(property);
        byte[] signature = getSignature();
        stringBuffer.append("            Signature: ");
        stringBuffer.append(new String(Hex.encode(signature, 0, 20)));
        stringBuffer.append(property);
        for (int i = 20; i < signature.length; i += 20) {
            if (i < signature.length - 20) {
                stringBuffer.append("                       ");
                stringBuffer.append(new String(Hex.encode(signature, i, 20)));
                stringBuffer.append(property);
            } else {
                stringBuffer.append("                       ");
                stringBuffer.append(new String(Hex.encode(signature, i, signature.length - i)));
                stringBuffer.append(property);
            }
        }
        X509Extensions extensions = this.f6246c.getTBSCertList().getExtensions();
        if (extensions != null) {
            Enumeration oids = extensions.oids();
            if (oids.hasMoreElements()) {
                stringBuffer.append("           Extensions: ");
                stringBuffer.append(property);
            }
            while (oids.hasMoreElements()) {
                DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) oids.nextElement();
                X509Extension extension = extensions.getExtension(dERObjectIdentifier);
                if (extension.getValue() != null) {
                    ASN1InputStream aSN1InputStream = new ASN1InputStream(extension.getValue().getOctets());
                    stringBuffer.append("                       critical(");
                    stringBuffer.append(extension.isCritical());
                    stringBuffer.append(") ");
                    try {
                        if (dERObjectIdentifier.equals(X509Extensions.CRLNumber)) {
                            stringBuffer.append(new CRLNumber(DERInteger.getInstance(aSN1InputStream.readObject()).getPositiveValue()));
                            stringBuffer.append(property);
                        } else if (dERObjectIdentifier.equals(X509Extensions.DeltaCRLIndicator)) {
                            stringBuffer.append("Base CRL: " + new CRLNumber(DERInteger.getInstance(aSN1InputStream.readObject()).getPositiveValue()));
                            stringBuffer.append(property);
                        } else if (dERObjectIdentifier.equals(X509Extensions.IssuingDistributionPoint)) {
                            stringBuffer.append(new IssuingDistributionPoint((ASN1Sequence) aSN1InputStream.readObject()));
                            stringBuffer.append(property);
                        } else if (dERObjectIdentifier.equals(X509Extensions.CRLDistributionPoints)) {
                            stringBuffer.append(new CRLDistPoint((ASN1Sequence) aSN1InputStream.readObject()));
                            stringBuffer.append(property);
                        } else if (dERObjectIdentifier.equals(X509Extensions.FreshestCRL)) {
                            stringBuffer.append(new CRLDistPoint((ASN1Sequence) aSN1InputStream.readObject()));
                            stringBuffer.append(property);
                        } else {
                            stringBuffer.append(dERObjectIdentifier.getId());
                            stringBuffer.append(" value = ");
                            stringBuffer.append(ASN1Dump.dumpAsString(aSN1InputStream.readObject()));
                            stringBuffer.append(property);
                        }
                    } catch (Exception unused) {
                        stringBuffer.append(dERObjectIdentifier.getId());
                        stringBuffer.append(" value = ");
                        stringBuffer.append("*****");
                        stringBuffer.append(property);
                    }
                } else {
                    stringBuffer.append(property);
                }
            }
        }
        Set<Object> revokedCertificates = getRevokedCertificates();
        if (revokedCertificates != null) {
            for (Object append : revokedCertificates) {
                stringBuffer.append(append);
                stringBuffer.append(property);
            }
        }
        return stringBuffer.toString();
    }

    public boolean isRevoked(Certificate certificate) {
        if (certificate.getType().equals("X.509")) {
            TBSCertList.CRLEntry[] revokedCertificates = this.f6246c.getRevokedCertificates();
            if (revokedCertificates != null) {
                BigInteger serialNumber = ((X509Certificate) certificate).getSerialNumber();
                for (TBSCertList.CRLEntry userCertificate : revokedCertificates) {
                    if (userCertificate.getUserCertificate().getValue().equals(serialNumber)) {
                        return true;
                    }
                }
            }
            return false;
        }
        throw new RuntimeException("X.509 CRL used with non X.509 Cert");
    }

    private boolean isIndirectCRL() throws CRLException {
        byte[] extensionValue = getExtensionValue(X509Extensions.IssuingDistributionPoint.getId());
        if (extensionValue == null) {
            return false;
        }
        try {
            return IssuingDistributionPoint.getInstance(X509ExtensionUtil.fromExtensionValue(extensionValue)).isIndirectCRL();
        } catch (Exception e) {
            throw new ExtCRLException("Exception reading IssuingDistributionPoint", e);
        }
    }
}
