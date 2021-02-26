package repack.org.bouncycastle.tsp.cms;

import java.io.IOException;
import repack.org.bouncycastle.asn1.ASN1String;
import repack.org.bouncycastle.asn1.cms.Attributes;
import repack.org.bouncycastle.asn1.cms.MetaData;
import repack.org.bouncycastle.cms.CMSException;
import repack.org.bouncycastle.operator.DigestCalculator;

class MetaDataUtil {
    private final MetaData metaData;

    MetaDataUtil(MetaData metaData2) {
        this.metaData = metaData2;
    }

    /* access modifiers changed from: package-private */
    public void initialiseMessageImprintDigestCalculator(DigestCalculator digestCalculator) throws CMSException {
        MetaData metaData2 = this.metaData;
        if (metaData2 != null && metaData2.isHashProtected()) {
            try {
                digestCalculator.getOutputStream().write(this.metaData.getDEREncoded());
            } catch (IOException e) {
                throw new CMSException("unable to initialise calculator from metaData: " + e.getMessage(), e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String getFileName() {
        MetaData metaData2 = this.metaData;
        if (metaData2 != null) {
            return convertString(metaData2.getFileName());
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public String getMediaType() {
        MetaData metaData2 = this.metaData;
        if (metaData2 != null) {
            return convertString(metaData2.getMediaType());
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Attributes getOtherMetaData() {
        MetaData metaData2 = this.metaData;
        if (metaData2 != null) {
            return metaData2.getOtherMetaData();
        }
        return null;
    }

    private String convertString(ASN1String aSN1String) {
        if (aSN1String != null) {
            return aSN1String.toString();
        }
        return null;
    }
}
