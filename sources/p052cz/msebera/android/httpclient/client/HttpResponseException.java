package p052cz.msebera.android.httpclient.client;

import p052cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
/* renamed from: cz.msebera.android.httpclient.client.HttpResponseException */
public class HttpResponseException extends ClientProtocolException {
    private static final long serialVersionUID = -7186627969477257933L;
    private final int statusCode;

    public HttpResponseException(int i, String str) {
        super(str);
        this.statusCode = i;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
