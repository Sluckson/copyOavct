package p052cz.msebera.android.httpclient.conn.params;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.util.Args;

@ThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.params.ConnPerRouteBean */
public final class ConnPerRouteBean implements ConnPerRoute {
    public static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 2;
    private volatile int defaultMax;
    private final ConcurrentHashMap<HttpRoute, Integer> maxPerHostMap;

    public ConnPerRouteBean(int i) {
        this.maxPerHostMap = new ConcurrentHashMap<>();
        setDefaultMaxPerRoute(i);
    }

    public ConnPerRouteBean() {
        this(2);
    }

    public int getDefaultMax() {
        return this.defaultMax;
    }

    public int getDefaultMaxPerRoute() {
        return this.defaultMax;
    }

    public void setDefaultMaxPerRoute(int i) {
        Args.positive(i, "Defautl max per route");
        this.defaultMax = i;
    }

    public void setMaxForRoute(HttpRoute httpRoute, int i) {
        Args.notNull(httpRoute, "HTTP route");
        Args.positive(i, "Max per route");
        this.maxPerHostMap.put(httpRoute, Integer.valueOf(i));
    }

    public int getMaxForRoute(HttpRoute httpRoute) {
        Args.notNull(httpRoute, "HTTP route");
        Integer num = this.maxPerHostMap.get(httpRoute);
        if (num != null) {
            return num.intValue();
        }
        return this.defaultMax;
    }

    public void setMaxForRoutes(Map<HttpRoute, Integer> map) {
        if (map != null) {
            this.maxPerHostMap.clear();
            this.maxPerHostMap.putAll(map);
        }
    }

    public String toString() {
        return this.maxPerHostMap.toString();
    }
}
