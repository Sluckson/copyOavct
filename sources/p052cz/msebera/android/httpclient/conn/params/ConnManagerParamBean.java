package p052cz.msebera.android.httpclient.conn.params;

import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.params.HttpAbstractParamBean;
import p052cz.msebera.android.httpclient.params.HttpParams;

@NotThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.params.ConnManagerParamBean */
public class ConnManagerParamBean extends HttpAbstractParamBean {
    public ConnManagerParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    public void setTimeout(long j) {
        this.params.setLongParameter("http.conn-manager.timeout", j);
    }

    public void setMaxTotalConnections(int i) {
        this.params.setIntParameter(ConnManagerPNames.MAX_TOTAL_CONNECTIONS, i);
    }

    public void setConnectionsPerRoute(ConnPerRouteBean connPerRouteBean) {
        this.params.setParameter(ConnManagerPNames.MAX_CONNECTIONS_PER_ROUTE, connPerRouteBean);
    }
}
