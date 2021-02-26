package p052cz.msebera.android.httpclient.impl.client;

import java.net.URI;
import java.net.URISyntaxException;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.ProtocolException;
import p052cz.msebera.android.httpclient.ProtocolVersion;
import p052cz.msebera.android.httpclient.RequestLine;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import p052cz.msebera.android.httpclient.message.AbstractHttpMessage;
import p052cz.msebera.android.httpclient.message.BasicRequestLine;
import p052cz.msebera.android.httpclient.params.HttpProtocolParams;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.RequestWrapper */
public class RequestWrapper extends AbstractHttpMessage implements HttpUriRequest {
    private int execCount;
    private String method;
    private final HttpRequest original;
    private URI uri;
    private ProtocolVersion version;

    public boolean isAborted() {
        return false;
    }

    public boolean isRepeatable() {
        return true;
    }

    public RequestWrapper(HttpRequest httpRequest) throws ProtocolException {
        Args.notNull(httpRequest, "HTTP request");
        this.original = httpRequest;
        setParams(httpRequest.getParams());
        setHeaders(httpRequest.getAllHeaders());
        if (httpRequest instanceof HttpUriRequest) {
            HttpUriRequest httpUriRequest = (HttpUriRequest) httpRequest;
            this.uri = httpUriRequest.getURI();
            this.method = httpUriRequest.getMethod();
            this.version = null;
        } else {
            RequestLine requestLine = httpRequest.getRequestLine();
            try {
                this.uri = new URI(requestLine.getUri());
                this.method = requestLine.getMethod();
                this.version = httpRequest.getProtocolVersion();
            } catch (URISyntaxException e) {
                throw new ProtocolException("Invalid request URI: " + requestLine.getUri(), e);
            }
        }
        this.execCount = 0;
    }

    public void resetHeaders() {
        this.headergroup.clear();
        setHeaders(this.original.getAllHeaders());
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        Args.notNull(str, "Method name");
        this.method = str;
    }

    public ProtocolVersion getProtocolVersion() {
        if (this.version == null) {
            this.version = HttpProtocolParams.getVersion(getParams());
        }
        return this.version;
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

    public RequestLine getRequestLine() {
        String method2 = getMethod();
        ProtocolVersion protocolVersion = getProtocolVersion();
        URI uri2 = this.uri;
        String aSCIIString = uri2 != null ? uri2.toASCIIString() : null;
        if (aSCIIString == null || aSCIIString.length() == 0) {
            aSCIIString = "/";
        }
        return new BasicRequestLine(method2, aSCIIString, protocolVersion);
    }

    public void abort() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public HttpRequest getOriginal() {
        return this.original;
    }

    public int getExecCount() {
        return this.execCount;
    }

    public void incrementExecCount() {
        this.execCount++;
    }
}
