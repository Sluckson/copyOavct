package repack.org.bouncycastle.cms;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Signature;
import java.security.SignatureException;

class SigOutputStream extends OutputStream {
    private final Signature sig;

    SigOutputStream(Signature signature) {
        this.sig = signature;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.sig.update(bArr, i, i2);
        } catch (SignatureException e) {
            throw new CMSStreamException("signature problem: " + e, e);
        }
    }

    public void write(int i) throws IOException {
        try {
            this.sig.update((byte) i);
        } catch (SignatureException e) {
            throw new CMSStreamException("signature problem: " + e, e);
        }
    }
}
