package p052cz.msebera.android.httpclient.protocol;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpRequestInterceptor;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.params.CoreProtocolPNames;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.protocol.RequestUserAgent */
public class RequestUserAgent implements HttpRequestInterceptor {
    private final String userAgent;

    public RequestUserAgent(String str) {
        this.userAgent = str;
    }

    public RequestUserAgent() {
        this((String) null);
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (!httpRequest.containsHeader("User-Agent")) {
            String str = null;
            HttpParams params = httpRequest.getParams();
            if (params != null) {
                str = (String) params.getParameter(CoreProtocolPNames.USER_AGENT);
            }
            if (str == null) {
                str = this.userAgent;
            }
            if (str != null) {
                httpRequest.addHeader("User-Agent", str);
            }
        }
    }
}
