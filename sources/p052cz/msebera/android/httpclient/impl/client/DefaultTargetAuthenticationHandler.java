package p052cz.msebera.android.httpclient.impl.client;

import java.util.List;
import java.util.Map;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p052cz.msebera.android.httpclient.auth.params.AuthPNames;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.DefaultTargetAuthenticationHandler */
public class DefaultTargetAuthenticationHandler extends AbstractAuthenticationHandler {
    public boolean isAuthenticationRequested(HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        return httpResponse.getStatusLine().getStatusCode() == 401;
    }

    public Map<String, Header> getChallenges(HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException {
        Args.notNull(httpResponse, "HTTP response");
        return parseChallenges(httpResponse.getHeaders("WWW-Authenticate"));
    }

    /* access modifiers changed from: protected */
    public List<String> getAuthPreferences(HttpResponse httpResponse, HttpContext httpContext) {
        List<String> list = (List) httpResponse.getParams().getParameter(AuthPNames.TARGET_AUTH_PREF);
        if (list != null) {
            return list;
        }
        return super.getAuthPreferences(httpResponse, httpContext);
    }
}
