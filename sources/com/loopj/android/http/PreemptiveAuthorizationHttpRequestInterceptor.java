package com.loopj.android.http;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpRequestInterceptor;
import p052cz.msebera.android.httpclient.auth.AuthScope;
import p052cz.msebera.android.httpclient.auth.AuthState;
import p052cz.msebera.android.httpclient.auth.Credentials;
import p052cz.msebera.android.httpclient.client.CredentialsProvider;
import p052cz.msebera.android.httpclient.impl.auth.BasicScheme;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

public class PreemptiveAuthorizationHttpRequestInterceptor implements HttpRequestInterceptor {
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Credentials credentials;
        AuthState authState = (AuthState) httpContext.getAttribute("http.auth.target-scope");
        CredentialsProvider credentialsProvider = (CredentialsProvider) httpContext.getAttribute("http.auth.credentials-provider");
        HttpHost httpHost = (HttpHost) httpContext.getAttribute("http.target_host");
        if (authState.getAuthScheme() == null && (credentials = credentialsProvider.getCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort()))) != null) {
            authState.setAuthScheme(new BasicScheme());
            authState.setCredentials(credentials);
        }
    }
}
