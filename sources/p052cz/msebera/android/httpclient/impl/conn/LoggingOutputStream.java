package p052cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.io.OutputStream;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.conn.LoggingOutputStream */
class LoggingOutputStream extends OutputStream {
    private final OutputStream out;
    private final Wire wire;

    public LoggingOutputStream(OutputStream outputStream, Wire wire2) {
        this.out = outputStream;
        this.wire = wire2;
    }

    public void write(int i) throws IOException {
        try {
            this.wire.output(i);
        } catch (IOException e) {
            Wire wire2 = this.wire;
            wire2.output("[write] I/O error: " + e.getMessage());
            throw e;
        }
    }

    public void write(byte[] bArr) throws IOException {
        try {
            this.wire.output(bArr);
            this.out.write(bArr);
        } catch (IOException e) {
            Wire wire2 = this.wire;
            wire2.output("[write] I/O error: " + e.getMessage());
            throw e;
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.wire.output(bArr, i, i2);
            this.out.write(bArr, i, i2);
        } catch (IOException e) {
            Wire wire2 = this.wire;
            wire2.output("[write] I/O error: " + e.getMessage());
            throw e;
        }
    }

    public void flush() throws IOException {
        try {
            this.out.flush();
        } catch (IOException e) {
            Wire wire2 = this.wire;
            wire2.output("[flush] I/O error: " + e.getMessage());
            throw e;
        }
    }

    public void close() throws IOException {
        try {
            this.out.close();
        } catch (IOException e) {
            Wire wire2 = this.wire;
            wire2.output("[close] I/O error: " + e.getMessage());
            throw e;
        }
    }
}
