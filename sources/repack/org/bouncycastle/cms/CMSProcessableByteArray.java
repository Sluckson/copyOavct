package repack.org.bouncycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.cms.CMSObjectIdentifiers;

public class CMSProcessableByteArray implements CMSTypedData, CMSReadable {
    private final byte[] bytes;
    private final ASN1ObjectIdentifier type;

    public CMSProcessableByteArray(byte[] bArr) {
        this(new ASN1ObjectIdentifier(CMSObjectIdentifiers.data.getId()), bArr);
    }

    public CMSProcessableByteArray(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr) {
        this.type = aSN1ObjectIdentifier;
        this.bytes = bArr;
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.bytes);
    }

    public void write(OutputStream outputStream) throws IOException, CMSException {
        outputStream.write(this.bytes);
    }

    public Object getContent() {
        return this.bytes.clone();
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.type;
    }
}
