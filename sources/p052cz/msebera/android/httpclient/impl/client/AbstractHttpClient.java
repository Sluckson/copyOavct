package p052cz.msebera.android.httpclient.impl.client;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import p052cz.msebera.android.httpclient.ConnectionReuseStrategy;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpRequestInterceptor;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpResponseInterceptor;
import p052cz.msebera.android.httpclient.annotation.GuardedBy;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.auth.AuthSchemeRegistry;
import p052cz.msebera.android.httpclient.client.AuthenticationHandler;
import p052cz.msebera.android.httpclient.client.AuthenticationStrategy;
import p052cz.msebera.android.httpclient.client.BackoffManager;
import p052cz.msebera.android.httpclient.client.ClientProtocolException;
import p052cz.msebera.android.httpclient.client.ConnectionBackoffStrategy;
import p052cz.msebera.android.httpclient.client.CookieStore;
import p052cz.msebera.android.httpclient.client.CredentialsProvider;
import p052cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import p052cz.msebera.android.httpclient.client.RedirectHandler;
import p052cz.msebera.android.httpclient.client.RedirectStrategy;
import p052cz.msebera.android.httpclient.client.RequestDirector;
import p052cz.msebera.android.httpclient.client.UserTokenHandler;
import p052cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import p052cz.msebera.android.httpclient.client.params.ClientPNames;
import p052cz.msebera.android.httpclient.client.params.CookiePolicy;
import p052cz.msebera.android.httpclient.client.params.HttpClientParamConfig;
import p052cz.msebera.android.httpclient.client.protocol.ClientContext;
import p052cz.msebera.android.httpclient.conn.ClientConnectionManager;
import p052cz.msebera.android.httpclient.conn.ClientConnectionManagerFactory;
import p052cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import p052cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import p052cz.msebera.android.httpclient.cookie.CookieSpecRegistry;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import p052cz.msebera.android.httpclient.impl.auth.BasicSchemeFactory;
import p052cz.msebera.android.httpclient.impl.auth.DigestSchemeFactory;
import p052cz.msebera.android.httpclient.impl.auth.NTLMSchemeFactory;
import p052cz.msebera.android.httpclient.impl.conn.BasicClientConnectionManager;
import p052cz.msebera.android.httpclient.impl.conn.DefaultHttpRoutePlanner;
import p052cz.msebera.android.httpclient.impl.conn.SchemeRegistryFactory;
import p052cz.msebera.android.httpclient.impl.cookie.BestMatchSpecFactory;
import p052cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory;
import p052cz.msebera.android.httpclient.impl.cookie.IgnoreSpecFactory;
import p052cz.msebera.android.httpclient.impl.cookie.NetscapeDraftSpecFactory;
import p052cz.msebera.android.httpclient.impl.cookie.RFC2109SpecFactory;
import p052cz.msebera.android.httpclient.impl.cookie.RFC2965SpecFactory;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.protocol.BasicHttpContext;
import p052cz.msebera.android.httpclient.protocol.BasicHttpProcessor;
import p052cz.msebera.android.httpclient.protocol.DefaultedHttpContext;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.protocol.HttpProcessor;
import p052cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import p052cz.msebera.android.httpclient.protocol.ImmutableHttpProcessor;
import p052cz.msebera.android.httpclient.util.Args;

@ThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.AbstractHttpClient */
public abstract class AbstractHttpClient extends CloseableHttpClient {
    @GuardedBy("this")
    private BackoffManager backoffManager;
    @GuardedBy("this")
    private ClientConnectionManager connManager;
    @GuardedBy("this")
    private ConnectionBackoffStrategy connectionBackoffStrategy;
    @GuardedBy("this")
    private CookieStore cookieStore;
    @GuardedBy("this")
    private CredentialsProvider credsProvider;
    @GuardedBy("this")
    private HttpParams defaultParams;
    @GuardedBy("this")
    private ConnectionKeepAliveStrategy keepAliveStrategy;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    @GuardedBy("this")
    private BasicHttpProcessor mutableProcessor;
    @GuardedBy("this")
    private ImmutableHttpProcessor protocolProcessor;
    @GuardedBy("this")
    private AuthenticationStrategy proxyAuthStrategy;
    @GuardedBy("this")
    private RedirectStrategy redirectStrategy;
    @GuardedBy("this")
    private HttpRequestExecutor requestExec;
    @GuardedBy("this")
    private HttpRequestRetryHandler retryHandler;
    @GuardedBy("this")
    private ConnectionReuseStrategy reuseStrategy;
    @GuardedBy("this")
    private HttpRoutePlanner routePlanner;
    @GuardedBy("this")
    private AuthSchemeRegistry supportedAuthSchemes;
    @GuardedBy("this")
    private CookieSpecRegistry supportedCookieSpecs;
    @GuardedBy("this")
    private AuthenticationStrategy targetAuthStrategy;
    @GuardedBy("this")
    private UserTokenHandler userTokenHandler;

    /* access modifiers changed from: protected */
    public abstract HttpParams createHttpParams();

    /* access modifiers changed from: protected */
    public abstract BasicHttpProcessor createHttpProcessor();

    protected AbstractHttpClient(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        this.defaultParams = httpParams;
        this.connManager = clientConnectionManager;
    }

    /* access modifiers changed from: protected */
    public HttpContext createHttpContext() {
        BasicHttpContext basicHttpContext = new BasicHttpContext();
        basicHttpContext.setAttribute(ClientContext.SCHEME_REGISTRY, getConnectionManager().getSchemeRegistry());
        basicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
        basicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
        basicHttpContext.setAttribute("http.cookie-store", getCookieStore());
        basicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
        return basicHttpContext;
    }

    /* access modifiers changed from: protected */
    public ClientConnectionManager createClientConnectionManager() {
        ClientConnectionManagerFactory clientConnectionManagerFactory;
        SchemeRegistry createDefault = SchemeRegistryFactory.createDefault();
        HttpParams params = getParams();
        String str = (String) params.getParameter(ClientPNames.CONNECTION_MANAGER_FACTORY_CLASS_NAME);
        if (str != null) {
            try {
                clientConnectionManagerFactory = (ClientConnectionManagerFactory) Class.forName(str).newInstance();
            } catch (ClassNotFoundException unused) {
                throw new IllegalStateException("Invalid class name: " + str);
            } catch (IllegalAccessException e) {
                throw new IllegalAccessError(e.getMessage());
            } catch (InstantiationException e2) {
                throw new InstantiationError(e2.getMessage());
            }
        } else {
            clientConnectionManagerFactory = null;
        }
        if (clientConnectionManagerFactory != null) {
            return clientConnectionManagerFactory.newInstance(params, createDefault);
        }
        return new BasicClientConnectionManager(createDefault);
    }

    /* access modifiers changed from: protected */
    public AuthSchemeRegistry createAuthSchemeRegistry() {
        AuthSchemeRegistry authSchemeRegistry = new AuthSchemeRegistry();
        authSchemeRegistry.register("Basic", new BasicSchemeFactory());
        authSchemeRegistry.register("Digest", new DigestSchemeFactory());
        authSchemeRegistry.register("NTLM", new NTLMSchemeFactory());
        return authSchemeRegistry;
    }

    /* access modifiers changed from: protected */
    public CookieSpecRegistry createCookieSpecRegistry() {
        CookieSpecRegistry cookieSpecRegistry = new CookieSpecRegistry();
        cookieSpecRegistry.register("best-match", new BestMatchSpecFactory());
        cookieSpecRegistry.register("compatibility", new BrowserCompatSpecFactory());
        cookieSpecRegistry.register("netscape", new NetscapeDraftSpecFactory());
        cookieSpecRegistry.register(CookiePolicy.RFC_2109, new RFC2109SpecFactory());
        cookieSpecRegistry.register(CookiePolicy.RFC_2965, new RFC2965SpecFactory());
        cookieSpecRegistry.register("ignoreCookies", new IgnoreSpecFactory());
        return cookieSpecRegistry;
    }

    /* access modifiers changed from: protected */
    public HttpRequestExecutor createRequestExecutor() {
        return new HttpRequestExecutor();
    }

    /* access modifiers changed from: protected */
    public ConnectionReuseStrategy createConnectionReuseStrategy() {
        return new DefaultConnectionReuseStrategy();
    }

    /* access modifiers changed from: protected */
    public ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
        return new DefaultConnectionKeepAliveStrategy();
    }

    /* access modifiers changed from: protected */
    public HttpRequestRetryHandler createHttpRequestRetryHandler() {
        return new DefaultHttpRequestRetryHandler();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public RedirectHandler createRedirectHandler() {
        return new DefaultRedirectHandler();
    }

    /* access modifiers changed from: protected */
    public AuthenticationStrategy createTargetAuthenticationStrategy() {
        return new TargetAuthenticationStrategy();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public AuthenticationHandler createTargetAuthenticationHandler() {
        return new DefaultTargetAuthenticationHandler();
    }

    /* access modifiers changed from: protected */
    public AuthenticationStrategy createProxyAuthenticationStrategy() {
        return new ProxyAuthenticationStrategy();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public AuthenticationHandler createProxyAuthenticationHandler() {
        return new DefaultProxyAuthenticationHandler();
    }

    /* access modifiers changed from: protected */
    public CookieStore createCookieStore() {
        return new BasicCookieStore();
    }

    /* access modifiers changed from: protected */
    public CredentialsProvider createCredentialsProvider() {
        return new BasicCredentialsProvider();
    }

    /* access modifiers changed from: protected */
    public HttpRoutePlanner createHttpRoutePlanner() {
        return new DefaultHttpRoutePlanner(getConnectionManager().getSchemeRegistry());
    }

    /* access modifiers changed from: protected */
    public UserTokenHandler createUserTokenHandler() {
        return new DefaultUserTokenHandler();
    }

    public final synchronized HttpParams getParams() {
        if (this.defaultParams == null) {
            this.defaultParams = createHttpParams();
        }
        return this.defaultParams;
    }

    public synchronized void setParams(HttpParams httpParams) {
        this.defaultParams = httpParams;
    }

    public final synchronized ClientConnectionManager getConnectionManager() {
        if (this.connManager == null) {
            this.connManager = createClientConnectionManager();
        }
        return this.connManager;
    }

    public final synchronized HttpRequestExecutor getRequestExecutor() {
        if (this.requestExec == null) {
            this.requestExec = createRequestExecutor();
        }
        return this.requestExec;
    }

    public final synchronized AuthSchemeRegistry getAuthSchemes() {
        if (this.supportedAuthSchemes == null) {
            this.supportedAuthSchemes = createAuthSchemeRegistry();
        }
        return this.supportedAuthSchemes;
    }

    public synchronized void setAuthSchemes(AuthSchemeRegistry authSchemeRegistry) {
        this.supportedAuthSchemes = authSchemeRegistry;
    }

    public final synchronized ConnectionBackoffStrategy getConnectionBackoffStrategy() {
        return this.connectionBackoffStrategy;
    }

    public synchronized void setConnectionBackoffStrategy(ConnectionBackoffStrategy connectionBackoffStrategy2) {
        this.connectionBackoffStrategy = connectionBackoffStrategy2;
    }

    public final synchronized CookieSpecRegistry getCookieSpecs() {
        if (this.supportedCookieSpecs == null) {
            this.supportedCookieSpecs = createCookieSpecRegistry();
        }
        return this.supportedCookieSpecs;
    }

    public final synchronized BackoffManager getBackoffManager() {
        return this.backoffManager;
    }

    public synchronized void setBackoffManager(BackoffManager backoffManager2) {
        this.backoffManager = backoffManager2;
    }

    public synchronized void setCookieSpecs(CookieSpecRegistry cookieSpecRegistry) {
        this.supportedCookieSpecs = cookieSpecRegistry;
    }

    public final synchronized ConnectionReuseStrategy getConnectionReuseStrategy() {
        if (this.reuseStrategy == null) {
            this.reuseStrategy = createConnectionReuseStrategy();
        }
        return this.reuseStrategy;
    }

    public synchronized void setReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        this.reuseStrategy = connectionReuseStrategy;
    }

    public final synchronized ConnectionKeepAliveStrategy getConnectionKeepAliveStrategy() {
        if (this.keepAliveStrategy == null) {
            this.keepAliveStrategy = createConnectionKeepAliveStrategy();
        }
        return this.keepAliveStrategy;
    }

    public synchronized void setKeepAliveStrategy(ConnectionKeepAliveStrategy connectionKeepAliveStrategy) {
        this.keepAliveStrategy = connectionKeepAliveStrategy;
    }

    public final synchronized HttpRequestRetryHandler getHttpRequestRetryHandler() {
        if (this.retryHandler == null) {
            this.retryHandler = createHttpRequestRetryHandler();
        }
        return this.retryHandler;
    }

    public synchronized void setHttpRequestRetryHandler(HttpRequestRetryHandler httpRequestRetryHandler) {
        this.retryHandler = httpRequestRetryHandler;
    }

    @Deprecated
    public final synchronized RedirectHandler getRedirectHandler() {
        return createRedirectHandler();
    }

    @Deprecated
    public synchronized void setRedirectHandler(RedirectHandler redirectHandler) {
        this.redirectStrategy = new DefaultRedirectStrategyAdaptor(redirectHandler);
    }

    public final synchronized RedirectStrategy getRedirectStrategy() {
        if (this.redirectStrategy == null) {
            this.redirectStrategy = new DefaultRedirectStrategy();
        }
        return this.redirectStrategy;
    }

    public synchronized void setRedirectStrategy(RedirectStrategy redirectStrategy2) {
        this.redirectStrategy = redirectStrategy2;
    }

    @Deprecated
    public final synchronized AuthenticationHandler getTargetAuthenticationHandler() {
        return createTargetAuthenticationHandler();
    }

    @Deprecated
    public synchronized void setTargetAuthenticationHandler(AuthenticationHandler authenticationHandler) {
        this.targetAuthStrategy = new AuthenticationStrategyAdaptor(authenticationHandler);
    }

    public final synchronized AuthenticationStrategy getTargetAuthenticationStrategy() {
        if (this.targetAuthStrategy == null) {
            this.targetAuthStrategy = createTargetAuthenticationStrategy();
        }
        return this.targetAuthStrategy;
    }

    public synchronized void setTargetAuthenticationStrategy(AuthenticationStrategy authenticationStrategy) {
        this.targetAuthStrategy = authenticationStrategy;
    }

    @Deprecated
    public final synchronized AuthenticationHandler getProxyAuthenticationHandler() {
        return createProxyAuthenticationHandler();
    }

    @Deprecated
    public synchronized void setProxyAuthenticationHandler(AuthenticationHandler authenticationHandler) {
        this.proxyAuthStrategy = new AuthenticationStrategyAdaptor(authenticationHandler);
    }

    public final synchronized AuthenticationStrategy getProxyAuthenticationStrategy() {
        if (this.proxyAuthStrategy == null) {
            this.proxyAuthStrategy = createProxyAuthenticationStrategy();
        }
        return this.proxyAuthStrategy;
    }

    public synchronized void setProxyAuthenticationStrategy(AuthenticationStrategy authenticationStrategy) {
        this.proxyAuthStrategy = authenticationStrategy;
    }

    public final synchronized CookieStore getCookieStore() {
        if (this.cookieStore == null) {
            this.cookieStore = createCookieStore();
        }
        return this.cookieStore;
    }

    public synchronized void setCookieStore(CookieStore cookieStore2) {
        this.cookieStore = cookieStore2;
    }

    public final synchronized CredentialsProvider getCredentialsProvider() {
        if (this.credsProvider == null) {
            this.credsProvider = createCredentialsProvider();
        }
        return this.credsProvider;
    }

    public synchronized void setCredentialsProvider(CredentialsProvider credentialsProvider) {
        this.credsProvider = credentialsProvider;
    }

    public final synchronized HttpRoutePlanner getRoutePlanner() {
        if (this.routePlanner == null) {
            this.routePlanner = createHttpRoutePlanner();
        }
        return this.routePlanner;
    }

    public synchronized void setRoutePlanner(HttpRoutePlanner httpRoutePlanner) {
        this.routePlanner = httpRoutePlanner;
    }

    public final synchronized UserTokenHandler getUserTokenHandler() {
        if (this.userTokenHandler == null) {
            this.userTokenHandler = createUserTokenHandler();
        }
        return this.userTokenHandler;
    }

    public synchronized void setUserTokenHandler(UserTokenHandler userTokenHandler2) {
        this.userTokenHandler = userTokenHandler2;
    }

    /* access modifiers changed from: protected */
    public final synchronized BasicHttpProcessor getHttpProcessor() {
        if (this.mutableProcessor == null) {
            this.mutableProcessor = createHttpProcessor();
        }
        return this.mutableProcessor;
    }

    private synchronized HttpProcessor getProtocolProcessor() {
        if (this.protocolProcessor == null) {
            BasicHttpProcessor httpProcessor = getHttpProcessor();
            int requestInterceptorCount = httpProcessor.getRequestInterceptorCount();
            HttpRequestInterceptor[] httpRequestInterceptorArr = new HttpRequestInterceptor[requestInterceptorCount];
            for (int i = 0; i < requestInterceptorCount; i++) {
                httpRequestInterceptorArr[i] = httpProcessor.getRequestInterceptor(i);
            }
            int responseInterceptorCount = httpProcessor.getResponseInterceptorCount();
            HttpResponseInterceptor[] httpResponseInterceptorArr = new HttpResponseInterceptor[responseInterceptorCount];
            for (int i2 = 0; i2 < responseInterceptorCount; i2++) {
                httpResponseInterceptorArr[i2] = httpProcessor.getResponseInterceptor(i2);
            }
            this.protocolProcessor = new ImmutableHttpProcessor(httpRequestInterceptorArr, httpResponseInterceptorArr);
        }
        return this.protocolProcessor;
    }

    public synchronized int getResponseInterceptorCount() {
        return getHttpProcessor().getResponseInterceptorCount();
    }

    public synchronized HttpResponseInterceptor getResponseInterceptor(int i) {
        return getHttpProcessor().getResponseInterceptor(i);
    }

    public synchronized HttpRequestInterceptor getRequestInterceptor(int i) {
        return getHttpProcessor().getRequestInterceptor(i);
    }

    public synchronized int getRequestInterceptorCount() {
        return getHttpProcessor().getRequestInterceptorCount();
    }

    public synchronized void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        getHttpProcessor().addInterceptor(httpResponseInterceptor);
        this.protocolProcessor = null;
    }

    public synchronized void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor, int i) {
        getHttpProcessor().addInterceptor(httpResponseInterceptor, i);
        this.protocolProcessor = null;
    }

    public synchronized void clearResponseInterceptors() {
        getHttpProcessor().clearResponseInterceptors();
        this.protocolProcessor = null;
    }

    public synchronized void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> cls) {
        getHttpProcessor().removeResponseInterceptorByClass(cls);
        this.protocolProcessor = null;
    }

    public synchronized void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor) {
        getHttpProcessor().addInterceptor(httpRequestInterceptor);
        this.protocolProcessor = null;
    }

    public synchronized void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor, int i) {
        getHttpProcessor().addInterceptor(httpRequestInterceptor, i);
        this.protocolProcessor = null;
    }

    public synchronized void clearRequestInterceptors() {
        getHttpProcessor().clearRequestInterceptors();
        this.protocolProcessor = null;
    }

    public synchronized void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> cls) {
        getHttpProcessor().removeRequestInterceptorByClass(cls);
        this.protocolProcessor = null;
    }

    /* access modifiers changed from: protected */
    public final CloseableHttpResponse doExecute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        DefaultedHttpContext defaultedHttpContext;
        HttpContext httpContext2;
        RequestDirector createClientRequestDirector;
        HttpRoutePlanner routePlanner2;
        ConnectionBackoffStrategy connectionBackoffStrategy2;
        BackoffManager backoffManager2;
        HttpHost httpHost2;
        HttpRoute determineRoute;
        HttpHost httpHost3 = httpHost;
        HttpRequest httpRequest2 = httpRequest;
        HttpContext httpContext3 = httpContext;
        Args.notNull(httpRequest2, "HTTP request");
        synchronized (this) {
            HttpContext createHttpContext = createHttpContext();
            if (httpContext3 == null) {
                defaultedHttpContext = createHttpContext;
            } else {
                defaultedHttpContext = new DefaultedHttpContext(httpContext3, createHttpContext);
            }
            HttpParams determineParams = determineParams(httpRequest2);
            defaultedHttpContext.setAttribute("http.request-config", HttpClientParamConfig.getRequestConfig(determineParams));
            httpContext2 = defaultedHttpContext;
            createClientRequestDirector = createClientRequestDirector(getRequestExecutor(), getConnectionManager(), getConnectionReuseStrategy(), getConnectionKeepAliveStrategy(), getRoutePlanner(), getProtocolProcessor(), getHttpRequestRetryHandler(), getRedirectStrategy(), getTargetAuthenticationStrategy(), getProxyAuthenticationStrategy(), getUserTokenHandler(), determineParams);
            routePlanner2 = getRoutePlanner();
            connectionBackoffStrategy2 = getConnectionBackoffStrategy();
            backoffManager2 = getBackoffManager();
        }
        if (connectionBackoffStrategy2 == null || backoffManager2 == null) {
            return CloseableHttpResponseProxy.newProxy(createClientRequestDirector.execute(httpHost3, httpRequest2, httpContext2));
        }
        if (httpHost3 != null) {
            httpHost2 = httpHost3;
        } else {
            try {
                httpHost2 = (HttpHost) determineParams(httpRequest2).getParameter(ClientPNames.DEFAULT_HOST);
            } catch (RuntimeException e) {
                if (connectionBackoffStrategy2.shouldBackoff((Throwable) e)) {
                    backoffManager2.backOff(determineRoute);
                }
                throw e;
            } catch (Exception e2) {
                if (connectionBackoffStrategy2.shouldBackoff((Throwable) e2)) {
                    backoffManager2.backOff(determineRoute);
                }
                if (e2 instanceof HttpException) {
                    throw ((HttpException) e2);
                } else if (e2 instanceof IOException) {
                    throw ((IOException) e2);
                } else {
                    throw new UndeclaredThrowableException(e2);
                }
            } catch (HttpException e3) {
                throw new ClientProtocolException((Throwable) e3);
            }
        }
        HttpContext httpContext4 = httpContext2;
        determineRoute = routePlanner2.determineRoute(httpHost2, httpRequest2, httpContext4);
        CloseableHttpResponse newProxy = CloseableHttpResponseProxy.newProxy(createClientRequestDirector.execute(httpHost3, httpRequest2, httpContext4));
        if (connectionBackoffStrategy2.shouldBackoff((HttpResponse) newProxy)) {
            backoffManager2.backOff(determineRoute);
        } else {
            backoffManager2.probe(determineRoute);
        }
        return newProxy;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public RequestDirector createClientRequestDirector(HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectHandler redirectHandler, AuthenticationHandler authenticationHandler, AuthenticationHandler authenticationHandler2, UserTokenHandler userTokenHandler2, HttpParams httpParams) {
        return new DefaultRequestDirector(httpRequestExecutor, clientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, httpRoutePlanner, httpProcessor, httpRequestRetryHandler, redirectHandler, authenticationHandler, authenticationHandler2, userTokenHandler2, httpParams);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public RequestDirector createClientRequestDirector(HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectStrategy redirectStrategy2, AuthenticationHandler authenticationHandler, AuthenticationHandler authenticationHandler2, UserTokenHandler userTokenHandler2, HttpParams httpParams) {
        return new DefaultRequestDirector(this.log, httpRequestExecutor, clientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, httpRoutePlanner, httpProcessor, httpRequestRetryHandler, redirectStrategy2, authenticationHandler, authenticationHandler2, userTokenHandler2, httpParams);
    }

    /* access modifiers changed from: protected */
    public RequestDirector createClientRequestDirector(HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectStrategy redirectStrategy2, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler2, HttpParams httpParams) {
        return new DefaultRequestDirector(this.log, httpRequestExecutor, clientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, httpRoutePlanner, httpProcessor, httpRequestRetryHandler, redirectStrategy2, authenticationStrategy, authenticationStrategy2, userTokenHandler2, httpParams);
    }

    /* access modifiers changed from: protected */
    public HttpParams determineParams(HttpRequest httpRequest) {
        return new ClientParamsStack((HttpParams) null, getParams(), httpRequest.getParams(), (HttpParams) null);
    }

    public void close() {
        getConnectionManager().shutdown();
    }
}
