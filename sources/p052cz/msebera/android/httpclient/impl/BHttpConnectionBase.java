package p052cz.msebera.android.httpclient.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.concurrent.atomic.AtomicReference;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpConnection;
import p052cz.msebera.android.httpclient.HttpConnectionMetrics;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpInetConnection;
import p052cz.msebera.android.httpclient.HttpMessage;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.config.MessageConstraints;
import p052cz.msebera.android.httpclient.entity.BasicHttpEntity;
import p052cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import p052cz.msebera.android.httpclient.impl.entity.LaxContentLengthStrategy;
import p052cz.msebera.android.httpclient.impl.entity.StrictContentLengthStrategy;
import p052cz.msebera.android.httpclient.impl.p053io.ChunkedInputStream;
import p052cz.msebera.android.httpclient.impl.p053io.ChunkedOutputStream;
import p052cz.msebera.android.httpclient.impl.p053io.ContentLengthInputStream;
import p052cz.msebera.android.httpclient.impl.p053io.ContentLengthOutputStream;
import p052cz.msebera.android.httpclient.impl.p053io.HttpTransportMetricsImpl;
import p052cz.msebera.android.httpclient.impl.p053io.IdentityInputStream;
import p052cz.msebera.android.httpclient.impl.p053io.IdentityOutputStream;
import p052cz.msebera.android.httpclient.impl.p053io.SessionInputBufferImpl;
import p052cz.msebera.android.httpclient.impl.p053io.SessionOutputBufferImpl;
import p052cz.msebera.android.httpclient.p054io.SessionInputBuffer;
import p052cz.msebera.android.httpclient.p054io.SessionOutputBuffer;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.Asserts;
import p052cz.msebera.android.httpclient.util.NetUtils;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.BHttpConnectionBase */
public class BHttpConnectionBase implements HttpConnection, HttpInetConnection {
    private final HttpConnectionMetricsImpl connMetrics;
    private final SessionInputBufferImpl inbuffer;
    private final ContentLengthStrategy incomingContentStrategy;
    private final SessionOutputBufferImpl outbuffer;
    private final ContentLengthStrategy outgoingContentStrategy;
    private final AtomicReference<Socket> socketHolder;

    protected BHttpConnectionBase(int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2) {
        ContentLengthStrategy contentLengthStrategy3;
        ContentLengthStrategy contentLengthStrategy4;
        int i3 = i;
        Args.positive(i, "Buffer size");
        HttpTransportMetricsImpl httpTransportMetricsImpl = new HttpTransportMetricsImpl();
        HttpTransportMetricsImpl httpTransportMetricsImpl2 = new HttpTransportMetricsImpl();
        this.inbuffer = new SessionInputBufferImpl(httpTransportMetricsImpl, i, -1, messageConstraints != null ? messageConstraints : MessageConstraints.DEFAULT, charsetDecoder);
        int i4 = i2;
        CharsetEncoder charsetEncoder2 = charsetEncoder;
        this.outbuffer = new SessionOutputBufferImpl(httpTransportMetricsImpl2, i, i2, charsetEncoder);
        this.connMetrics = new HttpConnectionMetricsImpl(httpTransportMetricsImpl, httpTransportMetricsImpl2);
        if (contentLengthStrategy != null) {
            contentLengthStrategy3 = contentLengthStrategy;
        } else {
            contentLengthStrategy3 = LaxContentLengthStrategy.INSTANCE;
        }
        this.incomingContentStrategy = contentLengthStrategy3;
        if (contentLengthStrategy2 != null) {
            contentLengthStrategy4 = contentLengthStrategy2;
        } else {
            contentLengthStrategy4 = StrictContentLengthStrategy.INSTANCE;
        }
        this.outgoingContentStrategy = contentLengthStrategy4;
        this.socketHolder = new AtomicReference<>();
    }

    /* access modifiers changed from: protected */
    public void ensureOpen() throws IOException {
        Socket socket = this.socketHolder.get();
        Asserts.check(socket != null, "Connection is not open");
        if (!this.inbuffer.isBound()) {
            this.inbuffer.bind(getSocketInputStream(socket));
        }
        if (!this.outbuffer.isBound()) {
            this.outbuffer.bind(getSocketOutputStream(socket));
        }
    }

    /* access modifiers changed from: protected */
    public InputStream getSocketInputStream(Socket socket) throws IOException {
        return socket.getInputStream();
    }

    /* access modifiers changed from: protected */
    public OutputStream getSocketOutputStream(Socket socket) throws IOException {
        return socket.getOutputStream();
    }

    /* access modifiers changed from: protected */
    public void bind(Socket socket) throws IOException {
        Args.notNull(socket, "Socket");
        this.socketHolder.set(socket);
        this.inbuffer.bind((InputStream) null);
        this.outbuffer.bind((OutputStream) null);
    }

    /* access modifiers changed from: protected */
    public SessionInputBuffer getSessionInputBuffer() {
        return this.inbuffer;
    }

    /* access modifiers changed from: protected */
    public SessionOutputBuffer getSessionOutputBuffer() {
        return this.outbuffer;
    }

    /* access modifiers changed from: protected */
    public void doFlush() throws IOException {
        this.outbuffer.flush();
    }

    public boolean isOpen() {
        return this.socketHolder.get() != null;
    }

    /* access modifiers changed from: protected */
    public Socket getSocket() {
        return this.socketHolder.get();
    }

    /* access modifiers changed from: protected */
    public OutputStream createOutputStream(long j, SessionOutputBuffer sessionOutputBuffer) {
        if (j == -2) {
            return new ChunkedOutputStream(2048, sessionOutputBuffer);
        }
        if (j == -1) {
            return new IdentityOutputStream(sessionOutputBuffer);
        }
        return new ContentLengthOutputStream(sessionOutputBuffer, j);
    }

    /* access modifiers changed from: protected */
    public OutputStream prepareOutput(HttpMessage httpMessage) throws HttpException {
        return createOutputStream(this.outgoingContentStrategy.determineLength(httpMessage), this.outbuffer);
    }

    /* access modifiers changed from: protected */
    public InputStream createInputStream(long j, SessionInputBuffer sessionInputBuffer) {
        if (j == -2) {
            return new ChunkedInputStream(sessionInputBuffer);
        }
        if (j == -1) {
            return new IdentityInputStream(sessionInputBuffer);
        }
        return new ContentLengthInputStream(sessionInputBuffer, j);
    }

    /* access modifiers changed from: protected */
    public HttpEntity prepareInput(HttpMessage httpMessage) throws HttpException {
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        long determineLength = this.incomingContentStrategy.determineLength(httpMessage);
        InputStream createInputStream = createInputStream(determineLength, this.inbuffer);
        if (determineLength == -2) {
            basicHttpEntity.setChunked(true);
            basicHttpEntity.setContentLength(-1);
            basicHttpEntity.setContent(createInputStream);
        } else if (determineLength == -1) {
            basicHttpEntity.setChunked(false);
            basicHttpEntity.setContentLength(-1);
            basicHttpEntity.setContent(createInputStream);
        } else {
            basicHttpEntity.setChunked(false);
            basicHttpEntity.setContentLength(determineLength);
            basicHttpEntity.setContent(createInputStream);
        }
        Header firstHeader = httpMessage.getFirstHeader("Content-Type");
        if (firstHeader != null) {
            basicHttpEntity.setContentType(firstHeader);
        }
        Header firstHeader2 = httpMessage.getFirstHeader("Content-Encoding");
        if (firstHeader2 != null) {
            basicHttpEntity.setContentEncoding(firstHeader2);
        }
        return basicHttpEntity;
    }

    public InetAddress getLocalAddress() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            return socket.getLocalAddress();
        }
        return null;
    }

    public int getLocalPort() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            return socket.getLocalPort();
        }
        return -1;
    }

    public InetAddress getRemoteAddress() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            return socket.getInetAddress();
        }
        return null;
    }

    public int getRemotePort() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            return socket.getPort();
        }
        return -1;
    }

    public void setSocketTimeout(int i) {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            try {
                socket.setSoTimeout(i);
            } catch (SocketException unused) {
            }
        }
    }

    public int getSocketTimeout() {
        Socket socket = this.socketHolder.get();
        if (socket != null) {
            try {
                return socket.getSoTimeout();
            } catch (SocketException unused) {
            }
        }
        return -1;
    }

    public void shutdown() throws IOException {
        Socket andSet = this.socketHolder.getAndSet((Object) null);
        if (andSet != null) {
            andSet.close();
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0018 */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[ExcHandler: UnsupportedOperationException (unused java.lang.UnsupportedOperationException), SYNTHETIC, Splitter:B:6:0x0018] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() throws java.io.IOException {
        /*
            r2 = this;
            java.util.concurrent.atomic.AtomicReference<java.net.Socket> r0 = r2.socketHolder
            r1 = 0
            java.lang.Object r0 = r0.getAndSet(r1)
            java.net.Socket r0 = (java.net.Socket) r0
            if (r0 == 0) goto L_0x0024
            cz.msebera.android.httpclient.impl.io.SessionInputBufferImpl r1 = r2.inbuffer     // Catch:{ all -> 0x001f }
            r1.clear()     // Catch:{ all -> 0x001f }
            cz.msebera.android.httpclient.impl.io.SessionOutputBufferImpl r1 = r2.outbuffer     // Catch:{ all -> 0x001f }
            r1.flush()     // Catch:{ all -> 0x001f }
            r0.shutdownOutput()     // Catch:{ IOException -> 0x0018 }
        L_0x0018:
            r0.shutdownInput()     // Catch:{ UnsupportedOperationException -> 0x001b, UnsupportedOperationException -> 0x001b }
        L_0x001b:
            r0.close()
            goto L_0x0024
        L_0x001f:
            r1 = move-exception
            r0.close()
            throw r1
        L_0x0024:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.BHttpConnectionBase.close():void");
    }

    /* JADX INFO: finally extract failed */
    private int fillInputBuffer(int i) throws IOException {
        Socket socket = this.socketHolder.get();
        int soTimeout = socket.getSoTimeout();
        try {
            socket.setSoTimeout(i);
            int fillBuffer = this.inbuffer.fillBuffer();
            socket.setSoTimeout(soTimeout);
            return fillBuffer;
        } catch (Throwable th) {
            socket.setSoTimeout(soTimeout);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public boolean awaitInput(int i) throws IOException {
        if (this.inbuffer.hasBufferedData()) {
            return true;
        }
        fillInputBuffer(i);
        return this.inbuffer.hasBufferedData();
    }

    public boolean isStale() {
        if (!isOpen()) {
            return true;
        }
        try {
            if (fillInputBuffer(1) < 0) {
                return true;
            }
            return false;
        } catch (SocketTimeoutException unused) {
            return false;
        } catch (IOException unused2) {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void incrementRequestCount() {
        this.connMetrics.incrementRequestCount();
    }

    /* access modifiers changed from: protected */
    public void incrementResponseCount() {
        this.connMetrics.incrementResponseCount();
    }

    public HttpConnectionMetrics getMetrics() {
        return this.connMetrics;
    }

    public String toString() {
        Socket socket = this.socketHolder.get();
        if (socket == null) {
            return "[Not bound]";
        }
        StringBuilder sb = new StringBuilder();
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        SocketAddress localSocketAddress = socket.getLocalSocketAddress();
        if (!(remoteSocketAddress == null || localSocketAddress == null)) {
            NetUtils.formatAddress(sb, localSocketAddress);
            sb.append("<->");
            NetUtils.formatAddress(sb, remoteSocketAddress);
        }
        return sb.toString();
    }
}
