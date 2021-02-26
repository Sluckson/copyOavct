package repack.org.bouncycastle.crypto.p067io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import repack.org.bouncycastle.crypto.Digest;

/* renamed from: repack.org.bouncycastle.crypto.io.DigestOutputStream */
public class DigestOutputStream extends FilterOutputStream {
    protected Digest digest;

    public DigestOutputStream(OutputStream outputStream, Digest digest2) {
        super(outputStream);
        this.digest = digest2;
    }

    public void write(int i) throws IOException {
        this.digest.update((byte) i);
        this.out.write(i);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.digest.update(bArr, i, i2);
        this.out.write(bArr, i, i2);
    }

    public Digest getDigest() {
        return this.digest;
    }
}
