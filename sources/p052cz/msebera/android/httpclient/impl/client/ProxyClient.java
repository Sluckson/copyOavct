package p052cz.msebera.android.httpclient.impl.client;

import com.google.firebase.perf.FirebasePerformance;
import java.io.IOException;
import java.net.Socket;
import p052cz.msebera.android.httpclient.ConnectionReuseStrategy;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpVersion;
import p052cz.msebera.android.httpclient.auth.AuthSchemeRegistry;
import p052cz.msebera.android.httpclient.auth.AuthScope;
import p052cz.msebera.android.httpclient.auth.AuthState;
import p052cz.msebera.android.httpclient.auth.Credentials;
import p052cz.msebera.android.httpclient.client.config.RequestConfig;
import p052cz.msebera.android.httpclient.client.params.HttpClientParamConfig;
import p052cz.msebera.android.httpclient.client.protocol.RequestClientConnControl;
import p052cz.msebera.android.httpclient.config.ConnectionConfig;
import p052cz.msebera.android.httpclient.conn.HttpConnectionFactory;
import p052cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.conn.routing.RouteInfo;
import p052cz.msebera.android.httpclient.entity.BufferedHttpEntity;
import p052cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import p052cz.msebera.android.httpclient.impl.auth.BasicSchemeFactory;
import p052cz.msebera.android.httpclient.impl.auth.DigestSchemeFactory;
import p052cz.msebera.android.httpclient.impl.auth.HttpAuthenticator;
import p052cz.msebera.android.httpclient.impl.auth.NTLMSchemeFactory;
import p052cz.msebera.android.httpclient.impl.conn.ManagedHttpClientConnectionFactory;
import p052cz.msebera.android.httpclient.impl.execchain.TunnelRefusedException;
import p052cz.msebera.android.httpclient.message.BasicHttpRequest;
import p052cz.msebera.android.httpclient.params.BasicHttpParams;
import p052cz.msebera.android.httpclient.params.HttpParamConfig;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.protocol.BasicHttpContext;
import p052cz.msebera.android.httpclient.protocol.HttpProcessor;
import p052cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import p052cz.msebera.android.httpclient.protocol.ImmutableHttpProcessor;
import p052cz.msebera.android.httpclient.protocol.RequestTargetHost;
import p052cz.msebera.android.httpclient.protocol.RequestUserAgent;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.EntityUtils;

/* renamed from: cz.msebera.android.httpclient.impl.client.ProxyClient */
public class ProxyClient {
    private final AuthSchemeRegistry authSchemeRegistry;
    private final HttpAuthenticator authenticator;
    private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;
    private final ConnectionConfig connectionConfig;
    private final HttpProcessor httpProcessor;
    private final AuthState proxyAuthState;
    private final ProxyAuthenticationStrategy proxyAuthStrategy;
    private final RequestConfig requestConfig;
    private final HttpRequestExecutor requestExec;
    private final ConnectionReuseStrategy reuseStrategy;

    public ProxyClient(HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory, ConnectionConfig connectionConfig2, RequestConfig requestConfig2) {
        this.connFactory = httpConnectionFactory == null ? ManagedHttpClientConnectionFactory.INSTANCE : httpConnectionFactory;
        this.connectionConfig = connectionConfig2 == null ? ConnectionConfig.DEFAULT : connectionConfig2;
        this.requestConfig = requestConfig2 == null ? RequestConfig.DEFAULT : requestConfig2;
        this.httpProcessor = new ImmutableHttpProcessor(new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent());
        this.requestExec = new HttpRequestExecutor();
        this.proxyAuthStrategy = new ProxyAuthenticationStrategy();
        this.authenticator = new HttpAuthenticator();
        this.proxyAuthState = new AuthState();
        this.authSchemeRegistry = new AuthSchemeRegistry();
        this.authSchemeRegistry.register("Basic", new BasicSchemeFactory());
        this.authSchemeRegistry.register("Digest", new DigestSchemeFactory());
        this.authSchemeRegistry.register("NTLM", new NTLMSchemeFactory());
        this.reuseStrategy = new DefaultConnectionReuseStrategy();
    }

    @Deprecated
    public ProxyClient(HttpParams httpParams) {
        this((HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection>) null, HttpParamConfig.getConnectionConfig(httpParams), HttpClientParamConfig.getRequestConfig(httpParams));
    }

    public ProxyClient(RequestConfig requestConfig2) {
        this((HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection>) null, (ConnectionConfig) null, requestConfig2);
    }

    public ProxyClient() {
        this((HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection>) null, (ConnectionConfig) null, (RequestConfig) null);
    }

    @Deprecated
    public HttpParams getParams() {
        return new BasicHttpParams();
    }

    @Deprecated
    public AuthSchemeRegistry getAuthSchemeRegistry() {
        return this.authSchemeRegistry;
    }

    public Socket tunnel(HttpHost httpHost, HttpHost httpHost2, Credentials credentials) throws IOException, HttpException {
        HttpResponse execute;
        Args.notNull(httpHost, "Proxy host");
        Args.notNull(httpHost2, "Target host");
        Args.notNull(credentials, "Credentials");
        HttpHost httpHost3 = httpHost2.getPort() <= 0 ? new HttpHost(httpHost2.getHostName(), 80, httpHost2.getSchemeName()) : httpHost2;
        HttpRoute httpRoute = new HttpRoute(httpHost3, this.requestConfig.getLocalAddress(), httpHost, false, RouteInfo.TunnelType.TUNNELLED, RouteInfo.LayerType.PLAIN);
        ManagedHttpClientConnection create = this.connFactory.create(httpRoute, this.connectionConfig);
        BasicHttpContext basicHttpContext = new BasicHttpContext();
        BasicHttpRequest basicHttpRequest = new BasicHttpRequest(FirebasePerformance.HttpMethod.CONNECT, httpHost3.toHostString(), HttpVersion.HTTP_1_1);
        BasicCredentialsProvider basicCredentialsProvider = new BasicCredentialsProvider();
        basicCredentialsProvider.setCredentials(new AuthScope(httpHost), credentials);
        basicHttpContext.setAttribute("http.target_host", httpHost2);
        basicHttpContext.setAttribute("http.connection", create);
        basicHttpContext.setAttribute("http.request", basicHttpRequest);
        basicHttpContext.setAttribute("http.route", httpRoute);
        basicHttpContext.setAttribute("http.auth.proxy-scope", this.proxyAuthState);
        basicHttpContext.setAttribute("http.auth.credentials-provider", basicCredentialsProvider);
        basicHttpContext.setAttribute("http.authscheme-registry", this.authSchemeRegistry);
        basicHttpContext.setAttribute("http.request-config", this.requestConfig);
        this.requestExec.preProcess(basicHttpRequest, this.httpProcessor, basicHttpContext);
        while (true) {
            if (!create.isOpen()) {
                create.bind(new Socket(httpHost.getHostName(), httpHost.getPort()));
            }
            this.authenticator.generateAuthResponse(basicHttpRequest, this.proxyAuthState, basicHttpContext);
            execute = this.requestExec.execute(basicHttpRequest, create, basicHttpContext);
            if (execute.getStatusLine().getStatusCode() >= 200) {
                if (!this.authenticator.isAuthenticationRequested(httpHost, execute, this.proxyAuthStrategy, this.proxyAuthState, basicHttpContext)) {
                    break;
                }
                if (!this.authenticator.handleAuthChallenge(httpHost, execute, this.proxyAuthStrategy, this.proxyAuthState, basicHttpContext)) {
                    break;
                }
                if (this.reuseStrategy.keepAlive(execute, basicHttpContext)) {
                    EntityUtils.consume(execute.getEntity());
                } else {
                    create.close();
                }
                basicHttpRequest.removeHeaders("Proxy-Authorization");
            } else {
                throw new HttpException("Unexpected response to CONNECT request: " + execute.getStatusLine());
            }
        }
        if (execute.getStatusLine().getStatusCode() <= 299) {
            return create.getSocket();
        }
        HttpEntity entity = execute.getEntity();
        if (entity != null) {
            execute.setEntity(new BufferedHttpEntity(entity));
        }
        create.close();
        throw new TunnelRefusedException("CONNECT refused by proxy: " + execute.getStatusLine(), execute);
    }
}
