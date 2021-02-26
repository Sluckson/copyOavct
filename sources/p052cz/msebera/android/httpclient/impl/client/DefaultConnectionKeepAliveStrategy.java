package p052cz.msebera.android.httpclient.impl.client;

import p052cz.msebera.android.httpclient.HeaderElement;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import p052cz.msebera.android.httpclient.message.BasicHeaderElementIterator;
import p052cz.msebera.android.httpclient.protocol.HTTP;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.DefaultConnectionKeepAliveStrategy */
public class DefaultConnectionKeepAliveStrategy implements ConnectionKeepAliveStrategy {
    public static final DefaultConnectionKeepAliveStrategy INSTANCE = new DefaultConnectionKeepAliveStrategy();

    public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        BasicHeaderElementIterator basicHeaderElementIterator = new BasicHeaderElementIterator(httpResponse.headerIterator(HTTP.CONN_KEEP_ALIVE));
        while (basicHeaderElementIterator.hasNext()) {
            HeaderElement nextElement = basicHeaderElementIterator.nextElement();
            String name = nextElement.getName();
            String value = nextElement.getValue();
            if (value != null && name.equalsIgnoreCase("timeout")) {
                try {
                    return Long.parseLong(value) * 1000;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return -1;
    }
}
