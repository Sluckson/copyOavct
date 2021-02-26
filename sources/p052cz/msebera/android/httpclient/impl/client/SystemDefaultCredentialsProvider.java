package p052cz.msebera.android.httpclient.impl.client;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.auth.AuthScope;
import p052cz.msebera.android.httpclient.auth.Credentials;
import p052cz.msebera.android.httpclient.auth.NTCredentials;
import p052cz.msebera.android.httpclient.auth.UsernamePasswordCredentials;
import p052cz.msebera.android.httpclient.client.CredentialsProvider;
import p052cz.msebera.android.httpclient.util.Args;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.client.SystemDefaultCredentialsProvider */
public class SystemDefaultCredentialsProvider implements CredentialsProvider {
    private static final Map<String, String> SCHEME_MAP = new ConcurrentHashMap();
    private final BasicCredentialsProvider internal = new BasicCredentialsProvider();

    static {
        SCHEME_MAP.put("Basic".toUpperCase(Locale.ENGLISH), "Basic");
        SCHEME_MAP.put("Digest".toUpperCase(Locale.ENGLISH), "Digest");
        SCHEME_MAP.put("NTLM".toUpperCase(Locale.ENGLISH), "NTLM");
        SCHEME_MAP.put("negotiate".toUpperCase(Locale.ENGLISH), "SPNEGO");
        SCHEME_MAP.put("Kerberos".toUpperCase(Locale.ENGLISH), "Kerberos");
    }

    private static String translateScheme(String str) {
        if (str == null) {
            return null;
        }
        String str2 = SCHEME_MAP.get(str);
        return str2 != null ? str2 : str;
    }

    public void setCredentials(AuthScope authScope, Credentials credentials) {
        this.internal.setCredentials(authScope, credentials);
    }

    private static PasswordAuthentication getSystemCreds(AuthScope authScope, Authenticator.RequestorType requestorType) {
        String host = authScope.getHost();
        int port = authScope.getPort();
        return Authenticator.requestPasswordAuthentication(host, (InetAddress) null, port, port == 443 ? "https" : HttpHost.DEFAULT_SCHEME_NAME, (String) null, translateScheme(authScope.getScheme()), (URL) null, requestorType);
    }

    public Credentials getCredentials(AuthScope authScope) {
        Args.notNull(authScope, "Auth scope");
        Credentials credentials = this.internal.getCredentials(authScope);
        if (credentials != null) {
            return credentials;
        }
        if (authScope.getHost() != null) {
            PasswordAuthentication systemCreds = getSystemCreds(authScope, Authenticator.RequestorType.SERVER);
            if (systemCreds == null) {
                systemCreds = getSystemCreds(authScope, Authenticator.RequestorType.PROXY);
            }
            if (systemCreds != null) {
                String property = System.getProperty("http.auth.ntlm.domain");
                if (property != null) {
                    return new NTCredentials(systemCreds.getUserName(), new String(systemCreds.getPassword()), (String) null, property);
                }
                if ("NTLM".equalsIgnoreCase(authScope.getScheme())) {
                    return new NTCredentials(systemCreds.getUserName(), new String(systemCreds.getPassword()), (String) null, (String) null);
                }
                return new UsernamePasswordCredentials(systemCreds.getUserName(), new String(systemCreds.getPassword()));
            }
        }
        return null;
    }

    public void clear() {
        this.internal.clear();
    }
}
