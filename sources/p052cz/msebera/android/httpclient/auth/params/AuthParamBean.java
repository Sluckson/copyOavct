package p052cz.msebera.android.httpclient.auth.params;

import p052cz.msebera.android.httpclient.params.HttpAbstractParamBean;
import p052cz.msebera.android.httpclient.params.HttpParams;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.auth.params.AuthParamBean */
public class AuthParamBean extends HttpAbstractParamBean {
    public AuthParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    public void setCredentialCharset(String str) {
        AuthParams.setCredentialCharset(this.params, str);
    }
}
