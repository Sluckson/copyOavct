package p052cz.msebera.android.httpclient.impl.client;

import java.security.Principal;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.auth.AuthScheme;
import p052cz.msebera.android.httpclient.auth.AuthState;
import p052cz.msebera.android.httpclient.auth.Credentials;
import p052cz.msebera.android.httpclient.client.UserTokenHandler;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.DefaultUserTokenHandler */
public class DefaultUserTokenHandler implements UserTokenHandler {
    public static final DefaultUserTokenHandler INSTANCE = new DefaultUserTokenHandler();

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r3 = ((p052cz.msebera.android.httpclient.conn.ManagedHttpClientConnection) r3).getSSLSession();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getUserToken(p052cz.msebera.android.httpclient.protocol.HttpContext r3) {
        /*
            r2 = this;
            cz.msebera.android.httpclient.client.protocol.HttpClientContext r3 = p052cz.msebera.android.httpclient.client.protocol.HttpClientContext.adapt(r3)
            cz.msebera.android.httpclient.auth.AuthState r0 = r3.getTargetAuthState()
            if (r0 == 0) goto L_0x0019
            java.security.Principal r0 = getAuthPrincipal(r0)
            if (r0 != 0) goto L_0x001a
            cz.msebera.android.httpclient.auth.AuthState r0 = r3.getProxyAuthState()
            java.security.Principal r0 = getAuthPrincipal(r0)
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            if (r0 != 0) goto L_0x0036
            cz.msebera.android.httpclient.HttpConnection r3 = r3.getConnection()
            boolean r1 = r3.isOpen()
            if (r1 == 0) goto L_0x0036
            boolean r1 = r3 instanceof p052cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
            if (r1 == 0) goto L_0x0036
            cz.msebera.android.httpclient.conn.ManagedHttpClientConnection r3 = (p052cz.msebera.android.httpclient.conn.ManagedHttpClientConnection) r3
            javax.net.ssl.SSLSession r3 = r3.getSSLSession()
            if (r3 == 0) goto L_0x0036
            java.security.Principal r0 = r3.getLocalPrincipal()
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.client.DefaultUserTokenHandler.getUserToken(cz.msebera.android.httpclient.protocol.HttpContext):java.lang.Object");
    }

    private static Principal getAuthPrincipal(AuthState authState) {
        Credentials credentials;
        AuthScheme authScheme = authState.getAuthScheme();
        if (authScheme == null || !authScheme.isComplete() || !authScheme.isConnectionBased() || (credentials = authState.getCredentials()) == null) {
            return null;
        }
        return credentials.getUserPrincipal();
    }
}
