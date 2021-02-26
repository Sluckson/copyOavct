package repack.org.bouncycastle.pkcs;

public class PKCSException extends Exception {
    private Throwable cause;

    public PKCSException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    public PKCSException(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.cause;
    }
}
