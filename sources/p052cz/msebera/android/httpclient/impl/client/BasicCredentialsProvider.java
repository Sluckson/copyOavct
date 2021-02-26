package p052cz.msebera.android.httpclient.impl.client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.auth.AuthScope;
import p052cz.msebera.android.httpclient.auth.Credentials;
import p052cz.msebera.android.httpclient.client.CredentialsProvider;
import p052cz.msebera.android.httpclient.util.Args;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.client.BasicCredentialsProvider */
public class BasicCredentialsProvider implements CredentialsProvider {
    private final ConcurrentHashMap<AuthScope, Credentials> credMap = new ConcurrentHashMap<>();

    public void setCredentials(AuthScope authScope, Credentials credentials) {
        Args.notNull(authScope, "Authentication scope");
        this.credMap.put(authScope, credentials);
    }

    private static Credentials matchCredentials(Map<AuthScope, Credentials> map, AuthScope authScope) {
        Credentials credentials = map.get(authScope);
        if (credentials != null) {
            return credentials;
        }
        int i = -1;
        AuthScope authScope2 = null;
        for (AuthScope next : map.keySet()) {
            int match = authScope.match(next);
            if (match > i) {
                authScope2 = next;
                i = match;
            }
        }
        return authScope2 != null ? map.get(authScope2) : credentials;
    }

    public Credentials getCredentials(AuthScope authScope) {
        Args.notNull(authScope, "Authentication scope");
        return matchCredentials(this.credMap, authScope);
    }

    public void clear() {
        this.credMap.clear();
    }

    public String toString() {
        return this.credMap.toString();
    }
}
