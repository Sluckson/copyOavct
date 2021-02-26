package p052cz.msebera.android.httpclient.impl.execchain;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.execchain.RequestEntityProxy */
class RequestEntityProxy implements HttpEntity {
    private boolean consumed = false;
    private final HttpEntity original;

    static void enhance(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        HttpEntity entity = httpEntityEnclosingRequest.getEntity();
        if (entity != null && !entity.isRepeatable() && !isEnhanced(entity)) {
            httpEntityEnclosingRequest.setEntity(new RequestEntityProxy(entity));
        }
    }

    static boolean isEnhanced(HttpEntity httpEntity) {
        return httpEntity instanceof RequestEntityProxy;
    }

    static boolean isRepeatable(HttpRequest httpRequest) {
        HttpEntity entity;
        if (!(httpRequest instanceof HttpEntityEnclosingRequest) || (entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity()) == null) {
            return true;
        }
        if (!isEnhanced(entity) || ((RequestEntityProxy) entity).isConsumed()) {
            return entity.isRepeatable();
        }
        return true;
    }

    RequestEntityProxy(HttpEntity httpEntity) {
        this.original = httpEntity;
    }

    public HttpEntity getOriginal() {
        return this.original;
    }

    public boolean isConsumed() {
        return this.consumed;
    }

    public boolean isRepeatable() {
        return this.original.isRepeatable();
    }

    public boolean isChunked() {
        return this.original.isChunked();
    }

    public long getContentLength() {
        return this.original.getContentLength();
    }

    public Header getContentType() {
        return this.original.getContentType();
    }

    public Header getContentEncoding() {
        return this.original.getContentEncoding();
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        return this.original.getContent();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        this.consumed = true;
        this.original.writeTo(outputStream);
    }

    public boolean isStreaming() {
        return this.original.isStreaming();
    }

    @Deprecated
    public void consumeContent() throws IOException {
        this.consumed = true;
        this.original.consumeContent();
    }

    public String toString() {
        return "RequestEntityProxy{" + this.original + '}';
    }
}
