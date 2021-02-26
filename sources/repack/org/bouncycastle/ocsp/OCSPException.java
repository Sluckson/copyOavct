package repack.org.bouncycastle.ocsp;

public class OCSPException extends Exception {

    /* renamed from: e */
    Exception f6295e;

    public OCSPException(String str) {
        super(str);
    }

    public OCSPException(String str, Exception exc) {
        super(str);
        this.f6295e = exc;
    }

    public Exception getUnderlyingException() {
        return this.f6295e;
    }

    public Throwable getCause() {
        return this.f6295e;
    }
}
