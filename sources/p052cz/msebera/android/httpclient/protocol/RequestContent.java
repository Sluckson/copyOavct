package p052cz.msebera.android.httpclient.protocol;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpRequestInterceptor;
import p052cz.msebera.android.httpclient.HttpVersion;
import p052cz.msebera.android.httpclient.ProtocolException;
import p052cz.msebera.android.httpclient.ProtocolVersion;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.protocol.RequestContent */
public class RequestContent implements HttpRequestInterceptor {
    private final boolean overwrite;

    public RequestContent() {
        this(false);
    }

    public RequestContent(boolean z) {
        this.overwrite = z;
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            if (this.overwrite) {
                httpRequest.removeHeaders("Transfer-Encoding");
                httpRequest.removeHeaders("Content-Length");
            } else if (httpRequest.containsHeader("Transfer-Encoding")) {
                throw new ProtocolException("Transfer-encoding header already present");
            } else if (httpRequest.containsHeader("Content-Length")) {
                throw new ProtocolException("Content-Length header already present");
            }
            ProtocolVersion protocolVersion = httpRequest.getRequestLine().getProtocolVersion();
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
            if (entity == null) {
                httpRequest.addHeader("Content-Length", "0");
                return;
            }
            if (!entity.isChunked() && entity.getContentLength() >= 0) {
                httpRequest.addHeader("Content-Length", Long.toString(entity.getContentLength()));
            } else if (!protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                httpRequest.addHeader("Transfer-Encoding", HTTP.CHUNK_CODING);
            } else {
                throw new ProtocolException("Chunked transfer encoding not allowed for " + protocolVersion);
            }
            if (entity.getContentType() != null && !httpRequest.containsHeader("Content-Type")) {
                httpRequest.addHeader(entity.getContentType());
            }
            if (entity.getContentEncoding() != null && !httpRequest.containsHeader("Content-Encoding")) {
                httpRequest.addHeader(entity.getContentEncoding());
            }
        }
    }
}
