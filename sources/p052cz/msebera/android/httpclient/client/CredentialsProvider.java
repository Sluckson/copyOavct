package p052cz.msebera.android.httpclient.client;

import p052cz.msebera.android.httpclient.auth.AuthScope;
import p052cz.msebera.android.httpclient.auth.Credentials;

/* renamed from: cz.msebera.android.httpclient.client.CredentialsProvider */
public interface CredentialsProvider {
    void clear();

    Credentials getCredentials(AuthScope authScope);

    void setCredentials(AuthScope authScope, Credentials credentials);
}
