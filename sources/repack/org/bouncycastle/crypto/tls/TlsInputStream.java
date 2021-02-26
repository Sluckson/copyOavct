package repack.org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;

class TlsInputStream extends InputStream {
    private byte[] buf = new byte[1];
    private TlsProtocolHandler handler = null;

    TlsInputStream(TlsProtocolHandler tlsProtocolHandler) {
        this.handler = tlsProtocolHandler;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.handler.readApplicationData(bArr, i, i2);
    }

    public int read() throws IOException {
        if (read(this.buf) < 0) {
            return -1;
        }
        return this.buf[0] & 255;
    }

    public void close() throws IOException {
        this.handler.close();
    }
}
