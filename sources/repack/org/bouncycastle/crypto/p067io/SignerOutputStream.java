package repack.org.bouncycastle.crypto.p067io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import repack.org.bouncycastle.crypto.Signer;

/* renamed from: repack.org.bouncycastle.crypto.io.SignerOutputStream */
public class SignerOutputStream extends FilterOutputStream {
    protected Signer signer;

    public SignerOutputStream(OutputStream outputStream, Signer signer2) {
        super(outputStream);
        this.signer = signer2;
    }

    public void write(int i) throws IOException {
        this.signer.update((byte) i);
        this.out.write(i);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.signer.update(bArr, i, i2);
        this.out.write(bArr, i, i2);
    }

    public Signer getSigner() {
        return this.signer;
    }
}
