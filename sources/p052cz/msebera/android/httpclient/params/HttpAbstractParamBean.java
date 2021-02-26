package p052cz.msebera.android.httpclient.params;

import p052cz.msebera.android.httpclient.util.Args;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.params.HttpAbstractParamBean */
public abstract class HttpAbstractParamBean {
    protected final HttpParams params;

    public HttpAbstractParamBean(HttpParams httpParams) {
        this.params = (HttpParams) Args.notNull(httpParams, "HTTP parameters");
    }
}
