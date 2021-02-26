package p052cz.msebera.android.httpclient.entity.mime.content;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p052cz.msebera.android.httpclient.entity.ContentType;
import p052cz.msebera.android.httpclient.entity.mime.MIME;
import p052cz.msebera.android.httpclient.util.Args;

/* renamed from: cz.msebera.android.httpclient.entity.mime.content.InputStreamBody */
public class InputStreamBody extends AbstractContentBody {
    private final String filename;

    /* renamed from: in */
    private final InputStream f4878in;

    public long getContentLength() {
        return -1;
    }

    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    @Deprecated
    public InputStreamBody(InputStream inputStream, String str, String str2) {
        this(inputStream, ContentType.create(str), str2);
    }

    public InputStreamBody(InputStream inputStream, String str) {
        this(inputStream, ContentType.DEFAULT_BINARY, str);
    }

    public InputStreamBody(InputStream inputStream, ContentType contentType, String str) {
        super(contentType);
        Args.notNull(inputStream, "Input stream");
        this.f4878in = inputStream;
        this.filename = str;
    }

    public InputStreamBody(InputStream inputStream, ContentType contentType) {
        this(inputStream, contentType, (String) null);
    }

    public InputStream getInputStream() {
        return this.f4878in;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = this.f4878in.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            this.f4878in.close();
        }
    }

    public String getFilename() {
        return this.filename;
    }
}
