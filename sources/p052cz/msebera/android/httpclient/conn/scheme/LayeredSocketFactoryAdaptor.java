package p052cz.msebera.android.httpclient.conn.scheme;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.scheme.LayeredSocketFactoryAdaptor */
class LayeredSocketFactoryAdaptor extends SocketFactoryAdaptor implements LayeredSocketFactory {
    private final LayeredSchemeSocketFactory factory;

    LayeredSocketFactoryAdaptor(LayeredSchemeSocketFactory layeredSchemeSocketFactory) {
        super(layeredSchemeSocketFactory);
        this.factory = layeredSchemeSocketFactory;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        return this.factory.createLayeredSocket(socket, str, i, z);
    }
}
