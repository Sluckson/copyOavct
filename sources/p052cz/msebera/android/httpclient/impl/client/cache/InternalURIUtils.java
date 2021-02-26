package p052cz.msebera.android.httpclient.impl.client.cache;

import java.net.URI;
import java.net.URISyntaxException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.utils.URIUtils;
import p052cz.msebera.android.httpclient.conn.routing.RouteInfo;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.InternalURIUtils */
class InternalURIUtils {
    public static URI rewriteURIForRoute(URI uri, RouteInfo routeInfo) throws URISyntaxException {
        if (uri == null) {
            return null;
        }
        if (routeInfo.getProxyHost() == null || routeInfo.isTunnelled()) {
            if (uri.isAbsolute()) {
                return URIUtils.rewriteURI(uri, (HttpHost) null, true);
            }
            return URIUtils.rewriteURI(uri);
        } else if (!uri.isAbsolute()) {
            return URIUtils.rewriteURI(uri, routeInfo.getTargetHost(), true);
        } else {
            return URIUtils.rewriteURI(uri);
        }
    }

    private InternalURIUtils() {
    }
}
