package p052cz.msebera.android.httpclient.impl.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import p052cz.msebera.android.httpclient.ProtocolException;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import p052cz.msebera.android.httpclient.protocol.HTTP;

@NotThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.EntityEnclosingRequestWrapper */
public class EntityEnclosingRequestWrapper extends RequestWrapper implements HttpEntityEnclosingRequest {
    /* access modifiers changed from: private */
    public boolean consumed;
    private HttpEntity entity;

    public EntityEnclosingRequestWrapper(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws ProtocolException {
        super(httpEntityEnclosingRequest);
        setEntity(httpEntityEnclosingRequest.getEntity());
    }

    public HttpEntity getEntity() {
        return this.entity;
    }

    public void setEntity(HttpEntity httpEntity) {
        this.entity = httpEntity != null ? new EntityWrapper(httpEntity) : null;
        this.consumed = false;
    }

    public boolean expectContinue() {
        Header firstHeader = getFirstHeader("Expect");
        return firstHeader != null && HTTP.EXPECT_CONTINUE.equalsIgnoreCase(firstHeader.getValue());
    }

    public boolean isRepeatable() {
        HttpEntity httpEntity = this.entity;
        return httpEntity == null || httpEntity.isRepeatable() || !this.consumed;
    }

    /* renamed from: cz.msebera.android.httpclient.impl.client.EntityEnclosingRequestWrapper$EntityWrapper */
    class EntityWrapper extends HttpEntityWrapper {
        EntityWrapper(HttpEntity httpEntity) {
            super(httpEntity);
        }

        public void consumeContent() throws IOException {
            boolean unused = EntityEnclosingRequestWrapper.this.consumed = true;
            super.consumeContent();
        }

        public InputStream getContent() throws IOException {
            boolean unused = EntityEnclosingRequestWrapper.this.consumed = true;
            return super.getContent();
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            boolean unused = EntityEnclosingRequestWrapper.this.consumed = true;
            super.writeTo(outputStream);
        }
    }
}
