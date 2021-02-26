package repack.org.bouncycastle.cms;

import java.security.cert.X509CertSelector;
import repack.org.bouncycastle.util.Arrays;

class OriginatorId extends X509CertSelector {
    OriginatorId() {
    }

    public int hashCode() {
        int hashCode = Arrays.hashCode(getSubjectKeyIdentifier());
        if (getSerialNumber() != null) {
            hashCode ^= getSerialNumber().hashCode();
        }
        return getIssuerAsString() != null ? hashCode ^ getIssuerAsString().hashCode() : hashCode;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof OriginatorId)) {
            return false;
        }
        OriginatorId originatorId = (OriginatorId) obj;
        if (!Arrays.areEqual(getSubjectKeyIdentifier(), originatorId.getSubjectKeyIdentifier()) || !equalsObj(getSerialNumber(), originatorId.getSerialNumber()) || !equalsObj(getIssuerAsString(), originatorId.getIssuerAsString())) {
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
}
