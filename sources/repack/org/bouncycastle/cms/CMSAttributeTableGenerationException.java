package repack.org.bouncycastle.cms;

public class CMSAttributeTableGenerationException extends CMSRuntimeException {

    /* renamed from: e */
    Exception f5902e;

    public CMSAttributeTableGenerationException(String str) {
        super(str);
    }

    public CMSAttributeTableGenerationException(String str, Exception exc) {
        super(str);
        this.f5902e = exc;
    }

    public Exception getUnderlyingException() {
        return this.f5902e;
    }

    public Throwable getCause() {
        return this.f5902e;
    }
}
