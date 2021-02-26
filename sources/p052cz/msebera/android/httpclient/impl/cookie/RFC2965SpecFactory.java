package p052cz.msebera.android.httpclient.impl.cookie;

import java.util.Collection;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.cookie.CookieSpec;
import p052cz.msebera.android.httpclient.cookie.CookieSpecFactory;
import p052cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import p052cz.msebera.android.httpclient.cookie.params.CookieSpecPNames;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.cookie.RFC2965SpecFactory */
public class RFC2965SpecFactory implements CookieSpecFactory, CookieSpecProvider {
    private final String[] datepatterns;
    private final boolean oneHeader;

    public RFC2965SpecFactory(String[] strArr, boolean z) {
        this.datepatterns = strArr;
        this.oneHeader = z;
    }

    public RFC2965SpecFactory() {
        this((String[]) null, false);
    }

    public CookieSpec newInstance(HttpParams httpParams) {
        if (httpParams == null) {
            return new RFC2965Spec();
        }
        String[] strArr = null;
        Collection collection = (Collection) httpParams.getParameter(CookieSpecPNames.DATE_PATTERNS);
        if (collection != null) {
            strArr = (String[]) collection.toArray(new String[collection.size()]);
        }
        return new RFC2965Spec(strArr, httpParams.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
    }

    public CookieSpec create(HttpContext httpContext) {
        return new RFC2965Spec(this.datepatterns, this.oneHeader);
    }
}
