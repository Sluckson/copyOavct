package p052cz.msebera.android.httpclient.entity.mime.content;

import java.io.IOException;
import java.io.OutputStream;
import p052cz.msebera.android.httpclient.entity.ContentType;
import p052cz.msebera.android.httpclient.entity.mime.MIME;
import p052cz.msebera.android.httpclient.util.Args;

/* renamed from: cz.msebera.android.httpclient.entity.mime.content.ByteArrayBody */
public class ByteArrayBody extends AbstractContentBody {
    private final byte[] data;
    private final String filename;

    public String getCharset() {
        return null;
    }

    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    @Deprecated
    public ByteArrayBody(byte[] bArr, String str, String str2) {
        this(bArr, ContentType.create(str), str2);
    }

    public ByteArrayBody(byte[] bArr, ContentType contentType, String str) {
        super(contentType);
        Args.notNull(bArr, "byte[]");
        this.data = bArr;
        this.filename = str;
    }

    public ByteArrayBody(byte[] bArr, String str) {
        this(bArr, "application/octet-stream", str);
    }

    public String getFilename() {
        return this.filename;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.data);
    }

    public long getContentLength() {
        return (long) this.data.length;
    }
}
