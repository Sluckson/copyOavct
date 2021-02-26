package p052cz.msebera.android.httpclient.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.entity.HttpEntityWrapper */
public class HttpEntityWrapper implements HttpEntity {
    protected HttpEntity wrappedEntity;

    public HttpEntityWrapper(HttpEntity httpEntity) {
        this.wrappedEntity = (HttpEntity) Args.notNull(httpEntity, "Wrapped entity");
    }

    public boolean isRepeatable() {
        return this.wrappedEntity.isRepeatable();
    }

    public boolean isChunked() {
        return this.wrappedEntity.isChunked();
    }

    public long getContentLength() {
        return this.wrappedEntity.getContentLength();
    }

    public Header getContentType() {
        return this.wrappedEntity.getContentType();
    }

    public Header getContentEncoding() {
        return this.wrappedEntity.getContentEncoding();
    }

    public InputStream getContent() throws IOException {
        return this.wrappedEntity.getContent();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        this.wrappedEntity.writeTo(outputStream);
    }

    public boolean isStreaming() {
        return this.wrappedEntity.isStreaming();
    }

    @Deprecated
    public void consumeContent() throws IOException {
        this.wrappedEntity.consumeContent();
    }
}
