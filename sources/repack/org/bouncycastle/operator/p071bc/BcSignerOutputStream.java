package repack.org.bouncycastle.operator.p071bc;

import java.io.IOException;
import java.io.OutputStream;
import repack.org.bouncycastle.crypto.CryptoException;
import repack.org.bouncycastle.crypto.Signer;

/* renamed from: repack.org.bouncycastle.operator.bc.BcSignerOutputStream */
public class BcSignerOutputStream extends OutputStream {
    private Signer sig;

    BcSignerOutputStream(Signer signer) {
        this.sig = signer;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.sig.update(bArr, i, i2);
    }

    public void write(byte[] bArr) throws IOException {
        this.sig.update(bArr, 0, bArr.length);
    }

    public void write(int i) throws IOException {
        this.sig.update((byte) i);
    }

    /* access modifiers changed from: package-private */
    public byte[] getSignature() throws CryptoException {
        return this.sig.generateSignature();
    }

    /* access modifiers changed from: package-private */
    public boolean verify(byte[] bArr) {
        return this.sig.verifySignature(bArr);
    }
}
