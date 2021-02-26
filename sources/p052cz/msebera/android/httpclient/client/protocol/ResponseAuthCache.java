package p052cz.msebera.android.httpclient.client.protocol;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpResponseInterceptor;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.auth.AuthProtocolState;
import p052cz.msebera.android.httpclient.auth.AuthScheme;
import p052cz.msebera.android.httpclient.auth.AuthState;
import p052cz.msebera.android.httpclient.client.AuthCache;
import p052cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.impl.client.BasicAuthCache;
import p052cz.msebera.android.httpclient.protocol.ExecutionContext;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
@Deprecated
/* renamed from: cz.msebera.android.httpclient.client.protocol.ResponseAuthCache */
public class ResponseAuthCache implements HttpResponseInterceptor {
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        AuthCache authCache = (AuthCache) httpContext.getAttribute("http.auth.auth-cache");
        HttpHost httpHost = (HttpHost) httpContext.getAttribute("http.target_host");
        AuthState authState = (AuthState) httpContext.getAttribute("http.auth.target-scope");
        if (!(httpHost == null || authState == null)) {
            if (this.log.isDebugEnabled()) {
                HttpClientAndroidLog httpClientAndroidLog = this.log;
                httpClientAndroidLog.debug("Target auth state: " + authState.getState());
            }
            if (isCachable(authState)) {
                SchemeRegistry schemeRegistry = (SchemeRegistry) httpContext.getAttribute(ClientContext.SCHEME_REGISTRY);
                if (httpHost.getPort() < 0) {
                    httpHost = new HttpHost(httpHost.getHostName(), schemeRegistry.getScheme(httpHost).resolvePort(httpHost.getPort()), httpHost.getSchemeName());
                }
                if (authCache == null) {
                    authCache = new BasicAuthCache();
                    httpContext.setAttribute("http.auth.auth-cache", authCache);
                }
                int i = C43411.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[authState.getState().ordinal()];
                if (i == 1) {
                    cache(authCache, httpHost, authState.getAuthScheme());
                } else if (i == 2) {
                    uncache(authCache, httpHost, authState.getAuthScheme());
                }
            }
        }
        HttpHost httpHost2 = (HttpHost) httpContext.getAttribute(ExecutionContext.HTTP_PROXY_HOST);
        AuthState authState2 = (AuthState) httpContext.getAttribute("http.auth.proxy-scope");
        if (httpHost2 != null && authState2 != null) {
            if (this.log.isDebugEnabled()) {
                HttpClientAndroidLog httpClientAndroidLog2 = this.log;
                httpClientAndroidLog2.debug("Proxy auth state: " + authState2.getState());
            }
            if (isCachable(authState2)) {
                if (authCache == null) {
                    authCache = new BasicAuthCache();
                    httpContext.setAttribute("http.auth.auth-cache", authCache);
                }
                int i2 = C43411.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[authState2.getState().ordinal()];
                if (i2 == 1) {
                    cache(authCache, httpHost2, authState2.getAuthScheme());
                } else if (i2 == 2) {
                    uncache(authCache, httpHost2, authState2.getAuthScheme());
                }
            }
        }
    }

    /* renamed from: cz.msebera.android.httpclient.client.protocol.ResponseAuthCache$1 */
    static /* synthetic */ class C43411 {
        static final /* synthetic */ int[] $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState = new int[AuthProtocolState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                cz.msebera.android.httpclient.auth.AuthProtocolState[] r0 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState = r0
                int[] r0 = $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState     // Catch:{ NoSuchFieldError -> 0x0014 }
                cz.msebera.android.httpclient.auth.AuthProtocolState r1 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.CHALLENGED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState     // Catch:{ NoSuchFieldError -> 0x001f }
                cz.msebera.android.httpclient.auth.AuthProtocolState r1 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.FAILURE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.client.protocol.ResponseAuthCache.C43411.<clinit>():void");
        }
    }

    private boolean isCachable(AuthState authState) {
        AuthScheme authScheme = authState.getAuthScheme();
        if (authScheme == null || !authScheme.isComplete()) {
            return false;
        }
        String schemeName = authScheme.getSchemeName();
        if (schemeName.equalsIgnoreCase("Basic") || schemeName.equalsIgnoreCase("Digest")) {
            return true;
        }
        return false;
    }

    private void cache(AuthCache authCache, HttpHost httpHost, AuthScheme authScheme) {
        if (this.log.isDebugEnabled()) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.debug("Caching '" + authScheme.getSchemeName() + "' auth scheme for " + httpHost);
        }
        authCache.put(httpHost, authScheme);
    }

    private void uncache(AuthCache authCache, HttpHost httpHost, AuthScheme authScheme) {
        if (this.log.isDebugEnabled()) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.debug("Removing from cache '" + authScheme.getSchemeName() + "' auth scheme for " + httpHost);
        }
        authCache.remove(httpHost);
    }
}
