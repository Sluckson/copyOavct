package repack.org.bouncycastle.util;

public class StoreException extends RuntimeException {

    /* renamed from: _e */
    private Throwable f6297_e;

    public StoreException(String str, Throwable th) {
        super(str);
        this.f6297_e = th;
    }

    public Throwable getCause() {
        return this.f6297_e;
    }
}
