package p052cz.msebera.android.httpclient.impl.client;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.client.ClientProtocolException;
import p052cz.msebera.android.httpclient.client.HttpClient;
import p052cz.msebera.android.httpclient.client.ResponseHandler;
import p052cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import p052cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import p052cz.msebera.android.httpclient.client.utils.URIUtils;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.EntityUtils;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.client.CloseableHttpClient */
public abstract class CloseableHttpClient implements HttpClient, Closeable {
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    /* access modifiers changed from: protected */
    public abstract CloseableHttpResponse doExecute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException;

    public CloseableHttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        return doExecute(httpHost, httpRequest, httpContext);
    }

    public CloseableHttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        Args.notNull(httpUriRequest, "HTTP request");
        return doExecute(determineTarget(httpUriRequest), httpUriRequest, httpContext);
    }

    private static HttpHost determineTarget(HttpUriRequest httpUriRequest) throws ClientProtocolException {
        URI uri = httpUriRequest.getURI();
        if (!uri.isAbsolute()) {
            return null;
        }
        HttpHost extractHost = URIUtils.extractHost(uri);
        if (extractHost != null) {
            return extractHost;
        }
        throw new ClientProtocolException("URI does not specify a valid host name: " + uri);
    }

    public CloseableHttpResponse execute(HttpUriRequest httpUriRequest) throws IOException, ClientProtocolException {
        return execute(httpUriRequest, (HttpContext) null);
    }

    public CloseableHttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException, ClientProtocolException {
        return doExecute(httpHost, httpRequest, (HttpContext) null);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return execute(httpUriRequest, responseHandler, (HttpContext) null);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        return execute(determineTarget(httpUriRequest), httpUriRequest, responseHandler, httpContext);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return execute(httpHost, httpRequest, responseHandler, (HttpContext) null);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        Args.notNull(responseHandler, "Response handler");
        CloseableHttpResponse execute = execute(httpHost, httpRequest, httpContext);
        try {
            T handleResponse = responseHandler.handleResponse(execute);
            EntityUtils.consume(execute.getEntity());
            return handleResponse;
        } catch (Exception e) {
            try {
                EntityUtils.consume(execute.getEntity());
            } catch (Exception e2) {
                this.log.warn("Error consuming content after an exception.", e2);
            }
            if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            } else if (e instanceof IOException) {
                throw ((IOException) e);
            } else {
                throw new UndeclaredThrowableException(e);
            }
        }
    }
}
