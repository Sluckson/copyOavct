package p052cz.msebera.android.httpclient.impl.client.cache;

import java.lang.reflect.Proxy;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.Proxies */
class Proxies {
    Proxies() {
    }

    public static CloseableHttpResponse enhanceResponse(HttpResponse httpResponse) {
        Args.notNull(httpResponse, "HTTP response");
        if (httpResponse instanceof CloseableHttpResponse) {
            return (CloseableHttpResponse) httpResponse;
        }
        return (CloseableHttpResponse) Proxy.newProxyInstance(ResponseProxyHandler.class.getClassLoader(), new Class[]{CloseableHttpResponse.class}, new ResponseProxyHandler(httpResponse));
    }
}
