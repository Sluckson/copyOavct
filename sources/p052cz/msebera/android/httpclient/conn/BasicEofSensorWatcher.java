package p052cz.msebera.android.httpclient.conn;

import java.io.IOException;
import java.io.InputStream;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.BasicEofSensorWatcher */
public class BasicEofSensorWatcher implements EofSensorWatcher {
    protected final boolean attemptReuse;
    protected final ManagedClientConnection managedConn;

    public BasicEofSensorWatcher(ManagedClientConnection managedClientConnection, boolean z) {
        Args.notNull(managedClientConnection, "Connection");
        this.managedConn = managedClientConnection;
        this.attemptReuse = z;
    }

    /* JADX INFO: finally extract failed */
    public boolean eofDetected(InputStream inputStream) throws IOException {
        try {
            if (this.attemptReuse) {
                inputStream.close();
                this.managedConn.markReusable();
            }
            this.managedConn.releaseConnection();
            return false;
        } catch (Throwable th) {
            this.managedConn.releaseConnection();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean streamClosed(InputStream inputStream) throws IOException {
        try {
            if (this.attemptReuse) {
                inputStream.close();
                this.managedConn.markReusable();
            }
            this.managedConn.releaseConnection();
            return false;
        } catch (Throwable th) {
            this.managedConn.releaseConnection();
            throw th;
        }
    }

    public boolean streamAbort(InputStream inputStream) throws IOException {
        this.managedConn.abortConnection();
        return false;
    }
}
