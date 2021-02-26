package repack.org.bouncycastle.x509.util;

public class StreamParsingException extends Exception {

    /* renamed from: _e */
    Throwable f6300_e;

    public StreamParsingException(String str, Throwable th) {
        super(str);
        this.f6300_e = th;
    }

    public Throwable getCause() {
        return this.f6300_e;
    }
}
