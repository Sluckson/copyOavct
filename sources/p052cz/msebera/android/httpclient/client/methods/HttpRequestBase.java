package p052cz.msebera.android.httpclient.client.methods;

import java.net.URI;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import p052cz.msebera.android.httpclient.ProtocolVersion;
import p052cz.msebera.android.httpclient.RequestLine;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.client.config.RequestConfig;
import p052cz.msebera.android.httpclient.message.BasicRequestLine;
import p052cz.msebera.android.httpclient.params.HttpProtocolParams;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.client.methods.HttpRequestBase */
public abstract class HttpRequestBase extends AbstractExecutionAwareRequest implements HttpUriRequest, Configurable {
    private RequestConfig config;
    private URI uri;
    private ProtocolVersion version;

    public abstract String getMethod();

    public void started() {
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.version = protocolVersion;
    }

    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion protocolVersion = this.version;
        return protocolVersion != null ? protocolVersion : HttpProtocolParams.getVersion(getParams());
    }

    public URI getURI() {
        return this.uri;
    }

    public RequestLine getRequestLine() {
        String method = getMethod();
        ProtocolVersion protocolVersion = getProtocolVersion();
        URI uri2 = getURI();
        String aSCIIString = uri2 != null ? uri2.toASCIIString() : null;
        if (aSCIIString == null || aSCIIString.length() == 0) {
            aSCIIString = "/";
        }
        return new BasicRequestLine(method, aSCIIString, protocolVersion);
    }

    public RequestConfig getConfig() {
        return this.config;
    }

    public void setConfig(RequestConfig requestConfig) {
        this.config = requestConfig;
    }

    public void setURI(URI uri2) {
        this.uri = uri2;
    }

    public void releaseConnection() {
        reset();
    }

    public String toString() {
        return getMethod() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getURI() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getProtocolVersion();
    }
}
