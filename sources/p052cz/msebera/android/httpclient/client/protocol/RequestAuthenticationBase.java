package p052cz.msebera.android.httpclient.client.protocol;

import java.util.Queue;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpRequestInterceptor;
import p052cz.msebera.android.httpclient.auth.AuthOption;
import p052cz.msebera.android.httpclient.auth.AuthProtocolState;
import p052cz.msebera.android.httpclient.auth.AuthScheme;
import p052cz.msebera.android.httpclient.auth.AuthState;
import p052cz.msebera.android.httpclient.auth.AuthenticationException;
import p052cz.msebera.android.httpclient.auth.ContextAwareAuthScheme;
import p052cz.msebera.android.httpclient.auth.Credentials;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Asserts;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.client.protocol.RequestAuthenticationBase */
abstract class RequestAuthenticationBase implements HttpRequestInterceptor {
    final HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    /* access modifiers changed from: package-private */
    public void process(AuthState authState, HttpRequest httpRequest, HttpContext httpContext) {
        AuthScheme authScheme = authState.getAuthScheme();
        Credentials credentials = authState.getCredentials();
        int i = C43401.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[authState.getState().ordinal()];
        if (i != 1) {
            if (i == 2) {
                ensureAuthScheme(authScheme);
                if (authScheme.isConnectionBased()) {
                    return;
                }
            } else if (i == 3) {
                Queue<AuthOption> authOptions = authState.getAuthOptions();
                if (authOptions != null) {
                    while (!authOptions.isEmpty()) {
                        AuthOption remove = authOptions.remove();
                        AuthScheme authScheme2 = remove.getAuthScheme();
                        Credentials credentials2 = remove.getCredentials();
                        authState.update(authScheme2, credentials2);
                        if (this.log.isDebugEnabled()) {
                            HttpClientAndroidLog httpClientAndroidLog = this.log;
                            httpClientAndroidLog.debug("Generating response to an authentication challenge using " + authScheme2.getSchemeName() + " scheme");
                        }
                        try {
                            httpRequest.addHeader(authenticate(authScheme2, credentials2, httpRequest, httpContext));
                            return;
                        } catch (AuthenticationException e) {
                            if (this.log.isWarnEnabled()) {
                                HttpClientAndroidLog httpClientAndroidLog2 = this.log;
                                httpClientAndroidLog2.warn(authScheme2 + " authentication error: " + e.getMessage());
                            }
                        }
                    }
                    return;
                }
                ensureAuthScheme(authScheme);
            }
            if (authScheme != null) {
                try {
                    httpRequest.addHeader(authenticate(authScheme, credentials, httpRequest, httpContext));
                } catch (AuthenticationException e2) {
                    if (this.log.isErrorEnabled()) {
                        HttpClientAndroidLog httpClientAndroidLog3 = this.log;
                        httpClientAndroidLog3.error(authScheme + " authentication error: " + e2.getMessage());
                    }
                }
            }
        }
    }

    /* renamed from: cz.msebera.android.httpclient.client.protocol.RequestAuthenticationBase$1 */
    static /* synthetic */ class C43401 {
        static final /* synthetic */ int[] $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState = new int[AuthProtocolState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                cz.msebera.android.httpclient.auth.AuthProtocolState[] r0 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState = r0
                int[] r0 = $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState     // Catch:{ NoSuchFieldError -> 0x0014 }
                cz.msebera.android.httpclient.auth.AuthProtocolState r1 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.FAILURE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState     // Catch:{ NoSuchFieldError -> 0x001f }
                cz.msebera.android.httpclient.auth.AuthProtocolState r1 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.SUCCESS     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState     // Catch:{ NoSuchFieldError -> 0x002a }
                cz.msebera.android.httpclient.auth.AuthProtocolState r1 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.CHALLENGED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.client.protocol.RequestAuthenticationBase.C43401.<clinit>():void");
        }
    }

    private void ensureAuthScheme(AuthScheme authScheme) {
        Asserts.notNull(authScheme, "Auth scheme");
    }

    private Header authenticate(AuthScheme authScheme, Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        Asserts.notNull(authScheme, "Auth scheme");
        if (authScheme instanceof ContextAwareAuthScheme) {
            return ((ContextAwareAuthScheme) authScheme).authenticate(credentials, httpRequest, httpContext);
        }
        return authScheme.authenticate(credentials, httpRequest);
    }
}
