package p052cz.msebera.android.httpclient.client.methods;

import java.net.URI;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.ProtocolVersion;
import p052cz.msebera.android.httpclient.RequestLine;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.message.AbstractHttpMessage;
import p052cz.msebera.android.httpclient.message.BasicRequestLine;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.protocol.HTTP;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.client.methods.HttpRequestWrapper */
public class HttpRequestWrapper extends AbstractHttpMessage implements HttpUriRequest {
    private final String method;
    private final HttpRequest original;
    private URI uri;
    private ProtocolVersion version;

    public boolean isAborted() {
        return false;
    }

    private HttpRequestWrapper(HttpRequest httpRequest) {
        this.original = httpRequest;
        this.version = this.original.getRequestLine().getProtocolVersion();
        this.method = this.original.getRequestLine().getMethod();
        if (httpRequest instanceof HttpUriRequest) {
            this.uri = ((HttpUriRequest) httpRequest).getURI();
        } else {
            this.uri = null;
        }
        setHeaders(httpRequest.getAllHeaders());
    }

    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion protocolVersion = this.version;
        return protocolVersion != null ? protocolVersion : this.original.getProtocolVersion();
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.version = protocolVersion;
    }

    public URI getURI() {
        return this.uri;
    }

    public void setURI(URI uri2) {
        this.uri = uri2;
    }

    public String getMethod() {
        return this.method;
    }

    public void abort() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public RequestLine getRequestLine() {
        String str;
        URI uri2 = this.uri;
        if (uri2 != null) {
            str = uri2.toASCIIString();
        } else {
            str = this.original.getRequestLine().getUri();
        }
        if (str == null || str.length() == 0) {
            str = "/";
        }
        return new BasicRequestLine(this.method, str, getProtocolVersion());
    }

    public HttpRequest getOriginal() {
        return this.original;
    }

    public String toString() {
        return getRequestLine() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.headergroup;
    }

    /* renamed from: cz.msebera.android.httpclient.client.methods.HttpRequestWrapper$HttpEntityEnclosingRequestWrapper */
    static class HttpEntityEnclosingRequestWrapper extends HttpRequestWrapper implements HttpEntityEnclosingRequest {
        private HttpEntity entity;

        public HttpEntityEnclosingRequestWrapper(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
            super(httpEntityEnclosingRequest);
            this.entity = httpEntityEnclosingRequest.getEntity();
        }

        public HttpEntity getEntity() {
            return this.entity;
        }

        public void setEntity(HttpEntity httpEntity) {
            this.entity = httpEntity;
        }

        public boolean expectContinue() {
            Header firstHeader = getFirstHeader("Expect");
            return firstHeader != null && HTTP.EXPECT_CONTINUE.equalsIgnoreCase(firstHeader.getValue());
        }
    }

    public static HttpRequestWrapper wrap(HttpRequest httpRequest) {
        if (httpRequest == null) {
            return null;
        }
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            return new HttpEntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) httpRequest);
        }
        return new HttpRequestWrapper(httpRequest);
    }

    @Deprecated
    public HttpParams getParams() {
        if (this.params == null) {
            this.params = this.original.getParams().copy();
        }
        return this.params;
    }
}
