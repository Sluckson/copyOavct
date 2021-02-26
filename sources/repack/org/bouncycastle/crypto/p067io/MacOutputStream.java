package repack.org.bouncycastle.crypto.p067io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import repack.org.bouncycastle.crypto.Mac;

/* renamed from: repack.org.bouncycastle.crypto.io.MacOutputStream */
public class MacOutputStream extends FilterOutputStream {
    protected Mac mac;

    public MacOutputStream(OutputStream outputStream, Mac mac2) {
        super(outputStream);
        this.mac = mac2;
    }

    public void write(int i) throws IOException {
        this.mac.update((byte) i);
        this.out.write(i);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.mac.update(bArr, i, i2);
        this.out.write(bArr, i, i2);
    }

    public Mac getMac() {
        return this.mac;
    }
}
