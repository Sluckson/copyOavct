package p052cz.msebera.android.httpclient.impl.client;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import p052cz.msebera.android.httpclient.FormattedHeader;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.auth.AuthOption;
import p052cz.msebera.android.httpclient.auth.AuthScheme;
import p052cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import p052cz.msebera.android.httpclient.auth.AuthScope;
import p052cz.msebera.android.httpclient.auth.Credentials;
import p052cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p052cz.msebera.android.httpclient.client.AuthCache;
import p052cz.msebera.android.httpclient.client.AuthenticationStrategy;
import p052cz.msebera.android.httpclient.client.CredentialsProvider;
import p052cz.msebera.android.httpclient.client.config.RequestConfig;
import p052cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import p052cz.msebera.android.httpclient.config.Lookup;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.protocol.HTTP;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.AuthenticationStrategyImpl */
abstract class AuthenticationStrategyImpl implements AuthenticationStrategy {
    private static final List<String> DEFAULT_SCHEME_PRIORITY = Collections.unmodifiableList(Arrays.asList(new String[]{"negotiate", "Kerberos", "NTLM", "Digest", "Basic"}));
    private final int challengeCode;
    private final String headerName;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    /* access modifiers changed from: package-private */
    public abstract Collection<String> getPreferredAuthSchemes(RequestConfig requestConfig);

    AuthenticationStrategyImpl(int i, String str) {
        this.challengeCode = i;
        this.headerName = str;
    }

    public boolean isAuthenticationRequested(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        return httpResponse.getStatusLine().getStatusCode() == this.challengeCode;
    }

    public Map<String, Header> getChallenges(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException {
        CharArrayBuffer charArrayBuffer;
        int i;
        Args.notNull(httpResponse, "HTTP response");
        Header[] headers = httpResponse.getHeaders(this.headerName);
        HashMap hashMap = new HashMap(headers.length);
        for (Header header : headers) {
            if (header instanceof FormattedHeader) {
                FormattedHeader formattedHeader = (FormattedHeader) header;
                charArrayBuffer = formattedHeader.getBuffer();
                i = formattedHeader.getValuePos();
            } else {
                String value = header.getValue();
                if (value != null) {
                    charArrayBuffer = new CharArrayBuffer(value.length());
                    charArrayBuffer.append(value);
                    i = 0;
                } else {
                    throw new MalformedChallengeException("Header value is null");
                }
            }
            while (i < charArrayBuffer.length() && HTTP.isWhitespace(charArrayBuffer.charAt(i))) {
                i++;
            }
            int i2 = i;
            while (i2 < charArrayBuffer.length() && !HTTP.isWhitespace(charArrayBuffer.charAt(i2))) {
                i2++;
            }
            hashMap.put(charArrayBuffer.substring(i, i2).toLowerCase(Locale.ENGLISH), header);
        }
        return hashMap;
    }

    public Queue<AuthOption> select(Map<String, Header> map, HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException {
        Args.notNull(map, "Map of auth challenges");
        Args.notNull(httpHost, "Host");
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext adapt = HttpClientContext.adapt(httpContext);
        LinkedList linkedList = new LinkedList();
        Lookup<AuthSchemeProvider> authSchemeRegistry = adapt.getAuthSchemeRegistry();
        if (authSchemeRegistry == null) {
            this.log.debug("Auth scheme registry not set in the context");
            return linkedList;
        }
        CredentialsProvider credentialsProvider = adapt.getCredentialsProvider();
        if (credentialsProvider == null) {
            this.log.debug("Credentials provider not set in the context");
            return linkedList;
        }
        Collection<String> preferredAuthSchemes = getPreferredAuthSchemes(adapt.getRequestConfig());
        if (preferredAuthSchemes == null) {
            preferredAuthSchemes = DEFAULT_SCHEME_PRIORITY;
        }
        if (this.log.isDebugEnabled()) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.debug("Authentication schemes in the order of preference: " + preferredAuthSchemes);
        }
        for (String str : preferredAuthSchemes) {
            Header header = map.get(str.toLowerCase(Locale.ENGLISH));
            if (header != null) {
                AuthSchemeProvider lookup = authSchemeRegistry.lookup(str);
                if (lookup != null) {
                    AuthScheme create = lookup.create(httpContext);
                    create.processChallenge(header);
                    Credentials credentials = credentialsProvider.getCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort(), create.getRealm(), create.getSchemeName()));
                    if (credentials != null) {
                        linkedList.add(new AuthOption(create, credentials));
                    }
                } else if (this.log.isWarnEnabled()) {
                    HttpClientAndroidLog httpClientAndroidLog2 = this.log;
                    httpClientAndroidLog2.warn("Authentication scheme " + str + " not supported");
                }
            } else if (this.log.isDebugEnabled()) {
                HttpClientAndroidLog httpClientAndroidLog3 = this.log;
                httpClientAndroidLog3.debug("Challenge for " + str + " authentication scheme not available");
            }
        }
        return linkedList;
    }

    public void authSucceeded(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext) {
        Args.notNull(httpHost, "Host");
        Args.notNull(authScheme, "Auth scheme");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext adapt = HttpClientContext.adapt(httpContext);
        if (isCachable(authScheme)) {
            AuthCache authCache = adapt.getAuthCache();
            if (authCache == null) {
                authCache = new BasicAuthCache();
                adapt.setAuthCache(authCache);
            }
            if (this.log.isDebugEnabled()) {
                HttpClientAndroidLog httpClientAndroidLog = this.log;
                httpClientAndroidLog.debug("Caching '" + authScheme.getSchemeName() + "' auth scheme for " + httpHost);
            }
            authCache.put(httpHost, authScheme);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isCachable(AuthScheme authScheme) {
        if (authScheme == null || !authScheme.isComplete()) {
            return false;
        }
        String schemeName = authScheme.getSchemeName();
        if (schemeName.equalsIgnoreCase("Basic") || schemeName.equalsIgnoreCase("Digest")) {
            return true;
        }
        return false;
    }

    public void authFailed(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext) {
        Args.notNull(httpHost, "Host");
        Args.notNull(httpContext, "HTTP context");
        AuthCache authCache = HttpClientContext.adapt(httpContext).getAuthCache();
        if (authCache != null) {
            if (this.log.isDebugEnabled()) {
                HttpClientAndroidLog httpClientAndroidLog = this.log;
                httpClientAndroidLog.debug("Clearing cached auth scheme for " + httpHost);
            }
            authCache.remove(httpHost);
        }
    }
}
