package repack.org.bouncycastle.crypto.p067io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import repack.org.bouncycastle.crypto.Mac;

/* renamed from: repack.org.bouncycastle.crypto.io.MacInputStream */
public class MacInputStream extends FilterInputStream {
    protected Mac mac;

    public MacInputStream(InputStream inputStream, Mac mac2) {
        super(inputStream);
        this.mac = mac2;
    }

    public int read() throws IOException {
        int read = this.in.read();
        if (read >= 0) {
            this.mac.update((byte) read);
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read >= 0) {
            this.mac.update(bArr, i, read);
        }
        return read;
    }

    public Mac getMac() {
        return this.mac;
    }
}
