package repack.org.bouncycastle.jcajce.p068io;

import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Mac;

/* renamed from: repack.org.bouncycastle.jcajce.io.MacOutputStream */
public class MacOutputStream extends OutputStream {
    protected Mac mac;

    public MacOutputStream(Mac mac2) {
        this.mac = mac2;
    }

    public void write(int i) throws IOException {
        this.mac.update((byte) i);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.mac.update(bArr, i, i2);
    }

    public byte[] getMac() {
        return this.mac.doFinal();
    }
}
