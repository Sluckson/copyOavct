package p052cz.msebera.android.httpclient.impl.auth;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p052cz.msebera.android.httpclient.Consts;
import p052cz.msebera.android.httpclient.HeaderElement;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.auth.ChallengeState;
import p052cz.msebera.android.httpclient.auth.MalformedChallengeException;
import p052cz.msebera.android.httpclient.auth.params.AuthPNames;
import p052cz.msebera.android.httpclient.message.BasicHeaderValueParser;
import p052cz.msebera.android.httpclient.message.ParserCursor;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.auth.RFC2617Scheme */
public abstract class RFC2617Scheme extends AuthSchemeBase {
    private final Charset credentialsCharset;
    private final Map<String, String> params;

    @Deprecated
    public RFC2617Scheme(ChallengeState challengeState) {
        super(challengeState);
        this.params = new HashMap();
        this.credentialsCharset = Consts.ASCII;
    }

    public RFC2617Scheme(Charset charset) {
        this.params = new HashMap();
        this.credentialsCharset = charset == null ? Consts.ASCII : charset;
    }

    public RFC2617Scheme() {
        this(Consts.ASCII);
    }

    public Charset getCredentialsCharset() {
        return this.credentialsCharset;
    }

    /* access modifiers changed from: package-private */
    public String getCredentialsCharset(HttpRequest httpRequest) {
        String str = (String) httpRequest.getParams().getParameter(AuthPNames.CREDENTIAL_CHARSET);
        return str == null ? getCredentialsCharset().name() : str;
    }

    /* access modifiers changed from: protected */
    public void parseChallenge(CharArrayBuffer charArrayBuffer, int i, int i2) throws MalformedChallengeException {
        HeaderElement[] parseElements = BasicHeaderValueParser.INSTANCE.parseElements(charArrayBuffer, new ParserCursor(i, charArrayBuffer.length()));
        if (parseElements.length != 0) {
            this.params.clear();
            for (HeaderElement headerElement : parseElements) {
                this.params.put(headerElement.getName().toLowerCase(Locale.ENGLISH), headerElement.getValue());
            }
            return;
        }
        throw new MalformedChallengeException("Authentication challenge is empty");
    }

    /* access modifiers changed from: protected */
    public Map<String, String> getParameters() {
        return this.params;
    }

    public String getParameter(String str) {
        if (str == null) {
            return null;
        }
        return this.params.get(str.toLowerCase(Locale.ENGLISH));
    }

    public String getRealm() {
        return getParameter("realm");
    }
}
