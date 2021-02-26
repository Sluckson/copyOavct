package p052cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.config.MessageConstraints;
import p052cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.p054io.HttpMessageParserFactory;
import p052cz.msebera.android.httpclient.p054io.HttpMessageWriterFactory;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.conn.LoggingManagedHttpClientConnection */
class LoggingManagedHttpClientConnection extends DefaultManagedHttpClientConnection {
    private final HttpClientAndroidLog headerlog;
    public HttpClientAndroidLog log;
    private final Wire wire;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoggingManagedHttpClientConnection(String str, HttpClientAndroidLog httpClientAndroidLog, HttpClientAndroidLog httpClientAndroidLog2, HttpClientAndroidLog httpClientAndroidLog3, int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageWriterFactory<HttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        super(str, i, i2, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy, contentLengthStrategy2, httpMessageWriterFactory, httpMessageParserFactory);
        this.log = httpClientAndroidLog;
        this.headerlog = httpClientAndroidLog2;
        this.wire = new Wire(httpClientAndroidLog3, str);
    }

    public void close() throws IOException {
        if (this.log.isDebugEnabled()) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.debug(getId() + ": Close connection");
        }
        super.close();
    }

    public void shutdown() throws IOException {
        if (this.log.isDebugEnabled()) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.debug(getId() + ": Shutdown connection");
        }
        super.shutdown();
    }

    /* access modifiers changed from: protected */
    public InputStream getSocketInputStream(Socket socket) throws IOException {
        InputStream socketInputStream = super.getSocketInputStream(socket);
        return this.wire.enabled() ? new LoggingInputStream(socketInputStream, this.wire) : socketInputStream;
    }

    /* access modifiers changed from: protected */
    public OutputStream getSocketOutputStream(Socket socket) throws IOException {
        OutputStream socketOutputStream = super.getSocketOutputStream(socket);
        return this.wire.enabled() ? new LoggingOutputStream(socketOutputStream, this.wire) : socketOutputStream;
    }

    /* access modifiers changed from: protected */
    public void onResponseReceived(HttpResponse httpResponse) {
        if (httpResponse != null && this.headerlog.isDebugEnabled()) {
            this.headerlog.debug(getId() + " << " + httpResponse.getStatusLine().toString());
            for (Header header : httpResponse.getAllHeaders()) {
                this.headerlog.debug(getId() + " << " + header.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRequestSubmitted(HttpRequest httpRequest) {
        if (httpRequest != null && this.headerlog.isDebugEnabled()) {
            this.headerlog.debug(getId() + " >> " + httpRequest.getRequestLine().toString());
            for (Header header : httpRequest.getAllHeaders()) {
                this.headerlog.debug(getId() + " >> " + header.toString());
            }
        }
    }
}
