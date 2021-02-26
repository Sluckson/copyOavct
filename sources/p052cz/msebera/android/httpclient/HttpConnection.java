package p052cz.msebera.android.httpclient;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: cz.msebera.android.httpclient.HttpConnection */
public interface HttpConnection extends Closeable {
    void close() throws IOException;

    HttpConnectionMetrics getMetrics();

    int getSocketTimeout();

    boolean isOpen();

    boolean isStale();

    void setSocketTimeout(int i);

    void shutdown() throws IOException;
}
