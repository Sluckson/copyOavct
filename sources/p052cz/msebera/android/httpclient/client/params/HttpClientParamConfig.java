package p052cz.msebera.android.httpclient.client.params;

import java.net.InetAddress;
import java.util.Collection;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.auth.params.AuthPNames;
import p052cz.msebera.android.httpclient.client.config.RequestConfig;
import p052cz.msebera.android.httpclient.conn.params.ConnRoutePNames;
import p052cz.msebera.android.httpclient.params.CoreConnectionPNames;
import p052cz.msebera.android.httpclient.params.CoreProtocolPNames;
import p052cz.msebera.android.httpclient.params.HttpParams;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.client.params.HttpClientParamConfig */
public final class HttpClientParamConfig {
    private HttpClientParamConfig() {
    }

    public static RequestConfig getRequestConfig(HttpParams httpParams) {
        return RequestConfig.custom().setSocketTimeout(httpParams.getIntParameter(CoreConnectionPNames.SO_TIMEOUT, 0)).setStaleConnectionCheckEnabled(httpParams.getBooleanParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, true)).setConnectTimeout(httpParams.getIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 0)).setExpectContinueEnabled(httpParams.getBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, false)).setProxy((HttpHost) httpParams.getParameter(ConnRoutePNames.DEFAULT_PROXY)).setLocalAddress((InetAddress) httpParams.getParameter(ConnRoutePNames.LOCAL_ADDRESS)).setProxyPreferredAuthSchemes((Collection) httpParams.getParameter(AuthPNames.PROXY_AUTH_PREF)).setTargetPreferredAuthSchemes((Collection) httpParams.getParameter(AuthPNames.TARGET_AUTH_PREF)).setAuthenticationEnabled(httpParams.getBooleanParameter(ClientPNames.HANDLE_AUTHENTICATION, true)).setCircularRedirectsAllowed(httpParams.getBooleanParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, false)).setConnectionRequestTimeout((int) httpParams.getLongParameter("http.conn-manager.timeout", 0)).setCookieSpec((String) httpParams.getParameter(ClientPNames.COOKIE_POLICY)).setMaxRedirects(httpParams.getIntParameter(ClientPNames.MAX_REDIRECTS, 50)).setRedirectsEnabled(httpParams.getBooleanParameter(ClientPNames.HANDLE_REDIRECTS, true)).setRelativeRedirectsAllowed(!httpParams.getBooleanParameter(ClientPNames.REJECT_RELATIVE_REDIRECT, false)).build();
    }
}
