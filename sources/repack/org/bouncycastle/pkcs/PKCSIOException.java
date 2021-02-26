package repack.org.bouncycastle.pkcs;

import java.io.IOException;

public class PKCSIOException extends IOException {
    private Throwable cause;

    public PKCSIOException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    public PKCSIOException(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.cause;
    }
}
