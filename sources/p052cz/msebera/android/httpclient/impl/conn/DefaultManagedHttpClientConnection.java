package p052cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.config.MessageConstraints;
import p052cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import p052cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import p052cz.msebera.android.httpclient.impl.DefaultBHttpClientConnection;
import p052cz.msebera.android.httpclient.p054io.HttpMessageParserFactory;
import p052cz.msebera.android.httpclient.p054io.HttpMessageWriterFactory;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.conn.DefaultManagedHttpClientConnection */
public class DefaultManagedHttpClientConnection extends DefaultBHttpClientConnection implements ManagedHttpClientConnection, HttpContext {
    private final Map<String, Object> attributes;

    /* renamed from: id */
    private final String f4888id;
    private volatile boolean shutdown;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultManagedHttpClientConnection(String str, int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageWriterFactory<HttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        super(i, i2, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy, contentLengthStrategy2, httpMessageWriterFactory, httpMessageParserFactory);
        this.f4888id = str;
        this.attributes = new ConcurrentHashMap();
    }

    public DefaultManagedHttpClientConnection(String str, int i) {
        this(str, i, i, (CharsetDecoder) null, (CharsetEncoder) null, (MessageConstraints) null, (ContentLengthStrategy) null, (ContentLengthStrategy) null, (HttpMessageWriterFactory<HttpRequest>) null, (HttpMessageParserFactory<HttpResponse>) null);
    }

    public String getId() {
        return this.f4888id;
    }

    public void shutdown() throws IOException {
        this.shutdown = true;
        super.shutdown();
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

    public void bind(Socket socket) throws IOException {
        if (!this.shutdown) {
            super.bind(socket);
        } else {
            socket.close();
            throw new InterruptedIOException("Connection already shutdown");
        }
    }

    public Socket getSocket() {
        return super.getSocket();
    }

    public SSLSession getSSLSession() {
        Socket socket = super.getSocket();
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).getSession();
        }
        return null;
    }
}
