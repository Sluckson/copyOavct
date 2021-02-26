package repack.org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;

class TlsOutputStream extends OutputStream {
    private byte[] buf = new byte[1];
    private TlsProtocolHandler handler;

    TlsOutputStream(TlsProtocolHandler tlsProtocolHandler) {
        this.handler = tlsProtocolHandler;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.handler.writeData(bArr, i, i2);
    }

    public void write(int i) throws IOException {
        byte[] bArr = this.buf;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    public void close() throws IOException {
        this.handler.close();
    }

    public void flush() throws IOException {
        this.handler.flush();
    }
}
