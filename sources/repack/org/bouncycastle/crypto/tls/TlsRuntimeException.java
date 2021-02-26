package repack.org.bouncycastle.crypto.tls;

public class TlsRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1928023487348344086L;

    /* renamed from: e */
    Throwable f6218e;

    public TlsRuntimeException(String str, Throwable th) {
        super(str);
        this.f6218e = th;
    }

    public TlsRuntimeException(String str) {
        super(str);
    }

    public Throwable getCause() {
        return this.f6218e;
    }
}
