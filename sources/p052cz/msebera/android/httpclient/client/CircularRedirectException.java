package p052cz.msebera.android.httpclient.client;

import p052cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
/* renamed from: cz.msebera.android.httpclient.client.CircularRedirectException */
public class CircularRedirectException extends RedirectException {
    private static final long serialVersionUID = 6830063487001091803L;

    public CircularRedirectException() {
    }

    public CircularRedirectException(String str) {
        super(str);
    }

    public CircularRedirectException(String str, Throwable th) {
        super(str, th);
    }
}
