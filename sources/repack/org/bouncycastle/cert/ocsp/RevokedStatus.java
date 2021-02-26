package repack.org.bouncycastle.cert.ocsp;

import java.util.Date;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.ocsp.RevokedInfo;
import repack.org.bouncycastle.asn1.x509.CRLReason;

public class RevokedStatus implements CertificateStatus {
    RevokedInfo info;

    public RevokedStatus(RevokedInfo revokedInfo) {
        this.info = revokedInfo;
    }

    public RevokedStatus(Date date, int i) {
        this.info = new RevokedInfo(new DERGeneralizedTime(date), new CRLReason(i));
    }

    public Date getRevocationTime() {
        return OCSPUtils.extractDate(this.info.getRevocationTime());
    }

    public boolean hasRevocationReason() {
        return this.info.getRevocationReason() != null;
    }

    public int getRevocationReason() {
        if (this.info.getRevocationReason() != null) {
            return this.info.getRevocationReason().getValue().intValue();
        }
        throw new IllegalStateException("attempt to get a reason where none is available");
    }
}
