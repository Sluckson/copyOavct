package repack.org.bouncycastle.crypto.p067io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import repack.org.bouncycastle.crypto.Signer;

/* renamed from: repack.org.bouncycastle.crypto.io.SignerInputStream */
public class SignerInputStream extends FilterInputStream {
    protected Signer signer;

    public SignerInputStream(InputStream inputStream, Signer signer2) {
        super(inputStream);
        this.signer = signer2;
    }

    public int read() throws IOException {
        int read = this.in.read();
        if (read >= 0) {
            this.signer.update((byte) read);
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read > 0) {
            this.signer.update(bArr, i, read);
        }
        return read;
    }

    public Signer getSigner() {
        return this.signer;
    }
}
