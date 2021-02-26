package p052cz.msebera.android.httpclient.client.protocol;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.auth.AuthState;
import p052cz.msebera.android.httpclient.conn.HttpRoutedConnection;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
@Deprecated
/* renamed from: cz.msebera.android.httpclient.client.protocol.RequestProxyAuthentication */
public class RequestProxyAuthentication extends RequestAuthenticationBase {
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        if (!httpRequest.containsHeader("Proxy-Authorization")) {
            HttpRoutedConnection httpRoutedConnection = (HttpRoutedConnection) httpContext.getAttribute("http.connection");
            if (httpRoutedConnection == null) {
                this.log.debug("HTTP connection not set in the context");
            } else if (!httpRoutedConnection.getRoute().isTunnelled()) {
                AuthState authState = (AuthState) httpContext.getAttribute("http.auth.proxy-scope");
                if (authState == null) {
                    this.log.debug("Proxy auth state not set in the context");
                    return;
                }
                if (this.log.isDebugEnabled()) {
                    HttpClientAndroidLog httpClientAndroidLog = this.log;
                    httpClientAndroidLog.debug("Proxy auth state: " + authState.getState());
                }
                process(authState, httpRequest, httpContext);
            }
        }
    }
}
