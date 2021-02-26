package p052cz.msebera.android.httpclient.client.protocol;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpRequestInterceptor;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.auth.AuthProtocolState;
import p052cz.msebera.android.httpclient.auth.AuthScheme;
import p052cz.msebera.android.httpclient.auth.AuthScope;
import p052cz.msebera.android.httpclient.auth.AuthState;
import p052cz.msebera.android.httpclient.auth.Credentials;
import p052cz.msebera.android.httpclient.client.AuthCache;
import p052cz.msebera.android.httpclient.client.CredentialsProvider;
import p052cz.msebera.android.httpclient.conn.routing.RouteInfo;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.client.protocol.RequestAuthCache */
public class RequestAuthCache implements HttpRequestInterceptor {
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        AuthScheme authScheme;
        AuthScheme authScheme2;
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext adapt = HttpClientContext.adapt(httpContext);
        AuthCache authCache = adapt.getAuthCache();
        if (authCache == null) {
            this.log.debug("Auth cache not set in the context");
            return;
        }
        CredentialsProvider credentialsProvider = adapt.getCredentialsProvider();
        if (credentialsProvider == null) {
            this.log.debug("Credentials provider not set in the context");
            return;
        }
        RouteInfo httpRoute = adapt.getHttpRoute();
        if (httpRoute == null) {
            this.log.debug("Route info not set in the context");
            return;
        }
        HttpHost targetHost = adapt.getTargetHost();
        if (targetHost == null) {
            this.log.debug("Target host not set in the context");
            return;
        }
        if (targetHost.getPort() < 0) {
            targetHost = new HttpHost(targetHost.getHostName(), httpRoute.getTargetHost().getPort(), targetHost.getSchemeName());
        }
        AuthState targetAuthState = adapt.getTargetAuthState();
        if (!(targetAuthState == null || targetAuthState.getState() != AuthProtocolState.UNCHALLENGED || (authScheme2 = authCache.get(targetHost)) == null)) {
            doPreemptiveAuth(targetHost, authScheme2, targetAuthState, credentialsProvider);
        }
        HttpHost proxyHost = httpRoute.getProxyHost();
        AuthState proxyAuthState = adapt.getProxyAuthState();
        if (proxyHost != null && proxyAuthState != null && proxyAuthState.getState() == AuthProtocolState.UNCHALLENGED && (authScheme = authCache.get(proxyHost)) != null) {
            doPreemptiveAuth(proxyHost, authScheme, proxyAuthState, credentialsProvider);
        }
    }

    private void doPreemptiveAuth(HttpHost httpHost, AuthScheme authScheme, AuthState authState, CredentialsProvider credentialsProvider) {
        String schemeName = authScheme.getSchemeName();
        if (this.log.isDebugEnabled()) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.debug("Re-using cached '" + schemeName + "' auth scheme for " + httpHost);
        }
        Credentials credentials = credentialsProvider.getCredentials(new AuthScope(httpHost, AuthScope.ANY_REALM, schemeName));
        if (credentials != null) {
            if ("BASIC".equalsIgnoreCase(authScheme.getSchemeName())) {
                authState.setState(AuthProtocolState.CHALLENGED);
            } else {
                authState.setState(AuthProtocolState.SUCCESS);
            }
            authState.update(authScheme, credentials);
            return;
        }
        this.log.debug("No credentials for preemptive authentication");
    }
}
