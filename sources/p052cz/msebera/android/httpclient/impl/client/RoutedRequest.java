package p052cz.msebera.android.httpclient.impl.client;

import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;

@NotThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.RoutedRequest */
public class RoutedRequest {
    protected final RequestWrapper request;
    protected final HttpRoute route;

    public RoutedRequest(RequestWrapper requestWrapper, HttpRoute httpRoute) {
        this.request = requestWrapper;
        this.route = httpRoute;
    }

    public final RequestWrapper getRequest() {
        return this.request;
    }

    public final HttpRoute getRoute() {
        return this.route;
    }
}
