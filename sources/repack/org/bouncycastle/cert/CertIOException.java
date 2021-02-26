package repack.org.bouncycastle.cert;

import java.io.IOException;

public class CertIOException extends IOException {
    private Throwable cause;

    public CertIOException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    public CertIOException(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.cause;
    }
}
