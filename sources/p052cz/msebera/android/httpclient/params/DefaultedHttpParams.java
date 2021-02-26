package p052cz.msebera.android.httpclient.params;

import java.util.HashSet;
import java.util.Set;
import p052cz.msebera.android.httpclient.util.Args;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.params.DefaultedHttpParams */
public final class DefaultedHttpParams extends AbstractHttpParams {
    private final HttpParams defaults;
    private final HttpParams local;

    public DefaultedHttpParams(HttpParams httpParams, HttpParams httpParams2) {
        this.local = (HttpParams) Args.notNull(httpParams, "Local HTTP parameters");
        this.defaults = httpParams2;
    }

    public HttpParams copy() {
        return new DefaultedHttpParams(this.local.copy(), this.defaults);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r1 = r2.defaults;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getParameter(java.lang.String r3) {
        /*
            r2 = this;
            cz.msebera.android.httpclient.params.HttpParams r0 = r2.local
            java.lang.Object r0 = r0.getParameter(r3)
            if (r0 != 0) goto L_0x0010
            cz.msebera.android.httpclient.params.HttpParams r1 = r2.defaults
            if (r1 == 0) goto L_0x0010
            java.lang.Object r0 = r1.getParameter(r3)
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.params.DefaultedHttpParams.getParameter(java.lang.String):java.lang.Object");
    }

    public boolean removeParameter(String str) {
        return this.local.removeParameter(str);
    }

    public HttpParams setParameter(String str, Object obj) {
        return this.local.setParameter(str, obj);
    }

    public HttpParams getDefaults() {
        return this.defaults;
    }

    public Set<String> getNames() {
        HashSet hashSet = new HashSet(getNames(this.defaults));
        hashSet.addAll(getNames(this.local));
        return hashSet;
    }

    public Set<String> getDefaultNames() {
        return new HashSet(getNames(this.defaults));
    }

    public Set<String> getLocalNames() {
        return new HashSet(getNames(this.local));
    }

    private Set<String> getNames(HttpParams httpParams) {
        if (httpParams instanceof HttpParamsNames) {
            return ((HttpParamsNames) httpParams).getNames();
        }
        throw new UnsupportedOperationException("HttpParams instance does not implement HttpParamsNames");
    }
}
