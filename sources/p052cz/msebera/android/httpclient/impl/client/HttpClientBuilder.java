package p052cz.msebera.android.httpclient.impl.client;

import java.io.Closeable;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import p052cz.msebera.android.httpclient.ConnectionReuseStrategy;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequestInterceptor;
import p052cz.msebera.android.httpclient.HttpResponseInterceptor;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import p052cz.msebera.android.httpclient.client.AuthenticationStrategy;
import p052cz.msebera.android.httpclient.client.BackoffManager;
import p052cz.msebera.android.httpclient.client.ConnectionBackoffStrategy;
import p052cz.msebera.android.httpclient.client.CookieStore;
import p052cz.msebera.android.httpclient.client.CredentialsProvider;
import p052cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import p052cz.msebera.android.httpclient.client.RedirectStrategy;
import p052cz.msebera.android.httpclient.client.ServiceUnavailableRetryStrategy;
import p052cz.msebera.android.httpclient.client.UserTokenHandler;
import p052cz.msebera.android.httpclient.client.config.CookieSpecs;
import p052cz.msebera.android.httpclient.client.config.RequestConfig;
import p052cz.msebera.android.httpclient.client.params.CookiePolicy;
import p052cz.msebera.android.httpclient.client.protocol.RequestAcceptEncoding;
import p052cz.msebera.android.httpclient.client.protocol.RequestAddCookies;
import p052cz.msebera.android.httpclient.client.protocol.RequestAuthCache;
import p052cz.msebera.android.httpclient.client.protocol.RequestClientConnControl;
import p052cz.msebera.android.httpclient.client.protocol.RequestDefaultHeaders;
import p052cz.msebera.android.httpclient.client.protocol.RequestExpectContinue;
import p052cz.msebera.android.httpclient.client.protocol.ResponseContentEncoding;
import p052cz.msebera.android.httpclient.client.protocol.ResponseProcessCookies;
import p052cz.msebera.android.httpclient.config.ConnectionConfig;
import p052cz.msebera.android.httpclient.config.Lookup;
import p052cz.msebera.android.httpclient.config.Registry;
import p052cz.msebera.android.httpclient.config.RegistryBuilder;
import p052cz.msebera.android.httpclient.config.SocketConfig;
import p052cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import p052cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import p052cz.msebera.android.httpclient.conn.SchemePortResolver;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import p052cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory;
import p052cz.msebera.android.httpclient.conn.socket.LayeredConnectionSocketFactory;
import p052cz.msebera.android.httpclient.conn.socket.PlainConnectionSocketFactory;
import p052cz.msebera.android.httpclient.conn.ssl.SSLConnectionSocketFactory;
import p052cz.msebera.android.httpclient.conn.ssl.SSLContexts;
import p052cz.msebera.android.httpclient.conn.ssl.X509HostnameVerifier;
import p052cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import p052cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import p052cz.msebera.android.httpclient.impl.NoConnectionReuseStrategy;
import p052cz.msebera.android.httpclient.impl.auth.BasicSchemeFactory;
import p052cz.msebera.android.httpclient.impl.auth.DigestSchemeFactory;
import p052cz.msebera.android.httpclient.impl.auth.NTLMSchemeFactory;
import p052cz.msebera.android.httpclient.impl.conn.DefaultProxyRoutePlanner;
import p052cz.msebera.android.httpclient.impl.conn.DefaultRoutePlanner;
import p052cz.msebera.android.httpclient.impl.conn.DefaultSchemePortResolver;
import p052cz.msebera.android.httpclient.impl.conn.PoolingHttpClientConnectionManager;
import p052cz.msebera.android.httpclient.impl.conn.SystemDefaultRoutePlanner;
import p052cz.msebera.android.httpclient.impl.cookie.BestMatchSpecFactory;
import p052cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory;
import p052cz.msebera.android.httpclient.impl.cookie.IgnoreSpecFactory;
import p052cz.msebera.android.httpclient.impl.cookie.NetscapeDraftSpecFactory;
import p052cz.msebera.android.httpclient.impl.cookie.RFC2109SpecFactory;
import p052cz.msebera.android.httpclient.impl.cookie.RFC2965SpecFactory;
import p052cz.msebera.android.httpclient.impl.execchain.BackoffStrategyExec;
import p052cz.msebera.android.httpclient.impl.execchain.ClientExecChain;
import p052cz.msebera.android.httpclient.impl.execchain.MainClientExec;
import p052cz.msebera.android.httpclient.impl.execchain.ProtocolExec;
import p052cz.msebera.android.httpclient.impl.execchain.RedirectExec;
import p052cz.msebera.android.httpclient.impl.execchain.RetryExec;
import p052cz.msebera.android.httpclient.impl.execchain.ServiceUnavailableRetryExec;
import p052cz.msebera.android.httpclient.protocol.HttpProcessor;
import p052cz.msebera.android.httpclient.protocol.HttpProcessorBuilder;
import p052cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import p052cz.msebera.android.httpclient.protocol.RequestContent;
import p052cz.msebera.android.httpclient.protocol.RequestTargetHost;
import p052cz.msebera.android.httpclient.protocol.RequestUserAgent;
import p052cz.msebera.android.httpclient.util.TextUtils;
import p052cz.msebera.android.httpclient.util.VersionInfo;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.client.HttpClientBuilder */
public class HttpClientBuilder {
    static final String DEFAULT_USER_AGENT;
    private boolean authCachingDisabled;
    private Lookup<AuthSchemeProvider> authSchemeRegistry;
    private boolean automaticRetriesDisabled;
    private BackoffManager backoffManager;
    private List<Closeable> closeables;
    private HttpClientConnectionManager connManager;
    private ConnectionBackoffStrategy connectionBackoffStrategy;
    private boolean connectionStateDisabled;
    private boolean contentCompressionDisabled;
    private boolean cookieManagementDisabled;
    private Lookup<CookieSpecProvider> cookieSpecRegistry;
    private CookieStore cookieStore;
    private CredentialsProvider credentialsProvider;
    private ConnectionConfig defaultConnectionConfig;
    private Collection<? extends Header> defaultHeaders;
    private RequestConfig defaultRequestConfig;
    private SocketConfig defaultSocketConfig;
    private X509HostnameVerifier hostnameVerifier;
    private HttpProcessor httpprocessor;
    private ConnectionKeepAliveStrategy keepAliveStrategy;
    private int maxConnPerRoute = 0;
    private int maxConnTotal = 0;
    private HttpHost proxy;
    private AuthenticationStrategy proxyAuthStrategy;
    private boolean redirectHandlingDisabled;
    private RedirectStrategy redirectStrategy;
    private HttpRequestExecutor requestExec;
    private LinkedList<HttpRequestInterceptor> requestFirst;
    private LinkedList<HttpRequestInterceptor> requestLast;
    private LinkedList<HttpResponseInterceptor> responseFirst;
    private LinkedList<HttpResponseInterceptor> responseLast;
    private HttpRequestRetryHandler retryHandler;
    private ConnectionReuseStrategy reuseStrategy;
    private HttpRoutePlanner routePlanner;
    private SchemePortResolver schemePortResolver;
    private ServiceUnavailableRetryStrategy serviceUnavailStrategy;
    private LayeredConnectionSocketFactory sslSocketFactory;
    private SSLContext sslcontext;
    private boolean systemProperties;
    private AuthenticationStrategy targetAuthStrategy;
    private String userAgent;
    private UserTokenHandler userTokenHandler;

    /* access modifiers changed from: protected */
    public ClientExecChain decorateMainExec(ClientExecChain clientExecChain) {
        return clientExecChain;
    }

    /* access modifiers changed from: protected */
    public ClientExecChain decorateProtocolExec(ClientExecChain clientExecChain) {
        return clientExecChain;
    }

    static {
        VersionInfo loadVersionInfo = VersionInfo.loadVersionInfo("cz.msebera.android.httpclient.client", HttpClientBuilder.class.getClassLoader());
        String release = loadVersionInfo != null ? loadVersionInfo.getRelease() : VersionInfo.UNAVAILABLE;
        DEFAULT_USER_AGENT = "Apache-HttpClient/" + release + " (java 1.5)";
    }

    public static HttpClientBuilder create() {
        return new HttpClientBuilder();
    }

    protected HttpClientBuilder() {
    }

    public final HttpClientBuilder setRequestExecutor(HttpRequestExecutor httpRequestExecutor) {
        this.requestExec = httpRequestExecutor;
        return this;
    }

    public final HttpClientBuilder setHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        this.hostnameVerifier = x509HostnameVerifier;
        return this;
    }

    public final HttpClientBuilder setSslcontext(SSLContext sSLContext) {
        this.sslcontext = sSLContext;
        return this;
    }

    public final HttpClientBuilder setSSLSocketFactory(LayeredConnectionSocketFactory layeredConnectionSocketFactory) {
        this.sslSocketFactory = layeredConnectionSocketFactory;
        return this;
    }

    public final HttpClientBuilder setMaxConnTotal(int i) {
        this.maxConnTotal = i;
        return this;
    }

    public final HttpClientBuilder setMaxConnPerRoute(int i) {
        this.maxConnPerRoute = i;
        return this;
    }

    public final HttpClientBuilder setDefaultSocketConfig(SocketConfig socketConfig) {
        this.defaultSocketConfig = socketConfig;
        return this;
    }

    public final HttpClientBuilder setDefaultConnectionConfig(ConnectionConfig connectionConfig) {
        this.defaultConnectionConfig = connectionConfig;
        return this;
    }

    public final HttpClientBuilder setConnectionManager(HttpClientConnectionManager httpClientConnectionManager) {
        this.connManager = httpClientConnectionManager;
        return this;
    }

    public final HttpClientBuilder setConnectionReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        this.reuseStrategy = connectionReuseStrategy;
        return this;
    }

    public final HttpClientBuilder setKeepAliveStrategy(ConnectionKeepAliveStrategy connectionKeepAliveStrategy) {
        this.keepAliveStrategy = connectionKeepAliveStrategy;
        return this;
    }

    public final HttpClientBuilder setTargetAuthenticationStrategy(AuthenticationStrategy authenticationStrategy) {
        this.targetAuthStrategy = authenticationStrategy;
        return this;
    }

    public final HttpClientBuilder setProxyAuthenticationStrategy(AuthenticationStrategy authenticationStrategy) {
        this.proxyAuthStrategy = authenticationStrategy;
        return this;
    }

    public final HttpClientBuilder setUserTokenHandler(UserTokenHandler userTokenHandler2) {
        this.userTokenHandler = userTokenHandler2;
        return this;
    }

    public final HttpClientBuilder disableConnectionState() {
        this.connectionStateDisabled = true;
        return this;
    }

    public final HttpClientBuilder setSchemePortResolver(SchemePortResolver schemePortResolver2) {
        this.schemePortResolver = schemePortResolver2;
        return this;
    }

    public final HttpClientBuilder setUserAgent(String str) {
        this.userAgent = str;
        return this;
    }

    public final HttpClientBuilder setDefaultHeaders(Collection<? extends Header> collection) {
        this.defaultHeaders = collection;
        return this;
    }

    public final HttpClientBuilder addInterceptorFirst(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor == null) {
            return this;
        }
        if (this.responseFirst == null) {
            this.responseFirst = new LinkedList<>();
        }
        this.responseFirst.addFirst(httpResponseInterceptor);
        return this;
    }

    public final HttpClientBuilder addInterceptorLast(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor == null) {
            return this;
        }
        if (this.responseLast == null) {
            this.responseLast = new LinkedList<>();
        }
        this.responseLast.addLast(httpResponseInterceptor);
        return this;
    }

    public final HttpClientBuilder addInterceptorFirst(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor == null) {
            return this;
        }
        if (this.requestFirst == null) {
            this.requestFirst = new LinkedList<>();
        }
        this.requestFirst.addFirst(httpRequestInterceptor);
        return this;
    }

    public final HttpClientBuilder addInterceptorLast(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor == null) {
            return this;
        }
        if (this.requestLast == null) {
            this.requestLast = new LinkedList<>();
        }
        this.requestLast.addLast(httpRequestInterceptor);
        return this;
    }

    public final HttpClientBuilder disableCookieManagement() {
        this.cookieManagementDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableContentCompression() {
        this.contentCompressionDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableAuthCaching() {
        this.authCachingDisabled = true;
        return this;
    }

    public final HttpClientBuilder setHttpProcessor(HttpProcessor httpProcessor) {
        this.httpprocessor = httpProcessor;
        return this;
    }

    public final HttpClientBuilder setRetryHandler(HttpRequestRetryHandler httpRequestRetryHandler) {
        this.retryHandler = httpRequestRetryHandler;
        return this;
    }

    public final HttpClientBuilder disableAutomaticRetries() {
        this.automaticRetriesDisabled = true;
        return this;
    }

    public final HttpClientBuilder setProxy(HttpHost httpHost) {
        this.proxy = httpHost;
        return this;
    }

    public final HttpClientBuilder setRoutePlanner(HttpRoutePlanner httpRoutePlanner) {
        this.routePlanner = httpRoutePlanner;
        return this;
    }

    public final HttpClientBuilder setRedirectStrategy(RedirectStrategy redirectStrategy2) {
        this.redirectStrategy = redirectStrategy2;
        return this;
    }

    public final HttpClientBuilder disableRedirectHandling() {
        this.redirectHandlingDisabled = true;
        return this;
    }

    public final HttpClientBuilder setConnectionBackoffStrategy(ConnectionBackoffStrategy connectionBackoffStrategy2) {
        this.connectionBackoffStrategy = connectionBackoffStrategy2;
        return this;
    }

    public final HttpClientBuilder setBackoffManager(BackoffManager backoffManager2) {
        this.backoffManager = backoffManager2;
        return this;
    }

    public final HttpClientBuilder setServiceUnavailableRetryStrategy(ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy) {
        this.serviceUnavailStrategy = serviceUnavailableRetryStrategy;
        return this;
    }

    public final HttpClientBuilder setDefaultCookieStore(CookieStore cookieStore2) {
        this.cookieStore = cookieStore2;
        return this;
    }

    public final HttpClientBuilder setDefaultCredentialsProvider(CredentialsProvider credentialsProvider2) {
        this.credentialsProvider = credentialsProvider2;
        return this;
    }

    public final HttpClientBuilder setDefaultAuthSchemeRegistry(Lookup<AuthSchemeProvider> lookup) {
        this.authSchemeRegistry = lookup;
        return this;
    }

    public final HttpClientBuilder setDefaultCookieSpecRegistry(Lookup<CookieSpecProvider> lookup) {
        this.cookieSpecRegistry = lookup;
        return this;
    }

    public final HttpClientBuilder setDefaultRequestConfig(RequestConfig requestConfig) {
        this.defaultRequestConfig = requestConfig;
        return this;
    }

    public final HttpClientBuilder useSystemProperties() {
        this.systemProperties = true;
        return this;
    }

    /* access modifiers changed from: protected */
    public void addCloseable(Closeable closeable) {
        if (closeable != null) {
            if (this.closeables == null) {
                this.closeables = new ArrayList();
            }
            this.closeables.add(closeable);
        }
    }

    private static String[] split(String str) {
        if (TextUtils.isBlank(str)) {
            return null;
        }
        return str.split(" *, *");
    }

    public CloseableHttpClient build() {
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager;
        DefaultProxyRoutePlanner defaultProxyRoutePlanner;
        HttpRoutePlanner httpRoutePlanner;
        HttpRequestExecutor httpRequestExecutor = this.requestExec;
        if (httpRequestExecutor == null) {
            httpRequestExecutor = new HttpRequestExecutor();
        }
        HttpRequestExecutor httpRequestExecutor2 = httpRequestExecutor;
        HttpClientConnectionManager httpClientConnectionManager = this.connManager;
        ArrayList arrayList = null;
        if (httpClientConnectionManager == null) {
            Object obj = this.sslSocketFactory;
            if (obj == null) {
                String[] split = this.systemProperties ? split(System.getProperty("https.protocols")) : null;
                String[] split2 = this.systemProperties ? split(System.getProperty("https.cipherSuites")) : null;
                X509HostnameVerifier x509HostnameVerifier = this.hostnameVerifier;
                if (x509HostnameVerifier == null) {
                    x509HostnameVerifier = SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
                }
                SSLContext sSLContext = this.sslcontext;
                if (sSLContext != null) {
                    obj = new SSLConnectionSocketFactory(sSLContext, split, split2, x509HostnameVerifier);
                } else if (this.systemProperties) {
                    obj = new SSLConnectionSocketFactory((SSLSocketFactory) SSLSocketFactory.getDefault(), split, split2, x509HostnameVerifier);
                } else {
                    obj = new SSLConnectionSocketFactory(SSLContexts.createDefault(), x509HostnameVerifier);
                }
            }
            PoolingHttpClientConnectionManager poolingHttpClientConnectionManager2 = new PoolingHttpClientConnectionManager((Registry<ConnectionSocketFactory>) RegistryBuilder.create().register(HttpHost.DEFAULT_SCHEME_NAME, PlainConnectionSocketFactory.getSocketFactory()).register("https", obj).build());
            SocketConfig socketConfig = this.defaultSocketConfig;
            if (socketConfig != null) {
                poolingHttpClientConnectionManager2.setDefaultSocketConfig(socketConfig);
            }
            ConnectionConfig connectionConfig = this.defaultConnectionConfig;
            if (connectionConfig != null) {
                poolingHttpClientConnectionManager2.setDefaultConnectionConfig(connectionConfig);
            }
            if (this.systemProperties && "true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true"))) {
                int parseInt = Integer.parseInt(System.getProperty("http.maxConnections", "5"));
                poolingHttpClientConnectionManager2.setDefaultMaxPerRoute(parseInt);
                poolingHttpClientConnectionManager2.setMaxTotal(parseInt * 2);
            }
            int i = this.maxConnTotal;
            if (i > 0) {
                poolingHttpClientConnectionManager2.setMaxTotal(i);
            }
            int i2 = this.maxConnPerRoute;
            if (i2 > 0) {
                poolingHttpClientConnectionManager2.setDefaultMaxPerRoute(i2);
            }
            poolingHttpClientConnectionManager = poolingHttpClientConnectionManager2;
        } else {
            poolingHttpClientConnectionManager = httpClientConnectionManager;
        }
        ConnectionReuseStrategy connectionReuseStrategy = this.reuseStrategy;
        if (connectionReuseStrategy == null) {
            if (!this.systemProperties) {
                connectionReuseStrategy = DefaultConnectionReuseStrategy.INSTANCE;
            } else if ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true"))) {
                connectionReuseStrategy = DefaultConnectionReuseStrategy.INSTANCE;
            } else {
                connectionReuseStrategy = NoConnectionReuseStrategy.INSTANCE;
            }
        }
        ConnectionReuseStrategy connectionReuseStrategy2 = connectionReuseStrategy;
        ConnectionKeepAliveStrategy connectionKeepAliveStrategy = this.keepAliveStrategy;
        if (connectionKeepAliveStrategy == null) {
            connectionKeepAliveStrategy = DefaultConnectionKeepAliveStrategy.INSTANCE;
        }
        ConnectionKeepAliveStrategy connectionKeepAliveStrategy2 = connectionKeepAliveStrategy;
        AuthenticationStrategy authenticationStrategy = this.targetAuthStrategy;
        if (authenticationStrategy == null) {
            authenticationStrategy = TargetAuthenticationStrategy.INSTANCE;
        }
        AuthenticationStrategy authenticationStrategy2 = authenticationStrategy;
        AuthenticationStrategy authenticationStrategy3 = this.proxyAuthStrategy;
        if (authenticationStrategy3 == null) {
            authenticationStrategy3 = ProxyAuthenticationStrategy.INSTANCE;
        }
        AuthenticationStrategy authenticationStrategy4 = authenticationStrategy3;
        UserTokenHandler userTokenHandler2 = this.userTokenHandler;
        if (userTokenHandler2 == null) {
            if (!this.connectionStateDisabled) {
                userTokenHandler2 = DefaultUserTokenHandler.INSTANCE;
            } else {
                userTokenHandler2 = NoopUserTokenHandler.INSTANCE;
            }
        }
        ClientExecChain decorateMainExec = decorateMainExec(new MainClientExec(httpRequestExecutor2, poolingHttpClientConnectionManager, connectionReuseStrategy2, connectionKeepAliveStrategy2, authenticationStrategy2, authenticationStrategy4, userTokenHandler2));
        HttpProcessor httpProcessor = this.httpprocessor;
        if (httpProcessor == null) {
            String str = this.userAgent;
            if (str == null) {
                if (this.systemProperties) {
                    str = System.getProperty("http.agent");
                }
                if (str == null) {
                    str = DEFAULT_USER_AGENT;
                }
            }
            HttpProcessorBuilder create = HttpProcessorBuilder.create();
            LinkedList<HttpRequestInterceptor> linkedList = this.requestFirst;
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    create.addFirst((HttpRequestInterceptor) it.next());
                }
            }
            LinkedList<HttpResponseInterceptor> linkedList2 = this.responseFirst;
            if (linkedList2 != null) {
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    create.addFirst((HttpResponseInterceptor) it2.next());
                }
            }
            create.addAll(new RequestDefaultHeaders(this.defaultHeaders), new RequestContent(), new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent(str), new RequestExpectContinue());
            if (!this.cookieManagementDisabled) {
                create.add((HttpRequestInterceptor) new RequestAddCookies());
            }
            if (!this.contentCompressionDisabled) {
                create.add((HttpRequestInterceptor) new RequestAcceptEncoding());
            }
            if (!this.authCachingDisabled) {
                create.add((HttpRequestInterceptor) new RequestAuthCache());
            }
            if (!this.cookieManagementDisabled) {
                create.add((HttpResponseInterceptor) new ResponseProcessCookies());
            }
            if (!this.contentCompressionDisabled) {
                create.add((HttpResponseInterceptor) new ResponseContentEncoding());
            }
            LinkedList<HttpRequestInterceptor> linkedList3 = this.requestLast;
            if (linkedList3 != null) {
                Iterator it3 = linkedList3.iterator();
                while (it3.hasNext()) {
                    create.addLast((HttpRequestInterceptor) it3.next());
                }
            }
            LinkedList<HttpResponseInterceptor> linkedList4 = this.responseLast;
            if (linkedList4 != null) {
                Iterator it4 = linkedList4.iterator();
                while (it4.hasNext()) {
                    create.addLast((HttpResponseInterceptor) it4.next());
                }
            }
            httpProcessor = create.build();
        }
        RedirectExec decorateProtocolExec = decorateProtocolExec(new ProtocolExec(decorateMainExec, httpProcessor));
        if (!this.automaticRetriesDisabled) {
            HttpRequestRetryHandler httpRequestRetryHandler = this.retryHandler;
            if (httpRequestRetryHandler == null) {
                httpRequestRetryHandler = DefaultHttpRequestRetryHandler.INSTANCE;
            }
            decorateProtocolExec = new RetryExec(decorateProtocolExec, httpRequestRetryHandler);
        }
        HttpRoutePlanner httpRoutePlanner2 = this.routePlanner;
        if (httpRoutePlanner2 == null) {
            SchemePortResolver schemePortResolver2 = this.schemePortResolver;
            if (schemePortResolver2 == null) {
                schemePortResolver2 = DefaultSchemePortResolver.INSTANCE;
            }
            HttpHost httpHost = this.proxy;
            if (httpHost != null) {
                defaultProxyRoutePlanner = new DefaultProxyRoutePlanner(httpHost, schemePortResolver2);
            } else {
                if (this.systemProperties) {
                    httpRoutePlanner = new SystemDefaultRoutePlanner(schemePortResolver2, ProxySelector.getDefault());
                } else {
                    httpRoutePlanner = new DefaultRoutePlanner(schemePortResolver2);
                }
                defaultProxyRoutePlanner = httpRoutePlanner;
            }
        } else {
            defaultProxyRoutePlanner = httpRoutePlanner2;
        }
        if (!this.redirectHandlingDisabled) {
            RedirectStrategy redirectStrategy2 = this.redirectStrategy;
            if (redirectStrategy2 == null) {
                redirectStrategy2 = DefaultRedirectStrategy.INSTANCE;
            }
            decorateProtocolExec = new RedirectExec(decorateProtocolExec, defaultProxyRoutePlanner, redirectStrategy2);
        }
        ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy = this.serviceUnavailStrategy;
        if (serviceUnavailableRetryStrategy != null) {
            decorateProtocolExec = new ServiceUnavailableRetryExec(decorateProtocolExec, serviceUnavailableRetryStrategy);
        }
        BackoffManager backoffManager2 = this.backoffManager;
        ConnectionBackoffStrategy connectionBackoffStrategy2 = this.connectionBackoffStrategy;
        BackoffStrategyExec backoffStrategyExec = (backoffManager2 == null || connectionBackoffStrategy2 == null) ? decorateProtocolExec : new BackoffStrategyExec(decorateProtocolExec, connectionBackoffStrategy2, backoffManager2);
        Lookup lookup = this.authSchemeRegistry;
        if (lookup == null) {
            lookup = RegistryBuilder.create().register("Basic", new BasicSchemeFactory()).register("Digest", new DigestSchemeFactory()).register("NTLM", new NTLMSchemeFactory()).build();
        }
        Lookup lookup2 = lookup;
        Lookup lookup3 = this.cookieSpecRegistry;
        if (lookup3 == null) {
            lookup3 = RegistryBuilder.create().register("best-match", new BestMatchSpecFactory()).register(CookieSpecs.STANDARD, new RFC2965SpecFactory()).register("compatibility", new BrowserCompatSpecFactory()).register("netscape", new NetscapeDraftSpecFactory()).register("ignoreCookies", new IgnoreSpecFactory()).register(CookiePolicy.RFC_2109, new RFC2109SpecFactory()).register(CookiePolicy.RFC_2965, new RFC2965SpecFactory()).build();
        }
        Lookup lookup4 = lookup3;
        CookieStore cookieStore2 = this.cookieStore;
        if (cookieStore2 == null) {
            cookieStore2 = new BasicCookieStore();
        }
        CookieStore cookieStore3 = cookieStore2;
        CredentialsProvider credentialsProvider2 = this.credentialsProvider;
        if (credentialsProvider2 == null) {
            if (this.systemProperties) {
                credentialsProvider2 = new SystemDefaultCredentialsProvider();
            } else {
                credentialsProvider2 = new BasicCredentialsProvider();
            }
        }
        CredentialsProvider credentialsProvider3 = credentialsProvider2;
        RequestConfig requestConfig = this.defaultRequestConfig;
        if (requestConfig == null) {
            requestConfig = RequestConfig.DEFAULT;
        }
        RequestConfig requestConfig2 = requestConfig;
        List<Closeable> list = this.closeables;
        if (list != null) {
            arrayList = new ArrayList(list);
        }
        return new InternalHttpClient(backoffStrategyExec, poolingHttpClientConnectionManager, defaultProxyRoutePlanner, lookup4, lookup2, cookieStore3, credentialsProvider3, requestConfig2, arrayList);
    }
}
