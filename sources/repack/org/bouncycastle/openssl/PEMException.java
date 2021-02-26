package repack.org.bouncycastle.openssl;

import java.io.IOException;

public class PEMException extends IOException {
    Exception underlying;

    public PEMException(String str) {
        super(str);
    }

    public PEMException(String str, Exception exc) {
        super(str);
        this.underlying = exc;
    }

    public Exception getUnderlyingException() {
        return this.underlying;
    }

    public Throwable getCause() {
        return this.underlying;
    }
}
