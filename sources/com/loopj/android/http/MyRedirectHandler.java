package com.loopj.android.http;

import java.net.URI;
import java.net.URISyntaxException;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpStatus;
import p052cz.msebera.android.httpclient.ProtocolException;
import p052cz.msebera.android.httpclient.client.CircularRedirectException;
import p052cz.msebera.android.httpclient.client.params.ClientPNames;
import p052cz.msebera.android.httpclient.client.utils.URIUtils;
import p052cz.msebera.android.httpclient.impl.client.DefaultRedirectHandler;
import p052cz.msebera.android.httpclient.impl.client.RedirectLocations;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

class MyRedirectHandler extends DefaultRedirectHandler {
    private static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    private final boolean enableRedirects;

    public MyRedirectHandler(boolean z) {
        this.enableRedirects = z;
    }

    public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        if (!this.enableRedirects) {
            return false;
        }
        if (httpResponse != null) {
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 307) {
                return true;
            }
            switch (statusCode) {
                case 301:
                case 302:
                case HttpStatus.SC_SEE_OTHER /*303*/:
                    return true;
                default:
                    return false;
            }
        } else {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
    }

    public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        URI uri;
        if (httpResponse != null) {
            Header firstHeader = httpResponse.getFirstHeader("location");
            if (firstHeader != null) {
                String replaceAll = firstHeader.getValue().replaceAll(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "%20");
                try {
                    URI uri2 = new URI(replaceAll);
                    HttpParams params = httpResponse.getParams();
                    if (!uri2.isAbsolute()) {
                        if (!params.isParameterTrue(ClientPNames.REJECT_RELATIVE_REDIRECT)) {
                            HttpHost httpHost = (HttpHost) httpContext.getAttribute("http.target_host");
                            if (httpHost != null) {
                                try {
                                    uri2 = URIUtils.resolve(URIUtils.rewriteURI(new URI(((HttpRequest) httpContext.getAttribute("http.request")).getRequestLine().getUri()), httpHost, true), uri2);
                                } catch (URISyntaxException e) {
                                    throw new ProtocolException(e.getMessage(), e);
                                }
                            } else {
                                throw new IllegalStateException("Target host not available in the HTTP context");
                            }
                        } else {
                            throw new ProtocolException("Relative redirect location '" + uri2 + "' not allowed");
                        }
                    }
                    if (params.isParameterFalse(ClientPNames.ALLOW_CIRCULAR_REDIRECTS)) {
                        RedirectLocations redirectLocations = (RedirectLocations) httpContext.getAttribute("http.protocol.redirect-locations");
                        if (redirectLocations == null) {
                            redirectLocations = new RedirectLocations();
                            httpContext.setAttribute("http.protocol.redirect-locations", redirectLocations);
                        }
                        if (uri2.getFragment() != null) {
                            try {
                                uri = URIUtils.rewriteURI(uri2, new HttpHost(uri2.getHost(), uri2.getPort(), uri2.getScheme()), true);
                            } catch (URISyntaxException e2) {
                                throw new ProtocolException(e2.getMessage(), e2);
                            }
                        } else {
                            uri = uri2;
                        }
                        if (!redirectLocations.contains(uri)) {
                            redirectLocations.add(uri);
                        } else {
                            throw new CircularRedirectException("Circular redirect to '" + uri + "'");
                        }
                    }
                    return uri2;
                } catch (URISyntaxException e3) {
                    throw new ProtocolException("Invalid redirect URI: " + replaceAll, e3);
                }
            } else {
                throw new ProtocolException("Received redirect response " + httpResponse.getStatusLine() + " but no location header");
            }
        } else {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
    }
}
