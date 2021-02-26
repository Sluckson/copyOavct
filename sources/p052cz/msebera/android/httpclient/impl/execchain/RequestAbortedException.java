package p052cz.msebera.android.httpclient.impl.execchain;

import java.io.InterruptedIOException;
import p052cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.execchain.RequestAbortedException */
public class RequestAbortedException extends InterruptedIOException {
    private static final long serialVersionUID = 4973849966012490112L;

    public RequestAbortedException(String str) {
        super(str);
    }

    public RequestAbortedException(String str, Throwable th) {
        super(str);
        if (th != null) {
            initCause(th);
        }
    }
}
