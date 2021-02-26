package repack.org.bouncycastle.ocsp;

import java.security.cert.X509Extension;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.ocsp.Request;
import repack.org.bouncycastle.asn1.x509.X509Extensions;

public class Req implements X509Extension {
    private Request req;

    public Req(Request request) {
        this.req = request;
    }

    public CertificateID getCertID() {
        return new CertificateID(this.req.getReqCert());
    }

    public X509Extensions getSingleRequestExtensions() {
        return this.req.getSingleRequestExtensions();
    }

    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        return criticalExtensionOIDs != null && !criticalExtensionOIDs.isEmpty();
    }

    private Set getExtensionOIDs(boolean z) {
        HashSet hashSet = new HashSet();
        X509Extensions singleRequestExtensions = getSingleRequestExtensions();
        if (singleRequestExtensions != null) {
            Enumeration oids = singleRequestExtensions.oids();
            while (oids.hasMoreElements()) {
                DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) oids.nextElement();
                if (z == singleRequestExtensions.getExtension(dERObjectIdentifier).isCritical()) {
                    hashSet.add(dERObjectIdentifier.getId());
                }
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
        repack.org.bouncycastle.asn1.x509.X509Extension extension;
        X509Extensions singleRequestExtensions = getSingleRequestExtensions();
        if (singleRequestExtensions == null || (extension = singleRequestExtensions.getExtension(new DERObjectIdentifier(str))) == null) {
            return null;
        }
        try {
            return extension.getValue().getEncoded(ASN1Encodable.DER);
        } catch (Exception e) {
            throw new RuntimeException("error encoding " + e.toString());
        }
    }
}
