package p052cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import p052cz.msebera.android.httpclient.config.Lookup;
import p052cz.msebera.android.httpclient.conn.DnsResolver;
import p052cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import p052cz.msebera.android.httpclient.conn.SchemePortResolver;
import p052cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import p052cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory;
import p052cz.msebera.android.httpclient.conn.socket.LayeredConnectionSocketFactory;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.conn.HttpClientConnectionOperator */
class HttpClientConnectionOperator {
    static final String SOCKET_FACTORY_REGISTRY = "http.socket-factory-registry";
    private final DnsResolver dnsResolver;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final SchemePortResolver schemePortResolver;
    private final Lookup<ConnectionSocketFactory> socketFactoryRegistry;

    HttpClientConnectionOperator(Lookup<ConnectionSocketFactory> lookup, SchemePortResolver schemePortResolver2, DnsResolver dnsResolver2) {
        Args.notNull(lookup, "Socket factory registry");
        this.socketFactoryRegistry = lookup;
        this.schemePortResolver = schemePortResolver2 == null ? DefaultSchemePortResolver.INSTANCE : schemePortResolver2;
        this.dnsResolver = dnsResolver2 == null ? SystemDefaultDnsResolver.INSTANCE : dnsResolver2;
    }

    private Lookup<ConnectionSocketFactory> getSocketFactoryRegistry(HttpContext httpContext) {
        Lookup<ConnectionSocketFactory> lookup = (Lookup) httpContext.getAttribute("http.socket-factory-registry");
        return lookup == null ? this.socketFactoryRegistry : lookup;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0120 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(p052cz.msebera.android.httpclient.conn.ManagedHttpClientConnection r21, p052cz.msebera.android.httpclient.HttpHost r22, java.net.InetSocketAddress r23, int r24, p052cz.msebera.android.httpclient.config.SocketConfig r25, p052cz.msebera.android.httpclient.protocol.HttpContext r26) throws java.io.IOException {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            r10 = r22
            r11 = r26
            cz.msebera.android.httpclient.config.Lookup r0 = r1.getSocketFactoryRegistry(r11)
            java.lang.String r3 = r22.getSchemeName()
            java.lang.Object r0 = r0.lookup(r3)
            r12 = r0
            cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory r12 = (p052cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory) r12
            if (r12 == 0) goto L_0x012d
            java.net.InetAddress r0 = r22.getAddress()
            r13 = 0
            r14 = 1
            if (r0 == 0) goto L_0x002a
            java.net.InetAddress[] r0 = new java.net.InetAddress[r14]
            java.net.InetAddress r3 = r22.getAddress()
            r0[r13] = r3
            goto L_0x0034
        L_0x002a:
            cz.msebera.android.httpclient.conn.DnsResolver r0 = r1.dnsResolver
            java.lang.String r3 = r22.getHostName()
            java.net.InetAddress[] r0 = r0.resolve(r3)
        L_0x0034:
            r15 = r0
            cz.msebera.android.httpclient.conn.SchemePortResolver r0 = r1.schemePortResolver
            int r9 = r0.resolve(r10)
            r8 = 0
        L_0x003c:
            int r0 = r15.length
            if (r8 >= r0) goto L_0x012c
            r0 = r15[r8]
            int r3 = r15.length
            int r3 = r3 - r14
            if (r8 != r3) goto L_0x0048
            r16 = 1
            goto L_0x004a
        L_0x0048:
            r16 = 0
        L_0x004a:
            java.net.Socket r5 = r12.createSocket(r11)
            int r3 = r25.getSoTimeout()
            r5.setSoTimeout(r3)
            boolean r3 = r25.isSoReuseAddress()
            r5.setReuseAddress(r3)
            boolean r3 = r25.isTcpNoDelay()
            r5.setTcpNoDelay(r3)
            boolean r3 = r25.isSoKeepAlive()
            r5.setKeepAlive(r3)
            int r3 = r25.getSoLinger()
            if (r3 < 0) goto L_0x0078
            if (r3 <= 0) goto L_0x0074
            r4 = 1
            goto L_0x0075
        L_0x0074:
            r4 = 0
        L_0x0075:
            r5.setSoLinger(r4, r3)
        L_0x0078:
            r2.bind(r5)
            java.net.InetSocketAddress r7 = new java.net.InetSocketAddress
            r7.<init>(r0, r9)
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r0 = r1.log
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto L_0x009e
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r0 = r1.log
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Connecting to "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r0.debug(r3)
        L_0x009e:
            r3 = r12
            r4 = r24
            r6 = r22
            r17 = r7
            r18 = r8
            r8 = r23
            r19 = r9
            r9 = r26
            java.net.Socket r0 = r3.connectSocket(r4, r5, r6, r7, r8, r9)     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectException -> 0x00d8, NoRouteToHostException -> 0x00d3 }
            r2.bind(r0)     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectException -> 0x00d8, NoRouteToHostException -> 0x00d3 }
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r0 = r1.log     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectException -> 0x00d8, NoRouteToHostException -> 0x00d3 }
            boolean r0 = r0.isDebugEnabled()     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectException -> 0x00d8, NoRouteToHostException -> 0x00d3 }
            if (r0 == 0) goto L_0x00d2
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r0 = r1.log     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectException -> 0x00d8, NoRouteToHostException -> 0x00d3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectException -> 0x00d8, NoRouteToHostException -> 0x00d3 }
            r3.<init>()     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectException -> 0x00d8, NoRouteToHostException -> 0x00d3 }
            java.lang.String r4 = "Connection established "
            r3.append(r4)     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectException -> 0x00d8, NoRouteToHostException -> 0x00d3 }
            r3.append(r2)     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectException -> 0x00d8, NoRouteToHostException -> 0x00d3 }
            java.lang.String r3 = r3.toString()     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectException -> 0x00d8, NoRouteToHostException -> 0x00d3 }
            r0.debug(r3)     // Catch:{ SocketTimeoutException -> 0x00f3, ConnectException -> 0x00d8, NoRouteToHostException -> 0x00d3 }
        L_0x00d2:
            return
        L_0x00d3:
            r0 = move-exception
            if (r16 != 0) goto L_0x00d7
            goto L_0x00f6
        L_0x00d7:
            throw r0
        L_0x00d8:
            r0 = move-exception
            if (r16 == 0) goto L_0x00f6
            java.lang.String r2 = r0.getMessage()
            java.lang.String r3 = "Connection timed out"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x00ed
            cz.msebera.android.httpclient.conn.ConnectTimeoutException r2 = new cz.msebera.android.httpclient.conn.ConnectTimeoutException
            r2.<init>(r0, r10, r15)
            throw r2
        L_0x00ed:
            cz.msebera.android.httpclient.conn.HttpHostConnectException r2 = new cz.msebera.android.httpclient.conn.HttpHostConnectException
            r2.<init>(r0, r10, r15)
            throw r2
        L_0x00f3:
            r0 = move-exception
            if (r16 != 0) goto L_0x0126
        L_0x00f6:
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r0 = r1.log
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto L_0x0120
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r0 = r1.log
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Connect to "
            r3.append(r4)
            r4 = r17
            r3.append(r4)
            java.lang.String r4 = " timed out. "
            r3.append(r4)
            java.lang.String r4 = "Connection will be retried using another IP address"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.debug(r3)
        L_0x0120:
            int r8 = r18 + 1
            r9 = r19
            goto L_0x003c
        L_0x0126:
            cz.msebera.android.httpclient.conn.ConnectTimeoutException r2 = new cz.msebera.android.httpclient.conn.ConnectTimeoutException
            r2.<init>(r0, r10, r15)
            throw r2
        L_0x012c:
            return
        L_0x012d:
            cz.msebera.android.httpclient.conn.UnsupportedSchemeException r0 = new cz.msebera.android.httpclient.conn.UnsupportedSchemeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r22.getSchemeName()
            r2.append(r3)
            java.lang.String r3 = " protocol is not supported"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.conn.HttpClientConnectionOperator.connect(cz.msebera.android.httpclient.conn.ManagedHttpClientConnection, cz.msebera.android.httpclient.HttpHost, java.net.InetSocketAddress, int, cz.msebera.android.httpclient.config.SocketConfig, cz.msebera.android.httpclient.protocol.HttpContext):void");
    }

    public void upgrade(ManagedHttpClientConnection managedHttpClientConnection, HttpHost httpHost, HttpContext httpContext) throws IOException {
        ConnectionSocketFactory lookup = getSocketFactoryRegistry(HttpClientContext.adapt(httpContext)).lookup(httpHost.getSchemeName());
        if (lookup == null) {
            throw new UnsupportedSchemeException(httpHost.getSchemeName() + " protocol is not supported");
        } else if (lookup instanceof LayeredConnectionSocketFactory) {
            managedHttpClientConnection.bind(((LayeredConnectionSocketFactory) lookup).createLayeredSocket(managedHttpClientConnection.getSocket(), httpHost.getHostName(), this.schemePortResolver.resolve(httpHost), httpContext));
        } else {
            throw new UnsupportedSchemeException(httpHost.getSchemeName() + " protocol does not support connection upgrade");
        }
    }
}
