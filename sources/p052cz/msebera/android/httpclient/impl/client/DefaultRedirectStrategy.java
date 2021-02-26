package p052cz.msebera.android.httpclient.impl.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpStatus;
import p052cz.msebera.android.httpclient.ProtocolException;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.CircularRedirectException;
import p052cz.msebera.android.httpclient.client.RedirectStrategy;
import p052cz.msebera.android.httpclient.client.config.RequestConfig;
import p052cz.msebera.android.httpclient.client.methods.HttpGet;
import p052cz.msebera.android.httpclient.client.methods.HttpHead;
import p052cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import p052cz.msebera.android.httpclient.client.methods.RequestBuilder;
import p052cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import p052cz.msebera.android.httpclient.client.utils.URIBuilder;
import p052cz.msebera.android.httpclient.client.utils.URIUtils;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.Asserts;
import p052cz.msebera.android.httpclient.util.TextUtils;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.DefaultRedirectStrategy */
public class DefaultRedirectStrategy implements RedirectStrategy {
    public static final DefaultRedirectStrategy INSTANCE = new DefaultRedirectStrategy();
    @Deprecated
    public static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    private static final String[] REDIRECT_METHODS = {"GET", "HEAD"};
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    public boolean isRedirected(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpResponse, "HTTP response");
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        String method = httpRequest.getRequestLine().getMethod();
        Header firstHeader = httpResponse.getFirstHeader("location");
        if (statusCode != 307) {
            switch (statusCode) {
                case 301:
                    break;
                case 302:
                    if (!isRedirectable(method) || firstHeader == null) {
                        return false;
                    }
                    return true;
                case HttpStatus.SC_SEE_OTHER:
                    return true;
                default:
                    return false;
            }
        }
        return isRedirectable(method);
    }

    public URI getLocationURI(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext adapt = HttpClientContext.adapt(httpContext);
        Header firstHeader = httpResponse.getFirstHeader("location");
        if (firstHeader != null) {
            String value = firstHeader.getValue();
            if (this.log.isDebugEnabled()) {
                HttpClientAndroidLog httpClientAndroidLog = this.log;
                httpClientAndroidLog.debug("Redirect requested to location '" + value + "'");
            }
            RequestConfig requestConfig = adapt.getRequestConfig();
            URI createLocationURI = createLocationURI(value);
            try {
                if (!createLocationURI.isAbsolute()) {
                    if (requestConfig.isRelativeRedirectsAllowed()) {
                        HttpHost targetHost = adapt.getTargetHost();
                        Asserts.notNull(targetHost, "Target host");
                        createLocationURI = URIUtils.resolve(URIUtils.rewriteURI(new URI(httpRequest.getRequestLine().getUri()), targetHost, false), createLocationURI);
                    } else {
                        throw new ProtocolException("Relative redirect location '" + createLocationURI + "' not allowed");
                    }
                }
                RedirectLocations redirectLocations = (RedirectLocations) adapt.getAttribute("http.protocol.redirect-locations");
                if (redirectLocations == null) {
                    redirectLocations = new RedirectLocations();
                    httpContext.setAttribute("http.protocol.redirect-locations", redirectLocations);
                }
                if (requestConfig.isCircularRedirectsAllowed() || !redirectLocations.contains(createLocationURI)) {
                    redirectLocations.add(createLocationURI);
                    return createLocationURI;
                }
                throw new CircularRedirectException("Circular redirect to '" + createLocationURI + "'");
            } catch (URISyntaxException e) {
                throw new ProtocolException(e.getMessage(), e);
            }
        } else {
            throw new ProtocolException("Received redirect response " + httpResponse.getStatusLine() + " but no location header");
        }
    }

    /* access modifiers changed from: protected */
    public URI createLocationURI(String str) throws ProtocolException {
        try {
            URIBuilder uRIBuilder = new URIBuilder(new URI(str).normalize());
            String host = uRIBuilder.getHost();
            if (host != null) {
                uRIBuilder.setHost(host.toLowerCase(Locale.ENGLISH));
            }
            if (TextUtils.isEmpty(uRIBuilder.getPath())) {
                uRIBuilder.setPath("/");
            }
            return uRIBuilder.build();
        } catch (URISyntaxException e) {
            throw new ProtocolException("Invalid redirect URI: " + str, e);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isRedirectable(String str) {
        for (String equalsIgnoreCase : REDIRECT_METHODS) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public HttpUriRequest getRedirect(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        URI locationURI = getLocationURI(httpRequest, httpResponse, httpContext);
        String method = httpRequest.getRequestLine().getMethod();
        if (method.equalsIgnoreCase("HEAD")) {
            return new HttpHead(locationURI);
        }
        if (method.equalsIgnoreCase("GET")) {
            return new HttpGet(locationURI);
        }
        if (httpResponse.getStatusLine().getStatusCode() == 307) {
            return RequestBuilder.copy(httpRequest).setUri(locationURI).build();
        }
        return new HttpGet(locationURI);
    }
}
