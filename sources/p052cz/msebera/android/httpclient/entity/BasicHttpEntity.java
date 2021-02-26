package p052cz.msebera.android.httpclient.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.Asserts;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.entity.BasicHttpEntity */
public class BasicHttpEntity extends AbstractHttpEntity {
    private InputStream content;
    private long length = -1;

    public boolean isRepeatable() {
        return false;
    }

    public long getContentLength() {
        return this.length;
    }

    public InputStream getContent() throws IllegalStateException {
        Asserts.check(this.content != null, "Content has not been provided");
        return this.content;
    }

    public void setContentLength(long j) {
        this.length = j;
    }

    public void setContent(InputStream inputStream) {
        this.content = inputStream;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        InputStream content2 = getContent();
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = content2.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        } finally {
            content2.close();
        }
    }

    public boolean isStreaming() {
        return this.content != null;
    }
}
