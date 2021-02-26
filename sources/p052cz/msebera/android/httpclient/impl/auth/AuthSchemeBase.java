package p052cz.msebera.android.httpclient.impl.auth;

import java.util.Locale;
import p052cz.msebera.android.httpclient.FormattedHeader;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.auth.AuthenticationException;
import p052cz.msebera.android.httpclient.auth.ChallengeState;
import p052cz.msebera.android.httpclient.auth.ContextAwareAuthScheme;
import p052cz.msebera.android.httpclient.auth.Credentials;
import p052cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p052cz.msebera.android.httpclient.protocol.HTTP;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.auth.AuthSchemeBase */
public abstract class AuthSchemeBase implements ContextAwareAuthScheme {
    private ChallengeState challengeState;

    /* access modifiers changed from: protected */
    public abstract void parseChallenge(CharArrayBuffer charArrayBuffer, int i, int i2) throws MalformedChallengeException;

    @Deprecated
    public AuthSchemeBase(ChallengeState challengeState2) {
        this.challengeState = challengeState2;
    }

    public AuthSchemeBase() {
    }

    public void processChallenge(Header header) throws MalformedChallengeException {
        int i;
        CharArrayBuffer charArrayBuffer;
        Args.notNull(header, "Header");
        String name = header.getName();
        if (name.equalsIgnoreCase("WWW-Authenticate")) {
            this.challengeState = ChallengeState.TARGET;
        } else if (name.equalsIgnoreCase("Proxy-Authenticate")) {
            this.challengeState = ChallengeState.PROXY;
        } else {
            throw new MalformedChallengeException("Unexpected header name: " + name);
        }
        if (header instanceof FormattedHeader) {
            FormattedHeader formattedHeader = (FormattedHeader) header;
            charArrayBuffer = formattedHeader.getBuffer();
            i = formattedHeader.getValuePos();
        } else {
            String value = header.getValue();
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
        String substring = charArrayBuffer.substring(i, i2);
        if (substring.equalsIgnoreCase(getSchemeName())) {
            parseChallenge(charArrayBuffer, i2, charArrayBuffer.length());
            return;
        }
        throw new MalformedChallengeException("Invalid scheme identifier: " + substring);
    }

    public Header authenticate(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        return authenticate(credentials, httpRequest);
    }

    public boolean isProxy() {
        ChallengeState challengeState2 = this.challengeState;
        return challengeState2 != null && challengeState2 == ChallengeState.PROXY;
    }

    public ChallengeState getChallengeState() {
        return this.challengeState;
    }

    public String toString() {
        String schemeName = getSchemeName();
        if (schemeName != null) {
            return schemeName.toUpperCase(Locale.ENGLISH);
        }
        return super.toString();
    }
}
