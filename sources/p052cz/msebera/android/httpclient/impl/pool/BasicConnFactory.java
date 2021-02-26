package p052cz.msebera.android.httpclient.impl.pool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import p052cz.msebera.android.httpclient.HttpClientConnection;
import p052cz.msebera.android.httpclient.HttpConnectionFactory;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.config.ConnectionConfig;
import p052cz.msebera.android.httpclient.config.SocketConfig;
import p052cz.msebera.android.httpclient.impl.DefaultBHttpClientConnection;
import p052cz.msebera.android.httpclient.impl.DefaultBHttpClientConnectionFactory;
import p052cz.msebera.android.httpclient.params.CoreConnectionPNames;
import p052cz.msebera.android.httpclient.params.HttpParamConfig;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.pool.ConnFactory;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.pool.BasicConnFactory */
public class BasicConnFactory implements ConnFactory<HttpHost, HttpClientConnection> {
    private final HttpConnectionFactory<? extends HttpClientConnection> connFactory;
    private final int connectTimeout;
    private final SocketFactory plainfactory;
    private final SocketConfig sconfig;
    private final SSLSocketFactory sslfactory;

    @Deprecated
    public BasicConnFactory(SSLSocketFactory sSLSocketFactory, HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP params");
        this.plainfactory = null;
        this.sslfactory = sSLSocketFactory;
        this.connectTimeout = httpParams.getIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 0);
        this.sconfig = HttpParamConfig.getSocketConfig(httpParams);
        this.connFactory = new DefaultBHttpClientConnectionFactory(HttpParamConfig.getConnectionConfig(httpParams));
    }

    @Deprecated
    public BasicConnFactory(HttpParams httpParams) {
        this((SSLSocketFactory) null, httpParams);
    }

    public BasicConnFactory(SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, int i, SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        this.plainfactory = socketFactory;
        this.sslfactory = sSLSocketFactory;
        this.connectTimeout = i;
        this.sconfig = socketConfig == null ? SocketConfig.DEFAULT : socketConfig;
        this.connFactory = new DefaultBHttpClientConnectionFactory(connectionConfig == null ? ConnectionConfig.DEFAULT : connectionConfig);
    }

    public BasicConnFactory(int i, SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        this((SocketFactory) null, (SSLSocketFactory) null, i, socketConfig, connectionConfig);
    }

    public BasicConnFactory(SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        this((SocketFactory) null, (SSLSocketFactory) null, 0, socketConfig, connectionConfig);
    }

    public BasicConnFactory() {
        this((SocketFactory) null, (SSLSocketFactory) null, 0, SocketConfig.DEFAULT, ConnectionConfig.DEFAULT);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public HttpClientConnection create(Socket socket, HttpParams httpParams) throws IOException {
        DefaultBHttpClientConnection defaultBHttpClientConnection = new DefaultBHttpClientConnection(httpParams.getIntParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, 8192));
        defaultBHttpClientConnection.bind(socket);
        return defaultBHttpClientConnection;
    }

    public HttpClientConnection create(HttpHost httpHost) throws IOException {
        Socket socket;
        String schemeName = httpHost.getSchemeName();
        if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(schemeName)) {
            SocketFactory socketFactory = this.plainfactory;
            socket = socketFactory != null ? socketFactory.createSocket() : new Socket();
        } else {
            socket = null;
        }
        if ("https".equalsIgnoreCase(schemeName)) {
            SocketFactory socketFactory2 = this.sslfactory;
            if (socketFactory2 == null) {
                socketFactory2 = SSLSocketFactory.getDefault();
            }
            socket = socketFactory2.createSocket();
        }
        if (socket != null) {
            String hostName = httpHost.getHostName();
            int port = httpHost.getPort();
            if (port == -1) {
                if (httpHost.getSchemeName().equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME)) {
                    port = 80;
                } else if (httpHost.getSchemeName().equalsIgnoreCase("https")) {
                    port = 443;
                }
            }
            socket.setSoTimeout(this.sconfig.getSoTimeout());
            socket.setTcpNoDelay(this.sconfig.isTcpNoDelay());
            int soLinger = this.sconfig.getSoLinger();
            if (soLinger >= 0) {
                socket.setSoLinger(soLinger > 0, soLinger);
            }
            socket.setKeepAlive(this.sconfig.isSoKeepAlive());
            socket.connect(new InetSocketAddress(hostName, port), this.connectTimeout);
            return (HttpClientConnection) this.connFactory.createConnection(socket);
        }
        throw new IOException(schemeName + " scheme is not supported");
    }
}
