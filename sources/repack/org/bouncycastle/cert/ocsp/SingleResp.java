package repack.org.bouncycastle.cert.ocsp;

import java.util.Date;
import java.util.List;
import java.util.Set;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ocsp.CertStatus;
import repack.org.bouncycastle.asn1.ocsp.RevokedInfo;
import repack.org.bouncycastle.asn1.ocsp.SingleResponse;
import repack.org.bouncycastle.asn1.x509.X509Extension;
import repack.org.bouncycastle.asn1.x509.X509Extensions;

public class SingleResp {
    private X509Extensions extensions;
    private SingleResponse resp;

    public SingleResp(SingleResponse singleResponse) {
        this.resp = singleResponse;
        this.extensions = singleResponse.getSingleExtensions();
    }

    public CertificateID getCertID() {
        return new CertificateID(this.resp.getCertID());
    }

    public CertificateStatus getCertStatus() {
        CertStatus certStatus = this.resp.getCertStatus();
        if (certStatus.getTagNo() == 0) {
            return null;
        }
        if (certStatus.getTagNo() == 1) {
            return new RevokedStatus(RevokedInfo.getInstance(certStatus.getStatus()));
        }
        return new UnknownStatus();
    }

    public Date getThisUpdate() {
        return OCSPUtils.extractDate(this.resp.getThisUpdate());
    }

    public Date getNextUpdate() {
        if (this.resp.getNextUpdate() == null) {
            return null;
        }
        return OCSPUtils.extractDate(this.resp.getNextUpdate());
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
        return OCSPUtils.getExtensionOIDs(this.extensions);
    }

    public Set getCriticalExtensionOIDs() {
        return OCSPUtils.getCriticalExtensionOIDs(this.extensions);
    }

    public Set getNonCriticalExtensionOIDs() {
        return OCSPUtils.getNonCriticalExtensionOIDs(this.extensions);
    }
}
