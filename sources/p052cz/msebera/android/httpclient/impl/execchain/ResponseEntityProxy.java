package p052cz.msebera.android.httpclient.impl.execchain;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.conn.EofSensorInputStream;
import p052cz.msebera.android.httpclient.conn.EofSensorWatcher;
import p052cz.msebera.android.httpclient.entity.HttpEntityWrapper;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.execchain.ResponseEntityProxy */
class ResponseEntityProxy extends HttpEntityWrapper implements EofSensorWatcher {
    private final ConnectionHolder connHolder;

    public boolean isRepeatable() {
        return false;
    }

    public static void enchance(HttpResponse httpResponse, ConnectionHolder connectionHolder) {
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null && entity.isStreaming() && connectionHolder != null) {
            httpResponse.setEntity(new ResponseEntityProxy(entity, connectionHolder));
        }
    }

    ResponseEntityProxy(HttpEntity httpEntity, ConnectionHolder connectionHolder) {
        super(httpEntity);
        this.connHolder = connectionHolder;
    }

    private void cleanup() {
        ConnectionHolder connectionHolder = this.connHolder;
        if (connectionHolder != null) {
            connectionHolder.abortConnection();
        }
    }

    public void releaseConnection() throws IOException {
        ConnectionHolder connectionHolder = this.connHolder;
        if (connectionHolder != null) {
            try {
                if (connectionHolder.isReusable()) {
                    this.connHolder.releaseConnection();
                }
            } finally {
                cleanup();
            }
        }
    }

    public InputStream getContent() throws IOException {
        return new EofSensorInputStream(this.wrappedEntity.getContent(), this);
    }

    @Deprecated
    public void consumeContent() throws IOException {
        releaseConnection();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        try {
            this.wrappedEntity.writeTo(outputStream);
            releaseConnection();
        } finally {
            cleanup();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean eofDetected(InputStream inputStream) throws IOException {
        try {
            inputStream.close();
            releaseConnection();
            cleanup();
            return false;
        } catch (Throwable th) {
            cleanup();
            throw th;
        }
    }

    public boolean streamClosed(InputStream inputStream) throws IOException {
        boolean z;
        try {
            z = this.connHolder != null && !this.connHolder.isReleased();
            inputStream.close();
            releaseConnection();
        } catch (SocketException e) {
            if (z) {
                throw e;
            }
        } catch (Throwable th) {
            cleanup();
            throw th;
        }
        cleanup();
        return false;
    }

    public boolean streamAbort(InputStream inputStream) throws IOException {
        cleanup();
        return false;
    }

    public String toString() {
        return "ResponseEntityProxy{" + this.wrappedEntity + '}';
    }
}
