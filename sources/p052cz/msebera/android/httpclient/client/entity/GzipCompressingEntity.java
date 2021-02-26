package p052cz.msebera.android.httpclient.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import p052cz.msebera.android.httpclient.message.BasicHeader;
import p052cz.msebera.android.httpclient.util.Args;

/* renamed from: cz.msebera.android.httpclient.client.entity.GzipCompressingEntity */
public class GzipCompressingEntity extends HttpEntityWrapper {
    private static final String GZIP_CODEC = "gzip";

    public long getContentLength() {
        return -1;
    }

    public boolean isChunked() {
        return true;
    }

    public GzipCompressingEntity(HttpEntity httpEntity) {
        super(httpEntity);
    }

    public Header getContentEncoding() {
        return new BasicHeader("Content-Encoding", "gzip");
    }

    public InputStream getContent() throws IOException {
        throw new UnsupportedOperationException();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        this.wrappedEntity.writeTo(gZIPOutputStream);
        gZIPOutputStream.close();
    }
}
