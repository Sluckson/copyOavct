package repack.org.bouncycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRLException;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREnumerated;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.util.ASN1Dump;
import repack.org.bouncycastle.asn1.x509.CRLReason;
import repack.org.bouncycastle.asn1.x509.GeneralName;
import repack.org.bouncycastle.asn1.x509.GeneralNames;
import repack.org.bouncycastle.asn1.x509.TBSCertList;
import repack.org.bouncycastle.asn1.x509.X509Extension;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.x509.extension.X509ExtensionUtil;

public class X509CRLEntryObject extends X509CRLEntry {

    /* renamed from: c */
    private TBSCertList.CRLEntry f6245c;
    private X500Principal certificateIssuer = loadCertificateIssuer();
    private int hashValue;
    private boolean isHashValueSet;
    private boolean isIndirect;
    private X500Principal previousCertificateIssuer;

    public X509CRLEntryObject(TBSCertList.CRLEntry cRLEntry) {
        this.f6245c = cRLEntry;
    }

    public X509CRLEntryObject(TBSCertList.CRLEntry cRLEntry, boolean z, X500Principal x500Principal) {
        this.f6245c = cRLEntry;
        this.isIndirect = z;
        this.previousCertificateIssuer = x500Principal;
    }

    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        return criticalExtensionOIDs != null && !criticalExtensionOIDs.isEmpty();
    }

    private X500Principal loadCertificateIssuer() {
        if (!this.isIndirect) {
            return null;
        }
        byte[] extensionValue = getExtensionValue(X509Extensions.CertificateIssuer.getId());
        if (extensionValue == null) {
            return this.previousCertificateIssuer;
        }
        try {
            GeneralName[] names = GeneralNames.getInstance(X509ExtensionUtil.fromExtensionValue(extensionValue)).getNames();
            for (int i = 0; i < names.length; i++) {
                if (names[i].getTagNo() == 4) {
                    return new X500Principal(names[i].getName().getDERObject().getDEREncoded());
                }
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    public X500Principal getCertificateIssuer() {
        return this.certificateIssuer;
    }

    private Set getExtensionOIDs(boolean z) {
        X509Extensions extensions = this.f6245c.getExtensions();
        if (extensions == null) {
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
        X509Extensions extensions = this.f6245c.getExtensions();
        if (extensions == null || (extension = extensions.getExtension(new DERObjectIdentifier(str))) == null) {
            return null;
        }
        try {
            return extension.getValue().getEncoded();
        } catch (Exception e) {
            throw new RuntimeException("error encoding " + e.toString());
        }
    }

    public int hashCode() {
        if (!this.isHashValueSet) {
            this.hashValue = super.hashCode();
            this.isHashValueSet = true;
        }
        return this.hashValue;
    }

    public byte[] getEncoded() throws CRLException {
        try {
            return this.f6245c.getEncoded(ASN1Encodable.DER);
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    public BigInteger getSerialNumber() {
        return this.f6245c.getUserCertificate().getValue();
    }

    public Date getRevocationDate() {
        return this.f6245c.getRevocationDate().getDate();
    }

    public boolean hasExtensions() {
        return this.f6245c.getExtensions() != null;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String property = System.getProperty("line.separator");
        stringBuffer.append("      userCertificate: ");
        stringBuffer.append(getSerialNumber());
        stringBuffer.append(property);
        stringBuffer.append("       revocationDate: ");
        stringBuffer.append(getRevocationDate());
        stringBuffer.append(property);
        stringBuffer.append("       certificateIssuer: ");
        stringBuffer.append(getCertificateIssuer());
        stringBuffer.append(property);
        X509Extensions extensions = this.f6245c.getExtensions();
        if (extensions != null) {
            Enumeration oids = extensions.oids();
            if (oids.hasMoreElements()) {
                stringBuffer.append("   crlEntryExtensions:");
                stringBuffer.append(property);
                while (oids.hasMoreElements()) {
                    DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) oids.nextElement();
                    X509Extension extension = extensions.getExtension(dERObjectIdentifier);
                    if (extension.getValue() != null) {
                        ASN1InputStream aSN1InputStream = new ASN1InputStream(extension.getValue().getOctets());
                        stringBuffer.append("                       critical(");
                        stringBuffer.append(extension.isCritical());
                        stringBuffer.append(") ");
                        try {
                            if (dERObjectIdentifier.equals(X509Extensions.ReasonCode)) {
                                stringBuffer.append(new CRLReason(DEREnumerated.getInstance(aSN1InputStream.readObject())));
                                stringBuffer.append(property);
                            } else if (dERObjectIdentifier.equals(X509Extensions.CertificateIssuer)) {
                                stringBuffer.append("Certificate issuer: ");
                                stringBuffer.append(new GeneralNames((ASN1Sequence) aSN1InputStream.readObject()));
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
        }
        return stringBuffer.toString();
    }
}
