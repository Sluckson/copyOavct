package p052cz.msebera.android.httpclient.impl.client;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.client.ConnectionBackoffStrategy;

/* renamed from: cz.msebera.android.httpclient.impl.client.DefaultBackoffStrategy */
public class DefaultBackoffStrategy implements ConnectionBackoffStrategy {
    public boolean shouldBackoff(Throwable th) {
        return (th instanceof SocketTimeoutException) || (th instanceof ConnectException);
    }

    public boolean shouldBackoff(HttpResponse httpResponse) {
        return httpResponse.getStatusLine().getStatusCode() == 503;
    }
}
