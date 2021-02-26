package repack.org.bouncycastle.operator;

public class OperatorException extends Exception {
    private Throwable cause;

    public OperatorException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    public OperatorException(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.cause;
    }
}
