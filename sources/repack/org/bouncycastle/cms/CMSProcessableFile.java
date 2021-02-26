package repack.org.bouncycastle.cms;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.cms.CMSObjectIdentifiers;

public class CMSProcessableFile implements CMSTypedData, CMSReadable {
    private static final int DEFAULT_BUF_SIZE = 32768;
    private final byte[] buf;
    private final File file;
    private final ASN1ObjectIdentifier type;

    public CMSProcessableFile(File file2) {
        this(file2, 32768);
    }

    public CMSProcessableFile(File file2, int i) {
        this(new ASN1ObjectIdentifier(CMSObjectIdentifiers.data.getId()), file2, i);
    }

    public CMSProcessableFile(ASN1ObjectIdentifier aSN1ObjectIdentifier, File file2, int i) {
        this.type = aSN1ObjectIdentifier;
        this.file = file2;
        this.buf = new byte[i];
    }

    public InputStream getInputStream() throws IOException, CMSException {
        return new BufferedInputStream(new FileInputStream(this.file), 32768);
    }

    public void write(OutputStream outputStream) throws IOException, CMSException {
        FileInputStream fileInputStream = new FileInputStream(this.file);
        while (true) {
            byte[] bArr = this.buf;
            int read = fileInputStream.read(bArr, 0, bArr.length);
            if (read <= 0) {
                fileInputStream.close();
                return;
            }
            outputStream.write(this.buf, 0, read);
        }
    }

    public Object getContent() {
        return this.file;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.type;
    }
}
