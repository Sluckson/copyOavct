package p052cz.msebera.android.httpclient.protocol;

import java.util.Map;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.util.Args;

@ThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.protocol.HttpRequestHandlerRegistry */
public class HttpRequestHandlerRegistry implements HttpRequestHandlerResolver {
    private final UriPatternMatcher<HttpRequestHandler> matcher = new UriPatternMatcher<>();

    public void register(String str, HttpRequestHandler httpRequestHandler) {
        Args.notNull(str, "URI request pattern");
        Args.notNull(httpRequestHandler, "Request handler");
        this.matcher.register(str, httpRequestHandler);
    }

    public void unregister(String str) {
        this.matcher.unregister(str);
    }

    public void setHandlers(Map<String, HttpRequestHandler> map) {
        this.matcher.setObjects(map);
    }

    public Map<String, HttpRequestHandler> getHandlers() {
        return this.matcher.getObjects();
    }

    public HttpRequestHandler lookup(String str) {
        return this.matcher.lookup(str);
    }
}
