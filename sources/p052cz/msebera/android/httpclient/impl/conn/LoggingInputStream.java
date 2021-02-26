package p052cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.io.InputStream;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.conn.LoggingInputStream */
class LoggingInputStream extends InputStream {

    /* renamed from: in */
    private final InputStream f4889in;
    private final Wire wire;

    public boolean markSupported() {
        return false;
    }

    public LoggingInputStream(InputStream inputStream, Wire wire2) {
        this.f4889in = inputStream;
        this.wire = wire2;
    }

    public int read() throws IOException {
        try {
            int read = this.f4889in.read();
            if (read == -1) {
                this.wire.input("end of stream");
            } else {
                this.wire.input(read);
            }
            return read;
        } catch (IOException e) {
            Wire wire2 = this.wire;
            wire2.input("[read] I/O error: " + e.getMessage());
            throw e;
        }
    }

    public int read(byte[] bArr) throws IOException {
        try {
            int read = this.f4889in.read(bArr);
            if (read == -1) {
                this.wire.input("end of stream");
            } else if (read > 0) {
                this.wire.input(bArr, 0, read);
            }
            return read;
        } catch (IOException e) {
            Wire wire2 = this.wire;
            wire2.input("[read] I/O error: " + e.getMessage());
            throw e;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int read = this.f4889in.read(bArr, i, i2);
            if (read == -1) {
                this.wire.input("end of stream");
            } else if (read > 0) {
                this.wire.input(bArr, i, read);
            }
            return read;
        } catch (IOException e) {
            Wire wire2 = this.wire;
            wire2.input("[read] I/O error: " + e.getMessage());
            throw e;
        }
    }

    public long skip(long j) throws IOException {
        try {
            return super.skip(j);
        } catch (IOException e) {
            Wire wire2 = this.wire;
            wire2.input("[skip] I/O error: " + e.getMessage());
            throw e;
        }
    }

    public int available() throws IOException {
        try {
            return this.f4889in.available();
        } catch (IOException e) {
            Wire wire2 = this.wire;
            wire2.input("[available] I/O error : " + e.getMessage());
            throw e;
        }
    }

    public void mark(int i) {
        super.mark(i);
    }

    public void reset() throws IOException {
        super.reset();
    }

    public void close() throws IOException {
        try {
            this.f4889in.close();
        } catch (IOException e) {
            Wire wire2 = this.wire;
            wire2.input("[close] I/O error: " + e.getMessage());
            throw e;
        }
    }
}
