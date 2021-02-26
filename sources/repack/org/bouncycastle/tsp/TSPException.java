package repack.org.bouncycastle.tsp;

public class TSPException extends Exception {
    Exception underlyingException;

    public TSPException(String str) {
        super(str);
    }

    public TSPException(String str, Exception exc) {
        super(str);
        this.underlyingException = exc;
    }

    public Exception getUnderlyingException() {
        return this.underlyingException;
    }

    public Throwable getCause() {
        return this.underlyingException;
    }
}
