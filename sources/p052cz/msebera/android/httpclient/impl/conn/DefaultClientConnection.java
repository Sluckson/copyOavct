package p052cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpResponseFactory;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import p052cz.msebera.android.httpclient.conn.OperatedClientConnection;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.impl.SocketHttpClientConnection;
import p052cz.msebera.android.httpclient.message.LineParser;
import p052cz.msebera.android.httpclient.p054io.HttpMessageParser;
import p052cz.msebera.android.httpclient.p054io.SessionInputBuffer;
import p052cz.msebera.android.httpclient.p054io.SessionOutputBuffer;
import p052cz.msebera.android.httpclient.params.BasicHttpParams;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.params.HttpProtocolParams;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.DefaultClientConnection */
public class DefaultClientConnection extends SocketHttpClientConnection implements OperatedClientConnection, ManagedHttpClientConnection, HttpContext {
    private final Map<String, Object> attributes = new HashMap();
    private boolean connSecure;
    public HttpClientAndroidLog headerLog = new HttpClientAndroidLog("cz.msebera.android.httpclient.headers");
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private volatile boolean shutdown;
    private volatile Socket socket;
    private HttpHost targetHost;
    public HttpClientAndroidLog wireLog = new HttpClientAndroidLog("cz.msebera.android.httpclient.wire");

    public String getId() {
        return null;
    }

    public final HttpHost getTargetHost() {
        return this.targetHost;
    }

    public final boolean isSecure() {
        return this.connSecure;
    }

    public final Socket getSocket() {
        return this.socket;
    }

    public SSLSession getSSLSession() {
        if (this.socket instanceof SSLSocket) {
            return ((SSLSocket) this.socket).getSession();
        }
        return null;
    }

    public void opening(Socket socket2, HttpHost httpHost) throws IOException {
        assertNotOpen();
        this.socket = socket2;
        this.targetHost = httpHost;
        if (this.shutdown) {
            socket2.close();
            throw new InterruptedIOException("Connection already shutdown");
        }
    }

    public void openCompleted(boolean z, HttpParams httpParams) throws IOException {
        Args.notNull(httpParams, "Parameters");
        assertNotOpen();
        this.connSecure = z;
        bind(this.socket, httpParams);
    }

    public void shutdown() throws IOException {
        this.shutdown = true;
        try {
            super.shutdown();
            if (this.log.isDebugEnabled()) {
                HttpClientAndroidLog httpClientAndroidLog = this.log;
                httpClientAndroidLog.debug("Connection " + this + " shut down");
            }
            Socket socket2 = this.socket;
            if (socket2 != null) {
                socket2.close();
            }
        } catch (IOException e) {
            this.log.debug("I/O error shutting down connection", e);
        }
    }

    public void close() throws IOException {
        try {
            super.close();
            if (this.log.isDebugEnabled()) {
                HttpClientAndroidLog httpClientAndroidLog = this.log;
                httpClientAndroidLog.debug("Connection " + this + " closed");
            }
        } catch (IOException e) {
            this.log.debug("I/O error closing connection", e);
        }
    }

    /* access modifiers changed from: protected */
    public SessionInputBuffer createSessionInputBuffer(Socket socket2, int i, HttpParams httpParams) throws IOException {
        if (i <= 0) {
            i = 8192;
        }
        SessionInputBuffer createSessionInputBuffer = super.createSessionInputBuffer(socket2, i, httpParams);
        return this.wireLog.isDebugEnabled() ? new LoggingSessionInputBuffer(createSessionInputBuffer, new Wire(this.wireLog), HttpProtocolParams.getHttpElementCharset(httpParams)) : createSessionInputBuffer;
    }

    /* access modifiers changed from: protected */
    public SessionOutputBuffer createSessionOutputBuffer(Socket socket2, int i, HttpParams httpParams) throws IOException {
        if (i <= 0) {
            i = 8192;
        }
        SessionOutputBuffer createSessionOutputBuffer = super.createSessionOutputBuffer(socket2, i, httpParams);
        return this.wireLog.isDebugEnabled() ? new LoggingSessionOutputBuffer(createSessionOutputBuffer, new Wire(this.wireLog), HttpProtocolParams.getHttpElementCharset(httpParams)) : createSessionOutputBuffer;
    }

    /* access modifiers changed from: protected */
    public HttpMessageParser<HttpResponse> createResponseParser(SessionInputBuffer sessionInputBuffer, HttpResponseFactory httpResponseFactory, HttpParams httpParams) {
        return new DefaultHttpResponseParser(sessionInputBuffer, (LineParser) null, httpResponseFactory, httpParams);
    }

    public void bind(Socket socket2) throws IOException {
        bind(socket2, new BasicHttpParams());
    }

    public void update(Socket socket2, HttpHost httpHost, boolean z, HttpParams httpParams) throws IOException {
        assertOpen();
        Args.notNull(httpHost, "Target host");
        Args.notNull(httpParams, "Parameters");
        if (socket2 != null) {
            this.socket = socket2;
            bind(socket2, httpParams);
        }
        this.targetHost = httpHost;
        this.connSecure = z;
    }

    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        HttpResponse receiveResponseHeader = super.receiveResponseHeader();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Receiving response: " + receiveResponseHeader.getStatusLine());
        }
        if (this.headerLog.isDebugEnabled()) {
            this.headerLog.debug("<< " + receiveResponseHeader.getStatusLine().toString());
            for (Header header : receiveResponseHeader.getAllHeaders()) {
                this.headerLog.debug("<< " + header.toString());
            }
        }
        return receiveResponseHeader;
    }

    public void sendRequestHeader(HttpRequest httpRequest) throws HttpException, IOException {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Sending request: " + httpRequest.getRequestLine());
        }
        super.sendRequestHeader(httpRequest);
        if (this.headerLog.isDebugEnabled()) {
            this.headerLog.debug(">> " + httpRequest.getRequestLine().toString());
            for (Header header : httpRequest.getAllHeaders()) {
                this.headerLog.debug(">> " + header.toString());
            }
        }
    }

    public Object getAttribute(String str) {
        return this.attributes.get(str);
    }

    public Object removeAttribute(String str) {
        return this.attributes.remove(str);
    }

    public void setAttribute(String str, Object obj) {
        this.attributes.put(str, obj);
    }
}
