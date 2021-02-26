package p052cz.msebera.android.httpclient.impl.client.cache;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.client.cache.InputLimit;
import p052cz.msebera.android.httpclient.client.cache.Resource;
import p052cz.msebera.android.httpclient.client.cache.ResourceFactory;
import p052cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import p052cz.msebera.android.httpclient.message.BasicHttpResponse;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.SizeLimitedResponseReader */
class SizeLimitedResponseReader {
    private boolean consumed;
    private InputStream instream;
    private InputLimit limit;
    private final long maxResponseSizeBytes;
    private final HttpRequest request;
    private Resource resource;
    private final ResourceFactory resourceFactory;
    /* access modifiers changed from: private */
    public final CloseableHttpResponse response;

    public SizeLimitedResponseReader(ResourceFactory resourceFactory2, long j, HttpRequest httpRequest, CloseableHttpResponse closeableHttpResponse) {
        this.resourceFactory = resourceFactory2;
        this.maxResponseSizeBytes = j;
        this.request = httpRequest;
        this.response = closeableHttpResponse;
    }

    /* access modifiers changed from: protected */
    public void readResponse() throws IOException {
        if (!this.consumed) {
            doConsume();
        }
    }

    private void ensureNotConsumed() {
        if (this.consumed) {
            throw new IllegalStateException("Response has already been consumed");
        }
    }

    private void ensureConsumed() {
        if (!this.consumed) {
            throw new IllegalStateException("Response has not been consumed");
        }
    }

    private void doConsume() throws IOException {
        ensureNotConsumed();
        this.consumed = true;
        this.limit = new InputLimit(this.maxResponseSizeBytes);
        HttpEntity entity = this.response.getEntity();
        if (entity != null) {
            String uri = this.request.getRequestLine().getUri();
            this.instream = entity.getContent();
            try {
                this.resource = this.resourceFactory.generate(uri, this.instream, this.limit);
            } finally {
                if (!this.limit.isReached()) {
                    this.instream.close();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isLimitReached() {
        ensureConsumed();
        return this.limit.isReached();
    }

    /* access modifiers changed from: package-private */
    public Resource getResource() {
        ensureConsumed();
        return this.resource;
    }

    /* access modifiers changed from: package-private */
    public CloseableHttpResponse getReconstructedResponse() throws IOException {
        ensureConsumed();
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(this.response.getStatusLine());
        basicHttpResponse.setHeaders(this.response.getAllHeaders());
        CombinedEntity combinedEntity = new CombinedEntity(this.resource, this.instream);
        HttpEntity entity = this.response.getEntity();
        if (entity != null) {
            combinedEntity.setContentType(entity.getContentType());
            combinedEntity.setContentEncoding(entity.getContentEncoding());
            combinedEntity.setChunked(entity.isChunked());
        }
        basicHttpResponse.setEntity(combinedEntity);
        return (CloseableHttpResponse) Proxy.newProxyInstance(ResponseProxyHandler.class.getClassLoader(), new Class[]{CloseableHttpResponse.class}, new ResponseProxyHandler(basicHttpResponse) {
            public void close() throws IOException {
                SizeLimitedResponseReader.this.response.close();
            }
        });
    }
}
