package p052cz.msebera.android.httpclient.impl.auth;

import java.nio.charset.Charset;
import p052cz.msebera.android.httpclient.Consts;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.auth.AuthenticationException;
import p052cz.msebera.android.httpclient.auth.ChallengeState;
import p052cz.msebera.android.httpclient.auth.Credentials;
import p052cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p052cz.msebera.android.httpclient.extras.Base64;
import p052cz.msebera.android.httpclient.message.BufferedHeader;
import p052cz.msebera.android.httpclient.protocol.BasicHttpContext;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;
import p052cz.msebera.android.httpclient.util.EncodingUtils;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.auth.BasicScheme */
public class BasicScheme extends RFC2617Scheme {
    private boolean complete;

    public String getSchemeName() {
        return "basic";
    }

    public boolean isConnectionBased() {
        return false;
    }

    public BasicScheme(Charset charset) {
        super(charset);
        this.complete = false;
    }

    @Deprecated
    public BasicScheme(ChallengeState challengeState) {
        super(challengeState);
    }

    public BasicScheme() {
        this(Consts.ASCII);
    }

    public void processChallenge(Header header) throws MalformedChallengeException {
        super.processChallenge(header);
        this.complete = true;
    }

    public boolean isComplete() {
        return this.complete;
    }

    @Deprecated
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        return authenticate(credentials, httpRequest, (HttpContext) new BasicHttpContext());
    }

    public Header authenticate(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        Args.notNull(credentials, "Credentials");
        Args.notNull(httpRequest, "HTTP request");
        StringBuilder sb = new StringBuilder();
        sb.append(credentials.getUserPrincipal().getName());
        sb.append(":");
        sb.append(credentials.getPassword() == null ? "null" : credentials.getPassword());
        byte[] encode = Base64.encode(EncodingUtils.getBytes(sb.toString(), getCredentialsCharset(httpRequest)), 2);
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
        if (isProxy()) {
            charArrayBuffer.append("Proxy-Authorization");
        } else {
            charArrayBuffer.append("Authorization");
        }
        charArrayBuffer.append(": Basic ");
        charArrayBuffer.append(encode, 0, encode.length);
        return new BufferedHeader(charArrayBuffer);
    }

    @Deprecated
    public static Header authenticate(Credentials credentials, String str, boolean z) {
        Args.notNull(credentials, "Credentials");
        Args.notNull(str, "charset");
        StringBuilder sb = new StringBuilder();
        sb.append(credentials.getUserPrincipal().getName());
        sb.append(":");
        sb.append(credentials.getPassword() == null ? "null" : credentials.getPassword());
        byte[] encode = Base64.encode(EncodingUtils.getBytes(sb.toString(), str), 2);
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
        if (z) {
            charArrayBuffer.append("Proxy-Authorization");
        } else {
            charArrayBuffer.append("Authorization");
        }
        charArrayBuffer.append(": Basic ");
        charArrayBuffer.append(encode, 0, encode.length);
        return new BufferedHeader(charArrayBuffer);
    }
}
