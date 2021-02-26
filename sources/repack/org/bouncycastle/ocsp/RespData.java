package repack.org.bouncycastle.ocsp;

import java.security.cert.X509Extension;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.ocsp.ResponseData;
import repack.org.bouncycastle.asn1.ocsp.SingleResponse;
import repack.org.bouncycastle.asn1.x509.X509Extensions;

public class RespData implements X509Extension {
    ResponseData data;

    public RespData(ResponseData responseData) {
        this.data = responseData;
    }

    public int getVersion() {
        return this.data.getVersion().getValue().intValue() + 1;
    }

    public RespID getResponderId() {
        return new RespID(this.data.getResponderID());
    }

    public Date getProducedAt() {
        try {
            return this.data.getProducedAt().getDate();
        } catch (ParseException e) {
            throw new IllegalStateException("ParseException:" + e.getMessage());
        }
    }

    public SingleResp[] getResponses() {
        ASN1Sequence responses = this.data.getResponses();
        SingleResp[] singleRespArr = new SingleResp[responses.size()];
        for (int i = 0; i != singleRespArr.length; i++) {
            singleRespArr[i] = new SingleResp(SingleResponse.getInstance(responses.getObjectAt(i)));
        }
        return singleRespArr;
    }

    public X509Extensions getResponseExtensions() {
        return this.data.getResponseExtensions();
    }

    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        return criticalExtensionOIDs != null && !criticalExtensionOIDs.isEmpty();
    }

    private Set getExtensionOIDs(boolean z) {
        HashSet hashSet = new HashSet();
        X509Extensions responseExtensions = getResponseExtensions();
        if (responseExtensions != null) {
            Enumeration oids = responseExtensions.oids();
            while (oids.hasMoreElements()) {
                DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) oids.nextElement();
                if (z == responseExtensions.getExtension(dERObjectIdentifier).isCritical()) {
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
        X509Extensions responseExtensions = getResponseExtensions();
        if (responseExtensions == null || (extension = responseExtensions.getExtension(new DERObjectIdentifier(str))) == null) {
            return null;
        }
        try {
            return extension.getValue().getEncoded(ASN1Encodable.DER);
        } catch (Exception e) {
            throw new RuntimeException("error encoding " + e.toString());
        }
    }
}
