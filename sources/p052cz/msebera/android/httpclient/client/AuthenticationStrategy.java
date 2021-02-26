package p052cz.msebera.android.httpclient.client;

import java.util.Map;
import java.util.Queue;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.auth.AuthOption;
import p052cz.msebera.android.httpclient.auth.AuthScheme;
import p052cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

/* renamed from: cz.msebera.android.httpclient.client.AuthenticationStrategy */
public interface AuthenticationStrategy {
    void authFailed(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext);

    void authSucceeded(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext);

    Map<String, Header> getChallenges(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException;

    boolean isAuthenticationRequested(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext);

    Queue<AuthOption> select(Map<String, Header> map, HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException;
}
