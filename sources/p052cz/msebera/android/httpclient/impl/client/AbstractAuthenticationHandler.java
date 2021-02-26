package p052cz.msebera.android.httpclient.impl.client;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p052cz.msebera.android.httpclient.FormattedHeader;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.auth.AuthScheme;
import p052cz.msebera.android.httpclient.auth.AuthSchemeRegistry;
import p052cz.msebera.android.httpclient.auth.AuthenticationException;
import p052cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p052cz.msebera.android.httpclient.client.AuthenticationHandler;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.protocol.HTTP;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Asserts;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;

@Immutable
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.AbstractAuthenticationHandler */
public abstract class AbstractAuthenticationHandler implements AuthenticationHandler {
    private static final List<String> DEFAULT_SCHEME_PRIORITY = Collections.unmodifiableList(Arrays.asList(new String[]{"negotiate", "NTLM", "Digest", "Basic"}));
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    /* access modifiers changed from: protected */
    public Map<String, Header> parseChallenges(Header[] headerArr) throws MalformedChallengeException {
        CharArrayBuffer charArrayBuffer;
        int i;
        HashMap hashMap = new HashMap(headerArr.length);
        for (FormattedHeader formattedHeader : headerArr) {
            if (formattedHeader instanceof FormattedHeader) {
                FormattedHeader formattedHeader2 = formattedHeader;
                charArrayBuffer = formattedHeader2.getBuffer();
                i = formattedHeader2.getValuePos();
            } else {
                String value = formattedHeader.getValue();
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
            hashMap.put(charArrayBuffer.substring(i, i2).toLowerCase(Locale.ENGLISH), formattedHeader);
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public List<String> getAuthPreferences() {
        return DEFAULT_SCHEME_PRIORITY;
    }

    /* access modifiers changed from: protected */
    public List<String> getAuthPreferences(HttpResponse httpResponse, HttpContext httpContext) {
        return getAuthPreferences();
    }

    public AuthScheme selectScheme(Map<String, Header> map, HttpResponse httpResponse, HttpContext httpContext) throws AuthenticationException {
        AuthSchemeRegistry authSchemeRegistry = (AuthSchemeRegistry) httpContext.getAttribute("http.authscheme-registry");
        Asserts.notNull(authSchemeRegistry, "AuthScheme registry");
        List<String> authPreferences = getAuthPreferences(httpResponse, httpContext);
        if (authPreferences == null) {
            authPreferences = DEFAULT_SCHEME_PRIORITY;
        }
        if (this.log.isDebugEnabled()) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.debug("Authentication schemes in the order of preference: " + authPreferences);
        }
        AuthScheme authScheme = null;
        Iterator<String> it = authPreferences.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (map.get(next.toLowerCase(Locale.ENGLISH)) != null) {
                if (this.log.isDebugEnabled()) {
                    HttpClientAndroidLog httpClientAndroidLog2 = this.log;
                    httpClientAndroidLog2.debug(next + " authentication scheme selected");
                }
                try {
                    authScheme = authSchemeRegistry.getAuthScheme(next, httpResponse.getParams());
                    break;
                } catch (IllegalStateException unused) {
                    if (this.log.isWarnEnabled()) {
                        HttpClientAndroidLog httpClientAndroidLog3 = this.log;
                        httpClientAndroidLog3.warn("Authentication scheme " + next + " not supported");
                    }
                }
            } else if (this.log.isDebugEnabled()) {
                HttpClientAndroidLog httpClientAndroidLog4 = this.log;
                httpClientAndroidLog4.debug("Challenge for " + next + " authentication scheme not available");
            }
        }
        if (authScheme != null) {
            return authScheme;
        }
        throw new AuthenticationException("Unable to respond to any of these challenges: " + map);
    }
}
