package p052cz.msebera.android.httpclient.impl.client;

import java.net.URI;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.ProtocolException;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.RedirectHandler;
import p052cz.msebera.android.httpclient.client.RedirectStrategy;
import p052cz.msebera.android.httpclient.client.methods.HttpGet;
import p052cz.msebera.android.httpclient.client.methods.HttpHead;
import p052cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

@Immutable
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.DefaultRedirectStrategyAdaptor */
class DefaultRedirectStrategyAdaptor implements RedirectStrategy {
    private final RedirectHandler handler;

    public DefaultRedirectStrategyAdaptor(RedirectHandler redirectHandler) {
        this.handler = redirectHandler;
    }

    public boolean isRedirected(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        return this.handler.isRedirectRequested(httpResponse, httpContext);
    }

    public HttpUriRequest getRedirect(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        URI locationURI = this.handler.getLocationURI(httpResponse, httpContext);
        if (httpRequest.getRequestLine().getMethod().equalsIgnoreCase("HEAD")) {
            return new HttpHead(locationURI);
        }
        return new HttpGet(locationURI);
    }

    public RedirectHandler getHandler() {
        return this.handler;
    }
}
