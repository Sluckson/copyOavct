package p052cz.msebera.android.httpclient.impl.auth;

import java.io.IOException;
import java.util.Queue;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.auth.AuthOption;
import p052cz.msebera.android.httpclient.auth.AuthProtocolState;
import p052cz.msebera.android.httpclient.auth.AuthScheme;
import p052cz.msebera.android.httpclient.auth.AuthState;
import p052cz.msebera.android.httpclient.auth.AuthenticationException;
import p052cz.msebera.android.httpclient.auth.ContextAwareAuthScheme;
import p052cz.msebera.android.httpclient.auth.Credentials;
import p052cz.msebera.android.httpclient.client.AuthenticationStrategy;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Asserts;

/* renamed from: cz.msebera.android.httpclient.impl.auth.HttpAuthenticator */
public class HttpAuthenticator {
    public HttpClientAndroidLog log;

    public HttpAuthenticator(HttpClientAndroidLog httpClientAndroidLog) {
        this.log = httpClientAndroidLog == null ? new HttpClientAndroidLog(getClass()) : httpClientAndroidLog;
    }

    public HttpAuthenticator() {
        this((HttpClientAndroidLog) null);
    }

    public boolean isAuthenticationRequested(HttpHost httpHost, HttpResponse httpResponse, AuthenticationStrategy authenticationStrategy, AuthState authState, HttpContext httpContext) {
        if (authenticationStrategy.isAuthenticationRequested(httpHost, httpResponse, httpContext)) {
            this.log.debug("Authentication required");
            if (authState.getState() == AuthProtocolState.SUCCESS) {
                authenticationStrategy.authFailed(httpHost, authState.getAuthScheme(), httpContext);
            }
            return true;
        }
        int i = C43471.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[authState.getState().ordinal()];
        if (i == 1 || i == 2) {
            this.log.debug("Authentication succeeded");
            authState.setState(AuthProtocolState.SUCCESS);
            authenticationStrategy.authSucceeded(httpHost, authState.getAuthScheme(), httpContext);
            return false;
        } else if (i == 3) {
            return false;
        } else {
            authState.setState(AuthProtocolState.UNCHALLENGED);
            return false;
        }
    }

    /* renamed from: cz.msebera.android.httpclient.impl.auth.HttpAuthenticator$1 */
    static /* synthetic */ class C43471 {
        static final /* synthetic */ int[] $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState = new int[AuthProtocolState.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                cz.msebera.android.httpclient.auth.AuthProtocolState[] r0 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState = r0
                int[] r0 = $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState     // Catch:{ NoSuchFieldError -> 0x0014 }
                cz.msebera.android.httpclient.auth.AuthProtocolState r1 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.CHALLENGED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState     // Catch:{ NoSuchFieldError -> 0x001f }
                cz.msebera.android.httpclient.auth.AuthProtocolState r1 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.HANDSHAKE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState     // Catch:{ NoSuchFieldError -> 0x002a }
                cz.msebera.android.httpclient.auth.AuthProtocolState r1 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.SUCCESS     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState     // Catch:{ NoSuchFieldError -> 0x0035 }
                cz.msebera.android.httpclient.auth.AuthProtocolState r1 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.FAILURE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState     // Catch:{ NoSuchFieldError -> 0x0040 }
                cz.msebera.android.httpclient.auth.AuthProtocolState r1 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.UNCHALLENGED     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.auth.HttpAuthenticator.C43471.<clinit>():void");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c0 A[Catch:{ MalformedChallengeException -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e7 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleAuthChallenge(p052cz.msebera.android.httpclient.HttpHost r7, p052cz.msebera.android.httpclient.HttpResponse r8, p052cz.msebera.android.httpclient.client.AuthenticationStrategy r9, p052cz.msebera.android.httpclient.auth.AuthState r10, p052cz.msebera.android.httpclient.protocol.HttpContext r11) {
        /*
            r6 = this;
            r0 = 0
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r1 = r6.log     // Catch:{ MalformedChallengeException -> 0x00e8 }
            boolean r1 = r1.isDebugEnabled()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            if (r1 == 0) goto L_0x0023
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r1 = r6.log     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r2.<init>()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r3 = r7.toHostString()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r2.append(r3)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r3 = " requested authentication"
            r2.append(r3)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r2 = r2.toString()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r1.debug(r2)     // Catch:{ MalformedChallengeException -> 0x00e8 }
        L_0x0023:
            java.util.Map r1 = r9.getChallenges(r7, r8, r11)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            boolean r2 = r1.isEmpty()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            if (r2 == 0) goto L_0x0035
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r7 = r6.log     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r8 = "Response contains no authentication challenges"
            r7.debug(r8)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            return r0
        L_0x0035:
            cz.msebera.android.httpclient.auth.AuthScheme r2 = r10.getAuthScheme()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            int[] r3 = p052cz.msebera.android.httpclient.impl.auth.HttpAuthenticator.C43471.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState     // Catch:{ MalformedChallengeException -> 0x00e8 }
            cz.msebera.android.httpclient.auth.AuthProtocolState r4 = r10.getState()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            int r4 = r4.ordinal()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r3 = r3[r4]     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r4 = 1
            if (r3 == r4) goto L_0x005a
            r5 = 2
            if (r3 == r5) goto L_0x005a
            r5 = 3
            if (r3 == r5) goto L_0x0056
            r5 = 4
            if (r3 == r5) goto L_0x0055
            r5 = 5
            if (r3 == r5) goto L_0x0070
            goto L_0x00b4
        L_0x0055:
            return r0
        L_0x0056:
            r10.reset()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            goto L_0x00b4
        L_0x005a:
            if (r2 != 0) goto L_0x0070
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r8 = r6.log     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r1 = "Auth scheme is null"
            r8.debug(r1)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r8 = 0
            r9.authFailed(r7, r8, r11)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r10.reset()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            cz.msebera.android.httpclient.auth.AuthProtocolState r7 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.FAILURE     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r10.setState(r7)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            return r0
        L_0x0070:
            if (r2 == 0) goto L_0x00b4
            java.lang.String r3 = r2.getSchemeName()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.util.Locale r5 = java.util.Locale.ENGLISH     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r3 = r3.toLowerCase(r5)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            cz.msebera.android.httpclient.Header r3 = (p052cz.msebera.android.httpclient.Header) r3     // Catch:{ MalformedChallengeException -> 0x00e8 }
            if (r3 == 0) goto L_0x00b1
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r8 = r6.log     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r1 = "Authorization challenge processed"
            r8.debug(r1)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r2.processChallenge(r3)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            boolean r8 = r2.isComplete()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            if (r8 == 0) goto L_0x00ab
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r8 = r6.log     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r1 = "Authentication failed"
            r8.debug(r1)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            cz.msebera.android.httpclient.auth.AuthScheme r8 = r10.getAuthScheme()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r9.authFailed(r7, r8, r11)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r10.reset()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            cz.msebera.android.httpclient.auth.AuthProtocolState r7 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.FAILURE     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r10.setState(r7)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            return r0
        L_0x00ab:
            cz.msebera.android.httpclient.auth.AuthProtocolState r7 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.HANDSHAKE     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r10.setState(r7)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            return r4
        L_0x00b1:
            r10.reset()     // Catch:{ MalformedChallengeException -> 0x00e8 }
        L_0x00b4:
            java.util.Queue r7 = r9.select(r1, r7, r8, r11)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            if (r7 == 0) goto L_0x00e7
            boolean r8 = r7.isEmpty()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            if (r8 != 0) goto L_0x00e7
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r8 = r6.log     // Catch:{ MalformedChallengeException -> 0x00e8 }
            boolean r8 = r8.isDebugEnabled()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            if (r8 == 0) goto L_0x00de
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r8 = r6.log     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r9.<init>()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r11 = "Selected authentication options: "
            r9.append(r11)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r9.append(r7)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            java.lang.String r9 = r9.toString()     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r8.debug(r9)     // Catch:{ MalformedChallengeException -> 0x00e8 }
        L_0x00de:
            cz.msebera.android.httpclient.auth.AuthProtocolState r8 = p052cz.msebera.android.httpclient.auth.AuthProtocolState.CHALLENGED     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r10.setState(r8)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            r10.update(r7)     // Catch:{ MalformedChallengeException -> 0x00e8 }
            return r4
        L_0x00e7:
            return r0
        L_0x00e8:
            r7 = move-exception
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r8 = r6.log
            boolean r8 = r8.isWarnEnabled()
            if (r8 == 0) goto L_0x010b
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r8 = r6.log
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r11 = "Malformed challenge: "
            r9.append(r11)
            java.lang.String r7 = r7.getMessage()
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r8.warn(r7)
        L_0x010b:
            r10.reset()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.auth.HttpAuthenticator.handleAuthChallenge(cz.msebera.android.httpclient.HttpHost, cz.msebera.android.httpclient.HttpResponse, cz.msebera.android.httpclient.client.AuthenticationStrategy, cz.msebera.android.httpclient.auth.AuthState, cz.msebera.android.httpclient.protocol.HttpContext):boolean");
    }

    public void generateAuthResponse(HttpRequest httpRequest, AuthState authState, HttpContext httpContext) throws HttpException, IOException {
        AuthScheme authScheme = authState.getAuthScheme();
        Credentials credentials = authState.getCredentials();
        int i = C43471.$SwitchMap$cz$msebera$android$httpclient$auth$AuthProtocolState[authState.getState().ordinal()];
        if (i == 1) {
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
                        httpRequest.addHeader(doAuth(authScheme2, credentials2, httpRequest, httpContext));
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
        } else if (i == 3) {
            ensureAuthScheme(authScheme);
            if (authScheme.isConnectionBased()) {
                return;
            }
        } else if (i == 4) {
            return;
        }
        if (authScheme != null) {
            try {
                httpRequest.addHeader(doAuth(authScheme, credentials, httpRequest, httpContext));
            } catch (AuthenticationException e2) {
                if (this.log.isErrorEnabled()) {
                    HttpClientAndroidLog httpClientAndroidLog3 = this.log;
                    httpClientAndroidLog3.error(authScheme + " authentication error: " + e2.getMessage());
                }
            }
        }
    }

    private void ensureAuthScheme(AuthScheme authScheme) {
        Asserts.notNull(authScheme, "Auth scheme");
    }

    private Header doAuth(AuthScheme authScheme, Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        if (authScheme instanceof ContextAwareAuthScheme) {
            return ((ContextAwareAuthScheme) authScheme).authenticate(credentials, httpRequest, httpContext);
        }
        return authScheme.authenticate(credentials, httpRequest);
    }
}
