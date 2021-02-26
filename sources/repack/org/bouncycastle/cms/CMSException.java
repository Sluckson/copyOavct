package repack.org.bouncycastle.cms;

public class CMSException extends Exception {

    /* renamed from: e */
    Exception f5903e;

    public CMSException(String str) {
        super(str);
    }

    public CMSException(String str, Exception exc) {
        super(str);
        this.f5903e = exc;
    }

    public Exception getUnderlyingException() {
        return this.f5903e;
    }

    public Throwable getCause() {
        return this.f5903e;
    }
}
