package p052cz.msebera.android.httpclient.impl;

import java.io.IOException;
import java.net.Socket;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.params.CoreConnectionPNames;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.DefaultHttpClientConnection */
public class DefaultHttpClientConnection extends SocketHttpClientConnection {
    public void bind(Socket socket, HttpParams httpParams) throws IOException {
        Args.notNull(socket, "Socket");
        Args.notNull(httpParams, "HTTP parameters");
        assertNotOpen();
        boolean z = true;
        socket.setTcpNoDelay(httpParams.getBooleanParameter(CoreConnectionPNames.TCP_NODELAY, true));
        socket.setSoTimeout(httpParams.getIntParameter(CoreConnectionPNames.SO_TIMEOUT, 0));
        socket.setKeepAlive(httpParams.getBooleanParameter(CoreConnectionPNames.SO_KEEPALIVE, false));
        int intParameter = httpParams.getIntParameter(CoreConnectionPNames.SO_LINGER, -1);
        if (intParameter >= 0) {
            if (intParameter <= 0) {
                z = false;
            }
            socket.setSoLinger(z, intParameter);
        }
        super.bind(socket, httpParams);
    }
}
