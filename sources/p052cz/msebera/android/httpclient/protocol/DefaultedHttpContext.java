package p052cz.msebera.android.httpclient.protocol;

import p052cz.msebera.android.httpclient.util.Args;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.protocol.DefaultedHttpContext */
public final class DefaultedHttpContext implements HttpContext {
    private final HttpContext defaults;
    private final HttpContext local;

    public DefaultedHttpContext(HttpContext httpContext, HttpContext httpContext2) {
        this.local = (HttpContext) Args.notNull(httpContext, "HTTP context");
        this.defaults = httpContext2;
    }

    public Object getAttribute(String str) {
        Object attribute = this.local.getAttribute(str);
        return attribute == null ? this.defaults.getAttribute(str) : attribute;
    }

    public Object removeAttribute(String str) {
        return this.local.removeAttribute(str);
    }

    public void setAttribute(String str, Object obj) {
        this.local.setAttribute(str, obj);
    }

    public HttpContext getDefaults() {
        return this.defaults;
    }

    public String toString() {
        return "[local: " + this.local + "defaults: " + this.defaults + "]";
    }
}
