package p052cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSession;
import p052cz.msebera.android.httpclient.HttpClientConnection;
import p052cz.msebera.android.httpclient.HttpConnectionMetrics;
import p052cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.conn.CPoolProxy */
class CPoolProxy implements ManagedHttpClientConnection, HttpContext {
    private volatile CPoolEntry poolEntry;

    CPoolProxy(CPoolEntry cPoolEntry) {
        this.poolEntry = cPoolEntry;
    }

    /* access modifiers changed from: package-private */
    public CPoolEntry getPoolEntry() {
        return this.poolEntry;
    }

    /* access modifiers changed from: package-private */
    public CPoolEntry detach() {
        CPoolEntry cPoolEntry = this.poolEntry;
        this.poolEntry = null;
        return cPoolEntry;
    }

    /* access modifiers changed from: package-private */
    public ManagedHttpClientConnection getConnection() {
        CPoolEntry cPoolEntry = this.poolEntry;
        if (cPoolEntry == null) {
            return null;
        }
        return (ManagedHttpClientConnection) cPoolEntry.getConnection();
    }

    /* access modifiers changed from: package-private */
    public ManagedHttpClientConnection getValidConnection() {
        ManagedHttpClientConnection connection = getConnection();
        if (connection != null) {
            return connection;
        }
        throw new ConnectionShutdownException();
    }

    public void close() throws IOException {
        CPoolEntry cPoolEntry = this.poolEntry;
        if (cPoolEntry != null) {
            cPoolEntry.closeConnection();
        }
    }

    public void shutdown() throws IOException {
        CPoolEntry cPoolEntry = this.poolEntry;
        if (cPoolEntry != null) {
            cPoolEntry.shutdownConnection();
        }
    }

    public boolean isOpen() {
        CPoolEntry cPoolEntry = this.poolEntry;
        if (cPoolEntry != null) {
            return !cPoolEntry.isClosed();
        }
        return false;
    }

    public boolean isStale() {
        ManagedHttpClientConnection connection = getConnection();
        if (connection != null) {
            return connection.isStale();
        }
        return true;
    }

    public void setSocketTimeout(int i) {
        getValidConnection().setSocketTimeout(i);
    }

    public int getSocketTimeout() {
        return getValidConnection().getSocketTimeout();
    }

    public String getId() {
        return getValidConnection().getId();
    }

    public void bind(Socket socket) throws IOException {
        getValidConnection().bind(socket);
    }

    public Socket getSocket() {
        return getValidConnection().getSocket();
    }

    public SSLSession getSSLSession() {
        return getValidConnection().getSSLSession();
    }

    public boolean isResponseAvailable(int i) throws IOException {
        return getValidConnection().isResponseAvailable(i);
    }

    public void sendRequestHeader(HttpRequest httpRequest) throws HttpException, IOException {
        getValidConnection().sendRequestHeader(httpRequest);
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException {
        getValidConnection().sendRequestEntity(httpEntityEnclosingRequest);
    }

    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        return getValidConnection().receiveResponseHeader();
    }

    public void receiveResponseEntity(HttpResponse httpResponse) throws HttpException, IOException {
        getValidConnection().receiveResponseEntity(httpResponse);
    }

    public void flush() throws IOException {
        getValidConnection().flush();
    }

    public HttpConnectionMetrics getMetrics() {
        return getValidConnection().getMetrics();
    }

    public InetAddress getLocalAddress() {
        return getValidConnection().getLocalAddress();
    }

    public int getLocalPort() {
        return getValidConnection().getLocalPort();
    }

    public InetAddress getRemoteAddress() {
        return getValidConnection().getRemoteAddress();
    }

    public int getRemotePort() {
        return getValidConnection().getRemotePort();
    }

    public Object getAttribute(String str) {
        ManagedHttpClientConnection validConnection = getValidConnection();
        if (validConnection instanceof HttpContext) {
            return ((HttpContext) validConnection).getAttribute(str);
        }
        return null;
    }

    public void setAttribute(String str, Object obj) {
        ManagedHttpClientConnection validConnection = getValidConnection();
        if (validConnection instanceof HttpContext) {
            ((HttpContext) validConnection).setAttribute(str, obj);
        }
    }

    public Object removeAttribute(String str) {
        ManagedHttpClientConnection validConnection = getValidConnection();
        if (validConnection instanceof HttpContext) {
            return ((HttpContext) validConnection).removeAttribute(str);
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CPoolProxy{");
        ManagedHttpClientConnection connection = getConnection();
        if (connection != null) {
            sb.append(connection);
        } else {
            sb.append("detached");
        }
        sb.append('}');
        return sb.toString();
    }

    public static HttpClientConnection newProxy(CPoolEntry cPoolEntry) {
        return new CPoolProxy(cPoolEntry);
    }

    private static CPoolProxy getProxy(HttpClientConnection httpClientConnection) {
        if (CPoolProxy.class.isInstance(httpClientConnection)) {
            return CPoolProxy.class.cast(httpClientConnection);
        }
        throw new IllegalStateException("Unexpected connection proxy class: " + httpClientConnection.getClass());
    }

    public static CPoolEntry getPoolEntry(HttpClientConnection httpClientConnection) {
        CPoolEntry poolEntry2 = getProxy(httpClientConnection).getPoolEntry();
        if (poolEntry2 != null) {
            return poolEntry2;
        }
        throw new ConnectionShutdownException();
    }

    public static CPoolEntry detach(HttpClientConnection httpClientConnection) {
        return getProxy(httpClientConnection).detach();
    }
}
