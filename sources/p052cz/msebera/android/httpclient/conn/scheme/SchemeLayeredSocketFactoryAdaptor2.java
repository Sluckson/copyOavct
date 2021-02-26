package p052cz.msebera.android.httpclient.conn.scheme;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import p052cz.msebera.android.httpclient.conn.ConnectTimeoutException;
import p052cz.msebera.android.httpclient.params.HttpParams;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.scheme.SchemeLayeredSocketFactoryAdaptor2 */
class SchemeLayeredSocketFactoryAdaptor2 implements SchemeLayeredSocketFactory {
    private final LayeredSchemeSocketFactory factory;

    SchemeLayeredSocketFactoryAdaptor2(LayeredSchemeSocketFactory layeredSchemeSocketFactory) {
        this.factory = layeredSchemeSocketFactory;
    }

    public Socket createSocket(HttpParams httpParams) throws IOException {
        return this.factory.createSocket(httpParams);
    }

    public Socket connectSocket(Socket socket, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, HttpParams httpParams) throws IOException, UnknownHostException, ConnectTimeoutException {
        return this.factory.connectSocket(socket, inetSocketAddress, inetSocketAddress2, httpParams);
    }

    public boolean isSecure(Socket socket) throws IllegalArgumentException {
        return this.factory.isSecure(socket);
    }

    public Socket createLayeredSocket(Socket socket, String str, int i, HttpParams httpParams) throws IOException, UnknownHostException {
        return this.factory.createLayeredSocket(socket, str, i, true);
    }
}
