package repack.org.bouncycastle.util;

public class StreamParsingException extends Exception {

    /* renamed from: _e */
    Throwable f6298_e;

    public StreamParsingException(String str, Throwable th) {
        super(str);
        this.f6298_e = th;
    }

    public Throwable getCause() {
        return this.f6298_e;
    }
}
