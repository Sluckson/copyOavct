package p052cz.msebera.android.httpclient;

/* renamed from: cz.msebera.android.httpclient.HttpException */
public class HttpException extends Exception {
    private static final long serialVersionUID = -5437299376222011036L;

    public HttpException() {
    }

    public HttpException(String str) {
        super(str);
    }

    public HttpException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
