package p052cz.msebera.android.httpclient.impl.client;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.StandardHttpRequestRetryHandler */
public class StandardHttpRequestRetryHandler extends DefaultHttpRequestRetryHandler {
    private final Map<String, Boolean> idempotentMethods;

    public StandardHttpRequestRetryHandler(int i, boolean z) {
        super(i, z);
        this.idempotentMethods = new ConcurrentHashMap();
        this.idempotentMethods.put("GET", Boolean.TRUE);
        this.idempotentMethods.put("HEAD", Boolean.TRUE);
        this.idempotentMethods.put("PUT", Boolean.TRUE);
        this.idempotentMethods.put("DELETE", Boolean.TRUE);
        this.idempotentMethods.put("OPTIONS", Boolean.TRUE);
        this.idempotentMethods.put("TRACE", Boolean.TRUE);
    }

    public StandardHttpRequestRetryHandler() {
        this(3, false);
    }

    /* access modifiers changed from: protected */
    public boolean handleAsIdempotent(HttpRequest httpRequest) {
        Boolean bool = this.idempotentMethods.get(httpRequest.getRequestLine().getMethod().toUpperCase(Locale.ENGLISH));
        return bool != null && bool.booleanValue();
    }
}
