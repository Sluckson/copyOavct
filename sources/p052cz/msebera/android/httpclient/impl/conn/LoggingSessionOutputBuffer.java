package p052cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import p052cz.msebera.android.httpclient.Consts;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.p054io.HttpTransportMetrics;
import p052cz.msebera.android.httpclient.p054io.SessionOutputBuffer;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;

@Immutable
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.LoggingSessionOutputBuffer */
public class LoggingSessionOutputBuffer implements SessionOutputBuffer {
    private final String charset;
    private final SessionOutputBuffer out;
    private final Wire wire;

    public LoggingSessionOutputBuffer(SessionOutputBuffer sessionOutputBuffer, Wire wire2, String str) {
        this.out = sessionOutputBuffer;
        this.wire = wire2;
        this.charset = str == null ? Consts.ASCII.name() : str;
    }

    public LoggingSessionOutputBuffer(SessionOutputBuffer sessionOutputBuffer, Wire wire2) {
        this(sessionOutputBuffer, wire2, (String) null);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        if (this.wire.enabled()) {
            this.wire.output(bArr, i, i2);
        }
    }

    public void write(int i) throws IOException {
        this.out.write(i);
        if (this.wire.enabled()) {
            this.wire.output(i);
        }
    }

    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
        if (this.wire.enabled()) {
            this.wire.output(bArr);
        }
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void writeLine(CharArrayBuffer charArrayBuffer) throws IOException {
        this.out.writeLine(charArrayBuffer);
        if (this.wire.enabled()) {
            String str = new String(charArrayBuffer.buffer(), 0, charArrayBuffer.length());
            this.wire.output((str + "\r\n").getBytes(this.charset));
        }
    }

    public void writeLine(String str) throws IOException {
        this.out.writeLine(str);
        if (this.wire.enabled()) {
            this.wire.output((str + "\r\n").getBytes(this.charset));
        }
    }

    public HttpTransportMetrics getMetrics() {
        return this.out.getMetrics();
    }
}
