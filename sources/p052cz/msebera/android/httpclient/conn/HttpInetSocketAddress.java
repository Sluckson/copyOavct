package p052cz.msebera.android.httpclient.conn;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.util.Args;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.HttpInetSocketAddress */
public class HttpInetSocketAddress extends InetSocketAddress {
    private static final long serialVersionUID = -6650701828361907957L;
    private final HttpHost httphost;

    public HttpInetSocketAddress(HttpHost httpHost, InetAddress inetAddress, int i) {
        super(inetAddress, i);
        Args.notNull(httpHost, "HTTP host");
        this.httphost = httpHost;
    }

    public HttpHost getHttpHost() {
        return this.httphost;
    }

    public String toString() {
        return this.httphost.getHostName() + ":" + getPort();
    }
}
