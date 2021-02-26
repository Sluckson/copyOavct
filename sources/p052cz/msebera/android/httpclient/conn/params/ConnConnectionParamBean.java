package p052cz.msebera.android.httpclient.conn.params;

import p052cz.msebera.android.httpclient.params.HttpAbstractParamBean;
import p052cz.msebera.android.httpclient.params.HttpParams;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.conn.params.ConnConnectionParamBean */
public class ConnConnectionParamBean extends HttpAbstractParamBean {
    public ConnConnectionParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    @Deprecated
    public void setMaxStatusLineGarbage(int i) {
        this.params.setIntParameter(ConnConnectionPNames.MAX_STATUS_LINE_GARBAGE, i);
    }
}
