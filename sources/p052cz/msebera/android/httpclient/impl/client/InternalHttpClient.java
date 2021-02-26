package p052cz.msebera.android.httpclient.impl.client;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import p052cz.msebera.android.httpclient.auth.AuthState;
import p052cz.msebera.android.httpclient.client.ClientProtocolException;
import p052cz.msebera.android.httpclient.client.CookieStore;
import p052cz.msebera.android.httpclient.client.CredentialsProvider;
import p052cz.msebera.android.httpclient.client.config.RequestConfig;
import p052cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import p052cz.msebera.android.httpclient.client.methods.Configurable;
import p052cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import p052cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import p052cz.msebera.android.httpclient.client.params.ClientPNames;
import p052cz.msebera.android.httpclient.client.params.HttpClientParamConfig;
import p052cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import p052cz.msebera.android.httpclient.config.Lookup;
import p052cz.msebera.android.httpclient.conn.ClientConnectionManager;
import p052cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import p052cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import p052cz.msebera.android.httpclient.conn.ManagedClientConnection;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import p052cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import p052cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.impl.execchain.ClientExecChain;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.params.HttpParamsNames;
import p052cz.msebera.android.httpclient.protocol.BasicHttpContext;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.client.InternalHttpClient */
class InternalHttpClient extends CloseableHttpClient {
    private final Lookup<AuthSchemeProvider> authSchemeRegistry;
    private final List<Closeable> closeables;
    /* access modifiers changed from: private */
    public final HttpClientConnectionManager connManager;
    private final Lookup<CookieSpecProvider> cookieSpecRegistry;
    private final CookieStore cookieStore;
    private final CredentialsProvider credentialsProvider;
    private final RequestConfig defaultConfig;
    private final ClientExecChain execChain;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final HttpRoutePlanner routePlanner;

    public InternalHttpClient(ClientExecChain clientExecChain, HttpClientConnectionManager httpClientConnectionManager, HttpRoutePlanner httpRoutePlanner, Lookup<CookieSpecProvider> lookup, Lookup<AuthSchemeProvider> lookup2, CookieStore cookieStore2, CredentialsProvider credentialsProvider2, RequestConfig requestConfig, List<Closeable> list) {
        Args.notNull(clientExecChain, "HTTP client exec chain");
        Args.notNull(httpClientConnectionManager, "HTTP connection manager");
        Args.notNull(httpRoutePlanner, "HTTP route planner");
        this.execChain = clientExecChain;
        this.connManager = httpClientConnectionManager;
        this.routePlanner = httpRoutePlanner;
        this.cookieSpecRegistry = lookup;
        this.authSchemeRegistry = lookup2;
        this.cookieStore = cookieStore2;
        this.credentialsProvider = credentialsProvider2;
        this.defaultConfig = requestConfig;
        this.closeables = list;
    }

    private HttpRoute determineRoute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        if (httpHost == null) {
            httpHost = (HttpHost) httpRequest.getParams().getParameter(ClientPNames.DEFAULT_HOST);
        }
        return this.routePlanner.determineRoute(httpHost, httpRequest, httpContext);
    }

    private void setupContext(HttpClientContext httpClientContext) {
        if (httpClientContext.getAttribute("http.auth.target-scope") == null) {
            httpClientContext.setAttribute("http.auth.target-scope", new AuthState());
        }
        if (httpClientContext.getAttribute("http.auth.proxy-scope") == null) {
            httpClientContext.setAttribute("http.auth.proxy-scope", new AuthState());
        }
        if (httpClientContext.getAttribute("http.authscheme-registry") == null) {
            httpClientContext.setAttribute("http.authscheme-registry", this.authSchemeRegistry);
        }
        if (httpClientContext.getAttribute("http.cookiespec-registry") == null) {
            httpClientContext.setAttribute("http.cookiespec-registry", this.cookieSpecRegistry);
        }
        if (httpClientContext.getAttribute("http.cookie-store") == null) {
            httpClientContext.setAttribute("http.cookie-store", this.cookieStore);
        }
        if (httpClientContext.getAttribute("http.auth.credentials-provider") == null) {
            httpClientContext.setAttribute("http.auth.credentials-provider", this.credentialsProvider);
        }
        if (httpClientContext.getAttribute("http.request-config") == null) {
            httpClientContext.setAttribute("http.request-config", this.defaultConfig);
        }
    }

    /* access modifiers changed from: protected */
    public CloseableHttpResponse doExecute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        Args.notNull(httpRequest, "HTTP request");
        RequestConfig requestConfig = null;
        HttpExecutionAware httpExecutionAware = httpRequest instanceof HttpExecutionAware ? (HttpExecutionAware) httpRequest : null;
        try {
            HttpRequestWrapper wrap = HttpRequestWrapper.wrap(httpRequest);
            if (httpContext == null) {
                httpContext = new BasicHttpContext();
            }
            HttpClientContext adapt = HttpClientContext.adapt(httpContext);
            if (httpRequest instanceof Configurable) {
                requestConfig = ((Configurable) httpRequest).getConfig();
            }
            if (requestConfig == null) {
                HttpParams params = httpRequest.getParams();
                if (!(params instanceof HttpParamsNames)) {
                    requestConfig = HttpClientParamConfig.getRequestConfig(params);
                } else if (!((HttpParamsNames) params).getNames().isEmpty()) {
                    requestConfig = HttpClientParamConfig.getRequestConfig(params);
                }
            }
            if (requestConfig != null) {
                adapt.setRequestConfig(requestConfig);
            }
            setupContext(adapt);
            return this.execChain.execute(determineRoute(httpHost, wrap, adapt), wrap, adapt, httpExecutionAware);
        } catch (HttpException e) {
            throw new ClientProtocolException((Throwable) e);
        }
    }

    public void close() {
        this.connManager.shutdown();
        List<Closeable> list = this.closeables;
        if (list != null) {
            for (Closeable close : list) {
                try {
                    close.close();
                } catch (IOException e) {
                    this.log.error(e.getMessage(), e);
                }
            }
        }
    }

    public HttpParams getParams() {
        throw new UnsupportedOperationException();
    }

    public ClientConnectionManager getConnectionManager() {
        return new ClientConnectionManager() {
            public void shutdown() {
                InternalHttpClient.this.connManager.shutdown();
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
                InternalHttpClient.this.connManager.closeIdleConnections(j, timeUnit);
            }

            public void closeExpiredConnections() {
                InternalHttpClient.this.connManager.closeExpiredConnections();
            }
        };
    }
}
