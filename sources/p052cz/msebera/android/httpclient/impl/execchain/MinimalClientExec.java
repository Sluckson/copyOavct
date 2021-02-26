package p052cz.msebera.android.httpclient.impl.execchain;

import java.net.URI;
import java.net.URISyntaxException;
import p052cz.msebera.android.httpclient.ConnectionReuseStrategy;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.ProtocolException;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import p052cz.msebera.android.httpclient.client.protocol.RequestClientConnControl;
import p052cz.msebera.android.httpclient.client.utils.URIUtils;
import p052cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import p052cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.protocol.HttpProcessor;
import p052cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import p052cz.msebera.android.httpclient.protocol.ImmutableHttpProcessor;
import p052cz.msebera.android.httpclient.protocol.RequestContent;
import p052cz.msebera.android.httpclient.protocol.RequestTargetHost;
import p052cz.msebera.android.httpclient.protocol.RequestUserAgent;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.VersionInfo;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.execchain.MinimalClientExec */
public class MinimalClientExec implements ClientExecChain {
    private final HttpClientConnectionManager connManager;
    private final HttpProcessor httpProcessor;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;

    public MinimalClientExec(HttpRequestExecutor httpRequestExecutor, HttpClientConnectionManager httpClientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy) {
        Args.notNull(httpRequestExecutor, "HTTP request executor");
        Args.notNull(httpClientConnectionManager, "Client connection manager");
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        Args.notNull(connectionKeepAliveStrategy, "Connection keep alive strategy");
        this.httpProcessor = new ImmutableHttpProcessor(new RequestContent(), new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent(VersionInfo.getUserAgent("Apache-HttpClient", "cz.msebera.android.httpclient.client", getClass())));
        this.requestExecutor = httpRequestExecutor;
        this.connManager = httpClientConnectionManager;
        this.reuseStrategy = connectionReuseStrategy;
        this.keepAliveStrategy = connectionKeepAliveStrategy;
    }

    static void rewriteRequestURI(HttpRequestWrapper httpRequestWrapper, HttpRoute httpRoute) throws ProtocolException {
        URI uri;
        try {
            URI uri2 = httpRequestWrapper.getURI();
            if (uri2 != null) {
                if (uri2.isAbsolute()) {
                    uri = URIUtils.rewriteURI(uri2, (HttpHost) null, true);
                } else {
                    uri = URIUtils.rewriteURI(uri2);
                }
                httpRequestWrapper.setURI(uri);
            }
        } catch (URISyntaxException e) {
            throw new ProtocolException("Invalid URI: " + httpRequestWrapper.getRequestLine().getUri(), e);
        }
    }

    /* JADX WARNING: type inference failed for: r9v3, types: [java.lang.Throwable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ac A[Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dc A[Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00eb A[Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f4 A[Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p052cz.msebera.android.httpclient.client.methods.CloseableHttpResponse execute(p052cz.msebera.android.httpclient.conn.routing.HttpRoute r8, p052cz.msebera.android.httpclient.client.methods.HttpRequestWrapper r9, p052cz.msebera.android.httpclient.client.protocol.HttpClientContext r10, p052cz.msebera.android.httpclient.client.methods.HttpExecutionAware r11) throws java.io.IOException, p052cz.msebera.android.httpclient.HttpException {
        /*
            r7 = this;
            java.lang.String r0 = "HTTP route"
            p052cz.msebera.android.httpclient.util.Args.notNull(r8, r0)
            java.lang.String r0 = "HTTP request"
            p052cz.msebera.android.httpclient.util.Args.notNull(r9, r0)
            java.lang.String r0 = "HTTP context"
            p052cz.msebera.android.httpclient.util.Args.notNull(r10, r0)
            rewriteRequestURI(r9, r8)
            cz.msebera.android.httpclient.conn.HttpClientConnectionManager r0 = r7.connManager
            r1 = 0
            cz.msebera.android.httpclient.conn.ConnectionRequest r0 = r0.requestConnection(r8, r1)
            java.lang.String r2 = "Request aborted"
            if (r11 == 0) goto L_0x0030
            boolean r3 = r11.isAborted()
            if (r3 != 0) goto L_0x0027
            r11.setCancellable(r0)
            goto L_0x0030
        L_0x0027:
            r0.cancel()
            cz.msebera.android.httpclient.impl.execchain.RequestAbortedException r8 = new cz.msebera.android.httpclient.impl.execchain.RequestAbortedException
            r8.<init>(r2)
            throw r8
        L_0x0030:
            cz.msebera.android.httpclient.client.config.RequestConfig r3 = r10.getRequestConfig()
            int r4 = r3.getConnectionRequestTimeout()     // Catch:{ InterruptedException -> 0x0136, ExecutionException -> 0x0125 }
            if (r4 <= 0) goto L_0x003c
            long r4 = (long) r4     // Catch:{ InterruptedException -> 0x0136, ExecutionException -> 0x0125 }
            goto L_0x003e
        L_0x003c:
            r4 = 0
        L_0x003e:
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x0136, ExecutionException -> 0x0125 }
            cz.msebera.android.httpclient.HttpClientConnection r0 = r0.get(r4, r6)     // Catch:{ InterruptedException -> 0x0136, ExecutionException -> 0x0125 }
            cz.msebera.android.httpclient.impl.execchain.ConnectionHolder r4 = new cz.msebera.android.httpclient.impl.execchain.ConnectionHolder
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r5 = r7.log
            cz.msebera.android.httpclient.conn.HttpClientConnectionManager r6 = r7.connManager
            r4.<init>(r5, r6, r0)
            if (r11 == 0) goto L_0x0062
            boolean r5 = r11.isAborted()     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            if (r5 != 0) goto L_0x0059
            r11.setCancellable(r4)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            goto L_0x0062
        L_0x0059:
            r4.close()     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            cz.msebera.android.httpclient.impl.execchain.RequestAbortedException r8 = new cz.msebera.android.httpclient.impl.execchain.RequestAbortedException     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            r8.<init>(r2)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            throw r8     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
        L_0x0062:
            boolean r11 = r0.isOpen()     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            if (r11 != 0) goto L_0x007a
            int r11 = r3.getConnectTimeout()     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            cz.msebera.android.httpclient.conn.HttpClientConnectionManager r2 = r7.connManager     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            if (r11 <= 0) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r11 = 0
        L_0x0072:
            r2.connect(r0, r8, r11, r10)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            cz.msebera.android.httpclient.conn.HttpClientConnectionManager r11 = r7.connManager     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            r11.routeComplete(r0, r8, r10)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
        L_0x007a:
            int r11 = r3.getSocketTimeout()     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            if (r11 < 0) goto L_0x0083
            r0.setSocketTimeout(r11)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
        L_0x0083:
            cz.msebera.android.httpclient.HttpRequest r11 = r9.getOriginal()     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            boolean r2 = r11 instanceof p052cz.msebera.android.httpclient.client.methods.HttpUriRequest     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            if (r2 == 0) goto L_0x00a9
            cz.msebera.android.httpclient.client.methods.HttpUriRequest r11 = (p052cz.msebera.android.httpclient.client.methods.HttpUriRequest) r11     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            java.net.URI r11 = r11.getURI()     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            boolean r2 = r11.isAbsolute()     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            if (r2 == 0) goto L_0x00a9
            cz.msebera.android.httpclient.HttpHost r2 = new cz.msebera.android.httpclient.HttpHost     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            java.lang.String r3 = r11.getHost()     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            int r5 = r11.getPort()     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            java.lang.String r11 = r11.getScheme()     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            r2.<init>((java.lang.String) r3, (int) r5, (java.lang.String) r11)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            goto L_0x00aa
        L_0x00a9:
            r2 = r1
        L_0x00aa:
            if (r2 != 0) goto L_0x00b0
            cz.msebera.android.httpclient.HttpHost r2 = r8.getTargetHost()     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
        L_0x00b0:
            java.lang.String r11 = "http.target_host"
            r10.setAttribute(r11, r2)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            java.lang.String r11 = "http.request"
            r10.setAttribute(r11, r9)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            java.lang.String r11 = "http.connection"
            r10.setAttribute(r11, r0)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            java.lang.String r11 = "http.route"
            r10.setAttribute(r11, r8)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            cz.msebera.android.httpclient.protocol.HttpProcessor r8 = r7.httpProcessor     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            r8.process(r9, r10)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            cz.msebera.android.httpclient.protocol.HttpRequestExecutor r8 = r7.requestExecutor     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            cz.msebera.android.httpclient.HttpResponse r8 = r8.execute(r9, r0, r10)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            cz.msebera.android.httpclient.protocol.HttpProcessor r9 = r7.httpProcessor     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            r9.process(r8, r10)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            cz.msebera.android.httpclient.ConnectionReuseStrategy r9 = r7.reuseStrategy     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            boolean r9 = r9.keepAlive(r8, r10)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            if (r9 == 0) goto L_0x00eb
            cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy r9 = r7.keepAliveStrategy     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            long r9 = r9.getKeepAliveDuration(r8, r10)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            r4.setValidFor(r9, r11)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            r4.markReusable()     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            goto L_0x00ee
        L_0x00eb:
            r4.markNonReusable()     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
        L_0x00ee:
            cz.msebera.android.httpclient.HttpEntity r9 = r8.getEntity()     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            if (r9 == 0) goto L_0x0101
            boolean r9 = r9.isStreaming()     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            if (r9 != 0) goto L_0x00fb
            goto L_0x0101
        L_0x00fb:
            cz.msebera.android.httpclient.impl.execchain.HttpResponseProxy r9 = new cz.msebera.android.httpclient.impl.execchain.HttpResponseProxy     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            r9.<init>(r8, r4)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            return r9
        L_0x0101:
            r4.releaseConnection()     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            cz.msebera.android.httpclient.impl.execchain.HttpResponseProxy r9 = new cz.msebera.android.httpclient.impl.execchain.HttpResponseProxy     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            r9.<init>(r8, r1)     // Catch:{ ConnectionShutdownException -> 0x0119, HttpException -> 0x0114, IOException -> 0x010f, RuntimeException -> 0x010a }
            return r9
        L_0x010a:
            r8 = move-exception
            r4.abortConnection()
            throw r8
        L_0x010f:
            r8 = move-exception
            r4.abortConnection()
            throw r8
        L_0x0114:
            r8 = move-exception
            r4.abortConnection()
            throw r8
        L_0x0119:
            r8 = move-exception
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException
            java.lang.String r10 = "Connection has been shut down"
            r9.<init>(r10)
            r9.initCause(r8)
            throw r9
        L_0x0125:
            r8 = move-exception
            java.lang.Throwable r9 = r8.getCause()
            if (r9 != 0) goto L_0x012d
            goto L_0x012e
        L_0x012d:
            r8 = r9
        L_0x012e:
            cz.msebera.android.httpclient.impl.execchain.RequestAbortedException r9 = new cz.msebera.android.httpclient.impl.execchain.RequestAbortedException
            java.lang.String r10 = "Request execution failed"
            r9.<init>(r10, r8)
            throw r9
        L_0x0136:
            r8 = move-exception
            java.lang.Thread r9 = java.lang.Thread.currentThread()
            r9.interrupt()
            cz.msebera.android.httpclient.impl.execchain.RequestAbortedException r9 = new cz.msebera.android.httpclient.impl.execchain.RequestAbortedException
            r9.<init>(r2, r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.execchain.MinimalClientExec.execute(cz.msebera.android.httpclient.conn.routing.HttpRoute, cz.msebera.android.httpclient.client.methods.HttpRequestWrapper, cz.msebera.android.httpclient.client.protocol.HttpClientContext, cz.msebera.android.httpclient.client.methods.HttpExecutionAware):cz.msebera.android.httpclient.client.methods.CloseableHttpResponse");
    }
}
