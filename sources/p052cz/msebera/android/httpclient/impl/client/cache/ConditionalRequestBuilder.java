package p052cz.msebera.android.httpclient.impl.client.cache;

import java.util.Map;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HeaderElement;
import p052cz.msebera.android.httpclient.ProtocolException;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.cache.HeaderConstants;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import p052cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.ConditionalRequestBuilder */
class ConditionalRequestBuilder {
    ConditionalRequestBuilder() {
    }

    public HttpRequestWrapper buildConditionalRequest(HttpRequestWrapper httpRequestWrapper, HttpCacheEntry httpCacheEntry) throws ProtocolException {
        HttpRequestWrapper wrap = HttpRequestWrapper.wrap(httpRequestWrapper.getOriginal());
        wrap.setHeaders(httpRequestWrapper.getAllHeaders());
        Header firstHeader = httpCacheEntry.getFirstHeader("ETag");
        if (firstHeader != null) {
            wrap.setHeader("If-None-Match", firstHeader.getValue());
        }
        Header firstHeader2 = httpCacheEntry.getFirstHeader("Last-Modified");
        if (firstHeader2 != null) {
            wrap.setHeader("If-Modified-Since", firstHeader2.getValue());
        }
        boolean z = false;
        for (Header elements : httpCacheEntry.getHeaders("Cache-Control")) {
            HeaderElement[] elements2 = elements.getElements();
            int length = elements2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                HeaderElement headerElement = elements2[i];
                if (HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE.equalsIgnoreCase(headerElement.getName()) || HeaderConstants.CACHE_CONTROL_PROXY_REVALIDATE.equalsIgnoreCase(headerElement.getName())) {
                    z = true;
                } else {
                    i++;
                }
            }
            z = true;
        }
        if (z) {
            wrap.addHeader("Cache-Control", "max-age=0");
        }
        return wrap;
    }

    public HttpRequestWrapper buildConditionalRequestFromVariants(HttpRequestWrapper httpRequestWrapper, Map<String, Variant> map) {
        HttpRequestWrapper wrap = HttpRequestWrapper.wrap(httpRequestWrapper.getOriginal());
        wrap.setHeaders(httpRequestWrapper.getAllHeaders());
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String next : map.keySet()) {
            if (!z) {
                sb.append(",");
            }
            z = false;
            sb.append(next);
        }
        wrap.setHeader("If-None-Match", sb.toString());
        return wrap;
    }

    public HttpRequestWrapper buildUnconditionalRequest(HttpRequestWrapper httpRequestWrapper, HttpCacheEntry httpCacheEntry) {
        HttpRequestWrapper wrap = HttpRequestWrapper.wrap(httpRequestWrapper.getOriginal());
        wrap.setHeaders(httpRequestWrapper.getAllHeaders());
        wrap.addHeader("Cache-Control", HeaderConstants.CACHE_CONTROL_NO_CACHE);
        wrap.addHeader("Pragma", HeaderConstants.CACHE_CONTROL_NO_CACHE);
        wrap.removeHeaders("If-Range");
        wrap.removeHeaders("If-Match");
        wrap.removeHeaders("If-None-Match");
        wrap.removeHeaders("If-Unmodified-Since");
        wrap.removeHeaders("If-Modified-Since");
        return wrap;
    }
}
