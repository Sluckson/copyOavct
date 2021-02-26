package p052cz.msebera.android.httpclient.protocol;

import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.util.Args;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.protocol.UriHttpRequestHandlerMapper */
public class UriHttpRequestHandlerMapper implements HttpRequestHandlerMapper {
    private final UriPatternMatcher<HttpRequestHandler> matcher;

    /* JADX WARNING: type inference failed for: r2v0, types: [cz.msebera.android.httpclient.protocol.UriPatternMatcher<cz.msebera.android.httpclient.protocol.HttpRequestHandler>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected UriHttpRequestHandlerMapper(p052cz.msebera.android.httpclient.protocol.UriPatternMatcher<p052cz.msebera.android.httpclient.protocol.HttpRequestHandler> r2) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "Pattern matcher"
            java.lang.Object r2 = p052cz.msebera.android.httpclient.util.Args.notNull(r2, r0)
            cz.msebera.android.httpclient.protocol.UriPatternMatcher r2 = (p052cz.msebera.android.httpclient.protocol.UriPatternMatcher) r2
            r1.matcher = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.protocol.UriHttpRequestHandlerMapper.<init>(cz.msebera.android.httpclient.protocol.UriPatternMatcher):void");
    }

    public UriHttpRequestHandlerMapper() {
        this(new UriPatternMatcher());
    }

    public void register(String str, HttpRequestHandler httpRequestHandler) {
        Args.notNull(str, "Pattern");
        Args.notNull(httpRequestHandler, "Handler");
        this.matcher.register(str, httpRequestHandler);
    }

    public void unregister(String str) {
        this.matcher.unregister(str);
    }

    /* access modifiers changed from: protected */
    public String getRequestPath(HttpRequest httpRequest) {
        String uri = httpRequest.getRequestLine().getUri();
        int indexOf = uri.indexOf("?");
        if (indexOf != -1) {
            return uri.substring(0, indexOf);
        }
        int indexOf2 = uri.indexOf("#");
        return indexOf2 != -1 ? uri.substring(0, indexOf2) : uri;
    }

    public HttpRequestHandler lookup(HttpRequest httpRequest) {
        Args.notNull(httpRequest, "HTTP request");
        return this.matcher.lookup(getRequestPath(httpRequest));
    }
}
