package p052cz.msebera.android.httpclient.cookie.params;

import java.util.Collection;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.params.HttpAbstractParamBean;
import p052cz.msebera.android.httpclient.params.HttpParams;

@NotThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.cookie.params.CookieSpecParamBean */
public class CookieSpecParamBean extends HttpAbstractParamBean {
    public CookieSpecParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    public void setDatePatterns(Collection<String> collection) {
        this.params.setParameter(CookieSpecPNames.DATE_PATTERNS, collection);
    }

    public void setSingleHeader(boolean z) {
        this.params.setBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, z);
    }
}
