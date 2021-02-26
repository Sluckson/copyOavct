package p052cz.msebera.android.httpclient.impl.client;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.client.ClientProtocolException;
import p052cz.msebera.android.httpclient.client.config.RequestConfig;
import p052cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import p052cz.msebera.android.httpclient.client.methods.Configurable;
import p052cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import p052cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import p052cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import p052cz.msebera.android.httpclient.conn.ClientConnectionManager;
import p052cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import p052cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import p052cz.msebera.android.httpclient.conn.ManagedClientConnection;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import p052cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import p052cz.msebera.android.httpclient.impl.execchain.MinimalClientExec;
import p052cz.msebera.android.httpclient.params.BasicHttpParams;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.protocol.BasicHttpContext;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import p052cz.msebera.android.httpclient.util.Args;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.client.MinimalHttpClient */
class MinimalHttpClient extends CloseableHttpClient {
    /* access modifiers changed from: private */
    public final HttpClientConnectionManager connManager;
    private final HttpParams params = new BasicHttpParams();
    private final MinimalClientExec requestExecutor;

    public MinimalHttpClient(HttpClientConnectionManager httpClientConnectionManager) {
        this.connManager = (HttpClientConnectionManager) Args.notNull(httpClientConnectionManager, "HTTP connection manager");
        this.requestExecutor = new MinimalClientExec(new HttpRequestExecutor(), httpClientConnectionManager, DefaultConnectionReuseStrategy.INSTANCE, DefaultConnectionKeepAliveStrategy.INSTANCE);
    }

    /* access modifiers changed from: protected */
    public CloseableHttpResponse doExecute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        Args.notNull(httpHost, "Target host");
        Args.notNull(httpRequest, "HTTP request");
        RequestConfig requestConfig = null;
        HttpExecutionAware httpExecutionAware = httpRequest instanceof HttpExecutionAware ? (HttpExecutionAware) httpRequest : null;
        try {
            HttpRequestWrapper wrap = HttpRequestWrapper.wrap(httpRequest);
            if (httpContext == null) {
                httpContext = new BasicHttpContext();
            }
            HttpClientContext adapt = HttpClientContext.adapt(httpContext);
            HttpRoute httpRoute = new HttpRoute(httpHost);
            if (httpRequest instanceof Configurable) {
                requestConfig = ((Configurable) httpRequest).getConfig();
            }
            if (requestConfig != null) {
                adapt.setRequestConfig(requestConfig);
            }
            return this.requestExecutor.execute(httpRoute, wrap, adapt, httpExecutionAware);
        } catch (HttpException e) {
            throw new ClientProtocolException((Throwable) e);
        }
    }

    public HttpParams getParams() {
        return this.params;
    }

    public void close() {
        this.connManager.shutdown();
    }

    public ClientConnectionManager getConnectionManager() {
        return new ClientConnectionManager() {
            public void shutdown() {
                MinimalHttpClient.this.connManager.shutdown();
            }

            public ClientConnectionRequest requestConnection(HttpRoute httpRoute, Object obj) {
                throw new UnsupportedOperationException();
            }

            public void releaseConnection(ManagedClientConnection managedClientConnection, long j, TimeUnit timeUnit) {
                throw new UnsupportedOperationException();
            }

            public SchemeRegistry getSchemeRegistry() {
                throw new UnsupportedOperationException();
            }

            public void closeIdleConnections(long j, TimeUnit timeUnit) {
                MinimalHttpClient.this.connManager.closeIdleConnections(j, timeUnit);
            }

            public void closeExpiredConnections() {
                MinimalHttpClient.this.connManager.closeExpiredConnections();
            }
        };
    }
}
