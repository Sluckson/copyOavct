package p052cz.msebera.android.httpclient.client.cache;

import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import p052cz.msebera.android.httpclient.protocol.BasicHttpContext;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.client.cache.HttpCacheContext */
public class HttpCacheContext extends HttpClientContext {
    public static final String CACHE_RESPONSE_STATUS = "http.cache.response.status";

    public static HttpCacheContext adapt(HttpContext httpContext) {
        if (httpContext instanceof HttpCacheContext) {
            return (HttpCacheContext) httpContext;
        }
        return new HttpCacheContext(httpContext);
    }

    public static HttpCacheContext create() {
        return new HttpCacheContext(new BasicHttpContext());
    }

    public HttpCacheContext(HttpContext httpContext) {
        super(httpContext);
    }

    public HttpCacheContext() {
    }

    public CacheResponseStatus getCacheResponseStatus() {
        return (CacheResponseStatus) getAttribute(CACHE_RESPONSE_STATUS, CacheResponseStatus.class);
    }
}
