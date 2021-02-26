package p052cz.msebera.android.httpclient.impl.execchain;

import java.io.IOException;
import p052cz.msebera.android.httpclient.ConnectionReuseStrategy;
import p052cz.msebera.android.httpclient.HttpClientConnection;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.auth.AuthState;
import p052cz.msebera.android.httpclient.client.AuthenticationStrategy;
import p052cz.msebera.android.httpclient.client.UserTokenHandler;
import p052cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import p052cz.msebera.android.httpclient.client.protocol.RequestClientConnControl;
import p052cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import p052cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import p052cz.msebera.android.httpclient.conn.routing.BasicRouteDirector;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.conn.routing.HttpRouteDirector;
import p052cz.msebera.android.httpclient.conn.routing.RouteTracker;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.impl.auth.HttpAuthenticator;
import p052cz.msebera.android.httpclient.protocol.HttpProcessor;
import p052cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import p052cz.msebera.android.httpclient.protocol.ImmutableHttpProcessor;
import p052cz.msebera.android.httpclient.protocol.RequestTargetHost;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.execchain.MainClientExec */
public class MainClientExec implements ClientExecChain {
    private final HttpAuthenticator authenticator;
    private final HttpClientConnectionManager connManager;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final AuthenticationStrategy proxyAuthStrategy;
    private final HttpProcessor proxyHttpProcessor;
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;
    private final HttpRouteDirector routeDirector;
    private final AuthenticationStrategy targetAuthStrategy;
    private final UserTokenHandler userTokenHandler;

    public MainClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler2) {
        Args.notNull(httpRequestExecutor, "HTTP request executor");
        Args.notNull(httpClientConnectionManager, "Client connection manager");
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        Args.notNull(connectionKeepAliveStrategy, "Connection keep alive strategy");
        Args.notNull(authenticationStrategy, "Target authentication strategy");
        Args.notNull(authenticationStrategy2, "Proxy authentication strategy");
        Args.notNull(userTokenHandler2, "User token handler");
        this.authenticator = new HttpAuthenticator();
        this.proxyHttpProcessor = new ImmutableHttpProcessor(new RequestTargetHost(), new RequestClientConnControl());
        this.routeDirector = new BasicRouteDirector();
        this.requestExecutor = httpRequestExecutor;
        this.connManager = httpClientConnectionManager;
        this.reuseStrategy = connectionReuseStrategy;
        this.keepAliveStrategy = connectionKeepAliveStrategy;
        this.targetAuthStrategy = authenticationStrategy;
        this.proxyAuthStrategy = authenticationStrategy2;
        this.userTokenHandler = userTokenHandler2;
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [java.lang.Throwable] */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0352, code lost:
        r2 = new java.io.InterruptedIOException("Connection has been shut down");
        r2.initCause(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x035c, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c7, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x020b A[Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0339, IOException -> 0x0335, RuntimeException -> 0x0331 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0261 A[Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x027c A[Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x02f7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c6 A[Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x00c1, IOException -> 0x00bc, RuntimeException -> 0x00b7 }, ExcHandler: ConnectionShutdownException (r0v18 'e' cz.msebera.android.httpclient.impl.conn.ConnectionShutdownException A[CUSTOM_DECLARE, Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x00c1, IOException -> 0x00bc, RuntimeException -> 0x00b7 }]), Splitter:B:105:0x01c5] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p052cz.msebera.android.httpclient.client.methods.CloseableHttpResponse execute(p052cz.msebera.android.httpclient.conn.routing.HttpRoute r25, p052cz.msebera.android.httpclient.client.methods.HttpRequestWrapper r26, p052cz.msebera.android.httpclient.client.protocol.HttpClientContext r27, p052cz.msebera.android.httpclient.client.methods.HttpExecutionAware r28) throws java.io.IOException, p052cz.msebera.android.httpclient.HttpException {
        /*
            r24 = this;
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r28
            java.lang.String r12 = "Proxy-Authorization"
            java.lang.String r13 = "Authorization"
            java.lang.String r1 = "HTTP route"
            p052cz.msebera.android.httpclient.util.Args.notNull(r8, r1)
            java.lang.String r1 = "HTTP request"
            p052cz.msebera.android.httpclient.util.Args.notNull(r9, r1)
            java.lang.String r1 = "HTTP context"
            p052cz.msebera.android.httpclient.util.Args.notNull(r10, r1)
            cz.msebera.android.httpclient.auth.AuthState r1 = r27.getTargetAuthState()
            if (r1 != 0) goto L_0x002d
            cz.msebera.android.httpclient.auth.AuthState r1 = new cz.msebera.android.httpclient.auth.AuthState
            r1.<init>()
            java.lang.String r2 = "http.auth.target-scope"
            r10.setAttribute(r2, r1)
        L_0x002d:
            r14 = r1
            cz.msebera.android.httpclient.auth.AuthState r1 = r27.getProxyAuthState()
            if (r1 != 0) goto L_0x003e
            cz.msebera.android.httpclient.auth.AuthState r1 = new cz.msebera.android.httpclient.auth.AuthState
            r1.<init>()
            java.lang.String r2 = "http.auth.proxy-scope"
            r10.setAttribute(r2, r1)
        L_0x003e:
            r15 = r1
            boolean r1 = r9 instanceof p052cz.msebera.android.httpclient.HttpEntityEnclosingRequest
            if (r1 == 0) goto L_0x0049
            r1 = r9
            cz.msebera.android.httpclient.HttpEntityEnclosingRequest r1 = (p052cz.msebera.android.httpclient.HttpEntityEnclosingRequest) r1
            p052cz.msebera.android.httpclient.impl.execchain.RequestEntityProxy.enhance(r1)
        L_0x0049:
            java.lang.Object r6 = r27.getUserToken()
            cz.msebera.android.httpclient.conn.HttpClientConnectionManager r1 = r7.connManager
            cz.msebera.android.httpclient.conn.ConnectionRequest r1 = r1.requestConnection(r8, r6)
            java.lang.String r5 = "Request aborted"
            if (r11 == 0) goto L_0x006a
            boolean r2 = r28.isAborted()
            if (r2 != 0) goto L_0x0061
            r11.setCancellable(r1)
            goto L_0x006a
        L_0x0061:
            r1.cancel()
            cz.msebera.android.httpclient.impl.execchain.RequestAbortedException r1 = new cz.msebera.android.httpclient.impl.execchain.RequestAbortedException
            r1.<init>(r5)
            throw r1
        L_0x006a:
            cz.msebera.android.httpclient.client.config.RequestConfig r16 = r27.getRequestConfig()
            int r2 = r16.getConnectionRequestTimeout()     // Catch:{ InterruptedException -> 0x036f, ExecutionException -> 0x035d }
            r17 = 0
            if (r2 <= 0) goto L_0x0078
            long r2 = (long) r2     // Catch:{ InterruptedException -> 0x036f, ExecutionException -> 0x035d }
            goto L_0x007a
        L_0x0078:
            r2 = r17
        L_0x007a:
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x036f, ExecutionException -> 0x035d }
            cz.msebera.android.httpclient.HttpClientConnection r4 = r1.get(r2, r4)     // Catch:{ InterruptedException -> 0x036f, ExecutionException -> 0x035d }
            java.lang.String r1 = "http.connection"
            r10.setAttribute(r1, r4)
            boolean r1 = r16.isStaleConnectionCheckEnabled()
            if (r1 == 0) goto L_0x00a8
            boolean r1 = r4.isOpen()
            if (r1 == 0) goto L_0x00a8
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r1 = r7.log
            java.lang.String r2 = "Stale connection check"
            r1.debug(r2)
            boolean r1 = r4.isStale()
            if (r1 == 0) goto L_0x00a8
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r1 = r7.log
            java.lang.String r2 = "Stale connection detected"
            r1.debug(r2)
            r4.close()
        L_0x00a8:
            cz.msebera.android.httpclient.impl.execchain.ConnectionHolder r3 = new cz.msebera.android.httpclient.impl.execchain.ConnectionHolder
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r1 = r7.log
            cz.msebera.android.httpclient.conn.HttpClientConnectionManager r2 = r7.connManager
            r3.<init>(r1, r2, r4)
            if (r11 == 0) goto L_0x00ca
            r11.setCancellable(r3)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x00c1, IOException -> 0x00bc, RuntimeException -> 0x00b7 }
            goto L_0x00ca
        L_0x00b7:
            r0 = move-exception
            r1 = r0
            r11 = r3
            goto L_0x0340
        L_0x00bc:
            r0 = move-exception
            r1 = r0
            r11 = r3
            goto L_0x0347
        L_0x00c1:
            r0 = move-exception
            r1 = r0
            r11 = r3
            goto L_0x034e
        L_0x00c6:
            r0 = move-exception
            r1 = r0
            goto L_0x0352
        L_0x00ca:
            r2 = 1
            r1 = 1
        L_0x00cc:
            if (r1 <= r2) goto L_0x00dd
            boolean r19 = p052cz.msebera.android.httpclient.impl.execchain.RequestEntityProxy.isRepeatable(r26)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x00c1, IOException -> 0x00bc, RuntimeException -> 0x00b7 }
            if (r19 == 0) goto L_0x00d5
            goto L_0x00dd
        L_0x00d5:
            cz.msebera.android.httpclient.client.NonRepeatableRequestException r1 = new cz.msebera.android.httpclient.client.NonRepeatableRequestException     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x00c1, IOException -> 0x00bc, RuntimeException -> 0x00b7 }
            java.lang.String r2 = "Cannot retry request with a non-repeatable request entity."
            r1.<init>(r2)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x00c1, IOException -> 0x00bc, RuntimeException -> 0x00b7 }
            throw r1     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x00c1, IOException -> 0x00bc, RuntimeException -> 0x00b7 }
        L_0x00dd:
            if (r11 == 0) goto L_0x00ec
            boolean r19 = r28.isAborted()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x00c1, IOException -> 0x00bc, RuntimeException -> 0x00b7 }
            if (r19 != 0) goto L_0x00e6
            goto L_0x00ec
        L_0x00e6:
            cz.msebera.android.httpclient.impl.execchain.RequestAbortedException r1 = new cz.msebera.android.httpclient.impl.execchain.RequestAbortedException     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x00c1, IOException -> 0x00bc, RuntimeException -> 0x00b7 }
            r1.<init>(r5)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x00c1, IOException -> 0x00bc, RuntimeException -> 0x00b7 }
            throw r1     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x00c1, IOException -> 0x00bc, RuntimeException -> 0x00b7 }
        L_0x00ec:
            boolean r19 = r4.isOpen()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x034b, IOException -> 0x0344, RuntimeException -> 0x033d }
            if (r19 != 0) goto L_0x013f
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r2 = r7.log     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x00c1, IOException -> 0x00bc, RuntimeException -> 0x00b7 }
            r20 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x00c1, IOException -> 0x00bc, RuntimeException -> 0x00b7 }
            r1.<init>()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x00c1, IOException -> 0x00bc, RuntimeException -> 0x00b7 }
            r21 = r3
            java.lang.String r3 = "Opening connection "
            r1.append(r3)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r1.append(r8)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            java.lang.String r1 = r1.toString()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r2.debug(r1)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r1 = r24
            r19 = 1
            r2 = r15
            r8 = r21
            r3 = r4
            r8 = r4
            r4 = r25
            r22 = r15
            r15 = r5
            r5 = r26
            r23 = r6
            r6 = r27
            r1.establishRoute(r2, r3, r4, r5, r6)     // Catch:{ TunnelRefusedException -> 0x0124 }
            goto L_0x014b
        L_0x0124:
            r0 = move-exception
            r1 = r0
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r2 = r7.log     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            boolean r2 = r2.isDebugEnabled()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            if (r2 == 0) goto L_0x0137
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r2 = r7.log     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            java.lang.String r3 = r1.getMessage()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r2.debug(r3)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
        L_0x0137:
            cz.msebera.android.httpclient.HttpResponse r1 = r1.getResponse()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r11 = r21
            goto L_0x02f9
        L_0x013f:
            r20 = r1
            r21 = r3
            r8 = r4
            r23 = r6
            r22 = r15
            r19 = 1
            r15 = r5
        L_0x014b:
            int r1 = r16.getSocketTimeout()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0339, IOException -> 0x0335, RuntimeException -> 0x0331 }
            if (r1 < 0) goto L_0x0167
            r8.setSocketTimeout(r1)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            goto L_0x0167
        L_0x0155:
            r0 = move-exception
            r1 = r0
            r11 = r21
            goto L_0x0340
        L_0x015b:
            r0 = move-exception
            r1 = r0
            r11 = r21
            goto L_0x0347
        L_0x0161:
            r0 = move-exception
            r1 = r0
            r11 = r21
            goto L_0x034e
        L_0x0167:
            if (r11 == 0) goto L_0x0176
            boolean r1 = r28.isAborted()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            if (r1 != 0) goto L_0x0170
            goto L_0x0176
        L_0x0170:
            cz.msebera.android.httpclient.impl.execchain.RequestAbortedException r1 = new cz.msebera.android.httpclient.impl.execchain.RequestAbortedException     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r1.<init>(r15)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            throw r1     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
        L_0x0176:
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r1 = r7.log     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0339, IOException -> 0x0335, RuntimeException -> 0x0331 }
            boolean r1 = r1.isDebugEnabled()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0339, IOException -> 0x0335, RuntimeException -> 0x0331 }
            if (r1 == 0) goto L_0x0198
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r1 = r7.log     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r2.<init>()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            java.lang.String r3 = "Executing request "
            r2.append(r3)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            cz.msebera.android.httpclient.RequestLine r3 = r26.getRequestLine()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r2.append(r3)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            java.lang.String r2 = r2.toString()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r1.debug(r2)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
        L_0x0198:
            boolean r1 = r9.containsHeader(r13)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0339, IOException -> 0x0335, RuntimeException -> 0x0331 }
            if (r1 != 0) goto L_0x01c5
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r1 = r7.log     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            boolean r1 = r1.isDebugEnabled()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            if (r1 == 0) goto L_0x01c0
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r1 = r7.log     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r2.<init>()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            java.lang.String r3 = "Target auth state: "
            r2.append(r3)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            cz.msebera.android.httpclient.auth.AuthProtocolState r3 = r14.getState()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r2.append(r3)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            java.lang.String r2 = r2.toString()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r1.debug(r2)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
        L_0x01c0:
            cz.msebera.android.httpclient.impl.auth.HttpAuthenticator r1 = r7.authenticator     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r1.generateAuthResponse(r9, r14, r10)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
        L_0x01c5:
            boolean r1 = r9.containsHeader(r12)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0339, IOException -> 0x0335, RuntimeException -> 0x0331 }
            if (r1 != 0) goto L_0x01fb
            boolean r1 = r25.isTunnelled()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            if (r1 != 0) goto L_0x01fb
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r1 = r7.log     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            boolean r1 = r1.isDebugEnabled()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            if (r1 == 0) goto L_0x01f3
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r1 = r7.log     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r2.<init>()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            java.lang.String r3 = "Proxy auth state: "
            r2.append(r3)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            cz.msebera.android.httpclient.auth.AuthProtocolState r3 = r22.getState()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r2.append(r3)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            java.lang.String r2 = r2.toString()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r1.debug(r2)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
        L_0x01f3:
            cz.msebera.android.httpclient.impl.auth.HttpAuthenticator r1 = r7.authenticator     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r6 = r22
            r1.generateAuthResponse(r9, r6, r10)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            goto L_0x01fd
        L_0x01fb:
            r6 = r22
        L_0x01fd:
            cz.msebera.android.httpclient.protocol.HttpRequestExecutor r1 = r7.requestExecutor     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0339, IOException -> 0x0335, RuntimeException -> 0x0331 }
            cz.msebera.android.httpclient.HttpResponse r5 = r1.execute(r9, r8, r10)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0339, IOException -> 0x0335, RuntimeException -> 0x0331 }
            cz.msebera.android.httpclient.ConnectionReuseStrategy r1 = r7.reuseStrategy     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0339, IOException -> 0x0335, RuntimeException -> 0x0331 }
            boolean r1 = r1.keepAlive(r5, r10)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0339, IOException -> 0x0335, RuntimeException -> 0x0331 }
            if (r1 == 0) goto L_0x0261
            cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy r1 = r7.keepAliveStrategy     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0339, IOException -> 0x0335, RuntimeException -> 0x0331 }
            long r1 = r1.getKeepAliveDuration(r5, r10)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0339, IOException -> 0x0335, RuntimeException -> 0x0331 }
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r3 = r7.log     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0339, IOException -> 0x0335, RuntimeException -> 0x0331 }
            boolean r3 = r3.isDebugEnabled()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0339, IOException -> 0x0335, RuntimeException -> 0x0331 }
            if (r3 == 0) goto L_0x0254
            int r3 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r3 <= 0) goto L_0x0239
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r3.<init>()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            java.lang.String r4 = "for "
            r3.append(r4)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r3.append(r1)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            java.lang.String r4 = " "
            r3.append(r4)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r3.append(r4)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            java.lang.String r3 = r3.toString()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            goto L_0x023b
        L_0x0239:
            java.lang.String r3 = "indefinitely"
        L_0x023b:
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r4 = r7.log     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r22 = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r5.<init>()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            java.lang.String r11 = "Connection can be kept alive "
            r5.append(r11)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r5.append(r3)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            java.lang.String r3 = r5.toString()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            r4.debug(r3)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0161, IOException -> 0x015b, RuntimeException -> 0x0155 }
            goto L_0x0256
        L_0x0254:
            r22 = r5
        L_0x0256:
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x0339, IOException -> 0x0335, RuntimeException -> 0x0331 }
            r11 = r21
            r11.setValidFor(r1, r3)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            r11.markReusable()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            goto L_0x0268
        L_0x0261:
            r22 = r5
            r11 = r21
            r11.markNonReusable()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
        L_0x0268:
            r1 = r24
            r2 = r14
            r3 = r6
            r4 = r25
            r21 = r22
            r5 = r21
            r22 = r6
            r6 = r27
            boolean r1 = r1.needAuthentication(r2, r3, r4, r5, r6)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            if (r1 == 0) goto L_0x02f7
            cz.msebera.android.httpclient.HttpEntity r1 = r21.getEntity()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            boolean r2 = r11.isReusable()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            if (r2 == 0) goto L_0x028a
            p052cz.msebera.android.httpclient.util.EntityUtils.consume(r1)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            goto L_0x02d1
        L_0x028a:
            r8.close()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            cz.msebera.android.httpclient.auth.AuthProtocolState r1 = r22.getState()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            cz.msebera.android.httpclient.auth.AuthProtocolState r2 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.SUCCESS     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            if (r1 != r2) goto L_0x02af
            cz.msebera.android.httpclient.auth.AuthScheme r1 = r22.getAuthScheme()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            if (r1 == 0) goto L_0x02af
            cz.msebera.android.httpclient.auth.AuthScheme r1 = r22.getAuthScheme()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            boolean r1 = r1.isConnectionBased()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            if (r1 == 0) goto L_0x02af
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r1 = r7.log     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            java.lang.String r2 = "Resetting proxy auth state"
            r1.debug(r2)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            r22.reset()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
        L_0x02af:
            cz.msebera.android.httpclient.auth.AuthProtocolState r1 = r14.getState()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            cz.msebera.android.httpclient.auth.AuthProtocolState r2 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.SUCCESS     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            if (r1 != r2) goto L_0x02d1
            cz.msebera.android.httpclient.auth.AuthScheme r1 = r14.getAuthScheme()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            if (r1 == 0) goto L_0x02d1
            cz.msebera.android.httpclient.auth.AuthScheme r1 = r14.getAuthScheme()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            boolean r1 = r1.isConnectionBased()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            if (r1 == 0) goto L_0x02d1
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r1 = r7.log     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            java.lang.String r2 = "Resetting target auth state"
            r1.debug(r2)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            r14.reset()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
        L_0x02d1:
            cz.msebera.android.httpclient.HttpRequest r1 = r26.getOriginal()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            boolean r2 = r1.containsHeader(r13)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            if (r2 != 0) goto L_0x02de
            r9.removeHeaders(r13)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
        L_0x02de:
            boolean r1 = r1.containsHeader(r12)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            if (r1 != 0) goto L_0x02e7
            r9.removeHeaders(r12)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
        L_0x02e7:
            int r1 = r20 + 1
            r4 = r8
            r3 = r11
            r5 = r15
            r15 = r22
            r6 = r23
            r2 = 1
            r8 = r25
            r11 = r28
            goto L_0x00cc
        L_0x02f7:
            r1 = r21
        L_0x02f9:
            if (r23 != 0) goto L_0x030d
            cz.msebera.android.httpclient.client.UserTokenHandler r2 = r7.userTokenHandler     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            java.lang.Object r6 = r2.getUserToken(r10)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            java.lang.String r2 = "http.user-token"
            r10.setAttribute(r2, r6)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            goto L_0x030f
        L_0x0307:
            r0 = move-exception
            goto L_0x033f
        L_0x0309:
            r0 = move-exception
            goto L_0x0346
        L_0x030b:
            r0 = move-exception
            goto L_0x034d
        L_0x030d:
            r6 = r23
        L_0x030f:
            if (r6 == 0) goto L_0x0314
            r11.setState(r6)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
        L_0x0314:
            cz.msebera.android.httpclient.HttpEntity r2 = r1.getEntity()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            if (r2 == 0) goto L_0x0327
            boolean r2 = r2.isStreaming()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            if (r2 != 0) goto L_0x0321
            goto L_0x0327
        L_0x0321:
            cz.msebera.android.httpclient.impl.execchain.HttpResponseProxy r2 = new cz.msebera.android.httpclient.impl.execchain.HttpResponseProxy     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            r2.<init>(r1, r11)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            return r2
        L_0x0327:
            r11.releaseConnection()     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            cz.msebera.android.httpclient.impl.execchain.HttpResponseProxy r2 = new cz.msebera.android.httpclient.impl.execchain.HttpResponseProxy     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            r3 = 0
            r2.<init>(r1, r3)     // Catch:{ ConnectionShutdownException -> 0x00c6, HttpException -> 0x030b, IOException -> 0x0309, RuntimeException -> 0x0307 }
            return r2
        L_0x0331:
            r0 = move-exception
            r11 = r21
            goto L_0x033f
        L_0x0335:
            r0 = move-exception
            r11 = r21
            goto L_0x0346
        L_0x0339:
            r0 = move-exception
            r11 = r21
            goto L_0x034d
        L_0x033d:
            r0 = move-exception
            r11 = r3
        L_0x033f:
            r1 = r0
        L_0x0340:
            r11.abortConnection()
            throw r1
        L_0x0344:
            r0 = move-exception
            r11 = r3
        L_0x0346:
            r1 = r0
        L_0x0347:
            r11.abortConnection()
            throw r1
        L_0x034b:
            r0 = move-exception
            r11 = r3
        L_0x034d:
            r1 = r0
        L_0x034e:
            r11.abortConnection()
            throw r1
        L_0x0352:
            java.io.InterruptedIOException r2 = new java.io.InterruptedIOException
            java.lang.String r3 = "Connection has been shut down"
            r2.<init>(r3)
            r2.initCause(r1)
            throw r2
        L_0x035d:
            r0 = move-exception
            r1 = r0
            java.lang.Throwable r2 = r1.getCause()
            if (r2 != 0) goto L_0x0366
            goto L_0x0367
        L_0x0366:
            r1 = r2
        L_0x0367:
            cz.msebera.android.httpclient.impl.execchain.RequestAbortedException r2 = new cz.msebera.android.httpclient.impl.execchain.RequestAbortedException
            java.lang.String r3 = "Request execution failed"
            r2.<init>(r3, r1)
            throw r2
        L_0x036f:
            r0 = move-exception
            r15 = r5
            r1 = r0
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r2.interrupt()
            cz.msebera.android.httpclient.impl.execchain.RequestAbortedException r2 = new cz.msebera.android.httpclient.impl.execchain.RequestAbortedException
            r2.<init>(r15, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.execchain.MainClientExec.execute(cz.msebera.android.httpclient.conn.routing.HttpRoute, cz.msebera.android.httpclient.client.methods.HttpRequestWrapper, cz.msebera.android.httpclient.client.protocol.HttpClientContext, cz.msebera.android.httpclient.client.methods.HttpExecutionAware):cz.msebera.android.httpclient.client.methods.CloseableHttpResponse");
    }

    /* access modifiers changed from: package-private */
    public void establishRoute(AuthState authState, HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpRequest httpRequest, HttpClientContext httpClientContext) throws HttpException, IOException {
        int nextStep;
        int connectTimeout = httpClientContext.getRequestConfig().getConnectTimeout();
        RouteTracker routeTracker = new RouteTracker(httpRoute);
        do {
            HttpRoute route = routeTracker.toRoute();
            nextStep = this.routeDirector.nextStep(httpRoute, route);
            int i = 0;
            switch (nextStep) {
                case -1:
                    throw new HttpException("Unable to establish route: planned = " + httpRoute + "; current = " + route);
                case 0:
                    this.connManager.routeComplete(httpClientConnection, httpRoute, httpClientContext);
                    continue;
                case 1:
                    HttpClientConnectionManager httpClientConnectionManager = this.connManager;
                    if (connectTimeout > 0) {
                        i = connectTimeout;
                    }
                    httpClientConnectionManager.connect(httpClientConnection, httpRoute, i, httpClientContext);
                    routeTracker.connectTarget(httpRoute.isSecure());
                    continue;
                case 2:
                    this.connManager.connect(httpClientConnection, httpRoute, connectTimeout > 0 ? connectTimeout : 0, httpClientContext);
                    routeTracker.connectProxy(httpRoute.getProxyHost(), false);
                    continue;
                case 3:
                    boolean createTunnelToTarget = createTunnelToTarget(authState, httpClientConnection, httpRoute, httpRequest, httpClientContext);
                    this.log.debug("Tunnel to target created.");
                    routeTracker.tunnelTarget(createTunnelToTarget);
                    continue;
                case 4:
                    int hopCount = route.getHopCount() - 1;
                    boolean createTunnelToProxy = createTunnelToProxy(httpRoute, hopCount, httpClientContext);
                    this.log.debug("Tunnel to proxy created.");
                    routeTracker.tunnelProxy(httpRoute.getHopTarget(hopCount), createTunnelToProxy);
                    continue;
                case 5:
                    this.connManager.upgrade(httpClientConnection, httpRoute, httpClientContext);
                    routeTracker.layerProtocol(httpRoute.isSecure());
                    continue;
                default:
                    throw new IllegalStateException("Unknown step indicator " + nextStep + " from RouteDirector.");
            }
        } while (nextStep > 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008e, code lost:
        r3 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0096, code lost:
        if (r0.reuseStrategy.keepAlive(r3, r8) == false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0098, code lost:
        r0.log.debug("Connection kept alive");
        p052cz.msebera.android.httpclient.util.EntityUtils.consume(r3.getEntity());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a7, code lost:
        r18.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean createTunnelToTarget(p052cz.msebera.android.httpclient.auth.AuthState r17, p052cz.msebera.android.httpclient.HttpClientConnection r18, p052cz.msebera.android.httpclient.conn.routing.HttpRoute r19, p052cz.msebera.android.httpclient.HttpRequest r20, p052cz.msebera.android.httpclient.client.protocol.HttpClientContext r21) throws p052cz.msebera.android.httpclient.HttpException, java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            r8 = r21
            cz.msebera.android.httpclient.client.config.RequestConfig r9 = r21.getRequestConfig()
            int r10 = r9.getConnectTimeout()
            cz.msebera.android.httpclient.HttpHost r2 = r19.getTargetHost()
            cz.msebera.android.httpclient.HttpHost r11 = r19.getProxyHost()
            java.lang.String r2 = r2.toHostString()
            cz.msebera.android.httpclient.message.BasicHttpRequest r12 = new cz.msebera.android.httpclient.message.BasicHttpRequest
            cz.msebera.android.httpclient.ProtocolVersion r3 = r20.getProtocolVersion()
            java.lang.String r4 = "CONNECT"
            r12.<init>(r4, r2, r3)
            cz.msebera.android.httpclient.protocol.HttpRequestExecutor r2 = r0.requestExecutor
            cz.msebera.android.httpclient.protocol.HttpProcessor r3 = r0.proxyHttpProcessor
            r2.preProcess(r12, r3, r8)
            r13 = 0
        L_0x002d:
            r2 = r13
        L_0x002e:
            r3 = 0
            if (r2 != 0) goto L_0x00ce
            boolean r2 = r18.isOpen()
            if (r2 != 0) goto L_0x0045
            cz.msebera.android.httpclient.conn.HttpClientConnectionManager r2 = r0.connManager
            if (r10 <= 0) goto L_0x003f
            r14 = r19
            r3 = r10
            goto L_0x0041
        L_0x003f:
            r14 = r19
        L_0x0041:
            r2.connect(r1, r14, r3, r8)
            goto L_0x0047
        L_0x0045:
            r14 = r19
        L_0x0047:
            java.lang.String r2 = "Proxy-Authorization"
            r12.removeHeaders(r2)
            cz.msebera.android.httpclient.impl.auth.HttpAuthenticator r2 = r0.authenticator
            r15 = r17
            r2.generateAuthResponse(r12, r15, r8)
            cz.msebera.android.httpclient.protocol.HttpRequestExecutor r2 = r0.requestExecutor
            cz.msebera.android.httpclient.HttpResponse r7 = r2.execute(r12, r1, r8)
            cz.msebera.android.httpclient.StatusLine r2 = r7.getStatusLine()
            int r2 = r2.getStatusCode()
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 < r3) goto L_0x00b2
            boolean r2 = r9.isAuthenticationEnabled()
            if (r2 == 0) goto L_0x00ae
            cz.msebera.android.httpclient.impl.auth.HttpAuthenticator r2 = r0.authenticator
            cz.msebera.android.httpclient.client.AuthenticationStrategy r5 = r0.proxyAuthStrategy
            r3 = r11
            r4 = r7
            r6 = r17
            r20 = r7
            r7 = r21
            boolean r2 = r2.isAuthenticationRequested(r3, r4, r5, r6, r7)
            if (r2 == 0) goto L_0x00ab
            cz.msebera.android.httpclient.impl.auth.HttpAuthenticator r2 = r0.authenticator
            cz.msebera.android.httpclient.client.AuthenticationStrategy r5 = r0.proxyAuthStrategy
            r3 = r11
            r4 = r20
            r6 = r17
            r7 = r21
            boolean r2 = r2.handleAuthChallenge(r3, r4, r5, r6, r7)
            if (r2 == 0) goto L_0x00ab
            cz.msebera.android.httpclient.ConnectionReuseStrategy r2 = r0.reuseStrategy
            r3 = r20
            boolean r2 = r2.keepAlive(r3, r8)
            if (r2 == 0) goto L_0x00a7
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r2 = r0.log
            java.lang.String r4 = "Connection kept alive"
            r2.debug(r4)
            cz.msebera.android.httpclient.HttpEntity r2 = r3.getEntity()
            p052cz.msebera.android.httpclient.util.EntityUtils.consume(r2)
            goto L_0x002d
        L_0x00a7:
            r18.close()
            goto L_0x002d
        L_0x00ab:
            r3 = r20
            goto L_0x00af
        L_0x00ae:
            r3 = r7
        L_0x00af:
            r2 = r3
            goto L_0x002e
        L_0x00b2:
            r3 = r7
            cz.msebera.android.httpclient.HttpException r1 = new cz.msebera.android.httpclient.HttpException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Unexpected response to CONNECT request: "
            r2.append(r4)
            cz.msebera.android.httpclient.StatusLine r3 = r3.getStatusLine()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00ce:
            cz.msebera.android.httpclient.StatusLine r4 = r2.getStatusLine()
            int r4 = r4.getStatusCode()
            r5 = 299(0x12b, float:4.19E-43)
            if (r4 <= r5) goto L_0x0106
            cz.msebera.android.httpclient.HttpEntity r3 = r2.getEntity()
            if (r3 == 0) goto L_0x00e8
            cz.msebera.android.httpclient.entity.BufferedHttpEntity r4 = new cz.msebera.android.httpclient.entity.BufferedHttpEntity
            r4.<init>(r3)
            r2.setEntity(r4)
        L_0x00e8:
            r18.close()
            cz.msebera.android.httpclient.impl.execchain.TunnelRefusedException r1 = new cz.msebera.android.httpclient.impl.execchain.TunnelRefusedException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "CONNECT refused by proxy: "
            r3.append(r4)
            cz.msebera.android.httpclient.StatusLine r4 = r2.getStatusLine()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.<init>(r3, r2)
            throw r1
        L_0x0106:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.execchain.MainClientExec.createTunnelToTarget(cz.msebera.android.httpclient.auth.AuthState, cz.msebera.android.httpclient.HttpClientConnection, cz.msebera.android.httpclient.conn.routing.HttpRoute, cz.msebera.android.httpclient.HttpRequest, cz.msebera.android.httpclient.client.protocol.HttpClientContext):boolean");
    }

    private boolean createTunnelToProxy(HttpRoute httpRoute, int i, HttpClientContext httpClientContext) throws HttpException {
        throw new HttpException("Proxy chains are not supported.");
    }

    private boolean needAuthentication(AuthState authState, AuthState authState2, HttpRoute httpRoute, HttpResponse httpResponse, HttpClientContext httpClientContext) {
        if (!httpClientContext.getRequestConfig().isAuthenticationEnabled()) {
            return false;
        }
        HttpHost targetHost = httpClientContext.getTargetHost();
        if (targetHost == null) {
            targetHost = httpRoute.getTargetHost();
        }
        if (targetHost.getPort() < 0) {
            targetHost = new HttpHost(targetHost.getHostName(), httpRoute.getTargetHost().getPort(), targetHost.getSchemeName());
        }
        boolean isAuthenticationRequested = this.authenticator.isAuthenticationRequested(targetHost, httpResponse, this.targetAuthStrategy, authState, httpClientContext);
        HttpHost proxyHost = httpRoute.getProxyHost();
        if (proxyHost == null) {
            proxyHost = httpRoute.getTargetHost();
        }
        boolean isAuthenticationRequested2 = this.authenticator.isAuthenticationRequested(proxyHost, httpResponse, this.proxyAuthStrategy, authState2, httpClientContext);
        if (isAuthenticationRequested) {
            return this.authenticator.handleAuthChallenge(targetHost, httpResponse, this.targetAuthStrategy, authState, httpClientContext);
        } else if (!isAuthenticationRequested2) {
            return false;
        } else {
            return this.authenticator.handleAuthChallenge(proxyHost, httpResponse, this.proxyAuthStrategy, authState2, httpClientContext);
        }
    }
}
