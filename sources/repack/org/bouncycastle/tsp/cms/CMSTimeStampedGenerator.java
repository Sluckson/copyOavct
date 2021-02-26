package repack.org.bouncycastle.tsp.cms;

import java.net.URI;
import repack.org.bouncycastle.asn1.DERBoolean;
import repack.org.bouncycastle.asn1.DERIA5String;
import repack.org.bouncycastle.asn1.DERUTF8String;
import repack.org.bouncycastle.asn1.cms.Attributes;
import repack.org.bouncycastle.asn1.cms.MetaData;
import repack.org.bouncycastle.cms.CMSException;
import repack.org.bouncycastle.operator.DigestCalculator;

public class CMSTimeStampedGenerator {
    protected URI dataUri;
    protected MetaData metaData;

    public void setDataUri(URI uri) {
        this.dataUri = uri;
    }

    public void setMetaData(boolean z, String str, String str2) {
        setMetaData(z, str, str2, (Attributes) null);
    }

    public void setMetaData(boolean z, String str, String str2, Attributes attributes) {
        DERIA5String dERIA5String = null;
        DERUTF8String dERUTF8String = str != null ? new DERUTF8String(str) : null;
        if (str2 != null) {
            dERIA5String = new DERIA5String(str2);
        }
        setMetaData(z, dERUTF8String, dERIA5String, attributes);
    }

    private void setMetaData(boolean z, DERUTF8String dERUTF8String, DERIA5String dERIA5String, Attributes attributes) {
        this.metaData = new MetaData(new DERBoolean(z), dERUTF8String, dERIA5String, attributes);
    }

    public void initialiseMessageImprintDigestCalculator(DigestCalculator digestCalculator) throws CMSException {
        new MetaDataUtil(this.metaData).initialiseMessageImprintDigestCalculator(digestCalculator);
    }
}
