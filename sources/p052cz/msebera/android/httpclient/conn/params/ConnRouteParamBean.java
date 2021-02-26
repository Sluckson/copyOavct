package p052cz.msebera.android.httpclient.conn.params;

import java.net.InetAddress;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.params.HttpAbstractParamBean;
import p052cz.msebera.android.httpclient.params.HttpParams;

@NotThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.params.ConnRouteParamBean */
public class ConnRouteParamBean extends HttpAbstractParamBean {
    public ConnRouteParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    public void setDefaultProxy(HttpHost httpHost) {
        this.params.setParameter(ConnRoutePNames.DEFAULT_PROXY, httpHost);
    }

    public void setLocalAddress(InetAddress inetAddress) {
        this.params.setParameter(ConnRoutePNames.LOCAL_ADDRESS, inetAddress);
    }

    public void setForcedRoute(HttpRoute httpRoute) {
        this.params.setParameter(ConnRoutePNames.FORCED_ROUTE, httpRoute);
    }
}
