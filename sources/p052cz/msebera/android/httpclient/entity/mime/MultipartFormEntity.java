package p052cz.msebera.android.httpclient.entity.mime;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.message.BasicHeader;

/* renamed from: cz.msebera.android.httpclient.entity.mime.MultipartFormEntity */
class MultipartFormEntity implements HttpEntity {
    private final long contentLength;
    private final Header contentType;
    private final AbstractMultipartForm multipart;

    public Header getContentEncoding() {
        return null;
    }

    MultipartFormEntity(AbstractMultipartForm abstractMultipartForm, String str, long j) {
        this.multipart = abstractMultipartForm;
        this.contentType = new BasicHeader("Content-Type", str);
        this.contentLength = j;
    }

    /* access modifiers changed from: package-private */
    public AbstractMultipartForm getMultipart() {
        return this.multipart;
    }

    public boolean isRepeatable() {
        return this.contentLength != -1;
    }

    public boolean isChunked() {
        return !isRepeatable();
    }

    public boolean isStreaming() {
        return !isRepeatable();
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public Header getContentType() {
        return this.contentType;
    }

    public void consumeContent() throws IOException, UnsupportedOperationException {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public InputStream getContent() throws IOException {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        this.multipart.writeTo(outputStream);
    }
}
