package p052cz.msebera.android.httpclient.impl.client;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.auth.AuthOption;
import p052cz.msebera.android.httpclient.auth.AuthScheme;
import p052cz.msebera.android.httpclient.auth.AuthScope;
import p052cz.msebera.android.httpclient.auth.AuthenticationException;
import p052cz.msebera.android.httpclient.auth.Credentials;
import p052cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p052cz.msebera.android.httpclient.client.AuthCache;
import p052cz.msebera.android.httpclient.client.AuthenticationHandler;
import p052cz.msebera.android.httpclient.client.AuthenticationStrategy;
import p052cz.msebera.android.httpclient.client.CredentialsProvider;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.AuthenticationStrategyAdaptor */
class AuthenticationStrategyAdaptor implements AuthenticationStrategy {
    private final AuthenticationHandler handler;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    public AuthenticationStrategyAdaptor(AuthenticationHandler authenticationHandler) {
        this.handler = authenticationHandler;
    }

    public boolean isAuthenticationRequested(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) {
        return this.handler.isAuthenticationRequested(httpResponse, httpContext);
    }

    public Map<String, Header> getChallenges(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException {
        return this.handler.getChallenges(httpResponse, httpContext);
    }

    public Queue<AuthOption> select(Map<String, Header> map, HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException {
        Args.notNull(map, "Map of auth challenges");
        Args.notNull(httpHost, "Host");
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpContext, "HTTP context");
        LinkedList linkedList = new LinkedList();
        CredentialsProvider credentialsProvider = (CredentialsProvider) httpContext.getAttribute("http.auth.credentials-provider");
        if (credentialsProvider == null) {
            this.log.debug("Credentials provider not set in the context");
            return linkedList;
        }
        try {
            AuthScheme selectScheme = this.handler.selectScheme(map, httpResponse, httpContext);
            selectScheme.processChallenge(map.get(selectScheme.getSchemeName().toLowerCase(Locale.ENGLISH)));
            Credentials credentials = credentialsProvider.getCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort(), selectScheme.getRealm(), selectScheme.getSchemeName()));
            if (credentials != null) {
                linkedList.add(new AuthOption(selectScheme, credentials));
            }
            return linkedList;
        } catch (AuthenticationException e) {
            if (this.log.isWarnEnabled()) {
                this.log.warn(e.getMessage(), e);
            }
            return linkedList;
        }
    }

    public void authSucceeded(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext) {
        AuthCache authCache = (AuthCache) httpContext.getAttribute("http.auth.auth-cache");
        if (isCachable(authScheme)) {
            if (authCache == null) {
                authCache = new BasicAuthCache();
                httpContext.setAttribute("http.auth.auth-cache", authCache);
            }
            if (this.log.isDebugEnabled()) {
                HttpClientAndroidLog httpClientAndroidLog = this.log;
                httpClientAndroidLog.debug("Caching '" + authScheme.getSchemeName() + "' auth scheme for " + httpHost);
            }
            authCache.put(httpHost, authScheme);
        }
    }

    public void authFailed(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext) {
        AuthCache authCache = (AuthCache) httpContext.getAttribute("http.auth.auth-cache");
        if (authCache != null) {
            if (this.log.isDebugEnabled()) {
                HttpClientAndroidLog httpClientAndroidLog = this.log;
                httpClientAndroidLog.debug("Removing from cache '" + authScheme.getSchemeName() + "' auth scheme for " + httpHost);
            }
            authCache.remove(httpHost);
        }
    }

    private boolean isCachable(AuthScheme authScheme) {
        if (authScheme == null || !authScheme.isComplete()) {
            return false;
        }
        String schemeName = authScheme.getSchemeName();
        if (schemeName.equalsIgnoreCase("Basic") || schemeName.equalsIgnoreCase("Digest")) {
            return true;
        }
        return false;
    }

    public AuthenticationHandler getHandler() {
        return this.handler;
    }
}
