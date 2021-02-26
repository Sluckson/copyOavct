package repack.org.bouncycastle.cert;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.x509.TBSCertList;
import repack.org.bouncycastle.asn1.x509.X509Extension;
import repack.org.bouncycastle.asn1.x509.X509Extensions;

public class X509CRLEntryHolder {
    private TBSCertList.CRLEntry entry;
    private X509Extensions extensions;

    X509CRLEntryHolder(TBSCertList.CRLEntry cRLEntry) {
        this.entry = cRLEntry;
        this.extensions = cRLEntry.getExtensions();
    }

    public BigInteger getSerialNumber() {
        return this.entry.getUserCertificate().getValue();
    }

    public Date getRevocationDate() {
        return this.entry.getRevocationDate().getDate();
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
}
