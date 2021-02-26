package p052cz.msebera.android.httpclient.conn;

import p052cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
/* renamed from: cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException */
public class ConnectionPoolTimeoutException extends ConnectTimeoutException {
    private static final long serialVersionUID = -7898874842020245128L;

    public ConnectionPoolTimeoutException() {
    }

    public ConnectionPoolTimeoutException(String str) {
        super(str);
    }
}
