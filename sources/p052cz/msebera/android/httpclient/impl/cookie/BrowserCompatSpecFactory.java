package p052cz.msebera.android.httpclient.impl.cookie;

import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.cookie.CookieSpec;
import p052cz.msebera.android.httpclient.cookie.CookieSpecFactory;
import p052cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory */
public class BrowserCompatSpecFactory implements CookieSpecFactory, CookieSpecProvider {
    private final String[] datepatterns;
    private final SecurityLevel securityLevel;

    /* renamed from: cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory$SecurityLevel */
    public enum SecurityLevel {
        SECURITYLEVEL_DEFAULT,
        SECURITYLEVEL_IE_MEDIUM
    }

    public BrowserCompatSpecFactory(String[] strArr, SecurityLevel securityLevel2) {
        this.datepatterns = strArr;
        this.securityLevel = securityLevel2;
    }

    public BrowserCompatSpecFactory(String[] strArr) {
        this((String[]) null, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpecFactory() {
        this((String[]) null, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    /* JADX WARNING: type inference failed for: r3v5, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p052cz.msebera.android.httpclient.cookie.CookieSpec newInstance(p052cz.msebera.android.httpclient.params.HttpParams r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L_0x0022
            java.lang.String r1 = "http.protocol.cookie-datepatterns"
            java.lang.Object r3 = r3.getParameter(r1)
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L_0x001a
            int r0 = r3.size()
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.Object[] r3 = r3.toArray(r0)
            r0 = r3
            java.lang.String[] r0 = (java.lang.String[]) r0
        L_0x001a:
            cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpec r3 = new cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpec
            cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory$SecurityLevel r1 = r2.securityLevel
            r3.<init>(r0, r1)
            return r3
        L_0x0022:
            cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpec r3 = new cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpec
            cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory$SecurityLevel r1 = r2.securityLevel
            r3.<init>(r0, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory.newInstance(cz.msebera.android.httpclient.params.HttpParams):cz.msebera.android.httpclient.cookie.CookieSpec");
    }

    public CookieSpec create(HttpContext httpContext) {
        return new BrowserCompatSpec(this.datepatterns);
    }
}
