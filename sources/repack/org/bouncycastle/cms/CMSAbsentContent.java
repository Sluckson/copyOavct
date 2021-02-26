package repack.org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.cms.CMSObjectIdentifiers;

public class CMSAbsentContent implements CMSTypedData, CMSReadable {
    private final ASN1ObjectIdentifier type;

    public Object getContent() {
        return null;
    }

    public InputStream getInputStream() {
        return null;
    }

    public void write(OutputStream outputStream) throws IOException, CMSException {
    }

    public CMSAbsentContent() {
        this(new ASN1ObjectIdentifier(CMSObjectIdentifiers.data.getId()));
    }

    public CMSAbsentContent(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.type = aSN1ObjectIdentifier;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.type;
    }
}
