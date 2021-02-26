package p052cz.msebera.android.httpclient.impl.client;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpRequestInterceptor;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpResponseInterceptor;
import p052cz.msebera.android.httpclient.client.ClientProtocolException;
import p052cz.msebera.android.httpclient.client.HttpClient;
import p052cz.msebera.android.httpclient.client.ResponseHandler;
import p052cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import p052cz.msebera.android.httpclient.client.protocol.RequestAcceptEncoding;
import p052cz.msebera.android.httpclient.client.protocol.ResponseContentEncoding;
import p052cz.msebera.android.httpclient.client.utils.URIUtils;
import p052cz.msebera.android.httpclient.conn.ClientConnectionManager;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.protocol.BasicHttpContext;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.EntityUtils;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.DecompressingHttpClient */
public class DecompressingHttpClient implements HttpClient {
    private final HttpRequestInterceptor acceptEncodingInterceptor;
    private final HttpClient backend;
    private final HttpResponseInterceptor contentEncodingInterceptor;

    public DecompressingHttpClient() {
        this(new DefaultHttpClient());
    }

    public DecompressingHttpClient(HttpClient httpClient) {
        this(httpClient, new RequestAcceptEncoding(), new ResponseContentEncoding());
    }

    DecompressingHttpClient(HttpClient httpClient, HttpRequestInterceptor httpRequestInterceptor, HttpResponseInterceptor httpResponseInterceptor) {
        this.backend = httpClient;
        this.acceptEncodingInterceptor = httpRequestInterceptor;
        this.contentEncodingInterceptor = httpResponseInterceptor;
    }

    public HttpParams getParams() {
        return this.backend.getParams();
    }

    public ClientConnectionManager getConnectionManager() {
        return this.backend.getConnectionManager();
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException, ClientProtocolException {
        return execute(getHttpHost(httpUriRequest), (HttpRequest) httpUriRequest, (HttpContext) null);
    }

    public HttpClient getHttpClient() {
        return this.backend;
    }

    /* access modifiers changed from: package-private */
    public HttpHost getHttpHost(HttpUriRequest httpUriRequest) {
        return URIUtils.extractHost(httpUriRequest.getURI());
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        return execute(getHttpHost(httpUriRequest), (HttpRequest) httpUriRequest, httpContext);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException, ClientProtocolException {
        return execute(httpHost, httpRequest, (HttpContext) null);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        HttpRequest httpRequest2;
        HttpResponse execute;
        if (httpContext == null) {
            try {
                httpContext = new BasicHttpContext();
            } catch (HttpException e) {
                EntityUtils.consume(execute.getEntity());
                throw e;
            } catch (IOException e2) {
                EntityUtils.consume(execute.getEntity());
                throw e2;
            } catch (RuntimeException e3) {
                EntityUtils.consume(execute.getEntity());
                throw e3;
            } catch (HttpException e4) {
                throw new ClientProtocolException((Throwable) e4);
            }
        }
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            httpRequest2 = new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) httpRequest);
        } else {
            httpRequest2 = new RequestWrapper(httpRequest);
        }
        this.acceptEncodingInterceptor.process(httpRequest2, httpContext);
        execute = this.backend.execute(httpHost, httpRequest2, httpContext);
        this.contentEncodingInterceptor.process(execute, httpContext);
        if (Boolean.TRUE.equals(httpContext.getAttribute(ResponseContentEncoding.UNCOMPRESSED))) {
            execute.removeHeaders("Content-Length");
            execute.removeHeaders("Content-Encoding");
            execute.removeHeaders("Content-MD5");
        }
        return execute;
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return execute(getHttpHost(httpUriRequest), (HttpRequest) httpUriRequest, responseHandler);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        return execute(getHttpHost(httpUriRequest), httpUriRequest, responseHandler, httpContext);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return execute(httpHost, httpRequest, responseHandler, (HttpContext) null);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        HttpResponse execute = execute(httpHost, httpRequest, httpContext);
        try {
            return responseHandler.handleResponse(execute);
        } finally {
            HttpEntity entity = execute.getEntity();
            if (entity != null) {
                EntityUtils.consume(entity);
            }
        }
    }
}
