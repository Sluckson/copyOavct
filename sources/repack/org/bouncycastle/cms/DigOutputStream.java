package repack.org.bouncycastle.cms;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

class DigOutputStream extends OutputStream {
    private final MessageDigest dig;

    DigOutputStream(MessageDigest messageDigest) {
        this.dig = messageDigest;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.dig.update(bArr, i, i2);
    }

    public void write(int i) throws IOException {
        this.dig.update((byte) i);
    }
}
