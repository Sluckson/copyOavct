package p052cz.msebera.android.httpclient.impl.client.cache;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.CacheEntity */
class CacheEntity implements HttpEntity, Serializable {
    private static final long serialVersionUID = -3467082284120936233L;
    private final HttpCacheEntry cacheEntry;

    public void consumeContent() throws IOException {
    }

    public boolean isChunked() {
        return false;
    }

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return false;
    }

    public CacheEntity(HttpCacheEntry httpCacheEntry) {
        this.cacheEntry = httpCacheEntry;
    }

    public Header getContentType() {
        return this.cacheEntry.getFirstHeader("Content-Type");
    }

    public Header getContentEncoding() {
        return this.cacheEntry.getFirstHeader("Content-Encoding");
    }

    public long getContentLength() {
        return this.cacheEntry.getResource().length();
    }

    public InputStream getContent() throws IOException {
        return this.cacheEntry.getResource().getInputStream();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        InputStream inputStream = this.cacheEntry.getResource().getInputStream();
        try {
            IOUtils.copy(inputStream, outputStream);
        } finally {
            inputStream.close();
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
