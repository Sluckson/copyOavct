package repack.org.bouncycastle.cms;

public class CMSRuntimeException extends RuntimeException {

    /* renamed from: e */
    Exception f5904e;

    public CMSRuntimeException(String str) {
        super(str);
    }

    public CMSRuntimeException(String str, Exception exc) {
        super(str);
        this.f5904e = exc;
    }

    public Exception getUnderlyingException() {
        return this.f5904e;
    }

    public Throwable getCause() {
        return this.f5904e;
    }
}
